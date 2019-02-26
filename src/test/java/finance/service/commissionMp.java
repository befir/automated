package finance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

//店中店管理
public class commissionMp extends RestfulAutomatedTest {
    //添加分销商品-查询商品
    private String goodsListUrl = baseUrl + "/agent-fx-web/commodity/goodsList.do";

    //添加分销商品-重置商品
    private String goodsUrl = baseUrl + "/agent-fx-web/commodity/goodsList.do";

    //添加分销商品
    private String addGoodsFilterUrl = baseUrl + "/agent-fx-web/commission/addGoodsFilter.do";

    //删除分销商品
    private String delGoodsFilterUrl = baseUrl + "/agent-fx-web/commission/delGoodsFilter.do";

    //修改商品范围
    private String updateInfoUrl = baseUrl + "/agent-fx-web/commission/updateInfo.do";

    //修改分销模式
    private String updateUrl = baseUrl + "/agent-fx-web/commission/updateInfo.do";

    //分销参数维护查询
    private String goods1Url = baseUrl + "/agent-fx-web/commodity/goodsList.do";

    //分销参数维护重置
    private String goodsList1Url = baseUrl + "/agent-fx-web/commodity/goodsList.do";

    //查询分销参数维护分佣设置
    private String getCommissionRuleUrl = baseUrl + "/agent-fx-web/commissionParam/getCommissionRule.do";

    //分销参数维护分佣设置
    private String addOrUpdateCommissionParamsUrl = baseUrl + "/agent-fx-web/commissionParam/addOrUpdateCommissionParams.do";

    //分销模式列表编辑
    private String updateInfo1Url = baseUrl + "/agent-fx-web/commission/updateInfo.do";

    //添加分销商品-查询商品
    @Test
    public void goodsList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"pageIndex\":1,\"pageSize\":10}");
        Object o = Ajax.post(driver, goodsListUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //添加分销商品-重置商品
    @Test
    public void goods() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"pageIndex\":1,\"pageSize\":10}");
        Object o = Ajax.post(driver, goodsUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //添加分销商品
    @Test
    public void addGoodsFilter() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"filters\":[{\"type\":3,\"typeId\":null,\"dimension\":1,\"key\":1878082801000382,\"logic\":1,\"name\":\"B0001\",\"storeId\":6,\"channelName\":\"欧电云自建BBC\",\"channelCode\":\"110001\",\"storeName\":\"欧乐便利金客隆店\",\"secondName\":\"B0001\",\"englishName\":\"七匹狼\"}]}");
        Object o = Ajax.post(driver, addGoodsFilterUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //删除分销商品
    @Test
    public void delGoodsFilter() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"filterIds\":[259]}");
        Object o = Ajax.post(driver, delGoodsFilterUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //修改商品范围
    @Test
    public void updateInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"isAvailable\":1,\"isDeleted\":0,\"versionNo\":56,\"companyId\":231,\"createUsername\":\"管理员\",\"createTime\":1539594963000,\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1542091001000,\"id\":1,\"name\":\"123\",\"defaultParentName\":\"欧电云服装商城\",\"series\":1,\"baseType\":1,\"mpRange\":\"1\",\"commissionConfigure\":3,\"company_id\":231,\"is_available\":1,\"is_deleted\":0,\"version_no\":56,\"create_username\":\"管理员\",\"create_time\":1539594963000,\"update_userid\":18101517160196,\"update_username\":\"superadmin\",\"update_time\":1542091001000}");
        Object o = Ajax.post(driver, updateInfoUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //修改分销模式
    @Test
    public void update() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"isAvailable\":1,\"isDeleted\":0,\"versionNo\":61,\"companyId\":231,\"createUsername\":\"管理员\",\"createTime\":1539594963000,\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1542783242000,\"id\":1,\"name\":\"123\",\"defaultParentName\":\"欧电云服装商城\",\"series\":1,\"baseType\":1,\"commissionConfigure\":3,\"dimensionRules\":[2,2,3,5,6],\"pointRules\":[2,3,4,5,6],\"incomeRateRules\":[2,3,4,5,6],\"bonusRules\":[2,3,4,5,6],\"values\":[],\"mpRange\":1,\"proxys\":[],\"commission\":{},\"company_id\":231,\"is_available\":1,\"is_deleted\":0,\"version_no\":61,\"create_username\":\"管理员\",\"create_time\":1539594963000,\"update_userid\":18101517160196,\"update_username\":\"superadmin\",\"update_time\":1542783242000}");
        Object o = Ajax.post(driver, updateUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //分销参数维护查询
    @Test
    public void goods1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"pageIndex\":1,\"pageSize\":10,\"name\":\"\",\"saleType\":-1,\"status\":-1,\"goodsSource\":-1,\"managementState\":-1}");
        Object o = Ajax.post(driver, goods1Url, param);
        System.out.println(JSON.toJSONString(o));
    }

    //分销参数维护重置
    @Test
    public void goodsList1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"pageIndex\":1,\"pageSize\":10,\"name\":\"\",\"saleType\":-1,\"status\":-1,\"goodsSource\":-1,\"managementState\":-1}");
        Object o = Ajax.post(driver, goodsList1Url, param);
        System.out.println(JSON.toJSONString(o));
    }

    //查询分销参数维护分佣设置
    @Test
    public void getCommissionRule() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"referIds\":[1878082801000382],\"referCommission\":1,\"commissionType\":2}");
        Object o = Ajax.post(driver, getCommissionRuleUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //分销参数维护分佣设置
    @Test
    public void addOrUpdateCommissionParams() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\"commissionId\":1,\"commissionParams\":[{\"id\":111841269,\"ruleValue\":1,\"level\":1}],\"commissionRule\":1,\"commissionType\":2,\"referIds\":[1878082801000382],\"proxys\":[],\"point\":null,\"incomeRate\":null}]");
        Object o = Ajax.post(driver, addOrUpdateCommissionParamsUrl, param);
        System.out.println(JSON.toJSONString(o));
    }

    //分销参数维护分佣设置
    @Test
    public void updateInfo1() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"isAvailable\":1,\"isDeleted\":0,\"versionNo\":62,\"companyId\":231,\"createUsername\":\"管理员\",\"createTime\":1539594963000,\"updateUserid\":18101517160196,\"updateUsername\":\"superadmin\",\"updateTime\":1542783819000,\"id\":1,\"name\":\"123\",\"defaultParentName\":\"欧电云服装商城\",\"series\":1,\"baseType\":1,\"commissionConfigure\":3,\"dimensionRules\":[2,2,3,5,6],\"pointRules\":[2,3,4,5,6],\"incomeRateRules\":[2,3,4,5,6],\"bonusRules\":[2,3,4,5,6],\"values\":[],\"mpRange\":1,\"proxys\":[],\"commission\":{},\"company_id\":231,\"is_available\":1,\"is_deleted\":0,\"version_no\":62,\"create_username\":\"管理员\",\"create_time\":1539594963000,\"update_userid\":18101517160196,\"update_username\":\"superadmin\",\"update_time\":1542783819000}");
        Object o = Ajax.post(driver, updateInfo1Url, param);
        System.out.println(JSON.toJSONString(o));
    }
}