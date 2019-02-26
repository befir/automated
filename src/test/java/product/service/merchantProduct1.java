package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class merchantProduct1 extends RestfulAutomatedTest {
    //请求价格管理1107
    private String viewMerchantProductPriceUrl = baseUrl + "/back-product-web2/back/merchantProductPrice/viewMerchantProductPrice.do";
    //请求价格税率1107
    private String listPurchaseTaxRateUrl = baseUrl + "/back-product-web2/back/merchantProductPrice/listPurchaseTaxRate.do";
    //请求类目属性1107
    private String queryMerchantProductAttributeByMpIdUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryMerchantProductAttributeByMpId.do";
    //保存类目属性1107
    private String saveOrUpdateMerchantProductAttributeUrl = baseUrl + "/back-product-web2/back/merchantProduct/saveOrUpdateMerchantProductAttribute.do";
    //请求渠道1107
    private String queryMerchantChannelProductByMpUrl = baseUrl + "/back-product-web2/back/merchantChannelProduct/queryMerchantChannelProductByMp.do";
    //请求店铺1107
    private String queryStoreOrgChannelPageUrl = baseUrl + "/back-merchant-web/api/store/queryStoreOrgChannelPage.do";
    //分发商品1107
    private String saveMerchantChannelProductUrl = baseUrl + "/back-product-web2/back/merchantChannelProduct/saveMerchantChannelProduct.do";
    //编辑渠道商品信息（上架）1107
    private String updateMerchantChannelProductUrl = baseUrl + "/back-product-web2/back/merchantChannelProduct/updateMerchantChannelProduct.do";
    //请求库存组织
    private String getAuthInventoryPageUrl = baseUrl + "/back-merchant-web/api/merchant/getAuthInventoryPage.do";
    //请求店铺库存
    private String listStoreStockUrl = baseUrl + "/back-product-web2/back/storeStock/listStoreStock.do";
    //新增库存组织
    private String updateStoreMerchantDetailUrl = baseUrl + "/back-product-web2/back/storeProduct/updateStoreMerchantDetail.do";
    //请求计量单位
    private String listMpCalculationUnitUrl = baseUrl + "/back-product-web2/back/calculation/listMpCalculationUnit.do";
    //新增辅助计量单位
    private String addMerchantProductBarcodeUrl = baseUrl + "/back-product-web2/back/merchantProduct/addMerchantProductBarcode.do";
    //商品辅计量单位列表
    private String listMerchantProductBarcodeByMpIdUrl = baseUrl + "/back-product-web2/back/merchantProduct/listMerchantProductBarcodeByMpId.do";
    //提交商品数据
    private String submitAuditUrl = baseUrl + "/back-product-web2/back/merchantProduct/submitAudit.do";
    //审核通过商品数据
    private String proAuditUrl = baseUrl + "/back-product-web2/back/merchantProduct/proAudit.do";

    @Test
    public void viewMerchantProductPrice() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"productId\": 1878082801000457,\n" +
                "\t\"channelCode\": -1,\n" +
                "\t\"storeId\": -1,\n" +
                "\t\"refId\": null\n" +
                "}");
        Object o = Ajax.post(driver, viewMerchantProductPriceUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
    public void listPurchaseTaxRate() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"typePoolCode\": 1,\n" +
                "\t\"typeCode\": 1\n" +
                "}");
        Object o = Ajax.post(driver, listPurchaseTaxRateUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void queryMerchantProductAttributeByMpId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProductId\": \"1878082801000460\"\n" +
                "}");
        Object o = Ajax.post(driver, queryMerchantProductAttributeByMpIdUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void saveOrUpdateMerchantProductAttribute() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": 1878082900000215,\n" +
                "\t\"isAvailable\": null,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": null,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": null,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"sortValue\": 3,\n" +
                "\t\"attNameId\": 1878080801000133,\n" +
                "\t\"merchantProductId\": \"1878082801000460\",\n" +
                "\t\"type\": 0,\n" +
                "\t\"parentId\": null,\n" +
                "\t\"attNameCustom\": null,\n" +
                "\t\"attName\": \"口感\",\n" +
                "\t\"attNameIds\": null,\n" +
                "\t\"categoryAttNameId\": 1878080802000367,\n" +
                "\t\"types\": null,\n" +
                "\t\"checked\": false,\n" +
                "\t\"attValues\": [1878080801000135],\n" +
                "\t\"mpIds\": null,\n" +
                "\t\"attValueIdSet\": null,\n" +
                "\t\"merchantProductAttValueVOS\": [{\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": 1878082900000216,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080801000135,\n" +
                "\t\t\"sortValue\": 2,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": 1878082900000215,\n" +
                "\t\t\"attValue\": \"半糖\",\n" +
                "\t\t\"categoryAttValueId\": 1878080802000372,\n" +
                "\t\t\"checked\": false,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}, {\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": null,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080801000134,\n" +
                "\t\t\"sortValue\": 1,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": null,\n" +
                "\t\t\"attValue\": \"重糖\",\n" +
                "\t\t\"categoryAttValueId\": 1878080802000371,\n" +
                "\t\t\"checked\": false,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}, {\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": null,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080801000136,\n" +
                "\t\t\"sortValue\": 3,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": null,\n" +
                "\t\t\"attValue\": \"少糖\",\n" +
                "\t\t\"categoryAttValueId\": 1878080802000373,\n" +
                "\t\t\"checked\": false,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}],\n" +
                "\t\"merchantProductAttValueVO\": null,\n" +
                "\t\"startItem\": 0\n" +
                "}, {\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": 1878082900000217,\n" +
                "\t\"isAvailable\": null,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": null,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": null,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"sortValue\": 2,\n" +
                "\t\"attNameId\": 1878080800000011,\n" +
                "\t\"merchantProductId\": \"1878082801000460\",\n" +
                "\t\"type\": 2,\n" +
                "\t\"parentId\": null,\n" +
                "\t\"attNameCustom\": null,\n" +
                "\t\"attName\": \"产地\",\n" +
                "\t\"attNameIds\": null,\n" +
                "\t\"categoryAttNameId\": 1878080902000578,\n" +
                "\t\"types\": null,\n" +
                "\t\"checked\": false,\n" +
                "\t\"attValues\": [1878080800000012],\n" +
                "\t\"mpIds\": null,\n" +
                "\t\"attValueIdSet\": null,\n" +
                "\t\"merchantProductAttValueVOS\": [{\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": null,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080800000013,\n" +
                "\t\t\"sortValue\": 2,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": null,\n" +
                "\t\t\"attValue\": \"进口\",\n" +
                "\t\t\"categoryAttValueId\": 1878080902000580,\n" +
                "\t\t\"checked\": false,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}, {\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": 1878082900000218,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080800000012,\n" +
                "\t\t\"sortValue\": 1,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": 1878082900000217,\n" +
                "\t\t\"attValue\": \"中国\",\n" +
                "\t\t\"categoryAttValueId\": 1878080902000579,\n" +
                "\t\t\"checked\": false,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}],\n" +
                "\t\"merchantProductAttValueVO\": null,\n" +
                "\t\"startItem\": 0\n" +
                "}, {\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": null,\n" +
                "\t\"isAvailable\": null,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": null,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": null,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"sortValue\": 1,\n" +
                "\t\"attNameId\": 1878080801000137,\n" +
                "\t\"merchantProductId\": \"1878082801000460\",\n" +
                "\t\"type\": 2,\n" +
                "\t\"parentId\": null,\n" +
                "\t\"attNameCustom\": null,\n" +
                "\t\"attName\": \"容量\",\n" +
                "\t\"attNameIds\": null,\n" +
                "\t\"categoryAttNameId\": 1878080802000366,\n" +
                "\t\"types\": null,\n" +
                "\t\"checked\": true,\n" +
                "\t\"checkValue\": 1878080801000139,\n" +
                "\t\"attValues\": null,\n" +
                "\t\"mpIds\": null,\n" +
                "\t\"attValueIdSet\": null,\n" +
                "\t\"merchantProductAttValueVOS\": [{\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": null,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080801000138,\n" +
                "\t\t\"sortValue\": 1,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": null,\n" +
                "\t\t\"attValue\": \"小杯\",\n" +
                "\t\t\"categoryAttValueId\": 1878080802000368,\n" +
                "\t\t\"checked\": false,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}, {\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": null,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080801000139,\n" +
                "\t\t\"sortValue\": 2,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": null,\n" +
                "\t\t\"attValue\": \"中杯\",\n" +
                "\t\t\"categoryAttValueId\": 1878080802000369,\n" +
                "\t\t\"checked\": true,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}, {\n" +
                "\t\t\"currentPage\": 0,\n" +
                "\t\t\"itemsPerPage\": 0,\n" +
                "\t\t\"id\": null,\n" +
                "\t\t\"isAvailable\": null,\n" +
                "\t\t\"createUsername\": null,\n" +
                "\t\t\"createTime\": null,\n" +
                "\t\t\"updateUsername\": null,\n" +
                "\t\t\"updateTime\": null,\n" +
                "\t\t\"authStoreIds\": null,\n" +
                "\t\t\"authMerchantIds\": null,\n" +
                "\t\t\"authInventoryIds\": null,\n" +
                "\t\t\"attValueId\": 1878080801000140,\n" +
                "\t\t\"sortValue\": 3,\n" +
                "\t\t\"attValueCustom\": null,\n" +
                "\t\t\"merchantProdAttNameId\": null,\n" +
                "\t\t\"attValue\": \"大杯\",\n" +
                "\t\t\"categoryAttValueId\": 1878080802000370,\n" +
                "\t\t\"checked\": false,\n" +
                "\t\t\"types\": null,\n" +
                "\t\t\"mpAttNameIds\": null,\n" +
                "\t\t\"merchantProductId\": null,\n" +
                "\t\t\"startItem\": 0\n" +
                "\t}],\n" +
                "\t\"merchantProductAttValueVO\": null,\n" +
                "\t\"startItem\": 0\n" +
                "}]");
        Object o = Ajax.post(driver, saveOrUpdateMerchantProductAttributeUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryMerchantChannelProductByMp() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"refId\": \"1878082801000460\"\n" +
                "}");
        Object o = Ajax.post(driver, queryMerchantChannelProductByMpUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void queryStoreOrgChannelPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"storeId\": 2029080801000007\n" +
                "}");
        Object o = Ajax.post(driver, queryStoreOrgChannelPageUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void saveMerchantChannelProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"refId\": \"1878082801000460\",\n" +
                "\t\"priceLevel\": 2,\n" +
                "\t\"autoUpdate\": {\n" +
                "\t\t\"storeId\": 2029080801000007,\n" +
                "\t\t\"storeName\": \"桂源铺BBC\",\n" +
                "\t\t\"storeCode\": \"1017001\",\n" +
                "\t\t\"channelCode\": \"110001\",\n" +
                "\t\t\"merchantId\": 2029080800003446\n" +
                "\t},\n" +
                "\t\"isAvailable\": 1,\n" +
                "\t\"storeId\": 2029080801000007,\n" +
                "\t\"channelCode\": \"110001\",\n" +
                "\t\"freightTemplateId\": 1885081302000067,\n" +
                "\t\"saleMerchantProductBarcodeId\": 1878082801000463,\n" +
                "\t\"salePriceWithTax\": \"20\",\n" +
                "\t\"marketPrice\": \"20\"\n" +
                "}");
        Object o = Ajax.post(driver, saveMerchantChannelProductUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }
    @Test
    public void updateMerchantChannelProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": 1878082900000223,\n" +
                "\t\"isAvailable\": 1,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": 1541582049833,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": 1541582049833,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"subTypeOfProduct\": null,\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"code\": \"1878082801000456\",\n" +
                "\t\"merchantProdVolume\": null,\n" +
                "\t\"shelflifeDays\": null,\n" +
                "\t\"purchaseTaxRate\": null,\n" +
                "\t\"returnDays\": null,\n" +
                "\t\"thirdMerchantProductCode\": null,\n" +
                "\t\"englishName\": null,\n" +
                "\t\"typeOfProduct\": null,\n" +
                "\t\"merchantCategoryId\": null,\n" +
                "\t\"parentId\": 1878082900000223,\n" +
                "\t\"grossWeight\": null,\n" +
                "\t\"subtitle\": null,\n" +
                "\t\"freightAttribute\": null,\n" +
                "\t\"isForceInvoice\": null,\n" +
                "\t\"artNo\": null,\n" +
                "\t\"brandId\": null,\n" +
                "\t\"measureType\": null,\n" +
                "\t\"isWeighted\": null,\n" +
                "\t\"replacementDays\": null,\n" +
                "\t\"netWeight\": null,\n" +
                "\t\"netWeightStart\": null,\n" +
                "\t\"remark\": null,\n" +
                "\t\"saleType\": null,\n" +
                "\t\"merchantProdLength\": null,\n" +
                "\t\"freightTemplateId\": 1885081302000067,\n" +
                "\t\"isVatInvoice\": null,\n" +
                "\t\"firstShelfTime\": null,\n" +
                "\t\"merchantProdHeight\": null,\n" +
                "\t\"type\": null,\n" +
                "\t\"isVoice\": null,\n" +
                "\t\"chineseName\": \"百褶裙\",\n" +
                "\t\"productId\": 1878082801000457,\n" +
                "\t\"sourceType\": null,\n" +
                "\t\"guaranteeDays\": null,\n" +
                "\t\"isVisible\": null,\n" +
                "\t\"categoryId\": null,\n" +
                "\t\"status\": null,\n" +
                "\t\"merchantProdWidth\": null,\n" +
                "\t\"isInvoice\": null,\n" +
                "\t\"countryOfOriginCode\": null,\n" +
                "\t\"provinceOfOriginCode\": null,\n" +
                "\t\"cityOfOriginCode\": null,\n" +
                "\t\"regionOfOriginCode\": null,\n" +
                "\t\"countryOfOriginName\": null,\n" +
                "\t\"provinceOfOriginName\": null,\n" +
                "\t\"cityOfOriginName\": null,\n" +
                "\t\"regionOfOriginName\": null,\n" +
                "\t\"refId\": 1878082801000460,\n" +
                "\t\"channelCode\": \"110001\",\n" +
                "\t\"isDefaultMerchantProduct\": null,\n" +
                "\t\"saleMerchantProductBarcodeId\": 1878082801000463,\n" +
                "\t\"storeId\": 2029080801000007,\n" +
                "\t\"canSale\": 1,\n" +
                "\t\"recycleStatus\": null,\n" +
                "\t\"recycleTime\": null,\n" +
                "\t\"dataType\": null,\n" +
                "\t\"merchantProductId\": 1878082801000460,\n" +
                "\t\"warehouseType\": null,\n" +
                "\t\"ids\": null,\n" +
                "\t\"childMpId\": null,\n" +
                "\t\"mpIds\": null,\n" +
                "\t\"itemIds\": null,\n" +
                "\t\"mainPictureUrl\": null,\n" +
                "\t\"mainUnitId\": null,\n" +
                "\t\"mainUnitName\": \"件\",\n" +
                "\t\"mainUnitCode\": null,\n" +
                "\t\"barcode\": null,\n" +
                "\t\"brandName\": null,\n" +
                "\t\"categoryName\": null,\n" +
                "\t\"categoryIds\": null,\n" +
                "\t\"salePriceWithTax\": 20,\n" +
                "\t\"purchasePriceWithTax\": null,\n" +
                "\t\"priceId\": 1878082900000225,\n" +
                "\t\"mpList\": null,\n" +
                "\t\"marketPrice\": 20,\n" +
                "\t\"pssmId\": null,\n" +
                "\t\"operationStrategyId\": null,\n" +
                "\t\"canSaleReturn\": null,\n" +
                "\t\"canDistribution\": null,\n" +
                "\t\"canPurchaseReturn\": null,\n" +
                "\t\"canPurchase\": null,\n" +
                "\t\"turnoverChannel\": null,\n" +
                "\t\"attNameCount\": null,\n" +
                "\t\"priceLevel\": 2,\n" +
                "\t\"orderMultipleNum\": null,\n" +
                "\t\"orderStartNum\": null,\n" +
                "\t\"canBatchCtrl\": null,\n" +
                "\t\"canSequenceCtrl\": null,\n" +
                "\t\"recycleFlag\": null,\n" +
                "\t\"modificationType\": null,\n" +
                "\t\"priceStatus\": null,\n" +
                "\t\"mpType\": null,\n" +
                "\t\"mpTypeOfProduct\": null,\n" +
                "\t\"attNameListSize\": null,\n" +
                "\t\"pssmIsAvailable\": null,\n" +
                "\t\"purchaseSellStockManagementId\": 1878082900000224,\n" +
                "\t\"itemId\": null,\n" +
                "\t\"mpId\": null,\n" +
                "\t\"mainPictureId\": null,\n" +
                "\t\"attNameId\": null,\n" +
                "\t\"attValueId\": null,\n" +
                "\t\"barcodeId\": null,\n" +
                "\t\"mpAttNameId\": null,\n" +
                "\t\"mpAttValueId\": null,\n" +
                "\t\"mpCategoryId\": null,\n" +
                "\t\"mpMerchantId\": null,\n" +
                "\t\"userId\": null,\n" +
                "\t\"inventoryId\": null,\n" +
                "\t\"mpCategoryFullNamePath\": null,\n" +
                "\t\"userName\": null,\n" +
                "\t\"fullIdPath\": null,\n" +
                "\t\"attName\": null,\n" +
                "\t\"attValue\": null,\n" +
                "\t\"measurementUnitCode\": null,\n" +
                "\t\"measurementUnit\": null,\n" +
                "\t\"mpMerchantName\": null,\n" +
                "\t\"storeName\": null,\n" +
                "\t\"mpChannelBarcode\": null,\n" +
                "\t\"mpChannelThirdUnitCode\": null,\n" +
                "\t\"mpChannelMeasurementUnit\": null,\n" +
                "\t\"thirdProductCode\": null,\n" +
                "\t\"mpMainPictureUrl\": null,\n" +
                "\t\"mpChineseName\": null,\n" +
                "\t\"mpCode\": null,\n" +
                "\t\"mpBrandName\": null,\n" +
                "\t\"attValuesStr\": null,\n" +
                "\t\"merchantCode\": null,\n" +
                "\t\"merchantName\": null,\n" +
                "\t\"auditMessage\": null,\n" +
                "\t\"fullNamePath\": null,\n" +
                "\t\"salePriceWithoutTax\": null,\n" +
                "\t\"saleTaxRate\": null,\n" +
                "\t\"afterPrice\": null,\n" +
                "\t\"beforePrice\": null,\n" +
                "\t\"realStockNum\": null,\n" +
                "\t\"applicationTime\": null,\n" +
                "\t\"productLength\": null,\n" +
                "\t\"productWidth\": null,\n" +
                "\t\"productHeight\": null,\n" +
                "\t\"weight\": null,\n" +
                "\t\"productVolume\": null,\n" +
                "\t\"purchasePriceWithoutTax\": null,\n" +
                "\t\"recommendRetailPrice\": null,\n" +
                "\t\"virtualStockNum\": null,\n" +
                "\t\"startDate\": null,\n" +
                "\t\"endDate\": null,\n" +
                "\t\"attTypes\": null,\n" +
                "\t\"typeOfProducts\": null,\n" +
                "\t\"attValueIds\": null,\n" +
                "\t\"attNameIds\": null,\n" +
                "\t\"brandIds\": null,\n" +
                "\t\"parentIds\": null,\n" +
                "\t\"refIds\": null,\n" +
                "\t\"storeIds\": null,\n" +
                "\t\"attNameIdList\": null,\n" +
                "\t\"barcodes\": null,\n" +
                "\t\"channelCodes\": null,\n" +
                "\t\"merchantIds\": null,\n" +
                "\t\"productIds\": null,\n" +
                "\t\"codes\": null,\n" +
                "\t\"pictureUrlList\": null,\n" +
                "\t\"attValueIdStrs\": null,\n" +
                "\t\"attList\": null,\n" +
                "\t\"videoUrlList\": null,\n" +
                "\t\"merchantProductAttributeVOS\": null,\n" +
                "\t\"mpAttList\": null,\n" +
                "\t\"mpSeriesAttList\": null,\n" +
                "\t\"merchantSecurityRelationPOS\": null,\n" +
                "\t\"attributeList\": null,\n" +
                "\t\"mpAttrVoList\": null,\n" +
                "\t\"merchantProductPageSearchFor\": null,\n" +
                "\t\"refParentId\": null,\n" +
                "\t\"barcodeList\": null,\n" +
                "\t\"merchantProductVOList\": null,\n" +
                "\t\"parentWarehouseType\": 0,\n" +
                "\t\"warehouseTypeView\": null,\n" +
                "\t\"autoUpdate\": {\n" +
                "\t\t\"storeId\": 2029080801000007,\n" +
                "\t\t\"storeName\": \"桂源铺BBC\",\n" +
                "\t\t\"storeCode\": \"1017001\",\n" +
                "\t\t\"channelCode\": \"110001\",\n" +
                "\t\t\"merchantId\": 2029080800003446\n" +
                "\t},\n" +
                "\t\"frontCanSale\": null,\n" +
                "\t\"singleChannelStockVO\": null,\n" +
                "\t\"enterWarehouse\": true,\n" +
                "\t\"defaultWarehouseType\": 1,\n" +
                "\t\"startItem\": 0\n" +
                "}");
        Object o = Ajax.post(driver, updateMerchantChannelProductUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }
    @Test
    public void getAuthInventoryPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 500\n" +
                "}");
        Object o = Ajax.post(driver, getAuthInventoryPageUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void listStoreStock() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProductId\": 1878082801000457\n" +
                "}");
        Object o = Ajax.post(driver, listStoreStockUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void updateStoreMerchantDetail() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": 1878083000000213,\n" +
                "\t\"isAvailable\": 1,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": null,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": null,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"canDistribution\": 1,\n" +
                "\t\"canSale\": 0,\n" +
                "\t\"canSaleReturn\": 0,\n" +
                "\t\"canPurchase\": 1,\n" +
                "\t\"canPurchaseReturn\": 1,\n" +
                "\t\"dmsCoefficientDay\": null,\n" +
                "\t\"turnoverChannel\": \"1\",\n" +
                "\t\"defaultSupplierId\": null,\n" +
                "\t\"defaultPurchaseOrg\": null,\n" +
                "\t\"defautPurchasesStoreId\": null,\n" +
                "\t\"defautPurchaseWarehouseId\": null,\n" +
                "\t\"defautPurchaserId\": null,\n" +
                "\t\"defautPurchaseSchedulerId\": null,\n" +
                "\t\"productId\": 1878082801000212,\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"storeId\": -1,\n" +
                "\t\"inventoryId\": 2029080801000004,\n" +
                "\t\"operationStrategyId\": 5804033004405396,\n" +
                "\t\"deliveryType\": null,\n" +
                "\t\"canBatchCtrl\": 0,\n" +
                "\t\"canSequenceCtrl\": 0,\n" +
                "\t\"stockSchedulerTypeId\": null,\n" +
                "\t\"sequenceSource\": null,\n" +
                "\t\"channelCode\": \"-1\",\n" +
                "\t\"orderStartNum\": null,\n" +
                "\t\"orderMultipleNum\": null,\n" +
                "\t\"priceLevel\": null,\n" +
                "\t\"itemId\": null,\n" +
                "\t\"dataType\": null,\n" +
                "\t\"actualStock\": null,\n" +
                "\t\"storeCode\": null,\n" +
                "\t\"storeName\": null,\n" +
                "\t\"merchantName\": \"桂源铺\",\n" +
                "\t\"productCode\": \"1878082801000211\",\n" +
                "\t\"productName\": \"百褶裙\",\n" +
                "\t\"productArr\": null,\n" +
                "\t\"mainUnitName\": \"件\",\n" +
                "\t\"artNo\": null,\n" +
                "\t\"brandName\": \"桂源铺\",\n" +
                "\t\"categoryName\": \"后台类目-下午茶-其他\",\n" +
                "\t\"modelType\": null,\n" +
                "\t\"barcode\": null,\n" +
                "\t\"opStatusCode\": null,\n" +
                "\t\"opStatusName\": null,\n" +
                "\t\"defaultSupplierSources\": null,\n" +
                "\t\"defaultStoreSources\": null,\n" +
                "\t\"storageSources\": null,\n" +
                "\t\"batchNumberPrefix\": null,\n" +
                "\t\"nextBatchNumberPrefix\": null,\n" +
                "\t\"stockSchedulerType\": null,\n" +
                "\t\"replenishAdvancedPeriod\": null,\n" +
                "\t\"schedulerStaffs\": null,\n" +
                "\t\"purchaseStaffs\": null,\n" +
                "\t\"salePrice\": null,\n" +
                "\t\"marketPrice\": null,\n" +
                "\t\"purchasePrice\": null,\n" +
                "\t\"startItem\": 0,\n" +
                "\t\"inventoryCode\": \"101701\",\n" +
                "\t\"inventoryName\": \"桂源铺组织\"\n" +
                "}");
        Object o = Ajax.post(driver, updateStoreMerchantDetailUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void listMpCalculationUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProdId\": \"1878082801000215\"\n" +
                "}");
        Object o = Ajax.post(driver, listMpCalculationUnitUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addMerchantProductBarcode() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProductId\": \"1878082801000215\",\n" +
                "\t\"state\": 1,\n" +
                "\t\"measurementUnitCode\": \"3\",\n" +
                "\t\"conversionRate\": \"10\",\n" +
                "\t\"measurementUnit\": \"个\"\n" +
                "}");
        Object o = Ajax.post(driver, addMerchantProductBarcodeUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }
    @Test
    public void listMerchantProductBarcodeByMpId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProductId\": \"1878082801000215\",\n" +
                "\t\"isStandard\": 0\n" +
                "}");
        Object o = Ajax.post(driver, listMerchantProductBarcodeByMpIdUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void submitAudit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"ids\": [1878082801000215]\n" +
                "}");
        Object o = Ajax.post(driver, submitAuditUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }
    @Test
    public void proAudit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"ids\": [1878082801000215],\n" +
                "\t\"status\": \"2\"\n" +
                "}");
        Object o = Ajax.post(driver, proAuditUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

}
