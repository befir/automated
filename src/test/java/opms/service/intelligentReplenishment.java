package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class intelligentReplenishment extends RestfulAutomatedTest {
    //查询规则
    private String selectPlRuleListurl = baseUrl+"/opms-web/plRule/selectPlRuleList.do";
   //查询规则列表
    private String selectPlRuleCountListByStatusurl = baseUrl+"/opms-web/plRule/selectPlRuleCountListByStatus.do";
    //新增计划页面
    private String getNewPlRuleurl = baseUrl+"/opms-web/plRule/getNewPlRule.do";
   //获取店铺
    private String queryStoreListurl = baseUrl+"/opms-web/merchantRead/queryStoreList.do";
    //请求库存组织
    private String queryWarehouseListurl = baseUrl+"/opms-web/warehouse/queryWarehouseList.do";
    //请求商品列表
    private String getStoreProductListurl = baseUrl+"/opms-web/product/getStoreProductList.do";
    //保存计划
    private String savePlRuleurl = baseUrl+"/opms-web/plRule/savePlRule.do";


    @Test
    public void selectPlRuleList() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10\n" +
                "}");
                Object o = Ajax.post(driver, selectPlRuleListurl, editRegisterparam);
    System.out.println(JSON.toJSONString(o));

    }
    @Test
    public void selectPlRuleCountListByStatus() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10\n" +
                "}");
                Object o = Ajax.post(driver, selectPlRuleCountListByStatusurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));


    }
    @Test
    public void getNewPlRule() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10\n" +
                "}");
                Object o = Ajax.post(driver, getNewPlRuleurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));


    }
    @Test
    public void queryStoreList() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"obj\": {\n" +
                "\t\t\"merchantCode\": \"spx101701\"\n" +
                "\t}\n" +
                "}");
                Object o = Ajax.post(driver, queryStoreListurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));


    }
    @Test
    public void queryWarehouseList() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"storeId\": 2029083400000176\n" +
                "}");
                Object o = Ajax.post(driver, queryWarehouseListurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));


    }
    @Test
    public void getStoreProductList() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"obj\": {\n" +
                "\t\t\"merchantIds\": [2029080800003446],\n" +
                "\t\t\"storeName\": \"桂源铺组织02\",\n" +
                "\t\t\"storeCode\": \"spx1112\",\n" +
                "\t\t\"storeId\": 2029083400000176,\n" +
                "\t\t\"warehouseName\": \"桃花仓20181115135900\",\n" +
                "\t\t\"warehouseCode\": \"20181115135900\",\n" +
                "\t\t\"warehouseId\": 1878083700000014,\n" +
                "\t\t\"barcodes\": []\n" +
                "\t}\n" +
                "}");
                Object o = Ajax.post(driver, getStoreProductListurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));


    }
@Test
    public void savePlRule() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"id\": null,\n" +
                "\t\"merchantCodes\": null,\n" +
                "\t\"ruleCode\": \"1886084302000092\",\n" +
                "\t\"ruleName\": \"11.21计划\",\n" +
                "\t\"plModelType\": \"3\",\n" +
                "\t\"status\": 0,\n" +
                "\t\"statusCount\": null,\n" +
                "\t\"effectiveStatus\": null,\n" +
                "\t\"effectiveTime\": \"2018-11-21\",\n" +
                "\t\"expireTime\": \"2018-11-30\",\n" +
                "\t\"storeCode\": null,\n" +
                "\t\"storeName\": null,\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"merchantCode\": \"spx101701\",\n" +
                "\t\"merchantName\": \"桂源铺\",\n" +
                "\t\"remark\": null,\n" +
                "\t\"companyId\": null,\n" +
                "\t\"isDeleted\": null,\n" +
                "\t\"versionNo\": null,\n" +
                "\t\"createUserid\": null,\n" +
                "\t\"createUsername\": \"Gyp\",\n" +
                "\t\"createTime\": 1542790930244,\n" +
                "\t\"createTimeDb\": null,\n" +
                "\t\"serverIp\": null,\n" +
                "\t\"updateUserid\": null,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": null,\n" +
                "\t\"updateTimeDb\": null,\n" +
                "\t\"plRuleJson\": {},\n" +
                "\t\"statusText\": null,\n" +
                "\t\"effectiveStatusText\": null,\n" +
                "\t\"plModelTypeText\": null,\n" +
                "\t\"detailList\": [],\n" +
                "\t\"mpList\": [{\n" +
                "\t\t\"orgType\": 3,\n" +
                "\t\t\"mpId\": 1878083400000383,\n" +
                "\t\t\"mpCode\": \"1878083400000379\",\n" +
                "\t\t\"mpName\": \"大水果\",\n" +
                "\t\t\"mpBarcode\": null,\n" +
                "\t\t\"mpBrandName\": \"桂源铺\",\n" +
                "\t\t\"mpMeasureUnit\": \"对\",\n" +
                "\t\t\"inventoryTurnoverDay\": 7,\n" +
                "\t\t\"orgId\": 1878083700000014,\n" +
                "\t\t\"orgCode\": \"20181115135900\",\n" +
                "\t\t\"orgName\": \"桃花仓20181115135900\",\n" +
                "\t\t\"inventoryId\": 2029083400000176,\n" +
                "\t\t\"inventoryCode\": \"spx1112\",\n" +
                "\t\t\"inventoryName\": \"桂源铺组织02\",\n" +
                "\t\t\"availableStockNum\": 0,\n" +
                "\t\t\"maxStockNum\": 9999,\n" +
                "\t\t\"moqNum\": 10,\n" +
                "\t\t\"mpqNum\": 10,\n" +
                "\t\t\"ongoingPurchaseNum\": \"1\",\n" +
                "\t\t\"ongoingDistributionNum\": \"1\",\n" +
                "\t\t\"minOnShelfNum\": 1,\n" +
                "\t\t\"reorderPointNum\": \"1\",\n" +
                "\t\t\"orderNum\": \"1\"\n" +
                "\t}],\n" +
                "\t\"orgList\": [],\n" +
                "\t\"categoryList\": []\n" +
                "}");
                Object o = Ajax.post(driver, savePlRuleurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));


    }


}
