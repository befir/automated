package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//应收管理
public class offinePaymentVoucher extends RestfulAutomatedTest {
    //线下支付凭证管理查询
    private String queryArOffineOrderUrl = baseUrl + "/back-finance-web/arOffinePaymentVoucher/queryArOffineOrderList.do";

    //线下支付凭证管理重置
    private String queryArOffineOrderListUrl = baseUrl + "/back-finance-web/arOffinePaymentVoucher/queryArOffineOrderList.do";

    //线下支付凭证管理查询
    @Test
    public void queryArOffineOrder() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"merchantName\":\"屈臣氏\",\"merchantId\":2076084100000011}}");
        Object o = Ajax.post(driver, queryArOffineOrderUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }

    //线下支付凭证管理重置
    @Test
    public void queryArOffineOrderList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"merchantName\":\"屈臣氏\",\"merchantId\":2076084100000011}}");
        Object o = Ajax.post(driver, queryArOffineOrderListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        JSONArray listObj = data.getJSONArray("listObj");
        //取第一个值组的值
//        String merchantName= listObj.getJSONObject(0).getString("merchantName");
//        String merchantCode= listObj.getJSONObject(0).getString("merchantCode");
        //断言merchantCode，定义一个常量并赋值，预期结果
//        String expectedData ="桂源铺";
//        String expectedData1 ="spx101701";
        String expectedData2= "0";
//        Assert.assertEquals(merchantName,expectedData);
//        Assert.assertEquals(merchantCode,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
//        System.out.println(merchantCode);
//        System.out.println(merchantName);
        System.out.println(JSON.toJSONString(o));
    }
}