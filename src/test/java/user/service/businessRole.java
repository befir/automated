package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class businessRole extends RestfulAutomatedTest {
    private String queryPlatformListUrl = baseUrl+"/ouser-web/platform/queryPlatformList.do";
    //请求身份信息
    private String queryIdentityInfoUrl = baseUrl+"/ouser-web/employee/queryIdentityInfo.do";
    //请求员工身份信息
    private String queryEmployeeIdentityUrl = baseUrl+"/ouser-web/employee/queryEmployeeIdentity.do";
    //请求所有角色数据
    private String queryAllRoleDataPageUrl = baseUrl+"/ouser-web/role/queryAllRoleDataPage.do";
    //请求角色功能
    private String getAllRoleFunctionByPlatformUrl = baseUrl+"/ouser-web/function/getAllRoleFunctionByPlatform.do";
    //请求渠道
    private String queryChannelUrl = baseUrl+"/ouser-web/platform/queryChannel.do";
    //请求菜单树
    private String queryMenuTreeUrl = baseUrl+"/ouser-web/platform/queryMenuTree.do";
    //请求新增角色名称
    private String queryRoleNameForAddUrl = baseUrl+"/ouser-web/role/queryRoleNameForAdd.do";
    //保存角色
    private String saveRoleUrl = baseUrl+"/ouser-web/role/saveRole.do";
    //删除角色
    private String deleteRoleUrl = baseUrl+"/ouser-web/role/deleteRole.do";
    @Test
    public void queryPlatformList() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryPlatformListUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryIdentityInfo() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryIdentityInfoUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryEmployeeIdentity() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryEmployeeIdentityUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryAllRoleDataPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"platformIds\": [2, 4, 5],\n" +
                "\t\"currentPage\": 1,\n" +
                "\t\"itemsPerPage\": 10,\n" +
                "\t\"platformId\": \"2\",\n" +
                "\t\"entityType\": \"2\",\n" +
                "\t\"roleIdList\": [2029080800003446]\n" +
                "}");
        Object o = Ajax.post(driver,queryAllRoleDataPageUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getAllRoleFunctionByPlatform() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"platformId\": 2\n" +
                "}");
        Object o = Ajax.post(driver,getAllRoleFunctionByPlatformUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryChannel() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"platformId\": 2\n" +
                "}");
        Object o = Ajax.post(driver,queryChannelUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryMenuTree() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"platformId\": 1,\n" +
                "\t\"channelCode\": \"000000\"\n" +
                "}");
        Object o = Ajax.post(driver,queryMenuTreeUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void queryRoleNameForAdd() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"name\": \"测试\",\n" +
                "\t\"entityType\": \"2\",\n" +
                "\t\"entityId\": 2029080800003446\n" +
                "}");
        Object o = Ajax.post(driver,queryRoleNameForAddUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void saveRole() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"entityId\": 2029080800003446,\n" +
                "\t\"desc\": \"\",\n" +
                "\t\"name\": \"测试\",\n" +
                "\t\"code\": \"111401\",\n" +
                "\t\"functionIds\": [\"1810161619553\", \"1018012600003161670\", \"1018012600003161671\", \"1018012600003161672\", \"1018012600003161673\", \"1018012600003161674\", \"1018012600003161675\", \"1018012600003161676\", \"1018012600003161678\", \"1018012600003161679\", \"1018012600003161680\", \"1018012600003161681\", \"1018012600003161682\", \"1018012600003161683\", \"1018012600003161684\", \"1018012600003161685\", \"1018012600003161686\", \"1018012600003161687\", \"1018012600003161688\", \"1018012600003161689\", \"1018012600003161690\", \"1018012600003161693\", \"1018012600003161694\", \"1018012600003161695\", \"1018012600003161692\", \"1018012600003161696\", \"1018012600003161698\", \"1018012600003161699\", \"1018012600003161700\", \"1018012600003161701\", \"1018012600003161703\", \"1018012600003161706\", \"1018012600003161707\", \"1018012600003161709\", \"1018012600003161718\", \"1018012600003161730\", \"1018012600003161704\", \"1018012600003161705\", \"1018012600003161712\", \"1018012600003161719\", \"1018012600003161713\", \"1018012600003161720\", \"1018012600003161721\", \"1018012600003161722\", \"1018012600003161723\", \"1018012600003161724\", \"1018012600003161725\", \"1018012600003161714\", \"1018012600003161727\", \"1018012600003161715\", \"1018012600003161728\", \"1018012600003161708\", \"1018012600003161710\", \"1018012600003161716\", \"1018012600003161717\", \"1018012600003161729\", \"1018012600003161711\", \"1018012600003161726\", \"1018012600003161779\", \"1018012600003161731\", \"1018012600003161732\", \"1018012600003161733\", \"1018012600003161734\", \"1018012600003161735\", \"1018012600003161780\", \"1018012600003161778\", \"1810161619541\", \"1810161619540\"],\n" +
                "\t\"platformId\": 4,\n" +
                "\t\"entityType\": \"2\"\n" +
                "}");
        Object o = Ajax.post(driver,saveRoleUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void deleteRole() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\n" +
                "\t\"id\": 1886083601000116\n" +
                "}");
        Object o = Ajax.post(driver,deleteRoleUrl,param);
        System.out.println(JSON.toJSONString(o));
    }

}
