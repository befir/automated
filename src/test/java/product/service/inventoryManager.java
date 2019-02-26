package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;

public class inventoryManager extends RestfulAutomatedTest {
    private String listStoreWarehouseWithPageUrl = baseUrl + "/back-product-web2/back/storeWarehouse/listStoreWarehouseWithPage.do";
    private String getAuthMerchantPageUrl = baseUrl + "/back-merchant-web/api/merchant/getAuthMerchantPage.do";
    private String saveStoreWarehouseUrl = baseUrl + "/back-product-web2/back/storeWarehouse/CENTER/saveStoreWarehouse.do";
    private String listStoreWarehouseWithPage1Url = baseUrl + "/back-product-web2/back/storeWarehouse/listStoreWarehouseWithPage.do";
    private String getAuthMerchantPage1Url = baseUrl + "/back-merchant-web/api/merchant/getAuthMerchantPage.do";
    private String queryStoreOrgPageByAuthUrl = baseUrl + "/back-merchant-web/api/store/queryStoreOrgPageByAuth.do";
    private String querychannelsUrl = baseUrl + "/back-product-web2/back/storeWarehouse/listChannels/1809081700000008.do";
    private String savevirtStoreWarehouse1Url = baseUrl + "/back-product-web2/back/storeWarehouse/VIRTUAL/saveStoreWarehouse.do";
    private String getAuthInventoryPageUrl = baseUrl + "/back-merchant-web/api/merchant/getAuthInventoryPage.do";
    private String listStoreWarehouseByParamUrl = baseUrl + "/back-product-web2/back/storeWarehouse/listStoreWarehouseByParam.do";
    private String listMerchantProductByPageOnModalUrl = baseUrl + "/back-product-web2/back/merchantProduct/listMerchantProductByPageOnModal.do";

