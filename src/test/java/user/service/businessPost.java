package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class businessPost extends RestfulAutomatedTest {
   //请求岗位列表
    private String queryPositionListUrl = baseUrl+"/ouser-web/position/queryPositionList.do";
    //请求岗位名称
    private String queryPositionByNameUrl = baseUrl+"/ouser-web/position/queryPositionByName.do";
    //新增岗位
    private String addPositionUrl = baseUrl+"/ouser-web/position/addPosition.do";
    //是否有权限
    private String isAuthorityUrl = baseUrl+"/ouser-web/user/isAuthority.do";
    //编辑岗位
    private String updatePositionUrl = baseUrl+"/ouser-web/position/updatePosition.do";
    //删除岗位
    private String deletePositionUrl = baseUrl+"/ouser-web/position/deletePosition.do";
    @Test
    public void queryPositionList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryPositionListUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryPositionByName() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"positionName\": \"UI\",\n" +
                "\t\"positionCode\": \"111301\",\n" +
                "\t\"entityId\": 2029080800003446,\n" +
                "\t\"positionDesc\": \"正经岗位\",\n" +
                "\t\"entityType\": \"2\"\n" +
                "}");
        Object o = Ajax.post(driver,queryPositionByNameUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addPosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"positionName\": \"UI\",\n" +
                "\t\"positionCode\": \"111301\",\n" +
                "\t\"entityId\": 2029080800003446,\n" +
                "\t\"positionDesc\": \"正经岗位\",\n" +
                "\t\"entityType\": \"2\"\n" +
                "}");
        Object o = Ajax.post(driver,addPositionUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void isAuthority() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"path\": \"/user/isAuthorityPosition.do\"\n" +
                "}");
        Object o = Ajax.post(driver,isAuthorityUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updatePosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"id\": 1886083501000253,\n" +
                "\t\"positionName\": \"UI\",\n" +
                "\t\"positionCode\": \"111301\",\n" +
                "\t\"entityId\": 2029080800003446,\n" +
                "\t\"positionDesc\": \"正经岗位01\",\n" +
                "\t\"entityType\": \"2\"\n" +
                "}");
        Object o = Ajax.post(driver,updatePositionUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void deletePosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"id\": 1886083501000253\n" +
                "}");
        Object o = Ajax.post(driver,deletePositionUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


}
