package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class restful extends RestfulAutomatedTest {

    private String queryMerchantProductUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryMerchantProductByPage.do";
    private String listStoreCategoryUrl = baseUrl + "/back-product-web2/back/category/listStoreCategory.do";
    private String listMpAuditUrl = baseUrl + "/back-product-web2/back/mpPriceAudit/listMpAudit.do";
    private String queryMerchantProdSecurityListUrl = baseUrl + "/back-product-web2/back/merchantProdSecurity/queryMerchantProdSecurityList.do";
    private String queryStoreProductUrl = baseUrl + "/back-product-web2/back/storeProduct/queryStoreProductByPage.do";
    private String queryPictureUrl = baseUrl + "/back-product-web2/back/merchantProduct/queryPictureByMpId.do";
    private String listSuperscriptUrl = baseUrl + "/back-product-web2/back/superscript/listSuperscriptByPage.do";
    private String deleteMerchantProdSecurityUrl = baseUrl + "/back-product-web2/back/merchantProdSecurity/deleteMerchantProdSecurityById.do";
    private String merchantProdSecurityEditUrl = baseUrl + "/back-product-web2/back/merchantProdSecurity/merchantProdSecurityEdit.do";
    private String queryOperationStrategyUrl = baseUrl + "/back-product-web2/back/operationStrategy/queryOperationStrategy.do";
    private String uploadMediaUrl = baseUrl + "/back-product-web2/back/media/uploadMedia.do";
    private String updateMerchantProductDescriptionUrl = baseUrl + "/back-product-web2/back/merchantProduct/updateMerchantProductDescription.do";
    private String addCategoryRootUrl = baseUrl + "/back-product-web2/back/category/addCategoryRoot.do";
    private String deleteCategoryRootUrl = baseUrl + "/back-product-web2/back/category/deleteCategoryRoot.do";

    @Test
//    查询商家商品
    public void queryMerchantProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryMerchantProductUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String brandId= listObj.getJSONObject(0).getString("brandId");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878083000000259";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
        Assert.assertEquals(brandId,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(brandId);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
//    查询店铺类目
    public void listStoreCategory() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,listStoreCategoryUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String id= listObj.getJSONObject(0).getString("id");
        String parentId= listObj.getJSONObject(0).getString("parentId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878080902000000";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
        Assert.assertEquals(id,expectedData);
        Assert.assertEquals(parentId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(parentId);
        System.out.println(id);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    查询价格变更审核
    public void listMpAudit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,listMpAuditUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
        String userName= listObj.getJSONObject(0).getString("userName");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="2029080800003446";
        String expectedData1 ="spx101701";
        String expectedData2= "0";
        Assert.assertEquals(merchantId,expectedData);
        Assert.assertEquals(userName,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(userName);
        System.out.println(merchantId);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    查询商品保障
    public void queryMerchantProdSecurityList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryMerchantProdSecurityListUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    查询价格变更审核
    public void queryStoreProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryStoreProductUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String productCode= listObj.getJSONObject(0).getString("productCode");
        String categoryId= listObj.getJSONObject(0).getString("categoryId");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878082203000018";
        String expectedData1 ="1878080900000425";
        String expectedData2= "0";
        Assert.assertEquals(productCode,expectedData);
        Assert.assertEquals(categoryId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(categoryId);
        System.out.println(productCode);
        System.out.println(JSON.toJSONString(o));

    }

    @Test
//    查询单个商品媒体（图片，视频）-RestFul（可对接）
    public void queryPicture() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("merchantProdId","1878081402000526");
        Object o = Ajax.post(driver,queryPictureUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    根据角标名称查询角标
    public void listSuperscript() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("name","爆款12");
        Object o = Ajax.post(driver,listSuperscriptUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    删除商品保障
    public void deleteMerchantProdSecurity() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("id","1809081300000023");
        Object o = Ajax.post(driver,deleteMerchantProdSecurityUrl,param);
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
//    新增商品保障
    public void merchantProdSecurityEdit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("merchantId","1811076601000000");
        param.put("title","名称");
        Object o = Ajax.post(driver,merchantProdSecurityEditUrl,param);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//    查询经营状态
    public void queryOperationStrategy() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryOperationStrategyUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    商品上传图片
    public void uploadMedia() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,uploadMediaUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    新增商品描述
    public void updateMerchantProductDescription() throws InterruptedException {
        JSONObject param = JSON.parseObject("{merchantProductId:'',type:'',content:''}");
        param.put("merchantProductId","1809081900000006");
        param.put("type",1);
        param.put("content","加他微信");
        Object o = Ajax.post(driver,updateMerchantProductDescriptionUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    新增店铺类目
    public void addCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{merchantProductId:'',type:'',content:''}");
        param.put("storeId","1811080800000191");
        param.put("addType",1);
        Object o = Ajax.post(driver,addCategoryRootUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    删除店铺类目
    public void deleteCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{merchantProductId:'',type:'',content:''}");
        param.put("id","1809081900000011");
        Object o = Ajax.post(driver,deleteCategoryRootUrl,param);
        System.out.println(JSON.toJSONString(o));
    }





}
