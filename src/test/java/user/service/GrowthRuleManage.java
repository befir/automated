package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class GrowthRuleManage extends RestfulAutomatedTest {

    //查询成长值规则
    private String queryPointsRuleServiceUrl = baseUrl+"/ouser-center/growthRule/list.do";
    //获取渠道信息
    private String queryChannelMap = baseUrl+"/ouser-web/api/channel/queryChannelMap.do";
    //新增成长值规则
    private String addPointsRuleServiceUrl = baseUrl+"/ouser-center/growthRule/add.do";
    //获取单个成长值规则信息
//    private String getPointsRuleServiceUrl = baseUrl+"/ouser-center/growthRule/info.do";
    //修改成长值规则
    private String editPointsRuleServiceUrl = baseUrl+"/ouser-center/growthRule/update.do";
    //启用停用成长值规则
    private String openPointsRuleServiceUrl = baseUrl+"/ouser-center/growthRule/update.do";

    @Test
    public void queryPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryChannelMap() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryChannelMap,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"ruleType\":\"G010001\",\"id\":\"\",\"channelCodes\":[\"110001\",\"110002\",\"110003\",\"110004\",\"120001\"],\"name\":\"\",\"userTypes\":[1001],\"ratio\":\"100\",\"code\":\"G010001\"}");
        param.put("name","成长值规则"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
//    @Test
//    public void getPointsRule() throws InterruptedException {
//        JSONObject param = JSON.parseObject("1884084800000005");
////        param.put("id","1884082202000016");
////        param.put("ruleType",101000);
//        Object o = Ajax.post(driver,getPointsRuleServiceUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
    @Test
    public void editPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1884084800000005,\"name\":\"成长值规则\",\"ruleType\":\"G010001\",\"code\":\"G010001\",\"userTypes\":[1001],\"sign\":null,\"ratio\":100,\"target\":null,\"value\":null,\"channelCodes\":[\"110001\",\"110002\",\"110003\",\"110004\",\"120001\"],\"isAvailable\":0,\"userTypeStr\":\"普通会员\"}");
//        param.put("id","1884082202000016");
        Object o = Ajax.post(driver,editPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void openPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1884084800000005,\"name\":\"成长值规则\",\"ruleType\":\"G010001\",\"code\":\"G010001\",\"userTypes\":[1001],\"sign\":null,\"ratio\":100,\"target\":null,\"value\":null,\"channelCodes\":[\"110001\",\"110002\",\"110003\",\"110004\",\"120001\"],\"isAvailable\":1,\"userTypeStr\":\"普通会员\"}");
//        param.put("id","1884082202000016");
//        param.put("isAvailable",1);
        Object o = Ajax.post(driver,openPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
