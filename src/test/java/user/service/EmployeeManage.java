package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class EmployeeManage extends RestfulAutomatedTest {

    //获取可分配的部门
    private String getCurrentServiceUrl1 = baseUrl+"/ouser-web/org/getCurrentOrg.do";
    //获取可分配的岗位
    private String queryPositionServiceUrl1 = baseUrl+"/ouser-web/position/queryPositionList.do";
    //查询运营账号列表
    private String queryEmployeePageByIdServiceUrl1 = baseUrl+"/ouser-web/employee/queryEmployeePageByIdentityType.do";
//    //查询
//    private String queryEmployeeServiceUrl = baseUrl+"/ouser-web/employee/queryEmployeeIdentity.do";
    //新增运营账号
    private String addEmployeeServiceUrl = baseUrl+"/ouser-web/employee/addEmployee.do";
    //修改运营账号信息
    private String updateEmployeeServiceUrl = baseUrl+"/ouser-web/employee/updateEmployee.do";
    //重置运营账号密码
    private String resetPasswordStatusServiceUrl = baseUrl+"/ouser-web///employee/resetPassword.do";
    //启用、停用运营账号
    private String updateEmployeeStatusServiceUrl = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    //获取运营平台可以分配的角色
    private String queryRoleServiceUrl = baseUrl+"/ouser-web//user/queryRoleToOperate.do";
    //获取当前账号已分配的角色
    private String getAllUserStatusServiceUrl = baseUrl+"/ouser-web//function/getAllUserFunctionByRoleIds.do";
    //修改运营账号已分配的角色
    private String UpdateUserRoleStatusServiceUrl = baseUrl+"/ouser-web//userRole/batchUpdateUserRole.do";

    @Test
    public void getCurrentServiceUrl1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,getCurrentServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryPositionServiceUrl1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"entityType\":1,\"currentPage\":1,\"itemsPerPage\":500}");
        Object o = Ajax.post(driver,queryPositionServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryEmployeePageByIdServiceUrl1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"identitySubTypes\":[11],\"identityType\":\"1\"}");
        Object o = Ajax.post(driver,queryEmployeePageByIdServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
//    @Test
//    public void queryEmployee() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{}");
//        Object o = Ajax.post(driver,queryEmployeeServiceUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
//    @Test
//    public void addEmployeeServiceUrl() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"departmentId\":\"\",\"positionId\":\"\",\"identityType\":1,\"merchantId\":\"\",\"identitySubType\":11,\"userName\":\"\",\"identityCardName\":\"\",\"mobile\":\"\",\"entityType\":1}");
//        param.put("departmentId","");
//        param.put("positionId","");
//        param.put("userName","");
//        param.put("identityCardName","");
//        param.put("mobile","");
//        param.put("departmentId","");
//        Object o = Ajax.post(driver,addEmployeeServiceUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
    @Test
    public void updateEmployeeServiceUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"departmentId\":\"\",\"positionId\":\"\",\"identityType\":1,\"merchantId\":\"\",\"identitySubType\":11,\"userName\":\"\",\"identityCardName\":\"\",\"mobile\":\"\",\"entityType\":1}");
        param.put("departmentId","");
        param.put("positionId","");
        param.put("userName","");
        param.put("identityCardName","");
        param.put("mobile","");
        param.put("departmentId","");
        Object o = Ajax.post(driver,updateEmployeeServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateEmployeeStatus() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userIds\":[1886083001000151],\"isAvailable\":1,\"identitySubTypes\":[11]}");
        Object o = Ajax.post(driver,updateEmployeeStatusServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void resetPassword() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userId\":1886083001000151,\"userName\":\"test03\",\"password\":\"9700ab3f5f25a71477a1bb862db60144\",\"identityCardName\":\"test03\",\"mobile\":\"12010001001\",\"email\":null,\"employeNum\":null,\"remarks\":null,\"merchantId\":null,\"isAvailable\":0,\"identityTypeCode\":null,\"identityType\":\"1\",\"identitySubType\":\"11\",\"entityType\":\"1\",\"entityId\":0,\"entityName\":null,\"departments\":[\"1886080802000061\"],\"positions\":[\"1886081004000109\"],\"departmentId\":\"1886080802000061\",\"positionId\":\"1886081004000109\"}");
        Object o = Ajax.post(driver,resetPasswordStatusServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryRoleServiceUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"1886083001000151\",\"identityType\":\"1\",\"platformId\":1}");
        Object o = Ajax.post(driver,queryRoleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getAllUserStatusServiceUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"roleIds\":[]}");
        Object o = Ajax.post(driver,getAllUserStatusServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void UpdateUserRoleStatusServiceUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userId\":1886083001000151,\"roleList\":[1886080802000007],\"delRoleList\":[18101517160128,1886081901000109,1886082106000447,1886082307000010,1886083401000648,1886083401000695]}");
        Object o = Ajax.post(driver,UpdateUserRoleStatusServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
