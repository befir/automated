package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//订单发票管理
public class invoiceManage extends RestfulAutomatedTest {

    //电子发票用户资质管理查询
    private String queryUserQualificationUrl = baseUrl+"/back-finance-web/invoiceUserQualificationManage/queryUserQualificationListWithPage.do";

    //电子发票用户资质管理重置
    private String queryUserUrl = baseUrl+"/back-finance-web/invoiceUserQualificationManage/queryUserQualificationListWithPage.do";

    //订单电子发票管理查询
    private String queryInvoiceUrl = baseUrl+"/back-finance-web/invoiceManage/queryInvoiceListWithPage.do";

    //订单电子发票管理重置
    private String queryInvoiceListUrl = baseUrl+"/back-finance-web/invoiceManage/queryInvoiceListWithPage.do";

    //订单电子发票管理删除
    private String removeInvoiceUrl = baseUrl+"/back-finance-web/invoiceManage/removeInvoice.do";

    //订单电子发票管理新增-查询商家
    private String queryMerchantUrl = baseUrl+"/back-finance-web/merchantRead/queryMerchantList.do";

    //订单电子发票管理新增
    private String saveInvoiceUrl = baseUrl+"/back-finance-web/invoiceManage/saveInvoice.do";

    //订单电子发票管理编辑
    private String updateInvoiceUrl = baseUrl+"/back-finance-web/invoiceManage/updateInvoiceAndItem.do";

    //订单电子发票配置查询
    private String queryInvoiceConfigUrl = baseUrl+"/back-finance-web/invoiceConfigManage/queryInvoiceConfigListWithPage.do";

    //订单电子发票配置重置
    private String queryInvoiceConfigListUrl = baseUrl+"/back-finance-web/invoiceConfigManage/queryInvoiceConfigListWithPage.do";

    //订单电子发票配置删除
    private String removeInvoiceConfigUrl = baseUrl+"/back-finance-web/invoiceConfigManage/removeInvoiceConfig.do";

    //订单电子发票配置编辑
    private String updateInvoiceConfigUrl = baseUrl+"/back-finance-web/invoiceConfigManage/updateInvoiceConfig.do";

    //订单电子发票配置新增
    private String saveInvoiceConfigUrl = baseUrl+"/back-finance-web/invoiceConfigManage/saveInvoiceConfig.do";

    //订单电子发票配置新增-查询商家
    private String queryMerchantListUrl = baseUrl+"/back-finance-web/merchantRead/queryMerchantList.do";

