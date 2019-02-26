package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.ody.automation.RestfulAutomationTest;
//import com.ody.automation.RestfulAutomationTest;

//采购收货单
public class queryPurchaseRequestOrderList extends RestfulAutomatedTest {

    //查询要货单
    private String queryPurchaseRequestOrderListUrl = baseUrl+"/opms-web/purchaseRequestOrder/queryPurchaseRequestOrderList.do";
    //重置要货单
    private String queryPurchaseRequestOrderListurl = baseUrl+"/opms-web/purchaseRequestOrder/queryPurchaseRequestOrderList.do";
    //新增要货单
    private String savePurchaseRequestOrderUrl = baseUrl+"/opms-web/purchaseRequestOrder/savePurchaseRequestOrder.do";
    //提交要货单
    private String updatePurchaseRequestOrderList = baseUrl+"/opms-web/purchaseRequestOrder/updatePurchaseRequestOrderList.do";
    //要货单审核通过
    private String auditPurchaseRequestOrderList = baseUrl+"/opms-web/purchaseRequestOrder/auditPurchaseRequestOrderList.do";
    //要货单分配
    private String distributionPurchaseRequestOrder = baseUrl+"/opms-web/purchaseRequestOrder/distributionPurchaseRequestOrder.do";



    //查询要货单
    @Test
    public void queryPurchaseRequestOrderList () throws InterruptedException {

        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"requestType\":\"3\",\"supplyType\":\"1\",\"orderStatus\":\"1\"}}\n");
        Object o = Ajax.post(driver, queryPurchaseRequestOrderListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //断言Data、Message、Code
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取listObj第一个值
        String expectedData1 = "请求成功";
        String expectedData2 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        Assert.assertNotNull(actualResult.get("data"));
        System.out.println(JSON.toJSONString(o));
    }
    //重置要货单
    @Test
    public void queryPurchaseRequestOrderListurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{}}\n");
         Object o = Ajax.post(driver, queryPurchaseRequestOrderListurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言code、message、data
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String requestmerchantId= listObj.getJSONObject(0).getString("requestTypeText");
        String expectedData3 ="自动备货";
        String expectedData1 = "0";
        String expectedData = "请求成功";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertNotNull(actualResult.get("data"));
        Assert.assertEquals(requestmerchantId,expectedData3);
        System.out.println(JSON.toJSONString(o));
    }

      //新增要货单
    @Test
    public void savePurchaseRequestOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"costWithTaxAmt\":\"1555.40\",\"costWithoutTaxAmt\":\"1329.40\",\"costTaxAmt\":\"226.00\",\"requestCount\":\"2.00\",\"requestType\":\"2\",\"supplyType\":\"2\",\"requestMerchantName\":\"P蒙牛商家\",\"requestMerchantCode\":\"CP1001\",\"requestMerchantId\":2029080902003362,\"supplyStoreId\":2029080902003394,\"supplyStoreCode\":\"CP10001\",\"supplyStoreName\":\"CP仓0001\",\"requestStoreName\":\"CP仓0002\",\"requestStoreCode\":\"CP0002\",\"requestStoreId\":2029080902003441,\"requestWarehouseName\":\"仓库1001\",\"requestWarehouseCode\":\"CK10001\",\"requestWarehouseId\":1878080900000558,\"requestDate\":\"2018-12-04\",\"orderStatus\":1,\"productInfo\":[{\"supplyStoreId\":2029080902003394,\"supplyStoreCode\":\"CP10001\",\"supplyStoreName\":\"CP仓0001\",\"supplyType\":\"2\",\"mpId\":1878080900000566,\"mpCode\":\"P181018001\",\"mpName\":\"盖奶\",\"mpBrandName\":\"P奈瑟\",\"mpBarcode\":\"181018001\",\"mpSpec\":null,\"mpMeasureUnit\":\"件\",\"costWithTaxUnitAmt\":88.88,\"costWithoutTaxUnitAmt\":75.9658,\"costTaxRate\":0.17,\"categoryName\":\"饮料\",\"mpTurnoverChannel\":1,\"requestPurchaseCount\":0,\"requestDistributionCount\":0,\"purchaseCount\":0,\"distributionCount\":0,\"costWithTaxAmt\":\"888.80\",\"costWithoutTaxAmt\":\"759.66\",\"costTaxAmt\":129.14,\"requestCount\":10,\"supplyWarehouseName\":\"采配子仓库01\",\"supplyWarehouseCode\":\"CK10002\",\"supplyWarehouseId\":1878080900000561,\"checked\":true},{\"supplyStoreId\":2029080902003394,\"supplyStoreCode\":\"CP10001\",\"supplyStoreName\":\"CP仓0001\",\"supplyType\":\"2\",\"mpId\":1878080900000845,\"mpCode\":\"P181018002\",\"mpName\":\"果冻\",\"mpBrandName\":\"P奈瑟\",\"mpBarcode\":\"181018002\",\"mpSpec\":null,\"mpMeasureUnit\":\"件\",\"costWithTaxUnitAmt\":66.66,\"costWithoutTaxUnitAmt\":56.9743,\"costTaxRate\":0.17,\"categoryName\":\"甜点\",\"mpTurnoverChannel\":null,\"requestPurchaseCount\":0,\"requestDistributionCount\":0,\"purchaseCount\":0,\"distributionCount\":0,\"costWithTaxAmt\":\"666.60\",\"costWithoutTaxAmt\":\"569.74\",\"costTaxAmt\":96.86000000000001,\"requestCount\":10,\"supplyWarehouseName\":\"采配子仓库01\",\"supplyWarehouseCode\":\"CK10002\",\"supplyWarehouseId\":1878080900000561,\"checked\":true}]}\n");
        Object o = Ajax.post(driver, savePurchaseRequestOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言Code、message、data
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String expectedData1 = "0";
        String expectedData = "请求成功";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertNotNull(actualResult.get("data"));
        System.out.println(JSON.toJSONString(o));
    }

    //提交要货单
    @Test
    public void updatePurchaseRequestOrderList  () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"requestTypeText\":\"总部铺货\",\"supplyTypeText\":\"内部门店\",\"orderStatusText\":\"待提交\",\"requestStatusText\":\"未履行\",\"requestDateStart\":null,\"requestDateEnd\":null,\"productInfo\":null,\"purchaseRequestDistribution\":null,\"requestCodeList\":null,\"id\":1886085602000006,\"requestCode\":\"YH1886085602000006\",\"requestType\":2,\"sourceCode\":null,\"requestStoreId\":2029080902003441,\"requestWarehouseId\":1878080900000558,\"requestMerchantId\":2029080902003362,\"merchantIds\":null,\"storeIds\":null,\"requestStoreCode\":\"CP0002\",\"requestStoreName\":\"CP仓0002\",\"requestWarehouseCode\":\"CK10001\",\"requestWarehouseName\":\"仓库1001\",\"requestMerchantCode\":\"CP1001\",\"requestMerchantName\":\"P蒙牛商家\",\"supplyType\":2,\"supplierCode\":null,\"supplierName\":null,\"supplyStoreId\":null,\"supplyStoreCode\":\"CP10001\",\"supplyStoreName\":\"CP仓0001\",\"supplyWarehouseId\":null,\"supplyWarehouseCode\":null,\"supplyWarehouseName\":null,\"supplyMerchantId\":null,\"supplyMerchantCode\":null,\"supplyMerchantName\":null,\"requestCount\":2,\"costWithTaxAmt\":1555.4,\"costWithoutTaxAmt\":1329.4,\"costTaxAmt\":226,\"requestDate\":1543881600000,\"requestDateStr\":\"2018-12-04\",\"auditTime\":null,\"auditUsername\":null,\"completeTime\":null,\"orderStatus\":2,\"requestStatus\":1,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080801000067,\"createUsername\":\"Gyp\",\"createTime\":1543910918000,\"createTimeDb\":1543910895000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null}\n");
         Object o = Ajax.post(driver, updatePurchaseRequestOrderList, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //        断言code、message、data
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

}

    //要货单审核通过
    @Test
    public void auditPurchaseRequestOrderList  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886085602000006,\"requestCode\":\"YH1886085602000006\",\"orderStatus\":\"3\",\"remark\":null}\n");
        Object o = Ajax.post(driver, auditPurchaseRequestOrderList, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code、message、data
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }
    //要货单分配
    @Test
    public void distributionPurchaseRequestOrder  () throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\"id\":1886085602000008,\"ids\":null,\"requestCode\":\"YH1886085602000006\",\"mpId\":1878080900000845,\"mpCode\":\"P181018002\",\"mpName\":\"果冻\",\"mpBarcode\":\"181018002\",\"mpMeasureUnit\":\"件\",\"mpSpec\":null,\"mpType\":null,\"mpBrandCode\":null,\"mpBrandName\":\"P奈瑟\",\"mpConversionRate\":null,\"mpTurnoverChannel\":null,\"mpTurnoverChannelText\":\"\",\"categoryCode\":null,\"categoryName\":\"甜点\",\"merchantCategoryCode\":null,\"merchantCategoryName\":null,\"purchaseStandardCount\":null,\"purchaseStandardMeasureUnit\":null,\"currentStockCount\":null,\"requestCount\":10,\"requestPurchaseCount\":0,\"requestDistributionCount\":0,\"purchaseCount\":0,\"distributionCount\":0,\"costWithTaxAmt\":666.6,\"costWithoutTaxAmt\":569.743,\"costTaxAmt\":96.857,\"costTaxRate\":0.17,\"costWithTaxUnitAmt\":66.66,\"costWithoutTaxUnitAmt\":56.9743,\"supplyType\":2,\"supplierCode\":null,\"supplierName\":null,\"supplyStoreCode\":\"CP10001\",\"supplyStoreId\":2029080902003394,\"supplyStoreName\":\"CP仓0001\",\"supplyWarehouseCode\":\"CK10002\",\"supplyWarehouseId\":1878080900000561,\"supplyWarehouseName\":\"采配子仓库01\",\"supplyMerchantCode\":\"CP1001\",\"supplyMerchantId\":2029080902003362,\"supplyMerchantName\":\"P蒙牛商家\",\"requestStatus\":null,\"requestStatusText\":null,\"requestResultType\":1,\"requestResultTypeText\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080801000067,\"createUsername\":\"Gyp\",\"createTime\":1543910918000,\"createTimeDb\":1543910895000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":1543910895000,\"updateTimeDb\":1543910895000,\"requestDate\":1543881600000,\"requestDateStart\":null,\"requestDateEnd\":null,\"auditTime\":1543911119000,\"completeTime\":null,\"requestStoreId\":2029080902003441,\"requestStoreCode\":\"CP0002\",\"requestStoreName\":\"CP仓0002\",\"requestMerchantId\":2029080902003362,\"requestMerchantCode\":\"CP1001\",\"requestMerchantName\":\"P蒙牛商家\",\"requestWarehouseId\":null,\"requestWarehouseCode\":null,\"requestWarehouseName\":null,\"merchantIds\":null,\"storeIds\":null,\"auditUsername\":\"Gyp\",\"orderStatus\":3,\"orderStatusText\":null,\"orderRequestStatus\":null,\"orderRequestStatusText\":null,\"requestCodes\":null,\"checked\":false,\"supplyTypeText\":\"内部门店\",\"disRequestCount\":10,\"planRequestCount\":10,\"requestType\":2,\"requestTypeText\":null,\"requestPredictResultTypeText\":\"\",\"realStockNum\":null,\"availableStockNum\":null,\"contractList\":[]},{\"id\":1886085602000007,\"ids\":null,\"requestCode\":\"YH1886085602000006\",\"mpId\":1878080900000566,\"mpCode\":\"P181018001\",\"mpName\":\"盖奶\",\"mpBarcode\":\"181018001\",\"mpMeasureUnit\":\"件\",\"mpSpec\":null,\"mpType\":null,\"mpBrandCode\":null,\"mpBrandName\":\"P奈瑟\",\"mpConversionRate\":null,\"mpTurnoverChannel\":1,\"mpTurnoverChannelText\":\"配送DC\",\"categoryCode\":null,\"categoryName\":\"饮料\",\"merchantCategoryCode\":null,\"merchantCategoryName\":null,\"purchaseStandardCount\":null,\"purchaseStandardMeasureUnit\":null,\"currentStockCount\":null,\"requestCount\":10,\"requestPurchaseCount\":1,\"requestDistributionCount\":9,\"purchaseCount\":0,\"distributionCount\":0,\"costWithTaxAmt\":888.8,\"costWithoutTaxAmt\":759.658,\"costTaxAmt\":129.142,\"costTaxRate\":0.17,\"costWithTaxUnitAmt\":88.88,\"costWithoutTaxUnitAmt\":75.9658,\"supplyType\":2,\"supplierCode\":null,\"supplierName\":null,\"supplyStoreCode\":\"CP10001\",\"supplyStoreId\":2029080902003394,\"supplyStoreName\":\"CP仓0001\",\"supplyWarehouseCode\":\"CK10002\",\"supplyWarehouseId\":1878080900000561,\"supplyWarehouseName\":\"采配子仓库01\",\"supplyMerchantCode\":\"CP1001\",\"supplyMerchantId\":2029080902003362,\"supplyMerchantName\":\"P蒙牛商家\",\"requestStatus\":null,\"requestStatusText\":null,\"requestResultType\":2,\"requestResultTypeText\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080801000067,\"createUsername\":\"Gyp\",\"createTime\":1543910918000,\"createTimeDb\":1543910895000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":1543910895000,\"updateTimeDb\":1543910895000,\"requestDate\":1543881600000,\"requestDateStart\":null,\"requestDateEnd\":null,\"auditTime\":1543911119000,\"completeTime\":null,\"requestStoreId\":2029080902003441,\"requestStoreCode\":\"CP0002\",\"requestStoreName\":\"CP仓0002\",\"requestMerchantId\":2029080902003362,\"requestMerchantCode\":\"CP1001\",\"requestMerchantName\":\"P蒙牛商家\",\"requestWarehouseId\":null,\"requestWarehouseCode\":null,\"requestWarehouseName\":null,\"merchantIds\":null,\"storeIds\":null,\"auditUsername\":\"Gyp\",\"orderStatus\":3,\"orderStatusText\":null,\"orderRequestStatus\":null,\"orderRequestStatusText\":null,\"requestCodes\":null,\"checked\":false,\"supplyTypeText\":\"内部门店\",\"disRequestCount\":10,\"planRequestCount\":10,\"requestType\":2,\"requestTypeText\":null,\"requestPredictResultTypeText\":\"供应方采购\",\"realStockNum\":9,\"availableStockNum\":9,\"contractList\":[]}]\n");
        Object o = Ajax.post(driver, distributionPurchaseRequestOrder, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code、message、data
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String expectedData = "要货分配失败，门店CP仓0002,商品果冻没有对应的供应商合同信息";
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }

    

}
