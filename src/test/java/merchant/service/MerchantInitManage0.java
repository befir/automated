package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class MerchantInitManage0 extends RestfulAutomatedTest {

    //查询当前商家账号下的商家（商家平台）
    private String getMerchantOrgServiceUrl = baseUrl+"/ouser-web/employee/queryIdentityInfo.do";
    //查询经销商列表
    private String queryMerchantInitServiceUrl = baseUrl+"/back-merchant-web/registerMerchant/queryRegisterDistributorPageInfo.do";
    //新增经销商
    private String addMerchantInitServiceUrl = baseUrl+"/back-merchant-web/registerMerchant/addRegisterMerchantInfo.do";
    //获取经销商详情信息
    private String queryMerchantInitByOrgIdServiceUrl = baseUrl+"/back-merchant-web/merchantOrgInfo/queryDistributorOrgBaseInfoByOrgId.do";
    //修改经销商详情信息
    private String editMerchantInitServiceUrl = baseUrl+"/back-merchant-web/merchantOrgInfo/updateMerchantOrgBaseInfoById.do";
    //获取经销商结算信息
    private String getMerchantAccountServiceUrl = baseUrl+"/back-finance-web/stmMerchantAccountController/selectMerchantAccount.do";
    //修改经销商结算信息
    private String editMerchantAccountServiceUrl = baseUrl+"/back-finance-web/stmMerchantAccountController/saveMerchantAccount.do";
    //获取经销商账号信息
    private String queryEmployeeServiceUrl = baseUrl+"/ouser-web/employee/queryEmployee.do";
    //修改经销商账号信息
    private String editEmployeeServiceUrl = baseUrl+"/ouser-web/employee/updateEmployee.do";
    @Test
    public void getMerchant() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,getMerchantOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryMerchantInit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"businessStatus\":\"\",\"merchantType\":\"\",\"auditStatus\":\"\",\"currentPage\":1,\"itemsPerPage\":10,\"orgType\":4,\"merchantIds\":[\"2029080800000000\"]}");
        Object o = Ajax.post(driver,queryMerchantInitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addMerchantInit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantType\":11,\"orgCode\":\"\",\"orgName\":\"\",\"orgType\":4,\"merchantId\":\"\"}");
        param.put("merchantId","2029080800000000");
        param.put("orgCode",dateFormat.format(new Date()));
        param.put("orgName","经销商"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addMerchantInitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
//    @Test
//    public void queryMerchantInitByOrgIdServiceUrl() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"2029080902000006\"}");
//        Object o = Ajax.post(driver,queryMerchantInitByOrgIdServiceUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
    @Test
    public void editStore() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"orgId\":\"\",\"orgCode\":\"SJX001\",\"orgType\":4,\"merchantType\":\"11\",\"orgName\":\"可口可乐经销商\",\"auditStatus\":\"0\",\"businessStatus\":\"1\",\"businessPeriodBegin\":null,\"businessPeriodEnd\":null,\"registeredDeposit\":null,\"accountingUnitId\":null,\"enterpriseName\":\"测试公司001\",\"enterpriseType\":\"1\",\"enterpriseStaffNums\":1,\"businessScope\":\"饮品\",\"businessLicenceNo\":\"123456789\",\"businessLicenceUrl\":null,\"businessLicencePeriodBegin\":\"2018-12-19\",\"businessLicencePeriodEnd\":\"2019-01-31\",\"registeredStatus\":null,\"registeredCountryCode\":null,\"registeredCountryName\":null,\"registeredProvinceCode\":310000,\"registeredProvinceName\":null,\"registeredCityCode\":310100,\"registeredCityName\":null,\"registeredRegionCode\":310115,\"registeredRegionName\":null,\"registeredDetailAddress\":\"张江\",\"registeredCapital\":\"3\",\"legalRepresentativeName\":\"测试公司001\",\"legalRepresentativeCertificateType\":\"1\",\"legalRepresentativeCertificateNo\":\"123456789\",\"contactName\":\"楚阳\",\"mobileNo\":15801904143,\"email\":\"15056040000@qq.com\",\"contactDetailAddress\":\"张江\",\"contactProvinceCode\":310000,\"contactCityCode\":310100,\"contactRegionCode\":310115,\"orgLevelCode\":null,\"entryTermsId\":null,\"registeredMoney\":\"\"}");
        param.put("id","2029080902000006");
        param.put("orgId","2029080902000006");
        Object o = Ajax.post(driver,editMerchantInitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getMerchantAccountServiceUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"merchantId\":\"\"}");
        param.put("merchantId","2029080902000006");
        Object o = Ajax.post(driver,getMerchantAccountServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editMerchantAccountServiceUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"merchantId\":\"\",\"receiverAccountType\":9,\"receiverEnterpriseName\":\"可口可乐\",\"receiverAccountNo\":\"123456\",\"receiverBankName\":\"中国银行\",\"receiverSubBankName\":\"张江支行\"}");
        param.put("id","1886081002000111");
        param.put("merchantId","2029080902000006");
        Object o = Ajax.post(driver,editMerchantAccountServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryEmployeeServiceUrl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"entityId\":\"\",\"identitySubTypes\":[41],\"currentPage\":1,\"itemsPerPage\":1}");
        param.put("entityId","2029080902000006");
        Object o = Ajax.post(driver,queryEmployeeServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
//    @Test
//    public void editEmployeeServiceUrl() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"userId\":1886080905000099,\"userName\":\"JXStest01\",\"password\":\"742f7a064323944713bd218529100173\",\"identityCardName\":\"JXStest01\",\"mobile\":\"12010000006\",\"email\":null,\"employeNum\":null,\"remarks\":null,\"merchantId\":null,\"isAvailable\":1,\"identityTypeCode\":null,\"identityType\":4,\"identitySubType\":41,\"entityType\":\"4\",\"entityId\":\"\",\"entityName\":null,\"departments\":[],\"positions\":[],\"exist\":true,\"currentPage\":1,\"itemsPerPage\":1}");
//        param.put("entityId","2029080902000006");
//        Object o = Ajax.post(driver,editEmployeeServiceUrl,param);
//        System.out.println(JSON.toJSONString(o));
//    }
}
