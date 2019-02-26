package merchant.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.AngularScope;
import common.CustomExpectedConditions;
import common.PageAutomatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MerchantOrgManage extends PageAutomatedTest {
    String baseUrl = properties.getProperty("baseUrl");
    private String orgId;
    @Test
    public void gotoMerchantManagePage() throws InterruptedException {
        String channelText = "全渠道";
        String firstMenuText = "商家中心";
        String secondMenuText = "商家管理";
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText(channelText)));
        action.click(driver.findElement(By.linkText(channelText))).perform();
        driverWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.linkText(firstMenuText))));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText(firstMenuText)));
        action.click(driver.findElement(By.linkText(firstMenuText))).perform();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(firstMenuText).xpath("//span[text()='"+secondMenuText+"']")));
        List<WebElement> elements = driver.findElement(By.linkText(firstMenuText)).findElements(By.xpath("//span[text()='"+secondMenuText+"']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                action.click(element).perform();
                break;
            }
        }
    }
    @Test(dependsOnMethods = {"gotoMerchantManagePage"},dataProvider = "merchantOrgBaseInfo")
    public void addMerchantOrg(JSONObject merchantOrgBaseInfo) throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.id("300818frame")));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@ng-click,'addMerchantInit')]")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addMerchantInit')]"))).perform();
        JSONObject merchantAddParam = new JSONObject();
        merchantAddParam.put("merchantType",11);
        merchantAddParam.put("orgCode",dateFormat.format(new Date()));
        merchantAddParam.put("orgName","autoTestName"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('regMerchantaddModal')","merchantAddParam",merchantAddParam);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@ng-click,'addMerchantInfo')]")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addMerchantInfo')]"))).perform();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("bootstrap-dialog-footer")));
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("bootstrap-dialog-footer")).findElement(By.xpath("//button[text()='确定']"))));
        action.click(driver.findElement(By.className("bootstrap-dialog-footer")).findElement(By.xpath("//button[text()='确定']"))).perform();
        JSONObject regMerchantQueryParam = new JSONObject();
        regMerchantQueryParam.put("orgCode",merchantAddParam.get("orgCode"));
        AngularScope.appendData(driver, "document.getElementById('regMerchantaddModal')","regMerchantQueryParam",regMerchantQueryParam);
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@type,'submit') and contains(@ng-click,'getRegisterMerchantPageInfo')]"))));
        action.click(driver.findElement(By.xpath("//button[contains(@type,'submit') and contains(@ng-click,'getRegisterMerchantPageInfo')]"))).perform();
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(@ng-click,'editRegMerchant')]"))));
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'editRegMerchant')]")).get(0)).perform();
        Set<String> windows = driver.getWindowHandles();
        for(String s:windows){
            if(driver.switchTo().window(s).getCurrentUrl().contains((String)merchantAddParam.get("orgCode")+"/2/true")){
                break;
            }
        }
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@ng-controller,'merchantBaseInfoController')]")));

        AngularScope.appendData(driver, "document.querySelector('[ng-controller=merchantBaseInfoController]')","merchantOrgBaseInfo",merchantOrgBaseInfo);
        AngularScope.appendData(driver, "document.querySelector('[ng-controller=merchantBaseInfoController]')","orgNameChange","上海");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@ng-model,'merchantOrgBaseInfo.businessPeriodBegin')]")));
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR,1);
        driver.findElement(By.xpath("//input[contains(@ng-model,'merchantOrgBaseInfo.businessPeriodBegin')]")).sendKeys(dateFormat2.format(new Date()));
        driver.findElement(By.xpath("//input[contains(@ng-model,'merchantOrgBaseInfo.businessPeriodEnd')]")).sendKeys(dateFormat2.format(now.getTime()));
        driver.findElement(By.xpath("//input[contains(@ng-model,'merchantOrgBaseInfo.businessLicencePeriodBegin')]")).sendKeys(dateFormat2.format(new Date()));
        driver.findElement(By.xpath("//input[contains(@ng-model,'merchantOrgBaseInfo.businessLicencePeriodEnd')]")).sendKeys(dateFormat2.format(now.getTime()));

        String registeredProvinceCodeXpath = "//province-picker[contains(@province-code,'merchantOrgBaseInfo.registeredProvinceCode')]//select";
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(registeredProvinceCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(registeredProvinceCodeXpath),2));
        Select registeredProvinceCode = new Select(driver.findElement(By.xpath(registeredProvinceCodeXpath)));
        registeredProvinceCode.selectByIndex(0);
        registeredProvinceCode.selectByIndex(2);

        String registeredCityCodeXpath = "//city-picker[contains(@city-code,'merchantOrgBaseInfo.registeredCityCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(registeredCityCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(registeredCityCodeXpath),1));
        Select registeredCityCode = new Select(driver.findElement(By.xpath(registeredCityCodeXpath)));
        registeredCityCode.selectByIndex(1);

        String registeredRegionCodeXpath = "//region-picker[contains(@region-code,'merchantOrgBaseInfo.registeredRegionCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(registeredRegionCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(registeredRegionCodeXpath),2));
        Select registeredRegionCode = new Select(driver.findElement(By.xpath(registeredRegionCodeXpath)));
        registeredRegionCode.selectByIndex(2);

        String contactProvinceCodeXpath = "//province-picker[contains(@province-code,'merchantOrgBaseInfo.contactProvinceCode')]//select";
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(contactProvinceCodeXpath)));
        Select contactProvinceCode = new Select(driver.findElement(By.xpath(contactProvinceCodeXpath)));
        contactProvinceCode.selectByIndex(0);
        contactProvinceCode.selectByIndex(3);

        String contactCityCodeXpath = "//city-picker[contains(@city-code,'merchantOrgBaseInfo.contactCityCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(contactCityCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(contactCityCodeXpath),1));
        Select contactCityCode = new Select(driver.findElement(By.xpath(contactCityCodeXpath)));
        contactCityCode.selectByIndex(2);

        String contactRegionCodeXpath = "//region-picker[contains(@region-code,'merchantOrgBaseInfo.contactRegionCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(contactRegionCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(contactRegionCodeXpath),3));
        Select contactRegionCode = new Select(driver.findElement(By.xpath(contactRegionCodeXpath)));
        contactRegionCode.selectByIndex(3);

        Object o = AngularScope.getData(driver, "document.querySelector('[ng-controller=merchantBaseInfoController]')","merchantOrgBaseInfo");
        System.out.println(JSON.toJSONString(o));
        orgId = JSON.parseObject(JSON.toJSONString(o)).getString("id");
        action.click(driver.findElement(By.xpath("//input[contains(@ng-model,'merchantOrgBaseInfo.entryTermsId')]")));
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'updateMerchantOrgBaseInfo')]")));
        action.perform();

    }
    @Test(dependsOnMethods = {"addMerchantOrg"})
    @Parameters("defaultOrgId")
    public void editMerchantOrg(String orgId) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("window.open('"+baseUrl+"/back-merchant-web/index.html#/editMerchantOrg/"+orgId+"/2/true','editMerchantOrg')");
        Set<String> windows = driver.getWindowHandles();
        for(String s:windows){
            if(driver.switchTo().window(s).getTitle().contains("editMerchantOrg")){
                break;
            }
        }
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-controller,'merchantBaseInfoController')]")));
        Thread.sleep(5000);
        JSONObject merchantOrgBaseInfo = new JSONObject();
        Calendar now = Calendar.getInstance();
        Date today = now.getTime();
        now.add(Calendar.YEAR,1);
        merchantOrgBaseInfo.put("businessPeriodBegin",dateFormat2.format(today));
        merchantOrgBaseInfo.put("businessPeriodEnd",dateFormat2.format(now.getTime()));
        merchantOrgBaseInfo.put("businessLicencePeriodBegin",dateFormat2.format(today));
        merchantOrgBaseInfo.put("businessLicencePeriodEnd",dateFormat2.format(now.getTime()));
        AngularScope.appendData(driver, "document.querySelector('[ng-controller=merchantBaseInfoController]')","merchantOrgBaseInfo",merchantOrgBaseInfo);
        AngularScope.appendData(driver, "document.querySelector('[ng-controller=merchantBaseInfoController]')","orgNameChange","上海");

        String registeredProvinceCodeXpath = "//province-picker[contains(@province-code,'merchantOrgBaseInfo.registeredProvinceCode')]//select";
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(registeredProvinceCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(registeredProvinceCodeXpath),2));
        Select registeredProvinceCode = new Select(driver.findElement(By.xpath(registeredProvinceCodeXpath)));
        registeredProvinceCode.selectByIndex(0);
        registeredProvinceCode.selectByIndex(2);

        String registeredCityCodeXpath = "//city-picker[contains(@city-code,'merchantOrgBaseInfo.registeredCityCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(registeredCityCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(registeredCityCodeXpath),1));
        Select registeredCityCode = new Select(driver.findElement(By.xpath(registeredCityCodeXpath)));
        registeredCityCode.selectByIndex(1);

        String registeredRegionCodeXpath = "//region-picker[contains(@region-code,'merchantOrgBaseInfo.registeredRegionCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(registeredRegionCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(registeredRegionCodeXpath),2));
        Select registeredRegionCode = new Select(driver.findElement(By.xpath(registeredRegionCodeXpath)));
        registeredRegionCode.selectByIndex(2);

        String contactProvinceCodeXpath = "//province-picker[contains(@province-code,'merchantOrgBaseInfo.contactProvinceCode')]//select";
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(contactProvinceCodeXpath)));
        Select contactProvinceCode = new Select(driver.findElement(By.xpath(contactProvinceCodeXpath)));
        contactProvinceCode.selectByIndex(0);
        contactProvinceCode.selectByIndex(3);

        String contactCityCodeXpath = "//city-picker[contains(@city-code,'merchantOrgBaseInfo.contactCityCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(contactCityCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(contactCityCodeXpath),1));
        Select contactCityCode = new Select(driver.findElement(By.xpath(contactCityCodeXpath)));
        contactCityCode.selectByIndex(2);

        String contactRegionCodeXpath = "//region-picker[contains(@region-code,'merchantOrgBaseInfo.contactRegionCode')]//select";
        driverWait.until(CustomExpectedConditions.selectRefreshed(By.xpath(contactRegionCodeXpath)));
        driverWait.until(CustomExpectedConditions.selectOptionSizeGreaterThan(By.xpath(contactRegionCodeXpath),3));
        Select contactRegionCode = new Select(driver.findElement(By.xpath(contactRegionCodeXpath)));
        contactRegionCode.selectByIndex(3);
