package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class categoryapply extends RestfulAutomatedTest {
    private String listCategoryAuditUrl = baseUrl + "/back-product-web2/back/categoryApply/listCategoryAudit.do";
    private String auditCategoryApplyUrl = baseUrl + "/back-product-web2/back/categoryApply/auditCategoryApply.do";
    private String auditCategoryApply2Url = baseUrl + "/back-product-web2/back/categoryApply/auditCategoryApply.do";
    private String queryPlatformAuthMerchantUrl = baseUrl + "/back-merchant-web/api/merchant/queryPlatformAuthMerchantPage.do";
    private String deleteCategoryRootUrl = baseUrl + "/back-product-web2/back/category/deleteCategoryRoot.do";



    @Test
//   查询类目审核
    public void listCategoryAudit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"merchantId\":2029080800000000}");
        Object o = Ajax.post(driver, listCategoryAuditUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
        String categoryId= listObj.getJSONObject(0).getString("categoryId");
        String categoryCode= listObj.getJSONObject(0).getString("categoryCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878081401001131";
        String expectedData1 ="1023002";
        String expectedData2= "0";
        Assert.assertEquals(categoryId,expectedData);
        Assert.assertEquals(categoryCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(categoryCode);
        System.out.println(categoryId);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//   类目审核通过
    public void auditCategoryApply() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"status\":2,\"categoryApplyIds\":[1878082801000233]}");
        Object o = Ajax.post(driver, auditCategoryApplyUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String categoryId= listObj.getJSONObject(0).getString("categoryId");
//        String categoryCode= listObj.getJSONObject(0).getString("categoryCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878081401001131";
        String expectedData1 ="1023002";
        String expectedData2= "0";
//        Assert.assertEquals(categoryId,expectedData);
//        Assert.assertEquals(categoryCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(categoryCode);
//        System.out.println(categoryId);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//   类目审核拒绝
    public void auditCategoryApply2() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"status\":\"3\",\"message\":\"拒绝\",\"categoryApplyIds\":[1878082301000398]}");
        Object o = Ajax.post(driver,auditCategoryApply2Url,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantType= listObj.getJSONObject(0).getString("merchantType");
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="11";
        String expectedData1 ="可口可乐";
        String expectedData2= "0";
//        Assert.assertEquals(merchantType,expectedData);
//        Assert.assertEquals(merchantName,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantName);
//        System.out.println(merchantType);
        System.out.println(JSON.toJSONString(o));
    }




    @Test
//   查看类目审核
    public void queryPlatformAuthMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":1000}");
        Object o = Ajax.post(driver,queryPlatformAuthMerchantUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantType= listObj.getJSONObject(0).getString("merchantType");
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="11";
        String expectedData1 ="可口可乐";
        String expectedData2= "0";
//        Assert.assertEquals(merchantType,expectedData);
//        Assert.assertEquals(merchantName,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantName);
//        System.out.println(merchantType);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    平台类目删除
    public void deleteCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1878083400000237}");
        Object o = Ajax.post(driver,deleteCategoryRootUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        //打印出o
        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantType= listObj.getJSONObject(0).getString("merchantType");
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="11";
        String expectedData1 ="可口可乐";
        String expectedData2= "CATEGORY_NOT_EXIST";
//        Assert.assertEquals(merchantType,expectedData);
//        Assert.assertEquals(merchantName,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantName);
//        System.out.println(merchantType);
        System.out.println(JSON.toJSONString(o));
    }


}