    @Test
    //查询仓库
    public void listStoreWarehouseWithOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"isVirtualWarehouse\":0,\"warehouseCode\":\"spx101706\"}");
        Object o = Ajax.post(driver, listStoreWarehouseWithPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
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
    //中心仓新增
    public void getAuthMerchantPage1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, getAuthMerchantPage1Url, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="可口可乐";
        String expectedData1 ="2029080800000000";
        String expectedData2= "0";
        Assert.assertEquals(merchantName,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(merchantName);
    }

    @Test
    //新增中心仓
    public void saveStoreWarehouse() throws InterruptedException {
        JSONObject param = JSON.parseObject("{warehouseType:'',isAvailable:'',isRealWarehouse:'',isSelfWarehouse:'',warehouseCode:'',warehouseName:'',merchantId:'',inventoryId:'',syncRule:'',warehouseCoverageList:'[]'}");
        param.put("warehouseType", 1);
        param.put("isAvailable", 1);
        param.put("isRealWarehouse", 0);
        param.put("warehouseCode", dateFormat.format(new Date()));
        param.put("warehouseName", "SPXTest" + dateFormat.format(new Date()));
        param.put("merchantId", 1811076800000016L);
        param.put("inventoryId", 1811078000003425L);
        param.put("syncRule", 0);
        param.put("warehouseCoverageList", null);
        Object o = Ajax.post(driver, saveStoreWarehouseUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    //查询拟合仓
    public void listStoreWarehouseWithPage1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{isVirtualWarehouse:1, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listStoreWarehouseWithPage1Url, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String isVirtualWarehouse= listObj.getJSONObject(0).getString("isVirtualWarehouse");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="1";
        String expectedData2= "0";
        Assert.assertEquals(merchantName,expectedData);
        Assert.assertEquals(isVirtualWarehouse,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(isVirtualWarehouse);
        System.out.println(merchantName);
    }

    @Test
    //拟合仓新增
    public void getAuthMerchantPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, getAuthMerchantPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="可口可乐";
        String expectedData1 ="2029080800000000";
        String expectedData2= "0";
        Assert.assertEquals(merchantName,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(merchantName);

    }

    @Test
    //拟合仓添加店铺库存
    public void queryStoreOrgPageByAuth() throws InterruptedException {
        JSONObject param = JSON.parseObject("{merchantId:'',currentPage: 1, itemsPerPage: 10}");
        param.put("merchantId", 1811076800000016L);
        Object o = Ajax.post(driver, queryStoreOrgPageByAuthUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="可口可乐";
        String expectedData1 ="2029080800000000";
        String expectedData2= "0";
        Assert.assertEquals(merchantName,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(merchantName);

    }

    @Test
    //拟合仓添加店铺库存请求渠道
    public void querychannels() throws InterruptedException {
        JSONObject param = JSON.parseObject("{warehouseType:'',isAvailable:'',isRealWarehouse:'',isSelfWarehouse:''}");
        param.put("warehouseType", 1);
        param.put("isAvailable", 1);
        param.put("isRealWarehouse", 0);
        param.put("isSelfWarehouse", 1);
        Object o = Ajax.post(driver, querychannelsUrl, param);
//        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        JSONObject code=actualResult.getJSONObject("code");

        System.out.println(JSON.toJSONString(o));
//        JSONObject expectedData = JSON.parseObject("{code:0}");
//        Assert.assertEquals(code, expectedData);



    }

    @Test
    //新增拟合仓10.29
    public void savevirtStoreWarehouse1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{warehouseCode:'',warehouseName:'',id:'',merchantId:'',merchantCode:'',merchantName:'',isAvailable:'',channelList:'',warehouseCoverageList:''}");
        param.put("warehouseCode", dateFormat.format(new Date()));
        param.put("warehouseName", "SPXTest" + dateFormat.format(new Date()));
        param.put("id", 0);
        param.put("merchantId", 1811076601000000L);
        param.put("merchantCode", 231L);
        param.put("merchantName", "欧电云信息科技");
        param.put("isAvailable", 1);

        JSONObject param1 = JSON.parseObject("{isAvailable:1,merchantId:'1811076601000000',storeWarehouseId:'',storeId:'1811076700000008',storeName:'上海欧电云店铺',storeCode:'123',assignType:'3',assignValue:'100',isNeedHold:'0'}");
        ArrayList channelList1 = new ArrayList();
        channelList1.add(param1);
        param.put("channelList", channelList1);

        JSONObject param2 = JSON.parseObject("{storeWarehouseId:'',merchantId:'1811076601000000',countryCode:'100000',provinceCode:'320000',cityCode:'320100',districtCode:'320114',isAvailable:1}");
        ArrayList channelList2 = new ArrayList();
        channelList2.add(param2);
        param.put("warehouseCoverageList", channelList2);
        Object o = Ajax.post(driver, savevirtStoreWarehouse1Url, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    //库内事务单据获取商家10.29
    public void getAuthInventoryPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{merchantId:'',currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, getAuthInventoryPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="可口可乐";
        String expectedData1 ="2029080800000000";
        String expectedData2= "0";
        Assert.assertEquals(merchantName,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(merchantName);
    }

    @Test

    //库内事务单据获取库存组织10.29
    public void listStoreWarehouseByParam() throws InterruptedException {
        JSONObject param = JSON.parseObject("{inventoryId:'',isVirtualWarehouse:''}");
        param.put("inventoryId", 1811079000003350L);
        param.put("isVirtualWarehouse", 0);
        Object o = Ajax.post(driver, listStoreWarehouseByParamUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //库内事务单据获取商家商品10.29
    public void listMerchantProductByPageOnModa() throws InterruptedException {
        JSONObject param = JSON.parseObject("{inventoryId:'',currentPage:1，itemsPerPage:10}");
        param.put("inventoryId", 1811079000003350L);
        Object o = Ajax.post(driver, listMerchantProductByPageOnModalUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

}