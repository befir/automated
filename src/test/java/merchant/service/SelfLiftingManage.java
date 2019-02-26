package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class SelfLiftingManage extends RestfulAutomatedTest {

    //查询自提点
    private String querySelfLiftingServiceUrl = baseUrl+"/back-merchant-web/slefLifting/queryList.do";
    //新增自提点
    private String addSelfLiftingServiceUrl = baseUrl+"/back-merchant-web/slefLifting/add.do";
    //获取自提点信息
    private String getSlefLiftingServiceUrl = baseUrl+"/back-merchant-web/slefLifting/getSlefLiftingById.do";
    //编辑自提点基本信息
    private String editSelfLiftingServiceUrl = baseUrl+"/back-merchant-web/slefLifting/update.do";
    //修改自提点营业时间
    private String editStoreBusinessTimeUrl = baseUrl+"/back-merchant-web/storeCalendarAction/updateStoreBusinessTime.do";
    @Test
    public void querySelfLifting() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":0,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,querySelfLiftingServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addSelfLifting() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"thirdparty\":\"\",\"name\":\"\",\"code\":\"\",\"type\":\"\",\"attribute\":\"\"}");
        param.put("code", dateFormat.format(new Date()));
        param.put("name", "文心阁自提点" + dateFormat.format(new Date()));
        param.put("type", 1);//自提点类型：1：自提点  2：自提柜
        param.put("attribute", 2);//自提点属性：1：自营  2：第三方
        param.put("thirdparty", 1);//第三方自提点：只有自提点属性为2时才需要输入1：丰巢  2：顺丰
        Object o = Ajax.post(driver, addSelfLiftingServiceUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getSelfLifting() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\"}");
        param.put("id", "2029081300000080");
        Object o = Ajax.post(driver, getSlefLiftingServiceUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editSelfLifting() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"isDeleted\":0,\"name\":\"\",\"code\":\"\",\"attribute\":2,\"thirdparty\":\"1\",\"type\":1,\"status\":0,\"capacityNum\":\"\",\"capacityWeight\":\"\",\"freshNum\":null,\"generalNum\":null,\"address\":null,\"longitude\":null,\"latitude\":null,\"currentPage\":0,\"itemsPerPage\":0,\"startItem\":0}");
        param.put("id", "2029081300000080");
        param.put("name", "屈臣氏自提点");
        param.put("code", "QCS001");
        param.put("capacityNum", 100);
        param.put("capacityWeight", 100);
        Object o = Ajax.post(driver, editSelfLiftingServiceUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editStoreBusinessTime() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"orgId\":\"\",\"timeType\":1,\"businessDays\":[{\"id\":\"\",\"isDeleted\":null,\"orgId\":\"\",\"week\":1,\"timeType\":1,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081300000082,\"isDeleted\":null,\"storeCalendarId\":2029081300000081,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081300000083,\"isDeleted\":null,\"orgId\":2029081300000080,\"week\":2,\"timeType\":1,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081300000084,\"isDeleted\":null,\"storeCalendarId\":2029081300000083,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081300000085,\"isDeleted\":null,\"orgId\":2029081300000080,\"week\":3,\"timeType\":1,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081300000086,\"isDeleted\":null,\"storeCalendarId\":2029081300000085,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081300000087,\"isDeleted\":null,\"orgId\":2029081300000080,\"week\":4,\"timeType\":1,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081300000088,\"isDeleted\":null,\"storeCalendarId\":2029081300000087,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081300000089,\"isDeleted\":null,\"orgId\":2029081300000080,\"week\":5,\"timeType\":1,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081300000090,\"isDeleted\":null,\"storeCalendarId\":2029081300000089,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081300000091,\"isDeleted\":null,\"orgId\":2029081300000080,\"week\":6,\"timeType\":1,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081300000092,\"isDeleted\":null,\"storeCalendarId\":2029081300000091,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]},{\"id\":2029081300000093,\"isDeleted\":null,\"orgId\":2029081300000080,\"week\":7,\"timeType\":1,\"type\":1,\"cutTime\":null,\"businessState\":null,\"storeCalendarItemsPOS\":[{\"id\":2029081300000094,\"isDeleted\":null,\"storeCalendarId\":2029081300000093,\"beginDate\":\"08:00:00\",\"endDate\":\"18:00:00\"}]}],\"businessSwitch\":false,\"businessState\":0}");
        param.put("id","2029081300000081");
        param.put("orgId","2029081300000080");
        Object o = Ajax.post(driver,editStoreBusinessTimeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
