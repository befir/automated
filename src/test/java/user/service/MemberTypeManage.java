package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class MemberTypeManage extends RestfulAutomatedTest {

    //查询会员类型
    private String queryMemberTypeServiceUrl = baseUrl+"/ouser-center/memberInfoRead/queryMemberType.do";
    //新增会员类型
    private String addMemberTypeServiceUrl = baseUrl+"/ouser-center/memberInfoRead/addMemberType.do";
    //编辑会员类型
    private String editMemberTypeServiceUrl = baseUrl+"/ouser-center/memberInfoRead/modifyMemberType.do";
    @Test
    public void queryMemberType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryMemberTypeServiceUrl,param);
        //断言code
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));
        System.out.println(JSON.toJSONString(o));
        String expectedData1 = "0";
        Assert.assertEquals(actualResult.get("code"),expectedData1);
    }
    @Test
    public void addMemberType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"memberTypeName\":\"\",\"remark\":\"\"}");
        param.put("memberTypeName","会员类型"+dateFormat.format(new Date()));
        param.put("remark","会员类型描述"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addMemberTypeServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editMemberType() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"memberTypeName\":\"普通会员02\",\"remark\":\"描述\",\"id\":1884082100000000,\"memberType\":1003}");
        param.put("id","1884082100000000");
        param.put("memberType",1003);
        param.put("memberTypeName","会员类型+"+dateFormat.format(new Date()));
        param.put("remark","会员类型描述+"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,editMemberTypeServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
