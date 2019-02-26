package product.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

public class addOperationStrategy extends RestfulAutomatedTest {
    private String addOperationStrategyUrl = baseUrl + "/back-product-web2/back/operationStrategy/addOperationStrategy.do";
    private String updateOperationStrategyUrl = baseUrl + "/back-product-web2/back/operationStrategy/updateOperationStrategy.do";
    private String queryOperationStrategyUrl = baseUrl + "/back-product-web2/back/operationStrategy/queryOperationStrategy.do";
    private String deleteOperationStrategyUrl = baseUrl + "/back-product-web2/back/operationStrategy/deleteOperationStrategy.do";



    @Test
//    新增经营状态
    public void addOperationStrategy() throws InterruptedException {
        JSONObject param = JSON.parseObject("{merchantProductId:'',type:'',content:''}");
        param.put("opStatusCode",1234);
        param.put("opStatusName","测试1234");
        param.put("allowedBuyGoods",1);
        param.put("allowedDistribution",1);
        param.put("allowedPurchases",1);
        param.put("allowedPurchasesReturn",1);
        param.put("allowedSale",1);
        Object o = Ajax.post(driver,addOperationStrategyUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    编辑经营状态
    public void updateOperationStrategy() throws InterruptedException {
        JSONObject param = JSON.parseObject("{merchantProductId:'',type:'',content:''}");
        param.put("id","1809082100000006");
        param.put("opStatusCode",1234);
        param.put("opStatusName","测试1234");
        param.put("allowedBuyGoods",0);
        param.put("allowedDistribution",0);
        param.put("allowedPurchases",0);
        param.put("allowedPurchasesReturn",1);
        param.put("allowedSale",1);
        Object o = Ajax.post(driver,updateOperationStrategyUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    查询经营状态
    public void queryOperationStrategy() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10, opStatusCode: 1112}");
        Object o = Ajax.post(driver,queryOperationStrategyUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


    @Test
//    删除经营状态
    public void deleteOperationStrategy() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10, opStatusCode: 1112}");
        Object o = Ajax.post(driver,deleteOperationStrategyUrl,param);
        System.out.println(JSON.toJSONString(o));
    }


}
