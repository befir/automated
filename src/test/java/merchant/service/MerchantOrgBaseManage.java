package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class MerchantOrgBaseManage extends RestfulAutomatedTest {

    //获取商家组织基本信息
    private String queryMerchantOrgBaseInfoByOrgId = baseUrl+"/back-merchant-web/merchantOrgInfo/queryMerchantOrgBaseInfoByOrgId.do";
    //获取当前启用的商家入驻条款信息
    private String queryEntryTermsById = baseUrl+"/back-merchant-web/entryTerms/queryEntryTermsById.do.do";
    //获取组织层级信息
    private String queryOrgLevelInfoList = baseUrl+"/back-merchant-web/orgLevelAction/queryOrgLevelInfoList.do";
    //修改商家组织基本信息
    private String editMerchantOrgBaseInfoByOrgId = baseUrl+"/back-merchant-web/merchantOrgInfo/updateMerchantOrgBaseInfoById.do";
   @Test
    public void queryEntryTermsById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"entryType\":1,\"status\":1}");
        Object o = Ajax.post(driver,queryEntryTermsById,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryOrgLevelInfoList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryOrgLevelInfoList,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editMerchantOrgBaseInfoByOrgId() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"orgId\":\"\",\"orgCode\":\"1\",\"orgType\":\"1\",\"merchantType\":\"11\",\"orgName\":\"\",\"auditStatus\":\"0\",\"businessStatus\":\"-1\",\"businessPeriodBegin\":\"2018-11-01\",\"businessPeriodEnd\":\"2018-12-31\",\"registeredDeposit\":\"1000\",\"accountingUnitId\":\"\",\"enterpriseName\":\"\",\"enterpriseType\":\"1\",\"enterpriseStaffNums\":\"2\",\"businessScope\":\"\",\"businessLicenceNo\":\"1234567890\",\"businessLicenceUrl\":null,\"businessLicencePeriodBegin\":\"2018-11-01\",\"businessLicencePeriodEnd\":\"2018-12-31\",\"registeredStatus\":null,\"registeredCountryCode\":null,\"registeredCountryName\":null,\"registeredProvinceCode\":310000,\"registeredProvinceName\":null,\"registeredCityCode\":310100,\"registeredCityName\":null,\"registeredRegionCode\":310115,\"registeredRegionName\":null,\"registeredDetailAddress\":\"张江\",\"registeredCapital\":\"2\",\"legalRepresentativeName\":\"\",\"legalRepresentativeCertificateType\":\"1\",\"legalRepresentativeCertificateNo\":\"360730199501011001\",\"contactName\":\"楚阳\",\"mobileNo\":\"15801904143\",\"email\":\"15801904143@qq.com\",\"contactDetailAddress\":\"张江\",\"contactProvinceCode\":310000,\"contactCityCode\":310100,\"contactRegionCode\":310115,\"orgLevelCode\":\"rootLevel\",\"entryTermsId\":\"\",\"registeredMoney\":\"\"}");
        param.put("id","2029080800000000");
        param.put("orgId","2029080800000000");
        param.put("orgName","可口可乐");
        param.put("accountingUnitId","2029080803000006");
        param.put("enterpriseName","可口可乐公司");
        param.put("businessScope","电子商务");
        param.put("legalRepresentativeName","可口可乐公司");
        param.put("entryTermsId","2029081900000216");
        Object o = Ajax.post(driver,editMerchantOrgBaseInfoByOrgId,param);
        System.out.println(JSON.toJSONString(o));
    }

}
