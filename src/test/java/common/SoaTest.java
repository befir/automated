package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SoaTest extends SoaAutomatedTest{
    private ServiceCase serviceCase;
    public SoaTest(ServiceCase serviceCase){
        this.serviceCase = serviceCase;
    }
    @Test(dataProvider = "getServiceUrl")
    public void callService(String serviceUrl,String input) throws Exception {
        System.out.println(serviceCase.getServiceUrl());
        System.out.println("-------------input:"+input+"-----");
        System.out.println("------expectOutput:"+serviceCase.getExpectOutput()+"-----");
        Object o = Ajax.soaPost(driver,properties.getProperty("soaCallUrl"), JSON.parse(input));
        JSONObject result = JSON.parseObject(JSON.toJSONString(o));
        result = result.containsKey("data")?result.getJSONObject("data"):result;
        result = result.containsKey("data")?result.getJSONObject("data"):result;
        System.out.println("------------output:"+JSON.toJSON(result)+"------");
        JsonAssert.equals(result,JSON.parse(serviceCase.getExpectOutput()));
    }
    @Factory
    @Parameters("caseFile")
    public static Object[] createTest(String caseFile) throws Exception {
        return ServiceTestFactory.generate(ServiceTestFactory.loadCaseFromExcel(caseFile));
    }
    @DataProvider
    public Object[][] getServiceUrl() {
        return new Object[][] {{serviceCase.getServiceUrl(),serviceCase.getInput()}};
    }
}