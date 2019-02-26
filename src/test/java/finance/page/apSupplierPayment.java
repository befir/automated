package finance.page;

import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//供应商结算管理
public class apSupplierPayment extends PageAutomatedTest {

    //财务中心
    @Test
    public void apSupplierPayment() throws InterruptedException {
        switchThirdMenuTo("全渠道","财务中心","供应商结算管理","供应商付款申请单");
    }

    //新增付款申请单
    @Test
    public void apSupplierFeeBilladd() throws InterruptedException {
        apSupplierPayment();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN130frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN130frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);

        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(500);

        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.id("menucreatePaymentOrder")).findElement(By.id("menucreatePaymentOrderframe")));

        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'openModalDialog')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")).get(1)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'selectedOk')]"))).perform();
        Thread.sleep(500);

        AngularScope.appendData(driver, "document.querySelector('[id=amount]')", "paymentOrder.feeBillDetailDTOs[0].payAmt", 1);
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveApSupplierPayment')]"))).perform();
        Thread.sleep(500);

    }

    //查询付款申请单
    @Test
    public void apSupplierFeeBillselect() throws InterruptedException {
        apSupplierPayment();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN130frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN130frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'getApSupplierPayment')]")).get(0)).perform();
        Thread.sleep(500);
    }

    //重置付款申请单
    @Test
    public void apSupplierFeeBillreset() throws InterruptedException {
        apSupplierPayment();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN130frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN130frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'reset')]")).get(0)).perform();
        Thread.sleep(500);
    }

    //审核付款申请单
    @Test
    public void apSupplierFeeBillaudit() throws InterruptedException {
        apSupplierPayment();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN130frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN130frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'auditPass')]")).get(0)).perform();
        Thread.sleep(500);
    }

    //审核驳回付款申请单
    @Test
    public void apSupplierFeeBillNOaudit() throws InterruptedException {
        apSupplierPayment();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN130frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN130frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'auditNoPass')]")).get(0)).perform();
        Thread.sleep(500);
    }

    //删除付款申请单
    @Test
    public void apSupplierFeeBilldelete() throws InterruptedException {
        apSupplierPayment();
        driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("FIN130frame")));
//        driver.switchTo().frame(driver.findElement(By.id("FIN130frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        Thread.sleep(500);

        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'confirmToDelete')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'close')]")).get(0)).perform();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'close')]")).get(0)).perform();
        Thread.sleep(500);
    }
}
