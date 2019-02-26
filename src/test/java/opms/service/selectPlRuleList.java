package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.ody.automation.RestfulAutomationTest;
//import com.ody.automation.RestfulAutomationTest;

//智能补货计划
public class selectPlRuleList extends RestfulAutomatedTest {

    //查询智能补货计划
    private String selectPlRuleListurl = baseUrl+"/opms-web/plRule/selectPlRuleList.do";
    //重置智能补货计划
    private String selectPlRuleListUrl = baseUrl+"/opms-web/plRule/selectPlRuleList.do";
    //新增智能补货计划
    private String savePlRuleUrl = baseUrl+"/opms-web/plRule/savePlRule.do";
    //查询智能补货结果
    private String queryPlMpResultListUrl = baseUrl+"/opms-web/plMpResultAction/queryPlMpResultList.do";
    //重置智能补货结果
    private String queryPlMpResultUrl = baseUrl+"/opms-web/plMpResultAction/queryPlMpResultList.do";

    //智能补货计划查询
    @Test
    public void setSelectPlRuleListurl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"merchantName\":\"上海欧电云\",\"merchantCode\":\"M003\",\"merchantId\":3}");
       Object o = Ajax.post(driver, selectPlRuleListurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//       断言data
       JSONObject expectedData = JSON.parseObject("{\"listObj\":[],\"total\":0}");
        Assert.assertEquals(actualResult.get("data"),expectedData);
       System.out.println(JSON.toJSONString(o));
    }
    //重置智能补货计划
    @Test
    public void selectPlRuleList () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}\n");
        Object o = Ajax.post(driver, selectPlRuleListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言data
        JSONObject expectedData = JSON.parseObject("{\"listObj\":[{\"createUserid\":18101517160196,\"merchantCode\":\"1\",\"plModelType\":3,\"plModelTypeText\":\"定量手工补货\",\"effectiveTime\":1542758400000,\"createTimeDb\":1542878508000,\"orgList\":[],\"merchantName\":\"可口可乐\",\"mpList\":[],\"ruleCode\":\"1886084402000046\",\"companyId\":231,\"expireTime\":1542931200000,\"createUsername\":\"superadmin\",\"isDeleted\":0,\"merchantId\":2029080800000000,\"createTime\":1542878361000,\"statusText\":\"进行中\",\"categoryList\":[],\"versionNo\":0,\"detailList\":[],\"ruleName\":\"AAA\",\"serverIp\":\"127.0.0.1\",\"id\":132,\"status\":1},{\"plModelType\":4,\"plModelTypeText\":\"定期手工补货\",\"updateUserid\":1886080801000067,\"effectiveTime\":1542844800000,\"orgList\":[],\"merchantName\":\"桂源铺\",\"createUsername\":\"Gyp\",\"isDeleted\":0,\"merchantId\":2029080800003446,\"categoryList\":[],\"updateTimeDb\":1542873890000,\"versionNo\":0,\"ruleName\":\"11.22补货计划01\",\"id\":131,\"createUserid\":1886080801000067,\"merchantCode\":\"spx101701\",\"createTimeDb\":1542873794000,\"updateTime\":1542873905000,\"mpList\":[],\"ruleCode\":\"1886084402000013\",\"companyId\":231,\"expireTime\":1543536000000,\"createTime\":1542873771000,\"statusText\":\"进行中\",\"detailList\":[],\"updateUsername\":\"Gyp\",\"serverIp\":\"127.0.0.1\",\"status\":1},{\"createUserid\":1886080801000067,\"merchantCode\":\"spx101701\",\"plModelType\":3,\"plModelTypeText\":\"定量手工补货\",\"effectiveTime\":1542758400000,\"createTimeDb\":1542798305000,\"orgList\":[],\"merchantName\":\"桂源铺\",\"mpList\":[],\"ruleCode\":\"1886084302000092\",\"companyId\":231,\"expireTime\":1543536000000,\"createUsername\":\"Gyp\",\"isDeleted\":0,\"merchantId\":2029080800003446,\"createTime\":1542790930000,\"statusText\":\"进行中\",\"categoryList\":[],\"versionNo\":0,\"detailList\":[],\"ruleName\":\"11.21计划\",\"serverIp\":\"127.0.0.1\",\"id\":130,\"status\":1},{\"createUserid\":1886080801000067,\"merchantCode\":\"spx101701\",\"plModelType\":3,\"plModelTypeText\":\"定量手工补货\",\"effectiveTime\":1542758400000,\"createTimeDb\":1542791624000,\"orgList\":[],\"merchantName\":\"桂源铺\",\"mpList\":[],\"ruleCode\":\"1886084302000091\",\"companyId\":231,\"expireTime\":1543536000000,\"createUsername\":\"Gyp\",\"isDeleted\":0,\"merchantId\":2029080800003446,\"createTime\":1542790930000,\"statusText\":\"进行中\",\"categoryList\":[],\"versionNo\":0,\"detailList\":[],\"ruleName\":\"11.21计划\",\"serverIp\":\"127.0.0.1\",\"id\":129,\"status\":1},{\"createUserid\":1886080801000067,\"merchantCode\":\"spx101701\",\"plModelType\":3,\"plModelTypeText\":\"定量手工补货\",\"effectiveTime\":1542758400000,\"createTimeDb\":1542791504000,\"orgList\":[],\"merchantName\":\"桂源铺\",\"mpList\":[],\"ruleCode\":\"1886084302000090\",\"companyId\":231,\"expireTime\":1543536000000,\"createUsername\":\"Gyp\",\"isDeleted\":0,\"merchantId\":2029080800003446,\"createTime\":1542790930000,\"statusText\":\"进行中\",\"categoryList\":[],\"versionNo\":0,\"detailList\":[],\"ruleName\":\"11.21计划\",\"serverIp\":\"127.0.0.1\",\"id\":128,\"status\":1},{\"createUserid\":1886080801000009,\"merchantCode\":\"1\",\"plModelType\":1,\"plModelTypeText\":\"定量自动补货\",\"effectiveTime\":1542585600000,\"createTimeDb\":1542594244000,\"orgList\":[],\"merchantName\":\"可口可乐\",\"mpList\":[],\"ruleCode\":\"1886084102000000\",\"companyId\":231,\"expireTime\":1543017600000,\"createUsername\":\"kekoukele\",\"isDeleted\":0,\"merchantId\":2029080800000000,\"createTime\":1542594189000,\"statusText\":\"进行中\",\"categoryList\":[],\"versionNo\":0,\"detailList\":[],\"ruleName\":\"定量\",\"serverIp\":\"127.0.0.1\",\"id\":127,\"status\":1},{\"plModelType\":2,\"plModelTypeText\":\"定期自动补货\",\"updateUserid\":18101517160196,\"effectiveTime\":1535328000000,\"orgList\":[],\"merchantName\":\"可口可乐\",\"createUsername\":\"superadmin\",\"isDeleted\":0,\"merchantId\":2029080800000000,\"categoryList\":[],\"updateTimeDb\":1541419474000,\"versionNo\":0,\"ruleName\":\"定期自动补货1105\",\"id\":126,\"createUserid\":18101517160196,\"merchantCode\":\"1\",\"createTimeDb\":1541417841000,\"updateTime\":1541419478000,\"mpList\":[],\"ruleCode\":\"1886082703000010\",\"companyId\":231,\"expireTime\":1542931200000,\"createTime\":1541417772000,\"statusText\":\"进行中\",\"detailList\":[],\"updateUsername\":\"superadmin\",\"serverIp\":\"127.0.0.1\",\"status\":1},{\"createUserid\":18101517160196,\"merchantCode\":\"1\",\"plModelType\":1,\"plModelTypeText\":\"定量自动补货\",\"effectiveTime\":1538611200000,\"createTimeDb\":1541417763000,\"orgList\":[],\"merchantName\":\"可口可乐\",\"mpList\":[],\"ruleCode\":\"1886082703000001\",\"companyId\":231,\"expireTime\":1542931200000,\"createUsername\":\"superadmin\",\"isDeleted\":0,\"merchantId\":2029080800000000,\"createTime\":1541417673000,\"statusText\":\"进行中\",\"categoryList\":[],\"versionNo\":0,\"detailList\":[],\"ruleName\":\"定量自动补货1105\",\"serverIp\":\"127.0.0.1\",\"id\":125,\"status\":1},{\"plModelType\":4,\"plModelTypeText\":\"定期手工补货\",\"effectiveTime\":1541116800000,\"orgList\":[],\"merchantName\":\"桂源铺\",\"createUsername\":\"Gyp\",\"isDeleted\":0,\"merchantId\":2029080800003446,\"categoryList\":[],\"updateTimeDb\":1541609994000,\"versionNo\":0,\"ruleName\":\"110201计划爱的噶啥的噶事嘎达噶事嘎嘎的嘎嘎嘎阿尔沙文热奥翁仁青安无热\",\"id\":124,\"createUserid\":1886080801000067,\"merchantCode\":\"spx101701\",\"createTimeDb\":1541160127000,\"updateTime\":1541609994000,\"mpList\":[],\"ruleCode\":\"1886082404000003\",\"companyId\":231,\"expireTime\":1541548800000,\"createTime\":1541160072000,\"statusText\":\"已过期\",\"detailList\":[],\"serverIp\":\"127.0.0.1\",\"status\":2},{\"plModelType\":2,\"plModelTypeText\":\"定期自动补货\",\"effectiveTime\":1541030400000,\"orgList\":[],\"remark\":\"哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈\",\"merchantName\":\"可口可乐\",\"createUsername\":\"superadmin\",\"isDeleted\":0,\"merchantId\":2029080800000000,\"categoryList\":[],\"versionNo\":0,\"ruleName\":\"哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈\",\"id\":123,\"createUserid\":18101517160196,\"merchantCode\":\"1\",\"createTimeDb\":1541074825000,\"mpList\":[],\"ruleCode\":\"1886082305000094\",\"companyId\":231,\"expireTime\":1543622400000,\"createTime\":1541074712000,\"statusText\":\"进行中\",\"detailList\":[],\"serverIp\":\"127.0.0.1\",\"status\":1}],\"total\":62}");
        Assert.assertEquals(actualResult.get("data"),expectedData);
//       System.out.println(JSON.toJSONString(o));
    }
      //新增智能补货
    @Test
    public void savePlRule () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":null,\"merchantCodes\":null,\"ruleCode\":\"1886084402000046\",\"ruleName\":\"AAA\",\"plModelType\":\"3\",\"status\":0,\"statusCount\":null,\"effectiveStatus\":null,\"effectiveTime\":\"2018-11-21\",\"expireTime\":\"2018-11-23\",\"storeCode\":null,\"storeName\":null,\"merchantId\":2029080800000000,\"merchantCode\":\"1\",\"merchantName\":\"可口可乐\",\"remark\":null,\"companyId\":null,\"isDeleted\":null,\"versionNo\":null,\"createUserid\":null,\"createUsername\":\"superadmin\",\"createTime\":1542878360643,\"createTimeDb\":null,\"serverIp\":null,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null,\"plRuleJson\":{},\"statusText\":null,\"effectiveStatusText\":null,\"plModelTypeText\":null,\"detailList\":[],\"mpList\":[{\"orgType\":3,\"mpId\":1878082101000246,\"mpCode\":\"1878082101000242\",\"mpName\":\"仓央嘉措\",\"mpBarcode\":\"425\",\"mpBrandName\":\"可口可乐\",\"mpMeasureUnit\":\"件\",\"inventoryTurnoverDay\":7,\"orgId\":1878082002000671,\"orgCode\":\"2333333333\",\"orgName\":\"智能补货测试的\",\"inventoryId\":2029082000010048,\"inventoryCode\":\"2333222222ddd\",\"inventoryName\":\"智能补货测试的\",\"availableStockNum\":0,\"maxStockNum\":9999,\"moqNum\":10,\"mpqNum\":10,\"ongoingPurchaseNum\":\"10\",\"ongoingDistributionNum\":\"10\",\"minOnShelfNum\":\"111\",\"reorderPointNum\":\"1\",\"orderNum\":\"100\"}],\"orgList\":[],\"categoryList\":[]}\n");
        Object o = Ajax.post(driver, savePlRuleUrl, param);
//        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言data
//        JSONObject expectedData = JSON.parseObject("{null}");
//        Assert.assertEquals(actualResult.get("data"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }

    //智能补货结果查询
    @Test
    public void queryPlMpResultList () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-22\",\"createTimeStart\":\"2018-10-23\",\"mpCode\":\"P181018019\",\"mpName\":\"\"}}\n");
         Object o = Ajax.post(driver, queryPlMpResultListUrl, param);
//         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言data
//         JSONObject expectedData = JSON.parseObject("{0}");
//          Assert.assertEquals(actualResult.get("data"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }

    //智能补货结果查询重置
    @Test
    public void queryPlMpResult () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-22\",\"createTimeStart\":\"2018-10-23\",\"mpCode\":\"P181018019\",\"mpName\":\"\"}}\n");
        Object o = Ajax.post(driver, queryPlMpResultUrl, param);
//        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
////        断言data
//        JSONObject expectedData = JSON.parseObject("listObj":[],"total":0}");
//        Assert.assertEquals(actualResult.get("data"),expectedData);
//        System.out.println(JSON.toJSONString(o));

    }

}
