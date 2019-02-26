package common;

import org.openqa.selenium.By;
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

public class SoaAutomatedTest {
    protected boolean driverQuite = true;
    protected static String swiftUrl;
    protected static WebDriver driver;
    protected static Actions action;
    protected static WebDriverWait driverWait;
    protected static Properties properties = new Properties();

    protected DateFormat dateFormat =  new SimpleDateFormat("yyyyMMddHHmmss");
    static {
        try {
            properties.load(new InputStreamReader(SoaAutomatedTest.class.getResourceAsStream("/properties.properties"),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        swiftUrl = properties.getProperty("swiftUrl");
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
        driver.get(properties.getProperty("swiftUrl"));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='jobNumber']")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        driver.findElement(By.xpath("//input[@name='jobNumber']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        action.click(driver.findElement(By.xpath("//button[text()='登录']"))).perform();
        String topMenuPath = "//div[@class='main-top-nav-select']/ul[@id='mainMenu']/li[@class='layui-nav-item']/a[text()='服务治理']";
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(topMenuPath)));
        driver.get(properties.getProperty("soaManageUrl"));
        String leftMenuPath = "//div[@class='home-middle-nav']/ul[@class='el-menu-vertical-demo el-menu']/li[@class='el-submenu']//div[@class='el-submenu__title']/span[text()='API治理']";
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(leftMenuPath)));
    }

    @AfterSuite
    public void clean() {
        if(driverQuite){
            driver.quit();
        }
    }
}
