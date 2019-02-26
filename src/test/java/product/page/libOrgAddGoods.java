package product.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class libOrgAddGoods extends PageAutomatedTest {
   @Test
    public void gotolibOrgPage() throws InterruptedException {
        //切换到商家平台
        switchPlatformTo("商家平台");
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商品中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心").xpath("//span[text()='商品进目录']")));
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//span[text()='商品进目录']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }

    @Test
    public void addlibOrg() throws InterruptedException {
        gotolibOrgPage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_8frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'add()')]"))).perform();
//        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'queryParams.displayType')]"))).perform();
//        driver.findElement(By.xpath("//select[contains(@ng-model,'queryParams.displayType')]")).findElements(By.tagName("option")).get(0).click();
        action.click(driver.findElement(By.xpath("//input[contains(@type,'radio')]")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'nextStep()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addAllInventoryToList()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).get(2)).perform();
        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveCheckInventoryList()')]"))).perform();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'nextStep()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addAllMerchantProduct()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).get(14)).perform();
        Thread.sleep(2000);
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveCheckMerchantProductList()')]"))).perform();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'nextStep()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'showSetOperationStrategyUpdate(e)')]"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'updateStrategyData.turnoverChannel')]")).sendKeys("配送");
        driver.findElement(By.xpath("//select[contains(@ng-model,'strategyStatusParam')]")).sendKeys("正常经营");
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveOperationStrategyUpdatePage()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'nextStep()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'doSuccess()')]"))).perform();
        Thread.sleep(1000);

    }


}
