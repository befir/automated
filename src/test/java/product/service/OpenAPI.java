package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;


public class OpenAPI extends RestfulAutomatedTest {
    private String queryGrantedCtgListByMerchantUrl = baseUrl + "/back-product-web2/openApi/merchantCategory/queryGrantedCtgListByMerchant.do";
    private String listItemInfoUrl = baseUrl + "/back-product-web2/openApi/merchantCategory/back-product-web2/openApi/mp/listItemInfoByPage.do";
    private String listItemPriceUrl = baseUrl + "/back-product-web2/openApi/merchantCategory/back-product-web2/openApi/mp/listItemPriceByPage.do";
    private String saveSelfProductUrl = baseUrl + "/back-product-web2/openApi/merchantCategory/back-product-web2/openApi/merchantProduct/saveSelfProduct.do";
    private String saveMerchantProductDescriptionUrl = baseUrl + "/back-product-web2/extra/merchantProduct/saveMerchantProductDescription.do";
    private String saveMerchantProductAfterSalesUrl = baseUrl + "/back-product-web2/extra/merchantProduct/saveMerchantProductAfterSales.do";
    private String listBrandByPageUrl = baseUrl + "/back-product-web2/openApi/brand/listBrandByPage.do";



    @Test
//    商家授权类目查询
    public void queryGrantedCtgListByMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{ \"merchantId\":2029080800000000}");
        Object o = Ajax.post(driver,queryGrantedCtgListByMerchantUrl,param);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//    分页获取item（店铺商品）列表
    public void listItemInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantId\":\"2029080800000000\",\"updateTime\":\"2017-05-05 00:00:00\"}");
        Object o = Ajax.post(driver,listItemInfoUrl,param);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//    分页获取item（店铺商品）价格列表
    public void listItemPrice() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantId\":\"2029080800000000\",\"updateTime\":\"2017-05-05 00:00:00\"}");
        Object o = Ajax.post(driver,listItemPriceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }





    @Test
