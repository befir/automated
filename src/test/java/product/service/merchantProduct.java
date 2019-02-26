package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class merchantProduct extends RestfulAutomatedTest {
    //查询商家商品列表
    private String queryMerchantProductByPageUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryMerchantProductByPage.do";
    //查询操作策略
    private String queryOperationStrategyUrl = baseUrl + "/back-product-web2/back/operationStrategy/queryOperationStrategy.do";
    //查询商品保障
    private String queryMerchantProdSecurityListUrl = baseUrl + "/back-product-web2/back/merchantProdSecurity/queryMerchantProdSecurityList.do";
    //查询主计量单位
    private String queryCalculationUnitByPageUrl = baseUrl + "/back-product-web2/back/product/queryCalculationUnitByPage.do";
    //查询商家平台
    private String queryPlatformAuthMerchantPageUrl = baseUrl + "/back-merchant-web/api/merchant/queryPlatformAuthMerchantPage.do";
    //查询后台类目
    private String queryGrantedCategoryListByMerchantUrl = baseUrl + "/back-product-web2/back/category/queryGrantedCategoryListByMerchant.do";
    //新增商品1106
    private String saveSelfProductUrl = baseUrl + "/back-product-web2/back/merchantProduct/saveSelfProduct.do";
    //商家商品销售区域列表
    private String listMerchantProductSaleAreaListUrl = baseUrl + "/back-product-web2/back/merchantProductSaleArea/listMerchantProductSaleAreaList.do";
    //请求自有模板
    private String queryFreightTemplateListByMerchantIdUrl = baseUrl + "/back-product-web2/back/thirdParty/queryFreightTemplateListByMerchantId.do";
    //请求商品图片1106
    private String queryPictureByMpIdUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryPictureByMpId.do";
    //保存商品图片
    private String addPicturesUrl = baseUrl + "/back-product-web2/back/merchantProduct/addPictures.do";
    //请求商品描述1106
    private String queryMerchantProductDescriptionByPIdAndTypeUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryMerchantProductDescriptionByPIdAndType.do";
   //更新商品描述1106
    private String updateMerchantProductDescriptionUrl = baseUrl + "/back-product-web2/back/merchantProduct/updateMerchantProductDescription.do";
    //请求商品售后1106
    private String queryMerchantProductAfterSaleByMPIdUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryMerchantProductAfterSaleByMPId.do";
    //新增商品售后1106
    private String addMerchantProductAfterSaleUrl = baseUrl + "/back-product-web2/back/merchantProduct/addMerchantProductAfterSale.do";
    //更新商品售后1106
    private String updateMerchantProductAfterSaleUrl = baseUrl + "/back-product-web2/back/merchantProduct/updateMerchantProductAfterSale.do";

    @Test
    public void queryMerchantProductByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"sourceType\": 1,\n" +
                "\t\"recycleStatus\": 0,\n" +
                "\t\"typeOfProducts\": [0, 3, 4]\n" +
                "}");
        Object o = Ajax.post(driver, queryMerchantProductByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String brandId= listObj.getJSONObject(0).getString("brandId");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878083000000259";
        String expectedData1 ="2029080800000000";
        String expectedData2= "0";
        Assert.assertEquals(brandId,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(brandId);
    }
        @Test
        public void queryOperationStrategy() throws InterruptedException {
            JSONObject param = JSON.parseObject("{\n" +
                    "\t\"currentPage\": 0,\n" +
                    "\t\"itemsPerPage\": 100\n" +
                    "}");
            Object o = Ajax.post(driver, queryOperationStrategyUrl, param);

            System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void queryMerchantProdSecurityList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver, queryMerchantProdSecurityListUrl, param);
//
        System.out.println(JSON.toJSONString(o));

    }

    @Test
    public void queryCalculationUnitByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10\n" +
                "}");
        Object o = Ajax.post(driver, queryCalculationUnitByPageUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void queryPlatformAuthMerchantPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 1000\n" +
                "}");
        Object o = Ajax.post(driver, queryPlatformAuthMerchantPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
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
    public void queryGrantedCategoryListByMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": 2029080800003446\n" +
                "}");
        Object o = Ajax.post(driver, queryGrantedCategoryListByMerchantUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test //1206
    public void saveSelfProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"typeOfProduct\": 0,\n" +
                "\t\"type\": 1,\n" +
                "\t\"isWeighted\": 0,\n" +
                "\t\"measureType\": 1,\n" +
                "\t\"canPurchase\": 1,\n" +
                "\t\"canSale\": 1,\n" +
                "\t\"canSaleReturn\": 1,\n" +
                "\t\"canPurchaseReturn\": 1,\n" +
                "\t\"canDistribution\": 1,\n" +
                "\t\"isInvoice\": 0,\n" +
                "\t\"isVatInvoice\": 0,\n" +
                "\t\"isForceInvoice\": 0,\n" +
                "\t\"merchantId\": 2029080800003446,\n" +
                "\t\"brandName\": \"桂源铺\",\n" +
                "\t\"brandId\": 1878080801000128,\n" +
                "\t\"chineseName\": \"百褶裙\",\n" +
                "\t\"mainUnitName\": \"jian-件\",\n" +
                "\t\"mainUnitId\": 2008078900000013,\n" +
                "\t\"mainUnitCode\": \"jian\",\n" +
                "\t\"fullNamePath\": \"后台类目-下午茶-其他\",\n" +
                "\t\"categoryName\": \"其他\",\n" +
                "\t\"categoryId\": 1878080801000132,\n" +
                "\t\"warehouseTypeView\": true,\n" +
                "\t\"merchantSecurityRelationPOS\": [{\n" +
                "\t\t\"securityId\": 1878080801000320\n" +
                "\t}]\n" +
                "}");
        Object o = Ajax.post(driver, saveSelfProductUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);



    }

    @Test
    public void listMerchantProductSaleAreaList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantId\": \"2029080800003446\",\n" +
                "\t\"merchantProductId\": \"1878082801000215\"\n" +
                "}");
        Object o = Ajax.post(driver, listMerchantProductSaleAreaListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
    public void queryFreightTemplateListByMerchantId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver, queryFreightTemplateListByMerchantIdUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "ERROR_CODE_CHECKPARAMS";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
    public void queryPictureByMpId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProdId\": \"1878082801000215\"\n" +
                "}");
        Object o = Ajax.post(driver, queryPictureByMpIdUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
    public void addPictures() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\n" +
                "\t\"merchantProdId\": \"1878082801000215\",\n" +
                "\t\"pictureUrl\": \"https://cdn.oudianyun.com/trunk/back-product/1541492954955_56.08845723961225_a0cf7fe3-ca22-4d60-9e9d-6d1ed4302146.jpg\",\n" +
                "\t\"sortValue\": 1,\n" +
                "\t\"clientType\": 0\n" +
                "}]");
        Object o = Ajax.post(driver, addPicturesUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test
    public void queryMerchantProductDescriptionByPIdAndType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProductId\": \"1878082801000215\",\n" +
                "\t\"type\": 1\n" +
                "}");
        Object o = Ajax.post(driver, queryMerchantProductDescriptionByPIdAndTypeUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
    public void updateMerchantProductDescription() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProductId\": \"1878082801000215\",\n" +
                "\t\"type\": 1,\n" +
                "\t\"content\": \"爱是若干\"\n" +
                "}");
        Object o = Ajax.post(driver, updateMerchantProductDescriptionUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void queryMerchantProductAfterSaleByMPId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"merchantProductId\": \"1878082801000215\"\n" +
                "}");
        Object o = Ajax.post(driver, queryMerchantProductAfterSaleByMPIdUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void addMerchantProductAfterSale() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"content\": \"艾薇儿艾薇儿\",\n" +
                "\t\"merchantProductId\": 1878082801000215\n" +
                "}");
        Object o = Ajax.post(driver, addMerchantProductAfterSaleUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void updateMerchantProductAfterSale() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"content\": \"阿尔噶噶\",\n" +
                "\t\"merchantProductId\": 1878082801000215\n" +
                "}");
        Object o = Ajax.post(driver, updateMerchantProductAfterSaleUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
}
