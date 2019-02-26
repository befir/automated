package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productAuditwhitelist  extends RestfulAutomatedTest {
    //查询白名单列表
    private String getWhiteListUrl = baseUrl + "/back-product-web2/back/merchantProductAuditWhite/getWhiteList.do";
    //新增白名单
    private String addWhiteUrl = baseUrl + "/back-product-web2/back/merchantProductAuditWhite/addWhite.do";
    //删除白名单
    private String deleteWhiteUrl = baseUrl + "/back-product-web2/back/merchantProductAuditWhite/deleteWhite.do";
    @Test
    public void getWhiteList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"authMerchantIds\": [2029080800000000, 2029080800003446, 2029080902000000, 2029081500000000, 2029082900000034, 2029082900000037, 2029083000006391, 2029083000006394, 2029083000006397, 2029083000006400, 2029083000006403, 2029083000006406, 2029083000006409, 2029083000006412, 2029083000006415, 2029083000006418, 2029083000006421, 2029083000006424, 2029083000006427, 2029083000006429, 2029083000006431, 2029083000006433, 2029083000006435, 2029083000006437, 2029083000006439, 2029083000006441, 2029083000006443, 2029083000006445, 2029083000006447, 2029083000006449, 2029083000006451, 2029083000006453, 2029083000006455, 2029083000006457, 2029083000006459, 2029083000006461, 2029083000006463]\n" +
                "}");
        Object o = Ajax.post(driver, getWhiteListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);

        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void addWhite() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"objRefs\": [1878082101000421]\n" +
                "}");
        Object o = Ajax.post(driver, addWhiteUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "REPEAT_AUDIT_MANAGE";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);

        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void deleteWhite() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": 1878080902001049,\n" +
                "\t\"isAvailable\": null,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": null,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": null,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"merchantId\": 2029080800000000,\n" +
                "\t\"ruleCode\": null,\n" +
                "\t\"ruleName\": null,\n" +
                "\t\"type\": 0,\n" +
                "\t\"priorityLevel\": 1,\n" +
                "\t\"merchantProductStatus\": 2,\n" +
                "\t\"objType\": 1,\n" +
                "\t\"objRefs\": null,\n" +
                "\t\"objRef\": 1878080800000006,\n" +
                "\t\"includeType\": 1,\n" +
                "\t\"checked\": null,\n" +
                "\t\"fullNamePath\": \"后台类目-下午茶-饮料\",\n" +
                "\t\"merchantCode\": null\n" +
                "}]");
        Object o = Ajax.post(driver, deleteWhiteUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);

        System.out.println(JSON.toJSONString(o));
    }


}
