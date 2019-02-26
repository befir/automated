package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class MerchantAccountManage extends RestfulAutomatedTest {

    //查询商家的结算信息
    private String queryAccountUnitServiceUrl = baseUrl+"/back-finance-web/stmMerchantAccountController/selectMerchantAccount.do";
    //编辑商家的结算信息
    private String addAccountUnitServiceUrl = baseUrl+"/back-finance-web/stmMerchantAccountController/saveMerchantAccount.do";
    //查询商家关联的渠道信息
    private String queryAccountUnitServiceUrl1 = baseUrl+"/ouser-web/api/channel/queryChannelMap.do";
    //给商家关联渠道
    private String addAccountUnitServiceUrl1 = baseUrl+"/back-merchant-web/merchantOrgChannel/addMerchantOrgChannel.do";
    //查询商家的账号信息
    private String addAccountUnitServiceUrl12 = baseUrl+"/ouser-web/employee/queryEmployee.do";
    @Test
    public void queryAccountUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantId\":\"2029080800000000\"}");
        Object o = Ajax.post(driver,queryAccountUnitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addAccountUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886081100000039,\"merchantId\":\"2029080800000000\",\"receiverAccountType\":1,\"receiverEnterpriseName\":\"\",\"receiverAccountNo\":\"xxx\",\"receiverBankName\":\"\",\"receiverSubBankName\":\"\"}");
//        param.put("unitCode",dateFormat.format(new Date()));
//        param.put("unitName","文心阁"+dateFormat.format(new Date()));
//        param.put("unitDesc","文心阁核算"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addAccountUnitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryAccountUnit1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryAccountUnitServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addAccountUnit1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"2029080800000000\",\"channelCode\":\"120001\",\"status\":0}");
//        param.put("unitCode",dateFormat.format(new Date()));
//        param.put("unitName","文心阁"+dateFormat.format(new Date()));
//        param.put("unitDesc","文心阁核算"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addAccountUnitServiceUrl1,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addAccountUnit2() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"entityId\":\"2029080800000000\",\"identitySubTypes\":[20],\"currentPage\":1,\"itemsPerPage\":1}");
//        param.put("unitCode",dateFormat.format(new Date()));
//        param.put("unitName","文心阁"+dateFormat.format(new Date()));
//        param.put("unitDesc","文心阁核算"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addAccountUnitServiceUrl12,param);
        System.out.println(JSON.toJSONString(o));
    }
}
