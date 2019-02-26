package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class PointsRuleManage extends RestfulAutomatedTest {

    //查询积分规则
    private String queryPointsRuleServiceUrl = baseUrl+"/ouser-center/pointsRuleAction/queryPointsRuleList.do";
    //获取渠道信息
    private String queryChannelMap = baseUrl+"/ouser-web/api/channel/queryChannelMap.do";
    //新增消费送积分规则
    private String addPointsRuleServiceUrl = baseUrl+"/ouser-center/pointsRuleNewAction/addNewRule.do";
    //新增注册送积分规则
    private String addPointsRuleServiceUrl1 = baseUrl+"/ouser-center/pointsRuleAction/savePointsRule.do";
    //新增完善资料送积分规则
    private String addPointsRuleServiceUrl2 = baseUrl+"/ouser-center/pointsRuleAction/savePointsRule.do";
    //新增签到送积分规则
    private String addPointsRuleServiceUrl3 = baseUrl+"/ouser-center/pointsRuleAction/savePointsRule.do";
    //新增积分抵现规则
    private String addPointsRuleServiceUrl4 = baseUrl+"/ouser-center/pointsRuleAction/savePointsRule.do";
    //获取单个积分规则信息
    private String getPointsRuleServiceUrl = baseUrl+"/ouser-center/pointsRuleAction/queryPointsRuleDetail.do";
    //修改积分规则
    private String editPointsRuleServiceUrl = baseUrl+"/ouser-center/pointsRuleAction/savePointsRule.do";
    //启用停用积分规则
    private String openPointsRuleServiceUrl = baseUrl+"/ouser-center/pointsRuleAction/updatePointsRuleStatus.do";
    //删除积分规则
    private String delPointsRuleServiceUrl = baseUrl+"/ouser-center/pointsRuleAction/updatePointsRuleStatus.do";

    @Test
    public void queryPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryPointsRuleServiceUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test
    public void queryChannelMap() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryChannelMap,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
//    @Test
//    public void addPointsRule() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"memberConsumers\":[{\"memberConsumerChannelCode\":\"\",\"memberConsumerNumber\":\"\",\"memberConsumerScore\":\"\"}],\"type\":\"\",\"ruleType\":\"\",\"name\":\"\",\"list\":[]}");
//        param.put("memberConsumerChannelCode",110001);
//        param.put("memberConsumerNumber",1L);//消费金额
//        param.put("memberConsumerScore",10000);//赠送积分值
//        param.put("type",100000);
//        param.put("ruleType",101000);//积分有效期
//        param.put("name","会员消费"+dateFormat.format(new Date()));
//        Object o = Ajax.post(driver,addPointsRuleServiceUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
    @Test
    public void addPointsRule1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"serialLogin\":[],\"loginLevels\":[{\"startDay\":\"1\",\"endDay\":\"7\",\"count\":\"10\"},{\"startDay\":\"8\",\"endDay\":\"15\",\"count\":\"15\"},{\"startDay\":\"16\",\"endDay\":\"20\",\"count\":\"20\"}],\"shareProducts\":[{\"shareProductChannelCode\":\"\",\"shareProductMaxTimePerDay\":\"\",\"shareProductCntPerTime\":\"\"}],\"channelCodes\":[],\"favoCommentCnt\":10,\"ruleType\":102,\"ruleName\":\"\",\"registerCnt\":\"1\",\"type\":\"1\"}");
//        param.put("memberConsumerChannelCode",110001);
//        param.put("memberConsumerNumber",1L);//消费金额
//        param.put("memberConsumerScore",10000);//赠送积分值
//        param.put("type",100000);
//        param.put("ruleType",101000);//积分有效期
        param.put("ruleName","注册送积分"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addPointsRuleServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addPointsRule2() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"serialLogin\":[],\"loginLevels\":[{\"startDay\":\"1\",\"endDay\":\"7\",\"count\":\"10\"},{\"startDay\":\"8\",\"endDay\":\"15\",\"count\":\"15\"},{\"startDay\":\"16\",\"endDay\":\"20\",\"count\":\"20\"}],\"shareProducts\":[{\"shareProductChannelCode\":\"\",\"shareProductMaxTimePerDay\":\"\",\"shareProductCntPerTime\":\"\"}],\"channelCodes\":[],\"favoCommentCnt\":10,\"ruleType\":104,\"ruleName\":\"\",\"improveInfoCnt\":\"1\",\"type\":\"1\"}");
