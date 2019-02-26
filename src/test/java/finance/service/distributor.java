package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

//店中店管理
public class distributor extends RestfulAutomatedTest {
    //消费商列表查询
    private String list3Url = baseUrl + "/agent-fx-web/distributor/list.do";

    //消费商列表重置
    private String list2Url = baseUrl + "/agent-fx-web/distributor/list.do";

    //编辑消费商列表-查询上级消费商
    private String parentUrl = baseUrl + "/agent-fx-web/distributor/parentList.do";

    //编辑消费商列表
    private String updateUrl = baseUrl + "/agent-fx-web/distributor/update.do";

    //停用消费商
    private String update1Url = baseUrl + "/agent-fx-web/distributor/update.do";

    //启用消费商
    private String update2Url = baseUrl + "/agent-fx-web/distributor/update.do";


    //消费商列表查询
    @Test
    public void list3() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"type\":2,\"parentId\":null}");
        Object o = Ajax.post(driver, list3Url, param);
        System.out.println(JSON.toJSONString(o));
    }

    //消费商列表重置
    @Test
    public void list2() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"type\":2,\"parentId\":null}");
        Object o = Ajax.post(driver, list2Url, param);
        System.out.println(JSON.toJSONString(o));
    }

    //编辑消费商列表-查询上级消费商
    @Test
    public void parent() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"path\":\"/1046014700020517/1046014700020516/\"}");
        Object o = Ajax.post(driver, parentUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //编辑消费商列表
    @Test
    public void update() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"isAvailable\":1,\"isDeleted\":0,\"versionNo\":1,\"companyId\":231,\"createTime\":\"2018-10-17\",\"updateTime\":1539761000000,\"currentPage\":0,\"itemsPerPage\":10,\"id\":1046014700020516,\"userId\":1886080801000009,\"userName\":\"12345678901\",\"commissionId\":1,\"commissionName\":\"123\",\"path\":\"/1046014700020517/1046014700020516/\",\"parentId\":1046014700020517,\"currentdateChildNum\":0,\"childNum\":0,\"status\":1,\"level\":2,\"registrationTime\":1539761142000,\"type\":2,\"consumeStatus\":1,\"mobile\":\"12345678901\",\"isNotCommission\":false,\"commissionStatus\":1,\"bonusStatus\":1,\"statusStr\":\"正常\",\"notCommission\":false,\"bonusStatusStr\":\"正常\",\"commissionStatusStr\":\"正常\",\"typeStr\":\"分销商\",\"limitClauseStart\":0,\"limitClauseCount\":10,\"company_id\":231,\"create_time\":1542701992605,\"update_time\":1542701992605}");
        Object o = Ajax.post(driver, updateUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //停用消费商列表
    @Test
    public void update1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1046014700020516,\"commissionStatus\":0,\"bonusStatus\":1,\"status\":0}");
        Object o = Ajax.post(driver, update1Url, param);
        System.out.println(JSON.toJSONString(o));
    }

    //启用消费商列表
    @Test
    public void update2() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":1046014700020516,\"commissionStatus\":1,\"bonusStatus\":1,\"status\":1}");
        Object o = Ajax.post(driver, update2Url, param);
        System.out.println(JSON.toJSONString(o));
    }
}