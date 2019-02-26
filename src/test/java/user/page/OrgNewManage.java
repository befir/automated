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

public class OrgNewManage extends PageAutomatedTest {

    @Test
    public void gotoOrgNewManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("用户中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("用户中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("用户中心").xpath("//span[text()='部门管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("用户中心")).findElements(By.xpath("//span[text()='部门管理']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增部门
    @Test(dependsOnMethods = {"gotoOrgNewManagePage"})
    public void addOrgNew() throws InterruptedException {
        gotoOrgNewManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("30OU01frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[contains(@id,'treeDemo_1_span')]"))).perform();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'oneOrgAdd()')]"))).perform();
        JSONObject orgNewInfo = new JSONObject();
        orgNewInfo.put("code",dateFormat.format(new Date()));
        orgNewInfo.put("orgName","部"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('orgDialog1')","orgNewInfo",orgNewInfo);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveNewOrg()')]"))).perform();
        Thread.sleep(1000);
    }
    //编辑部门
    @Test(dependsOnMethods = {"addOrgNew"})
    public void editOrgNew() throws InterruptedException {
//        String unitId = "treeDemo_9_span";
//        gotoOrgNewManagePage();
//        WebDriver webDriver;
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("30OU01frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        //选择第九个部门进行选中
        action.click(driver.findElement(By.xpath("//span[contains(@id,'treeDemo_5_span')]"))).perform();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'oneOrgedit()')]"))).perform();
        JSONObject orgEditInfo = new JSONObject();
        orgEditInfo.put("code",dateFormat.format(new Date()));
        orgEditInfo.put("orgName","门"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('orgDialog2')","orgEditInfo",orgEditInfo);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-disabled,'editDisabled')]"))).perform();
        Thread.sleep(1000);
    }
    //查询部门
    @Test(dependsOnMethods = {"editOrgNew"})
    public void getOrgNew() throws InterruptedException {
//        String unitId = "treeDemo_9_span";
//        gotoOrgNewManagePage();
//        WebDriver webDriver;
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("30OU01frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        JSONObject input = new JSONObject();
        input.put("keyword","管理");
        AngularScope.appendData(driver,"document.getElementsByClassName('col-sm-3  b-b b-l b-r b-t')","input",input);
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@type,'submit')]"))).perform();
        Thread.sleep(3000);
        input.put("keyword","");
        AngularScope.appendData(driver,"document.getElementsByClassName('col-sm-3  b-b b-l b-r b-t')","input",input);
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@type,'submit')]"))).perform();
        Thread.sleep(3000);
    }

    //删除部门
    @Test(dependsOnMethods = {"getOrgNew"})
    public void deleteOrgNew() throws InterruptedException {
//        String unitId = "treeDemo_9_span";
//        gotoOrgNewManagePage();
//        WebDriver webDriver;
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("30OU01frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[contains(@id,'treeDemo_5_span')]"))).perform();
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'oneOrgdel()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'delOneOrg()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(3000);
    }
}
