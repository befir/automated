package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class avancedPricing  extends RestfulAutomatedTest {
    //查询价目表
    private String listPriceSheetByPageUrl = baseUrl + "/back-product-web2/back/merchantProductPrice/listPriceSheetByPage.do";
    //请求商务页面
    private String queryPlatformAuthMerchantPageUrl = baseUrl + "/back-merchant-web/api/merchant/queryPlatformAuthMerchantPage.do";
    //请求渠道
    private String getMerchantChannelListUrl = baseUrl + "/back-merchant-web/api/merchant/getMerchantChannelList.do";
    //新增价目表
    private String savePriceSheetUrl = baseUrl + "/back-product-web2/back/merchantProductPrice/savePriceSheet.do";

    @Test
    public void listPriceSheetByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listPriceSheetByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String merchantId= listObj.getJSONObject(0).getString("merchantId");

//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="2029080800003446";
        String expectedData2= "0";
        Assert.assertEquals(merchantId,expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
    }

    @Test
    public void queryPlatformAuthMerchantPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, queryPlatformAuthMerchantPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="2029080800000000";
        String expectedData1 ="可口可乐";
        String expectedData2= "0";
        Assert.assertEquals(merchantId,expectedData);
        Assert.assertEquals(merchantName,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantName);
        System.out.println(merchantId);
    }

    @Test
    public void getMerchantChannelList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": 2029080800003446\n" +
                "}");
        Object o = Ajax.post(driver, getMerchantChannelListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
    public void savePriceSheet() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"status\": 1,\n" +
                "\t\"sort\": 201811020001,\n" +
                "\t\"priceSheetCode\": \"S201811020001\",\n" +
                "\t\"priceSheetName\": \"价目1\",\n" +
                "\t\"startDate\": \"2018-11-02\",\n" +
                "\t\"endDate\": \"2018-11-30\",\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"channelCodes\": \"_110001,\",\n" +
                "\t\"strategyVOList\": [{\n" +
                "\t\t\"refId\": 1,\n" +
                "\t\t\"refCode\": \"1878081602000041\",\n" +
                "\t\t\"refName\": \"鸡米花\",\n" +
                "\t\t\"objectUnit\": \"3\",\n" +
                "\t\t\"assistUnitName\": \"3\",\n" +
                "\t\t\"mainUnitName\": \"个\",\n" +
                "\t\t\"calcType\": 1,\n" +
                "\t\t\"price\": \"12\"\n" +
                "\t}]\n" +
                "}");
        param.put("priceSheetCode",dateFormat.format(new Date()));
        param.put("priceSheetName","价目"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver, savePriceSheetUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
}
