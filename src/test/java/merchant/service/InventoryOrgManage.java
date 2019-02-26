package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class InventoryOrgManage extends RestfulAutomatedTest {

    //查询库存组织
    private String queryInventoryOrgServiceUrl = baseUrl+"/back-merchant-web/inventoryAction/queryInventoryInfoList.do";
    //新增库存组织
    private String addInventoryOrgServiceUrl = baseUrl+"/back-merchant-web/inventoryAction/addInventoryOrgInfo.do";
    //获取库存组织详情页面信息
    private String queryInventoryServiceUrl = baseUrl+"/back-merchant-web/inventoryAction/queryInventoryInfo.do";
    //编辑库存组织基本信息
    private String editInventoryOrgServiceUrl = baseUrl+"/back-merchant-web/inventoryAction/updateInventoryInfo.do";
    //编辑配送范围
    private String updateStoreCoverageServiceUrl = baseUrl+"/back-merchant-web/storeCoverageAction/updateStoreCoverageInfo.do";
    //编辑配送时间
    private String updateStoreDistributionTime = baseUrl+"/back-merchant-web/storeCalendarAction/updateStoreDistributionTime.do";
    @Test
    public void queryInventoryOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{status: \"\", merchantId: \"\", merchantIds: [\"2029080800000000\"], currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryInventoryOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addInventoryOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{orgType: 3, orgSubType: 31, merchantId: '', orgCode: '', orgName: ''}");
        param.put("merchantId","2029080800000000");
        param.put("orgCode",dateFormat.format(new Date()));
        param.put("orgName","屈臣氏库存组织"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addInventoryOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryInventory() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgName\":\"\",\"contactMobileNo\":\"\",\"mobileNo\":\"\",\"contactName\":\"\",\"parentOrgName\":\"\",\"email\":\"\",\"orgId\":\"\",\"orgCode\":\"\",\"status\":\"\",\"inventoryType\":\"\",\"countryCode\":null,\"countryName\":null,\"provinceCode\":310000,\"provinceName\":null,\"cityCode\":310100,\"cityName\":null,\"regionCode\":310115,\"regionName\":null,\"detailAddress\":\"\",\"desc\":\"\",\"longitude\":\"\",\"latitude\":\"\",\"merchantId\":\"\",\"createDate\":null,\"id\":\"2029081900000002\"}");
        param.put("id","2029081900000002");
        param.put("merchantId","2029080800000000");
        param.put("parentOrgName","可口可乐");
        param.put("orgId","2029081900000002");
        param.put("orgCode","20181028102530");
        param.put("orgName","屈臣氏库存组织20181028102530");
        param.put("mobileNo","15801904143");
        param.put("contactName","楚阳");
        param.put("email","15801904143@qq.com");
        param.put("status",1);
        param.put("inventoryType",21);
        param.put("detailAddress","张江");
        param.put("desc","屈臣氏库存组织描述"+dateFormat.format(new Date()));
        param.put("longitude","121.586855");
        param.put("latitude","31.201593");
        Object o = Ajax.post(driver,queryInventoryServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editInventoryOrg() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgName\":\"\",\"contactMobileNo\":\"\",\"mobileNo\":\"\",\"contactName\":\"\",\"parentOrgName\":\"\",\"email\":\"\",\"orgId\":\"\",\"orgCode\":\"\",\"status\":\"\",\"inventoryType\":\"\",\"countryCode\":null,\"countryName\":null,\"provinceCode\":310000,\"provinceName\":null,\"cityCode\":310100,\"cityName\":null,\"regionCode\":310115,\"regionName\":null,\"detailAddress\":\"\",\"desc\":\"\",\"longitude\":\"\",\"latitude\":\"\",\"merchantId\":\"\",\"createDate\":null}");
        param.put("merchantId","2029080800000000");
        param.put("parentOrgName","可口可乐");
        param.put("orgId","2029081900000002");
        param.put("orgCode","20181028102530");
        param.put("orgName","屈臣氏库存组织20181028102530");
        param.put("mobileNo","15801904143");
        param.put("contactName","楚阳");
        param.put("email","15801904143@qq.com");
        param.put("status",1);
        param.put("inventoryType",21);
        param.put("detailAddress","张江");
        param.put("desc","屈臣氏库存组织描述"+dateFormat.format(new Date()));
        param.put("longitude","121.586855");
        param.put("latitude","31.201593");
        Object o = Ajax.post(driver,editInventoryOrgServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateStoreCoverage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"\",\"coverageMapVO\":{\"id\":null,\"orgId\":\"\",\"pois\":[{\"id\":null,\"storeCoverageId\":null,\"name\":null,\"poi\":\"[{\\\"lng\\\":107.087823,\\\"lat\\\":42.673795},{\\\"lng\\\":122.029229,\\\"lat\\\":54.565248},{\\\"lng\\\":136.26751,\\\"lat\\\":48.333833},{\\\"lng\\\":130.994073,\\\"lat\\\":42.024244},{\\\"lng\\\":124.138604,\\\"lat\\\":39.494971},{\\\"lng\\\":122.732354,\\\"lat\\\":22.095109},{\\\"lng\\\":112.36126,\\\"lat\\\":3.852528},{\\\"lng\\\":108.318292,\\\"lat\\\":20.786213},{\\\"lng\\\":99.529229,\\\"lat\\\":21.114534},{\\\"lng\\\":95.837823,\\\"lat\\\":26.105432},{\\\"lng\\\":79.314385,\\\"lat\\\":30.134963},{\\\"lng\\\":72.634698,\\\"lat\\\":39.359192},{\\\"lng\\\":86.872979,\\\"lat\\\":49.943657}]\",\"maxX\":null,\"maxY\":null,\"minX\":null,\"minY\":null}]}}");
        param.put("orgId","2029081900000002");
        param.put("orgId","2029081900000002");
        Object o = Ajax.post(driver,updateStoreCoverageServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateStoreDistributionTime() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"\",\"timeType\":2,\"businessDays\":[{\"id\":2029081900000253,\"isDeleted\":null,\"orgId\":\"\",\"week\":1,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000254,\"isDeleted\":null,\"storeCalendarId\":2029081900000253,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000255,\"isDeleted\":null,\"orgId\":\"\",\"week\":2,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000256,\"isDeleted\":null,\"storeCalendarId\":2029081900000255,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000257,\"isDeleted\":null,\"orgId\":\"\",\"week\":3,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000258,\"isDeleted\":null,\"storeCalendarId\":2029081900000257,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000259,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":4,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000260,\"isDeleted\":null,\"storeCalendarId\":2029081900000259,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000261,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":5,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000262,\"isDeleted\":null,\"storeCalendarId\":2029081900000261,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000263,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":6,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000264,\"isDeleted\":null,\"storeCalendarId\":2029081900000263,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081900000265,\"isDeleted\":null,\"orgId\":2029081900000002,\"week\":7,\"timeType\":2,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081900000266,\"isDeleted\":null,\"storeCalendarId\":2029081900000265,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]}],\"businessState\":0}");
        param.put("orgId","2029081900000002");
        param.put("orgId","2029081900000002");
        Object o = Ajax.post(driver,updateStoreDistributionTime,param);
        System.out.println(JSON.toJSONString(o));
    }
}
