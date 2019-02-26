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
public class selectPOList extends RestfulAutomatedTest {

    //查询采购单
    private String selectPOListUrl = baseUrl+"/opms-web/purchaseOrder/selectPOList.do";
    //重置采购单
    private String selectPOListurl = baseUrl+"/opms-web/purchaseOrder/selectPOList.do";
    //新增发运单
    private String savePOUrl = baseUrl+"/opms-web/purchaseOrder/savePO.do";
    //发运单提交
    private String submitPOUrl = baseUrl+"/opms-web/purchaseOrder/submitPO.do";
    //审核通过
    private String approvePOUListrUrl = baseUrl+"/opms-web/purchaseOrder/selectPOList.do";



    //查询采购单
    @Test
    public void selectPOListurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"endCreateTime\":\"2018-11-23\",\"startCreateTime\":\"2018-10-24\",\"orderStatus\":null,\"supplierCode\":\"1886082802000015\",\"supplierName\":\"维达供应商\"}}");
        Object o = Ajax.post(driver, selectPOListurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言data
        JSONObject expectedData = JSON.parseObject("{\"listObj\":[],\"total\":0}");
        Assert.assertEquals(actualResult.get("data"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }
    //重置采购单
    @Test
    public void selectPOList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"endCreateTime\":\"2018-11-23\",\"startCreateTime\":\"2018-10-24\",\"orderStatus\":null}}");
         Object o = Ajax.post(driver, selectPOListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//       断言data
        JSONObject expectedData = JSON.parseObject("{\"listObj\":[],\"total\":0}");
        Assert.assertEquals(actualResult.get("data"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }

      //创建采购单
    @Test
    public void savePO  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":null,\"purchaseCode\":\"CG1886084504000008\",\"sourceCode\":null,\"sourceCodeType\":\"1\",\"purchaseMerchantCode\":null,\"purchaseMerchantName\":null,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"supplierContactName\":null,\"supplierMobile\":null,\"receiveStoreId\":2029080902003441,\"receiveStoreCode\":\"CP0002\",\"receiveStoreName\":\"CP仓0002\",\"receiveWarehouseId\":null,\"receiveWarehouseCode\":null,\"receiveWarehouseName\":null,\"receiveMerchantId\":2029080902003362,\"receiveMerchantCode\":\"CP1001\",\"receiveMerchantName\":\"P蒙牛商家\",\"receiveAddress\":null,\"receiveMethod\":\"2\",\"costWithTaxAmt\":null,\"costWithoutTaxAmt\":null,\"costTaxAmt\":null,\"purchaseDate\":\"2018-11-23\",\"auditTime\":null,\"auditUsename\":null,\"expectReceiveDate\":\"2018-11-23\",\"actualReceiveDate\":null,\"completeTime\":null,\"orderStatus\":1,\"purchaseStatus\":1,\"contractCode\":null,\"isMpq\":null,\"costAccountingCode\":null,\"costAccountingName\":null,\"purchaserCode\":\"1886081503000024\",\"purchaserName\":\"采购员莉莉\",\"srcSystem\":null,\"attach1Path\":null,\"attach1Name\":null,\"attach2Path\":null,\"attach2Name\":null,\"attach3Path\":null,\"attach3Name\":null,\"remark\":null,\"companyId\":null,\"isDeleted\":null,\"versionNo\":null,\"createUserid\":null,\"createUsername\":\"superadmin\",\"createTime\":1542965642517,\"createTimeDb\":null,\"serverIp\":null,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null,\"startAuditTime\":null,\"endAuditTime\":null,\"startCreateTime\":null,\"endCreateTime\":null,\"productCodeBarcode\":null,\"productName\":null,\"orderStatusText\":null,\"sourceCodeTypeText\":null,\"productList\":[{\"mpId\":1878080900000566,\"mpName\":\"盖奶\",\"mpCode\":\"P181018001\",\"mpBarcode\":\"181018001\",\"mpSpec\":null,\"mpBrandName\":\"P奈瑟\",\"mpMeasureUnit\":\"件\",\"mpType\":1,\"mpBrandCode\":null,\"categoryCode\":null,\"categoryName\":\"饮料\",\"costTaxRate\":0.03,\"costWithTaxUnitAmt\":10,\"costWithoutTaxUnitAmt\":\"9.7087\",\"contractCode\":\"HT1886082202000014\",\"contractType\":1,\"receiveStoreId\":2029080902003441,\"receiveStoreCode\":\"CP0002\",\"receiveStoreName\":\"CP仓0002\",\"expectReceiveDate\":\"2018-11-23\",\"receiveMethod\":\"2\",\"costWithTaxAmt\":\"100.0000\",\"costWithoutTaxAmt\":\"97.0870\",\"purchaseCount\":10}],\"receiveStoreIds\":null,\"sql\":null}");
        Object o = Ajax.post(driver, savePOUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code
        String expectedData1 = "20002";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));
    }

    //提交采购单
    @Test
    public void submitPO  () throws InterruptedException {
         JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-22\",\"createTimeStart\":\"2018-10-23\",\"mpCode\":\"P181018019\",\"mpName\":\"\"}}\n");
         Object o = Ajax.post(driver, submitPOUrl, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code、message
        String expectedData = "系统异常:null";
        String expectedData1 = "20002";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));
    }

    //审核采购单
    @Test
    public void approvePOUListr  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"endCreateTime\":\"2018-11-23\",\"startCreateTime\":\"2018-10-24\",\"orderStatus\":null}}\n");
        Object o = Ajax.post(driver, approvePOUListrUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code、message
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }

}
