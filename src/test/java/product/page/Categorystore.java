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

public class Categorystore extends PageAutomatedTest {
    @Test
    public void gotoCategorystorepage() throws InterruptedException {
        //切换到商家平台
        switchPlatformTo("商家平台");
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商品中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心").xpath("//span[text()='店铺类目']")));
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//span[text()='店铺类目']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }

    @Test
//    店铺类目新增
    public void addCategorystore() throws InterruptedException {
        gotoCategorystorepage();
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_7frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'openAddCategoryModal()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'categoryObj.storeInfo')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'categoryObj.storeInfo')]")).findElements(By.tagName("option")).get(1).click();
        Thread.sleep(500);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(0)).perform();
        Thread.sleep(500);

        JSONObject categoryObj = new JSONObject();
        categoryObj.put("name", "测试" + dateFormat.format(new Date()));
//        AngularScope.setData(driver,"document.querySelector('input[ng-model]')","Params",Params);
        AngularScope.appendData(driver, "document.querySelector('[ng-model=\"categoryObj.name\"]')", "categoryObj", categoryObj);
        Thread.sleep(1000);
        System.out.println(JSON.toJSONString( AngularScope.getData(driver, "document.querySelector('[ng-model=\"categoryObj.name\"]')", "categoryObj")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'ok()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryStoreCategoryList()')]"))).perform();
    }
    @Test
//    店铺类目编辑
    public void editCategorystore() throws InterruptedException {
        gotoCategorystorepage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_7frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'gotoCategoryDetail(e.id,e.storeId)')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@type,'radio')]")).get(1)).perform();
        Thread.sleep(1000);
        JSONObject selectedCategory = new JSONObject();
        selectedCategory.put("thirdCode",1234);
        AngularScope.appendData(driver,"document.querySelector('[ng-model=\"selectedCategory.thirdCode\"]')","selectedCategory",selectedCategory);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'updateCategory()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@id,'btn_ok')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'backToManage()')]"))).perform();
    }
    @Test
//    店铺类目查询
    public void getCategorystore() throws InterruptedException {
        gotoCategorystorepage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_7frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        JSONObject queryParam = new JSONObject();
        queryParam.put("name","测试20181113200058");
        AngularScope.appendData(driver,"document.querySelector('[ng-model=\"queryParam.name\"]')","queryParam",queryParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'queryStoreCategoryList()')]"))).perform();
        Thread.sleep(3000);

    }
}