//        param.put("memberConsumerChannelCode",110001);
//        param.put("memberConsumerNumber",1L);//消费金额
//        param.put("memberConsumerScore",10000);//赠送积分值
//        param.put("type",100000);
//        param.put("ruleType",101000);//积分有效期
        param.put("ruleName","完善资料送积分"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addPointsRuleServiceUrl2,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addPointsRule3() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"serialLogin\":[],\"loginLevels\":[{\"startDay\":\"1\",\"endDay\":\"2\",\"count\":\"1\"},{\"startDay\":\"3\",\"endDay\":\"4\",\"count\":\"2\"},{\"startDay\":\"5\",\"endDay\":\"6\",\"count\":\"3\"}],\"shareProducts\":[{\"shareProductChannelCode\":\"\",\"shareProductMaxTimePerDay\":\"\",\"shareProductCntPerTime\":\"\"}],\"channelCodes\":[],\"favoCommentCnt\":10,\"ruleType\":101,\"ruleName\":\"\",\"loginSetupType\":\"2\",\"type\":\"1\"}");
//        param.put("memberConsumerChannelCode",110001);
//        param.put("memberConsumerNumber",1L);//消费金额
//        param.put("memberConsumerScore",10000);//赠送积分值
//        param.put("type",100000);
//        param.put("ruleType",101000);//积分有效期
        param.put("ruleName","签到送积分"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addPointsRuleServiceUrl3,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addPointsRule4() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"serialLogin\":[],\"loginLevels\":[{\"startDay\":\"1\",\"endDay\":\"7\",\"count\":\"10\"},{\"startDay\":\"8\",\"endDay\":\"15\",\"count\":\"15\"},{\"startDay\":\"16\",\"endDay\":\"20\",\"count\":\"20\"}],\"shareProducts\":[{\"shareProductChannelCode\":\"\",\"shareProductMaxTimePerDay\":\"\",\"shareProductCntPerTime\":\"\"}],\"channelCodes\":[\"110001\",\"110002\",\"110003\",\"110004\",\"120001\"],\"favoCommentCnt\":10,\"ruleType\":19,\"ruleName\":\"\",\"pointsValue\":\"10\",\"orderUpCount\":\"999999\",\"orderUpUnit\":\"point\",\"type\":\"2\"}");
//        param.put("memberConsumerChannelCode",110001);
//        param.put("memberConsumerNumber",1L);//消费金额
//        param.put("memberConsumerScore",10000);//赠送积分值
//        param.put("type",100000);
//        param.put("ruleType",101000);//积分有效期
        param.put("ruleName","积分抵现"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addPointsRuleServiceUrl4,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"1884081702000011\",\"ruleType\":\"19\"}");
//        param.put("id","1884082202000016");
//        param.put("ruleType",101000);
        Object o = Ajax.post(driver,getPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1884081702000011,\"relateId\":1540555702624,\"companyId\":231,\"type\":\"2\",\"ruleName\":\"积分抵现\",\"ruleType\":19,\"isAvailable\":-1,\"isDeleted\":0,\"basicConfig\":null,\"loginSetupType\":null,\"loginCntPerDay\":null,\"serialLogin\":null,\"loginLevels\":null,\"registerCnt\":null,\"firstBindMobileCnt\":null,\"nonFirstBindMobileCnt\":null,\"improveInfoCnt\":null,\"shareActivityMaxTimePerDay\":null,\"shareActivityCntPerTime\":null,\"setupCXHD\":null,\"setupSQHD\":null,\"shareAppMaxTimePerDay\":null,\"shareAppCntPerTime\":null,\"community\":null,\"favoCommentCnt\":null,\"favoCommentCnt2\":null,\"rewardTimesPerPiece\":null,\"rewardTimesPerPeople\":null,\"rewardCntOptions\":null,\"birthdayCnt\":null,\"pointsValue\":10,\"orderUpCount\":\"999999\",\"orderUpUnit\":\"point\",\"channelCodes\":[\"110001\",\"110002\",\"110003\",\"110004\",\"120001\"],\"shareProducts\":null}");
//        param.put("id","1884082202000016");
//        param.put("ruleType",101000);
        Object o = Ajax.post(driver,editPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void openPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1884082202000016,\"isAvailable\":\"1\",\"ruleType\":101000,\"relateId\":null}");
//        param.put("id","1884082202000016");
//        param.put("ruleType",101000);
        Object o = Ajax.post(driver,openPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void delPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1884084500000000,\"isDeleted\":\"1\",\"ruleType\":102,\"relateId\":1542950180851}");
//        param.put("id","1884084500000000");
//        param.put("ruleType",102);
        Object o = Ajax.post(driver,delPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
