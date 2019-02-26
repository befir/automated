package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class employeejingxiao extends RestfulAutomatedTest {
    private String addEmployeeUrl = baseUrl+"/ouser-web/employee/addEmployee.do";
    private String getDistributorByMerchantUrl = baseUrl+"/back-merchant-web/api/merchant/getDistributorByMerchant.do";
    private String updateEmployeeStatusUrl = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    private String updateEmployeeStatus1Url = baseUrl+"/ouser-web/employee/updateEmployeeStatus.do";
    private String updateEmployeeUrl = baseUrl+"/ouser-web/employee/updateEmployee.do";





    @Test
//    新增经销商账号
    public void addEmployee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"departmentId\":\"\",\"positionId\":\"\",\"identityType\":4,\"entityId\":\"2076084401000061\",\"identitySubType\":41,\"userName\":\"1111\",\"identityCardName\":\"经销商1111\",\"mobile\":\"12345678905\",\"entityType\":4}");
        Object o = Ajax.post(driver,addEmployeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//   根据商家查询经销商账号
    public void getDistributorByMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgType\":4,\"itemsPerPage\":500,\"currentPage\":1,\"merchantId\":\"2076083702000036\"}");
        Object o = Ajax.post(driver,getDistributorByMerchantUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//   停用经销商账号
    public void updateEmployeeStatus() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userIds\":[1984084400000401],\"isAvailable\":0,\"identitySubTypes\":[41]}");
        Object o = Ajax.post(driver,updateEmployeeStatusUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//  启用经销商账号
    public void updateEmployeeStatus1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userIds\":[1984084400000401],\"isAvailable\":1,\"identitySubTypes\":[41]}");
        Object o = Ajax.post(driver,updateEmployeeStatus1Url,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//  编辑经销商账号
    public void updateEmployee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userId\":1984084400000401,\"userName\":\"1111\",\"password\":\"73be7588c0e118cc45796b242ae05a16\",\"identityCardName\":\"经销商11111\",\"mobile\":\"12345678905\",\"email\":null,\"employeNum\":null,\"remarks\":null,\"merchantId\":null,\"isAvailable\":1,\"identityTypeCode\":null,\"identityType\":\"4\",\"identitySubType\":\"41\",\"entityType\":\"4\",\"entityId\":2076084401000061,\"entityName\":null,\"departments\":[],\"positions\":[],\"departmentId\":\"\",\"positionId\":\"\"}");
        Object o = Ajax.post(driver,updateEmployeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }








}
