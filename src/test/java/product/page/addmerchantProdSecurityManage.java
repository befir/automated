package product.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class addmerchantProdSecurityManage extends PageAutomatedTest {
//
    @Test
    public void gotoProductManagePage() throws InterruptedException {
        //切换到商家平台
        switchPlatformTo("商家平台");
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商品中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心").xpath("//span[text()='商品保障']")));
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//span[text()='商品保障']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }


    @Test
    public void addmerchantProdSecurityManage() throws InterruptedException {
        gotoProductManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_14frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'add()')]"))).perform();
        Thread.sleep(1000);
        JSONObject merchantProdSecurityVo = new JSONObject();
        merchantProdSecurityVo.put("title","概不包邮2");
        AngularScope.appendData(driver, "document.querySelector('input[ng-model]')", "merchantProdSecurityVo", merchantProdSecurityVo);
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'merchantProdSecurityVo.merchantId')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'merchantProdSecurityVo.merchantId')]")).findElements(By.tagName("option")).get(2).click();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveMerchantProdSecurity()')]"))).perform();
        Thread.sleep(1000);
         action.click(driver.findElement(By.className("form-group")).findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();

//        action.click(driver.findElement(By.className("bootstrap-dialog-footer")).findElement(By.xpath("//button[text()='确定']"))).perform();

    }

}











