package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class merchantEmployee extends RestfulAutomatedTest {
    private String addEmployeeUrl = baseUrl+"/ouser-web/employee/addEmployee.do";
    private String updateEmployeeUrl = baseUrl+"/ouser-web/employee/updateEmployee.do";
    private String updateEmployeeStatusUrl = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    private String updateEmployeeStatus1Url = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    private String queryEmployeePageByIdentityTypeUrl = baseUrl+"/ouser-web/employee/queryEmployeePageByIdentityType.do";
    private String updateEmployeUrl = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    private String updateEmploye1Url = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    private String batchUpdateUserRoleUrl = baseUrl+"/ouser-web//userRole/batchUpdateUserRole.do";
    private String queryIdentityInfoUrl = baseUrl+"/ouser-web////////employee/queryIdentityInfo.do";
    private String getAuthMerchantPageUrl = baseUrl+"/back-merchant-web/api/merchant/getAuthMerchantPage.do.do";

//    @Test
////    新增商家员工
//    public void addEmployee() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"departmentId\":\"\",\"positionId\":\"\",\"identityType\":2,\"merchantId\":\"\",\"identitySubType\":\"21\",\"userName\":\"qwer\",\"mobile\":\"12345678900\",\"identityCardName\":\"姓名\",\"entityId\":\"2029080800003446\",\"entityType\":2}");
//        Object o = Ajax.post(driver,addEmployeeUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }


    @Test
//    编辑商家员工
    public void updateEmployee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userId\":1886084101000027,\"userName\":\"qwer\",\"password\":\"4d16b2b184c30edefc8479556ac52d5c\",\"identityCardName\":\"姓名1\",\"mobile\":\"12345678900\",\"email\":null,\"employeNum\":null,\"remarks\":null,\"merchantId\":null,\"isAvailable\":1,\"identityTypeCode\":null,\"identityType\":\"2\",\"identitySubType\":\"21\",\"entityType\":\"2\",\"entityId\":2029080800003446,\"entityName\":null,\"departments\":[],\"positions\":[],\"departmentId\":\"\",\"positionId\":\"\"}");
        Object o = Ajax.post(driver,updateEmployeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    停用商家员工
    public void updateEmployeeStatus() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userIds\":[1886084101000027],\"isAvailable\":0,\"identitySubTypes\":[21,30]}\n");
        Object o = Ajax.post(driver,updateEmployeeStatusUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    启用商家员工
    public void updateEmployeeStatus1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userIds\":[1886084101000027],\"isAvailable\":1,\"identitySubTypes\":[21,30]}\n");
        Object o = Ajax.post(driver,updateEmployeeStatus1Url,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    查询商家员工
    public void queryEmployeePageByIdentityType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"isAvailable\":\"\",\"departmentId\":\"\",\"positionId\":\"\",\"userName\":\"qwer\",\"currentPage\":1,\"itemsPerPage\":10,\"identitySubTypes\":[21,30],\"identityType\":\"2\"}");
        Object o = Ajax.post(driver,queryEmployeePageByIdentityTypeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    批量启用商家员工
    public void updateEmploye() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userIds\":[\"1886083701000156\",\"1886081501000062\",\"1886080902000010\",\"1886080801000067\",\"1886080801000009\"],\"isAvailable\":1,\"identitySubTypes\":[20]}");
        Object o = Ajax.post(driver,updateEmployeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    批量禁用商家员工
    public void updateEmploye1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userIds\":[\"1886083701000156\",\"1886081501000062\",\"1886080902000010\"],\"isAvailable\":0,\"identitySubTypes\":[20]}");
        Object o = Ajax.post(driver,updateEmploye1Url,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    商家员工分配功能权限
    public void batchUpdateUserRole() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userId\":1886083701000156,\"roleList\":[18101517160182],\"delRoleList\":[18101517160181,1886080802000060]}");
        Object o = Ajax.post(driver,batchUpdateUserRoleUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    商家员工分配数据权限
    public void queryIdentityInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"itemsPerPage\":1000,\"currentPage\":1,\"checked\":true,\"isSystem\":false,\"userId\":\"1886083701000156\",\"merchantIds\":[\"2029083000006437\"]}");
        Object o = Ajax.post(driver,queryIdentityInfoUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    查询商家员工授权商家
    public void getAuthMerchantPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"itemsPerPage\":500,\"currentPage\":1}");
        Object o = Ajax.post(driver,getAuthMerchantPageUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

}
