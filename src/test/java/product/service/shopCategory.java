package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class shopCategory extends RestfulAutomatedTest {
    private String listStoreCategoryUrl = baseUrl + "/back-product-web2/back/category/listStoreCategory.do";
    private String queryStoreOrgPageByAuthUrl = baseUrl + "/back-merchant-web/api/store/queryStoreOrgPageByAuth.do";
    private String addCategoryRootUrl = baseUrl + "/back-product-web2/back/category/addCategoryRoot.do";
    private String deleteCategoryRootUrl = baseUrl + "/back-product-web2/back/category/deleteCategoryRoot.do";
    private String getCategoryDetailUrl = baseUrl + "/back-product-web2/back/category/getCategoryDetail.do";
    private String queryCategoryListByParentUrl = baseUrl + "/back-product-web2/back/category/queryCategoryListByParent.do";
    private String addCategoryChildUrl = baseUrl + "/back-product-web2/back/category/addCategoryChild.do";
    private String updateCategoryRootUrl = baseUrl + "/back-product-web2/back/category/updateCategoryRoot.do";
    private String listBrandByPageUrl = baseUrl + "/back-product-web2/back/brand/listBrandByPage.do";
    private String listQueryAggregationMerchantProductUrl = baseUrl + "/back-product-web2/back/category/listQueryAggregationMerchantProduct.do";
    private String batchDelAggregationProductUrl = baseUrl + "/back-product-web2/back/category/batchDelAggregationProduct.do";
    private String updateCategoryUrl = baseUrl + "/back-product-web2/back/category/updateCategory.do";


    @Test
    //查询店铺类目列表
    public void listStoreCategory() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listStoreCategoryUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //新增请求店铺
    public void queryStoreOrgPageByAuth() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, queryStoreOrgPageByAuthUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //新增店铺类目
    public void addCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"storeInfo\":{\"storeId\":2029080801000007,\"storeName\":\"桂源铺BBC\",\"storeType\":null,\"storeTypeName\":null,\"storeCode\":\"1017001\",\"isDefault\":null,\"merchantId\":2029080800003446,\"merchantName\":\"桂源铺\",\"merchantCode\":\"spx101701\",\"auditStatus\":null,\"provinceCode\":null,\"provinceName\":null,\"cityCode\":null,\"cityName\":null,\"regionCode\":null,\"regionName\":null,\"detailAddress\":null,\"longitude\":null,\"latitude\":null,\"logoUrl\":null,\"businessLicenseUrl\":null,\"channelCodesStr\":\"110001\",\"channelInfoList\":[{\"channelCode\":\"110001\",\"channelName\":\"欧电云自建BBC\",\"channelMode\":\"BBC\"}],\"contactsMobile\":null,\"storeOnlineType\":\"0\",\"distributionItemsOutDTOList\":null},\"merchantId\":2029080800003446,\"storeId\":2029080801000007,\"addType\":1,\"name\":\"桂源铺BBC类目\",\"type\":6,\"categoryCode\":\"jnwxtrd8h7p\"}");
        Object o = Ajax.post(driver, addCategoryRootUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //删除店铺类目
    public void deleteCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1878082206000000}");
        Object o = Ajax.post(driver, deleteCategoryRootUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //获取类目详情
    public void getCategoryDetail() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"1878082206000002\"}");
        Object o = Ajax.post(driver, getCategoryDetailUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //查询类目
    public void queryCategoryListByParent() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"1878082206000002\"}");
        Object o = Ajax.post(driver, queryCategoryListByParentUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //新增子类目
    public void addCategoryChild() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"parentId\":1878082206000002,\"name\":'',\"categoryCode\":'',\"isVisible\":1}");
        param.put("name","Gyp"+dateFormat.format(new Date()));
        param.put("categoryCode","Store"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver, addCategoryChildUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    //编辑父级类目编码
    public void updateCategoryRoot() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1878082206000002,\"name\":\"桂源铺BBC类目\",\"categoryCode\":'',\"pictureUrl\":null,\"isVisible\":1,\"thirdCode\":null}");
        param.put("categoryCode","Store"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver, updateCategoryRootUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    private String saveAggreationMpUrl = baseUrl + "/back-product-web2/back/category/saveAggreationMp.do";
//11.01
    @Test
    //保存聚合商品
    public void saveAggreationMp() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\"categoryTreeNodeRelationId\":1878082206000006,\"productId\":1878082101000107,\"type\":0}]");
        Object o = Ajax.post(driver, saveAggreationMpUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    //获取类目详情
    public void listBrandByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, listBrandByPageUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    //根据品牌查询聚合商品
    public void listQueryAggregationMerchantProduct() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"brandName\":\"糖果秀\",\"brandId\":1878082101000509,\"currentPage\":1,\"itemsPerPage\":10,\"categoryIds\":[],\"categoryTreeNodeRelationId\":1878082206000006}");
        Object o = Ajax.post(driver, listQueryAggregationMerchantProductUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    //批量删除聚合商品
    public void batchDelAggregationProduct() throws InterruptedException {
        JSONArray param = JSON.parseArray("[1878082301000605]");
        Object o = Ajax.post(driver, batchDelAggregationProductUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    //根据品牌查询聚合商品
    public void updateCategory() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"id\": 1878082206000006,\n" +
                "\t\"name\": \"水果类目\",\n" +
                "\t\"categoryCode\": \"1201\",\n" +
                "\t\"pictureUrl\": \"https://cdn.oudianyun.com/trunk/back-product/1541064536338_86.43886124095307_5eea9ac6-87b8-41fe-9b92-286ad86748dd.jpg\",\n" +
                "\t\"isVisible\": \"1\",\n" +
                "\t\"thirdCode\": null\n" +
                "}");
        Object o = Ajax.post(driver, updateCategoryUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

}
