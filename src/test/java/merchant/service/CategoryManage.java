package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;


public class CategoryManage extends RestfulAutomatedTest {

    //查询商家已添加的类目
    private String queryMerchantBrand = baseUrl+"/back-product-web2/back/categoryApply/listCategoryApply.do";
    //获取商品根类目信息
    private String getBrandByParam = baseUrl+"/back-product-web2/back/category/getBackgroundDetailUrl.do";
    //获取商品根类目下的类目信息
    private String queryBrandByParam = baseUrl+"/back-product-web2/back/category/queryCategoryListByParent.do";
    //根据ID查询商品类目信息
    private String queryMerchantBrandByMerchantId = baseUrl+"/back-product-web2/back/category/querySubCtgTreeNodeByParentId.do";
    //添加商家商品类目
    private String addMerchantBrand = baseUrl+"/back-product-web2/back/categoryApply/applyCategory.do";
    //删除商家已添加的商品类目
    private String deleteMerchantBrandById = baseUrl+"/back-product-web2/back/categoryApply/deleteCategoryApply.do";
    @Test
    public void queryMerchantBrand() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantId\":\"\"}");
        param.put("merchantId","2029080800000000");
        Object o = Ajax.post(driver,queryMerchantBrand,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getBrandByParam() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,getBrandByParam,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryBrandByParam() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"parentId\":\"\"}");
        param.put("parentId","2008078900000002");
        Object o = Ajax.post(driver,queryBrandByParam,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryMerchantBrandByMerchantId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"parentId\":\"\",\"firstCategoryId\":\"\"}");
        param.put("parentId","1878081302000050");
        param.put("firstCategoryId","2008078900000002");
        Object o = Ajax.post(driver,queryMerchantBrandByMerchantId,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addMerchantBrand() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878081401000002,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"bucklePoint\":0.1,\"categoryCode\":\"1023001\",\"code\":null,\"description\":null,\"fullIdPath\":\"2008078900000002-1878081401000002\",\"fullNamePath\":\"后台类目-水果\",\"isHighlight\":null,\"isLeaves\":1,\"isVisible\":1,\"level\":1,\"listSort\":6,\"merchantId\":\"2029080800000000\",\"name\":\"水果\",\"parentId\":2008078900000002,\"pictureUrl\":null,\"taxRate\":null,\"thirdCode\":null,\"type\":1,\"firstCategoryId\":2008078900000002,\"refId\":-1,\"storeId\":null,\"startItem\":0,\"isParent\":false,\"tId\":\"categoryTree_7\",\"parentTId\":\"categoryTree_1\",\"open\":false,\"zAsync\":true,\"isFirstNode\":false,\"isLastNode\":false,\"isAjaxing\":false,\"checked\":true,\"checkedOld\":false,\"nocheck\":false,\"chkDisabled\":false,\"halfCheck\":false,\"check_Child_State\":-1,\"check_Focus\":false,\"isHover\":false,\"editNameFlag\":false,\"isLoaded\":true}]");
        Object o = Ajax.post(driver,addMerchantBrand,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void deleteMerchantBrandById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\"}");
        param.put("id","1878081602000076");
        Object o = Ajax.post(driver,deleteMerchantBrandById,param);
        System.out.println(JSON.toJSONString(o));
    }
}
