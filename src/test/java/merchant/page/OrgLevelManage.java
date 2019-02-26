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

public class OrgLevelManage extends PageAutomatedTest {

    @Test
    public void gotoOrgLevelManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("商家中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("商家中心").xpath("//span[text()='组织层级']")));
        List<WebElement> elements = driver.findElement(By.linkText("商家中心")).findElements(By.xpath("//span[text()='组织层级']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    @Test
    //新增组织层级
    public void addOrgLevel() throws InterruptedException {
        gotoOrgLevelManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300814frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[contains(@id,'treeDemo_1_span')]"))).perform();
        action.click(driver.findElement(By.xpath("//span[contains(@id,'addBtn_treeDemo_1')]"))).perform();
        JSONObject addOrgParam = new JSONObject();
        addOrgParam.put("levelCode",dateFormat.format(new Date()));
        addOrgParam.put("levelName","组织层级"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('addOrg')","addOrgParam",addOrgParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'addOrgParamFunc();')]"))).perform();
        Thread.sleep(1000);
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
    }
    //编辑组织层级
    @Test
    public void editOrgLevel() throws InterruptedException {
        gotoOrgLevelManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300814frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//span[contains(@id,'treeDemo_6_span')]"))).perform();
        action.click(driver.findElement(By.xpath("//span[contains(@id,'editBtn_treeDemo_6')]"))).perform();
        JSONObject editOrgParam = new JSONObject();
//        addOrgParam.put("levelCode",dateFormat.format(new Date()));
        editOrgParam.put("levelName","层级"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('editOrg')","editOrgParam",editOrgParam);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'editOrgParamFunc();')]"))).perform();
        Thread.sleep(1000);
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
    }
    //查询组织层级
    @Test
    public void getOrgLevel() throws InterruptedException {
        gotoOrgLevelManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("300814frame")));

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);

        JSONObject input = new JSONObject();
        input.put("keyword","根节点");
        AngularScope.appendData(driver,"document.getElementsByClassName('col-sm-4  b-b b-l b-r b-t')","input",input);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'searchLevel()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'refreshLevel()')]"))).perform();
        Thread.sleep(1000);
    }
}
