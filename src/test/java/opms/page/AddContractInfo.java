package opms.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class AddContractInfo extends PageAutomatedTest {

    @Test
    public void gotoContractInfoPage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("采购中心")));
        Thread.sleep(5000);
        driver.findElement(By.linkText("采购中心")).click();
        driver.findElement(By.linkText("合同管理")).click();
        List<WebElement> elements=driver.findElement(By.linkText("采购中心")).findElements(By.xpath("//li[contains(@definedattr,'/opms-web/#/jxContractList')]"));

        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }



    @Test
    public void AddContractInfo() throws InterruptedException {
        gotoContractInfoPage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("CP10702frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openModalDialog')]"))).perform();
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);


        Thread.sleep(500);


    }
}
