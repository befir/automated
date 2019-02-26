package opms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class savePurchaser extends RestfulAutomatedTest {
    //全局变量
    private String merchantName = "P蒙牛商家";
    private String merchantId= "2029080800000000";
    private String companyId= "231";


 //接口
    private String AddPurchaserurl = baseUrl+"opms-web/purchaser/savePurchaser.do";
    private String addSuplierServiceUrl = baseUrl+"";
    @Test
    public void savePurchaser () throws InterruptedException {
        JSONObject addRegisterparam = JSON.parseObject("{businessStatus: \"\", merchantType: \"\", auditStatus: \"\", currentPage: 1, itemsPerPage: 10}");
        Thread.sleep(5000);
        addRegisterparam.put("id", "5");
        addRegisterparam.put("purchaserName", "采购员莉莉");
        addRegisterparam.put("purchaserCode", "1886081503000024");
        addRegisterparam.put("userName", "333");
        addRegisterparam.put("status", "1");
        addRegisterparam.put("merchantId",merchantId );
        addRegisterparam.put("companyId", companyId);
        addRegisterparam.put("isDeleted",  0);
        addRegisterparam.put("versionNo",  0);
        addRegisterparam.put("createUserid", "18101517160196");
        addRegisterparam.put("createUsername", "superadmin");
        addRegisterparam.put("createTime", "1540372314000");
        addRegisterparam.put("createTimeDb", "1540372314000");
        addRegisterparam.put("serverIp", "127.0.0.1");
        addRegisterparam.put("updateUserid", "18101517160196");
        addRegisterparam.put("updateUsername", "superadmin");
        addRegisterparam.put("updateTime", "1540374011000");
        addRegisterparam.put("updateTimeDb", "1540373864000");
        addRegisterparam.put("statusText", "null");
        Object o = Ajax.post(driver, AddPurchaserurl, addRegisterparam);
        System.out.println(JSON.toJSONString(o));
        //JSONObject result = (JSONObject) JSON.toJSON(o);
       // orgId = result.getString("data");
        Thread.sleep(5000);
    }
}
