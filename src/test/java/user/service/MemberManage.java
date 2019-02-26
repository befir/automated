package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MemberManage extends RestfulAutomatedTest {

    //查询会员列表
    private String queryMemberServiceUrl1 = baseUrl+"/ouser-center/member/queryMemberList.do";
    //新增会员账号
    private String addMemberServiceUrl = baseUrl+"/ouser-center/user/addOneUser.do";
    //启用停用会员账号
    private String openMemberServiceUrl = baseUrl+"/ouser-center//userInfoAction/updateUserStatus.do";

    @Test
    public void queryMember() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryMemberServiceUrl1,param);
        //断言code
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test
    public void openMember() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"userId\":2029080900000072,\"status\":1}");
        Object o = Ajax.post(driver,openMemberServiceUrl,param);
        //断言code
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
//    @Test
//    public void addMember() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"mobile\":\"\",\"identityCardName\":\"\",\"email\":\"\"}");
//        param.put("mobile","15801904143");
//        param.put("identityCardName","楚阳");
//        param.put("email","123@qq.com");
//        Object o = Ajax.post(driver,addMemberServiceUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
}
