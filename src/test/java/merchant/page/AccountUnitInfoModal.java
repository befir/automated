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

public class AccountUnitInfoModal extends PageAutomatedTest {

// 新增核算组织
    @Test
    public void gotoMerchantManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商家中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心").xpath("//span[text()='核算组织']")));
        List<WebElement> elements = driver.findElement(By.linkText("商家中心")).findElements(By.xpath("//span[text()='核算组织']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }

    @Test
    public void addAccountUnitInfoModalShow() throws InterruptedException {
        gotoMerchantManagePage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300816frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));

        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addAccountUnitInfoModalShow')]"))).perform();
        JSONObject accountUnitAddParam = new JSONObject();
        //merchantAddParam.put("merchantType",11);//没有找到
        accountUnitAddParam.put("unitCode", dateFormat.format(new Date()));
        accountUnitAddParam.put("unitName", "autoTestName" + dateFormat.format(new Date()));
        //setData 新增
        AngularScope.appendData(driver, "document.getElementById('addAccountUnitModal')", "accountUnitAddParam", accountUnitAddParam);

        Thread.sleep(1000);
        // 点击新增按钮  （元素：addAccountUnitInfo()）
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addAccountUnitInfo()')]"))).perform();
        Thread.sleep(1000);

        Alert alt = driver.switchTo().alert();
        alt.accept();

        // 查询新增的核算组织信息
       JSONObject accountUnitParam = new JSONObject();
       accountUnitParam.put("unitCode",accountUnitAddParam.get("unitCode"));
        AngularScope.appendData(driver, "document.getElementById('addAccountUnitModal')","accountUnitParam",accountUnitParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.name("merchantForm")).findElement(By.xpath("//button[contains(@ng-click,'getAllAccountUnitInfo()')]"))).perform();
        Thread.sleep(1000);
        //编辑核算组织信息

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'editAccountModalShow(unit)')]"))).perform();


        accountUnitAddParam = new JSONObject();

        //merchantAddParam.put("merchantType",11);//没有找到
        accountUnitAddParam.put("unitCode", dateFormat.format(new Date()));
        accountUnitAddParam.put("unitName",  "上海欧电云"+dateFormat.format(new Date()));

         //appendData追加
        AngularScope.appendData(driver, "document.getElementById('addAccountUnitModal')","accountUnitAddParam",accountUnitAddParam);

        Thread.sleep(1000);
        action.click(driver.findElement(By.id("addAccountUnitModal")).findElement(By.xpath("//button[contains(@ng-click,'addAccountUnitInfo()')]"))).perform();
        Thread.sleep(1000);

        Alert alt1 = driver.switchTo().alert();
        alt.accept();

        Thread.sleep(1000);
        //重置
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset()')]"))).perform();
        Thread.sleep(1000);

        //查询
        action.click(driver.findElement(By.name("merchantForm")).findElement(By.xpath("//button[contains(@ng-click,'getAllAccountUnitInfo()')]"))).perform();
    }
    @Test
    public void getAllAccountUnitInfoOrg() throws InterruptedException {
        gotoMerchantManagePage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300816frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));

        Thread.sleep(1000);
        JSONObject accountUnitParam = new JSONObject();
        accountUnitParam.put("unitCode","20181016174356");
        AngularScope.appendData(driver, "document.getElementById('addAccountUnitModal')","accountUnitParam",accountUnitParam);

        Thread.sleep(1000);
        action.click(driver.findElement(By.name("merchantForm")).findElement(By.xpath("//button[contains(@ng-click,'getAllAccountUnitInfo()')]"))).perform();



    }}


