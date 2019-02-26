package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class editMpConfig extends RestfulAutomatedTest {
    //全局变量
    private String merchantName = "P蒙牛商家";
    private String merchantId= "2029080800000000";
    private String companyId= "231";


 //接口
    private String editMpConfigurl = baseUrl+"opms-web/mpConfigAction/editMpConfig.do";
    private String saveSupplierurl = baseUrl+"opms-web/supplier/saveSupplier.do";
    private String editMpConfigServiceUrl = baseUrl+"";
    @Test
    public void editMpConfigInfo () throws InterruptedException {
        JSONArray editRegisterparam = JSON.parseArray("[{\"id\":1886081603000158,\"merchantName\":\"P蒙牛商家\",\"merchantCode\":\"CP1001\",\"storeName\":\"CP仓0002\",\"storeCode\":\"CP0002\",\"mpId\":1878080902001241,\"mpCode\":\"P181018018\",\"mpName\":\"花生糖\",\"mpBarcode\":\"181018018\",\"mpMeasureUnit\":\"件\",\"mpSpec\":null,\"mpType\":1,\"mpBrandCode\":null,\"mpBrandName\":\"P奈瑟\",\"mpConversionRate\":null,\"categoryCode\":null,\"categoryName\":\"其他\",\"purchaseMeasureUnit\":\"件\",\"purchaseStandardNum\":1,\"moqNum\":1,\"mpqNum\":1,\"safeStockNum\":10,\"maxStockNum\":100,\"minStockNum\":1,\"safeStockDays\":10,\"mpDistributionDays\":null,\"useType\":\"2\"}]");
        Thread.sleep(5000);
        Object o = Ajax.post(driver, editMpConfigurl, editRegisterparam);
        System.out.println(JSON.toJSONString(o));
        //JSONObject result = (JSONObject) JSON.toJSON(o);
       // orgId = result.getString("data");
        Thread.sleep(5000);
    }


    @Test
    public void saveSupplier() throws InterruptedException {
        JSONObject saveSupplierRegisterparam = JSON.parseObject("{\"merchantIds\":null,\"id\":11,\"supplierCode\":\"1886081603000000\",\"supplierName\":\"P蒙牛供应商\",\"supplierShortName\":null,\"supplierHelpCode\":null,\"supplierGlnCode\":null,\"userId\":1886080902000076,\"merchantId\":2029080902003362,\"merchantCode\":\"CP1001\",\"merchantName\":\"P蒙牛商家\",\"enterpriseCode\":null,\"enterpriseName\":null,\"enterpriseType\":null,\"enterpriseLicenseNumber\":\"X89955555\",\"enterpriseTaxPayerType\":1,\"enterpriseTaxRate\":18,\"enterpriseTaxCode\":null,\"enterpriseRegisteredCapital\":null,\"enterpriseBrandName\":null,\"enterpriseMajorBusiness\":null,\"cooperationMethod\":\"1\",\"status\":1,\"statusText\":\"启用\",\"wmsSendStatus\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080902000076,\"createUsername\":\"Yami\",\"createTime\":1540432734000,\"createTimeDb\":1540432586000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null,\"addressDetail\":null,\"createTimeStart\":null,\"createTimeEnd\":null,\"enterpriseTaxPayerTypeText\":\"一般纳税人\",\"enterpriseTypeText\":\"\",\"cooperationMethodText\":\"经销\",\"receiverAccountType\":null,\"receiverAccountTypeText\":null,\"receiverAccountNo\":null,\"receiverMobile\":null,\"receiverIdNumber\":null,\"receiverRealName\":null,\"receiverBankName\":null,\"receiverSubBankName\":null,\"provinceName\":null,\"cityName\":null,\"regionName\":null,\"personName\":null,\"positionName\":null,\"fixedTelephone\":null,\"mobile\":null,\"fax\":null,\"qq\":null,\"weixin\":null,\"postcode\":null,\"email\":null,\"contactPersonAddressDetail\":null,\"supplierCodeList\":null,\"attachInfo\":[{\"id\":3,\"supplierCode\":\"1886081603000000\",\"attachName\":\"12.jpg\",\"attachPath\":\"https://cdn.oudianyun.com/trunk/opms/1540432688871_67.53772113103736_94951b7c-fc89-4015-b26e-19f34fcf22b1.jpg\",\"effectiveTime\":null,\"expireTime\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080902000076,\"createUsername\":\"Yami\",\"createTime\":1540432734000,\"createTimeDb\":1540432586000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null}],\"contactInfo\":{\"id\":10,\"supplierCode\":\"1886081603000000\",\"userId\":null,\"userLoginName\":null,\"personName\":\"pyp\",\"positionName\":null,\"fixedTelephone\":null,\"mobile\":\"1387978888888\",\"fax\":null,\"qq\":null,\"weixin\":null,\"postcode\":null,\"email\":null,\"addressDetail\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080902000076,\"createUsername\":\"Yami\",\"createTime\":1540432734000,\"createTimeDb\":1540432586000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null},\"addressInfo\":{\"id\":10,\"supplierCode\":\"1886081603000000\",\"provinceId\":10,\"provinceName\":\"上海\",\"cityId\":110,\"cityName\":\"上海市\",\"regionId\":1140,\"regionName\":\"浦东新区\",\"addressDetail\":\"春晖路99号\",\"isDefault\":null,\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080902000076,\"createUsername\":\"Yami\",\"createTime\":1540432734000,\"createTimeDb\":1540432586000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null},\"accountInfo\":{\"id\":10,\"supplierCode\":\"1886081603000000\",\"receiverAccountType\":1,\"receiverAccountTypeText\":\"支付宝\",\"receiverAccountNo\":\"8956555555\",\"receiverMobile\":\"1379898888888\",\"receiverIdNumber\":\"3056565555555\",\"receiverRealName\":\"pyp\",\"receiverBankName\":\"中国银行\",\"receiverSubBankName\":\"张江支行\",\"remark\":null,\"companyId\":231,\"isDeleted\":0,\"versionNo\":0,\"createUserid\":1886080902000076,\"createUsername\":\"Yami\",\"createTime\":1540432734000,\"createTimeDb\":1540432586000,\"serverIp\":\"127.0.0.1\",\"updateUserid\":null,\"updateUsername\":null,\"updateTime\":null,\"updateTimeDb\":null},\"currentPage\":null,\"itemsPerPage\":null}");
        Thread.sleep(30000);

        Object o = Ajax.post(driver, saveSupplierurl, saveSupplierRegisterparam);
        System.out.println(JSON.toJSONString(o));
        //JSONObject result = (JSONObject) JSON.toJSON(o);
        // orgId = result.getString("data");
        Thread.sleep(5000);
    }



}
