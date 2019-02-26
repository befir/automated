package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class PointListManage extends RestfulAutomatedTest {

    //查询积分流水
    private String getPointListServiceUrl = baseUrl+"/ouser-center/pointsAcctAction/getUserPointList.do";
    //查询会员积分流水详情
    private String queryPointListServiceUrl = baseUrl+"/ouser-center/pointsAcctAction/getUserAccountFlow.do";
    //查询成长值流水
    private String queryBalenceServiceUrl = baseUrl+"/ouser-center/balence/queryBalenceAll.do";
    //查询会员成长值流水详情
    private String getBalenceServiceUrl = baseUrl+"/ouser-center/balence/queryBalenceDetail.do";
    @Test
    public void getPointList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,getPointListServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryPointList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"accountId\":88}");
        Object o = Ajax.post(driver,queryPointListServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryBalence() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryBalenceServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getBalence() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"userId\":1886083001000151}");
        param.put("userId","1886083001000151");
        Object o = Ajax.post(driver,getBalenceServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
