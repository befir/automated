package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class BrandManage extends RestfulAutomatedTest {

    //查询商家已添加的商品品牌
    private String queryMerchantBrand = baseUrl+"/back-product-web2/back/merchantBrand/listMerchantBrand.do";
    //获取商品品牌信息
    private String queryBrandByParam = baseUrl+"/back-product-web2/back/brand/listBrandByParam.do";
    //根据ID查询品牌是否存在和已添加
    private String queryMerchantBrandByMerchantId = baseUrl+"/back-product-web2/back/merchantBrand/queryMerchantBrandByMerchantId.do";
    //根据ID查询品牌信息
    private String viewBrandInfoById = baseUrl+"/back-product-web2/back/brand/viewBrandInfoById.do";
    //添加商家商品品牌
    private String addMerchantBrand = baseUrl+"/back-product-web2/back/merchantBrand/saveMerchantBrand.do";
    //根据ID获取商家已添加的商品品牌
    private String getMerchantBrandById = baseUrl+"/back-product-web2/back/merchantBrand/getMerchantBrandById.do";
    //修改商家已添加的商品品牌
    private String editMerchantBrandById = baseUrl+"/back-product-web2/back/merchantBrand/updateMerchantBrandById.do";
    //删除商家已添加的商品品牌
    private String deleteMerchantBrandById = baseUrl+"/back-product-web2/back/merchantBrand/deleteMerchantBrandById.do";
    @Test
    public void queryMerchantBrand() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"merchantId\":\"\"}");
        param.put("merchantId","2029080800000000");
        Object o = Ajax.post(driver,queryMerchantBrand,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryBrandByParam() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryBrandByParam,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryMerchantBrandByMerchantId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantId\":\"\",\"brandId\":\"\"}");
        param.put("merchantId","2029080800000000");
        param.put("brandId","1878080900000399");
        Object o = Ajax.post(driver,queryMerchantBrandByMerchantId,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void viewBrandInfoById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\"}");
        param.put("id","1878080900000399");
        Object o = Ajax.post(driver,viewBrandInfoById,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addMerchantBrand() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"brandId\":\"\",\"validityStart\":\"\",\"validityEnd\":\"\",\"seniorityName\":\"\",\"seniorityUrl\":\"\",\"merchantId\":\"\",\"status\":1}");
        param.put("merchantId","2029080800000000");
        param.put("brandId","1878080900000399");
        param.put("seniorityName","百易格"+dateFormat.format(new Date()));
        param.put("validityStart","2018-11-01");
        param.put("validityEnd","2019-01-31");
        param.put("seniorityUrl","https://cdn.oudianyun.com/trunk/back-product/1541640874131_60.06855929504099_2681abc1-79b2-407b-b1ae-03f12fccdc8a.jpg");
        Object o = Ajax.post(driver,addMerchantBrand,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getMerchantBrandById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\"}");
        param.put("id","1878080800000053");
         Object o = Ajax.post(driver,getMerchantBrandById,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editMerchantBrandById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":\"\",\"isAvailable\":null,\"createUsername\":null,\"createTime\":1539740492000,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"status\":2,\"seniorityName\":\"名称1\",\"validityStart\":\"2018-10-17\",\"validityEnd\":\"2023-10-26\",\"seniorityUrl\":\"https://cdn.oudianyun.com/trunk/back-product/1539740624656_50.090233973696776_e61acc8c-d80e-4f6e-a353-0fa858e5078a.jpg\",\"seniorityUrl2\":\"https://cdn.oudianyun.com/trunk/back-product/1539740628897_17.200369514710957_2eaba508-db91-4e51-9b8a-9d5bca569a4e.jpg\",\"seniorityUrl3\":\"https://cdn.oudianyun.com/trunk/back-product/1539740629109_27.053647266331627_17034bf0-577a-427a-9d46-b866a3d79027.jpg\",\"seniorityName2\":null,\"validityStart2\":\"2018-10-17\",\"validityEnd2\":\"2018-10-17\",\"seniorityUrl4\":null,\"seniorityUrl5\":null,\"seniorityUrl6\":null,\"seniorityName3\":null,\"validityStart3\":\"2018-10-17\",\"validityEnd3\":\"2018-10-17\",\"seniorityUrl7\":null,\"seniorityUrl8\":null,\"seniorityUrl9\":null,\"remark\":null,\"merchantId\":\"2029080800000000\",\"brandId\":1878080800000003,\"brandName\":\"可口可乐\",\"alias\":\"饮料\",\"englishName\":\"fdhg\",\"logUrl\":\"https://cdn.oudianyun.com/trunk/back-product/1539740192331_1.0337389615176162_01b57e34-f996-41fa-8570-bb5483cc3ce2.jpg\",\"owner\":\"大风歌等\",\"merchantName\":null,\"merchantCode\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"ids\":null,\"startItem\":0}");
        param.put("id","1878080800000053");
        Object o = Ajax.post(driver,editMerchantBrandById,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void deleteMerchantBrandById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\"}");
        param.put("id","1878083000000001");
        Object o = Ajax.post(driver,deleteMerchantBrandById,param);
        System.out.println(JSON.toJSONString(o));
    }
}
