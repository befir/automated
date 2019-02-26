package opms.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class AddPurchaser extends PageAutomatedTest {

    @Test
    public void gotoPurchaserListPage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("采购中心")));
        Thread.sleep(5000);
        driver.findElement(By.linkText("采购中心")).click();
        driver.findElement(By.linkText("采配设置")).click();
        List<WebElement> elements=driver.findElement(By.linkText("采购中心")).findElements(By.xpath("//li[contains(@definedattr,'/opms-web/#/purchaserList')]"));
       // driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("采购中心").xpath("//span[text()='供应商管理']")));
       // List<WebElement> elements = driver.findElement(By.linkText("采购中心")).findElements(By.xpath("//span[text()='供应商管理']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }



    @Test
    public void addPurchaser() throws InterruptedException {
        gotoPurchaserListPage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("CP10401frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'create')]"))).perform();
      //  driver.switchTo().parentFrame();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'editModal')]")));
       driver.findElement(By.xpath("//input[contains(@ng-model,'data.purchaserName')]")).sendKeys("采购员多多");
        driver.findElement(By.xpath("//input[contains(@ng-model,'data.userName')]")).sendKeys("444");
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'save()')]"))).perform();
        Thread.sleep(1000);


    }
}
