package merchant.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class FlagManage extends PageAutomatedTest {

    @Test
    public void gotoFlagManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商家中心")).click();
        driver.findElement(By.linkText("设置")).click();
        List<WebElement> elements=driver.findElement(By.linkText("商家中心")).findElements(By.xpath("//li[contains(@definedattr,'/back-merchant-web/index.html#/merchantFlagList')]"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增店铺标签
    @Test
    public void addFlag() throws InterruptedException {
        gotoFlagManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300817frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openModal()')]"))).perform();
        JSONObject pageObj = new JSONObject();
        pageObj.put("name","店铺标签"+dateFormat.format(new Date()));
        pageObj.put("url","https://cdn.oudianyun.com/trunk/back-merchant-web/1540698208421_29.943133850477576_05cc56d2-9a8f-4fc9-8780-f38fd0c71423.jpg");
        pageObj.put("description", "店铺标签描述" + dateFormat.format(new Date()));
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'pageObj.isMonopolistic')]")));
        AngularScope.appendData(driver,"document.getElementsByClassName('modal fade ng-isolate-scope in')","pageObj",pageObj);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveFlag()')]"))).perform();
        Thread.sleep(1000);
    }
    //编辑店铺标签
    @Test
    public void editFlag() throws InterruptedException {
        gotoFlagManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300817frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openModal(record)')]"))).perform();
        JSONObject pageObj = new JSONObject();
        pageObj.put("name","标签"+dateFormat.format(new Date()));
        pageObj.put("url","https://cdn.oudianyun.com/trunk/back-merchant-web/1540698208421_29.943133850477576_05cc56d2-9a8f-4fc9-8780-f38fd0c71423.jpg");
        pageObj.put("description", "标签描述" + dateFormat.format(new Date()));
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'pageObj.isMonopolistic')]")));
        AngularScope.appendData(driver,"document.getElementsByClassName('modal fade ng-isolate-scope in')","pageObj",pageObj);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveFlag()')]"))).perform();
        Thread.sleep(1000);
    }
    //查询店铺标签
    @Test
    public void getFlag() throws InterruptedException {
        gotoFlagManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300817frame")));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);

        JSONObject params = new JSONObject();
        params.put("name","店铺");
        AngularScope.appendData(driver,"document.getElementsByClassName('wrapper-md ng-scope')","params",params);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getData()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getData()')]"))).perform();
        Thread.sleep(1000);
    }
}
