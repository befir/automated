package product.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class Warehousestock extends PageAutomatedTest {

    @Test
    public void gotoProductManagePage() throws InterruptedException {

        //切换到商家平台
        switchPlatformTo("商家平台");
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("库存中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心").xpath("//span[text()='仓库库存管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("库存中心")).findElements(By.xpath("//span[text()='仓库库存管理']"));
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }

    }
    @Test
    public void queryWarehousestock() throws InterruptedException {
        gotoProductManagePage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("STOCK_CHANNEL_7frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//button[contains(@type,'button')]")).get(3)).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'queryParam.inventoryId')]")).findElements(By.tagName("option")).get(12).click();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryList()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryList()')]"))).perform();




    }



}

