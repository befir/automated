package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.utils.Browser;
import common.utils.ContentType;
import common.utils.JsonAssert;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.testng.annotations.*;

import java.io.InputStreamReader;
import java.util.Properties;

public class RestfulAutomatedTest {
    private static JSONObject paramAlias = new JSONObject();
    protected static Browser browser;
    protected static Properties properties = new Properties();

    private ServiceCase serviceCase;
    public RestfulAutomatedTest(ServiceCase serviceCase){
        this.serviceCase = serviceCase;
    }
    @Test(dataProvider = "getServiceUrl")
    public void callService(String serviceUrl,String inputStr,ServiceCase serviceCase) throws Exception {
        System.out.println(serviceCase.getServiceUrl());
        System.out.println("-------------input:"+inputStr+"-----");
        System.out.println("------expectOutput:"+serviceCase.getExpectOutput()+"-----");
        try{
            Connection.Response response = browser.execute(serviceCase.getRequestMethod().toUpperCase(), ContentType.valueOf(serviceCase.getContentType().toUpperCase()),properties.getProperty(serviceCase.getBaseUrl())+serviceUrl,JSON.parseObject(inputStr));
            if(response.statusCode()!=200){
                throw new Exception("服务异常,异常码:"+response.statusCode());
            }else{
                String body = response.body();
                Object output;

                System.out.println("------------output:"+body+"------");
                if(body.startsWith("[")){
                    output = JSON.parseArray(body);
                }else{
                    output = JSON.parseObject(body);
                }
                if(StringUtils.isNotBlank(serviceCase.getParamAlias())){
                    JSONObject alias = JSON.parseObject(serviceCase.getParamAlias());
                    outputAlias(output,alias);
                    System.out.println("--------paramAlias:"+paramAlias.toJSONString());
                }
                JsonAssert.equals(output,JSON.parse(serviceCase.getExpectOutput()));
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
        serviceCase.setInput(inputAlias(serviceCase.getInput()));
        return new Object[][] {{serviceCase.getServiceUrl(),serviceCase.getInput(),serviceCase}};
    }

    @BeforeSuite
    @Parameters({"domain","loginUserName","loginPassword"})
    public void init(String domain,String loginUserName,String loginPassword) throws Exception{
        browser = new Browser();
        properties.load(new InputStreamReader(RestfulAutomatedTest.class.getResourceAsStream("/properties.properties"),"UTF-8"));
        Connection.Response response;
        String companyId = properties.getProperty("COMPANY_ID");
        String domainUrl = properties.getProperty(domain);
        if(StringUtils.isBlank(companyId)){
            String domainService = properties.getProperty("DOMAIN_SERVICE");
            JSONObject domainPara = new JSONObject();
            domainPara.put("data",domainUrl.substring("http://".length()));
            response = browser.execute("post",ContentType.JSON,domainService,domainPara);
            System.out.println(response.body());
            companyId = JSON.parseObject(response.body()).getJSONObject("data").getString("companyId");
        }
        System.out.println("companyId:"+companyId);
        String loginService = properties.getProperty(domain.replaceAll("_URL","_LOGIN_URL"));
        JSONObject loginPara = new JSONObject();
        loginPara.put("username",loginUserName);
        loginPara.put("password",loginPassword);
        String loginParam = properties.getProperty(domain.replaceAll("_URL","_LOGIN_PARAM"));
        if(StringUtils.isNotBlank(loginParam)){
            loginPara.putAll(JSON.parseObject(loginParam));
        }
        response = browser.execute("post",ContentType.JSON,domainUrl+loginService,loginPara);

        String ut = response.cookie("ut");
        System.out.println("ut:"+ut);
        browser.setCompanyId(companyId);
        browser.setUt(ut);
    }
    private String inputAlias(String inputStr){
        if(inputStr.contains("$")){
            for(String key:paramAlias.keySet()){
                inputStr = inputStr.replaceAll("[$]"+key,paramAlias.getString(key));
            }
        }
        return inputStr;
    }
    private void outputAlias(Object output,JSONObject alias){
        String paramKey;
        for(String aliasKey:alias.keySet()){
            paramKey = alias.getString(aliasKey);
            String[] paras = paramKey.split("\\.");
            Object data = output;
            for(String key:paras){
                if(key.toLowerCase().startsWith("list")){
                    data = ((JSONArray)data).get(Integer.parseInt(key.substring(key.toLowerCase().indexOf("list(")+5,key.toLowerCase().indexOf(")"))));
                }else if(key.startsWith("$")){
                    data = ((JSONObject)data).get(key.replaceAll("\\$",""));
                }
            }
            paramAlias.put(aliasKey,data);
        }
    }
}
