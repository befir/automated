package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class ProductManage extends RestfulAutomatedTest {

    //全局变量
    private String orgId;
    private String orgCode = "JS371522222jh7";
    private String orgName = "金蝶软件015f7f";

    //接口
    private String queryMerchantOrgServiceUrl = baseUrl + "/back-merchant-web/registerMerchant/queryRegisterMerchantPageInfo.do";
    private String addRegisterMerchantInfoUrl = baseUrl + "/back-merchant-web/registerMerchant/addRegisterMerchantInfo.do";
    private String updateMerchantOrgBaseInfoByIdUrl = baseUrl + "/back-merchant-web/merchantOrgInfo/updateMerchantOrgBaseInfoById.do";
    private String updateMerchantOrgBaseInfoByIdUrl2 = baseUrl + "";
    private String updateMerchantOrgBaseInfoByIdUrl1 = baseUrl + "";


    @Test
    public void queryMerchantOrgCode() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("orgCode", "orgCode");
        Object o = Ajax.post(driver, queryMerchantOrgServiceUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void addRegisterMerchant () throws InterruptedException {
        JSONObject addRegisterparam = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        addRegisterparam.put("orgCode", orgCode);
        addRegisterparam.put("orgName", orgName);
        addRegisterparam.put("merchantType", "11");
        Object o = Ajax.post(driver, addRegisterMerchantInfoUrl, addRegisterparam);
        System.out.println(JSON.toJSONString(o));
        JSONObject result = (JSONObject) JSON.toJSON(o);
        orgId = result.getString("data");
        Thread.sleep(5000);
    }
    @Test
    public void updateMerchantOrg () throws InterruptedException {
        JSONObject updateMerchantparam = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Thread.sleep(5000);
        updateMerchantparam.put("accountingUnitId", "2029080803000006");
        updateMerchantparam.put("auditStatus", "0");
        updateMerchantparam.put("businessLicenceNo", "985656656565656J");
        updateMerchantparam.put("businessLicencePeriodBegin", "2018-10-15");
        updateMerchantparam.put("businessLicencePeriodEnd", "2019-10-18");
        updateMerchantparam.put("businessLicenceUrl", null);
        updateMerchantparam.put("businessPeriodBegin", "2018-10-14");
        updateMerchantparam.put("businessPeriodEnd", "2022-10-18");
        updateMerchantparam.put("businessScope", "服装，食品");
        updateMerchantparam.put("businessStatus", "-1");
        updateMerchantparam.put("contactCityCode", 310100);
        updateMerchantparam.put("contactDetailAddress", "金蝶软件园3号楼");
        updateMerchantparam.put("contactName", "张三88");
        updateMerchantparam.put("contactProvinceCode", 310000);
        updateMerchantparam.put("contactRegionCode", 310115);
        updateMerchantparam.put("email", "397013577@qq.com");
        updateMerchantparam.put("enterpriseName", "金蝶软件园x");
        updateMerchantparam.put("enterpriseStaffNums", 4);
        updateMerchantparam.put("enterpriseType", "2");
        updateMerchantparam.put("entryTermsId", "2029080800000037");
        updateMerchantparam.put("id", orgId);
        updateMerchantparam.put("legalRepresentativeCertificateNo", "985656656565656");
        updateMerchantparam.put("legalRepresentativeCertificateType", "1");
        updateMerchantparam.put("legalRepresentativeName", "金蝶");
        updateMerchantparam.put("merchantType", "11");
        updateMerchantparam.put("mobileNo", "13262277382");
        updateMerchantparam.put("orgCode", orgCode);
        updateMerchantparam.put("orgId", orgId);
        updateMerchantparam.put("orgName", orgName);
        updateMerchantparam.put("orgType", "1");
        updateMerchantparam.put("registeredCapital", "4");
        updateMerchantparam.put("registeredCityCode", "310100");
        updateMerchantparam.put("registeredDeposit", 900);
        updateMerchantparam.put("registeredDetailAddress", "金蝶软件园3号楼");
        updateMerchantparam.put("registeredProvinceCode", 310000);
        updateMerchantparam.put("registeredRegionCode", 310115);
        Object o = Ajax.post(driver, updateMerchantOrgBaseInfoByIdUrl, updateMerchantparam);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryMerchantOrgByOrgCode () throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("orgCode", orgCode);
        Object o = Ajax.post(driver, queryMerchantOrgServiceUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryMerchantOrgByOrgCode2 () throws InterruptedException {
        addRegisterMerchant();
        updateMerchantOrg();
    }
}

