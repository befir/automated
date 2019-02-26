package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CategoryBack extends RestfulAutomatedTest {

    private String addCategoryRootUrl = baseUrl + "/back-product-web2/back/category/addCategoryRoot.do";
    private String listRootCategoryBackUrl = baseUrl + "/back-product-web2/back/category/listRootCategoryBack.do";
    private String addCategoryChildUrl = baseUrl + "/back-product-web2/back/category/addCategoryChild.do";
    private String updateCategoryUrl = baseUrl + "/back-product-web2/back/category/updateCategory.do";
    private String queryCategoryTreeNodeByNameUrl = baseUrl + "/back-product-web2/back/category/queryCategoryTreeNodeByName.do";
    private String aggregationSingleBackGroundNodeUrl = baseUrl + "/back-product-web2/back/category/aggregationSingleBackGroundNode.do";
    private String saveAggreationMpUrl = baseUrl + "/back/category/saveAggreationMp.do";
    private String deleteCategoryRootUrl = baseUrl + "/back-product-web2/back/category/deleteCategoryRoot.do";



    @Test
//    平台类目新增
    public void addCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"type\":2,\"name\":\"名称\",\"categoryCode\":\"123\"}");
        Object o = Ajax.post(driver,addCategoryRootUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "SAME_NAME_EXIST";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }


    @Test
//    平台类目查询
    public void listRootCategoryBack() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"name\":\"名称\"}");
        Object o = Ajax.post(driver,listRootCategoryBackUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }


    @Test
//    平台类目子类目新增
    public void addCategoryChild() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"parentId\":1878083400000237,\"name\":\"食品\",\"categoryCode\":\"12323\",\"isVisible\":1}");
        Object o = Ajax.post(driver,addCategoryChildUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "PARENT_CATEGORY_NOT_EXIST";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }



    @Test
//    平台类目子类目编辑
    public void updateCategory() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1878083400000243,\"name\":\"食品123\",\"categoryCode\":\"12323\",\"pictureUrl\":null,\"isVisible\":1,\"thirdCode\":null}");
        Object o = Ajax.post(driver,updateCategoryUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "CATEGORY_NOT_EXIST";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }



    @Test
//    平台类目子类目查询
    public void queryCategoryTreeNodeByName() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"firstCategoryId\":1878083400000237}");
        Object o = Ajax.post(driver,queryCategoryTreeNodeByNameUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "CATEGORY_NOT_EXIST";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }




    @Test
//    平台类目子类目聚合类目
    public void aggregationSingleBackGroundNode() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"leftTreeNodeId\":1878083400000243,\"rightTreeNodeId\":1878080900000585}");
        Object o = Ajax.post(driver,aggregationSingleBackGroundNodeUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "LEFTTREEE_IS_EQUALS_RIGHTTREE";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }




    @Test
//    平台类目子类目聚合商品
    public void saveAggreationMp() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\"categoryTreeNodeRelationId\":1878083400000243,\"productId\":1878083400000135,\"type\":0}]");
        Object o = Ajax.post(driver,saveAggreationMpUrl,param);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//    平台类目删除
    public void deleteCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1878083400000237}");
        Object o = Ajax.post(driver,deleteCategoryRootUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "CATEGORY_NOT_EXIST";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }



}
