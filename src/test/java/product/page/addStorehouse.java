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

public class addStorehouse extends PageAutomatedTest {
    @Test
    public void gotoProductManagePage() throws InterruptedException {
        //切换到商家平台
        switchPlatformTo("商家平台");
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("库存中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心").xpath("//span[text()='仓库管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("库存中心")).findElements(By.xpath("//span[text()='仓库管理']"));
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }

    }
    @Test
    //新增门店仓
    public void addStorehouse() throws InterruptedException {
        gotoProductManagePage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("STOCK_CHANNEL_4frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'add()')]"))).perform();
        JSONObject storeWarehouse = new JSONObject();
        storeWarehouse.put("warehouseCode", dateFormat.format(new Date()));
        storeWarehouse.put("warehouseName", "桂源" + dateFormat.format(new Date()));
//        storeWarehouse.put("warehouseType", 0);

        AngularScope.appendData(driver, "document.querySelector('input[ng-model]')", "storeWarehouse", storeWarehouse);
        Thread.sleep(1000);
        //选择商家
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'storeWarehouse.merchantId')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'storeWarehouse.merchantId')]")).findElements(By.tagName("option")).get(1).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@ng-model,'storeWarehouse.inventoryId')]/option[@label]")));
        //选择库存组织
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'storeWarehouse.inventoryId')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'storeWarehouse.inventoryId')]")).findElements(By.tagName("option")).get(1).click();
        //选择仓库类型
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'storeWarehouse.warehouseType')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'storeWarehouse.warehouseType')]")).findElements(By.tagName("option")).get(2).click();
        //启/禁用
        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'storeWarehouse.isAvailable')]")).get(0)).perform();
        //勾选手工设置库存规则
        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'storeWarehouse.syncRule')]")).get(0)).perform();
        //保存
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'saveWarehouse()')]")).get(0)).perform();
        Thread.sleep(1000);
        //确定提示
        action.click(driver.findElement(By.id("btn_ok"))).perform();
//        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'back()')]")).get(1)).perform();


    }




}
