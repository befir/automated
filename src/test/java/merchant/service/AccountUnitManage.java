package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class AccountUnitManage extends RestfulAutomatedTest {
    String baseUrl = properties.getProperty("baseUrl");

    //查询核算组织
    private String queryAccountUnitServiceUrl = baseUrl+"/back-merchant-web/accountUnitAction/queryAccountUnitInfoPage.do";
    //新增核算组织
    private String addAccountUnitServiceUrl = baseUrl+"/back-merchant-web/accountUnitAction/addAccountUnitInfo.do";
    //修改核算组织信息
    private String updateAccountUnitServiceUrl = baseUrl+"/back-merchant-web/accountUnitAction/updateAccountUnitInfo.do";
    @Test
    public void queryAccountUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{unitCode: '', unitName: '', currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver,queryAccountUnitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryAccountUnitByOrgCode()  {
        JSONObject param = JSON.parseObject("{unitCode: '', unitName: '', currentPage: 1, itemsPerPage: 10}");
        param.put("unitCode","SJX0001");
        Object o = Ajax.post(driver,queryAccountUnitServiceUrl,param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
//        JSONObject expectedResult = JSON.parseObject("{\"gitVersion\":{\"git.branch\":\"back-merchant-web-d-2.3.15\",\"git.commit.id\":\"fcd288a5f29b4a62fc0b8beb4ab9549fee28c54e\"},\"data\":{\"total\":1,\"listObj\":[{\"id\":2029080803000006,\"unitName\":\"文心阁核算\",\"unitCode\":\"SJX0001\"}]},\"code\":\"0\"}");
        JSONObject expectedData = JSON.parseObject("{\"total\":1,\"listObj\":[{\"id\":2029080803000008,\"unitName\":\"文心阁核算\",\"unitCode\":\"SJX0001\"}]}");

        Assert.assertEquals(actualResult.get("data"),expectedData);
//        Assert.assertEquals(actualResult.get("data"),expectedResult.get("data"));
//        System.out.println(JSON.toJSONString(o));
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testException()  {
        throw  new RuntimeException("");
    }
    @Test
    public void addAccountUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{unitCode: '', unitName: '', unitDesc: ''}");
        param.put("unitCode",dateFormat.format(new Date()));
        param.put("unitName","文心阁"+dateFormat.format(new Date()));
        param.put("unitDesc","文心阁核算"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addAccountUnitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void updateAccountUnit() throws InterruptedException {
        JSONObject param = JSON.parseObject("{id: 2029081701000004, isDeleted: '', unitCode: '', unitName: '', unitDesc: ''}");
        param.put("unitCode",dateFormat.format(new Date()));
        param.put("unitName","文心阁组织"+dateFormat.format(new Date()));
        param.put("unitDesc","文心阁核算组织描述"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,updateAccountUnitServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
