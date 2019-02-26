package product.page;

import com.alibaba.fastjson.JSON;
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


public class addModal extends PageAutomatedTest {
    @Test
    public void gotoModalPage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(5000);
        driver.findElement(By.linkText("商品中心")).click();
        driver.findElement(By.linkText("商品设置")).click();
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//li[contains(@definedattr,'/back-web/app/default/product2/index.html#/businessStatusSettingManage')]"));
        // driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("采购中心").xpath("//span[text()='供应商管理']")));
        // List<WebElement> elements = driver.findElement(By.linkText("采购中心")).findElements(By.xpath("//span[text()='供应商管理']"));
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }
    }
    //
    @Test
    public void addModal() throws InterruptedException {
        gotoModalPage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_1_5frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
//        System.out.println(JSON.toJSONString( AngularScope.getData(driver, "document.querySelector('[ng-model=\"Params.opStatusName\"]')", "Params")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addModal')]"))).perform();
        JSONObject Params = new JSONObject();
        Params.put("opStatusCode",dateFormat.format(new Date()));
        Params.put("opStatusName","测试"+dateFormat.format(new Date()));
//        AngularScope.setData(driver,"document.querySelector('input[ng-model]')","Params",Params);
        AngularScope.appendData(driver, "document.querySelector('[ng-model=\"Params.opStatusName\"]')", "Params", Params);
//        System.out.println(JSON.toJSONString( AngularScope.getData(driver, "document.querySelector('[ng-model=\"Params.opStatusName\"]')", "Params")));
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[contains(@ng-model,'Params.opStatusCode')]")).sendKeys("123");
//        driver.findElement(By.xpath("//input[contains(@ng-model,'Params.opStatusName')]")).sendKeys("测试");
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'Params.allowedPurchases')]")));//允许采购
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'Params.allowedSale')]")));//允许销售
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'Params.allowedDistribution')]")));//允许配送
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'Params.allowedPurchasesReturn')]")));//允许采退
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'Params.allowedSaleReturn')]")));//允许销退
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'Params.allowedBuyGoods')]"))).perform();//允许进货
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'ok()')]"))).perform();
        System.out.println(JSON.toJSONString( AngularScope.getData(driver, "document.querySelector('[ng-model=\"Params.opStatusName\"]')", "Params")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(500);


    }
}
