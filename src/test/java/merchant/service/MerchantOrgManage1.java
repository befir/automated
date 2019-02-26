package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class MerchantOrgManage1 extends RestfulAutomatedTest {

    private String queryMerchantOrgServiceUrl = baseUrl+"/back-merchant-web/registerMerchant/queryRegisterMerchantPageInfo.do";
    private String addMerchantOrgServiceUrl = baseUrl+"";

    private String orgCode = "20181012173102";
    @Test
    public void queryMerchantOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryMerchantOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public Object queryMerchantOrgByOrgCode() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("orgCode",orgCode);
        Object o = Ajax.post(driver,queryMerchantOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
        return o;
    }
    @Test
    public void queryMerchantOrgByOrgCode2() throws InterruptedException {

        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("orgCode",orgCode);
        Object o = Ajax.post(driver,queryMerchantOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void addMerchantOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("orgCode","20181012173102");
        Object o = Ajax.post(driver,addMerchantOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
