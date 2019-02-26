package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class FlagManage extends RestfulAutomatedTest {

    //查询店铺标签
    private String queryFlagServiceUrl = baseUrl+"/back-merchant-web/merchantFlag/findAllMerchantFlagList.do";
    //新增店铺标签
    private String addFlagServiceUrl = baseUrl+"/back-merchant-web/merchantFlag/addMerchantFlag.do";
    //编辑店铺标签
    private String editFlagServiceUrl = baseUrl+"/back-merchant-web/merchantFlag/updateMerchantFlag.do";
    @Test
    public void queryFlag() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"currentPage\":1,\"itemsPerPage\":10,\"name\":\"\",\"createDateBegin\":\"\",\"createDateEnd\":\"\"}");
        Object o = Ajax.post(driver,queryFlagServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addFlagl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"name\":\"\",\"url\":\"\",\"description\":\"\",\"isMonopolistic\":\"\"}");
        param.put("name","店铺标签"+dateFormat.format(new Date()));
        param.put("url","https://cdn.oudianyun.com/trunk/back-merchant-web/1540698208421_29.943133850477576_05cc56d2-9a8f-4fc9-8780-f38fd0c71423.jpg");
        param.put("description","店铺标签描述"+dateFormat.format(new Date()));
        param.put("isMonopolistic",1);//0:非专营排他性   1:专营排他性
        Object o = Ajax.post(driver,addFlagServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editFlagl() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"id\":\"\",\"name\":\"\",\"url\":\"\",\"description\":\"\",\"isMonopolistic\":\"\"}");
        param.put("id","2029081900000220");
        param.put("name","店铺标签"+dateFormat.format(new Date()));
        param.put("url","https://cdn.oudianyun.com/trunk/back-merchant-web/1540698208421_29.943133850477576_05cc56d2-9a8f-4fc9-8780-f38fd0c71423.jpg");
        param.put("description","店铺标签描述"+dateFormat.format(new Date()));
        param.put("isMonopolistic",1);//0:非专营排他性   1:专营排他性
        Object o = Ajax.post(driver,editFlagServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
