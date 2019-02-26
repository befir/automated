package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//供应商费用管理
public class Fee extends RestfulAutomatedTest {
    //供应商费用单查询
    private String queryApSupplierFeeBillUrl = baseUrl+"/back-finance-web/apFeeBill/queryApSupplierFeeBillList.do";

    //供应商费用单审核
    private String SupplierFeeBillUrl = baseUrl+"/back-finance-web/apFeeBill/auditApSupplierFeeBill.do";

    //供应商费用单重置
    private String queryApSupplierFeeUrl = baseUrl+"/back-finance-web/apFeeBill/queryApSupplierFeeBillList.do";

    //供应商费用单删除
    private String deleteApSupplierFeeUrl = baseUrl+"/back-finance-web/apFeeBill/deleteApSupplierFeeBill.do";

    //新增费用单-查询门店
    private String queryStore = baseUrl+"/back-finance-web/merchantStore/queryStoreList.do";

    //新增费用单-查询供应商
    private String querySupplier = baseUrl+"/back-finance-web/supplier/querySupplierList.do";

    //新增费用单
    private String saveFee = baseUrl+"/back-finance-web/apFeeBill/saveFeeBill.do";

    //新增费用单-查询费用类型
    private String selectFeeType = baseUrl+"/back-finance-web/feeType/selectFeeTypePage.do";

    //编辑费用单
    private String updateApSupplierFeeUrl = baseUrl+"/back-finance-web/apFeeBill/updateApSupplierFeeBill.do";

    //供应商费用明细重置
    private String SupplierFeeBillItemUrl = baseUrl+"/back-finance-web/apFeeBill/queryApSupplierFeeBillItemList.do";

    //供应商费用明细查询
    private String SupplierFeeUrl = baseUrl+"/back-finance-web/apFeeBill/queryApSupplierFeeBillItemList.do";

    //费用类型管理新增
    private String saveFeeTypeUrl = baseUrl+"/back-finance-web/feeType/saveFeeType.do";

    //费用类型新增
    private String saveFeeUrl = baseUrl+"/back-finance-web/feeType/saveFeeType.do";

    //费用类型管理查看
    private String selectFeeTypeUrl = baseUrl+"/back-finance-web/feeType/selectFeeType.do";

    //费用类型删除
    private String removeFeeUrl = baseUrl+"/back-finance-web/feeType/removeFeeType.do";

    //费用类型管理删除
    private String removeFeeTypeUrl = baseUrl+"/back-finance-web/feeType/removeFeeType.do";

