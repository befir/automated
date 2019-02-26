package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class StoreOrgManage extends RestfulAutomatedTest {

    //查询店铺组织
    private String queryStoreOrgServiceUrl = baseUrl+"/back-merchant-web/storeAction/queryStoreInfoList.do";
    //新增店铺组织
    private String addStoreOrgServiceUrl = baseUrl+"/back-merchant-web/storeAction/addStoreOrgInfo.do";
    //获取店铺组织详情信息
    private String queryStoreServiceUrl = baseUrl+"/back-merchant-web/storeAction/queryStoreInfo.do";
    //修改店铺组织详情信息
    private String editStoreServiceUrl = baseUrl+"/back-merchant-web/storeAction/updateStoreInfo.do";
    //编辑配送范围
    private String updateStoreCoverageServiceUrl = baseUrl+"/back-merchant-web/storeCoverageAction/updateStoreCoverageInfo.do";
    //编辑营业时间
    private String updateStoreTimeUrl = baseUrl+"/back-merchant-web/storeCalendarAction/updateStoreBusinessTime.do";
    //编辑配送时间
    private String updateStoreDistributionTimeUrl = baseUrl+"/back-merchant-web/storeCalendarAction/updateStoreDistributionTime.do";
    //新增地址信息
    private String addAddressUrl = baseUrl+"/back-merchant-web/merchantOrgAddress/addMerchantOrgAddress.do";
    //修改地址信息
    private String editAddressUrl = baseUrl+"/back-merchant-web/merchantOrgAddress/updateMerchantOrgAddressById.do";
    @Test
    public void queryStoreOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{storeOnlineType: \"\", orgType: \"\", storeStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryStoreOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryStoreOrgByOrgCode() throws InterruptedException {
        JSONObject param = JSON.parseObject("{storeOnlineType: \"\", orgType: \"\", storeStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        param.put("orgCode","11");
        Object o = Ajax.post(driver,queryStoreOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addStoreOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{orgSubType: 1, orgType: 2, storeOnlineType: 1, merchantId: 2029080800000000, orgCode: '', orgName: '', channelCode: 110002}");
        param.put("orgCode",dateFormat.format(new Date()));
        param.put("orgName","屈臣氏店铺"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addStoreOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryStore() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"\",\"id\":\"\"}");
        param.put("orgId","2029080902000011");
        param.put("id","2029080902000011");
        Object o = Ajax.post(driver,queryStoreServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editStore() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"isDeleted\":\"\",\"companyId\":\"\",\"orgId\":\"\",\"orgCode\":\"\",\"orgName\":\"\",\"orgType\":null,\"auditStatus\":null,\"accountingUnitId\":null,\"storeType\":null,\"logoUrl\":null,\"staffNums\":null,\"countryCode\":null,\"countryName\":null,\"provinceCode\":null,\"provinceName\":null,\"cityCode\":null,\"cityName\":null,\"regionCode\":null,\"regionName\":null,\"detailAddress\":null,\"desc\":null,\"shotDesc\":null,\"businessState\":null,\"businessLicenseUrl\":null,\"signUrl\":null,\"longitude\":121.586855,\"latitude\":31.201593,\"merchantId\":\"2029080800000000\",\"serviceType\":null,\"status\":null,\"selfCreateCategory\":null,\"storeStatus\":\"1\",\"storeOnlineType\":\"0\",\"mobileNo\":null,\"email\":null,\"contactName\":null,\"shortDesc\":null,\"entryTermsId\":null,\"storageCapacity\":null,\"storageCapacityUnits\":null,\"businessArea\":null,\"businessAreaUnits\":null,\"parentOrgName\":null,\"createDate\":null,\"inventoryType\":null,\"channelCode\":null,\"channelMode\":null,\"storeId\":2029080902000011,\"warehouseId\":null,\"warehouseName\":null,\"merchantName\":\"\"}");
        param.put("id","2029080902000011");
        param.put("isDeleted","");
        param.put("companyId","");
        param.put("orgId","2029080902000011");
        param.put("orgCode","15");
        param.put("orgName","可口可乐线上O2O");
        param.put("orgType","");
        param.put("auditStatus","");
        param.put("accountingUnitId","");
        param.put("storeType","");
        param.put("logoUrl","");
        param.put("staffNums","");
        param.put("countryCode","");
        param.put("countryName","");
        param.put("provinceCode","");
        param.put("provinceName","");
        param.put("cityCode","");
        param.put("cityName","");
        param.put("regionCode","");
        param.put("regionName","");
        param.put("detailAddress","");
        param.put("desc","");
        param.put("longitude","121.586855");
        param.put("latitude","31.201593");
        param.put("merchantId","121.2029080800000000");
        param.put("entryTermsId","");
        param.put("storageCapacity","");
        param.put("storageCapacityUnits","");
        param.put("businessArea","");
        param.put("businessAreaUnits","");
        param.put("parentOrgName","");
        param.put("createDate","");
        param.put("inventoryType","");
        param.put("channelCode","");
        param.put("channelMode","");
        param.put("storeId","2029080902000011");
        param.put("warehouseId","");
        param.put("warehouseName","");
        param.put("merchantName","可口可乐线");

        Object o = Ajax.post(driver,editStoreServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateStoreCoverage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"\",\"coverageMapVO\":{\"id\":null,\"orgId\":\"\",\"pois\":[{\"id\":null,\"storeCoverageId\":null,\"name\":null,\"poi\":\"[{\\\"lng\\\":107.087823,\\\"lat\\\":42.673795},{\\\"lng\\\":122.029229,\\\"lat\\\":54.565248},{\\\"lng\\\":136.26751,\\\"lat\\\":48.333833},{\\\"lng\\\":130.994073,\\\"lat\\\":42.024244},{\\\"lng\\\":124.138604,\\\"lat\\\":39.494971},{\\\"lng\\\":122.732354,\\\"lat\\\":22.095109},{\\\"lng\\\":112.36126,\\\"lat\\\":3.852528},{\\\"lng\\\":108.318292,\\\"lat\\\":20.786213},{\\\"lng\\\":99.529229,\\\"lat\\\":21.114534},{\\\"lng\\\":95.837823,\\\"lat\\\":26.105432},{\\\"lng\\\":79.314385,\\\"lat\\\":30.134963},{\\\"lng\\\":72.634698,\\\"lat\\\":39.359192},{\\\"lng\\\":86.872979,\\\"lat\\\":49.943657}]\",\"maxX\":null,\"maxY\":null,\"minX\":null,\"minY\":null}]}}");
        param.put("orgId","2029080902000011");
        param.put("orgId","2029080902000011");
        Object o = Ajax.post(driver,updateStoreCoverageServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateStoreTime() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"\",\"timeType\":1,\"businessDays\":[{\"id\":2029081900000253,\"isDeleted\":null,\"orgId\":\"\",\"week\":1,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000254,\"isDeleted\":null,\"storeCalendarId\":2029081900000253,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000255,\"isDeleted\":null,\"orgId\":\"\",\"week\":2,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000256,\"isDeleted\":null,\"storeCalendarId\":2029081900000255,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000257,\"isDeleted\":null,\"orgId\":\"\",\"week\":3,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000258,\"isDeleted\":null,\"storeCalendarId\":2029081900000257,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000259,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":4,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000260,\"isDeleted\":null,\"storeCalendarId\":2029081900000259,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000261,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":5,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000262,\"isDeleted\":null,\"storeCalendarId\":2029081900000261,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000263,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":6,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000264,\"isDeleted\":null,\"storeCalendarId\":2029081900000263,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000265,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":7,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000266,\"isDeleted\":null,\"storeCalendarId\":2029081900000265,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]}],\"businessState\":0}");
        param.put("orgId","2029080902000011");
        param.put("orgId","2029080902000011");
        Object o = Ajax.post(driver,updateStoreTimeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateStoreDistributionTime() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"\",\"timeType\":2,\"businessDays\":[{\"id\":2029081900000253,\"isDeleted\":null,\"orgId\":\"\",\"week\":1,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000254,\"isDeleted\":null,\"storeCalendarId\":2029081900000253,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000255,\"isDeleted\":null,\"orgId\":\"\",\"week\":2,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000256,\"isDeleted\":null,\"storeCalendarId\":2029081900000255,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000257,\"isDeleted\":null,\"orgId\":\"\",\"week\":3,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000258,\"isDeleted\":null,\"storeCalendarId\":2029081900000257,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000259,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":4,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000260,\"isDeleted\":null,\"storeCalendarId\":2029081900000259,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000261,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":5,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000262,\"isDeleted\":null,\"storeCalendarId\":2029081900000261,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000263,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":6,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000264,\"isDeleted\":null,\"storeCalendarId\":2029081900000263,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000265,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":7,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000266,\"isDeleted\":null,\"storeCalendarId\":2029081900000265,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]}],\"businessState\":0}");
        param.put("orgId","2029080902000011");
        param.put("orgId","2029080902000011");
        Object o = Ajax.post(driver,updateStoreDistributionTimeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addAddress() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"isDefault\":0,\"contactPerson\":\"\",\"contactTelephone\":\"\",\"postCode\":\"\",\"detailAddress\":\"\",\"provinceCode\":\"\",\"cityCode\":\"\",\"regionCode\":\"\",\"remark\":\"\",\"orgId\":\"\",\"addressType\":1}");
        param.put("orgId","2029080902000011");
        param.put("isDefault",0);
        param.put("addressType",1);
        param.put("contactPerson","楚阳");
        param.put("contactTelephone","15801904143");
        param.put("postCode","342800");
        param.put("provinceCode",310000);
        param.put("cityCode",310100);
        param.put("regionCode",310115);
        param.put("detailAddress","张江");
        param.put("remark","地址信息备注");
        Object o = Ajax.post(driver,addAddressUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editAddress() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"orgType\":null,\"orgId\":\"\",\"addressType\":1,\"contactPerson\":\"\",\"contactTelephone\":\"\",\"postCode\":\"\",\"countryCode\":null,\"countryName\":null,\"provinceCode\":\"\",\"provinceName\":null,\"cityCode\":\"\",\"cityName\":null,\"regionCode\":\"\",\"regionName\":null,\"detailAddress\":\"\",\"isDefault\":0,\"remark\":\"\"}");
        param.put("id","2029082700000046");
        param.put("orgId","2029080902000011");
        param.put("isDefault",0);
        param.put("addressType",1);
        param.put("contactPerson","楚阳");
        param.put("contactTelephone","15801904143");
        param.put("postCode","342800");
        param.put("provinceCode",310000);
        param.put("cityCode",310100);
        param.put("regionCode",310115);
        param.put("detailAddress","张江");
        param.put("remark","地址信息备注");
        Object o = Ajax.post(driver,editAddressUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
