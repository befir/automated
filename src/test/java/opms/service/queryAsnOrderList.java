package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.ody.automation.RestfulAutomationTest;
//import com.ody.automation.RestfulAutomationTest;

//采购单
public class queryAsnOrderList extends RestfulAutomatedTest {

    //重置发运单
    private String queryAsnOrderListUrl = baseUrl+"/opms-web/purchaseAsnOrderAction/queryAsnOrderList.do";
    //查询发运单
    private String queryAsnOrderlistUrl = baseUrl+"/opms-web/purchaseAsnOrderAction/queryAsnOrderList.do";
    //新增发运单
    private String saveAsnOrderUrl = baseUrl+"/opms-web/purchaseAsnOrderAction/saveAsnOrder.do";
    //发运单提交
    private String confirmAsnOrderUrl = baseUrl+"/opms-web/purchaseAsnOrderAction/confirmAsnOrder.do";
    //发运单发运完成
    private String queryAsnOrderList = baseUrl+"/opms-web/purchaseAsnOrderAction/queryAsnOrderList.do";



    //查询发运单
    @Test
    public void queryAsnOrderListUrl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-26\",\"createTimeStart\":\"2018-10-27\",\"orderStatus\":\"3\"}}");
        Object o = Ajax.post(driver, queryAsnOrderListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //断言Data、Message、Code
        JSONObject getJSONObject = JSON.parseObject("{\"listObj\":[],\"total\":0}");
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertNotNull(actualResult.get("data"));

        System.out.println(JSON.toJSONString(o));
    }
    //重置发运单
    @Test
    public void queryAsnOrderlistUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-26\",\"createTimeStart\":\"2018-10-27\"}}");
         Object o = Ajax.post(driver, queryAsnOrderlistUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言Data
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));
    }

      //新建发运单
    @Test
    public void saveAsnOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886084803000001,\"asnCode\":\"ASN1886084803000001\",\"createTime\":1543230856769,\"orderStatus\":1,\"receiveMerchantName\":\"P蒙牛商家\",\"receiveMerchantCode\":\"CP1001\",\"receiveMerchantId\":2029080902003362,\"receiveStoreName\":\"CP仓0001\",\"receiveStoreCode\":\"CP10001\",\"receiveStoreId\":2029080902003394,\"receiverName\":null,\"receiverMobile\":null,\"supplierName\":\"P蒙牛供应商\",\"supplierCode\":\"1886081603000000\",\"supplierContactName\":null,\"supplierMobile\":null,\"deliveryCompanyName\":null,\"deliveryExpressCode\":null,\"actualDeliveryDate\":\"2018-11-26\",\"expectReceiveDate\":\"2018-11-27\",\"costWithTaxAmt\":\"300.00\",\"receiveAddress\":null,\"remark\":null,\"detailList\":[{\"asnCode\":\"ASN1886084803000001\",\"purchaseCode\":\"CG1886083002000001\",\"purchaseProductId\":1886083002000004,\"mpId\":1878080900000566,\"mpName\":\"盖奶\",\"mpCode\":\"P181018001\",\"mpSpec\":null,\"mpBarcode\":\"181018001\",\"categoryName\":\"饮料\",\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"costWithTaxUnitAmt\":10,\"costWithoutTaxAmt\":\"97.10\",\"costWithoutTaxUnitAmt\":\"9.71\",\"costTaxRate\":0.03,\"purchaseCount\":10,\"costWithTaxAmt\":\"100.00\",\"deliveryCount\":10,\"deliveryMpWeight\":\"\",\"deliveryMpVolume\":\"\",\"deliveryMpGw\":\"\",\"deliveryMpNw\":\"\",\"deliveryMpCtn\":\"\",\"expectReceiveDate\":\"2018-11-08\",\"receiveMethod\":3,\"contractCode\":\"HT1886082202000014\",\"contractType\":1,\"receiveStoreId\":2029080902003394,\"receiveStoreCode\":\"CP10001\",\"receiveStoreName\":\"CP仓0001\",\"receiveAddress\":null},{\"asnCode\":\"ASN1886084803000001\",\"purchaseCode\":\"CG1886083002000001\",\"purchaseProductId\":1886083002000005,\"mpId\":1878080900000845,\"mpName\":\"果冻\",\"mpCode\":\"P181018002\",\"mpSpec\":null,\"mpBarcode\":\"181018002\",\"categoryName\":\"甜点\",\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"costWithTaxUnitAmt\":10,\"costWithoutTaxAmt\":\"97.10\",\"costWithoutTaxUnitAmt\":\"9.71\",\"costTaxRate\":0.03,\"purchaseCount\":10,\"costWithTaxAmt\":\"100.00\",\"deliveryCount\":10,\"deliveryMpWeight\":\"\",\"deliveryMpVolume\":\"\",\"deliveryMpGw\":\"\",\"deliveryMpNw\":\"\",\"deliveryMpCtn\":\"\",\"expectReceiveDate\":\"2018-11-08\",\"receiveMethod\":3,\"contractCode\":\"HT1886082202000014\",\"contractType\":1,\"receiveStoreId\":2029080902003394,\"receiveStoreCode\":\"CP10001\",\"receiveStoreName\":\"CP仓0001\",\"receiveAddress\":null},{\"asnCode\":\"ASN1886084803000001\",\"purchaseCode\":\"CG1886083002000001\",\"purchaseProductId\":1886083002000006,\"mpId\":1878080902000922,\"mpName\":\"蛋挞\",\"mpCode\":\"P181018005\",\"mpSpec\":null,\"mpBarcode\":\"181018005\",\"categoryName\":\"蛋糕\",\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"个\",\"costWithTaxUnitAmt\":10,\"costWithoutTaxAmt\":\"97.10\",\"costWithoutTaxUnitAmt\":\"9.71\",\"costTaxRate\":0.03,\"purchaseCount\":10,\"costWithTaxAmt\":\"100.00\",\"deliveryCount\":10,\"deliveryMpWeight\":\"\",\"deliveryMpVolume\":\"\",\"deliveryMpGw\":\"\",\"deliveryMpNw\":\"\",\"deliveryMpCtn\":\"\",\"expectReceiveDate\":\"2018-11-08\",\"receiveMethod\":3,\"contractCode\":\"HT1886082202000014\",\"contractType\":1,\"receiveStoreId\":2029080902003394,\"receiveStoreCode\":\"CP10001\",\"receiveStoreName\":\"CP仓0001\",\"receiveAddress\":null}]}\n");
        Object o = Ajax.post(driver, saveAsnOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言Data、Message、Code
        JSONObject getJSONObject = JSON.parseObject("{\"listObj\":[],\"total\":0}");
        String expectedData = "发运单ASN1886084803000001状态异常，请核对单据状态";
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertNotNull(actualResult.get("data"));
        System.out.println(JSON.toJSONString(o));
    }

    //提交发运单
    @Test
    public void confirmAsnOrderUrl  () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"detailList\":null,\"id\":1886084803000001,\"receiveStoreIds\":null,\"idList\":null,\"asnCode\":\"ASN1886084803000001\",\"asnCodeList\":null,\"purchaseCode\":null,\"purchaseMerchantCode\":null,\"purchaseMerchantName\":null,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"supplierContactName\":null,\"supplierMobile\":null,\"deliveryCompanyName\":null,\"deliveryExpressCode\":null,\"deliveryCount\":30,\"deliveryMpWeight\":0,\"deliveryMpVolume\":0,\"receiveStoreId\":2029080902003394,\"receiveWarehouseId\":null,\"receiveMerchantId\":2029080902003362,\"receiveStoreCode\":\"CP10001\",\"receiveStoreName\":\"CP仓0001\",\"receiveWarehouseCode\":null,\"receiveWarehouseName\":null,\"receiveMerchantCode\":\"CP1001\",\"receiveMerchantName\":\"P蒙牛商家\",\"receiveAddress\":null,\"receiveMethod\":null,\"receiveMethodText\":\"\",\"receiverName\":null,\"receiverMobile\":null,\"costWithTaxAmt\":300,\"costWithoutTaxAmt\":291.3,\"costTaxAmt\":0,\"orderStatus\":2,\"orderStatusText\":\"待确认\",\"orderStatusList\":null,\"deliveryStatus\":null,\"deliveryStatusText\":\"\",\"deliveryMsg\":\"运输公司：  运单号\",\"auditTime\":null,\"auditTimeStart\":null,\"auditTimeEnd\":null,\"auditUsename\":null,\"expectDeliveryDate\":null,\"expectDeliveryDateStart\":null,\"expectDeliveryDateEnd\":null,\"expectDeliveryDateText\":null,\"actualDeliveryDate\":\"2018-11-26\",\"actualDeliveryDateStart\":null,\"actualDeliveryDateEnd\":null,\"actualDeliveryDateText\":\"2018-11-26\",\"expectReceiveDate\":\"2018-11-27\",\"expectReceiveDateStart\":null,\"expectReceiveDateEnd\":null,\"expectReceiveDateText\":\"2018-11-27\",\"actualReceiveDate\":null,\"actualReceiveDateStart\":null,\"actualReceiveDateEnd\":null,\"actualReceiveDateText\":null,\"completeTime\":null,\"completeTimeStart\":null,\"completeTimeEnd\":null,\"srcSystem\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":\"2018-11-26\",\"createTimeStart\":null,\"createTimeEnd\":null,\"createTimeDb\":1543230876000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":1543230876000,\"updateTimeDb\":1543230876000}\n");
         Object o = Ajax.post(driver, confirmAsnOrderUrl, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //        断言code、message
        String expectedData = "没有找到相应发运单";
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

}

    //发运单发运完成
    @Test
    public void queryAsnOrderList  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-26\",\"createTimeStart\":\"2018-10-27\"}}");
        Object o = Ajax.post(driver, queryAsnOrderList, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code、message
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }

    

}
