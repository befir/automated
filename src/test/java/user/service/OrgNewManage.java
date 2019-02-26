package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class OrgNewManage extends RestfulAutomatedTest {

    //查询部门
    private String queryOrgNewServiceUrl = baseUrl+"/ouser-web/org/getCurrentOrg.do";
    //新增部门
    private String addOrgNewServiceUrl = baseUrl+"/ouser-web/org/addOneOrg.do";
    //查询单个部门的信息
    private String getOrgNewServiceUrl = baseUrl+"/ouser-web/org/getDepartmentInfoById.do";
    //编辑部门
    private String editOrgNewServiceUrl = baseUrl+"/ouser-web/org/editOneOrg.do";
    //删除部门
    private String deleteOrgNewServiceUrl = baseUrl+"/ouser-web/org/deleteOneOrg.do";

    @Test
    public void queryOrgNew() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver,queryOrgNewServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addOrgNew() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"parentCode\":\"\",\"code\":\"\",\"orgName\":\"\"}");
        param.put("parentCode",23);//第一次添加不用传
        param.put("code",dateFormat.format(new Date()));
        param.put("orgName","部门"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addOrgNewServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void getOrgNew() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\"}");
        param.put("id","1886080801000003");
        Object o = Ajax.post(driver,getOrgNewServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editOrgNew() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"parentCode\":\"\",\"id\":\"\",\"code\":\"\",\"orgName\":\"\"}");
        param.put("parentCode",23);//上级部门编码
        param.put("id","1886082101000101");
        param.put("code",dateFormat.format(new Date()));
        param.put("orgName","部门"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,editOrgNewServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void deleteOrgNew() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"code\":\"11\",\"orgName\":\"11\",\"parentCode\":\"23\"}");
        param.put("parentCode",23);//上级部门编码
        param.put("id","1886082101000122");
        Object o = Ajax.post(driver,deleteOrgNewServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
