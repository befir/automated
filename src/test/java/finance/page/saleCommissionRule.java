package finance.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//
public class saleCommissionRule extends PageAutomatedTest {

    //财务中心
    @Test
    public void gotoMerchantManagePage3() throws InterruptedException {
        switchThirdMenuTo("全渠道","财务中心","财务设置","销售提成规则设置");
    }

    //新增销售提成规则
    @Test(dependsOnMethods = {"gotoMerchantManagePage3"})
    public void apSupplierFeeBilladd() throws InterruptedException {
//       gotoMerchantManagePage3();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN10190frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN10190frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'create')]"))).perform();
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.id("menucreateSaleCommissionRule")).findElement(By.id("menucreateSaleCommissionRuleframe")));

        AngularScope.appendData(driver, "document.querySelector('input')", "suplierPayments.ruleName", "规则设置单b");
        AngularScope.appendData(driver,"document.querySelector('input')","suplierPayments.commissionType",1);
        AngularScope.appendData(driver,"document.querySelector('input')","suplierPayments.mpScopeType",1);
        AngularScope.appendData(driver,"document.querySelector('input')","suplierPayments.commissionAmtType",1);
        AngularScope.appendData(driver,"document.querySelector('input')","suplierPayments.effectiveDate","2018-10-10");
        AngularScope.appendData(driver,"document.querySelector('input')","suplierPayments.saleCommissionType",2);
        AngularScope.appendData(driver,"document.querySelector('input')","suplierPayments.triggerConditionIn",2);
        Thread.sleep(500);

        JSONObject saleCommissionTypeRules = new JSONObject();
        saleCommissionTypeRules.put("commissionPercent", "10");
        saleCommissionTypeRules.put("singleAmount", "100");
        Thread.sleep(500);
        AngularScope.appendData(driver, "document.querySelector('input')", "saleCommissionTypeRules[0]", saleCommissionTypeRules);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'save')]"))).perform();
        Thread.sleep(1000);
    }

    //查询销售提成规则
    @Test(dependsOnMethods = {"apSupplierFeeBilladd"})
    public void apSupplierFeeBillselect() throws InterruptedException {
//        gotoMerchantManagePage3();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN10190frame")));
//       driver.switchTo().frame(driver.findElement(By.id("FIN10190frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryList')]"))).perform();
        Thread.sleep(500);
    }

    //重置销售提成规则
    @Test(dependsOnMethods = {"apSupplierFeeBillselect"})
    public void apSupplierFeeBillreset() throws InterruptedException {
//        gotoMerchantManagePage3();
//        Actions action = new Actions(driver);
//       driver.switchTo().frame(driver.findElement(By.id("FIN10190frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset')]"))).perform();
        Thread.sleep(500);
    }

    //审核销售提成规则
    @Test(dependsOnMethods = {"apSupplierFeeBillreset"})
    public void apSupplierFeeBillaudit() throws InterruptedException {
//        gotoMerchantManagePage3();
//        Actions action = new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("FIN10190frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'aditPass')]")).get(0)).perform();
        Thread.sleep(500);
    }

//    //新增销售提成规则
//    @Test(dependsOnMethods = {"apSupplierFeeBillaudit"})
//    public void apSupplierFeeBilladd2() throws InterruptedException {
//        gotoMerchantManagePage3();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("FIN10190frame")));
//        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
//        Thread.sleep(500);
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'create')]"))).perform();
//        Thread.sleep(500);
//        driver.switchTo().parentFrame();
//        driver.switchTo().frame(driver.findElement(By.id("menucreateSaleCommissionRule")).findElement(By.id("menucreateSaleCommissionRuleframe")));
//
//        AngularScope.setData(driver,"document.querySelector('input')","suplierPayments.ruleName","规则设置单b");
//        AngularScope.setData(driver,"document.querySelector('input')","suplierPayments.commissionType",1);
//        AngularScope.setData(driver,"document.querySelector('input')","suplierPayments.mpScopeType",1);
//        AngularScope.setData(driver,"document.querySelector('input')","suplierPayments.commissionAmtType",1);
//        AngularScope.setData(driver,"document.querySelector('input')","suplierPayments.effectiveDate","2018-10-10");
//        AngularScope.setData(driver,"document.querySelector('input')","suplierPayments.saleCommissionType",2);
//        AngularScope.setData(driver,"document.querySelector('input')","suplierPayments.triggerConditionIn",2);
//        Thread.sleep(500);
//
//        JSONObject saleCommissionTypeRules = new JSONObject();
//        saleCommissionTypeRules.put("commissionPercent", "10");
//        saleCommissionTypeRules.put("singleAmount", "100");
//        Thread.sleep(500);
//        AngularScope.setData(driver, "document.querySelector('input')", "saleCommissionTypeRules[0]", saleCommissionTypeRules);
//
//        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
//        Thread.sleep(500);
//        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
//        Thread.sleep(500);
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
//        Thread.sleep(500);
//
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'save')]"))).perform();
//    }

    //删除销售提成规则
    @Test(dependsOnMethods = {"apSupplierFeeBillaudit"})
    public void apSupplierFeeBilldelete() throws InterruptedException {
//        gotoMerchantManagePage3();
//        Actions action = new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("FIN10190frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'delete')]"))).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'close')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'close')]")).get(0)).perform();
        Thread.sleep(500);
    }
}

