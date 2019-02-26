package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//退货单
public class PurchaseReturn extends RestfulAutomatedTest {

    //退货单查询
    private String selectPurchaseReturnUrl = baseUrl+"/opms-web/purchaseReturnOrder/selectPurchaseReturnOrderList.do";
    //重置退货单查询条件
    private String selectPurchaseReturnurl = baseUrl+"/opms-web/purchaseReturnOrder/selectPurchaseReturnOrderList.do";
    //退货单保存
    private String savePurchaseReturnOrderUrl = baseUrl+"/opms-web/purchaseReturnOrder/savePurchaseReturnOrder.do";
    //退货单提交
    private String selectPurchaseReturnOrderListUrl = baseUrl+"/opms-web/purchaseReturnOrder/selectPurchaseReturnOrderList.do";
    //退货单审核通过
    private String selectPurchaseReturnOrderListurl = baseUrl+"/opms-web/purchaseReturnOrder/selectPurchaseReturnOrderList.do";




    //退货单查询
    @Test
    public void selectPurchaseReturnUrl () throws InterruptedException {

        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"endCreateTime\":\"2018-11-29\",\"startCreateTime\":\"2018-10-30\",\"orderStatus\":null,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"returnStoreName\":\"CP仓0001\",\"returnStoreCode\":\"CP10001\",\"returnStoreId\":2029080902003394}}\n");
        Object o = Ajax.post(driver, selectPurchaseReturnUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //断言Data、Message、Code
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertNotNull(actualResult.get("data"));

        System.out.println(JSON.toJSONString(o));
    }
    //重置退货单查询条件
    @Test
    public void selectPurchaseReturnurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"endCreateTime\":\"2018-11-29\",\"startCreateTime\":\"2018-10-30\",\"orderStatus\":null}}\n");
         Object o = Ajax.post(driver, selectPurchaseReturnurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言code、message、data
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String expectedData1 = "0";
        String expectedData = "请求成功";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertNotNull(actualResult.get("data"));
        System.out.println(JSON.toJSONString(o));
    }

      //退货单保存
    @Test
    public void savePurchaseReturnOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":null,\"returnStoreIds\":null,\"returnCode\":\"TH1886085102000002\",\"returnType\":null,\"receiveCode\":\"SH1886084902000031\",\"purchaseCode\":null,\"purchaseMerchantCode\":null,\"purchaseMerchantName\":null,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"returnStoreId\":2029080902003394,\"returnStoreCode\":\"CP10001\",\"returnStoreName\":\"CP仓0001\",\"returnWarehouseId\":null,\"returnWarehouseCode\":null,\"returnWarehouseName\":null,\"returnMerchantId\":2029080902003362,\"returnMerchantCode\":\"CP1001\",\"returnMerchantName\":\"P蒙牛商家\",\"operatorName\":null,\"costWithTaxAmt\":null,\"costWithoutTaxAmt\":null,\"costTaxAmt\":null,\"returnDate\":\"2018-11-29\",\"auditTime\":null,\"auditUsename\":null,\"completeTime\":null,\"orderStatus\":1,\"returnStatus\":null,\"isMpq\":null,\"costAccountingCode\":null,\"costAccountingName\":null,\"srcSystem\":null,\"remark\":null,\"companyId\":null,\"isDeleted\":null,\"versionNo\":null,\"createUserid\":null,\"createUsername\":\"superadmin\",\"createTime\":1543470992681,\"createTimeDb\":null,\"serverIp\":null,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null,\"startAuditTime\":null,\"endAuditTime\":null,\"startCreateTime\":null,\"endCreateTime\":null,\"productCodeBarcode\":null,\"productName\":null,\"orderStatusText\":null,\"productList\":[{\"mpId\":1878080902000906,\"mpName\":\"鱿鱼卷\",\"mpCode\":\"P181018003\",\"mpBarcode\":\"181018003\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":1,\"mpBrandCode\":\"181018003\",\"categoryCode\":null,\"categoryName\":\"其他\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886084902000031\",\"purchaseCode\":null,\"receiveProductId\":1886084902000034,\"purchaseProductId\":null,\"stockCount\":5,\"returnWarehouseId\":1878080900000561,\"returnWarehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"50.00\",\"costWithoutTaxAmt\":\"48.55\",\"returnWarehouseCode\":\"CK10002\",\"returnCount\":5},{\"mpId\":1878080900000845,\"mpName\":\"果冻\",\"mpCode\":\"P181018002\",\"mpBarcode\":\"181018002\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":1,\"mpBrandCode\":\"181018002\",\"categoryCode\":null,\"categoryName\":\"甜点\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886084902000031\",\"purchaseCode\":null,\"receiveProductId\":1886084902000033,\"purchaseProductId\":null,\"stockCount\":5,\"returnWarehouseId\":1878080900000561,\"returnWarehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"50.00\",\"costWithoutTaxAmt\":\"48.55\",\"returnWarehouseCode\":\"CK10002\",\"returnCount\":5},{\"mpId\":1878080900000566,\"mpName\":\"盖奶\",\"mpCode\":\"P181018001\",\"mpBarcode\":\"181018001\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":1,\"mpBrandCode\":\"181018001\",\"categoryCode\":null,\"categoryName\":\"饮料\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886084902000031\",\"purchaseCode\":null,\"receiveProductId\":1886084902000032,\"purchaseProductId\":null,\"stockCount\":5,\"returnWarehouseId\":1878080900000561,\"returnWarehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"50.00\",\"costWithoutTaxAmt\":\"48.55\",\"returnWarehouseCode\":\"CK10002\",\"returnCount\":5}]}");
        Object o = Ajax.post(driver, savePurchaseReturnOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言Code
        String expectedData1 = "20002";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));
    }

    //退货单提交
    @Test
    public void selectPurchaseReturnOrderListUrl  () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"endCreateTime\":\"2018-11-29\",\"startCreateTime\":\"2018-10-30\",\"orderStatus\":null}}\n");
         Object o = Ajax.post(driver, selectPurchaseReturnOrderListUrl, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //        断言code、message、data
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertNotNull(actualResult.get("data"));
        System.out.println(JSON.toJSONString(o));

}

    //退货单审核通过
    @Test
    public void selectPurchaseReturnOrderListurl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"endCreateTime\":\"2018-11-29\",\"startCreateTime\":\"2018-10-30\",\"orderStatus\":null}}\n");
        Object o = Ajax.post(driver, selectPurchaseReturnOrderListurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code、message
        String expectedData = "请求成功";
        String expectedData1 = "0";
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertNotNull(actualResult.get("data"));
        System.out.println(JSON.toJSONString(o));

    }

    

}
