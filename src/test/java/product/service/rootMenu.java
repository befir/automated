package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class rootMenu extends RestfulAutomatedTest {
    private String queryCalculationUnitInfoUrl = baseUrl + "/back-product-web2/back/calculation/queryCalculationUnitInfoByPage.do";
    private String UpdateCalculationUnitUrl = baseUrl + "/back-product-web2/back/calculation/addOrUpdateCalculationUnit.do";
    private String addCalculationUnitUrl = baseUrl + "/back-product-web2/back/calculation/addOrUpdateCalculationUnit.do";
    private String listBrandUrl = baseUrl + "/back-product-web2/back/brand/listBrandByPage.do";
    private String addBrandInfoUrl = baseUrl + "/back-product-web2/back/brand/addBrandInfo.do";
    private String updateBrandInfoUrl = baseUrl + "/back-product-web2/back/brand/updateBrandInfo.do";
    private String addAttributeInfoUrl = baseUrl + "/back-product-web2/back/attribute/addAttributeInfo.do";
    private String deleteAttributeUrl = baseUrl + "/back-product-web2/back/attribute/deleteAttribute.do";


//

    @Test
//    查询经营状态
    public void queryCalculationUnitInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"calculationUnitCode\":\"ceshi\"}");
        Object o = Ajax.post(driver,queryCalculationUnitInfoUrl,param);
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
//    编辑经营状态
    public void UpdateCalculationUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1809081300000014,\"isAvailable\":1,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"calculationUnitName\":\"ceshi2\",\"calculationUnitCode\":\"ceshi\",\"decimalDigits\":0,\"startItem\":0}");
        Object o = Ajax.post(driver,UpdateCalculationUnitUrl,param);
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
//        b em.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    新增经营状态
    public void addCalculationUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1809081300000014,\"isAvailable\":1,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"calculationUnitName\":\"ceshi2\",\"calculationUnitCode\":\"ceshi\",\"decimalDigits\":0,\"startItem\":0}");
        Object o = Ajax.post(driver,addCalculationUnitUrl,param);
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
//    查询商品品牌
    public void listBrand() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"name\":\"良品铺子\"}");
        Object o = Ajax.post(driver,listBrandUrl,param);
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
//    新增商品品牌
    public void addBrandInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"name\":\"证件卡\",\"introduction\":\"\"}");
        Object o = Ajax.post(driver,addBrandInfoUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    更新商品品牌
    public void updateBrandInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082206000005,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"code\":\"1878082206000004\",\"name\":\"证件卡\",\"chineseName\":null,\"englishName\":\"mc\",\"alias\":null,\"logUrl\":null,\"owner\":null,\"dataSourceType\":1,\"dataSource\":null,\"trademarkUrl\":null,\"registrationNumber\":null,\"ownedcompanyChineseName\":null,\"ownedcompanyEnglishName\":null,\"introduction\":\"\",\"certificateName1\":null,\"certificatePicurl1\":null,\"certificateName2\":null,\"certificatePicurl2\":null,\"certificateName3\":null,\"certificatePicurl3\":null,\"merchantCode\":null,\"merchantName\":null,\"startItem\":0}");
        Object o = Ajax.post(driver,updateBrandInfoUrl,param);
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
        String expectedData2= "SAME_NAME_EXIST";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));

    }

    @Test
//    新增属性
    public void addAttributeInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"addType\":0,\"attributeValuePOS\":[{\"addType\":0,\"value\":\"大大\",\"sortValue\":0},{\"addType\":0,\"value\":\"小小\",\"sortValue\":1},{\"addType\":0,\"value\":\"中中\",\"sortValue\":2}],\"code\":\"879\",\"name\":\"测试001\"}");
        Object o = Ajax.post(driver,addAttributeInfoUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

//    @Test
////    删除属性
//    public void deleteAttribute() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082206000032,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"name\":\"测试001\",\"code\":\"879\",\"attributeValuePOS\":[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082206000033,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attributeNameId\":1878082206000032,\"value\":\"大大\",\"sortValue\":0,\"code\":null,\"addType\":1,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082206000034,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attributeNameId\":1878082206000032,\"value\":\"小小小\",\"sortValue\":1,\"code\":null,\"addType\":1,\"startItem\":0},{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082206000035,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"attributeNameId\":1878082206000032,\"value\":\"中中\",\"sortValue\":2,\"code\":null,\"addType\":1,\"startItem\":0}],\"attributeValuesStr\":\"大大,小小小,中中\",\"addType\":1,\"startItem\":0}");
//        Object o = Ajax.post(driver,deleteAttributeUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }






}
