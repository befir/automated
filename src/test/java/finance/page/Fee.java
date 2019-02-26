package finance.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//供应商费用管理
public class Fee extends PageAutomatedTest {

    //财务中心
    @Test
    public void gotoMerchantManagePage3() throws InterruptedException {
        switchThirdMenuTo("全渠道","财务中心","供应商费用管理","供应商费用单");
    }

    //新增费用单
    @Test
    public void apSupplierFeeBilladd() throws InterruptedException {
        gotoMerchantManagePage3();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN151frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN151frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addBill')]"))).perform();
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.id("menufeeBillAddTab")).findElement(By.id("menufeeBillAddTabframe")));
        JSONObject submitFeeBillObj = new JSONObject();
        submitFeeBillObj.put("billName","付款单a");
        submitFeeBillObj.put("billType",1);
        submitFeeBillObj.put("paymentMethod",1);
        submitFeeBillObj.put("feeBillItemDTOs",new Object[]{});
        AngularScope.appendData(driver, "document.querySelector('[ng-controller=apSupplierFeeBillEditController]')", "submitFeeBillObj", submitFeeBillObj);
        Thread.sleep(500);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(500);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(1)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(500);


        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addStoreFee')]"))).perform();
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//input[contains(@ng-click,'openChoseFeeTypeModal')]"))).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openChoseFeeTypeOkEvt')]"))).perform();
        Thread.sleep(500);

        AngularScope.appendData(driver,"document.querySelector('[ng-controller=apSupplierFeeBillEditController]')","submitFeeBillObj.feeBillItemDTOs[0].feeItemAmt",100);
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveFeeBill')]"))).perform();
        Thread.sleep(500);

    }

    //查询 重置费用单
    @Test
    public void apSupplierFeeBillselect() throws InterruptedException {
        gotoMerchantManagePage3();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN151frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN151frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getFeeBills')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset')]"))).perform();
        Thread.sleep(1000);
    }

    //编辑费用单
    @Test
    public void apSupplierFeeBillbianji() throws InterruptedException {
        gotoMerchantManagePage3();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN151frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN151frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'editBill')]"))).perform();
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.id("menufeeBillEditTab1886082104000031")).findElement(By.id("menufeeBillEditTab1886082104000031frame")));
        JSONObject submitFeeBillObj = new JSONObject();
        submitFeeBillObj.put("billName","款单");
        submitFeeBillObj.put("billType",1);
        submitFeeBillObj.put("paymentMethod",2);
        submitFeeBillObj.put("feeBillItemDTOs",new Object[]{});
        AngularScope.appendData(driver,"document.querySelector('[ng-controller=apSupplierFeeBillEditController]')","submitFeeBillObj",submitFeeBillObj);
        Thread.sleep(1000);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(1)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(500);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(1)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(1)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//input[contains(@ng-click,'openChoseFeeTypeModal')]"))).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openChoseFeeTypeOkEvt')]"))).perform();
        Thread.sleep(500);

        AngularScope.appendData(driver,"document.querySelector('[ng-controller=apSupplierFeeBillEditController]')","submitFeeBillObj.feeBillItemDTOs[0].feeItemAmt",100);
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveFeeBill')]"))).perform();
        Thread.sleep(500);

    }

    //删除费用单
    @Test
    public void apSupplierFeeBilldelete() throws InterruptedException {
        gotoMerchantManagePage3();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN151frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN151frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'removeFeeBill')]"))).perform();
        Thread.sleep(400);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
        Thread.sleep(400);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
        Thread.sleep(500);
    }

    //审核费用单
    @Test
    public void audit() throws InterruptedException {
        gotoMerchantManagePage3();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN151frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN151frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(400);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'auditFeeBill')]"))).perform();
        Thread.sleep(500);


    }
}
