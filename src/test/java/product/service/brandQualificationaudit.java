package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class brandQualificationaudit extends RestfulAutomatedTest {
    //请求商品审核列表
    private String getWhiteListUrl = baseUrl + "/back-product-web2/back/merchantProductAuditWhite/getWhiteList.do";
    //审核通过商家品牌
    private String updateMerchantBrandStatusByIdsUrl = baseUrl + "/back-product-web2/back/merchantBrand/updateMerchantBrandStatusByIds.do";
    //查看商家品牌
    private String getMerchantBrandByIdUrl = baseUrl + "/back-product-web2/back/merchantBrand/getMerchantBrandById.do";
    //翻页
    private String listMerchantBrandUrl = baseUrl + "/back-product-web2/back/merchantBrand/listMerchantBrand.do";
    @Test
    public void getWhiteList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"authMerchantIds\": [2029080800000000, 2029080800003446, 2029080902000000, 2029081500000000, 2029082900000034, 2029082900000037, 2029083000006391, 2029083000006394, 2029083000006397, 2029083000006400, 2029083000006403, 2029083000006406, 2029083000006409, 2029083000006412, 2029083000006415, 2029083000006418, 2029083000006421, 2029083000006424, 2029083000006427, 2029083000006429, 2029083000006431, 2029083000006433, 2029083000006435, 2029083000006437, 2029083000006439, 2029083000006441, 2029083000006443, 2029083000006445, 2029083000006447, 2029083000006449, 2029083000006451, 2029083000006453, 2029083000006455, 2029083000006457, 2029083000006459, 2029083000006461, 2029083000006463]\n" +
                "}");
        Object o = Ajax.post(driver, getWhiteListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);

    }
    @Test
    public void updateMerchantBrandStatusByIds() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"ids\": [1878083000000300],\n" +
                "\t\"status\": 2\n" +
                "}");
        Object o = Ajax.post(driver, updateMerchantBrandStatusByIdsUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test
    public void getMerchantBrandById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"id\": \"1878083000000300\"\n" +
                "}");
        Object o = Ajax.post(driver, getMerchantBrandByIdUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);

    }
 @Test
    public void listMerchantBrand() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 20\n" +
                "}");
        Object o = Ajax.post(driver, listMerchantBrandUrl, param);
     JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

     System.out.println(JSON.toJSONString(o));
     JSONObject data=actualResult.getJSONObject("data");
     JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
     String merchantId= listObj.getJSONObject(0).getString("merchantId");
//     String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        //断言merchantCode，定义一个常量并赋值，预期结果
     String expectedData ="2029080800000000";
//     String expectedData1 ="可口可乐";
     String expectedData2= "0";
     Assert.assertEquals(merchantId,expectedData);
//     Assert.assertEquals(merchantName,expectedData1);
     Assert.assertEquals(actualResult.get("code"),expectedData2);
//     System.out.println(merchantName);
     System.out.println(merchantId);
    }

}
