package common;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RestfulTest extends RestfulAutomatedTest{
    private ServiceCase serviceCase;
    public RestfulTest(ServiceCase serviceCase){
        this.serviceCase = serviceCase;
    }
    @Test(dataProvider = "getServiceUrl")
    public void callService(String serviceUrl,String input) throws Exception {
        System.out.println(serviceCase.getServiceUrl());
        System.out.println("-------------input:"+input+"-----");
        System.out.println("------expectOutput:"+serviceCase.getExpectOutput()+"-----");
        Object o = Ajax.post(driver, baseUrl+serviceUrl, JSON.parse(input));
        System.out.println("------------output:"+JSON.toJSON(o)+"------");
        JsonAssert.equals(JSON.toJSON(o),JSON.parse(serviceCase.getExpectOutput()));
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