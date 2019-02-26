package product.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class newBill extends RestfulAutomatedTest {
    private String listImInventoryAdjustmentBillByPageUrl = baseUrl + "/back-product-web2/back/stock/listImInventoryAdjustmentBillByPage.do";
    private String batchSaveImInventoryAdjustmentBillItemUrl = baseUrl + "/back-product-web2/back/stock/batchSaveImInventoryAdjustmentBillItem.do";
    private String getImInventoryAdjustmentBillByIdUrl = baseUrl + "/back-product-web2/back/stock/getImInventoryAdjustmentBillById.do";
    private String updateImInventoryAdjustmentBillUrl = baseUrl + "/back-product-web2/back/stock/updateImInventoryAdjustmentBill.do";
    private String updateImInventoryAdjustmentBillForCompleteUrl = baseUrl + "/back-product-web2/back/stock/updateImInventoryAdjustmentBillForComplete.do";

    @Test
    //查询单据
    public void listImInventoryAdjustmentBillByPage() throws InterruptedException {
        JSONObject param = JSON.parseObject("{currentPage: 1, itemsPerPage: 10}");
        Object o = Ajax.post(driver, listImInventoryAdjustmentBillByPageUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject data=actualResult.getJSONObject("data");
        JSONArray listObj = data.getJSONArray("listObj");
//        //取第一个值组的值
        String billCode= listObj.getJSONObject(0).getString("billCode");
        String targetMerchantId= listObj.getJSONObject(0).getString("targetMerchantId");
//        //断言merchantCode，定义一个常量并赋值，预期结果
        String expectedData ="1878083500000030";
        String expectedData1 ="2029080800003446";
        String expectedData2= "0";
        Assert.assertEquals(billCode,expectedData);
        Assert.assertEquals(targetMerchantId,expectedData1);
        Assert.assertEquals(actualResult.get("code"),expectedData2);
        System.out.println(targetMerchantId);
        System.out.println(billCode);
    }

    @Test
        //保存单据
    public void batchSaveImInventoryAdjustmentBillItem() throws InterruptedException {
        JSONArray param = JSON.parseArray("[{\"billStockNum\":1,\"sortValue\":0,\"chineseName\":\"鹿先森笔记本\",\"code\":\"1809079003000073\",\"attList\":null,\"artNo\":null,\"barcode\":null,\"mainUnitName\":\"个\",\"merchantProductId\":1809079003000077,\"productId\":1809079003000074,\"imInventoryAdjustmentBillId\":\"1809082100000022\",\"stockNum\":1},{\"billStockNum\":1,\"sortValue\":1,\"chineseName\":\"套娃\",\"code\":\"1809079900000004\",\"attList\":null,\"artNo\":null,\"barcode\":null,\"mainUnitName\":\"件\",\"merchantProductId\":1809079900000008,\"productId\":1809079900000005,\"imInventoryAdjustmentBillId\":\"1809082100000022\",\"stockNum\":1}]");
        Object o = Ajax.post(driver, batchSaveImInventoryAdjustmentBillItemUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }

    @Test
    //获取单据id
    public void getImInventoryAdjustmentBillById() throws InterruptedException {
        JSONObject param = JSON.parseObject("{id:1809082100000011}");
        Object o = Ajax.post(driver, getImInventoryAdjustmentBillByIdUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));

        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);
    }
    @Test
    //确认单据
    public void updateImInventoryAdjustmentBill() throws InterruptedException {
        JSONObject param = JSON.parseObject("{id:1809082100000011}");
        Object o = Ajax.post(driver, updateImInventoryAdjustmentBillUrl, param);
        JSONObject actualResult = JSON.parseObject(JSON.toJSONString(o));

        System.out.println(JSON.toJSONString(o));
        JSONObject expectedData = JSON.parseObject("");
        Assert.assertEquals(actualResult.get("data"), expectedData);

    }

    @Test
    //完成单据
    public void updateImInventoryAdjustmentBillForComplete() throws InterruptedException {
        JSONObject param = JSON.parseObject("{}");
        Object o = Ajax.post(driver, updateImInventoryAdjustmentBillForCompleteUrl, param);
        System.out.println(JSON.toJSONString(o));
    }
}
