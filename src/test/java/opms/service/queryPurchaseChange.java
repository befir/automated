package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//更正单
public class queryPurchaseChange extends RestfulAutomatedTest {

    //更正单查询
    private String queryPurchaseChangeOrderListUrl = baseUrl+"/opms-web/purchaseChangeOrderAction/queryPurchaseChangeOrderList.do";
    //更正单重置
    private String queryPurchaseChangeOrderListurl = baseUrl+"/opms-web/purchaseChangeOrderAction/queryPurchaseChangeOrderList.do";
    //收货更正单
    private String addPurchaseChangeOrderUrl = baseUrl+"/opms-web/purchaseChangeOrderAction/addPurchaseChangeOrder.do";
    //退货更正单
    private String addPurchaseChangeOrderurl = baseUrl+"/opms-web/purchaseChangeOrderAction/addPurchaseChangeOrder.do";
    //更正单提交
    private String submitPurchaseChangeOrderUrl = baseUrl+"/opms-web/purchaseChangeOrderAction/submitPurchaseChangeOrder.do";
    //更正单审核通过
    private String auditPurchaseChangeOrderUrl = baseUrl+"/opms-web/purchaseChangeOrderAction/auditPurchaseChangeOrder.do";



    //更正单查询
    @Test
    public void queryPurchaseChangeOrderListUrl () throws InterruptedException {

        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-30\",\"createTimeStart\":\"2018-11-01\",\"changeType\":\"3\",\"supplierName\":\"P蒙牛供应商\",\"supplierCode\":\"1886081603000000\",\"storeName\":\"CP仓0001\",\"storeCode\":\"CP10001\",\"storeId\":2029080902003394}}\n");
        Object o = Ajax.post(driver, queryPurchaseChangeOrderListUrl, param);
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
    //更正单重置
    @Test
    public void queryPurchaseChangeOrderListurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-30\",\"createTimeStart\":\"2018-11-01\"}}\n");
         Object o = Ajax.post(driver, queryPurchaseChangeOrderListurl, param);
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

      //收货更正单
    @Test
    public void addPurchaseChangeOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":null,\"changeCode\":\"GZ1811301886085202000000\",\"changeType\":2,\"changeTypeText\":\"入库更正\",\"receiveCode\":\"SH1886083002000007\",\"returnCode\":null,\"purchaseCode\":null,\"purchaseMerchantCode\":null,\"purchaseMerchantName\":null,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"storeId\":2029080902003394,\"storeIds\":null,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"costWithTaxAmt\":null,\"costWithoutTaxAmt\":null,\"costTaxAmt\":null,\"changeDate\":1543550084474,\"changeDateStart\":null,\"changeDateEnd\":null,\"auditTime\":null,\"auditUsename\":null,\"completeTime\":null,\"completeTimeStart\":null,\"completeTimeEnd\":null,\"orderStatus\":1,\"orderStatusText\":\"待提交\",\"remark\":null,\"companyId\":null,\"isDeleted\":null,\"versionNo\":null,\"createUserid\":null,\"createUsername\":null,\"createTime\":\"2018-11-30\",\"createTimeDb\":null,\"serverIp\":null,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null,\"products\":[{\"changeType\":\"2\",\"mpId\":1878080902000922,\"mpName\":\"蛋挞\",\"mpCode\":\"P181018005\",\"mpBarcode\":\"181018005\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"个\",\"mpType\":null,\"mpBrandCode\":null,\"categoryCode\":null,\"categoryName\":\"蛋糕\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886083002000007\",\"purchaseCode\":null,\"purchaseProductId\":null,\"oldCount\":10,\"receiveProductId\":1886083002000010,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"storeId\":2029080902003394,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"warehouseId\":1878080900000561,\"warehouseCode\":\"CK10002\",\"warehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"10.00\",\"costWithoutTaxAmt\":\"9.71\",\"costTaxAmt\":\"0.29\",\"changeCount\":\"1.0000\",\"newCount\":\"11\",\"checked\":true},{\"changeType\":\"2\",\"mpId\":1878080900000845,\"mpName\":\"果冻\",\"mpCode\":\"P181018002\",\"mpBarcode\":\"181018002\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":null,\"mpBrandCode\":null,\"categoryCode\":null,\"categoryName\":\"甜点\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886083002000007\",\"purchaseCode\":null,\"purchaseProductId\":null,\"oldCount\":10,\"receiveProductId\":1886083002000009,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"storeId\":2029080902003394,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"warehouseId\":1878080900000561,\"warehouseCode\":\"CK10002\",\"warehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"10.00\",\"costWithoutTaxAmt\":\"9.71\",\"costTaxAmt\":\"0.29\",\"changeCount\":\"1.0000\",\"newCount\":\"11\",\"checked\":true},{\"changeType\":\"2\",\"mpId\":1878080900000566,\"mpName\":\"盖奶\",\"mpCode\":\"P181018001\",\"mpBarcode\":\"181018001\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":null,\"mpBrandCode\":null,\"categoryCode\":null,\"categoryName\":\"饮料\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886083002000007\",\"purchaseCode\":null,\"purchaseProductId\":null,\"oldCount\":10,\"receiveProductId\":1886083002000008,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"storeId\":2029080902003394,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"warehouseId\":1878080900000561,\"warehouseCode\":\"CK10002\",\"warehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"10.00\",\"costWithoutTaxAmt\":\"9.71\",\"costTaxAmt\":\"0.29\",\"changeCount\":\"1.0000\",\"newCount\":\"11\",\"checked\":true}],\"receiveOrder\":null,\"purchaseOrder\":null,\"inStockOrder\":null,\"receiveUser\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"receiveTimeStart\":null,\"receiveTimeEnd\":null,\"inStockTimeStart\":null,\"inStockTimeEnd\":null,\"mpName\":null,\"mpCode\":null}\n");
        Object o = Ajax.post(driver, addPurchaseChangeOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言Code
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));
    }

    //退货更正单
    @Test
    public void addPurchaseChangeOrderurl  () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"id\":null,\"changeCode\":\"GZ1811301886085202000008\",\"changeType\":3,\"changeTypeText\":\"退货更正\",\"receiveCode\":\"SH1886082902000000\",\"returnCode\":\"TH1886082902000004\",\"purchaseCode\":null,\"purchaseMerchantCode\":null,\"purchaseMerchantName\":null,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"storeId\":2029080902003394,\"storeIds\":null,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"costWithTaxAmt\":null,\"costWithoutTaxAmt\":null,\"costTaxAmt\":null,\"changeDate\":1543550400674,\"changeDateStart\":null,\"changeDateEnd\":null,\"auditTime\":null,\"auditUsename\":null,\"completeTime\":null,\"completeTimeStart\":null,\"completeTimeEnd\":null,\"orderStatus\":1,\"orderStatusText\":\"待提交\",\"remark\":null,\"companyId\":null,\"isDeleted\":null,\"versionNo\":null,\"createUserid\":null,\"createUsername\":null,\"createTime\":\"2018-11-30\",\"createTimeDb\":null,\"serverIp\":null,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null,\"products\":[{\"changeType\":\"3\",\"mpId\":1878080902000947,\"mpName\":\"桂花糕\",\"mpCode\":\"P181018009\",\"mpBarcode\":\"181018009\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":1,\"mpBrandCode\":null,\"categoryCode\":null,\"categoryName\":\"甜点\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886082902000000\",\"purchaseCode\":null,\"returnCode\":\"TH1886082902000004\",\"purchaseProductId\":null,\"oldCount\":4,\"returnProductId\":1886082902000006,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"storeId\":2029080902003394,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"warehouseId\":1878080900000561,\"warehouseCode\":\"CK10002\",\"warehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"10.00\",\"costWithoutTaxAmt\":\"9.71\",\"costTaxAmt\":\"0.29\",\"changeCount\":\"1.0000\",\"newCount\":\"5\"},{\"changeType\":\"3\",\"mpId\":1878080902000941,\"mpName\":\"糖炒栗子\",\"mpCode\":\"P181018008\",\"mpBarcode\":\"181018008\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":1,\"mpBrandCode\":null,\"categoryCode\":null,\"categoryName\":\"其他\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886082902000000\",\"purchaseCode\":null,\"returnCode\":\"TH1886082902000004\",\"purchaseProductId\":null,\"oldCount\":3,\"returnProductId\":1886082902000007,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"storeId\":2029080902003394,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"warehouseId\":1878080900000561,\"warehouseCode\":\"CK10002\",\"warehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"10.00\",\"costWithoutTaxAmt\":\"9.71\",\"costTaxAmt\":\"0.29\",\"changeCount\":\"1.0000\",\"newCount\":\"4\"},{\"changeType\":\"3\",\"mpId\":1878080902000935,\"mpName\":\"薯片\",\"mpCode\":\"P181018007\",\"mpBarcode\":\"181018007\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"个\",\"mpType\":1,\"mpBrandCode\":null,\"categoryCode\":null,\"categoryName\":\"蛋糕\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"receiveCode\":\"SH1886082902000000\",\"purchaseCode\":null,\"returnCode\":\"TH1886082902000004\",\"purchaseProductId\":null,\"oldCount\":2,\"returnProductId\":1886082902000008,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"storeId\":2029080902003394,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"warehouseId\":1878080900000561,\"warehouseCode\":\"CK10002\",\"warehouseName\":\"采配子仓库01\",\"costWithTaxAmt\":\"10.00\",\"costWithoutTaxAmt\":\"9.71\",\"costTaxAmt\":\"0.29\",\"changeCount\":\"1.0000\",\"newCount\":\"3\"}],\"receiveOrder\":null,\"purchaseOrder\":null,\"inStockOrder\":null,\"receiveUser\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"receiveTimeStart\":null,\"receiveTimeEnd\":null,\"inStockTimeStart\":null,\"inStockTimeEnd\":null,\"mpName\":null,\"mpCode\":null}\n");
         Object o = Ajax.post(driver, addPurchaseChangeOrderurl, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //        断言code
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

}

    //更正单提交
    @Test
    public void submitPurchaseChangeOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886085202000001,\"changeCode\":\"GZ1811301886085202000000\",\"changeType\":2,\"changeTypeText\":\"入库更正\",\"receiveCode\":\"SH1886083002000007\",\"returnCode\":null,\"purchaseCode\":null,\"purchaseMerchantCode\":null,\"purchaseMerchantName\":null,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"storeId\":2029080902003394,\"storeIds\":null,\"storeCode\":\"CP10001\",\"storeName\":\"CP仓0001\",\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"costWithTaxAmt\":30,\"costWithoutTaxAmt\":29.13,\"costTaxAmt\":null,\"changeDate\":1543550084000,\"changeDateStart\":null,\"changeDateEnd\":null,\"auditTime\":null,\"auditUsename\":null,\"completeTime\":null,\"completeTimeStart\":null,\"completeTimeEnd\":null,\"orderStatus\":1,\"orderStatusText\":\"待提交\",\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1543536000000,\"createTimeDb\":1543550104000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":1543550105000,\"updateTimeDb\":1543550105000,\"products\":null,\"receiveOrder\":null,\"purchaseOrder\":null,\"inStockOrder\":null,\"receiveUser\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"receiveTimeStart\":null,\"receiveTimeEnd\":null,\"inStockTimeStart\":null,\"inStockTimeEnd\":null,\"mpName\":null,\"mpCode\":null}\n");
        Object o = Ajax.post(driver, submitPurchaseChangeOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }
    //更正单审核通过
    @Test
    public void  auditPurchaseChangeOrderUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886085202000001,\"orderStatus\":3}\n");
        Object o = Ajax.post(driver, auditPurchaseChangeOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }

    

}
