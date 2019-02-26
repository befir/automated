package user.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;


//店铺员工
public class Type extends RestfulAutomatedTest {
//
    //编辑员工
    private String updateEmployeeurl =  baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    //停用
    private String queryEmployeePageByIdentityTypeurl = baseUrl+"/ouser-web/employee/queryEmployeePageByIdentityType.do";
    //查询员工
    private String queryEmployeePageByIdentityTypeUrl = baseUrl+"/ouser-web/employee/queryEmployeePageByIdentityType.do";
    //功能权限
    private String queryRoleToOperateurl = baseUrl+"/ouser-web//user/queryRoleToOperate.do";
    //数据权限
    private String queryIdentityInfo = baseUrl+"/ouser-web//employee/queryIdentityInfo.do";





    //编辑员工
    @Test
    public void updateEmployeeurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"userIds\": [2029080900000043],\n" +
                "\t\"isAvailable\": 0,\n" +
                "\t\"identitySubTypes\": [21, 30]\n" +
                "}");
        Object o = Ajax.post(driver, updateEmployeeurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        //断言
        String expectedcode2 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode2);
        System.out.println(JSON.toJSONString(o));
    }
    //停用
    @Test
    public void queryEmployeePageByIdentityTypeurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"identitySubTypes\":[31],\"identityType\":\"31\"}");
        Object o = Ajax.post(driver, queryEmployeePageByIdentityTypeurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
////断言code
        String expectedcode2 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode2);
        System.out.println(JSON.toJSONString(o));
    }

    //查询员工
    @Test
    public void queryEmployeePageByIdentityTypeUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"isAvailable\":\"1\",\"departmentId\":\"\",\"positionId\":\"1984085600009723\",\"userName\":\"123456\",\"identityCardName\":\"123456\",\"employeNum\":\"123456\",\"mobile\":\"12345678954\",\"currentPage\":1,\"itemsPerPage\":10,\"identitySubTypes\":[31],\"identityType\":\"31\"}");
        Object o = Ajax.post(driver, queryEmployeePageByIdentityTypeUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
////断言Code
        String expectedcode3 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode3);
        System.out.println(JSON.toJSONString(o));
    }

    //功能权限
    @Test
    public void  queryRoleToOperateurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"1886083001000151\",\"identityType\":\"1\",\"platformId\":1}");
        Object o = Ajax.post(driver,queryRoleToOperateurl , param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
  //        断言code
        String expectedcode3 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode3);
        System.out.println(JSON.toJSONString(o));

    }

    //数据权限
     @Test
    public void queryIdentityInfo  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"itemsPerPage\":1000,\"currentPage\":1,\"checked\":true,\"isSystem\":false,\"userId\":\"1984085600003459\",\"merchantIds\":[\"2076085201000114\"]}");
        Object o = Ajax.post(driver, queryIdentityInfo, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code
       String expectedcode3 = "0";
       Assert.assertEquals(actualResult.get("code"),expectedcode3);
        System.out.println(JSON.toJSONString(o));

   }}


