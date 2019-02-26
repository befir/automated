package user.page;

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

public class MemberGradeManage extends PageAutomatedTest {

    @Test
    public void gotoMemberGradeManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("会员中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("会员中心")).click();
        driver.findElement(By.linkText("会员管理")).click();
        List<WebElement> elements=driver.findElement(By.linkText("会员中心")).findElements(By.xpath("//li[contains(@definedattr,'/ouser-center/index.html#/memberGradeList')]"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增会员等级
    @Test(dependsOnMethods = {"gotoMemberGradeManagePage"})
    public void addMemberGrade() throws InterruptedException {
        int x=(int)(Math.random()*10+1);
        gotoMemberGradeManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("308902frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addMemberGrade()')]"))).perform();
        JSONObject memberShipInfo = new JSONObject();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'memberShipInfo.memberType')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'memberShipInfo.memberType')]")).findElements(By.tagName("option")).get(1).click();
        Thread.sleep(3000);
        memberShipInfo.put("levelName","会员等级"+dateFormat.format(new Date()));
        memberShipInfo.put("iconUrl","http://cdn.oudianyun.com/ones2.3-prod/trunk/osc/1540863513035_71.82356973706898.jpg");
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'memberShipInfo.gradeStatus')]")).get(1)).perform();
        Thread.sleep(3000);
        memberShipInfo.put("balence",x);
        System.out.println(JSON.toJSONString("等级达成条件："+x));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'memberShipInfo.endTimeStatus')]")).get(0)).perform();
        Thread.sleep(1000);
        AngularScope.appendData(driver,"document.getElementsByClassName('form-group col-md-11 ng-scope')","memberShipInfo",memberShipInfo);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveGradeInfo();')]"))).perform();
        Thread.sleep(3000);
//        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(1000);
    }
    //修改会员等级
    @Test(dependsOnMethods = {"addMemberGrade"})
    public void editMemberGrade() throws InterruptedException {
        int x=(int)(Math.random()*10+1);
//        gotoMemberGradeManagePage();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("308902frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'openEditPage(item)')]")).get(0)).perform();
        JSONObject memberShipInfo = new JSONObject();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//select[contains(@ng-model,'memberShipInfo.memberType')]"))).perform();
        driver.findElement(By.xpath("//select[contains(@ng-model,'memberShipInfo.memberType')]")).findElements(By.tagName("option")).get(1).click();
        Thread.sleep(3000);
        memberShipInfo.put("levelName","等级"+dateFormat.format(new Date()));
        memberShipInfo.put("iconUrl","http://cdn.oudianyun.com/ones2.3-prod/trunk/osc/1540863513035_71.82356973706898.jpg");
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'memberShipInfo.gradeStatus')]")).get(1)).perform();
        Thread.sleep(3000);
        memberShipInfo.put("balence",x);
        System.out.println(JSON.toJSONString("等级达成条件："+x));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//input[contains(@ng-model,'memberShipInfo.endTimeStatus')]")).get(0)).perform();
        Thread.sleep(1000);
        AngularScope.appendData(driver,"document.getElementsByClassName('form-group col-md-11 ng-scope')","memberShipInfo",memberShipInfo);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'updateGradeInfo();')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(1000);
    }
    //查询会员等级
    @Test(dependsOnMethods = {"editMemberGrade"})
    public void getMemberGrade() throws InterruptedException {
        int x=(int)(Math.random()*10+1);
//        gotoMemberGradeManagePage();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("308902frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        JSONObject orgNewInfo = new JSONObject();
        orgNewInfo.put("code",dateFormat.format(new Date()));
        driver.findElement(By.xpath("//input[contains(@ng-model,'queryContent.obj.levelName')]")).sendKeys("会员等级");
        driver.findElement(By.xpath("//input[contains(@ng-model,'queryContent.obj.balence')]")).sendKeys(x+"");
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getData(1)')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'reset()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'getData(1)')]"))).perform();
        Thread.sleep(3000);
    }
}
