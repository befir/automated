package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuideUserManage extends RestfulAutomatedTest {

    //查询岗位信息
    private String queryPositionServiceUrl = baseUrl+"/ouser-web/position/queryPositionList.do";
    //查询导购员
    private String queryGuideUserServiceUrl = baseUrl+"/ouser-web/employee/queryGuideUserPage.do.do";
    //查询可分配的角色
    private String queryRoleServiceUrl = baseUrl+"/ouser-web//user/queryRoleToOperate.do";
    //查询已分配的角色
    private String getAllUserRoleServiceUrl = baseUrl+"/ouser-web//function/getAllUserFunctionByRoleIds.do";
    //修改用户角色
    private String UpdateUserRoleServiceUrl = baseUrl+"/ouser-web//userRole/batchUpdateUserRole.do";
    @Test
    public void queryPosition() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":99999,\"entityIds\":[2029080800000000,2029080800003446,2029080902003474,2029081400000365,2029081500000037,2029081600000006,2029081600000008,2029081600000010,2029081600000012,2029081600000014]}");
        Object o = Ajax.post(driver,queryPositionServiceUrl,param);
        //断言code
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test//(dependsOnMethods = {"queryPosition"})
    public void queryGuideUser() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryGuideUserServiceUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        JSONObject expectedResult = JSON.parseObject("{\"gitVersion\":{\"git.branch\":\"back-merchant-web-d-2.3.15\",\"git.commit.id\":\"fcd288a5f29b4a62fc0b8beb4ab9549fee28c54e\"},\"data\":{\"total\":1,\"listObj\":[{\"id\":2029080803000006,\"unitName\":\"文心阁核算\",\"unitCode\":\"SJX0001\"}]},\"code\":\"0\"}");
        JSONObject expectedData = JSON.parseObject("{\"total\":19,\"listObj\":[{\"startItem\":0,\"entityId\":2029080800000000,\"isAvailable\":1,\"identitySubType\":20,\"identityCardName\":\"可口可乐\",\"username\":\"kekoukele\",\"userId\":1886080801000009,\"currentPage\":0,\"employeNum\":\"11234562\",\"itemsPerPage\":0,\"mobile\":\"12345678901\"},{\"startItem\":0,\"positionCode\":\"002\",\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":30,\"identityCardName\":\"kkkldp001\",\"username\":\"kkkldp001\",\"userId\":1886080901000023,\"currentPage\":0,\"positionName\":\"导购员\",\"employeNum\":\"10056\",\"itemsPerPage\":0,\"mobile\":\"12010000000\"},{\"startItem\":0,\"positionCode\":\"002\",\"entityId\":2029080800000000,\"isAvailable\":1,\"identitySubType\":21,\"identityCardName\":\"kkklyg001\",\"username\":\"kkklyg001\",\"userId\":1886080901000029,\"currentPage\":0,\"positionName\":\"导购员\",\"employeNum\":\"1005\",\"itemsPerPage\":0,\"mobile\":\"12010000001\"},{\"startItem\":0,\"entityId\":2029080800000000,\"isAvailable\":1,\"identitySubType\":21,\"identityCardName\":\"kkklyg001\",\"username\":\"kkklyg001\",\"userId\":1886080901000029,\"currentPage\":0,\"employeNum\":\"1005\",\"itemsPerPage\":0,\"mobile\":\"12010000001\"},{\"startItem\":0,\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"kkkldpyg001\",\"username\":\"kkkldpyg001\",\"userId\":1886081701000073,\"currentPage\":0,\"itemsPerPage\":0,\"mobile\":\"12010000031\"},{\"startItem\":0,\"entityId\":2029080800000013,\"isAvailable\":1,\"identitySubType\":30,\"identityCardName\":\"12010000022\",\"username\":\"12010000022\",\"userId\":1886082002000235,\"currentPage\":0,\"itemsPerPage\":0,\"mobile\":\"12010000022\"},{\"startItem\":0,\"entityId\":2029080800000013,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"12010000023\",\"username\":\"12010000023\",\"userId\":1886082002000270,\"currentPage\":0,\"itemsPerPage\":0,\"mobile\":\"12010000023\"},{\"startItem\":0,\"positionCode\":\"002\",\"entityId\":2029080800000013,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"12010000023\",\"username\":\"12010000023\",\"userId\":1886082002000270,\"currentPage\":0,\"positionName\":\"导购员\",\"itemsPerPage\":0,\"mobile\":\"12010000023\"},{\"startItem\":0,\"entityId\":2029080800000000,\"isAvailable\":1,\"identitySubType\":21,\"identityCardName\":\"12010000023\",\"username\":\"12010000023\",\"userId\":1886082002000270,\"currentPage\":0,\"itemsPerPage\":0,\"mobile\":\"12010000023\"},{\"startItem\":0,\"positionCode\":\"002\",\"entityId\":2029080800000000,\"isAvailable\":1,\"identitySubType\":21,\"identityCardName\":\"12010000023\",\"username\":\"12010000023\",\"userId\":1886082002000270,\"currentPage\":0,\"positionName\":\"导购员\",\"itemsPerPage\":0,\"mobile\":\"12010000023\"},{\"startItem\":0,\"positionCode\":\"002\",\"entityId\":2029080800000000,\"isAvailable\":1,\"identitySubType\":21,\"identityCardName\":\"12010000024\",\"username\":\"12010000024\",\"userId\":1886082103000253,\"currentPage\":0,\"positionName\":\"导购员\",\"itemsPerPage\":0,\"mobile\":\"12010000024\"},{\"startItem\":0,\"entityId\":2029080800000000,\"isAvailable\":1,\"identitySubType\":21,\"identityCardName\":\"12010000024\",\"username\":\"12010000024\",\"userId\":1886082103000253,\"currentPage\":0,\"itemsPerPage\":0,\"mobile\":\"12010000024\"},{\"startItem\":0,\"positionCode\":\"002\",\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"12010000024\",\"username\":\"12010000024\",\"userId\":1886082103000253,\"currentPage\":0,\"positionName\":\"导购员\",\"itemsPerPage\":0,\"mobile\":\"12010000024\"},{\"startItem\":0,\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"12010000024\",\"username\":\"12010000024\",\"userId\":1886082103000253,\"currentPage\":0,\"itemsPerPage\":0,\"mobile\":\"12010000024\"},{\"startItem\":0,\"positionCode\":\"002\",\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"kkklyg001\",\"username\":\"kkklyg001\",\"userId\":1886080901000029,\"currentPage\":0,\"positionName\":\"导购员\",\"employeNum\":\"1005\",\"itemsPerPage\":0,\"mobile\":\"12010000001\"},{\"startItem\":0,\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"kkklyg001\",\"username\":\"kkklyg001\",\"userId\":1886080901000029,\"currentPage\":0,\"employeNum\":\"1005\",\"itemsPerPage\":0,\"mobile\":\"12010000001\"},{\"startItem\":0,\"positionCode\":\"2333\",\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"妮妮\",\"username\":\"13761073412\",\"userId\":1886081302000193,\"currentPage\":0,\"positionName\":\"拣货员\",\"itemsPerPage\":0,\"mobile\":\"13761073412\"},{\"startItem\":0,\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"哈哈\",\"username\":\"15800525800\",\"userId\":1886082303000026,\"currentPage\":0,\"itemsPerPage\":0,\"mobile\":\"15856486446\"},{\"startItem\":0,\"positionCode\":\"2333\",\"entityId\":2029080800000008,\"isAvailable\":1,\"identitySubType\":31,\"identityCardName\":\"呵呵\",\"username\":\"15800536987\",\"userId\":1886082401000430,\"currentPage\":0,\"positionName\":\"拣货员\",\"itemsPerPage\":0,\"mobile\":\"15800569874\"}]}");

        Assert.assertEquals(actualResult.get("data"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }
    @Test//(dependsOnMethods = {"queryGuideUser"})
    public void queryRole() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"1886080801000009\",\"entityId\":\"2029080800000000\",\"platformId\":5}");
        Object o = Ajax.post(driver,queryRoleServiceUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        JSONObject expectedResult = JSON.parseObject("{\"gitVersion\":{\"git.branch\":\"back-merchant-web-d-2.3.15\",\"git.commit.id\":\"fcd288a5f29b4a62fc0b8beb4ab9549fee28c54e\"},\"data\":{\"total\":1,\"listObj\":[{\"id\":2029080803000006,\"unitName\":\"文心阁核算\",\"unitCode\":\"SJX0001\"}]},\"code\":\"0\"}");
        JSONObject expectedData = JSON.parseObject("{\"userObj\":{\"type\":3,\"password\":\"6121518c5a58409da2bcd3372b18e8e3\",\"isAvailable\":1,\"orgId\":1886080801000003,\"bSaltUpdateTime\":1542858998000,\"cipherMobile\":\"@%^*qlFuzoD+aEMZscuQ7Cl/6g==\",\"username\":\"kekoukele\",\"bSalt\":\"cscid4fd$u\",\"updateTime\":1539739964000,\"status\":1,\"email\":\"1112@qq.com\",\"mobile\":\"12345678901\",\"bAlgorithmVersion\":1,\"createTime\":1539739964000,\"birthday\":1538438400000,\"sex\":1,\"remarks\":\"0102132\",\"id\":1886080801000009,\"identityCardName\":\"可口可乐\",\"lastLoginIp\":\"172.16.3.31\",\"employeNum\":\"11234562\",\"lastLoginTime\":1539740754000,\"itemsPerPage\":0,\"startItem\":0,\"headPicUrl\":\"http://ody.cdn.oudianyun.com/saas/1470054335227_8.213774587623634_me@2x.png\",\"orgName\":\"行政\",\"isDeleted\":0,\"companyId\":231,\"currentPage\":0},\"roleList\":[],\"ownRoleList\":[{\"id\":1886083001000532,\"name\":\"导购员角色\",\"itemsPerPage\":0,\"startItem\":0,\"code\":\"DGY01\",\"currentPage\":0}]}");

        Assert.assertEquals(actualResult.get("data"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }
    @Test//(dependsOnMethods = {"queryRole"})
    public void getAllUserRole() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"roleIds\":[1886083001000532]}");
        Object o = Ajax.post(driver,getAllUserRoleServiceUrl,param);
        //断言code
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test//(dependsOnMethods = {"getAllUserRole"})
    public void UpdateUserRole() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userId\":1886080801000009,\"roleList\":[1886083001000532],\"delRoleList\":[]}");
        Object o = Ajax.post(driver,UpdateUserRoleServiceUrl,param);
        //断言code
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
}
