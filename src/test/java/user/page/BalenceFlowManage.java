package user.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class BalenceFlowManage extends PageAutomatedTest {

    @Test
    public void gotoBasicConfigManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("会员中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("会员中心")).click();
        driver.findElement(By.linkText("成长值管理")).click();
        List<WebElement> elements=driver.findElement(By.linkText("会员中心")).findElements(By.xpath("//li[contains(@definedattr,'/ouser-center/index.html#/balenceFlowList')]"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //查看成长值流水
    @Test(dependsOnMethods = {"gotoBasicConfigManagePage"})
    public void addBasicConfig() throws InterruptedException {
        gotoBasicConfigManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("309201frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'viewInfo(e)')]")).get(0)).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'back()')]"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@ng-model,'queryPointsFlow.balanceBegin')]")).sendKeys("5");
        driver.findElement(By.xpath("//input[contains(@ng-model,'queryPointsFlow.balanceEnd')]")).sendKeys("500");
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryBalenceFlowAll()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryBalenceFlowAll()')]"))).perform();
        Thread.sleep(1000);
    }
}
