package product.page;

import com.alibaba.fastjson.JSON;
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

public class addbrand extends PageAutomatedTest {

    @Test
    public void gotobrandPage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(5000);
        driver.findElement(By.linkText("商品中心")).click();
        driver.findElement(By.linkText("商品设置")).click();
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//li[contains(@definedattr,'/back-web/app/default/product2/index.html#/brandManage')]"));
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }
    }

    @Test
    public void addbrand() throws InterruptedException {
        gotobrandPage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_1_1frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));

        Thread.sleep(1000);
//        System.out.println(JSON.toJSONString( AngularScope.getData(driver, "document.querySelector('[ng-model=\"Params.opStatusName\"]')", "Params")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'add')]"))).perform();
        JSONObject brand = new JSONObject();
        brand.put("name", "测试" + dateFormat.format(new Date()));
        Thread.sleep(500);
        brand.put("englishName", "fsfsf");
        Thread.sleep(500);
        brand.put("alias", "别名");
        Thread.sleep(500);
        brand.put("alias", "别名");
        Thread.sleep(500);
        brand.put("owner", "个人");
        Thread.sleep(500);
        brand.put("registrationNumber", "123456");
        Thread.sleep(500);
        brand.put("ownedcompanyChineseName", "欧电云");
        Thread.sleep(500);
        brand.put("ownedcompanyEnglishName", "oudianyun");
        Thread.sleep(500);
//        AngularScope.setData(driver,"document.querySelector('input[ng-model]')","Params",Params);
        AngularScope.appendData(driver, "document.querySelector('[ng-model=\"brand.name\"]')", "brand", brand);
//        System.out.println(JSON.toJSONString( AngularScope.getData(driver, "document.querySelector('[ng-model=\"Params.opStatusName\"]')", "Params")));
//        Thread.sleep(1000);

        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'save()')]"))).perform();
        System.out.println(JSON.toJSONString(AngularScope.getData(driver, "document.querySelector('[ng-model=\"brand.name\"]')", "brand")));
        Thread.sleep(500);
        action.click(driver.findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(500);
    }

}
