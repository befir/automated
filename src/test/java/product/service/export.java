package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class export extends RestfulAutomatedTest {
    private String asyncEventUrl = baseUrl + "/back-product-web2/back/asyncTask/asyncEvent.do";
    private String asyncEvent1Url = baseUrl + "/back-product-web2/back/asyncTask/asyncEvent.do";
    private String asyncEvent2Url = baseUrl + "/back-product-web2/back/asyncTask/asyncEvent.do";
    private String queryStoreProductByPageUrl = baseUrl + "/back-product-web2/back/storeProduct/queryStoreProductByPage.do";
    private String asyncEvent3Url = baseUrl + "/back-product-web2/back/asyncTask/asyncEvent.do";



    @Test
//    商家商品导出
    public void asyncEvent() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"templateCode\":\"mpExport\",\"jsonTxt\":\"{\\\"currentPage\\\":1,\\\"itemsPerPage\\\":10,\\\"sourceType\\\":1,\\\"recycleStatus\\\":0,\\\"typeOfProducts\\\":[0,3,4]}\"}");
        Object o = Ajax.post(driver,asyncEventUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    品牌导出
    public void asyncEvent1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"templateCode\":\"brandExport\",\"jsonTxt\":\"{\\\"currentPage\\\":1,\\\"itemsPerPage\\\":10}\"}");
        Object o = Ajax.post(driver,asyncEvent1Url,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    产品导出
    public void asyncEvent2() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"templateCode\":\"productManageExport\",\"jsonTxt\":\"{\\\"currentPage\\\":1,\\\"itemsPerPage\\\":10}\"}");
        Object o = Ajax.post(driver,asyncEvent2Url,param);
        System.out.println(JSON.toJSONString(o));
    }



    @Test
//    库存组织商品管理查询
    public void queryStoreProductByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"fuzzyProductTitle\":\"大水果\"}");
        Object o = Ajax.post(driver,queryStoreProductByPageUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    库存组织商品管理导出
    public void asyncEvent3() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"templateCode\":\"purchaseSellStockManagementManageExport\",\"jsonTxt\":\"{\\\"currentPage\\\":1,\\\"itemsPerPage\\\":10,\\\"fuzzyProductTitle\\\":\\\"大水果\\\"}\"}");
        Object o = Ajax.post(driver,asyncEvent3Url,param);
        System.out.println(JSON.toJSONString(o));
    }



}
