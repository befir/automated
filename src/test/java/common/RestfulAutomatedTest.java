package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class RestfulAutomatedTest {
    protected boolean driverQuite = true;
    protected static String baseUrl;
    protected static WebDriver driver;
    protected static Actions action;
    protected static WebDriverWait driverWait;
    protected static Properties properties = new Properties();
    private static String userCookieKey = "ut";
    protected static String ut;

    protected DateFormat dateFormat =  new SimpleDateFormat("yyyyMMddHHmmss");
    static {
        try {
            properties.load(new InputStreamReader(RestfulAutomatedTest.class.getResourceAsStream("/properties.properties"),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseUrl = properties.getProperty("baseUrl");
    }
    protected void switchPlatformTo(String name){
        String platformNameSpanPath = "//div[contains(@ng-controller,'menuCtrl')]//span[contains(@class,'avatar-second-box')]//span[contains(@class,'operate-platform-text')]";
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(platformNameSpanPath)));
        String platformName = driver.findElement(By.xpath(platformNameSpanPath)).getText();
        if(name!=null && !name.equals(platformName)){
            String platformListItemPath = "//div[contains(@ng-controller,'menuCtrl')]//a[contains(@ng-click,'showPlatformMenu') and contains(text(),'%s')]";
            driver.findElement(By.xpath(platformNameSpanPath)).click();
            driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(platformListItemPath,name))));
            driver.findElement(By.xpath(String.format(platformListItemPath,name))).click();
            String newPlatformSpanPath = "//div[contains(@ng-controller,'menuCtrl')]//span[contains(@class,'avatar-second-box')]//span[contains(@class,'operate-platform-text') and contains(text(),'%s')]";
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(newPlatformSpanPath,name))));
        }
    }

    @BeforeSuite
    public static void init() throws Exception {
        System.setProperty(properties.getProperty("webDriver"), properties.getProperty("webDriverExe"));
    }
    @BeforeSuite
    @Parameters({"loginUserName","loginPassword"})
    public void login(String userName,String password){
        driver=new ChromeDriver(); //chrome
        driverWait = new WebDriverWait(driver, Long.parseLong(properties.getProperty("timeOut")));
        driver.manage().window().maximize();
        action = new Actions(driver);
        driver.get(properties.getProperty("baseUrl"));
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
}
