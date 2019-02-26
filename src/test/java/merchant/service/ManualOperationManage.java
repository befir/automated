package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class ManualOperationManage extends RestfulAutomatedTest {

    //查询积分人工作业
    private String queryPointsRuleServiceUrl = baseUrl+"/ouser-center/manualOperationAction/getManualOperationPage.do";
    //新增积分人工作业
    private String addPointsRuleServiceUrl = baseUrl+"/ouser-center/manualOperationAction/addManualOperation.do";

    @Test
    public void queryPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addPointsRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"opeObjs\":[{\"userId\":\"\",\"username\":\"\"}],\"opeObj\":\"\",\"opeType\":\"1\",\"opeAmount\":\"1\",\"channelCode\":\"\",\"opeReason\":\"\"}");
        param.put("userId","1886081703000466");
        param.put("opeObj","1886081703000466");
        param.put("channelCode",110001);
        param.put("opeReason",1);
        Object o = Ajax.post(driver,addPointsRuleServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
