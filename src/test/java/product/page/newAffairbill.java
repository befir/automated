package product.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class newAffairbill extends PageAutomatedTest {

    @Test
    public void gotoProductManagePage() throws InterruptedException {

            //切换到商家平台
            switchPlatformTo("商家平台");
            driver.findElement(By.linkText("全渠道")).click();
            driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心")));
            Thread.sleep(1000);
            driver.findElement(By.linkText("库存中心")).click();
            driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心").xpath("//span[text()='库内事务单据']")));
            List<WebElement> elements = driver.findElement(By.linkText("库存中心")).findElements(By.xpath("//span[text()='库内事务单据']"));
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    element.click();
                    break;
                }
            }

        }
        @Test
    public void addInventorybill() throws InterruptedException {
        gotoProductManagePage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("STOCK_CHANNEL_6frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//button[contains(@type,'button')]")).get(3)).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//a[contains(@ng-click,'createOrtherInOut()')]"))).perform();
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'imInventoryAdjustmentBill.targetInventoryId')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'imInventoryAdjustmentBill.targetInventoryId')]")).findElements(By.tagName("option")).get(12).click();
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'imInventoryAdjustmentBill.targetWarehouseId')]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'imInventoryAdjustmentBill.targetWarehouseId')]")).findElements(By.tagName("option")).get(1).click();

        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'imInventoryAdjustmentBill.stockProcessType')]")).get(0)).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'imInventoryAdjustmentBill.subBillType')]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'imInventoryAdjustmentBill.subBillType')]")).findElements(By.tagName("option")).get(1).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[contains(@ng-model,'imInventoryAdjustmentBill.createUsername')]")).sendKeys("Jessie");

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveBillHead()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openMerchantProductModal()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'e.checked')]")).get(0)).perform();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'ok()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[contains(@ng-click,'changeBillStockNum(e)')]"))).perform();

        driver.findElement(By.xpath("//input[contains(@ng-model,'e.billStockNum')]")).sendKeys("0");

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveBillItem()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'confirmBill()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'completeBill()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'back()')]"))).perform();


        }



    }

