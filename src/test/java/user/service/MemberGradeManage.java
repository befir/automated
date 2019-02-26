package user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class MemberGradeManage extends RestfulAutomatedTest {

    //查询会员等级
    private String queryMemberGradeServiceUrl = baseUrl+"/ouser-center/memberGrade/queryMemberGradeList.do";
    //新增会员等级
    private String addMemberGradeServiceUrl = baseUrl+"/ouser-center/memberInfoRead/addMemberShipInfo.do";
    //编辑会员等级
    private String editMemberGradeServiceUrl = baseUrl+"/ouser-center/memberInfoRead/updateMemberShipInfo.do";

    int x=(int)(Math.random()*100);
    @Test
    public void queryMemberGrade() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10}");
        Object o = Ajax.post(driver,queryMemberGradeServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addMemberGrade() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"memberType\":\"\",\"levelName\":\"\",\"iconUrl\":\"\",\"gradeStatus\":\"\",\"endTimeStatus\":\"\",\"balence\":\"\"}");
        param.put("memberType",1001);
        param.put("levelName","会员等级"+dateFormat.format(new Date()));
        param.put("iconUrl","http://cdn.oudianyun.com/ones2.3-prod/trunk/osc/1540863513035_71.82356973706898.jpg");
        param.put("gradeStatus",2);
        param.put("endTimeStatus",1);
        param.put("balence",x);
        Object o = Ajax.post(driver,addMemberGradeServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editMemberGrade() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"memberType\":\"\",\"timeStyle\":\"\",\"id\":\"\",\"levelName\":\"\",\"iconUrl\":\"\",\"gradeStatus\":\"\",\"balence\":\"\",\"sort\":0,\"discountRate\":\"\",\"endTimeStatus\":\"\",\"timeNum\":\"\",\"loseBalence\":\"\"}");
        param.put("id","1884082100000002");
        param.put("memberType",1001);
        param.put("levelName","等级"+dateFormat.format(new Date()));
        param.put("iconUrl","http://cdn.oudianyun.com/ones2.3-prod/trunk/osc/1540863513035_71.82356973706898.jpg");
        param.put("gradeStatus",2);
        param.put("endTimeStatus",1);
        param.put("balence",x);
        Object o = Ajax.post(driver,editMemberGradeServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
