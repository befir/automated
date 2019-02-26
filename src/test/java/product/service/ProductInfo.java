package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//
public class ProductInfo extends RestfulAutomatedTest {

    private String queryProductInfoUrl = baseUrl + "/back-product-web2/back/product/queryProductInfoByPage.do";
    private String updateProductInfoUrl = baseUrl + "/back-product-web2/back/product/updateProductInfo.do";
    private String addProductDescriptionUrl = baseUrl + "/back-product-web2/back/product/addProductDescription.do";
    private String addProductAfterSaleUrl = baseUrl + "/back-product-web2/back/product/addProductAfterSale.do";
    private String queryProductAttributeByPIdUrl = baseUrl + "/back-product-web2/back/product/queryProductAttributeByPId.do.do";
    private String updateCanSaleUrl = baseUrl + "/back-product-web2/back/product/updateCanSale.do";
    private String updateCanSale1Url = baseUrl + "/back-product-web2/back/product/updateCanSale.do";
    private String queryProductPictureListByPIdUrl = baseUrl + "/back-product-web2/back/product/queryProductPictureListByPId.do";
    private String queryProductPictureListUrl = baseUrl + "/back-product-web2/back/product/queryProductPictureListByPId.do";
    private String updateProductUrl = baseUrl + "/back-product-web2/back/product/updateProductInfo.do";

    @Test
//    查询产品
    public void queryProductInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"code\":\"1878082203000218\"}");
        Object o = Ajax.post(driver,queryProductInfoUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String brandId= listObj.getJSONObject(0).getString("brandId");
        String categoryId= listObj.getJSONObject(0).getString("categoryId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878080800000003";
        String expectedData1 ="1878080900000425";
        String expectedData2= "0";
        Assert.assertEquals(brandId,expectedData);
        Assert.assertEquals(categoryId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(categoryId);
        System.out.println(brandId);
    }

    @Test
//    编辑产品
    public void updateProductInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082203000219,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"productVolume\":54,\"englishName\":\"gfjgh\",\"subtitle\":\"发的规划\",\"productLength\":54,\"weightValue\":null,\"brandId\":1878080800000003,\"sourceType\":1,\"title\":\"tf16\",\"productHeight\":54,\"thirdProductCode\":\"1234\",\"code\":\"1878082203000218\",\"productWidth\":45,\"uniformPrice\":null,\"publishDate\":null,\"weight\":null,\"artNo\":\"45645\",\"modelType\":1,\"productModel\":null,\"categoryId\":1878080900000425,\"grossWeight\":45,\"regionOfOriginCode\":null,\"countryOfOriginName\":null,\"provinceOfOriginName\":null,\"cityOfOriginName\":null,\"regionOfOriginName\":null,\"shelflifeDays\":54,\"isWeighted\":0,\"measureType\":1,\"isForceInvoice\":0,\"isVatInvoice\":1,\"isInvoice\":1,\"fullIdPath\":\"2008078900000002-1878080800000004-1878080900000425\",\"fullNamePath\":\"后台类目-下午茶-蛋糕\",\"typeOfProduct\":0,\"categoryTreeNodeRelationId\":null,\"ids\":null,\"canSale\":1,\"brandName\":\"可口可乐\",\"categoryName\":\"蛋糕\",\"categoryIds\":null,\"barcode\":null,\"mainUnitId\":null,\"mainUnitName\":\"件\",\"mainUnitCode\":\"jian\",\"mainPictureUrl\":null,\"originString\":null,\"merchantId\":null,\"canAggravate\":null,\"startItem\":0}");
        Object o = Ajax.post(driver,updateProductInfoUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }


    @Test
//    添加产品描述
    public void addProductDescription() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"content\":\"<span style=\\\"color:#7D8082;font-family:&quot;font-size:14px;font-variant-numeric:normal;font-variant-east-asian:normal;line-height:21px;white-space:normal;widows:1;background-color:#FFFFFF;\\\"><span class=\\\"Apple-converted-space\\\">&nbsp;</span>上面的问题有结果了么</span>\",\"type\":1,\"productId\":1878082203000219}");
        Object o = Ajax.post(driver,addProductDescriptionUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
//    添加产品售后
    public void addProductAfterSale() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"content\":\"<span style=\\\"color:#7D8082;font-family:&quot;font-size:14px;font-variant-numeric:normal;font-variant-east-asian:normal;line-height:21px;white-space:normal;widows:1;background-color:#FFFFFF;\\\"><span class=\\\"Apple-converted-space\\\">&nbsp;</span>上面的问题有结果了么</span>\",\"type\":1,\"productId\":1878082203000219}");
        Object o = Ajax.post(driver,addProductAfterSaleUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
//    添加产品属性
    public void queryProductAttributeByPId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"productId\":\"1878082700000223\"}");
        Object o = Ajax.post(driver,queryProductAttributeByPIdUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    产品允许销售
    public void updateCanSale() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"productVOS\":[{\"id\":1878082700000408,\"canSale\":1}],\"batchCanSale\":1}");
        Object o = Ajax.post(driver,updateCanSaleUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
//    产品不可销售
    public void updateCanSale1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"productVOS\":[{\"id\":1878082700000388,\"canSale\":1}],\"batchCanSale\":1}");
        Object o = Ajax.post(driver,updateCanSale1Url,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
//    产品上传图片
    public void queryProductPictureListByPId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"pictureUrl\": \"https://cdn.oudianyun.com/trunk/back-product/1541668401569_4.611224571720729_71456a0b-1691-4621-a39b-15dcba33f99a.jpg\"\n}");
        Object o = Ajax.post(driver,queryProductPictureListByPIdUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "PRODUCT_ID_IS_NULL";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }

    @Test
//    产品删除图片
    public void queryProductPictureList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"productId\":\"1878082700000223\"}");
        Object o = Ajax.post(driver,queryProductPictureListUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    产品新增英文名称
    public void updateProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082700000223,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"productVolume\":null,\"englishName\":\"fghdh\",\"subtitle\":null,\"productLength\":null,\"weightValue\":null,\"brandId\":1878081702002272,\"sourceType\":1,\"title\":\"大果粒奶茶\",\"productHeight\":null,\"thirdProductCode\":null,\"code\":\"1878082700000222\",\"productWidth\":null,\"uniformPrice\":null,\"publishDate\":null,\"weight\":null,\"artNo\":null,\"modelType\":1,\"productModel\":null,\"categoryId\":1878080800000006,\"grossWeight\":null,\"regionOfOriginCode\":null,\"countryOfOriginName\":null,\"provinceOfOriginName\":null,\"cityOfOriginName\":null,\"regionOfOriginName\":null,\"shelflifeDays\":null,\"isWeighted\":0,\"measureType\":1,\"isForceInvoice\":0,\"isVatInvoice\":0,\"isInvoice\":0,\"fullIdPath\":\"2008078900000002-1878080800000004-1878080800000006\",\"fullNamePath\":\"后台类目-下午茶-饮料\",\"typeOfProduct\":1,\"categoryTreeNodeRelationId\":null,\"ids\":null,\"canSale\":0,\"brandName\":\"奶茶\",\"categoryName\":\"饮料\",\"categoryIds\":null,\"barcode\":null,\"mainUnitId\":null,\"mainUnitName\":\"件\",\"mainUnitCode\":\"jian\",\"mainPictureUrl\":null,\"originString\":null,\"merchantId\":null,\"canAggravate\":null,\"startItem\":0}");
        Object o = Ajax.post(driver,updateProductUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }












}
