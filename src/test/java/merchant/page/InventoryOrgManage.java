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

public class InventoryOrgManage extends PageAutomatedTest {

    @Test
    public void gotoInventoryManagePage() throws InterruptedException {
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
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心").xpath("//span[text()='库存组织']")));
        List<WebElement> elements = driver.findElement(By.linkText("商家中心")).findElements(By.xpath("//span[text()='库存组织']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增库存组织
    @Test
    public void addInventoryOrg() throws InterruptedException {
        gotoInventoryManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("SJ_300829frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'showAddInventoryModel()')]"))).perform();
        JSONObject inventoryAddParam = new JSONObject();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//select(@ng-model,'inventoryAddParam.merchantId')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'inventoryAddParam.merchantId')]")).findElements(By.tagName("option")).get(0).click();
        Thread.sleep(1000);
        inventoryAddParam.put("orgCode",dateFormat.format(new Date()));
        inventoryAddParam.put("orgName","文心阁库存"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('orgaddModal')","inventoryAddParam",inventoryAddParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addInventoryOrgInfo()')]"))).perform();
        Thread.sleep(1000);
    }
}
