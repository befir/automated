package product.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class inventoryMapping extends PageAutomatedTest {
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
    public void addInventoryOrg() throws InterruptedException {
        gotoProductManagePage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("STOCK_CHANNEL_4frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'editMapping(e)')]")).get(9)).perform();
        Thread.sleep(1000);
        //新增
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'addMapping()')]")).get(0)).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.virtualWarehouseId')]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.virtualWarehouseId')]")).findElements(By.tagName("option")).get(6).click();

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.assignType')]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.assignType')]")).findElements(By.tagName("option")).get(1).click();


        driver.findElement(By.xpath("//input[contains(@ng-model,'mappingParam.assignValue')]")).sendKeys("90");
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'addMapping()')]")).get(1)).perform();
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveMappings()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.id("btn_ok"))).perform();

    }


}
