package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class addCategoryRoot extends RestfulAutomatedTest {
    private String addCategoryRootUrl = baseUrl + "/back-product-web2/back/category/addCategoryRoot.do";
    private String listMerchantCategoryUrl = baseUrl + "/back-product-web2/back/category/listMerchantCategory.do";
    private String fileUploadToKsyUrl = baseUrl + "/back-product-web2/back/media/fileUploadToKsy.do";
    private String addCategoryChildUrl = baseUrl + "/back-product-web2/back/category/addCategoryChild.do";
    private String queryCategoryTreeNodeByNameUrl = baseUrl + "/back-product-web2/back/category/queryCategoryTreeNodeByName.do";
    private String deleteCategoryRootUrl = baseUrl + "/back-product-web2/back/category/deleteCategoryRoot.do";





    @Test
//    商家类目新增
    public void addCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" + "\t\"type\": 4,\n" + "\t\"merchantId\": 2029080800000000,\n" + "\t\"name\": \"东方宝石\",\n" + "\t\"categoryCode\": \"123\"\n" + "}");
        Object o = Ajax.post(driver,addCategoryRootUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    商家类目查询
    public void listMerchantCategory() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" + "\t\"currentPage\": 1,\n" + "\t\"itemsPerPage\": 10,\n" + "\t\"name\": \"东方宝石\"\n" + "}");
        Object o = Ajax.post(driver,listMerchantCategoryUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    商家类目编辑
    public void fileUploadToKsy() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"url\":\"\"}");
        param.put("url","https://cdn.oudianyun.com/trunk/back-product/1541402745692_99.87172390309156_7d389910-ddd1-4941-9ce6-54c971c276c1.jpg");
        Object o = Ajax.post(driver,fileUploadToKsyUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    商家子类目新增
    public void addCategoryChild() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" + "\t\"parentId\": 1878082700001574,\n" + "\t\"name\": \"洗护用品\",\n" + "\t\"categoryCode\": \"5\",\n" + "\t\"isVisible\": 1\n" + "}");
        Object o = Ajax.post(driver,addCategoryChildUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    商家子类目新增
    public void queryCategoryTreeNodeByName() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" + "\t\"firstCategoryId\": 1878082700001574\n" + "}");
        Object o = Ajax.post(driver,queryCategoryTreeNodeByNameUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    商家子类目新增
    public void deleteCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" + "\t\"id\": 1878082700001574,\n" + "\t\"type\": 4\n" + "}");
        Object o = Ajax.post(driver,deleteCategoryRootUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


}
