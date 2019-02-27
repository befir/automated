package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.utils.Browser;
import common.utils.ContentType;
import common.utils.JsonAssert;
import common.utils.RequestMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class RestfulAutomatedTest {
    protected boolean driverQuite = true;

    private ServiceCase serviceCase;
    public RestfulAutomatedTest(ServiceCase serviceCase){
        this.serviceCase = serviceCase;
    }
    @Test(dataProvider = "getServiceUrl")
    public void callService(String serviceUrl,String input,ServiceCase serviceCase) throws Exception {
        System.out.println(serviceCase.getServiceUrl());
        System.out.println("-------------input:"+input+"-----");
        System.out.println("------expectOutput:"+serviceCase.getExpectOutput()+"-----");
        Object o = browser.execute(RequestMethod.valueOf(serviceCase.getRequestMethod().toUpperCase()), ContentType.valueOf(serviceCase.getContentType().toUpperCase()),companyId,baseUrl+serviceUrl, JSON.parse(input));
        System.out.println("------------output:"+JSON.toJSON(o)+"------");
        JsonAssert.equals(JSON.toJSON(o),JSON.parse(serviceCase.getExpectOutput()));
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
    @Parameters({"loginUserName","loginPassword"})
    public void login(String userName,String password) throws Exception{
        init();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@ng-model, 'user.username')]")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@ng-model, 'user.password')]")));
        driver.findElement(By.xpath("//input[contains(@ng-model, 'user.username')]")).sendKeys(userName);
        driver.findElement(By.xpath("//input[contains(@ng-model, 'user.password')]")).sendKeys(password);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("label")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class, 'auth-normal')]")));
        action.dragAndDrop(driver.findElement(By.id("label")),driver.findElement(By.xpath("//i[contains(@class, 'auth-normal')]"))).perform();
        Cookie cookie = driver.manage().getCookieNamed(userCookieKey);
        if(cookie==null){
            new Throwable("登录失败");
        }else{
            ut = cookie.getValue();
        }
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-controller,'menuCtrl')]")));
    }

    @AfterSuite
    public void clean() {
        if(driverQuite){
            driver.quit();
        }
    }

    protected static Browser browser;
    protected static String baseUrl;
    protected static WebDriver driver;
    protected static Actions action;
    protected static WebDriverWait driverWait;
    protected static Properties properties = new Properties();
    private static String userCookieKey = "ut";
    protected static String ut;
    protected static String companyId;
    static {
        try {
            properties.load(new InputStreamReader(RestfulAutomatedTest.class.getResourceAsStream("/properties.properties"),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseUrl = properties.getProperty("baseUrl");
    }
    private void init() {
        System.setProperty(properties.getProperty("webDriver"), properties.getProperty("webDriverExe"));
        driver=new ChromeDriver(); //chrome
        browser = new Browser(driver);
        driverWait = new WebDriverWait(driver, Long.parseLong(properties.getProperty("timeOut")));
        driver.manage().window().maximize();
        action = new Actions(driver);
        driver.get(properties.getProperty("baseUrl"));
        String domainUrl = "/ouser-web/cloud/domainService/getDomainInfoByAccessDomainUrl";
        JSONObject queryPara = new JSONObject();
        queryPara.put("data",baseUrl.substring("http://".length()));
        Object result = browser.execute(RequestMethod.POST,ContentType.JSON,null,domainUrl,queryPara);
        companyId = JSON.parseObject(JSON.toJSONString(result)).getJSONObject("data").getString("companyId");
    }
}