//        WebElement element = driver.findElement(By.xpath("//input[contains(@ng-model,'merchantOrgBaseInfo.entryTermsId')]"));
//        action.click(element).perform();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'updateMerchantOrgBaseInfo')]"))).perform();
    }
    @Test(dependsOnMethods = {"editMerchantOrg"})
    @Parameters("defaultOrgId")
    public void queryMerchantOrg(String orgId) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("window.open('"+baseUrl+"/back-merchant-web/index.html#/queryMerchantOrg/"+orgId+"/2/false','queryMerchantOrg')");
        Set<String> windows = driver.getWindowHandles();
        for(String s:windows){
            if(driver.switchTo().window(s).getTitle().contains("queryMerchantOrg")){
                break;
            }
        }
        
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-controller,'merchantBaseInfoController')]")));
        Thread.sleep(5000);

        Object merchantOrgBaseInfo = AngularScope.getData(driver, "document.querySelector('[ng-controller=merchantBaseInfoController]')","merchantOrgBaseInfo");
        System.out.println("---------------------------------------------");
        System.out.println("merchantOrgBaseInfo:"+ JSON.toJSONString(merchantOrgBaseInfo));
        System.out.println("---------------------------------------------");
        Object orgNameChange = AngularScope.getData(driver, "document.querySelector('[ng-controller=merchantBaseInfoController]')","orgNameChange");
        System.out.println("orgNameChange:"+ JSON.toJSONString(orgNameChange));
        System.out.println("---------------------------------------------");
        }

    @DataProvider(name = "merchantOrgBaseInfo")
    public static Object[][] merchantOrgBaseInfo() {
        JSONObject merchantOrgBaseInfo = new JSONObject();
        merchantOrgBaseInfo.put("registeredDeposit","5000");
        merchantOrgBaseInfo.put("enterpriseName","autoTest");
        merchantOrgBaseInfo.put("legalRepresentativeName","autoTestUser");
        merchantOrgBaseInfo.put("legalRepresentativeCertificateType",1);
        merchantOrgBaseInfo.put("legalRepresentativeCertificateNo","123456");
        merchantOrgBaseInfo.put("businessLicenceNo","12345678");
        merchantOrgBaseInfo.put("enterpriseType",1);
        merchantOrgBaseInfo.put("businessScope","电子商务");
        merchantOrgBaseInfo.put("mobileNo","13455555555");
        merchantOrgBaseInfo.put("registeredDetailAddress","碧波路88号");
        merchantOrgBaseInfo.put("registeredCapital",5);
        merchantOrgBaseInfo.put("enterpriseStaffNums",4);
        merchantOrgBaseInfo.put("accountingUnitId","1811076601000006");
        merchantOrgBaseInfo.put("contactName","autoTestUser");
        merchantOrgBaseInfo.put("email","autoTestUser@ody.com");
        merchantOrgBaseInfo.put("contactDetailAddress","碧波路88号");
        merchantOrgBaseInfo.put("entryTermsId","1");
        merchantOrgBaseInfo.put("orgLevelCode","01");
        return new Object[][] { { merchantOrgBaseInfo } };
    }
}
