package opms.page;

import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class AddSuplier extends PageAutomatedTest {

    @Test
    public void gotoSupplierPage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("采购中心")));
        Thread.sleep(5000);
        driver.findElement(By.linkText("采购中心")).click();
        driver.findElement(By.linkText("供应商管理")).click();
        List<WebElement> elements=driver.findElement(By.linkText("采购中心")).findElements(By.xpath("//li[contains(@definedattr,'/opms-web/#/supplierList')]"));
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
    public void addSupplier() throws InterruptedException {
        gotoSupplierPage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("CP10501frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addSupplier')]"))).perform();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.id("tab0")).findElement(By.id("tab0frame")));
       // driver.findElement(By.xpath("//input[contains(@ng-model,'merchantName')]")).sendKeys("屈臣氏自营商家");
       action.click(driver.findElement(By.xpath("//input[contains(@ng-click,'openModalDialog')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(2)).perform();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.supplierName')]")).sendKeys("P测试供应商");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.supplierShortName')]")).sendKeys("P简称");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.supplierHelpCode')]")).sendKeys("ZJM1001");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.supplierGlnCode')]")).sendKeys("GLM码");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.status')]")).sendKeys("1");
        driver.findElement(By.xpath("//select[contains(@ng-model,'supplier.basicInfo.cooperationMethod')]")).sendKeys("经销");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseName')]")).sendKeys("光明企业");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseCode')]")).sendKeys("PGM1001");
        driver.findElement(By.xpath("//select[contains(@ng-model,'supplier.basicInfo.enterpriseType')]")).sendKeys("国有企业");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseLicenseNumber')]")).sendKeys("X89988888");
        driver.findElement(By.xpath("//select[contains(@ng-model,'supplier.basicInfo.enterpriseTaxPayerType')]")).sendKeys("一般纳税人");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseTaxRate')]")).sendKeys("17");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseTaxCode')]")).sendKeys("89777888888");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseRegisteredCapital')]")).sendKeys("50万");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseBrandName')]")).sendKeys("P品牌");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.basicInfo.enterpriseMajorBusiness')]")).sendKeys("水果");
        driver.findElement(By.xpath("//textarea[contains(@ng-model,'supplier.basicInfo.remark')]")).sendKeys("备注10001");
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//li[contains(@ng-click,'changeTab(1)')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'province')]")).sendKeys("上海");
        driver.findElement(By.xpath("//select[contains(@ng-model,'city')]")).sendKeys("上海市");
        driver.findElement(By.xpath("//select[contains(@ng-model,'region')]")).sendKeys("浦东新区");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.addressInfo.addressDetail')]")).sendKeys("晨晖路88号");
        action.click(driver.findElement(By.xpath("//li[contains(@ng-click,'changeTab(3)')]"))).perform();
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.contactInfo.personName')]")).sendKeys("pyp");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.contactInfo.mobile')]")).sendKeys("13761935226");
        action.click(driver.findElement(By.xpath("//li[contains(@ng-click,'changeTab(4)')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'supplier.accountInfo.receiverAccountType')]")).sendKeys("支付宝");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.accountInfo.receiverAccountNo')]")).sendKeys("895555444444");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.accountInfo.receiverRealName')]")).sendKeys("pyp");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.accountInfo.receiverMobile')]")).sendKeys("13761935226");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.accountInfo.receiverIdNumber')]")).sendKeys("30565555555");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.accountInfo.receiverBankName')]")).sendKeys("中国银行");
        driver.findElement(By.xpath("//input[contains(@ng-model,'supplier.accountInfo.receiverSubBankName')]")).sendKeys("张江支行");

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveSupplier')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'close')]"))).perform();
        Thread.sleep(500);

    }
}
