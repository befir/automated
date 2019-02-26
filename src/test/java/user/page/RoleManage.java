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

public class RoleManage extends PageAutomatedTest {

    @Test
    public void gotoRoleManagePage() throws InterruptedException {
//        driverQuite = false;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("用户中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("用户中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("用户中心").xpath("//span[text()='角色管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("用户中心")).findElements(By.xpath("//span[text()='角色管理']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增角色
    @Test(dependsOnMethods = {"gotoRoleManagePage"})
    public void addRole() throws InterruptedException {
        gotoRoleManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("30OU03frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'cleanData()')]"))).perform();
        JSONObject addRole = new JSONObject();
        addRole.put("name","角色"+dateFormat.format(new Date()));
        addRole.put("code",dateFormat.format(new Date()));
        addRole.put("addPlatform",0);
        addRole.put("desc","角色描述"+dateFormat.format(new Date()));
//        action.click(driver.findElement(By.xpath("//span[contains(@id,'treeDemo_1_check')]"))).perform();
        AngularScope.appendData(driver,"document.getElementById('addForm')","addRole",addRole);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'saveRole()')]"))).perform();
        Thread.sleep(1000);
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
    }
    //修改角色
    @Test(dependsOnMethods = {"addRole"})
    public void editRole() throws InterruptedException {
        gotoRoleManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("30OU03frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/button[1]"))).perform();
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'roleById(e.id)')]")).get(0)).perform();
        JSONObject editRole = new JSONObject();
        editRole.put("name","角色X"+dateFormat.format(new Date()));
        editRole.put("code",dateFormat.format(new Date()));
        editRole.put("addPlatform",0);
        editRole.put("desc","角色描述X"+dateFormat.format(new Date()));
        action.click(driver.findElement(By.xpath("//span[contains(@id,'treeEditRole_1_check')]"))).perform();
        AngularScope.appendData(driver,"document.getElementById('editForm')","editRole",editRole);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'updateRole()')]"))).perform();
        Thread.sleep(1000);
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
    }
    //查询角色
    @Test(dependsOnMethods = {"editRole"})
    public void getRole() throws InterruptedException {
        gotoRoleManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("30OU03frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        JSONObject querycontent = new JSONObject();
        querycontent.put("name","角色");
        AngularScope.appendData(driver,"document.getElementsByClassName('panel panel-default')","querycontent",querycontent);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'query()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'resetValue()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'query()')]"))).perform();
        Thread.sleep(1000);
    }
    //删除角色
//    @Test(dependsOnMethods = {"getRole"})
//    public void deleteRole() throws InterruptedException {
//        gotoRoleManagePage();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("30OU03frame")));
//        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
//        Thread.sleep(1000);
//        JSONObject querycontent = new JSONObject();
//        querycontent.put("name","角色");
//        AngularScope.setData(driver,"document.getElementsByClassName('panel panel-default')","querycontent",querycontent);
//        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'query()')]"))).perform();
//        Thread.sleep(3000);
//        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'deleteRole(e.id)')]")).get(0)).perform();
//        Thread.sleep(3000);
//        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
//        Thread.sleep(3000);
//        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
//        Thread.sleep(3000);
//    }
}
