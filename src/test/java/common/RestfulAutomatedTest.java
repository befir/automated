package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.utils.Browser;
import common.utils.ContentType;
import common.utils.JsonAssert;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.testng.annotations.*;

import java.io.InputStreamReader;
import java.util.Properties;

public class RestfulAutomatedTest {
    protected static Browser browser;
    protected static Properties properties = new Properties();

    private ServiceCase serviceCase;
    public RestfulAutomatedTest(ServiceCase serviceCase){
        this.serviceCase = serviceCase;
    }
    @Test(dataProvider = "getServiceUrl")
    public void callService(String serviceUrl,String input,ServiceCase serviceCase) throws Exception {
        System.out.println(serviceCase.getServiceUrl());
        System.out.println("-------------input:"+input+"-----");
        System.out.println("------expectOutput:"+serviceCase.getExpectOutput()+"-----");
        try{
            Connection.Response response = browser.execute(serviceCase.getRequestMethod().toUpperCase(), ContentType.valueOf(serviceCase.getContentType().toUpperCase()),properties.getProperty(serviceCase.getBaseUrl())+serviceUrl, JSON.parseObject(input));
            if(response.statusCode()!=200){
                throw new Exception("服务异常,异常码:"+response.statusCode());
            }else{
                System.out.println("------------output:"+response.body()+"------");
                JsonAssert.equals(JSON.parse(response.body()),JSON.parse(serviceCase.getExpectOutput()));
            }
        }catch (HttpStatusException exception){
            throw new Exception("服务异常,异常码:" + exception.getStatusCode());
        }

    }

    @Factory
    @Parameters("caseFile")
    public static Object[] createTest(String caseFile) throws Exception {
        return ServiceTestFactory.generate(ServiceTestFactory.loadCaseFromExcel(caseFile));
    }
    @DataProvider
    public Object[][] getServiceUrl() throws Exception {
        return new Object[][] {{serviceCase.getServiceUrl(),serviceCase.getInput(),serviceCase}};
    }

    @BeforeSuite
    @Parameters({"domain","loginUserName","loginPassword"})
    public void init(String domain,String loginUserName,String loginPassword) throws Exception{
        browser = new Browser();
        properties.load(new InputStreamReader(RestfulAutomatedTest.class.getResourceAsStream("/properties.properties"),"UTF-8"));
        String baseUrl = properties.getProperty("baseUrl");
        String domainService = "/ouser-web/cloud/domainService/getDomainInfoByAccessDomainUrl";
        JSONObject domainPara = new JSONObject();
        domainPara.put("data",baseUrl.substring("http://".length()));
        Connection.Response response = browser.execute("post",ContentType.JSON,baseUrl+domainService,domainPara);
        String companyId = JSON.parseObject(response.body()).getJSONObject("data").getString("companyId");
        System.out.println("companyId:"+companyId);

        String domainUrl = properties.getProperty(domain);
        String loginService = "/ouser-web/mobileLogin/login.do";
        JSONObject loginPara = new JSONObject();
        loginPara.put("username",loginUserName);
        loginPara.put("password",loginPassword);
        response = browser.execute("post",ContentType.JSON,domainUrl+loginService,loginPara);

        String ut = response.cookie("ut");
        System.out.println("ut:"+ut);
        browser.setCompanyId(companyId);
        browser.setUt(ut);
    }
}
