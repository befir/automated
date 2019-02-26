package merchant.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Ajax;
import common.RestfulAutomatedTest;
import org.testng.annotations.Test;

import java.util.Date;

public class SalesAreaManage extends RestfulAutomatedTest {

    //查询销售区域
    private String querySalesAreaServiceUrl = baseUrl+"/back-merchant-web/salesAreaAction/querySalesAreaList.do";
    //新增销售区域
    private String addSalesAreaServiceUrl = baseUrl+"/back-merchant-web/salesAreaAction/addSalesAreaInfo.do";
    //新增销售区域
    private String editSalesAreaServiceUrl = baseUrl+"/back-merchant-web/salesAreaAction/updateSalesAreaInfo.do";
    @Test
    public void querySalesArea() throws InterruptedException {
        JSONObject param = JSON.parseObject("{itemsPerPage: 10, pageSizes: [10,20,50,100], currentPage: 1, orgId: 2029080800000000}");
        Object o = Ajax.post(driver,querySalesAreaServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void addSalesArea() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"areaCode\":\"\",\"areaName\":\"\",\"orgId\":2029080800000000,\"orgCode\":\"1\",\"saveAreaList\":[{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310101},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310104},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310105},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310106},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310107},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310108},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310109},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310110},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310112},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310113},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310114},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310115},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310116},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310117},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310118},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310120},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310230}]}");
        param.put("areaCode",dateFormat.format(new Date()));
        param.put("areaName","屈臣氏销售区域"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,addSalesAreaServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
    @Test
    public void editSalesArea() throws InterruptedException {
        JSONObject param = JSON.parseObject("{\"areaCode\":\"\",\"areaName\":\"\",\"orgId\":\"\",\"orgCode\":\"1\",\"saveAreaList\":[{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310101},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310104},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310105},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310106},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310107},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310108},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310109},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310110},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310112},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310113},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310114},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310115},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310116},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310117},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310118},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310120},{\"provinceCode\":310000,\"cityCode\":310100,\"countyCode\":310230}]}");
        param.put("id","2029082101003442");
        param.put("merchantId","2029080800000000");
        param.put("orgId","2029080800000000");
        param.put("areaCode",dateFormat.format(new Date()));
        param.put("areaName","屈臣氏区域"+dateFormat.format(new Date()));
        Object o = Ajax.post(driver,editSalesAreaServiceUrl,param);
        System.out.println(JSON.toJSONString(o));
    }
}
