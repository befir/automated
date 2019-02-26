package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//财务设置
public class saleCommissionRule extends RestfulAutomatedTest {
    //销售提成规则设置查询
    private String querySaleCommissionRuleUrl = baseUrl + "/back-finance-web/saleCommissionRule/querySaleCommissionRuleList.do";

    //销售提成规则设置重置
    private String querySaleCommissionRuleListUrl = baseUrl + "/back-finance-web/saleCommissionRule/querySaleCommissionRuleList.do";

    //销售提成规则设置删除
    private String deleteSaleCommissionRuleUrl = baseUrl + "/back-finance-web/saleCommissionRule/deleteSaleCommissionRule.do";

    //新增销售提成规则设置单-查询商家
    private String queryMerchantUrl = baseUrl + "/back-finance-web/merchantRead/queryMerchantList.do";

    //新增销售提成规则设置单
    private String saveSaleCommissionUrl = baseUrl + "/back-finance-web/saleCommissionRule/saveSaleCommissionRule.do";

    //编辑销售提成规则设置单
    private String updateSaleCommissionUrl = baseUrl + "/back-finance-web/saleCommissionRule/updateSaleCommissionRule.do";

    //审核销售提成规则设置单
    private String auditSaleCommissionUrl = baseUrl + "/back-finance-web/saleCommissionRule/auditSaleCommissionRule.do";

    //查询支付方式配置
    private String queryPaymentMethodUrl = baseUrl + "/back-finance-web/paymentMethod/queryPaymentMethodPage.do";

    //重置支付方式配置
    private String queryPaymentUrl = baseUrl + "/back-finance-web/paymentMethod/queryPaymentMethodPage.do";

    //删除支付方式配置
    private String deletedPaymentMethodUrl = baseUrl + "/back-finance-web/paymentMethod/deletedPaymentMethod.do";

    //新增支付方式配置
    private String savePaymentMethodUrl = baseUrl + "/back-finance-web/paymentMethod/savePaymentMethod.do";

    //修改支付方式配置
    private String updatePaymentMethodUrl = baseUrl + "/back-finance-web/paymentMethod/updatePaymentMethod.do";

    //禁用支付方式配置
    private String updatePaymentUrl = baseUrl + "/back-finance-web/paymentMethod/updatePaymentMethod.do";

    //查询支付网关配置
    private String queryPaymentGatewayUrl = baseUrl + "/back-finance-web/paymentGateway/queryPaymentGatewayListPage.do";

    //重置支付网关配置
    private String queryPaymentGatewayListUrl = baseUrl + "/back-finance-web/paymentGateway/queryPaymentGatewayListPage.do";

    //删除支付网关配置
    private String deletePaymentGatewayUrl = baseUrl + "/back-finance-web/paymentGateway/deletePaymentGateway.do";

    //新增支付网关配置
    private String savePaymentGatewayUrl = baseUrl + "/back-finance-web/paymentGateway/savePaymentGateway.do";

    //修改支付网关配置
    private String updatePaymentGatewayUrl = baseUrl + "/back-finance-web/paymentGateway/updatePaymentGateway.do";

    //修改提现设置
    private String updateWithdrawConfigUrl = baseUrl + "/back-finance-web/withdrawConfig/updateWithdrawConfig.do";

    //修改审核设置
    private String updateAuditConfigUrl = baseUrl + "/back-finance-web/auditConfig/updateAuditConfig.do";




