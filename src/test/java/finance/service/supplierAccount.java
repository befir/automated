package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//供应商预付款管理
public class supplierAccount extends RestfulAutomatedTest {
    //预付资质供应商查询
    private String querySupplierAccountUrl = baseUrl + "/back-finance-web/supplierAccount/querySupplierAccountList.do";

    //预付资质供应商重置
    private String querySupplierAccountListUrl = baseUrl + "/back-finance-web/supplierAccount/querySupplierAccountList.do";

    //预付资质供应商新增
    private String createAccountUrl = baseUrl + "/back-finance-web/supplierAccount/createAccount.do";

    //预付资质供应商关闭
    private String closeSupplierAccountUrl = baseUrl + "/back-finance-web/supplierAccount/closeSupplierAccount.do";

    //预付资质供应商开启
    private String openSupplierAccountUrl = baseUrl + "/back-finance-web/supplierAccount/openSupplierAccount.do";

    //采购预付款流水查询
    private String querySupplierAccountlUrl = baseUrl + "/back-finance-web/supplierAccount/querySupplierAccountLog.do";

    //采购预付款流水重置
    private String querySupplierAccountLogUrl = baseUrl + "/back-finance-web/supplierAccount/querySupplierAccountLog.do";

    //预付款单管理及查询查询
    private String querySupplierAccountAdjustUrl = baseUrl + "/back-finance-web/supplierAccountAdjust/querySupplierAccountAdjustList.do";

    //预付款单管理及查询重置
    private String querySupplierAccountAdjustListUrl = baseUrl + "/back-finance-web/supplierAccountAdjust/querySupplierAccountAdjustList.do";

    //预付款单管理及查询审核
    private String auditPassAdvanceAccountAdjutsUrl = baseUrl + "/back-finance-web/supplierAccountAdjust/auditPassAdvanceAccountAdjutsOrder.do";

    //新增预付款单管理及查询-查询供应商
    private String querySupplierUrl = baseUrl + "/back-finance-web/supplier/querySupplierList.do";

    //新增预付款单管理及查询
    private String confirmAdvanceAccountAdjustUrl = baseUrl + "/back-finance-web/supplierAccountAdjust/confirmAdvanceAccountAdjustOrder.do";

    //删除预付款单管理及查询
    private String deleteAdvanceAccountAdjutsUrl = baseUrl + "/back-finance-web/supplierAccountAdjust/deleteAdvanceAccountAdjutsOrder.do";


    //预付资质供应商查询
    @Test
    public void querySupplierAccount() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySupplierAccountUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //预付资质供应商重置
    @Test
    public void querySupplierAccountList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySupplierAccountListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //预付资质供应商新增
    @Test
    public void createAccount() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"supplierCode\":\"1886082004000301\",\"supplierName\":\"可口可乐\"}");
        Object o = Ajax.post(driver, createAccountUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //预付资质供应商关闭
    @Test
    public void closeSupplierAccount() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083400000097}");
        Object o = Ajax.post(driver, closeSupplierAccountUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //预付资质供应商开启
    @Test
    public void openSupplierAccount() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083400000097}");
        Object o = Ajax.post(driver, openSupplierAccountUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //采购预付款流水查询
    @Test
    public void querySupplierAccountl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySupplierAccountlUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //采购预付款流水重置
    @Test
    public void querySupplierAccountLog() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySupplierAccountLogUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //预付款单管理及查询查询
    @Test
    public void querySupplierAccountAdjust() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{\"confirmStatus\":2},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySupplierAccountAdjustUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //预付款单管理及查询重置
    @Test
    public void querySupplierAccountAdjustList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{\"confirmStatus\":2},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, querySupplierAccountAdjustListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //预付款单管理及查询审核
    @Test
    public void auditPassAdvanceAccountAdjuts() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886082005000074,\"auditRemark\":null}");
        Object o = Ajax.post(driver, auditPassAdvanceAccountAdjutsUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }


    //新增预付款单管理及查询-查询供应商
    @Test
    public void querySupplier() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"supplierTypeValue\":null}}");
        Object o = Ajax.post(driver, querySupplierUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //新增预付款单管理及查询
    @Test
    public void confirmAdvanceAccountAdjust() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083500000149,\"operationAmount\":\"100\",\"remark\":\"阿康\",\"sourceOrderCode\":null,\"sourceOperationAmount\":null}");
        Object o = Ajax.post(driver, confirmAdvanceAccountAdjustUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //删除预付款单管理及查询
    @Test
    public void deleteAdvanceAccountAdjuts() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083500000149,\"auditRemark\":null}");
        Object o = Ajax.post(driver, deleteAdvanceAccountAdjutsUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }
}