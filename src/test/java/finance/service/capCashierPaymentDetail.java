package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//退款单管理
public class capCashierPaymentDetail extends RestfulAutomatedTest {
    //门店缴款明细查询
    private String queryCapCashierPaymentDetailUrl = baseUrl + "/back-finance-web/capCashierPayment/queryCapCashierPaymentDetailList.do";

    //门店缴款明细重置
    private String queryCapCashierPaymentDetailListUrl = baseUrl + "/back-finance-web/capCashierPayment/queryCapCashierPaymentDetailList.do";

    //门店缴款明细-查询门店
    private String queryStoreUrl = baseUrl + "/back-finance-web/merchantStore/queryStoreList.do";

    //门店缴款汇总查询
    private String totalCapCashierPaymentDetailUrl = baseUrl + "/back-finance-web/capCashierPayment/totalCapCashierPaymentDetailList.do.do";

    //门店缴款汇总重置
    private String totalCapCashierPaymentDetailListUrl = baseUrl + "/back-finance-web/capCashierPayment/totalCapCashierPaymentDetailList.do.do";

    //退款单管理线下退款
    private String updateRefundUrl = baseUrl + "/back-finance-web/refundManage/updateRefundDetail.do";

    //门店缴款明细查询
    @Test
    public void queryRefundManage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{}}");
        Object o = Ajax.post(driver, queryCapCashierPaymentDetailUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//        data.remove("trace");
        JSONObject expectedData = JSON.parseObject("{\"listObj\":[{\"createTime\":1540803370000,\"paymentAmt\":200,\"storeName\":\"屈臣氏店铺20181026195032\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803370000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000087\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000026\",\"createUsername\":\"superadmin\",\"id\":1886082005000042,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181026195032\"},{\"createTime\":1540803333000,\"paymentAmt\":200,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803333000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000086\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000025\",\"createUsername\":\"superadmin\",\"id\":1886082005000037,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803323000,\"paymentAmt\":20,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803323000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000085\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000024\",\"createUsername\":\"superadmin\",\"id\":1886082005000034,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803298000,\"paymentAmt\":20,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803298000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000083\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000021\",\"createUsername\":\"superadmin\",\"id\":1886082005000031,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803245000,\"paymentAmt\":20,\"storeName\":\"金蝶软件园89w87\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803245000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000081\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000020\",\"createUsername\":\"superadmin\",\"id\":1886082005000024,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"9820181028163854\"},{\"createTime\":1540803081000,\"paymentAmt\":20,\"storeName\":\"文心阁店铺20181029154333\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803081000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000082\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000049\",\"createUsername\":\"superadmin\",\"id\":1886082005000021,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181029154333\"}],\"total\":6}");
//        expectedData.remove("trace");
        Assert.assertEquals(data, expectedData);
        //    System.out.println(JSON.toJSONString(o));
    }

    //门店缴款明细重置
    @Test
    public void queryCapCashierPaymentDetailList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{}}");
        Object o = Ajax.post(driver,queryCapCashierPaymentDetailListUrl , param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject("{\"listObj\":[{\"createTime\":1540803370000,\"paymentAmt\":200,\"storeName\":\"屈臣氏店铺20181026195032\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803370000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000087\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000026\",\"createUsername\":\"superadmin\",\"id\":1886082005000042,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181026195032\"},{\"createTime\":1540803333000,\"paymentAmt\":200,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803333000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000086\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000025\",\"createUsername\":\"superadmin\",\"id\":1886082005000037,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803323000,\"paymentAmt\":20,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803323000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000085\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000024\",\"createUsername\":\"superadmin\",\"id\":1886082005000034,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803298000,\"paymentAmt\":20,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803298000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000083\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000021\",\"createUsername\":\"superadmin\",\"id\":1886082005000031,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803245000,\"paymentAmt\":20,\"storeName\":\"金蝶软件园89w87\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803245000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000081\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000020\",\"createUsername\":\"superadmin\",\"id\":1886082005000024,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"9820181028163854\"},{\"createTime\":1540803081000,\"paymentAmt\":20,\"storeName\":\"文心阁店铺20181029154333\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803081000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000082\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000049\",\"createUsername\":\"superadmin\",\"id\":1886082005000021,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181029154333\"}],\"total\":6}");
        Assert.assertEquals(data, expectedData);
        //    System.out.println(JSON.toJSONString(o));
    }

    //门店缴款明细-查询门店
    @Test
    public void queryStore() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{}}");
        Object o = Ajax.post(driver, queryStoreUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "{\"listObj\":[{\"storeName\":\"荣耀线上旗舰店\",\"merchantName\":\"武汉光谷K11国际中心\",\"merchantId\":2029084400000000,\"storeId\":2029084400003355,\"storeCode\":\"wuhan002\"},{\"storeName\":\"武汉荣耀旗舰店\",\"merchantName\":\"武汉光谷K11国际中心\",\"merchantId\":2029084400000000,\"storeId\":2029084400003350,\"storeCode\":\"wuhan001\"},{\"storeName\":\"b2cXIANSHANG\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084300000005,\"storeCode\":\"7801111\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000059\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000059,\"storeCode\":\"9820181120135009\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000051\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000051,\"storeCode\":\"9820181120134650\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000043\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000043,\"storeCode\":\"9820181120104130\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000035\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000035,\"storeCode\":\"9820181120104000\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000027\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000027,\"storeCode\":\"9820181120100324\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000019\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000019,\"storeCode\":\"9820181120100258\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000011\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000011,\"storeCode\":\"9820181120094125\",\"detailAddress\":\"金蝶软件园36号\"}],\"total\":115}");
        Assert.assertEquals(data, expectedData);
        //    System.out.println(JSON.toJSONString(o));
    }

    //门店缴款汇总查询
    @Test
    public void totalCapCashierPaymentDetail() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{}}");
        Object o = Ajax.post(driver, totalCapCashierPaymentDetailUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "{\"listObj\":[{\"createTime\":1540803370000,\"paymentAmt\":200,\"storeName\":\"屈臣氏店铺20181026195032\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803370000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000087\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000026\",\"createUsername\":\"superadmin\",\"id\":1886082005000042,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181026195032\"},{\"createTime\":1540803298000,\"paymentAmt\":240,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803298000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000083\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000021\",\"createUsername\":\"superadmin\",\"id\":1886082005000031,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803245000,\"paymentAmt\":20,\"storeName\":\"金蝶软件园89w87\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803245000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000081\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000020\",\"createUsername\":\"superadmin\",\"id\":1886082005000024,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"9820181028163854\"},{\"createTime\":1540803081000,\"paymentAmt\":20,\"storeName\":\"文心阁店铺20181029154333\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803081000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000082\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000049\",\"createUsername\":\"superadmin\",\"id\":1886082005000021,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181029154333\"}],\"total\":4}");
        Assert.assertEquals(data, expectedData);
        //    System.out.println(JSON.toJSONString(o));
    }


    //门店缴款汇总重置
    @Test
    public void totalCapCashierPaymentDetailList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{}}");
        Object o = Ajax.post(driver, totalCapCashierPaymentDetailListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "{\"listObj\":[{\"createTime\":1540803370000,\"paymentAmt\":200,\"storeName\":\"屈臣氏店铺20181026195032\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803370000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000087\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000026\",\"createUsername\":\"superadmin\",\"id\":1886082005000042,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181026195032\"},{\"createTime\":1540803298000,\"paymentAmt\":240,\"storeName\":\"8888888888888\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803298000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000083\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000021\",\"createUsername\":\"superadmin\",\"id\":1886082005000031,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"8888\"},{\"createTime\":1540803245000,\"paymentAmt\":20,\"storeName\":\"金蝶软件园89w87\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803245000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000081\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000020\",\"createUsername\":\"superadmin\",\"id\":1886082005000024,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"9820181028163854\"},{\"createTime\":1540803081000,\"paymentAmt\":20,\"storeName\":\"文心阁店铺20181029154333\",\"createUserid\":18101517160196,\"paymentMethodCode\":\"WeiXin\",\"paymentTime\":1540803081000,\"serverIp\":\"127.0.0.1\",\"posTerminalNo\":\"1000011\",\"cashierBatchNo\":\"10000082\",\"paymentMethodName\":\"weixin\",\"isDeleted\":0,\"cashierName\":\"收银员\",\"paymentCode\":\"10000000000049\",\"createUsername\":\"superadmin\",\"id\":1886082005000021,\"versionNo\":0,\"companyId\":231,\"storeCode\":\"20181029154333\"}],\"total\":4}");
        Assert.assertEquals(data, expectedData);
        //    System.out.println(JSON.toJSONString(o));
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