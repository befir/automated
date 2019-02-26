package user.page;

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

public class MemberTypeManage extends PageAutomatedTest {

    @Test
    public void gotoMemberTypeManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("会员中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("会员中心")).click();
        driver.findElement(By.linkText("会员管理")).click();
        List<WebElement> elements=driver.findElement(By.linkText("会员中心")).findElements(By.xpath("//li[contains(@definedattr,'/ouser-center/index.html#/memberTypeManage')]"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增会员类型
    @Test(dependsOnMethods = {"gotoMemberTypeManagePage"})
    public void addMemberType() throws InterruptedException {
        gotoMemberTypeManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("308904frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addMemberType()')]"))).perform();
        JSONObject memberTypeInfoNew = new JSONObject();
        memberTypeInfoNew.put("memberTypeName","会员类型"+dateFormat.format(new Date()));
        memberTypeInfoNew.put("remark","会员类型描述"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('_addMemberType')","memberTypeInfoNew",memberTypeInfoNew);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'save()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(1000);
    }
    //修改会员类型
    @Test(dependsOnMethods = {"addMemberType"})
    public void editMemberType() throws InterruptedException {
//        gotoMemberTypeManagePage();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("308904frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'modifyMemberType(e)')]")).get(0)).perform();
        JSONObject memberTypeInfo = new JSONObject();
        memberTypeInfo.put("memberTypeName","类型"+dateFormat.format(new Date()));
        memberTypeInfo.put("remark","类型描述"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('_modifyMemberType')","memberTypeInfo",memberTypeInfo);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'modify()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(1000);
    }
}