//    新增商品接口
    public void saveSelfProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082301000747,\"isAvailable\":null,\"createUsername\":null,\"createTime\":1541128944075,\"updateUsername\":null,\"updateTime\":1541128944075,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"subTypeOfProduct\":1,\"merchantId\":2029080800000000,\"code\":\"1878082301000743\",\"merchantProdVolume\":null,\"shelflifeDays\":null,\"purchaseTaxRate\":null,\"returnDays\":null,\"thirdMerchantProductCode\":\"23424\",\"englishName\":\"dfhdfgh\",\"typeOfProduct\":0,\"merchantCategoryId\":null,\"parentId\":1878082301000747,\"grossWeight\":null,\"subtitle\":\"hfg\",\"freightAttribute\":null,\"isForceInvoice\":0,\"artNo\":null,\"brandId\":1878080800000003,\"measureType\":1,\"isWeighted\":0,\"replacementDays\":null,\"netWeight\":null,\"netWeightStart\":null,\"remark\":null,\"saleType\":null,\"merchantProdLength\":null,\"freightTemplateId\":null,\"isVatInvoice\":0,\"firstShelfTime\":null,\"merchantProdHeight\":null,\"type\":1,\"isVoice\":1,\"chineseName\":\"kele\",\"productId\":1878082301000744,\"sourceType\":1,\"guaranteeDays\":null,\"isVisible\":1,\"categoryId\":1878080900000425,\"status\":0,\"merchantProdWidth\":null,\"isInvoice\":0,\"regionOfOriginCode\":null,\"countryOfOriginName\":null,\"provinceOfOriginName\":null,\"cityOfOriginName\":null,\"regionOfOriginName\":null,\"refId\":1878082301000747,\"channelCode\":\"-1\",\"isDefaultMerchantProduct\":null,\"saleMerchantProductBarcodeId\":null,\"storeId\":-1,\"canSale\":0,\"recycleStatus\":null,\"recycleTime\":null,\"dataType\":null,\"merchantProductId\":null,\"warehouseType\":1,\"ids\":null,\"childMpId\":null,\"mpIds\":null,\"itemIds\":null,\"mainPictureUrl\":null,\"mainUnitId\":1878082301000749,\"mainUnitName\":\"件\",\"mainUnitCode\":\"jian\",\"barcode\":null,\"brandName\":\"可口可乐\",\"categoryName\":\"蛋糕\",\"categoryIds\":null,\"salePriceWithTax\":null,\"purchasePriceWithTax\":null,\"priceId\":null,\"mpList\":null,\"marketPrice\":null,\"pssmId\":1878082301000748,\"operationStrategyId\":null,\"canSaleReturn\":1,\"canDistribution\":1,\"canPurchaseReturn\":1,\"canPurchase\":1,\"turnoverChannel\":null,\"attNameCount\":null,\"priceLevel\":null,\"orderMultipleNum\":null,\"orderStartNum\":null,\"canBatchCtrl\":null,\"canSequenceCtrl\":null,\"recycleFlag\":null,\"modificationType\":null,\"priceStatus\":null,\"mpType\":null,\"mpTypeOfProduct\":null,\"attNameListSize\":null,\"pssmIsAvailable\":null,\"purchaseSellStockManagementId\":null,\"itemId\":null,\"mpId\":null,\"mainPictureId\":null,\"attNameId\":null,\"attValueId\":null,\"barcodeId\":null,\"mpAttNameId\":null,\"mpAttValueId\":null,\"mpCategoryId\":null,\"mpMerchantId\":null,\"userId\":null,\"inventoryId\":null,\"mpCategoryFullNamePath\":null,\"userName\":null,\"fullIdPath\":null,\"attName\":null,\"attValue\":null,\"measurementUnitCode\":null,\"measurementUnit\":null,\"mpMerchantName\":null,\"storeName\":null,\"mpChannelBarcode\":null,\"mpChannelThirdUnitCode\":null,\"mpChannelMeasurementUnit\":null,\"thirdProductCode\":null,\"mpMainPictureUrl\":null,\"mpChineseName\":null,\"mpCode\":null,\"mpBrandName\":null,\"attValuesStr\":null,\"merchantCode\":null,\"merchantName\":null,\"auditMessage\":null,\"fullNamePath\":\"后台类目-下午茶-蛋糕\",\"salePriceWithoutTax\":null,\"saleTaxRate\":null,\"afterPrice\":null,\"beforePrice\":null,\"realStockNum\":null,\"applicationTime\":null,\"productLength\":null,\"productWidth\":null,\"productHeight\":null,\"weight\":null,\"productVolume\":null,\"purchasePriceWithoutTax\":null,\"recommendRetailPrice\":null,\"virtualStockNum\":null,\"startDate\":null,\"endDate\":null,\"attTypes\":null,\"typeOfProducts\":null,\"attValueIds\":null,\"attNameIds\":null,\"brandIds\":null,\"parentIds\":null,\"refIds\":null,\"storeIds\":null,\"attNameIdList\":null,\"barcodes\":null,\"channelCodes\":null,\"merchantIds\":null,\"productIds\":null,\"codes\":null,\"pictureUrlList\":null,\"attValueIdStrs\":null,\"attList\":null,\"videoUrlList\":null,\"merchantProductAttributeVOS\":null,\"mpAttList\":null,\"mpSeriesAttList\":null,\"merchantSecurityRelationPOS\":[{\"securityId\":1878080801000225}],\"attributeList\":null,\"mpAttrVoList\":null,\"merchantProductPageSearchFor\":null,\"refParentId\":null,\"barcodeList\":null,\"merchantProductVOList\":null,\"parentWarehouseType\":1,\"warehouseTypeView\":false,\"autoUpdate\":null,\"frontCanSale\":null,\"singleChannelStockVO\":null,\"enterWarehouse\":false,\"defaultWarehouseType\":1,\"startItem\":0}}");
        Object o = Ajax.post(driver,saveSelfProductUrl,param);
        System.out.println(JSON.toJSONString(o));
    }




    @Test
//   新增/修改商品文描接口
    public void saveMerchantProductDescription() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"mpId\":1878082301000747, \"describeType\":1,\"content\":\"123123123\"}");
        Object o = Ajax.post(driver,saveMerchantProductDescriptionUrl,param);
        System.out.println(JSON.toJSONString(o));
    }





    @Test
//    新增/修改商品售后接口
    public void saveMerchantProductAfterSales() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"mpId\":1878082301000747,\"content\":\"123123123\"}");
        Object o = Ajax.post(driver,saveMerchantProductAfterSalesUrl,param);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//    新增/修改商品售后接口
    public void listBrandByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"name\":\"可口可乐\",\"currentPage\":0,\"itemsPerPage\":10,\"merchantIds\":[2029080800000000]}");
        Object o = Ajax.post(driver,listBrandByPageUrl,param);
        System.out.println(JSON.toJSONString(o));
    }



}
