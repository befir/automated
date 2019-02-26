package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class supplierManagement extends RestfulAutomatedTest {
    //查询供应商列表
    private String querySupplierListurl = baseUrl+"/opms-web/supplier/querySupplierList.do";
    //获取供应商id
    private String getSupplierBasicurl = baseUrl+"/opms-web/supplier/getSupplierBasic.do";
   //提供附件
    private String getSupplierAttachurl = baseUrl+"/opms-web/supplier/getSupplierAttach.do";
   //供应商详情
    private String getSupplierContacturl = baseUrl+"/opms-web/supplier/getSupplierContact.do";
    //供应商账户信息
    private String getSupplierAccounturl = baseUrl+"/opms-web/supplier/getSupplierAccount.do";
    //供应商地址
    private String getSupplierAddressurl = baseUrl+"/opms-web/supplier/getSupplierAddress.do";
    //新增供应商
    private String saveSupplierurl = baseUrl+"/opms-web/supplier/saveSupplier.do";

    @Test
    public void querySupplierList() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"obj\": {\n" +
                "\t\t\"createTimeEnd\": \"2018-11-22\",\n" +
                "\t\t\"createTimeStart\": \"2018-10-23\"\n" +
                "\t}\n" +
                "}");
        Object o = Ajax.post(driver, querySupplierListurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));

    }
    @Test
    public void getSupplierBasic() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"supplierCode\": \"1886084402000032\"\n" +
                "}");
        Object o = Ajax.post(driver, getSupplierBasicurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));

    }
    @Test
    public void getSupplierAttach() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"supplierCode\": \"1886084402000032\"\n" +
                "}");
        Object o = Ajax.post(driver, getSupplierAttachurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));

    }
    @Test
    public void getSupplierContact() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"supplierCode\": \"1886084402000032\"\n" +
                "}");
        Object o = Ajax.post(driver, getSupplierContacturl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));

    }
    @Test
    public void getSupplierAccount() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"supplierCode\": \"1886084402000032\"\n" +
                "}");
        Object o = Ajax.post(driver, getSupplierAccounturl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));

    }
    @Test
    public void getSupplierAddress() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"supplierCode\": \"1886084402000032\"\n" +
                "}");
        Object o = Ajax.post(driver, getSupplierAddressurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));

    }
    @Test
    public void saveSupplier() throws InterruptedException {
        JSONObject editRegisterparam = JSON.parseObject("{\n" +
                "\t\"status\": 1,\n" +
                "\t\"supplierName\": \"可口可乐供应商\",\n" +
                "\t\"cooperationMethod\": \"1\",\n" +
                "\t\"enterpriseTaxPayerType\": \"1\",\n" +
                "\t\"enterpriseLicenseNumber\": \"12100010001\",\n" +
                "\t\"enterpriseTaxRate\": \"0.2\",\n" +
                "\t\"accountInfo\": {\n" +
                "\t\t\"receiverAccountType\": \"1\",\n" +
                "\t\t\"receiverRealName\": \"采购员\",\n" +
                "\t\t\"receiverAccountNo\": \"12100010001\",\n" +
                "\t\t\"receiverMobile\": \"12100010001\",\n" +
                "\t\t\"receiverBankName\": \"建设\",\n" +
                "\t\t\"receiverIdNumber\": \"12100010001\",\n" +
                "\t\t\"receiverSubBankName\": \"12100010001\"\n" +
                "\t},\n" +
                "\t\"contactInfo\": {\n" +
                "\t\t\"personName\": \"采购管理员\",\n" +
                "\t\t\"mobile\": \"12100010001\"\n" +
                "\t},\n" +
                "\t\"attachInfo\": [{\n" +
                "\t\t\"supplierCode\": \"\",\n" +
                "\t\t\"attachName\": \"采购合同.docx\",\n" +
                "\t\t\"attachPath\": \"https://cdn.oudianyun.com/trunk/opms/1542875824545_59.67477615635273_4bd714cf-7f6f-4008-924e-88e3581a9c7d.docx\"\n" +
                "\t}],\n" +
                "\t\"addressInfo\": {\n" +
                "\t\t\"provinceName\": \"北京\",\n" +
                "\t\t\"provinceId\": 2,\n" +
                "\t\t\"cityName\": \"北京市\",\n" +
                "\t\t\"cityId\": 37,\n" +
                "\t\t\"regionName\": \"东城区\",\n" +
                "\t\t\"regionId\": 410,\n" +
                "\t\t\"addressDetail\": \"北京东城\"\n" +
                "\t},\n" +
                "\t\"merchantId\": 2029080800000000,\n" +
                "\t\"merchantCode\": \"1\",\n" +
                "\t\"merchantName\": \"可口可乐\"\n" +
                "}");
        Object o = Ajax.post(driver, saveSupplierurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));

    }




}
