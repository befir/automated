package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class PositionManage extends RestfulAutomatedTest {

    //查询岗位
    private String queryPositionServiceUrl = baseUrl+"/ouser-web/position/queryPositionList.do";
    //新增岗位
    private String addPositionServiceUrl = baseUrl+"/ouser-web/position/addPosition.do";
    //编辑岗位
    private String editPositionServiceUrl = baseUrl+"/ouser-web/position/updatePosition.do";
    //删除岗位
    private String deletePositionServiceUrl = baseUrl+"/ouser-web/position/deletePosition.do";
    @Test
    public void queryPosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"createTimeStart\":\"\",\"createTimeEnd\":\"\",\"currentPage\":1,\"itemsPerPage\":10,\"entityType\":\"\"}");
        param.put("entityType",1);//1：运营平台   2：商家平台
        Object o = Ajax.post(driver,queryPositionServiceUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);

    }
    @Test
    public void addPosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"positionName\":\"11\",\"positionCode\":\"12\",\"positionDesc\":\"13\",\"entityType\":\"1\"}");
        param.put("entityType",1);//1：运营平台   2：商家平台
        param.put("positionCode",dateFormat.format(new Date()));
        param.put("positionName","岗位"+dateFormat.format(new Date()));
        param.put("positionDesc","岗位描述"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addPositionServiceUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test
    public void editPosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"positionName\":\"\",\"positionCode\":\"\",\"positionDesc\":\"\",\"entityType\":\"1\"}");
        param.put("entityType",1);//1：运营平台   2：商家平台
        param.put("id","1886081901000099");
        param.put("positionCode","20181028142708");
        param.put("positionName","岗位"+dateFormat.format(new Date()));
        param.put("positionDesc","岗位描述"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,editPositionServiceUrl,param);

        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test
    public void deletePosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\"}");
        param.put("id","1886081901000099");
        Object o = Ajax.post(driver,deletePositionServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
}
