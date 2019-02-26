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

//采购单
public class ReceiveOrderList extends RestfulAutomatedTest {

    //无采购收货单查询
    private String queryReceiveOrderListUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/queryReceiveOrderList.do";
    //新增无采购收货单
    private String saveReceiveOrderUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/saveReceiveOrder.do";
    //无采购收货单检验通过
    private String checkReceiveOrderUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/checkReceiveOrder.do";
    //无采购收货单取消
    private String queryReceiveOrderListurl = baseUrl+"/opms-web/purchaseReceiveOrderAction/queryReceiveOrderList.do";
    //无采购收货单确认
    private String confirmReceiveOrderUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/confirmReceiveOrder.do";



    //无采购收货单查询
    @Test
    public void queryReceiveOrderList () throws InterruptedException {

        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"receiveType\":\"2\",\"receiveDateStart\":\"2018-11-26\",\"receiveDateEnd\":\"2018-11-30\",\"receiveStatus\":\"6\",\"receiveCode\":\"SH1886084902000031\"}}\n");
        Object o = Ajax.post(driver, queryReceiveOrderListUrl, param);
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
    //新增无采购收货单
    @Test
    public void saveReceiveOrderUrl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886085002000000,\"receiveCode\":\"SH1886085002000000\",\"receiveType\":2,\"createTime\":1543384551094,\"orderStatus\":1,\"receiveMerchantName\":\"P蒙牛商家\",\"receiveMerchantCode\":\"CP1001\",\"receiveMerchantId\":2029080902003362,\"receiveStoreName\":\"CP仓0001\",\"receiveStoreCode\":\"CP10001\",\"receiveStoreId\":2029080902003394,\"receiverName\":null,\"supplierName\":\"P蒙牛供应商\",\"supplierCode\":\"1886081603000000\",\"deliveryCompanyName\":null,\"deliveryExpressCode\":null,\"costWithTaxAmt\":\"1000.00\",\"costWithoutTaxAmt\":\"971.00\",\"receiveAddress\":null,\"remark\":null,\"receiveDate\":\"2018-11-28\",\"detailList\":[{\"receiveCode\":\"SH1886085002000000\",\"receiveStoreName\":\"CP仓0001\",\"receiveStoreCode\":\"CP10001\",\"receiveStoreId\":2029080902003394,\"receiveMerchantName\":\"P蒙牛商家\",\"receiveMerchantCode\":\"CP1001\",\"receiveMerchantId\":2029080902003362,\"mpName\":\"盖奶\",\"mpId\":1878080900000566,\"mpCode\":\"P181018001\",\"mpSpec\":null,\"mpBarcode\":\"181018001\",\"categoryName\":\"饮料\",\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":9.71,\"costTaxRate\":0.03,\"costWithTaxAmt\":\"1000.00\",\"costWithoutTaxAmt\":\"971.00\",\"receiveCount\":\"100\",\"receiveMethod\":\"2\"}]}\n");
         Object o = Ajax.post(driver, saveReceiveOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言code、message
        String expectedData1 = "-1";
        String expectedData = "收货门店id：2029080902003394无效";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertEquals(actualResult.get("message"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }

      //无采购收货单检验通过
    @Test
    public void checkReceiveOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886085002000000}\n");
        Object o = Ajax.post(driver, checkReceiveOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言Code
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));
    }

    //无采购收货单取消
    @Test
    public void queryReceiveOrderListurl  () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"receiveType\":\"2\"}}\n");
         Object o = Ajax.post(driver, queryReceiveOrderListurl, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //        断言code、message
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

}

    //无采购收货单确认
    @Test
    public void confirmReceiveOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"receiveCode\":\"SH1886085002000002\"}\n");
        Object o = Ajax.post(driver, confirmReceiveOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code、message
        String expectedData = "单据状态异常，请核对单据状态";
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }

    

}
