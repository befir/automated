package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class PageAutomatedTest {
    protected boolean driverQuite = true;
    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait driverWait;
    protected static Properties properties = new Properties();
    private static String userCookieKey = "ut";
    protected static String ut;

    protected DateFormat dateFormat =  new SimpleDateFormat("yyyyMMddHHmmss");
    protected DateFormat dateFormat2 =  new SimpleDateFormat("yyyy-MM-dd");

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

    protected WebElement switchFirstMenuTo(String channelName, String firstMenuName){
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText(channelName)));
        action.click(driver.findElement(By.linkText(channelName))).perform();
        showFirstMenuName(firstMenuName);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText(firstMenuName)));
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.click(driver.findElement(By.linkText(firstMenuName))).perform();
        return driver.findElement(By.linkText(firstMenuName));
    }
    private void showFirstMenuName(String firstMenuName){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+firstMenuName+"']")));
        while(true){
            if(driver.findElement(By.xpath("//a[text()='"+firstMenuName+"']")).isDisplayed()){
                break;
            }else{
                action.click(driver.findElement(By.xpath("//span[contains(@ng-click,'secondRightMove')]"))).perform();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    protected WebElement switchSecondMenuTo(String channelName,String firstMenuName,String secondMenuName){
        switchFirstMenuTo(channelName,firstMenuName);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(firstMenuName).xpath("//a[@class='auto newAuto ng-scope']/span[text()='"+secondMenuName+"']")));
        List<WebElement> elements = driver.findElement(By.linkText(firstMenuName)).findElements(By.xpath("//a[@class='auto newAuto ng-scope']/span[text()='"+secondMenuName+"']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                action.click(element).perform();
                return element;
            }
        }
        return null;
    }
    protected WebElement switchThirdMenuTo(String channelName,String firstMenuName,String secondMenuName,String thirdMenuName){
//        switchSecondMenuTo(channelName,firstMenuName,secondMenuName);
        List<WebElement> elements = switchSecondMenuTo(channelName,firstMenuName,secondMenuName).findElements(By.xpath("//li[@class='ng-scope']/a[@class='paddL-mini']/span[text()='"+thirdMenuName+"']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                action.click(element).perform();
                return element;
            }
        }
        return null;
    }
    protected void closeTab(String tabName){
        action.click(driver.findElement(By.xpath("//li[@class='active-tab']/label[text()='"+tabName+"']/../span"))).perform();
    }
    @BeforeSuite
    public static void init() throws Exception {
        properties.load(new InputStreamReader(PageAutomatedTest.class.getResourceAsStream("/properties.properties"),"UTF-8"));
        System.setProperty(properties.getProperty("webDriver"), properties.getProperty("webDriverExe"));
    }
    @BeforeClass
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
    @AfterMethod
    public void gotoMainWindow(){
        String mainWinStr = "";
        Set<String> windows = driver.getWindowHandles();
        String mainWindowTitle = properties.getProperty("mainWindowTitle");
        for(String s:windows){
            if(driver.switchTo().window(s).getTitle().equals(mainWindowTitle)){
                mainWinStr = s;
            }else{
                driver.close();
            }
        }
        driver.switchTo().window(mainWinStr);
    }

    @AfterClass
    public void clean() {
        if(driverQuite){
            driver.quit();
        }
    }
}
