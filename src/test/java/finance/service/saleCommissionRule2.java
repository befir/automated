package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//财务设置
public class saleCommissionRule2 extends RestfulAutomatedTest {
    //销售返利规则设置查询
    private String selectSaleRebateRulesUrl = baseUrl + "/back-finance-web/saleRebateRules/selectSaleRebateRules.do";

    //销售返利规则设置重置
    private String selectSaleRebateRuleUrl = baseUrl + "/back-finance-web/saleRebateRules/selectSaleRebateRules.do";

    //新增销售返利规则
    private String saveSaleRebateRuleInfoUrl = baseUrl + "/back-finance-web/saleRebateRules/saveSaleRebateRuleInfo.do";

    //修改销售返利规则
    private String saveSaleRebateRuleUrl = baseUrl + "/back-finance-web/saleRebateRules/saveSaleRebateRuleInfo.do";

    //账期设置查询
    private String queryComSettlePeriodUrl = baseUrl + "/back-finance-web/settlePeriod/queryComSettlePeriodList.do";

    //账期设置重置
    private String queryComSettlePeriodListUrl = baseUrl + "/back-finance-web/settlePeriod/queryComSettlePeriodList.do";

    //新增账期设置-查询商家
    private String queryMerchantUrl = baseUrl + "/back-finance-web/merchantRead/queryMerchantList.do";

    //新增账期设置
    private String insertComSettlePeriodRuleUrl = baseUrl + "/back-finance-web/settlePeriod/insertComSettlePeriodRule.do";

    //编辑账期设置
    private String updateComSettlePeriodRuleUrl = baseUrl + "/back-finance-web/settlePeriod/updateComSettlePeriodRule.do";

    //账期设置失效
    private String expireComSettlePeriodRuleUrl = baseUrl + "/back-finance-web/settlePeriod/expireComSettlePeriodRule.do";

