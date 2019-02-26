package product.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productCataloging extends RestfulAutomatedTest {
    //商品进目录获取库组织
    private String getAuthInventoryPageUrl = baseUrl + "/back-merchant-web/api/merchant/getAuthInventoryPage.do";
    //商品进目录获取商家商品
    private String queryMerchantProductForLibOrgUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryMerchantProductForLibOrg.do";
    //商品进目录请求策略列表
    private String queryOperationStrategyUrl = baseUrl + "/back-product-web2/back/operationStrategy/queryOperationStrategy.do";
    //商品进目录请求策略id
    private String getOperationStrategyByIdUrl = baseUrl + "/back-product-web2/back/operationStrategy/getOperationStrategyById.do";
    //商品进目录成功
    private String saveMerchantProductStrategyForLibOrgUrl = baseUrl + "/back-product-web2/back/merchantProduct/saveMerchantProductStrategyForLibOrg.do";

    @Test
    public void getAuthInventoryPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10\n" +
                "}");
        Object o = Ajax.post(driver, getAuthInventoryPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String inventoryId= listObj.getJSONObject(0).getString("inventoryId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="桂源铺";
        String expectedData1 ="2029083400000176";
        String expectedData2= "0";
        Assert.assertEquals(merchantName,expectedData);
        Assert.assertEquals(inventoryId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(inventoryId);
        System.out.println(merchantName);
    }

    @Test
    public void queryMerchantProductForLibOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"merchantId\": 2029080800003446\n" +
                "}");
        Object o = Ajax.post(driver, queryMerchantProductForLibOrgUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String productId= listObj.getJSONObject(0).getString("productId");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878081304000516";
        String expectedData1 ="2029080800003446";
        String expectedData2= "0";
        Assert.assertEquals(productId,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(productId);
    }

    @Test
    public void queryOperationStrategy() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 100\n" +
                "}");
        Object o = Ajax.post(driver, queryOperationStrategyUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String opStatusName= listObj.getJSONObject(0).getString("opStatusName");
        String startItem= listObj.getJSONObject(0).getString("startItem");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="测试20181114001123";
        String expectedData1 ="0";
        String expectedData2= "0";
        Assert.assertEquals(opStatusName,expectedData);
        Assert.assertEquals(startItem,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(startItem);
        System.out.println(opStatusName);
    }

    @Test
    public void getOperationStrategyById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"norId\": 5804033004405396\n" +
                "}");
        Object o = Ajax.post(driver, getOperationStrategyByIdUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String expectedData1 = "0";

        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertNotNull(actualResult.get("data"));
    }

    @Test
    public void saveMerchantProductStrategyForLibOrg() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\n" +
                "\t\"currentPage\": 0,\n" +
                "\t\"itemsPerPage\": 0,\n" +
                "\t\"id\": 1878080900000128,\n" +
                "\t\"isAvailable\": null,\n" +
                "\t\"createUsername\": null,\n" +
                "\t\"createTime\": 1541145329502,\n" +
                "\t\"updateUsername\": null,\n" +
                "\t\"updateTime\": 1541145329502,\n" +
                "\t\"authStoreIds\": null,\n" +
                "\t\"authMerchantIds\": null,\n" +
                "\t\"authInventoryIds\": null,\n" +
                "\t\"subTypeOfProduct\": null,\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"code\": \"1878080900000124\",\n" +
                "\t\"merchantProdVolume\": null,\n" +
                "\t\"shelflifeDays\": null,\n" +
                "\t\"purchaseTaxRate\": null,\n" +
                "\t\"returnDays\": null,\n" +
                "\t\"thirdMerchantProductCode\": null,\n" +
                "\t\"englishName\": null,\n" +
                "\t\"typeOfProduct\": null,\n" +
                "\t\"merchantCategoryId\": null,\n" +
                "\t\"parentId\": null,\n" +
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
                "\t\"freightTemplateId\": null,\n" +
                "\t\"isVatInvoice\": null,\n" +
                "\t\"firstShelfTime\": null,\n" +
                "\t\"merchantProdHeight\": null,\n" +
                "\t\"type\": null,\n" +
                "\t\"isVoice\": null,\n" +
                "\t\"chineseName\": \"快乐柠檬\",\n" +
                "\t\"productId\": 1878080900000125,\n" +
                "\t\"sourceType\": null,\n" +
                "\t\"guaranteeDays\": null,\n" +
                "\t\"isVisible\": null,\n" +
                "\t\"categoryId\": null,\n" +
                "\t\"status\": 2,\n" +
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
                "\t\"refId\": null,\n" +
                "\t\"channelCode\": \"-1\",\n" +
                "\t\"isDefaultMerchantProduct\": null,\n" +
                "\t\"saleMerchantProductBarcodeId\": null,\n" +
                "\t\"storeId\": null,\n" +
                "\t\"canSale\": 1,\n" +
                "\t\"recycleStatus\": null,\n" +
                "\t\"recycleTime\": null,\n" +
                "\t\"dataType\": null,\n" +
                "\t\"merchantProductId\": null,\n" +
                "\t\"warehouseType\": 0,\n" +
                "\t\"ids\": null,\n" +
                "\t\"childMpId\": null,\n" +
                "\t\"mpIds\": null,\n" +
                "\t\"itemIds\": null,\n" +
                "\t\"mainPictureUrl\": null,\n" +
                "\t\"mainUnitId\": null,\n" +
                "\t\"mainUnitName\": null,\n" +
                "\t\"mainUnitCode\": null,\n" +
                "\t\"barcode\": null,\n" +
                "\t\"brandName\": null,\n" +
                "\t\"categoryName\": null,\n" +
                "\t\"categoryIds\": null,\n" +
                "\t\"salePriceWithTax\": null,\n" +
                "\t\"purchasePriceWithTax\": null,\n" +
                "\t\"priceId\": null,\n" +
                "\t\"mpList\": null,\n" +
                "\t\"marketPrice\": null,\n" +
                "\t\"pssmId\": null,\n" +
                "\t\"operationStrategyId\": 5804033004405397,\n" +
                "\t\"canSaleReturn\": 1,\n" +
                "\t\"canDistribution\": 1,\n" +
                "\t\"canPurchaseReturn\": 1,\n" +
                "\t\"canPurchase\": 1,\n" +
                "\t\"turnoverChannel\": \"1\",\n" +
                "\t\"attNameCount\": null,\n" +
                "\t\"priceLevel\": null,\n" +
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
                "\t\"purchaseSellStockManagementId\": null,\n" +
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
                "\t\"inventoryId\": 2029080801000004,\n" +
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
                "\t\"parentWarehouseType\": null,\n" +
                "\t\"warehouseTypeView\": true,\n" +
                "\t\"autoUpdate\": null,\n" +
                "\t\"frontCanSale\": null,\n" +
                "\t\"singleChannelStockVO\": null,\n" +
                "\t\"enterWarehouse\": false,\n" +
                "\t\"defaultWarehouseType\": 1,\n" +
                "\t\"startItem\": 0,\n" +
                "\t\"checked\": true,\n" +
                "\t\"opStatusName\": \"新商品试销\"\n" +
                "}]");
        Object o = Ajax.post(driver, saveMerchantProductStrategyForLibOrgUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

}
