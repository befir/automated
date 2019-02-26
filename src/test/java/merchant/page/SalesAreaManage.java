package merchant.page;

import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class SalesAreaManage extends PageAutomatedTest {

    @Test
    public void gotoSalesAreaManagePage() throws InterruptedException {
//        driverQuite = false;
        //切换到商家平台
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div/ul/li[2]/a")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/ul/li[2]/a")).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("商家平台")));
        driver.findElement(By.linkText("商家平台")).click();
        Thread.sleep(1000);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商家中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心").xpath("//span[text()='销售区域']")));
        List<WebElement> elements = driver.findElement(By.linkText("商家中心")).findElements(By.xpath("//span[text()='销售区域']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增销售区域
    @Test
    public void addSalesArea() throws InterruptedException {
        gotoSalesAreaManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300820frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'showAddOrEditModal()')]"))).perform();
        JSONObject salesAreaAddParam = new JSONObject();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'addParam.orgObj')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'addParam.orgObj')]")).findElements(By.tagName("option")).get(1).click();
        Thread.sleep(1000);
        salesAreaAddParam.put("areaCode",dateFormat.format(new Date()));
        salesAreaAddParam.put("areaName","文心阁销售区域"+dateFormat.format(new Date()));
//        salesAreaAddParam.put("orgObj","2029080800000000");
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'genera')]")));//勾选全国
//        action.click(driver.findElement(By.xpath("//input[contains(@ng-change,'selectFirstLayerAddress(provinceList[$index - 3], $index - 3)')]")));//勾选上海
        Thread.sleep(3000);
        AngularScope.appendData(driver,"document.getElementById('salesAreaModal')","salesAreaAddParam",salesAreaAddParam);
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-disabled,'saveButton')]"))).perform();
        Thread.sleep(5000);
    }
    //编辑销售区域
    @Test
    public void editSalesArea() throws InterruptedException {
        gotoSalesAreaManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300820frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'editAreaModel(salesArea)')]"))).perform();
        JSONObject salesAreaAddParam = new JSONObject();
        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'addParam.orgObj')]"))).perform();
//        driver.findElement(By.xpath("//select[contains(@ng-model,'addParam.orgObj')]")).findElements(By.tagName("option")).get(1).click();
        Thread.sleep(1000);
        salesAreaAddParam.put("areaCode",dateFormat.format(new Date()));
        salesAreaAddParam.put("areaName","文心阁区域"+dateFormat.format(new Date()));
//        salesAreaAddParam.put("orgObj","2029080800000000");
//        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'genera')]")));//勾选全国
        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'provinceList[$index - 3].selected')]")));//勾选上海
        AngularScope.appendData(driver,"document.getElementById('salesAreaModal')","salesAreaAddParam",salesAreaAddParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-disabled,'saveButton')]"))).perform();
        Thread.sleep(1000);
    }
}