    //供应商费用单查询
    @Test
    public void queryApSupplierFeeBill() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryApSupplierFeeBillUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "{\"listObj\":[{\"feeAmt\":100,\"createTime\":1542875354000,\"supplierName\":\"可口可乐\",\"createUserid\":1886080801000067,\"billStatus\":1,\"id\":1886084400000123,\"billName\":\"付款单a\",\"billTypeText\":\"供应商费用单\",\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886084400000122\",\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"华为线下旗舰店\",\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886082004000301\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"Gyp\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"待审核\",\"storeCode\":\"wuhan003\"},{\"feeAmt\":10,\"createTime\":1542079508000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":18101517160196,\"billStatus\":2,\"id\":1886083500000046,\"billTypeText\":\"供应商费用单\",\"auditTime\":1542181556000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886083500000045\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1542181556000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"superadmin\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1542007737000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":18101517160196,\"billStatus\":1,\"id\":1886083400000088,\"billTypeText\":\"供应商费用单\",\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886083400000087\",\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"superadmin\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"待审核\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1541759969000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000009,\"billStatus\":1,\"id\":1886083100000151,\"billTypeText\":\"供应商费用单\",\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886083100000150\",\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"待审核\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1541075074000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000067,\"billStatus\":2,\"id\":1886082300000181,\"billTypeText\":\"供应商费用单\",\"auditTime\":1541149759000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082300000180\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1541149759000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"Gyp\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1540967781000,\"supplierName\":\"纯净的纯牛奶\",\"createUserid\":18101517160196,\"billStatus\":2,\"id\":1886082200000164,\"billName\":\"付款单\",\"billTypeText\":\"供应商费用单\",\"auditTime\":1541149761000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082200000163\",\"updateUserid\":1886080801000067,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"财务o2o\",\"updateTime\":1542191671000,\"serverIp\":\"127.0.0.1\",\"supplierCode\":\"1886081503000005\",\"paymentStatus\":1,\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"superadmin\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"Gyp\",\"storeCode\":\"cw1003\"},{\"feeAmt\":10,\"createTime\":1540902142000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886082104000043,\"billTypeText\":\"供应商费用单\",\"auditTime\":1541149762000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082104000042\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1541149762000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":100,\"createTime\":1540901886000,\"supplierName\":\"纯净的纯牛奶\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886082104000037,\"billName\":\"付款单\",\"billTypeText\":\"供应商费用单\",\"auditTime\":1540901935000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082104000036\",\"updateUserid\":1886080801000009,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"糖果秀O2O1\",\"updateTime\":1540901935000,\"serverIp\":\"127.0.0.1\",\"supplierCode\":\"1886081503000005\",\"paymentStatus\":1,\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"kekoukele\",\"storeCode\":\"10300004\"},{\"feeAmt\":10,\"createTime\":1540897729000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886082104000031,\"billTypeText\":\"供应商费用单\",\"auditTime\":1540901813000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082104000030\",\"updateUserid\":1886080801000009,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1540901813000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"kekoukele\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":100,\"createTime\":1540536451000,\"supplierName\":\"纯净的纯牛奶\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886081704000112,\"billName\":\"付款单\",\"billTypeText\":\"供应商费用单\",\"auditTime\":1540810353000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886081704000111\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"2029081601000085\",\"updateTime\":1540810353000,\"serverIp\":\"127.0.0.1\",\"supplierCode\":\"1886081503000005\",\"paymentStatus\":1,\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181025212835\"}],\"total\":16}");
        Assert.assertEquals(data, expectedData);
        //    System.out.println(JSON.toJSONString(o));
    }

    //供应商费用单审核
    @Test
    public void SupplierFeeBill() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886081500000225}");
        Object o = Ajax.post(driver,SupplierFeeBillUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "");
        Assert.assertEquals(data, expectedData);
            //System.out.println(JSON.toJSONString(o));
    }

    //供应商费用单重置
    @Test
    public void queryApSupplierFee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"obj\":{},\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryApSupplierFeeUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "{\"listObj\":[{\"feeAmt\":100,\"createTime\":1542875354000,\"supplierName\":\"可口可乐\",\"createUserid\":1886080801000067,\"billStatus\":1,\"id\":1886084400000123,\"billName\":\"付款单a\",\"billTypeText\":\"供应商费用单\",\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886084400000122\",\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"华为线下旗舰店\",\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886082004000301\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"Gyp\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"待审核\",\"storeCode\":\"wuhan003\"},{\"feeAmt\":10,\"createTime\":1542079508000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":18101517160196,\"billStatus\":2,\"id\":1886083500000046,\"billTypeText\":\"供应商费用单\",\"auditTime\":1542181556000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886083500000045\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1542181556000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"superadmin\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1542007737000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":18101517160196,\"billStatus\":1,\"id\":1886083400000088,\"billTypeText\":\"供应商费用单\",\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886083400000087\",\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"superadmin\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"待审核\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1541759969000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000009,\"billStatus\":1,\"id\":1886083100000151,\"billTypeText\":\"供应商费用单\",\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886083100000150\",\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"待审核\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1541075074000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000067,\"billStatus\":2,\"id\":1886082300000181,\"billTypeText\":\"供应商费用单\",\"auditTime\":1541149759000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082300000180\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1541149759000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"Gyp\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":10,\"createTime\":1540967781000,\"supplierName\":\"纯净的纯牛奶\",\"createUserid\":18101517160196,\"billStatus\":2,\"id\":1886082200000164,\"billName\":\"付款单\",\"billTypeText\":\"供应商费用单\",\"auditTime\":1541149761000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082200000163\",\"updateUserid\":1886080801000067,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"财务o2o\",\"updateTime\":1542191671000,\"serverIp\":\"127.0.0.1\",\"supplierCode\":\"1886081503000005\",\"paymentStatus\":1,\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"superadmin\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"Gyp\",\"storeCode\":\"cw1003\"},{\"feeAmt\":10,\"createTime\":1540902142000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886082104000043,\"billTypeText\":\"供应商费用单\",\"auditTime\":1541149762000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082104000042\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1541149762000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":100,\"createTime\":1540901886000,\"supplierName\":\"纯净的纯牛奶\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886082104000037,\"billName\":\"付款单\",\"billTypeText\":\"供应商费用单\",\"auditTime\":1540901935000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082104000036\",\"updateUserid\":1886080801000009,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"糖果秀O2O1\",\"updateTime\":1540901935000,\"serverIp\":\"127.0.0.1\",\"supplierCode\":\"1886081503000005\",\"paymentStatus\":1,\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"kekoukele\",\"storeCode\":\"10300004\"},{\"feeAmt\":10,\"createTime\":1540897729000,\"supplierName\":\"P蒙牛供应商\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886082104000031,\"billTypeText\":\"供应商费用单\",\"auditTime\":1540901813000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886082104000030\",\"updateUserid\":1886080801000009,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"金蝶软件园89w87\",\"updateTime\":1540901813000,\"serverIp\":\"127.0.0.1\",\"paymentStatus\":1,\"supplierCode\":\"1886081603000000\",\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"kekoukele\",\"storeCode\":\"9820181028163854\"},{\"feeAmt\":100,\"createTime\":1540536451000,\"supplierName\":\"纯净的纯牛奶\",\"createUserid\":1886080801000009,\"billStatus\":2,\"id\":1886081704000112,\"billName\":\"付款单\",\"billTypeText\":\"供应商费用单\",\"auditTime\":1540810353000,\"settlementStatus\":1,\"versionNo\":0,\"billCode\":\"1886081704000111\",\"updateUserid\":18101517160196,\"settlementStatusText\":\"未关联结算单\",\"createType\":1,\"paymentStatusText\":\"未付款\",\"billType\":1,\"export\":false,\"storeName\":\"2029081601000085\",\"updateTime\":1540810353000,\"serverIp\":\"127.0.0.1\",\"supplierCode\":\"1886081503000005\",\"paymentStatus\":1,\"createTypeText\":\"人工创建\",\"isDeleted\":0,\"createUsername\":\"kekoukele\",\"paymentMethodText\":\"票扣\",\"companyId\":231,\"paymentMethod\":1,\"billStatusText\":\"已审核 \",\"updateUsername\":\"superadmin\",\"storeCode\":\"9820181025212835\"}],\"total\":16}");
        Assert.assertEquals(data, expectedData);
        //    System.out.println(JSON.toJSONString(o));
    }


    //新增费用单-查询门店
    @Test
    public void queryStore() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryStore,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "{\"listObj\":[{\"storeName\":\"华为线下旗舰店\",\"merchantName\":\"武汉光谷K11国际中心\",\"merchantId\":2029084400000000,\"storeId\":2029084400003360,\"storeCode\":\"wuhan003\"},{\"storeName\":\"荣耀线上旗舰店\",\"merchantName\":\"武汉光谷K11国际中心\",\"merchantId\":2029084400000000,\"storeId\":2029084400003355,\"storeCode\":\"wuhan002\"},{\"storeName\":\"武汉荣耀旗舰店\",\"merchantName\":\"武汉光谷K11国际中心\",\"merchantId\":2029084400000000,\"storeId\":2029084400003350,\"storeCode\":\"wuhan001\"},{\"storeName\":\"b2cXIANSHANG\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084300000005,\"storeCode\":\"7801111\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000059\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000059,\"storeCode\":\"9820181120135009\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000051\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000051,\"storeCode\":\"9820181120134650\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000043\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000043,\"storeCode\":\"9820181120104130\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000035\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000035,\"storeCode\":\"9820181120104000\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000027\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000027,\"storeCode\":\"9820181120100324\",\"detailAddress\":\"金蝶软件园36号\"},{\"regionCode\":\"310115\",\"storeName\":\"2029084200000019\",\"provinceCode\":\"310000\",\"cityCode\":\"310100\",\"merchantName\":\"可口可乐\",\"merchantId\":2029080800000000,\"storeId\":2029084200000019,\"storeCode\":\"9820181120100258\",\"detailAddress\":\"金蝶软件园36号\"}],\"total\":116}");
        Assert.assertEquals(data, expectedData);
        //System.out.println(JSON.toJSONString(o));
    }


    //新增费用单-查询供应商
    @Test
    public void querySupplier() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,querySupplier,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        JSONObject data=actualResult.getJSONObject("data");
