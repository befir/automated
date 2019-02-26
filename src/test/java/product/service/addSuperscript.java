package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;


public class addSuperscript extends RestfulAutomatedTest {

    private String saveSuperscriptWithTxUrl = baseUrl + "/back-product-web2/back/superscript/saveSuperscriptWithTx.do";
    private String updateSuperscriptWithTxUrl = baseUrl + "/back-product-web2/back/superscript/updateSuperscriptWithTx.do";
    private String saveAggreationMpWithTxUrl = baseUrl + "/back-product-web2/back/superscript/saveAggreationMpWithTx.do";
    private String updateMpSuperscriptTimeUrl = baseUrl + "/back-product-web2/back/superscript/updateMpSuperscriptTime.do";
    private String getAggregationMpByParamUrl = baseUrl + "/back-product-web2/back/superscript/getAggregationMpByParam.do";
    private String batchDeleteAggregationMpUrl = baseUrl + "/back-product-web2/back/superscript/batchDeleteAggregationMp.do";
    private String getAggregationMpUrl = baseUrl + "/back-product-web2/back/superscript/getAggregationMpByParam.do";


    @Test
//    角标新增
    public void saveSuperscriptWithTx() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"name\": \"\",\"code\": \"\",\"displayType\": \"\"}");
        param.put("name","海抢");
        param.put("code",1234);
        param.put("displayType","0");
        Object o = Ajax.post(driver,saveSuperscriptWithTxUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    角标上传图片
    public void updateSuperscriptWithTx() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"name\": \"\",\"code\": \"\",\"displayType\": \"\"}");
        param.put("name","海抢");
        param.put("code",1234);
        param.put("displayType","0");
        param.put("iconUrl", "https://cdn.oudianyun.com/trunk/back-product/1541489246118_86.90715022351006_34d6435d-3c5c-4357-9bb2-bbfde186ab44.jpeg");
        Object o = Ajax.post(driver,updateSuperscriptWithTxUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    角标添加商品
    public void saveAggreationMpWithTx() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"superscriptId\":1878082801000148,\"merchantProductId\":1878081602001095}");
        Object o = Ajax.post(driver,saveAggreationMpWithTxUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    商品角标状态
    public void updateMpSuperscriptTime() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"validFrom\":\"2018-11-06 15:37:01\",\"validTo\":\"2021-11-10 15:37:01\",\"id\":1878082801000171}");
        Object o = Ajax.post(driver,updateMpSuperscriptTimeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
//    查询商品角标
    public void getAggregationMpByParam() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"superscriptId\":1878082801000148,\"dateStatus\":\"1\"}");
        Object o = Ajax.post(driver,getAggregationMpByParamUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
//    删除商品角标
    public void batchDeleteAggregationMp() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":0,\"id\":1878082801000171,\"isAvailable\":null,\"createUsername\":null,\"createTime\":null,\"updateUsername\":null,\"updateTime\":null,\"authStoreIds\":null,\"authMerchantIds\":null,\"authInventoryIds\":null,\"mpIds\":null,\"sourceType\":null,\"merchantProductId\":null,\"name\":null,\"applyType\":null,\"displayType\":null,\"iconUrl\":null,\"description\":null,\"superscriptId\":null,\"itemIds\":null,\"itemId\":null,\"merchantId\":3,\"storeId\":6,\"channelCode\":\"110001\",\"validFrom\":\"2018-11-06 15:37:01\",\"validTo\":\"2021-11-10 15:37:01\",\"priority\":null,\"chineseName\":\"TS\",\"code\":\"1878081602001079\",\"dateStatus\":1,\"startItem\":0}");
        Object o = Ajax.post(driver,batchDeleteAggregationMpUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
//    查询新增角标
    public void getAggregationMp() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"superscriptId\":1878082801000148}");
        Object o = Ajax.post(driver,getAggregationMpUrl,param);
        System.out.println(JSON.toJSONString(o));
    }








}
