package merchant.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class AccountUnitManage extends PageAutomatedTest {

    @Test
    public void gotoAccountUnitManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商家中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心").xpath("//span[text()='商家管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("商家中心")).findElements(By.xpath("//span[text()='核算组织']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //
    @Test
    public void addAccountUnit() throws InterruptedException {
        gotoAccountUnitManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300816frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addAccountUnitInfoModalShow')]"))).perform();
        JSONObject accountUnitAddParam = new JSONObject();
        accountUnitAddParam.put("unitCode",dateFormat.format(new Date()));
        accountUnitAddParam.put("unitName","文心阁核算组织"+dateFormat.format(new Date()));
        accountUnitAddParam.put("unitDesc", "核算组织描述" + dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('addAccountUnitModal')","accountUnitAddParam",accountUnitAddParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-if,'modalType==1')]"))).perform();
        Thread.sleep(1000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }
    @Test
    public void editAccountUnit() throws InterruptedException {
        gotoAccountUnitManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300816frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"merchantTable\"]/tbody/tr[1]/td[1]/button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'editAccountModalShow(unit)')]"))).perform();
        JSONObject accountUnitAddParam = new JSONObject();
        accountUnitAddParam.put("unitName","文心阁核算"+dateFormat.format(new Date()));
        accountUnitAddParam.put("unitDesc", "核算描述" + dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('addAccountUnitModal')","accountUnitAddParam",accountUnitAddParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addAccountUnitInfo()')]"))).perform();
        Thread.sleep(1000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }
    //查询核算组织
    @Test
    public void getAccountUnit() throws InterruptedException {
        gotoAccountUnitManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300816frame")));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);

        JSONObject accountUnitParam = new JSONObject();
        accountUnitParam.put("unitName","欧电云");
        AngularScope.appendData(driver,"document.getElementsByClassName('wrapper-md ng-scope')","accountUnitParam",accountUnitParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getAllAccountUnitInfo()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getAllAccountUnitInfo()')]"))).perform();
        Thread.sleep(1000);
    }
}
