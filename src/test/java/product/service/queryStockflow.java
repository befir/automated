package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class queryStockflow extends RestfulAutomatedTest {
    private String listImWarehouseStockJournalRecordByPageUrl = baseUrl + "/back-product-web2/back/stock/listImWarehouseStockJournalRecordByPage.do";
    private String listImWarehouseRealStockByPageUrl = baseUrl + "/back-product-web2/back/stock/listImWarehouseStockJournalRecordByPage.do";
    private String listImVirtualWarehouseStockByPageUrl = baseUrl + "/back-product-web2/back/stock/listImVirtualWarehouseStockByPage.do";
    private String listImVirtualChannelStockByPageUrl = baseUrl + "/back-product-web2/back/stock/listImVirtualChannelStockByPage.do";

    private String queryStoreProductByPageUrl = baseUrl + "/back-product-web2/back/storeProduct/queryStoreProductByPage.do";
    @Test
    //查询实际库存流水列表
    public void listImWarehouseStockJournalRecordByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listImWarehouseStockJournalRecordByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String brandName= listObj.getJSONObject(0).getString("brandName");
        String imWarehouseRealStockId= listObj.getJSONObject(0).getString("imWarehouseRealStockId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="1878080801000348";
        String expectedData2= "0";
        Assert.assertEquals(brandName,expectedData);
        Assert.assertEquals(imWarehouseRealStockId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(imWarehouseRealStockId);
        System.out.println(brandName);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //查询实际库存管理列表
    public void listImWarehouseRealStockByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listImWarehouseRealStockByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String brandName= listObj.getJSONObject(0).getString("brandName");
        String imWarehouseRealStockId= listObj.getJSONObject(0).getString("imWarehouseRealStockId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="1878080801000348";
        String expectedData2= "0";
        Assert.assertEquals(brandName,expectedData);
        Assert.assertEquals(imWarehouseRealStockId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(imWarehouseRealStockId);
        System.out.println(brandName);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //查询拟合库存管理列表
    public void listImVirtualWarehouseStockByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listImVirtualWarehouseStockByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String brandName= listObj.getJSONObject(0).getString("brandName");
//        String imWarehouseRealStockId= listObj.getJSONObject(0).getString("imWarehouseRealStockId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="1878080801000348";
        String expectedData2= "0";
//        Assert.assertEquals(brandName,expectedData);
//        Assert.assertEquals(imWarehouseRealStockId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(imWarehouseRealStockId);
//        System.out.println(brandName);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //查询渠道库存管理列表
    public void listImVirtualChannelStockByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listImVirtualChannelStockByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String brandName= listObj.getJSONObject(0).getString("brandName");
//        String imWarehouseRealStockId= listObj.getJSONObject(0).getString("imWarehouseRealStockId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="可口可乐";
        String expectedData1 ="1878080801000348";
        String expectedData2= "0";
//        Assert.assertEquals(brandName,expectedData);
//        Assert.assertEquals(imWarehouseRealStockId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(imWarehouseRealStockId);
//        System.out.println(brandName);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //查询库存组织商品
    public void queryStoreProductByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10\n" +
                "}");
        Object o = Ajax.post(driver, queryStoreProductByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String brandName= listObj.getJSONObject(0).getString("brandName");
        String imWarehouseRealStockId= listObj.getJSONObject(0).getString("imWarehouseRealStockId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="可口可乐";
        String expectedData1 ="1878080801000348";
        String expectedData2= "0";
        Assert.assertEquals(brandName,expectedData);
        Assert.assertEquals(imWarehouseRealStockId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(imWarehouseRealStockId);
        System.out.println(brandName);
        System.out.println(JSON.toJSONString(o));
    }
}
