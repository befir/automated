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
public class queryReceiveOrderList extends RestfulAutomatedTest {

    //查询采购收货单
    private String queryReceiveOrderListUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/queryReceiveOrderList.do";
    //采购收货单重置
    private String queryReceiveOrderListurl = baseUrl+"/opms-web/purchaseReceiveOrderAction/queryReceiveOrderList.do";
    //新增采购收货单
    private String saveReceiveOrderUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/saveReceiveOrder.do";
    //采购收货单校验
    private String queryOrderListUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/queryReceiveOrderList.do";
    //采购收货单确认
    private String confirmReceiveOrderUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/queryReceiveOrderList.do";
    //采购收货单取消
    private String queryListUrl = baseUrl+"/opms-web/purchaseReceiveOrderAction/queryReceiveOrderList.do";



    //采购收货单查询
    @Test
    public void queryReceiveOrderList () throws InterruptedException {

        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"receiveType\":\"1\",\"receiveCode\":\"SH1886082302004038\",\"receiveStatus\":\"6\",\"supplierCode\":\"1886081603000000\"}}");
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
    //采购收货单重置
    @Test
    public void queryReceiveOrderListurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"receiveType\":\"1\"}}\n");
         Object o = Ajax.post(driver, queryReceiveOrderListurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言code、message
        String expectedData1 = "0";
        String expectedData = "请求成功";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertEquals(actualResult.get("message"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }

      //新增采购收货单
    @Test
    public void saveReceiveOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886085503000000,\"receiveCode\":\"SH1886085503000000\",\"receiveType\":1,\"createTime\":1543817220700,\"orderStatus\":1,\"receiveMerchantName\":\"P蒙牛商家\",\"receiveMerchantCode\":\"CP1001\",\"receiveMerchantId\":2029080902003362,\"receiveStoreName\":\"CP仓0001\",\"receiveStoreCode\":\"CP10001\",\"receiveStoreId\":2029080902003394,\"receiverName\":null,\"supplierName\":\"P蒙牛供应商\",\"supplierCode\":\"1886081603000000\",\"deliveryCompanyName\":null,\"deliveryExpressCode\":null,\"costWithTaxAmt\":\"4444.00\",\"costWithoutTaxAmt\":\"3798.50\",\"receiveAddress\":null,\"remark\":null,\"receiveDate\":\"2018-12-03\",\"detailList\":[{\"receiveCode\":\"SH1886085503000000\",\"purchaseCode\":\"CG1886082102000018\",\"purchaseProductId\":1886082102000020,\"receiveStoreName\":\"CP仓0001\",\"receiveStoreCode\":\"CP10001\",\"receiveStoreId\":2029080902003394,\"receiveMerchantName\":\"P蒙牛商家\",\"receiveMerchantCode\":\"CP1001\",\"receiveMerchantId\":2029080902003362,\"mpName\":\"盖奶\",\"mpId\":1878080900000566,\"mpCode\":\"P181018001\",\"mpSpec\":null,\"mpBarcode\":\"181018001\",\"categoryName\":\"饮料\",\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"costWithTaxUnitAmt\":88.88,\"costWithoutTaxUnitAmt\":75.97,\"costTaxRate\":0.17,\"purchaseCount\":50,\"costWithTaxAmt\":\"4444.00\",\"costWithoutTaxAmt\":\"3798.50\",\"receiveCount\":50,\"receiveMethod\":3}]}\n");
        Object o = Ajax.post(driver, saveReceiveOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//断言Code
        String expectedData1 = "-1";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));
    }

    //采购收货单校验
    @Test
    public void queryOrderList  () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"receiveType\":\"1\"}}\n");
         Object o = Ajax.post(driver, queryOrderListUrl, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //        断言code、message、data
        JSONObject expectedData3 = JSON.parseObject("{\"listObj\":[],\"total\":0}");
        Assert.assertEquals(actualResult.get("data"),expectedData3);
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

}

    //采购收货单确认
    @Test
    public void confirmReceiveOrderUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"receiveType\":\"1\"}}\n");
        Object o = Ajax.post(driver, confirmReceiveOrderUrl, param);
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
    //采购收货单取消
    @Test
    public void queryListUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"receiveType\":\"1\"}}");
        Object o = Ajax.post(driver, queryListUrl, param);
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

    

}
