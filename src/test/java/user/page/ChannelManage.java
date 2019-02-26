package user.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class ChannelManage extends PageAutomatedTest {

    @Test
    public void gotoChannelManageManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商家中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心").xpath("//span[text()='渠道管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("商家中心")).findElements(By.xpath("//span[text()='渠道管理']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //查询渠道
    @Test(dependsOnMethods = {"gotoChannelManageManagePage"})
    public void getChannelManage() throws InterruptedException {
        gotoChannelManageManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300899frame")));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);

        JSONObject channelQueryParams = new JSONObject();
        channelQueryParams.put("channelName","欧电云");
        AngularScope.appendData(driver,"document.getElementsByClassName('wrapper-md ng-scope')","channelQueryParams",channelQueryParams);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryChannelList()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'resetChannelParams()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryChannelList()')]"))).perform();
        Thread.sleep(1000);
    }
}
