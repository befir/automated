package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class BasicConfigManage extends RestfulAutomatedTest {

    //查询积分基础配置
    private String queryBasicConfigServiceUrl = baseUrl+"/ouser-center/pointsRuleAction/queryBasicConfigInfo.do";
    //设置积分基础配置
    private String addBasicConfigServiceUrl = baseUrl+"/ouser-center/pointsRuleAction/savePointsRule.do";
    //查询成长值基础配置
    private String queryBasicConfigServiceUrl1 = baseUrl+"/ouser-center/pointsRuleAction/queryBasicConfigInfo.do";
    //设置成长值基础配置
    private String addBasicConfigServiceUrl1 = baseUrl+"/ouser-center/pointsRuleAction/savePointsRule.do";

    @Test
    public void queryBasicConfig() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryBasicConfigServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addBasicConfig() throws InterruptedException {
        int x=(int)(Math.random()*1000000+1000000);
        int y=(int)(Math.random()*10+1);
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"relateId\":\"\",\"companyId\":231,\"type\":null,\"ruleName\":\"基础配置\",\"ruleType\":100,\"isAvailable\":1,\"isDeleted\":0,\"basicConfig\":{\"rate\":null,\"maxPerDay\":8888888,\"expiryCnt\":8,\"expiryUnit\":4,\"expiryType\":2},\"loginSetupType\":null,\"loginCntPerDay\":null,\"serialLogin\":null,\"loginLevels\":null,\"registerCnt\":null,\"firstBindMobileCnt\":null,\"nonFirstBindMobileCnt\":null,\"improveInfoCnt\":null,\"shareActivityMaxTimePerDay\":null,\"shareActivityCntPerTime\":null,\"setupCXHD\":null,\"setupSQHD\":null,\"shareAppMaxTimePerDay\":null,\"shareAppCntPerTime\":null,\"community\":null,\"favoCommentCnt\":null,\"favoCommentCnt2\":null,\"rewardTimesPerPiece\":null,\"rewardTimesPerPeople\":null,\"rewardCntOptions\":null,\"birthdayCnt\":null,\"pointsValue\":null,\"orderUpCount\":null,\"orderUpUnit\":null,\"channelCodes\":null,\"shareProducts\":null}");
//        param.put("id","1884082303000022");
//        param.put("relateId","1541077508853");
//        param.put("companyId",231);//公司ID
//        param.put("ruleName","基础配置");
//        param.put("expiryCnt",y);//积分有效期
//        param.put("expiryUnit",4);//积分有效期:1：日  2：周  3：月  4：年
//        param.put("expiryType",2);//1：按领取的时间计算   2：按自然年计算
//        param.put("maxPerDay",x);//积分上限值
//        param.put("rate","");
        Object o = Ajax.post(driver,addBasicConfigServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryBasicConfig1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryBasicConfigServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addBasicConfig1() throws InterruptedException {
        int x=(int)(Math.random()*1000000+1000000);
        int y=(int)(Math.random()*10+1);
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"relateId\":\"\",\"companyId\":231,\"type\":null,\"ruleName\":\"基础配置\",\"ruleType\":100,\"isAvailable\":1,\"isDeleted\":0,\"basicConfig\":{\"rate\":null,\"maxPerDay\":8888888,\"expiryCnt\":8,\"expiryUnit\":4,\"expiryType\":2},\"loginSetupType\":null,\"loginCntPerDay\":null,\"serialLogin\":null,\"loginLevels\":null,\"registerCnt\":null,\"firstBindMobileCnt\":null,\"nonFirstBindMobileCnt\":null,\"improveInfoCnt\":null,\"shareActivityMaxTimePerDay\":null,\"shareActivityCntPerTime\":null,\"setupCXHD\":null,\"setupSQHD\":null,\"shareAppMaxTimePerDay\":null,\"shareAppCntPerTime\":null,\"community\":null,\"favoCommentCnt\":null,\"favoCommentCnt2\":null,\"rewardTimesPerPiece\":null,\"rewardTimesPerPeople\":null,\"rewardCntOptions\":null,\"birthdayCnt\":null,\"pointsValue\":null,\"orderUpCount\":null,\"orderUpUnit\":null,\"channelCodes\":null,\"shareProducts\":null}");
        Object o = Ajax.post(driver,addBasicConfigServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
}