    //电子发票用户资质管理查询
    @Test
    public void queryUserQualification() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryUserQualificationUrl,param);
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

    //电子发票用户资质管理重置
    @Test
    public void queryUser() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryUserUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        JSONObject data=actualResult.getJSONObject("data");
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

    //订单电子发票管理查询
    @Test
    public void queryInvoice() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryInvoiceUrl,param);
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

    //订单电子发票管理重置
    @Test
    public void removeInvoice() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,removeInvoiceUrl,param);
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

    //订单电子发票管理删除
    @Test
    public void queryInvoiceList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886082300000132}");
        Object o = Ajax.post(driver,queryInvoiceListUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票管理新增-查询商家
    @Test
    public void queryMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryMerchantUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票管理新增
    @Test
    public void saveInvoice() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"invoiceItemDTOs\":[{\"itemAmount\":\"1.00\",\"itemTaxAmount\":\"1.00\",\"itemThirdMpCode\":\"1\",\"itemMpCode\":\"1\",\"itemName\":\"1\",\"itemUnit\":\"1\",\"itemStandard\":\"1\",\"itemCount\":1,\"itemUnitAmount\":1,\"itemTaxRate\":1}],\"invoiceBillingType\":0,\"invoiceType\":1,\"invoiceFileType\":1,\"invoiceTaxType\":0,\"buyerType\":1,\"merchantCode\":\"CP1001\",\"merchantId\":2029080902003362,\"orderCode\":\"11111111\",\"buyerTaxpayerIdentificationCode\":\"1111111111111111111\",\"buyerName\":\"11111111111\",\"buyerAddress\":\"11111\",\"invoiceWithoutTaxAmount\":\"1.00\",\"invoiceTaxAmount\":\"1.00\",\"invoiceWithtaxAmount\":\"2.00\",\"buyerMobile\":\"17633503433\"}");
        Object o = Ajax.post(driver,saveInvoiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票管理编辑
    @Test
    public void updateInvoice() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886082300000132,\"proInvoiceTradeNo\":null,\"orderCode\":\"11111111\",\"orderCodeInner\":\"1886082300000131\",\"invoiceBillingType\":0,\"invoiceBillingTypeText\":\"蓝票\",\"invoiceStatus\":0,\"invoiceStatusText\":\"待开票\",\"invoiceType\":1,\"invoiceTypeText\":\"增值税普通发票\",\"invoiceFileType\":1,\"invoiceFileTypeText\":\"电子发票\",\"invoiceTaxType\":0,\"invoiceTaxTypeText\":\"普通征税\",\"deductAmount\":null,\"auditType\":1,\"auditTypeText\":\"人工审核\",\"auditStatus\":0,\"auditStatusText\":\"未审核\",\"auditUserid\":null,\"auditUsername\":null,\"sellerTaxpayerIdentificationCode\":\"110109500321655\",\"sellerName\":\"百旺电子测试2\",\"sellerAddress\":\"南山区蛇口、83484949\",\"sellerTel\":\"17633503433\",\"sellerBankAccount\":\"110\",\"sellerBankAddress\":\"南山区蛇口、83484949\",\"buyerType\":1,\"buyerTaxpayerIdentificationCode\":\"1111111111111111111\",\"buyerName\":\"11111111111\",\"buyerAddress\":\"11111\",\"buyerTel\":null,\"buyerBankAddress\":null,\"buyerBankAccount\":null,\"buyerMobile\":\"17633503433\",\"buyerEmail\":null,\"payee\":\"百旺电子测试2\",\"drawer\":\"百旺电子测试2\",\"checker\":\"百旺电子测试2\",\"invoiceWithtaxAmount\":\"22.00\",\"invoiceWithoutTaxAmount\":\"11.00\",\"invoiceTaxAmount\":\"11.00\",\"proInvoiceCode\":null,\"proInvoiceNo\":null,\"invoiceTradeNo\":\"1886082300000131\",\"invoiceCode\":null,\"invoiceNo\":null,\"invoiceCheckCode\":null,\"invoiceStartDate\":null,\"invoiceDate\":null,\"invoiceEndDate\":null,\"createStartDate\":null,\"createEndDate\":null,\"pdfUrl\":null,\"pdfUrlText\":\"下载\",\"qrCodeUrl\":null,\"userId\":null,\"merchantCode\":\"CP1001\",\"merchantId\":2029080902003362,\"isAvailable\":null,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080902000076,\"createUsername\":\"Yami\",\"createUserip\":null,\"createUsermac\":null,\"createTime\":1541052724000,\"createTimeDb\":null,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateUserip\":null,\"updateUsermac\":null,\"updateTime\":null,\"updateTimeDb\":null,\"clientVersionno\":null,\"companyId\":231,\"invoiceItemDTOs\":[{\"id\":1886082300000133,\"invoiceId\":1886082300000132,\"itemType\":0,\"itemTypeText\":\"正常行\",\"itemThirdMpCode\":\"1\",\"itemMpCode\":\"1\",\"itemName\":\"1\",\"itemUnit\":\"1\",\"itemStandard\":\"1\",\"itemCount\":1,\"itemUnitAmount\":11,\"itemAmount\":\"11.00\",\"itemTaxAmount\":\"11.00\",\"itemTaxRate\":1,\"itemTaxRateText\":\"100.00%\",\"userId\":null,\"isAvailable\":null,\"isDeleted\":0,\"versionNo\":null,\"createUserid\":null,\"createUsername\":null,\"createUserip\":null,\"createUsermac\":null,\"createTime\":null,\"createTimeDb\":null,\"serverIp\":null,\"updateUserid\":null,\"updateUsername\":null,\"updateUserip\":null,\"updateUsermac\":null,\"updateTime\":null,\"updateTimeDb\":null,\"clientVersionno\":null,\"companyId\":231}],\"interfaceCode\":null}");
        Object o = Ajax.post(driver,updateInvoiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票配置查询
    @Test
    public void queryInvoiceConfig() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryInvoiceConfigUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票配置重置
    @Test
    public void queryInvoiceConfigList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryInvoiceConfigListUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票配置删除
    @Test
    public void removeInvoiceConfig() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,removeInvoiceConfigUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票配置编辑
    @Test
    public void updateInvoiceConfig() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886080903000212,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"merchantAddress\":\"南山区蛇口、83484949\",\"merchantBankAccount\":\"111\",\"merchantBankAddress\":\"南山区蛇口、83484949\",\"merchantTaxpayerIdentificationCode\":\"110109500321655\",\"merchantTaxpayerName\":\"百旺电子测试2\",\"merchantTaxpayerTel\":\"17633503433\",\"merchantChecker\":\"百旺电子测试2\",\"merchantDrawer\":\"百旺电子测试2\",\"merchantPayee\":\"百旺电子测试2\",\"channelCode\":\"baiWang\",\"channelName\":\"百旺\",\"iconUrl\":null,\"status\":1,\"statusText\":\"启用\",\"remark\":null,\"companyId\":231,\"companyName\":null,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":null,\"createUsername\":null,\"createUserip\":null,\"createUsermac\":null,\"createTime\":1539849684000,\"updateUserid\":1886080902000076,\"updateUsername\":\"Yami\",\"updateTime\":1539849836000,\"invoiceMerchantChannelConfigs\":[{\"id\":1886080903000213,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"appid\",\"paramType\":1,\"paramValue\":\"6d29f136114544bcc73edcce960c430231183cc192c433e2b9ebcad56e8ceb08\"},{\"id\":1886080903000214,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"requestUrl\",\"paramType\":1,\"paramValue\":\"https://dev.fapiao.com:18943/fpt-dsqz/invoice\"},{\"id\":1886080903000215,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"KEY_STORE_PASS\",\"paramType\":1,\"paramValue\":\"123456\"},{\"id\":1886080903000216,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"TRUST_STORE_PASS\",\"paramType\":1,\"paramValue\":\"123456\"},{\"id\":1886080903000217,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"contentPassword\",\"paramType\":1,\"paramValue\":\"5EE6C2C11DD421F2\"},{\"id\":1886080903000218,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"TRUST_STORE_FILE\",\"paramType\":2,\"paramValue2\":\"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\"},{\"id\":1886080903000219,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"KEY_STORE_FILE\",\"paramType\":2,\"paramValue2\":\"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\"}]}");
        Object o = Ajax.post(driver,updateInvoiceConfigUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票配置新增
    @Test
    public void saveInvoiceConfig() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886080903000212,\"merchantId\":2029080902003362,\"merchantCode\":\"SJX2018101801\",\"merchantName\":\"屈臣氏自营商家\",\"merchantAddress\":\"南山区蛇口、83484949\",\"merchantBankAccount\":\"111\",\"merchantBankAddress\":\"南山区蛇口、83484949\",\"merchantTaxpayerIdentificationCode\":\"110109500321655\",\"merchantTaxpayerName\":\"百旺电子测试2\",\"merchantTaxpayerTel\":\"17633503433\",\"merchantChecker\":\"百旺电子测试2\",\"merchantDrawer\":\"百旺电子测试2\",\"merchantPayee\":\"百旺电子测试2\",\"channelCode\":\"baiWang\",\"channelName\":\"百旺\",\"iconUrl\":null,\"status\":1,\"statusText\":\"启用\",\"remark\":null,\"companyId\":231,\"companyName\":null,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":null,\"createUsername\":null,\"createUserip\":null,\"createUsermac\":null,\"createTime\":1539849684000,\"updateUserid\":1886080902000076,\"updateUsername\":\"Yami\",\"updateTime\":1539849836000,\"invoiceMerchantChannelConfigs\":[{\"id\":188604480903000213,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"appid\",\"paramType\":1,\"paramValue\":\"6d29f136114544bcc73edcce960c430231183cc192c433e2b9ebcad56e8ceb08\"},{\"id\":18860980903000214,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"requestUrl\",\"paramType\":1,\"paramValue\":\"https://dev.fapiao.com:18943/fpt-dsqz/invoice\"},{\"id\":18860809803000215,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"KEY_STORE_PASS\",\"paramType\":1,\"paramValue\":\"123456\"},{\"id\":188605580903000216,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"TRUST_STORE_PASS\",\"paramType\":1,\"paramValue\":\"123456\"},{\"id\":18860805903000217,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"contentPassword\",\"paramType\":1,\"paramValue\":\"5EE6C2C11DD421F2\"},{\"id\":1886080903000218,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"TRUST_STORE_FILE\",\"paramType\":2,\"paramValue2\":\"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\"},{\"id\":1886080903000219,\"channelCode\":\"baiWang\",\"merchantCode\":\"CP1001\",\"paramKey\":\"KEY_STORE_FILE\",\"paramType\":2,\"paramValue2\":\"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\"}]}");
        Object o = Ajax.post(driver,saveInvoiceConfigUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //订单电子发票配置新增-查询商家
    @Test
    public void queryMerchantList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryMerchantListUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
