package finance.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//供应商发票管理
public class apSupplierInvoice extends PageAutomatedTest {

    //财务中心
    @Test
    public void apSupplierInvoice() throws InterruptedException {
//        driverQuite = false;
        switchThirdMenuTo("全渠道","财务中心","供应商发票管理","供应商发票管理");
    }

    //新增供应商发票管理
    @Test(dependsOnMethods = {"apSupplierInvoice"},description = "新增供应商发票管理")
    public void apSupplierInvoiceadd() throws InterruptedException {
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN132frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN132frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'routeToAdd')]"))).perform();
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.id("menuapSupplierInvoiceAdd")).findElement(By.id("menuapSupplierInvoiceAddframe")));
        JSONObject submitInvoiceObj = new JSONObject();
        submitInvoiceObj.put("invoiceType", 1);
        submitInvoiceObj.put("invoiceTitleType", 1);
        submitInvoiceObj.put("supplierInvoiceDetail", new Object[]{});
        submitInvoiceObj.put("invoiceLeftCode", "1101545455417"+(int)(Math.random()*1000));
        submitInvoiceObj.put("invoiceRightCode", "11544545458");
        submitInvoiceObj.put("invoiceTitleContent", "上海欧电云");
        submitInvoiceObj.put("salerName", "上海欧电");
        submitInvoiceObj.put("salerTaxCode", "9856565656");
        submitInvoiceObj.put("purchaserName", "89421212");
        submitInvoiceObj.put("purchaserTaxCode", "5212121212");

        AngularScope.appendData(driver, "document.querySelector('[ng-controller=apSupplierInvoiceEditController]')", "submitInvoiceObj", submitInvoiceObj);
        Thread.sleep(1000);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(1000);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(1)).perform();
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(1000);

        action.click(driver.findElements(By.xpath("//input[contains(@ng-click,'openModalDialog')]")).get(2)).perform();
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addStoreInvoice')]"))).perform();
        Thread.sleep(1000);


        JSONObject item = new JSONObject();
        item.put("itemName", "货物");
        item.put("itemSpec", "实体");
        item.put("itemUnit", "财务仓");
        item.put("itemNum", 10);
        item.put("itemUnTaxedUnitAmt", 85);
        item.put("itemTaxRate", 0.13);
        AngularScope.appendData(driver, "document.querySelector('[ng-controller=apSupplierInvoiceEditController]')", "submitInvoiceObj.supplierInvoiceDetail[0]", item);
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveInvoice')]"))).perform();
        Thread.sleep(500);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//a[contains(@ng-click,'return')]"))).perform();
        Thread.sleep(500);

    }

    //查询供应商发票管理
    @Test(dependsOnMethods = {"apSupplierInvoiceadd"},description = "查询供应商发票管理")
    public void apSupplierInvoicequery() throws InterruptedException {
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN132frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN132frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getInvoices')]"))).perform();
        Thread.sleep(1000);

    }

    //重置供应商发票管理
    @Test(dependsOnMethods = {"apSupplierInvoicequery"},description = "重置供应商发票管理")
    public void apSupplierInvoicereset() throws InterruptedException {
//        Actions action = new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("FIN132frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset')]"))).perform();
        Thread.sleep(400);

    }

    //审核供应商发票管理
    @Test(dependsOnMethods = {"apSupplierInvoicereset"})
    public void apSupplierInvoiceaudit() throws InterruptedException {
//        Actions action = new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("FIN132frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'audit')]"))).perform();
        Thread.sleep(400);

        AngularScope.appendData(driver,"document.querySelector('[ng-model=auditType]')","auditType",2);
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'auditInvoice')]"))).perform();
        Thread.sleep(400);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
        Thread.sleep(500);
    }

//    //编辑供应商发票管理
//    @Test(dependsOnMethods = {"apSupplierInvoiceaudit"})
//    public void apSupplierInvoiceedit() throws InterruptedException {
//        Actions action = new Actions(driver);
////        driver.switchTo().frame(driver.findElement(By.id("FIN132frame")));
//        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'routeToEdit')]"))).perform();
//        Thread.sleep(400);
//        driver.switchTo().parentFrame();
//        driver.switchTo().frame(driver.findElement(By.id("menuapSupplierInvoiceEdit1886083600000138")).findElement(By.id("menuapSupplierInvoiceEdit1886083600000138frame")));
//
//        JSONObject submitInvoiceObj = new JSONObject();
//        submitInvoiceObj.put("supplierInvoiceDetail", new Object[]{});
//        submitInvoiceObj.put("invoiceLeftCode", "1101545455417"+(int)(Math.random()*1000));
//        submitInvoiceObj.put("invoiceRightCode", "11544545458");
//        submitInvoiceObj.put("invoiceTitleContent", "上海欧电云哦");
//        submitInvoiceObj.put("salerName", "上海欧电哦");
//        AngularScope.setData(driver, "document.querySelector('[ng-controller=apSupplierInvoiceEditController]')", "submitInvoiceObj", submitInvoiceObj);
//        Thread.sleep(1000);
//
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveInvoice')]"))).perform();
//        Thread.sleep(400);
//
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
//        Thread.sleep(500);
//
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'return')]"))).perform();
//        Thread.sleep(500);
//    }
//
    //删除供应商发票管理
    @Test(dependsOnMethods = {"apSupplierInvoiceaudit"})
    public void apSupplierInvoicedelete() throws InterruptedException {

//        Actions action = new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("FIN132frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'delInvoice')]"))).perform();
        Thread.sleep(400);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
        Thread.sleep(400);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
        Thread.sleep(500);
    }

}