package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class CertificateManage extends RestfulAutomatedTest {

    //获取资质证书信息
    private String queryMerchantOrgCertificateByOrgId = baseUrl+"/back-merchant-web/merchantOrgCertificate/queryMerchantOrgCertificateByOrgId.do";
    //新增资质证书
    private String addMerchantOrgCertificate = baseUrl+"/back-merchant-web/merchantOrgCertificate/addMerchantOrgCertificate.do";
    //修改资质证书信息
    private String editMerchantOrgCertificate = baseUrl+"/back-merchant-web/merchantOrgCertificate/updateMerchantOrgCertificateById.do";
    //删除资质证书
    private String deleteMerchantOrgBaseInfoByOrgId = baseUrl+"/back-merchant-web/merchantOrgCertificate/deleteMerchantOrgCertificateById.do";
//    @Test
//    public void queryEntryTermsById() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{\"2029080800000000\"}");
//        Object o = Ajax.post(driver,queryMerchantOrgCertificateByOrgId,param);
//        System.out.println(JSON.toJSONString(o));
//    }
    @Test
    public void addMerchantOrgCertificate() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"certificateName\":\"\",\"periodBegin\":\"\",\"periodEnd\":\"\",\"fileUrl\":\"\",\"description\":\"\",\"orgId\":\"\"}");
        param.put("orgId","2029080800000000");
        param.put("certificateName","资质证书"+dateFormat.format(new Date()));
        param.put("periodBegin","2018-11-01");
        param.put("periodEnd","2019-01-31");
        param.put("fileUrl","https://cdn.oudianyun.com/trunk/back-merchant-web/1541568205926_23.006508280815552_67f74ce2-2ca7-4fed-8941-10ee4c572662.jpg");
        param.put("description","资质证书描述"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addMerchantOrgCertificate,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editMerchantOrgCertificate() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"orgId\":\"\",\"certificateType\":null,\"fileUrl\":\"\",\"certificateName\":\"\",\"periodBegin\":\"\",\"periodEnd\":\"\",\"description\":\"\"}");
        param.put("id","2029082900000032");
        param.put("orgId","2029080800000000");
        param.put("certificateName","资质证书"+dateFormat.format(new Date()));
        param.put("periodBegin","2018-11-01");
        param.put("periodEnd","2019-01-31");
        param.put("fileUrl","https://cdn.oudianyun.com/trunk/back-merchant-web/1541568205926_23.006508280815552_67f74ce2-2ca7-4fed-8941-10ee4c572662.jpg");
        param.put("description","资质证书描述"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,editMerchantOrgCertificate,param);
        System.out.println(JSON.toJSONString(o));
    }
//    @Test
//    public void deleteMerchantOrgCertificate() throws InterruptedException {
//        JSONObject param = JSON.parseObject("{2029081601000017}");
//        Object o = Ajax.post(driver,deleteMerchantOrgBaseInfoByOrgId,param);
//        System.out.println(JSON.toJSONString(o));
//    }

}