//     data.remove("trace");
        JSONObject expectedData = JSON.parseObject( "{\"listObj\":[{\"supplierName\":\"可口可乐\",\"supplierId\":12,\"supplierCode\":\"1886082004000301\"},{\"supplierName\":\"可口可乐供应商\",\"supplierId\":46,\"supplierCode\":\"1886084402000032\"},{\"supplierName\":\"可口可乐供应商\",\"supplierId\":47,\"supplierCode\":\"1886084402000037\"},{\"supplierName\":\"可口可乐供应商\",\"supplierId\":49,\"supplierCode\":\"1886084402000049\"}],\"total\":4}");
        Assert.assertEquals(data, expectedData);
        //System.out.println(JSON.toJSONString(o));
    }

    //新增费用单-查询费用类型
    @Test
    public void selectFeeType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemPerPage\":10}");
        Object o = Ajax.post(driver,selectFeeType,param);
        System.out.println(JSON.toJSONString(o));
    }

    //新增费用单
    @Test
    public void saveFee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"feeBillItemDTOs\":[{\"feeTypeCode\":\"2\",\"feeTypeName\":\"付款\",\"feeTransactionType\":1,\"feeItemAmt\":10}],\"billType\":1,\"paymentMethod\":1,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"storeCode\":\"9820181028163854\",\"storeName\":\"金蝶软件园89w87\"}");
        Object o = Ajax.post(driver,saveFee,param);
        System.out.println(JSON.toJSONString(o));
    }

    //编辑费用单
    @Test
    public void updateApSupplierFee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"feeBillItemDTOs\":[{\"id\":1886082200000166,\"feeItemCode\":\"1886082200000165\",\"billName\":\"付款单\",\"feeBillCode\":\"1886082200000163\",\"feeTypeCode\":\"2\",\"feeTypeName\":\"付款\",\"feeTransactionType\":1,\"feeTransactionTypeText\":\"收\",\"feeItemAmt\":10,\"paidAmt\":null,\"settlementCode\":null,\"settlementStatus\":1,\"settlementStatusText\":\"未关联结算单\",\"paymentBillCode\":null,\"paymentStatus\":1,\"paymentStatusText\":\"未付款\",\"paymentTime\":null,\"paymentTimeStart\":null,\"paymentTimeEnd\":null,\"remark\":null,\"isDeleted\":0,\"companyId\":231,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1540967781000,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"versionNo\":0,\"serverIp\":\"127.0.0.1\"}],\"billCodeList\":null,\"paymentStatusNotInList\":null,\"id\":1886082200000164,\"billCode\":\"1886082200000163\",\"billName\":\"付款单\",\"billType\":1,\"billTypeText\":\"供应商费用单\",\"supplierCode\":\"1886081503000005\",\"supplierName\":\"纯净的纯牛奶\",\"billStatus\":1,\"billStatusText\":\"待审核\",\"settlementCode\":null,\"settlementStatus\":1,\"settlementStatusText\":\"未关联结算单\",\"paidAmt\":null,\"paymentStatus\":1,\"paymentStatusText\":\"未付款\",\"paymentBillCode\":null,\"paymentMethod\":1,\"paymentMethodText\":\"票扣\",\"paymentChannel\":null,\"paymentTime\":null,\"paymentTimeStart\":null,\"paymentTimeEnd\":null,\"feeAmt\":100,\"auditTime\":null,\"auditTimeStart\":null,\"auditTimeEnd\":null,\"auditLevel\":null,\"auditLevelName\":null,\"storeCode\":\"cw1003\",\"storeName\":\"财务o2o\",\"merchantName\":null,\"merchantCode\":null,\"createType\":1,\"createTypeText\":\"人工创建\",\"createUserRealName\":null,\"remark\":null,\"isDeleted\":0,\"companyId\":231,\"serverIp\":\"127.0.0.1\",\"versionNo\":0,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1540967781000,\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"export\":false}");
        Object o = Ajax.post(driver,updateApSupplierFeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //供应商费用单删除
    @Test
    public void deleteApSupplierFee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083400000084}");
        Object o = Ajax.post(driver,deleteApSupplierFeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //供应商费用明细重置
    @Test
    public void sumFeeBillDetails() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,SupplierFeeBillItemUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //供应商费用明细查询
    @Test
    public void SupplierFee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{obj:{}, currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,SupplierFeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //费用类型管理新增
    @Test
    public void saveFeeType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"superfeeTypeCode\":\"0\",\"feeTypeLevel\":0,\"isPreset\":\"0\",\"transactionType\":1,\"isAvailable\":1,\"feeTypeAttribute\":2,\"feeTypeCode\":\"5\",\"feeTypeName\":\"收款\"}");
        Object o = Ajax.post(driver,saveFeeTypeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //费用类型新增
    @Test
    public void saveFeel() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"superfeeTypeCode\":\"5\",\"feeTypeLevel\":1,\"isPreset\":0,\"transactionType\":1,\"isAvailable\":1,\"feeTypeAttribute\":2,\"feeTypeCode\":\"6\",\"feeTypeName\":\"收款单据\"}");
        Object o = Ajax.post(driver,saveFeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    //费用类型管理查看
    @Test
    public void selectFeeTypeUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886080903000186}");
        Object o = Ajax.post(driver,selectFeeTypeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //费用类型删除
    @Test
    public void removeFee() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083600000103,\"feeTypeLevel\":2,\"feeTypeCode\":\"6\",\"feeTypeName\":\"收款单据\",\"transactionType\":1,\"superfeeTypeCode\":\"5\",\"feeTypeAttribute\":2,\"isAvailable\":1,\"isPreset\":0,\"currentPage\":null,\"itemPerPage\":null,\"merchantId\":null,\"merchantCode\":null,\"merchantName\":null,\"rootMerchantId\":null,\"rootMerchantCode\":null,\"rootMerchantName\":null}");
        Object o = Ajax.post(driver,removeFeeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    //费用类型管理删除
    @Test
    public void removeFeeType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1886083600000096,\"feeTypeLevel\":1,\"feeTypeCode\":\"5\",\"feeTypeName\":\"收款\",\"transactionType\":1,\"superfeeTypeCode\":\"0\",\"feeTypeAttribute\":2,\"isAvailable\":1,\"isPreset\":0,\"currentPage\":null,\"itemPerPage\":null,\"merchantId\":null,\"merchantCode\":null,\"merchantName\":null,\"rootMerchantId\":null,\"rootMerchantCode\":null,\"rootMerchantName\":null}");
        Object o = Ajax.post(driver,removeFeeTypeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

}
