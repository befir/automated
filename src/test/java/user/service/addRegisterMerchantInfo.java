package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;


//商家员工
public class addRegisterMerchantInfo extends RestfulAutomatedTest {
    //
    //编辑员工
    private String addRegisterMerchantInfourl =  baseUrl+"/back-merchant-web/registerMerchant/addRegisterMerchantInfo.do";
    //查询
    private String queryRegisterMerchantPageInfourl = baseUrl+"/back-merchant-web/registerMerchant/queryRegisterMerchantPageInfo.do";
    //编辑基本信息
    private String queryEntryTermsByIdUrl = baseUrl+"/back-merchant-web/entryTerms/queryEntryTermsById.do.do";
    //资质证书
    private String addMerchantOrgCertificateurl = baseUrl+"/back-merchant-web/merchantOrgCertificate/addMerchantOrgCertificate.do";
    //品牌管理
    private String  listMerchantBrandurl = baseUrl+"/back-product-web2/back/merchantBrand/listMerchantBrand.do";
    //类目管理
    private String  listCategoryApplyurl = baseUrl+"/back-product-web2/back/categoryApply/listCategoryApply.do";





    //编辑员工
    @Test
    public void addRegisterMerchantInfourl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantType\":\"11\",\"orgCode\":\"123\",\"orgName\":\"123\"}");
        Object o = Ajax.post(driver, addRegisterMerchantInfourl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        //断言
        String expectedcode2 = "-1";
        Assert.assertEquals(actualResult.get("code"),expectedcode2);
        System.out.println(JSON.toJSONString(o));
    }
    //查询
    @Test
    public void queryRegisterMerchantPageInfourl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"businessStatus\":\"\",\"merchantType\":\"\",\"auditStatus\":\"\",\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, queryRegisterMerchantPageInfourl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
////断言code
        String expectedcode2 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode2);
        System.out.println(JSON.toJSONString(o));
    }

    //编辑基本信息
    @Test
    public void queryEntryTermsByIdUrl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"entryType\":1,\"status\":1}");
        Object o = Ajax.post(driver, queryEntryTermsByIdUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
////断言Code
        String expectedcode3 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode3);
        System.out.println(JSON.toJSONString(o));
    }

    //资质证书
    @Test
    public void  addMerchantOrgCertificateurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"certificateName\":\"1\",\"periodBegin\":\"2018-12-06\",\"periodEnd\":\"2018-12-06\",\"fileUrl\":\"https://cdn.oudianyun.com/trunk/back-merchant-web/1544093637435_86.06474088194075_c71a07b1-66a1-41e7-b916-bbde3c2a64d7.jpg\",\"orgId\":\"2076085801000027\"}");
        Object o = Ajax.post(driver,addMerchantOrgCertificateurl , param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //        断言code
        String expectedcode3 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode3);
        System.out.println(JSON.toJSONString(o));

    }

    //品牌管理
    @Test
    public void listMerchantBrandurl  () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"merchantId\":\"2076085801000027\"}");
        Object o = Ajax.post(driver, listMerchantBrandurl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言code
        String expectedcode3 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode3);
        System.out.println(JSON.toJSONString(o));

    }
    //类目管理
    @Test
    public void listCategoryApplyurl () throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantId\":\"2076085801000027\"}");
        Object o = Ajax.post(driver, listCategoryApplyurl , param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        //断言
        String expectedcode2 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedcode2);
        System.out.println(JSON.toJSONString(o));
    }




}

