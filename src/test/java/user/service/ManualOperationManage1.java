package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class ManualOperationManage1 extends RestfulAutomatedTest {

    //查询成长值人工作业
    private String queryPointsRuleServiceUrl = baseUrl+"/ouser-center/balence/queryManualOperationAll.do";
    //查询平台渠道
    private String queryChannelServiceUrl = baseUrl+"/ouser-web/api/channel/queryChannelMap.do";
    //获取会员选择列表
    private String getUserServiceUrl = baseUrl+"/ouser-center/user/searchUserIdentityInfoList.do";
    //新增成长值人工作业
    private String addPointsRuleServiceUrl = baseUrl+"/ouser-center/balence/addManualOperation.do";

    @Test
    public void queryPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"businessTypes\":[\"1\",\"2\",\"3\",\"4\"]}");
        Object o = Ajax.post(driver,queryPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryChannel() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryChannelServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getUser() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"identityTypeCodeList\":[4,41,42,43,44,45],\"limit\":10,\"offset\":0,\"memberTypeList\":[1015,1014,1013,1012,1011,1010,1009,1008,1007,1006,1005,1004,1003,1002,1001]}");
        Object o = Ajax.post(driver,getUserServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"opeObjs\":[{\"userId\":\"1886080801000009\",\"username\":\"kekoukele\"}],\"opeObj\":\"1886080801000009\",\"growthType\":\"1\",\"changeAmount\":\"1\",\"channelCode\":\"110001\",\"opeReason\":\"3\"}");
//        param.put("userId","1886080801000009");
//        param.put("opeObj","1886080801000009");
//        param.put("channelCode",110001);
//        param.put("opeReason",1);
        Object o = Ajax.post(driver,addPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
