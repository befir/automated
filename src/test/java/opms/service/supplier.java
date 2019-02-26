package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

//供应商管理
public class supplier extends RestfulAutomatedTest {

    //供应商管理查询
    private String querySupplierUrl = baseUrl+"/opms-web/supplier/querySupplierList.do";
    //供应商管理编辑
    private String saveSupplierUrl = baseUrl+"/opms-web/supplier/saveSupplier.do";
    //供应商管理重置
    private String querySupplierListUrl = baseUrl+"/opms-web/supplier/querySupplierList.do";
    //供应商管理新增
    private String saveSupplier1URL = baseUrl+"/opms-web/supplier/saveSupplier.do";
    //供应商管理删除
    private String deleteSupplierUrl = baseUrl+"/opms-web/supplier/deleteSupplier.do";

    //查询供应商
    @Test
    public void querySupplier() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-21\",\"createTimeStart\":\"2018-10-22\"}}");
       Object o = Ajax.post(driver, querySupplierUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
////       断言data
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
       System.out.println(JSON.toJSONString(o));
    }
    //编辑供应商
    @Test
    public void saveSupplier() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantIds\":null,\"id\":13,\"supplierCode\":\"1886082802000015\",\"supplierName\":\"维达供应商\",\"supplierShortName\":null,\"supplierHelpCode\":null,\"supplierGlnCode\":null,\"userId\":18101517160196,\"merchantId\":2029081400000035,\"merchantCode\":\"20181023\",\"merchantName\":\"维达\",\"enterpriseCode\":null,\"enterpriseName\":null,\"enterpriseType\":null,\"enterpriseLicenseNumber\":\"201811060001\",\"enterpriseTaxPayerType\":1,\"enterpriseTaxRate\":10,\"enterpriseTaxCode\":null,\"enterpriseRegisteredCapital\":null,\"enterpriseBrandName\":null,\"enterpriseMajorBusiness\":null,\"cooperationMethod\":\"1\",\"status\":1,\"statusText\":\"启用\",\"wmsSendStatus\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080905000049,\"createUsername\":\"sunny\",\"createTime\":1541500700000,\"createTimeDb\":1541500695000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1542772334000,\"updateTimeDb\":null,\"addressDetail\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"enterpriseTaxPayerTypeText\":\"一般纳税人\",\"enterpriseTypeText\":\"\",\"cooperationMethodText\":\"经销\",\"receiverAccountType\":null,\"receiverAccountTypeText\":null,\"receiverAccountNo\":null,\"receiverMobile\":null,\"receiverIdNumber\":null,\"receiverRealName\":null,\"receiverBankName\":null,\"receiverSubBankName\":null,\"provinceName\":null,\"cityName\":null,\"regionName\":null,\"personName\":null,\"positionName\":null,\"fixedTelephone\":null,\"mobile\":null,\"fax\":null,\"qq\":null,\"weixin\":null,\"postcode\":null,\"email\":null,\"contactPersonAddressDetail\":null,\"supplierCodeList\":null,\"attachInfo\":[],\"contactInfo\":{\"id\":12,\"supplierCode\":\"1886082802000015\",\"userId\":null,\"userLoginName\":null,\"personName\":\"123\",\"positionName\":null,\"fixedTelephone\":null,\"mobile\":\"13\",\"fax\":null,\"qq\":null,\"weixin\":null,\"postcode\":null,\"email\":null,\"addressDetail\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080905000049,\"createUsername\":\"sunny\",\"createTime\":1541500700000,\"createTimeDb\":1541500695000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1542772334000,\"updateTimeDb\":null},\"addressInfo\":{\"id\":12,\"supplierCode\":\"1886082802000015\",\"provinceId\":2,\"provinceName\":\"北京\",\"cityId\":37,\"cityName\":\"北京市\",\"regionId\":410,\"regionName\":\"东城区\",\"addressDetail\":\"123\",\"isDefault\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080905000049,\"createUsername\":\"sunny\",\"createTime\":1541500700000,\"createTimeDb\":1541500695000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1542772334000,\"updateTimeDb\":null},\"accountInfo\":{\"id\":12,\"supplierCode\":\"1886082802000015\",\"receiverAccountType\":1,\"receiverAccountTypeText\":\"支付宝\",\"receiverAccountNo\":\"13\",\"receiverMobile\":\"123\",\"receiverIdNumber\":\"1231\",\"receiverRealName\":\"132\",\"receiverBankName\":\"132\",\"receiverSubBankName\":\"123\",\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080905000049,\"createUsername\":\"sunny\",\"createTime\":1541500700000,\"createTimeDb\":1541500695000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1542772334000,\"updateTimeDb\":null},\"currentPage\":null,\"itemsPerPage\":null}");

        Object o = Ajax.post(driver, saveSupplierUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言data
         String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
       System.out.println(JSON.toJSONString(o));
    }
      //重置供应商
    @Test
    public void querySupplierList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"obj\":{\"createTimeEnd\":\"2018-11-21\",\"createTimeStart\":\"2018-10-22\"}}");
        Object o = Ajax.post(driver, querySupplierListUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
////        断言data
        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        Assert.assertNotNull(actualResult.get("data"));
        System.out.println(JSON.toJSONString(o));
    }

    //新增供应商
    @Test
    public void saveSupplier1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"status\":1,\"supplierName\":\"666666\",\"enterpriseTaxPayerType\":\"1\",\"cooperationMethod\":\"1\",\"enterpriseLicenseNumber\":\"S2185413215814\",\"enterpriseTaxRate\":\"10\",\"accountInfo\":{\"receiverAccountType\":\"1\",\"receiverAccountNo\":\"13255558888\",\"receiverRealName\":\"留着\",\"receiverMobile\":\"13255558888\",\"receiverIdNumber\":\"411481199601221111\",\"receiverBankName\":\"建设银行\",\"receiverSubBankName\":\"建设银行\"},\"contactInfo\":{\"personName\":\"留着\",\"mobile\":\"13255558888\"},\"attachInfo\":[],\"addressInfo\":{\"provinceName\":\"上海\",\"provinceId\":10,\"cityName\":\"上海市\",\"cityId\":110,\"regionName\":\"宝山区\",\"regionId\":1138,\"addressDetail\":\"宝山公路\"},\"merchantId\":2076083800017140,\"merchantCode\":\"6666\",\"merchantName\":\"66666\"}\n");
        Object o = Ajax.post(driver, saveSupplier1URL, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言data
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
       System.out.println(JSON.toJSONString(o));
    }

    //删除供应商
    @Test
    public void deleteSupplier() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantIds\":null,\"id\":23,\"supplierCode\":\"1886084302000038\",\"supplierName\":\"66666\",\"supplierShortName\":null,\"supplierHelpCode\":null,\"supplierGlnCode\":null,\"userId\":18101517160196,\"merchantId\":2029080800000000,\"merchantCode\":\"1\",\"merchantName\":\"可口可乐\",\"enterpriseCode\":null,\"enterpriseName\":null,\"enterpriseType\":null,\"enterpriseLicenseNumber\":\"S2132145681321\",\"enterpriseTaxPayerType\":1,\"enterpriseTaxRate\":20,\"enterpriseTaxCode\":null,\"enterpriseRegisteredCapital\":null,\"enterpriseBrandName\":null,\"enterpriseMajorBusiness\":null,\"cooperationMethod\":\"1\",\"status\":1,\"statusText\":\"启用\",\"wmsSendStatus\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":18101517160196,\"createUsername\":\"superadmin\",\"createTime\":1542783506000,\"createTimeDb\":1542783492000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null,\"addressDetail\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"enterpriseTaxPayerTypeText\":null,\"enterpriseTypeText\":null,\"cooperationMethodText\":null,\"receiverAccountType\":null,\"receiverAccountTypeText\":null,\"receiverAccountNo\":null,\"receiverMobile\":null,\"receiverIdNumber\":null,\"receiverRealName\":null,\"receiverBankName\":null,\"receiverSubBankName\":null,\"provinceName\":null,\"cityName\":null,\"regionName\":null,\"personName\":null,\"positionName\":null,\"fixedTelephone\":null,\"mobile\":null,\"fax\":null,\"qq\":null,\"weixin\":null,\"postcode\":null,\"email\":null,\"contactPersonAddressDetail\":null,\"supplierCodeList\":null,\"attachInfo\":null,\"contactInfo\":null,\"addressInfo\":null,\"accountInfo\":null,\"currentPage\":null,\"itemsPerPage\":null}");
        Object o = Ajax.post(driver, deleteSupplierUrl, param);
       JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        断言data
        String expectedData = "请求成功";
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("message"),expectedData);
        Assert.assertEquals(actualResult.get("code"),expectedData1);
        System.out.println(JSON.toJSONString(o));

    }

}