    //销售提成规则设置查询
    @Test
    public void querySaleCommissionRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySaleCommissionRuleUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //销售提成规则设置重置
    @Test
    public void querySaleCommissionRuleList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySaleCommissionRuleListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //销售提成规则设置删除
    @Test
    public void deleteSaleCommissionRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1255050507000144}");
        Object o = Ajax.post(driver, deleteSaleCommissionRuleUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //新增销售提成规则设置单-查询商家
    @Test
    public void queryMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, queryMerchantUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //新增销售提成规则设置单
    @Test
    public void saveSaleCommission() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"mpDTOList\":[],\"employeeDTOList\":[],\"positionDTOList\":[],\"statusInList\":null,\"merchantIds\":null,\"commissionAmount\":null,\"commissionPercent\":null,\"singleAmount\":null,\"startAmount\":null,\"endAmount\":null,\"id\":null,\"ruleCode\":\"1886082700000161\",\"ruleName\":\"规则名称\",\"commissionType\":1,\"commissionTypeText\":\"指定岗位\",\"triggerConditionIn\":\"1\",\"triggerConditionInText\":null,\"triggerConditionDelayDays\":null,\"triggerConditionOut\":\"\",\"triggerConditionOutText\":null,\"effectiveDate\":\"2018-11-05\",\"expireDate\":null,\"commissionAmtType\":1,\"commissionAmtTypeText\":\"含税销售金额\",\"mpScopeType\":1,\"mpScopeTypeText\":\"所有商品\",\"saleCommissionType\":2,\"saleCommissionTypeText\":\"固定比率\",\"saleCommissionTypeRule\":\"[{\\\"commissionPercent\\\":1,\\\"singleAmount\\\":100}]\",\"status\":null,\"statusText\":null,\"auditTime\":null,\"auditUsername\":null,\"discardTime\":null,\"discardUsername\":null,\"merchantId\":2029080800000000,\"merchantCode\":\"1\",\"merchantName\":\"可口可乐\",\"attachPath\":null,\"attachName\":null,\"remark\":null,\"logRemark\":null,\"companyId\":null,\"isDeleted\":null,\"versionNo\":null,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1541401892860,\"createTimeStart\":null,\"createTimeEnd\":null,\"serverIp\":null,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null}");
        Object o = Ajax.post(driver, saveSaleCommissionUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //编辑销售提成规则设置单
    @Test
    public void updateSaleCommission() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"mpDTOList\":[],\"employeeDTOList\":[],\"positionDTOList\":[],\"statusInList\":null,\"merchantIds\":null,\"commissionAmount\":null,\"commissionPercent\":null,\"singleAmount\":null,\"startAmount\":null,\"endAmount\":null,\"id\":1255050507000133,\"ruleCode\":\"1886082700000161\",\"ruleName\":\"规则名称\",\"commissionType\":1,\"commissionTypeText\":\"所有人员\",\"triggerConditionIn\":1,\"triggerConditionInText\":\"销售订单审核通过\",\"triggerConditionDelayDays\":null,\"triggerConditionOut\":null,\"triggerConditionOutText\":\"\",\"effectiveDate\":\"2018-11-05\",\"expireDate\":null,\"commissionAmtType\":1,\"commissionAmtTypeText\":\"含税销售金额\",\"mpScopeType\":1,\"mpScopeTypeText\":\"所有商品\",\"saleCommissionType\":2,\"saleCommissionTypeText\":\"固定比率\",\"saleCommissionTypeRule\":\"[{\\\"commissionPercent\\\":1,\\\"singleAmount\\\":1000}]\",\"status\":1,\"statusText\":\"待审核\",\"auditTime\":null,\"auditUsername\":null,\"discardTime\":null,\"discardUsername\":null,\"merchantId\":2029080800000000,\"merchantCode\":\"1\",\"merchantName\":\"可口可乐\",\"attachPath\":null,\"attachName\":null,\"remark\":null,\"logRemark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1541401893000,\"createTimeStart\":null,\"createTimeEnd\":null,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null}");
        Object o = Ajax.post(driver, updateSaleCommissionUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //审核销售提成规则设置
    @Test
    public void auditSaleCommission() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"mpDTOList\":null,\"employeeDTOList\":null,\"positionDTOList\":null,\"statusInList\":null,\"merchantIds\":null,\"commissionAmount\":null,\"commissionPercent\":null,\"singleAmount\":null,\"startAmount\":null,\"endAmount\":null,\"id\":1255050507000133,\"ruleCode\":\"1886082700000161\",\"ruleName\":\"规则名称\",\"commissionType\":1,\"commissionTypeText\":\"所有人员\",\"triggerConditionIn\":1,\"triggerConditionInText\":\"销售订单审核通过\",\"triggerConditionDelayDays\":null,\"triggerConditionOut\":null,\"triggerConditionOutText\":\"\",\"effectiveDate\":1541376000000,\"expireDate\":null,\"commissionAmtType\":1,\"commissionAmtTypeText\":\"含税销售金额\",\"mpScopeType\":1,\"mpScopeTypeText\":\"所有商品\",\"saleCommissionType\":2,\"saleCommissionTypeText\":\"固定比率\",\"saleCommissionTypeRule\":\"[{\\\"commissionPercent\\\":1,\\\"singleAmount\\\":1000}]\",\"status\":1,\"statusText\":\"待审核\",\"auditTime\":null,\"auditUsername\":null,\"discardTime\":null,\"discardUsername\":null,\"merchantId\":2029080800000000,\"merchantCode\":\"1\",\"merchantName\":\"可口可乐\",\"attachPath\":null,\"attachName\":null,\"remark\":null,\"logRemark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":null,\"createUserid\":null,\"createUsername\":\"superadmin\",\"createTime\":1541401893000,\"createTimeStart\":null,\"createTimeEnd\":null,\"serverIp\":null,\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1541402099000}");
        Object o = Ajax.post(driver, auditSaleCommissionUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //查询支付方式配置
    @Test
    public void queryPaymentMethod() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"businessType\":\"\",\"saleChannelCode\":\"\"}");
        Object o = Ajax.post(driver, queryPaymentMethodUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //重置支付方式配置
    @Test
    public void queryPayment() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"businessType\":\"\",\"saleChannelCode\":\"\"}");
        Object o = Ajax.post(driver, queryPaymentUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

        //删除支付方式配置
    @Test
    public void deletedPaymentMethod() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1881082800000231,\"methodCode\":\"1\",\"methodName\":\"网上支付\",\"parentMethodCode\":null,\"level\":1,\"merchantId\":null,\"businessType\":1,\"saleChannelCode\":\"O2O\",\"status\":0,\"companyId\":231,\"terminalType\":null,\"isDeleted\":1881082800000231}");
        Object o = Ajax.post(driver, deletedPaymentMethodUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //新增支付方式配置
    @Test
    public void savePaymentMethod() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"methodCode\":\"1\",\"businessType\":1,\"saleChannelCode\":\"B2B\",\"status\":1,\"methodName\":\"网上支付\",\"merchantId\":\"\"}");
        Object o = Ajax.post(driver, savePaymentMethodUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //编辑支付方式配置
    @Test
    public void updatePaymentMethod() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1881082800000231,\"methodCode\":\"1\",\"methodName\":\"网上支付\",\"parentMethodCode\":null,\"level\":1,\"merchantId\":\"\",\"businessType\":1,\"saleChannelCode\":\"O2O\",\"status\":1,\"companyId\":231,\"terminalType\":null}");
        Object o = Ajax.post(driver, updatePaymentMethodUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //禁用支付方式配置
    @Test
    public void updatePayment() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1881082800000231,\"methodCode\":\"1\",\"methodName\":\"网上支付\",\"parentMethodCode\":null,\"level\":1,\"merchantId\":null,\"businessType\":1,\"saleChannelCode\":\"O2O\",\"status\":0,\"companyId\":231,\"terminalType\":null}");
        Object o = Ajax.post(driver, updatePaymentUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //查询支付网关配置
    @Test
    public void queryPaymentGateway() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"saleChannelCode\":\"\"}");
        Object o = Ajax.post(driver, queryPaymentGatewayUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //重置支付网关配置
    @Test
    public void queryPaymentGatewayList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"saleChannelCode\":\"\"}");
        Object o = Ajax.post(driver, queryPaymentGatewayListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //删除支付网关配置
    @Test
    public void deletePaymentGateway() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1881082900000136,\"gatewayCode\":\"6\",\"gatewayName\":\"银联支付\",\"methodCode\":\"1\",\"methodName\":\"网上支付\",\"channelCode\":\"unionpay\",\"channelName\":\"银联支付\",\"merchantId\":null,\"merchantCode\":\"\",\"saleChannelCode\":\"B2B\",\"merchantName\":null,\"businessType\":2,\"terminalType\":\"PC\",\"iconUrl\":\"http://cdn.oudianyun.com/opay/yinlian.jpg\",\"payUrl\":null,\"returnUrl\":null,\"notifyUrl\":null,\"status\":1,\"companyName\":null,\"companyId\":231,\"remark\":null,\"isDeleted\":1881082900000136}");
        Object o = Ajax.post(driver, deletePaymentGatewayUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }


    //新增支付网关配置
    @Test
    public void savePaymentGateway() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"methodCode\":1,\"methodName\":\"网上支付\",\"channelCode\":\"unionpay\",\"businessType\":1,\"saleChannelCode\":\"B2B\",\"terminalType\":\"PC\",\"gatewayCode\":\"6\",\"status\":1,\"channelName\":\"银联支付\",\"gatewayName\":\"银联支付\",\"iconUrl\":\"http://cdn.oudianyun.com/opay/yinlian.jpg\",\"merchantCode\":\"\"}");
        Object o = Ajax.post(driver, savePaymentGatewayUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //修改支付网关配置
    @Test
    public void updatePaymentGateway() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1881082900000136,\"gatewayCode\":\"6\",\"gatewayName\":\"银联支付\",\"methodCode\":\"1\",\"methodName\":\"网上支付\",\"channelCode\":\"unionpay\",\"channelName\":\"银联支付\",\"merchantId\":null,\"merchantCode\":\"\",\"saleChannelCode\":\"B2B\",\"merchantName\":null,\"businessType\":2,\"terminalType\":\"PC\",\"iconUrl\":\"http://cdn.oudianyun.com/opay/yinlian.jpg\",\"payUrl\":null,\"returnUrl\":null,\"notifyUrl\":null,\"status\":1,\"companyName\":null,\"companyId\":231,\"remark\":null}");
        Object o = Ajax.post(driver, updatePaymentGatewayUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //修改提现设置
    @Test
    public void updateWithdrawConfig() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886081602000192,\"withdrawType\":1,\"minAmount\":0,\"maxCount\":0,\"contingentIncomeTax\":0,\"withdrawRestrict\":null,\"companyId\":231,\"isDeleted\":0,\"payTypeList\":null,\"feeDetailList\":[{\"withdrawFeeDetailId\":null,\"startAmount\":0,\"endAmount\":1,\"feePercent\":0,\"feeAmount\":0,\"feeOrder\":null,\"withdrawConfigId\":null,\"createTime\":null,\"updateTime\":null}],\"feeFixedDetailList\":[{\"withdrawFeeDetailId\":null,\"startAmount\":0,\"endAmount\":null,\"feePercent\":0,\"feeAmount\":0,\"feeOrder\":null,\"withdrawConfigId\":null,\"createTime\":null,\"updateTime\":null}],\"withdrawFeeType\":1}");
        Object o = Ajax.post(driver, updateWithdrawConfigUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //修改审核设置
    @Test
    public void updateAuditConfig() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"auditType\":\"0\",\"nodeConfigList\":[],\"superAuditRoleId\":0,\"id\":1886081404000052}");
        Object o = Ajax.post(driver, updateAuditConfigUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

}