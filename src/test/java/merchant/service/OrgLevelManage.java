package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class OrgLevelManage extends RestfulAutomatedTest {

    //查询组织层级
    private String queryOrgLevelServiceUrl = baseUrl+"/back-merchant-web/orgLevelAction/queryOrgLevelInfoList.do";
    //新增组织层级
    private String addOrgLevelServiceUrl = baseUrl+"/back-merchant-web/orgLevelAction/addOrgLevelInfo.do";
    @Test
    public void queryOrgLevel() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryOrgLevelServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addOrgLevel() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"parentLevelCode\":\"rootLevel\",\"levelCode\":\"\",\"levelName\":\"\"}");
        param.put("levelCode",dateFormat.format(new Date()));
        param.put("levelName","组织层级"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addOrgLevelServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
