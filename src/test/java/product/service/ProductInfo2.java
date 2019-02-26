package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductInfo2  extends RestfulAutomatedTest {
    private String queryProductBarcodeByPIdUrl = baseUrl + "/back-product-web2/back/product/queryProductBarcodeByPId.do";
    private String addProductBarcodeUrl = baseUrl + "/back-product-web2/back/product/addProductBarcode.do";
    private String updateProductBarcodeUrl = baseUrl + "/back-product-web2/back/product/updateProductBarcode.do";
    private String updateProductBarcode1Url = baseUrl + "/back-product-web2/back/product/updateProductBarcode.do";
    private String queryProductAttributeByPIdUrl = baseUrl + "/back-product-web2/back/product/queryProductAttributeByPId.do";
    private String saveOrUpdateProductAttributeUrl = baseUrl + "/back-product-web2/back/product/saveOrUpdateProductAttribute.do";

    @Test
//    查询产品辅计量单位
    public void queryProductBarcodeByPId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"productId\":\"1878083500000035\",\"isStandard\":0}");
        Object o = Ajax.post(driver,queryProductBarcodeByPIdUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("{\"id\":1878083500000089,\"startItem\":0,\"measurementUnit\":\"测试20181108184047\",\"state\":0,\"barcode\":\"23\",\"measurementUnitCode\":\"20181108184047\",\"thirdUnitCode\":\"123\",\"currentPage\":0,\"itemsPerPage\":0,\"isStandard\":0,\"conversionRate\":12,\"productId\":1878083500000035}");
        Assert.assertEquals(actualResult.get("data"),expectedData);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//    新增产品辅计量单位
    public void addProductBarcode() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"productId\":\"1878083500000035\",\"state\":1,\"measurementUnitCode\":\"20181108184047\",\"conversionRate\":\"12\",\"measurementUnit\":\"测试20181108184047\"}");
        Object o = Ajax.post(driver,addProductBarcodeUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "MEASUREMENT_UNIT_CODE_EXIST";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    编辑产品辅计量单位
    public void updateProductBarcode() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878083500000089,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"productId\":1878083500000035,\"measurementUnit\":\"测试20181108184047\",\"isStandard\":0,\"barcode\":\"23\",\"conversionRate\":12,\"measurementUnitCode\":\"20181108184047\",\"state\":1,\"thirdUnitCode\":\"123\",\"startItem\":0}");
        Object o = Ajax.post(driver,updateProductBarcodeUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    禁用产品辅计量单位
    public void updateProductBarcode1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878083500000089,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"productId\":1878083500000035,\"measurementUnit\":\"测试20181108184047\",\"isStandard\":0,\"barcode\":\"23\",\"conversionRate\":12,\"measurementUnitCode\":\"20181108184047\",\"state\":0,\"thirdUnitCode\":\"123\",\"startItem\":0}");
        Object o = Ajax.post(driver,updateProductBarcode1Url,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    查询产品类目属性
    public void queryProductAttributeByPId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"productId\":\"1878083400000135\"}");
        Object o = Ajax.post(driver,queryProductAttributeByPIdUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    新增产品类目属性
    public void saveOrUpdateProductAttribute() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"sortValue\":4,\"attNameId\":2008078900000047,\"productId\":\"1878083400000380\",\"attName\":\"尺码\",\"categoryAttNameId\":1878080800000028,\"checked\":true,\"productAttValueVOS\":[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":2008078900000048,\"productAttNameId\":null,\"sortValue\":1,\"attValue\":\"XL\",\"categoryAttValueId\":1878080800000034,\"checked\":false,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":2008078900000049,\"productAttNameId\":null,\"sortValue\":2,\"attValue\":\"X\",\"categoryAttValueId\":1878080800000035,\"checked\":true,\"startItem\":0}],\"attValue\":null,\"checkValue\":2008078900000049,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"sortValue\":3,\"attNameId\":1878080800000008,\"productId\":\"1878083400000380\",\"attName\":\"质感\",\"categoryAttNameId\":1878080800000027,\"checked\":true,\"productAttValueVOS\":[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":1878080800000009,\"productAttNameId\":null,\"sortValue\":1,\"attValue\":\"磨砂\",\"categoryAttValueId\":1878080800000032,\"checked\":true,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":1878080800000010,\"productAttNameId\":null,\"sortValue\":2,\"attValue\":\"镜面\",\"categoryAttValueId\":1878080800000033,\"checked\":false,\"startItem\":0}],\"attValue\":null,\"checkValue\":1878080800000009,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"sortValue\":1,\"attNameId\":1878080800000011,\"productId\":\"1878083400000380\",\"attName\":\"产地\",\"categoryAttNameId\":1878080800000026,\"checked\":false,\"productAttValueVOS\":[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":1878080800000012,\"productAttNameId\":null,\"sortValue\":1,\"attValue\":\"中国\",\"categoryAttValueId\":1878080800000030,\"checked\":false,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":1878080800000013,\"productAttNameId\":null,\"sortValue\":2,\"attValue\":\"进口\",\"categoryAttValueId\":1878080800000031,\"checked\":false,\"startItem\":0}],\"attValue\":null,\"checkValue\":null,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"sortValue\":2,\"attNameId\":1878080801000137,\"productId\":\"1878083400000380\",\"attName\":\"容量\",\"categoryAttNameId\":1878080802000553,\"checked\":false,\"productAttValueVOS\":[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":1878080801000138,\"productAttNameId\":null,\"sortValue\":1,\"attValue\":\"小杯\",\"categoryAttValueId\":1878080802000554,\"checked\":false,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":1878080801000139,\"productAttNameId\":null,\"sortValue\":2,\"attValue\":\"中杯\",\"categoryAttValueId\":1878080802000555,\"checked\":false,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":1878080801000140,\"productAttNameId\":null,\"sortValue\":3,\"attValue\":\"大杯\",\"categoryAttValueId\":1878080802000556,\"checked\":false,\"startItem\":0}],\"attValue\":null,\"checkValue\":null,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"sortValue\":5,\"attNameId\":2008078900000050,\"productId\":\"1878083400000380\",\"attName\":\"颜色\",\"categoryAttNameId\":1878080800000029,\"checked\":false,\"productAttValueVOS\":[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":2008078900000051,\"productAttNameId\":null,\"sortValue\":0,\"attValue\":\"红\",\"categoryAttValueId\":1878080800000036,\"checked\":false,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":null,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attValueId\":2008078900000052,\"productAttNameId\":null,\"sortValue\":1,\"attValue\":\"蓝\",\"categoryAttValueId\":1878080800000037,\"checked\":false,\"startItem\":0}],\"attValue\":null,\"checkValue\":null,\"startItem\":0}]\n");
        Object o = Ajax.post(driver,saveOrUpdateProductAttributeUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }



}
