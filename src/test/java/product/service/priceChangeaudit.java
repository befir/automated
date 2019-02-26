package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class priceChangeaudit extends RestfulAutomatedTest {
    //商家商品价格变更审核查询
    private String listMpAuditUrl = baseUrl + "/back-product-web2/back/mpPriceAudit/listMpAudit.do";
    //店铺商品价格变更审核查询
    private String listStoreMpAuditUrl = baseUrl + "/back-product-web2/back/mpPriceAudit/listMpAudit.do";
    //商家商品审核通过
    private String batchUpdateAuditStatusWithTxUrl = baseUrl + "/back-product-web2/back/mpPriceAudit/listMpAudit.do";
    //商家商品审核拒绝
    private String batchUpdateAuditStatusWithTx1Url = baseUrl + "/back-product-web2/back/mpPriceAudit/batchUpdateAuditStatusWithTx.do";
    //店铺商品审核通过
    private String batchUpdateStoreStatusWithTxUrl = baseUrl + "/back-product-web2/back/mpPriceAudit/batchUpdateStoreStatusWithTx.do";
    //店铺商品审核拒绝
    private String batchUpdateStoreStatusWithTx2Url = baseUrl + "/back-product-web2/back/mpPriceAudit/batchUpdateStoreStatusWithTx.do";


    @Test
    public void listMpAudit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listMpAuditUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String userName= listObj.getJSONObject(0).getString("userName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="Gyp";
        String expectedData1 ="2029080800003446";
        String expectedData2= "0";
        Assert.assertEquals(userName,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(userName);
    }
    @Test
    public void listStoreMpAudit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listStoreMpAuditUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String userName= listObj.getJSONObject(0).getString("userName");
        String merchantId= listObj.getJSONObject(0).getString("merchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="Gyp";
        String expectedData1 ="2029080800003446";
        String expectedData2= "0";
        Assert.assertEquals(userName,expectedData);
        Assert.assertEquals(merchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(merchantId);
        System.out.println(userName);
    }

    @Test
    public void batchUpdateAuditStatusWithTx() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"ids\": [1878082104000041],\n" +
                "\t\"status\": \"1\"\n" +
                "}");
        Object o = Ajax.post(driver, batchUpdateAuditStatusWithTxUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("{\"listObj\":[],\"total\":10}");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
    public void batchUpdateAuditStatusWithTx1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"ids\": [1878082101000489],\n" +
                "\t\"status\": \"2\",\n" +
                "\t\"refusalCause\": \"贵的可怕\"\n" +
                "}");
        Object o = Ajax.post(driver, batchUpdateAuditStatusWithTx1Url, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
    public void batchUpdateStoreStatusWithTx() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"ids\": [1878082101000490],\n" +
                "\t\"status\": \"1\"\n" +
                "}");
        Object o = Ajax.post(driver, batchUpdateStoreStatusWithTxUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
    public void batchUpdateStoreStatusWithTx2() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"ids\": [1878082101000451],\n" +
                "\t\"status\": \"2\",\n" +
                "\t\"refusalCause\": \"简直可怕\"\n" +
                "}");
        Object o = Ajax.post(driver, batchUpdateStoreStatusWithTx2Url, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

}
