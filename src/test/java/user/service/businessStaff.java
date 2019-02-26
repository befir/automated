package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class businessStaff extends RestfulAutomatedTest {
    //请求员工列表
    private String queryEmployeePageByIdentityTypeUrl = baseUrl+"/ouser-web/employee/queryEmployeePageByIdentityType.do";
    //新增员工
    private String addEmployeeUrl = baseUrl+"/ouser-web/employee/addEmployee.do";
    //更新员工状态
    private String updateEmployeeStatusUrl = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    //更新员工信息
    private String updateEmployeeUrl = baseUrl+"ouser-web/employee/updateEmployee.do";
    //分配功能权限
    private String getAllUserFunctionByRoleIdsUrl = baseUrl+"/ouser-web//function/getAllUserFunctionByRoleIds.do";
   //更新功能权限
    private String batchUpdateUserRoleUrl = baseUrl+"/ouser-web//userRole/batchUpdateUserRole.do";
    //获取当前文件
    private String getCurrentOrgUrl = baseUrl+"/ouser-web///org/getCurrentOrg.do";
    //保存数据权限分配
    private String batchUpdateVisitControlInfoUrl = baseUrl+"/back-merchant-web/orgUserAuthoAction/batchUpdateVisitControlInfo.do";
    //重置密码
    private String resetPasswordUrl = baseUrl+"/ouser-web/////employee/resetPassword.do";
    //请求店铺组织
    private String queryStoreOrgPageByAuthUrl = baseUrl+"/back-merchant-web/api/store/queryStoreOrgPageByAuth.do";

    @Test
    public void queryEmployeePageByIdentityType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"isAvailable\": \"\",\n" +
                "\t\"departmentId\": \"\",\n" +
                "\t\"positionId\": \"\",\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"identitySubTypes\": [21, 30],\n" +
                "\t\"identityType\": \"2\"\n" +
                "}");
        Object o = Ajax.post(driver,queryEmployeePageByIdentityTypeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
//    @Test
//    public void addEmployee() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\n" +
//                "\t\"departmentId\": \"\",\n" +
//                "\t\"positionId\": \"\",\n" +
//                "\t\"identityType\": 2,\n" +
//                "\t\"merchantId\": \"\",\n" +
//                "\t\"identitySubType\": \"21\",\n" +
//                "\t\"userName\": \"100\",\n" +
//                "\t\"identityCardName\": \"张三\",\n" +
//                "\t\"mobile\": \"12100010001\",\n" +
//                "\t\"entityId\": \"2029080800003446\",\n" +
//                "\t\"entityType\": 2\n" +
//                "}");
//        Object o = Ajax.post(driver,addEmployeeUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }

    @Test
    public void updateEmployeeStatus() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"userIds\": [2029080900000043],\n" +
                "\t\"isAvailable\": 0,\n" +
                "\t\"identitySubTypes\": [21, 30]\n" +
                "}");
        Object o = Ajax.post(driver,updateEmployeeStatusUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void updateEmployee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"userId\": 2029080900000043,\n" +
                "\t\"userName\": \"100\",\n" +
                "\t\"password\": \"0ddd4bd6620f5d43d1b6494e5f5911d3\",\n" +
                "\t\"identityCardName\": \"张三三\",\n" +
                "\t\"mobile\": \"12100010001\",\n" +
                "\t\"email\": null,\n" +
                "\t\"employeNum\": null,\n" +
                "\t\"remarks\": null,\n" +
                "\t\"merchantId\": null,\n" +
                "\t\"isAvailable\": 0,\n" +
                "\t\"identityTypeCode\": null,\n" +
                "\t\"identityType\": \"2\",\n" +
                "\t\"identitySubType\": \"21\",\n" +
                "\t\"entityType\": \"2\",\n" +
                "\t\"entityId\": 2029080800003446,\n" +
                "\t\"entityName\": null,\n" +
                "\t\"departments\": [],\n" +
                "\t\"positions\": [],\n" +
                "\t\"departmentId\": \"\",\n" +
                "\t\"positionId\": \"\"\n" +
                "}");
        Object o = Ajax.post(driver,updateEmployeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getAllUserFunctionByRoleIds() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"roleIds\": [1886081302000360]\n" +
                "}");
        Object o = Ajax.post(driver,getAllUserFunctionByRoleIdsUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void batchUpdateUserRole() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"userId\": 2029080900000043,\n" +
                "\t\"roleList\": [1886081302000360],\n" +
                "\t\"delRoleList\": []\n" +
                "}");
        Object o = Ajax.post(driver,batchUpdateUserRoleUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
     @Test
    public void getCurrentOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,getCurrentOrgUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void batchUpdateVisitControlInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"userId\": \"2029080900000043\",\n" +
                "\t\"orgInfoList\": [],\n" +
                "\t\"orgType\": 2,\n" +
                "\t\"orgIds\": [2, 2029080801000007, 2029080803000000, 2029081000000000, 2029081300000531, 2029081400000013, 2029083600000012, 3, 2029083400000176, 2029080801000004]\n" +
                "}");
        Object o = Ajax.post(driver,batchUpdateVisitControlInfoUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
//    @Test
//    public void resetPasswordUrl() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\n" +
//                "\t\"userId\": 2029080900000043,\n" +
//                "\t\"userName\": \"100\",\n" +
//                "\t\"password\": \"0ddd4bd6620f5d43d1b6494e5f5911d3\",\n" +
//                "\t\"identityCardName\": \"张三三\",\n" +
//                "\t\"mobile\": \"12100010001\",\n" +
//                "\t\"email\": null,\n" +
//                "\t\"employeNum\": null,\n" +
//                "\t\"remarks\": null,\n" +
//                "\t\"merchantId\": null,\n" +
//                "\t\"isAvailable\": 1,\n" +
//                "\t\"identityTypeCode\": null,\n" +
//                "\t\"identityType\": \"2\",\n" +
//                "\t\"identitySubType\": \"21\",\n" +
//                "\t\"entityType\": \"2\",\n" +
//                "\t\"entityId\": 2029080800003446,\n" +
//                "\t\"entityName\": null,\n" +
//                "\t\"departments\": [],\n" +
//                "\t\"positions\": [],\n" +
//                "\t\"departmentId\": \"\",\n" +
//                "\t\"positionId\": \"\"\n" +
//                "}");
//        Object o = Ajax.post(driver,resetPasswordUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
    @Test
    public void queryStoreOrgPageByAuth() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"itemsPerPage\": 1000,\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"checked\": false,\n" +
                "\t\"isSystem\": false,\n" +
                "\t\"userId\": \"2029080900000043\",\n" +
                "\t\"merchantIds\": [\"2029080800003446\"],\n" +
                "\t\"merchantId\": \"2029080800003446\"\n" +
                "}");
        Object o = Ajax.post(driver,queryStoreOrgPageByAuthUrl,param);
        System.out.println(JSON.toJSONString(o));
    }



}
