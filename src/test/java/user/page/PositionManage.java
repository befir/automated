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

public class PositionManage extends PageAutomatedTest {

    @Test
    public void gotoPositionManagePage() throws InterruptedException {
        driverQuite = true;
        driverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("全渠道")));
        driver.findElement(By.linkText("全渠道")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("用户中心")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("用户中心")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("用户中心").xpath("//span[text()='岗位管理']")));
        List<WebElement> elements = driver.findElement(By.linkText("用户中心")).findElements(By.xpath("//span[text()='岗位管理']"));
        for(WebElement element:elements){
            if(element.isDisplayed()){
                element.click();
                break;
            }
        }
    }
    //新增岗位
    @Test(dependsOnMethods = {"gotoPositionManagePage"})
    public void addPosition() throws InterruptedException {
        gotoPositionManagePage();
        Actions action =new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.id("30OU06frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'cleanData()')]"))).perform();
        JSONObject addDTO = new JSONObject();
        addDTO.put("positionCode",dateFormat.format(new Date()));
        addDTO.put("positionName",dateFormat.format(new Date()));
        addDTO.put("positionDesc","岗位描述"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('formT')","addDTO",addDTO);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'savePosition()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(5000);
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
    }
    //编辑岗位
    @Test(dependsOnMethods = {"addPosition"})
    public void editPosition() throws InterruptedException {
//        String unitId = "treeDemo_9_span";
//        gotoPositionManagePage();
////        WebDriver webDriver = new ChromeDriver();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("30OU06frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'query()')]")).get(0)).perform();
        Thread.sleep(1000);
        //选择第九个部门进行选中
        action.click(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'editData(e)')]"))).perform();
        JSONObject mdfposition = new JSONObject();
        mdfposition.put("positionCode",dateFormat.format(new Date()));
        mdfposition.put("positionName",dateFormat.format(new Date()));
        mdfposition.put("positionDesc","岗位描述+"+dateFormat.format(new Date()));
        AngularScope.appendData(driver,"document.getElementById('formM')","mdfposition",mdfposition);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'updatePosition()')]"))).perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(5000);
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
    }
    //查询岗位
    @Test(dependsOnMethods = {"editPosition"})
    public void getPosition() throws InterruptedException {
//        gotoPositionManagePage();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("30OU06frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        String positionName="岗位";
//        JSONObject positionName = new JSONObject();
//        positionName.put("positionName","岗位");
        AngularScope.appendData(driver,"document.getElementsByClassName('panel panel-default')","positionName",positionName);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'query()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'resetValue()')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'query()')]"))).perform();
        Thread.sleep(5000);
//        Alert alt = driver.switchTo().alert();
//        alt.accept();
    }
    //删除岗位
    @Test(dependsOnMethods = {"getPosition"})
    public void deletePosition() throws InterruptedException {
//        gotoPositionManagePage();
//        Actions action =new Actions(driver);
//        driver.switchTo().frame(driver.findElement(By.id("30OU06frame")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));
        Thread.sleep(1000);
        String positionName="岗位";
        AngularScope.appendData(driver,"document.getElementsByClassName('panel panel-default')","positionName",positionName);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'query()')]"))).perform();
        Thread.sleep(3000);
        action.click(driver.findElement(By.xpath("//button[contains(@ng-click,'editData2(e.id)')]"))).perform();
        Thread.sleep(2000);
        action.click(driver.findElements(By.xpath("//button[contains(@ng-click,'deletePosition()')]")).get(0)).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"))).perform();
        Thread.sleep(2000);
    }
}
