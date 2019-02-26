package product.page;

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

public class addsuperscriptManage extends PageAutomatedTest {

    @Test
    public void gotosuperscriptpage() throws InterruptedException {
        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商品中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心").xpath("//span[text()='商品标签(角标)']")));
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//span[text()='商品标签(角标)']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    @Test
    public void addsuperscript() throws InterruptedException {
        gotosuperscriptpage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_3frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'add()')]"))).perform();
        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'queryParams.displayType')]"))).perform();
//        driver.findElement(By.xpath("//select[contains(@ng-model,'queryParams.displayType')]")).findElements(By.tagName("option")).get(0).click();
        JSONObject queryParams = new JSONObject();
        queryParams.put("name","测试"+dateFormat.format(new Date()));
        queryParams.put("code",dateFormat.format(new Date()));
        queryParams.put("displayType","主图左上");
        Thread.sleep(1000);
        queryParams.put("priority",12);
        AngularScope.appendData(driver, "document.querySelector('input[ng-model]')", "queryParams", queryParams);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'queryParams.displayType')]")).sendKeys("主图左上");
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'save()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.className("form-group")).findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'batchAddMp()')]"))).perform();
        Thread.sleep(1000);
//        action.click(driver.findElements (By.xpath("//input[contains(@type,'checkbox')]")).get(0)).perform();
        action.click(driver.findElements (By.xpath("//input[contains(@type,'checkbox')]")).get(1)).perform();

//        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'e.checked')]")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addAggreationMp()')]"))).perform();
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'back()')]"))).perform();


    }



}