    //销售返利规则设置查询
    @Test
    public void selectSaleRebateRules() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, selectSaleRebateRulesUrl, param);
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

    //销售返利规则设置重置
    @Test
    public void selectSaleRebateRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, selectSaleRebateRuleUrl, param);
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

    //新增销售返利规则
    @Test
    public void saveSaleRebateRuleInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"saleRebateType\":\"1\",\"saleRebateRuleDateperiodList\":[{\"id\":null,\"beginDate\":\"2019-01-08\",\"endDate\":\"2019-02-16\",\"generateBillStatus\":0,\"isDeleted\":0}],\"saleRebateRuleGoodsList\":[{\"commissionRestrict\":1,\"promotionType\":0,\"goodsRestrict\":0,\"isDeleted\":0,\"promotionList\":\"\"}],\"saleRebateRuleRoyaltyrateList\":[{\"id\":null,\"beginAmount\":0,\"endAmount\":9999999,\"royaltyRate\":0,\"reward\":\"\",\"royaltyType\":\"2\",\"isDeleted\":0}],\"saleRebateRuleName\":\"销售返利规则\"}");
        Object o = Ajax.post(driver, saveSaleRebateRuleInfoUrl, param);
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

    //修改销售返利规则
    @Test
    public void saveSaleRebateRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083003000217,\"saleRebateType\":1,\"saleRebateTypeText\":\"自销奖励\",\"saleRebateRuleCode\":null,\"saleRebateRuleName\":\"销售返利规则啊\",\"remark\":null,\"saleRebateRuleDateperiodList\":[{\"id\":1886083003000218,\"beginDate\":\"2019-01-08\",\"endDate\":\"2019-02-16\",\"saleRebateRuleId\":1886083003000217,\"periodOrder\":null,\"generateBillStatus\":0,\"isDeleted\":0}],\"saleRebateRuleGoodsList\":[{\"id\":1886083003000219,\"commissionRestrict\":1,\"promotionType\":0,\"saleRebateRuleId\":1886083003000217,\"promotionList\":\"\",\"isDeleted\":0,\"goodsList\":null,\"goodsRestrict\":0}],\"saleRebateRuleRoyaltyrateList\":[{\"id\":1886083003000220,\"beginAmount\":0,\"endAmount\":9999999,\"saleRebateRuleId\":1886083003000220,\"royaltyRate\":0,\"reward\":\"\",\"rewardGoodCode\":null,\"rewardIconUrl\":null,\"royaltyType\":2,\"isDeleted\":0}],\"currentPage\":null,\"itemsPerPage\":null,\"canModify\":0,\"partyId\":null,\"partyCode\":null,\"partyName\":null,\"partyType\":null,\"effectiveType\":null,\"effectiveTypeText\":null,\"effectiveDate\":null,\"expireDate\":null,\"effectiveDateStr\":null,\"expireDateStr\":null}");
        Object o = Ajax.post(driver, saveSaleRebateRuleUrl, param);
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

    //账期设置查询
    @Test
    public void queryComSettlePeriod() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"businessType\":\"\",\"settlePeriodType\":\"\"}}");
        Object o = Ajax.post(driver, queryComSettlePeriodUrl, param);
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

    //账期设置重置
    @Test
    public void queryComSettlePeriodList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"businessType\":\"\",\"settlePeriodType\":\"\"}}");
        Object o = Ajax.post(driver, queryComSettlePeriodListUrl, param);
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

    //新增账期设置-查询商家
    @Test
    public void queryMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{}}");
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

    //新增账期设置
    @Test
    public void insertComSettlePeriodRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"businessType\":1,\"settleBaseDateType\":1,\"settlePeriodType\":\"1\",\"expireDay\":1,\"merchantId\":3,\"merchantCode\":\"M003\",\"merchantName\":\"上海欧电云\",\"ruleName\":\"账期名称\",\"ruleEffectiveTime\":\"2018-11-09\",\"cycleDay\":7,\"isValid\":1}");
        Object o = Ajax.post(driver, insertComSettlePeriodRuleUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
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

    //编辑账期设置
    @Test
    public void updateComSettlePeriodRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"limitClauseStartItem\":null,\"limitClauseCount\":null,\"currentPage\":null,\"itemsPerPage\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"businessTypeText\":\"付款账期\",\"settlePeriodTypeText\":\"按周\",\"settleBaseDateTypeText\":\"收货日期\",\"cycleDay\":7,\"isValidText\":\"生效\",\"text\":null,\"preliminaryDate\":null,\"ruleNameNoVague\":null,\"limit\":null,\"offset\":null,\"id\":1886083100000130,\"ruleCode\":\"1886083100000130\",\"ruleName\":\"账期名称\",\"settleType\":1,\"businessType\":1,\"settleBaseDateType\":1,\"settlePeriodType\":\"1\",\"expireDay\":1,\"ruleEffectiveTime\":\"2018-11-08\",\"isValid\":1,\"isPlatform\":null,\"merchantId\":3,\"merchantName\":\"上海欧电云\",\"merchantCode\":\"M003\",\"rootMerchantId\":null,\"isDeleted\":0,\"companyId\":231,\"versionNo\":0,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1541748737000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null}");
        Object o = Ajax.post(driver, updateComSettlePeriodRuleUrl, param);
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

    //账期设置失效
    @Test
    public void expireComSettlePeriodRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"limitClauseStartItem\":null,\"limitClauseCount\":null,\"currentPage\":null,\"itemsPerPage\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"businessTypeText\":\"付款账期\",\"settlePeriodTypeText\":\"按季度\",\"settleBaseDateTypeText\":\"收货日期\",\"cycleDay\":120,\"isValidText\":\"生效\",\"text\":\"账期\",\"preliminaryDate\":null,\"ruleNameNoVague\":null,\"limit\":null,\"offset\":null,\"id\":1886081404000061,\"ruleCode\":\"1886081404000061\",\"ruleName\":\"账期\",\"settleType\":1,\"businessType\":1,\"settleBaseDateType\":1,\"settlePeriodType\":\"3\",\"expireDay\":1,\"ruleEffectiveTime\":1540224000000,\"ruleExpireTime\":null,\"isValid\":2,\"isPlatform\":null,\"merchantId\":2029080800000000,\"merchantName\":\"可口可乐\",\"merchantCode\":\"1\",\"rootMerchantId\":null,\"isDeleted\":0,\"companyId\":231,\"versionNo\":0,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1540263794000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null}");
        Object o = Ajax.post(driver, expireComSettlePeriodRuleUrl, param);
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