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

public class calculationManage  extends PageAutomatedTest {
    @Test
    public void gotocalculationManagePage() throws InterruptedException {
        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(5000);
        driver.findElement(By.linkText("商品中心")).click();
        driver.findElement(By.linkText("商品设置")).click();
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//li[contains(@definedattr,'/back-web/app/default/product2/index.html#/calculationManage')]"));
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
    public void addcalculation() throws InterruptedException {
        gotocalculationManagePage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_1_4frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openAdd')]"))).perform();
        JSONObject calculationUnitForUpdate = new JSONObject();
        calculationUnitForUpdate.put("calculationUnitCode", dateFormat.format(new Date()));
        calculationUnitForUpdate.put("calculationUnitName", "测试" + dateFormat.format(new Date()));
        AngularScope.appendData(driver, "document.querySelector('[ng-model=\"calculationUnitForUpdate.calculationUnitName\"]')", "calculationUnitForUpdate", calculationUnitForUpdate);

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'calculationUnitForUpdate.decimalDigits')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'calculationUnitForUpdate.decimalDigits')]")).findElements(By.tagName("option")).get(3).click();
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'calculationUnitForUpdate.isAvailable')]")));//启用状态
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveCalculationInfo()')]"))).perform();
        System.out.println(JSON.toJSONString(AngularScope.getData(driver, "document.querySelector('[ng-model=\"calculationUnitForUpdate.calculationUnitName\"]')", "Params")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(500);


    }
    }
