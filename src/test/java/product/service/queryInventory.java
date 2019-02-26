package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class queryInventory extends RestfulAutomatedTest {

    private String listStoreWarehouseWithPageUrl = baseUrl + "/back-product-web2/back/storeWarehouse/listStoreWarehouseWithPage.do";
    private String saveStoreWarehouseUrl = baseUrl + "/back-product-web2/back/storeWarehouse/CENTER/saveStoreWarehouse.do";
    private String queryMerchantProductByPageUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryMerchantProductByPage.do";
    private String queryMerchantProdSecurityListUrl = baseUrl + "/back-product-web2/back/merchantProdSecurity/queryMerchantProdSecurityList.do";
    private String saveSelfProductUrl = baseUrl + "/back-product-web2/back/merchantProduct/saveSelfProduct.do";
    private String savevirtSelfProductUrl = baseUrl + "/back-product-web2/back/storeWarehouse/VIRTUAL/saveStoreWarehouse.do";
    private String saveSuperscriptWithTxUrl = baseUrl+ "/back-product-web2/back/superscript/saveSuperscriptWithTx.do";
    private String listImWarehouseFreezeJournalRecordByPageUrl = baseUrl+ "/back-product-web2/back/stock/listImWarehouseFreezeJournalRecordByPage.do";
    private String listImWarehouseStockJournalRecordByPageUrl = baseUrl+ "/back-product-web2/back/stock/listImWarehouseStockJournalRecordByPage.do";


    @Test
    //查询仓库
    public void listStoreWarehouseWithOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listStoreWarehouseWithPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
        Assert.assertEquals(merchantName,expectedData);
        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantCode);
        System.out.println(merchantName);
    }

    @Test
    //新建中心仓
    public void saveStoreWarehouseOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, saveStoreWarehouseUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
    //商家商品安全列表
    public void queryMerchantProdSecurityListOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, queryMerchantProductByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String brandId= listObj.getJSONObject(0).getString("brandId");
        String warehouseType= listObj.getJSONObject(0).getString("warehouseType");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878083000000259";
        String expectedData1 ="1";
        String expectedData2= "0";
        Assert.assertEquals(brandId,expectedData);
        Assert.assertEquals(warehouseType,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(warehouseType);
        System.out.println(brandId);

    }
    @Test
    //查询商品保障
    public void queryMerchantProductByOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, queryMerchantProdSecurityListUrl, param);
//        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
//        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
////        //取第一个值组的值
//        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        String warehouseType= listObj.getJSONObject(0).getString("warehouseType");
////        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="1878083000000259";
//        String expectedData1 ="1";
//        String expectedData2= "0";
//        Assert.assertEquals(merchantId,expectedData);
////        Assert.assertEquals(warehouseType,expectedData1);
//        Assert.assertEquals(actualResult.get("code"),expectedData2);
////        System.out.println(warehouseType);
//        System.out.println(merchantId);
    }
     @Test
    //自建子品
     public void saveSelfProductOrg() throws InterruptedException {
         JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
         Object o = Ajax.post(driver, saveSelfProductUrl, param);
         JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

         System.out.println(JSON.toJSONString(o));
         JSONObject expectedData = JSON.parseObject("");
         Assert.assertEquals(actualResult.get("data"), expectedData);
     }

    @Test
    //新增拟合仓
    public void savevirtSelfProductOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, savevirtSelfProductUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }
    @Test
    //新增角标
    public void saveSuperscriptWithTx() throws InterruptedException {
        JSONObject param = JSON.parseObject("{name: \"爆款11\", code: \"0013314\", displayType: \"0\"}");
        Object o = Ajax.post(driver, saveSuperscriptWithTxUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
    //查询冻结明细
    public void listImWarehouseFreezeJournalRecordByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listImWarehouseFreezeJournalRecordByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String billCode= listObj.getJSONObject(0).getString("billCode");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1885084301000557";
        String expectedData1 ="2029080800000000";
        String expectedData2= "0";
        Assert.assertEquals(billCode,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(billCode);

    }

    @Test
    //查询实际库存流水
    public void listImWarehouseStockJournalRecordByPageOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listImWarehouseStockJournalRecordByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String brandName= listObj.getJSONObject(0).getString("brandName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="2029080800003446";
        String expectedData2= "0";
        Assert.assertEquals(brandName,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(brandName);
    }



}