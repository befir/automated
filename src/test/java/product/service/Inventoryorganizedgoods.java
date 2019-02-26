package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Inventoryorganizedgoods extends RestfulAutomatedTest {
    //查询库存组织商品
    private String queryStoreProductByPageUrl = baseUrl + "/back-product-web2/back/storeProduct/queryStoreProductByPage.do";
    //批量禁用
    private String updateStoreProductStatusBatchUrl = baseUrl + "/back-product-web2/back/storeProduct/updateStoreProductStatusBatch.do";
    //修改经营状态
    private String updateStoreProductOpStrategyBatchUrl = baseUrl + "/back-product-web2/back/storeProduct/updateStoreProductOpStrategyBatch.do";
    //请求库存组织商品页面
    private String getAuthInventoryPageUrl = baseUrl + "/back-merchant-web/api/merchant/getAuthInventoryPage.do";
    //编辑库存组织商品详情页面
    private String updateStoreMerchantDetailUrl = baseUrl + "/back-product-web2/back/storeProduct/updateStoreMerchantDetail.do";

    @Test
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
        String productCode= listObj.getJSONObject(0).getString("productCode");
        String categoryId= listObj.getJSONObject(0).getString("categoryId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878082203000018";
        String expectedData1 ="1878080900000425";
        String expectedData2= "0";
        Assert.assertEquals(productCode,expectedData);
        Assert.assertEquals(categoryId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(categoryId);
        System.out.println(productCode);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateStoreProductStatusBatch() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\n" +
                "\t\"id\": 1878083000000213,\n" +
                "\t\"isAvailable\": 0\n" +
                "}, {\n" +
                "\t\"id\": 1878082402000458,\n" +
                "\t\"isAvailable\": 0\n" +
                "}]");
        Object o = Ajax.post(driver, updateStoreProductStatusBatchUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String productCode= listObj.getJSONObject(0).getString("productCode");
//        String categoryId= listObj.getJSONObject(0).getString("categoryId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878082203000018";
        String expectedData1 ="1878080900000425";
        String expectedData2= "0";
//        Assert.assertEquals(productCode,expectedData);
//        Assert.assertEquals(categoryId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(categoryId);
//        System.out.println(productCode);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateStoreProductOpStrategyBatch() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\n" +
                "\t\"id\": 1878083000000213,\n" +
                "\t\"operationStrategyId\": 5804033004405396\n" +
                "}]");
        Object o = Ajax.post(driver, updateStoreProductOpStrategyBatchUrl, param);
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
    public void getAuthInventoryPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": \"2029080800003446\",\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 500\n" +
                "}");
        Object o = Ajax.post(driver, getAuthInventoryPageUrl, param);
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
    public void updateStoreMerchantDetail() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": 1878083000000213,\n" +
                "\t\"isAvailable\": 0,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": null,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": null,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"canDistribution\": 1,\n" +
                "\t\"canSale\": 0,\n" +
                "\t\"canSaleReturn\": 0,\n" +
                "\t\"canPurchase\": 1,\n" +
                "\t\"canPurchaseReturn\": 1,\n" +
                "\t\"dmsCoefficientDay\": null,\n" +
                "\t\"turnoverChannel\": 1,\n" +
                "\t\"defaultSupplierId\": null,\n" +
                "\t\"defaultPurchaseOrg\": null,\n" +
                "\t\"defautPurchasesStoreId\": null,\n" +
                "\t\"defautPurchaseWarehouseId\": null,\n" +
                "\t\"defautPurchaserId\": null,\n" +
                "\t\"defautPurchaseSchedulerId\": null,\n" +
                "\t\"productId\": 1878082801000212,\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"storeId\": -1,\n" +
                "\t\"inventoryId\": 2029080801000004,\n" +
                "\t\"operationStrategyId\": 5804033004405396,\n" +
                "\t\"deliveryType\": null,\n" +
                "\t\"canBatchCtrl\": 0,\n" +
                "\t\"canSequenceCtrl\": 0,\n" +
                "\t\"stockSchedulerTypeId\": null,\n" +
                "\t\"sequenceSource\": null,\n" +
                "\t\"channelCode\": \"-1\",\n" +
                "\t\"orderStartNum\": null,\n" +
                "\t\"orderMultipleNum\": null,\n" +
                "\t\"priceLevel\": null,\n" +
                "\t\"itemId\": null,\n" +
                "\t\"dataType\": null,\n" +
                "\t\"actualStock\": null,\n" +
                "\t\"storeCode\": null,\n" +
                "\t\"storeName\": null,\n" +
                "\t\"merchantName\": \"桂源铺\",\n" +
                "\t\"productCode\": \"1878082801000211\",\n" +
                "\t\"productName\": \"百褶裙\",\n" +
                "\t\"productArr\": null,\n" +
                "\t\"mainUnitName\": \"件\",\n" +
                "\t\"artNo\": null,\n" +
                "\t\"brandName\": \"桂源铺\",\n" +
                "\t\"categoryName\": \"后台类目-下午茶-其他\",\n" +
                "\t\"modelType\": null,\n" +
                "\t\"barcode\": null,\n" +
                "\t\"opStatusCode\": \"0001\",\n" +
                "\t\"opStatusName\": \"正常经营\",\n" +
                "\t\"defaultSupplierSources\": null,\n" +
                "\t\"defaultStoreSources\": null,\n" +
                "\t\"storageSources\": null,\n" +
                "\t\"batchNumberPrefix\": null,\n" +
                "\t\"nextBatchNumberPrefix\": null,\n" +
                "\t\"stockSchedulerType\": null,\n" +
                "\t\"replenishAdvancedPeriod\": null,\n" +
                "\t\"schedulerStaffs\": null,\n" +
                "\t\"purchaseStaffs\": null,\n" +
                "\t\"salePrice\": 30,\n" +
                "\t\"marketPrice\": null,\n" +
                "\t\"purchasePrice\": null,\n" +
                "\t\"startItem\": 0,\n" +
                "\t\"inventoryCode\": \"101701\",\n" +
                "\t\"inventoryName\": \"桂源铺组织\"\n" +
                "}");
        Object o = Ajax.post(driver, updateStoreMerchantDetailUrl, param);
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
