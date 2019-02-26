package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//退款单管理
public class refundManage extends RestfulAutomatedTest {
    //退款单管理查询
    private String queryRefundManageUrl = baseUrl + "/back-finance-web/refundManage/queryRefundManageList.do";

    //退款单管理重置
    private String queryRefundManageListUrl = baseUrl + "/back-finance-web/refundManage/queryRefundManageList.do";

    //退款单管理退款取消
    private String updateRefundDetailUrl = baseUrl + "/back-finance-web/refundManage/updateRefundDetail.do";

    //退款单管理线下退款
    private String updateRefundUrl = baseUrl + "/back-finance-web/refundManage/updateRefundDetail.do";

    //退款单管理查询
    @Test
    public void queryRefundManage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{\"refundSubStatus\":\"\",\"refundType\":\"\",\"refundAccountType\":\"\"},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, queryRefundManageUrl, param);
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

    //退款单管理重置
    @Test
    public void queryRefundManageList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{\"refundSubStatus\":\"\",\"refundType\":\"\",\"refundAccountType\":\"\"},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver, queryRefundManageListUrl, param);
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

    //退款单管理退款取消
    @Test
    public void updateRefundDetail() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886082900000280,\"refundAmountText\":\"6.00\",\"payType\":null,\"auditType\":\"CONFIRM_CANCEL_REFUND_TYPE\"}");
        Object o = Ajax.post(driver, updateRefundDetailUrl, param);
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

    //退款单管理线下退款
    @Test
    public void updateRefund() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083003000244,\"refundAmountText\":\"22.00\",\"payType\":null,\"offlinePaySerial\":\"14524845458744\",\"refundChannel\":\"1\",\"refundSubTime\":\"2018-11-14\",\"auditType\":\"CONFIRM_OFFLINE_REFUND_TYPE\"}");
        Object o = Ajax.post(driver, updateRefundUrl, param);
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