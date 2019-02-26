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

import java.util.List;

public class ProductManage extends PageAutomatedTest {

    @Test
    public void gotoProductManagePage() throws InterruptedException {
        //切换到商家平台
        switchPlatformTo("商家平台");
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商品中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商品中心").xpath("//span[text()='商家商品管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("商品中心")).findElements(By.xpath("//span[text()='商家商品管理']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }

    @Test
//新增商品
    public void addProductManageOrg() throws InterruptedException {
        gotoProductManagePage();
       Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("PRODUCT_CHANNEL_12frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));

//        Thread.sleep(5000);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@ng-click,'add()')]")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'add()')]"))).perform();
//        JSONObject product = new JSONObject();
//       // driver.get(baseUrl+"/back-web/app/default/product2/index.html#/selfProductManage");
////        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-controller,'platformCtrl')]")));
////
//        Thread.sleep(5000);
//      Select merchantId = new Select(driver.findElement(By.xpath("//select[contains(@ng-options,'item.merchantId as item.merchantName for item in userMerchantList')]")));
//             merchantId.selectByIndex(2);
//        Thread.sleep(1000);
//
//        product.put("chineseName","坚果零食");
//        product.put("code","7981"+dateFormat.format(new Date()));
//        product.put("fullNamePath","后台-水果-海外水果-苹果");
//        product.put("categoryName","苹果");
//        product.put("brandid","1809076603000008");
//        product.put("brandId","1809076603000009");
//        product.put("brandName","来伊份");
//        product.put("mainUnitName","piece-件");
//        product.put("mainUnitId","piece");
//        product.put("isWeighted","7");
//        product.put("canSaleReturn","1");
//        product.put("barcode","895"+dateFormat.format(new Date()));
//       AngularScope.appendData(driver, "document.querySelector('select[ng-model]')","product",product);
        driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[contains(@ng-model,'product.chineseName')]")));
        String data = "{\"typeOfProduct\":0,\"type\":1,\"itemsPerPage\":0,\"mainUnitId\":1809080800000197,\"isWeighted\":0,\"mainUnitName\":\"件\",\"pssmId\":1809080800000196,\"sourceType\":1,\"brandId\":1809076603000009,\"status\":0,\"fullNamePath\":\"后台-水果-海外水果-苹果\",\"mainUnitCode\":\"piece\",\"measureType\":1,\"storeId\":-1,\"currentPage\":0,\"canPurchase\":1,\"startItem\":0,\"merchantId\":1811076601000010,\"brandName\":\"来伊份\",\"isVisible\":1,\"isForceInvoice\":0,\"isVoice\":1,\"canDistribution\":1,\"canSaleReturn\":1,\"isVatInvoice\":0,\"categoryName\":\"苹果\",\"channelCode\":\"-1\",\"isInvoice\":0,\"canPurchaseReturn\":1,\"canSale\":0,\"chineseName\":\"坚果零食\",\"categoryId\":1809076603000012}";
        JSONObject product = JSON.parseObject(data);
        AngularScope.appendData(driver, "document.querySelector('select[ng-model]')","product",product);
        System.out.println(JSON.toJSONString(AngularScope.getData(driver, "document.querySelector('select[ng-model]')","product")));
        //driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[contains(@ng-model,'product.chineseName')]")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@ng-click,'save()')]")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'save()')]"))).perform();
        Thread.sleep(5000);

        action.click(driver.findElement(By.id("btn_ok"))).perform();
        Thread.sleep(5000);
      //  action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'product.brandName')]"))).perform();
       // Thread.sleep(5000);
       // action.click(driver.findElement(By.xpath("//button[contains(@type,'submit') and contains(@ng-click,'getRegisterMerchantPageInfo')]"))).perform();
        //action.(driver.findElement(By.xpath("//label[contains(@label,'ng-valid ng-dirty') and contains(@class,'来伊份')]"))).perform();

      // 点击进入图片页面
      action.click(driver.findElement(By.xpath("//li[contains(@ng-click,'initPicture()')]"))).perform();
        Thread.sleep(5000);
        // 点击进入商品描述页面
        action.click(driver.findElement(By.xpath("//li[contains(@ng-click,'initMerchantProductDescription()')]"))).perform();
        Thread.sleep(5000);
        action.click(driver.findElement(By.xpath("//li[contains(@ng-click,'initMerchantProductDescription()')]"))).perform();

        System.out.println(JSON.toJSONString(AngularScope.getData(driver, "document.querySelector('select[ng-model]')","product")));

      AngularScope.appendData(driver, "document.querySelector('select[ng-model]')","product",product);
}
}
