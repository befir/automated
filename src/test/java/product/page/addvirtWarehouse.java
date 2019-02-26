package product.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class addvirtWarehouse extends PageAutomatedTest {
    @Test
    public void gotoProductManagePage1() throws InterruptedException {
        //切换到商家平台
        switchPlatformTo("商家平台");
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("库存中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("库存中心").xpath("//span[text()='拟合仓管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("库存中心")).findElements(By.xpath("//span[text()='拟合仓管理']"));
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }

    }


    @Test
    //新增拟合仓
    public void addvirtInventoryOrg() throws InterruptedException {
//        driverQuite = false;
        gotoProductManagePage1();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("STOCK_CHANNEL_5frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'add()')]"))).perform();
        JSONObject virtualWarehouse = new JSONObject();
        virtualWarehouse.put("warehouseCode",dateFormat.format(new Date()));
        virtualWarehouse.put("warehouseName", "桃花拟合" + dateFormat.format(new Date()));

        AngularScope.appendData(driver, "document.querySelector('input[ng-model]')", "virtualWarehouse", virtualWarehouse);

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'virtualWarehouse.merchantId')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'virtualWarehouse.merchantId')]")).findElements(By.tagName("option")).get(1).click();

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addCoverage()')]"))).perform();

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'c.provinceCode')]"))).perform();
        Thread.sleep(1000);

        Select registeredProvinceCode = new Select(driver.findElement(By.xpath("//select[contains(@ng-model,'c.provinceCode')]")));
        registeredProvinceCode.selectByIndex(2);
        Thread.sleep(1000);

        Select registeredCityCode = new Select(driver.findElement(By.xpath("//select[contains(@ng-model,'c.cityCode')]")));
        registeredCityCode.selectByIndex(1);
        Thread.sleep(1000);

        Select registeredRegionCode = new Select(driver.findElement(By.xpath("//select[contains(@ng-model,'c.districtCode')]")));
        registeredRegionCode.selectByIndex(1);
        Thread.sleep(1000);

        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addMapping()')]"))).perform();

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.storeId')]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.storeId')]")).findElements(By.tagName("option")).get(1).click();

        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.assignType')]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[contains(@ng-model,'mappingParam.assignType')]")).findElements(By.tagName("option")).get(1).click();


        driver.findElement(By.xpath("//input[contains(@ng-model,'mappingParam.assignValue')]")).sendKeys("90");
//  //输入框第二种放法
//        action.sendKeys(driver.findElement(By.xpath("//input[contains(@ng-model,'mappingParam.assignValue')]")),"90").perform();
//        JSONObject mappingParam = new JSONObject();
//        mappingParam.put("assignValue",90);
//        mappingParam.put("alarmValue",99);
////        AngularScope.appendData(driver, "document.querySelector('[ng-model=mappingParam.assignValue]')", "mappingParam", mappingParam);
//        AngularScope.appendData(driver, "document.querySelector('input[ng-model=\"mappingParam.assignValue\"]')", "mappingParam", mappingParam);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'addMapping()')]")).get(1)).perform();
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveVirtualWarehouse')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.id("btn_ok"))).perform();


    }

}
