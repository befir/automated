package common;

import com.alibaba.fastjson.JSON;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AngularScope {
    public static void appendData(WebDriver driver, String element, String key, Object o){
        ((JavascriptExecutor)driver).executeScript(
                "var scope = angular.element("+element+").scope();" +
                        "var dataArgs = "+ JSON.toJSONString(o)+";"+
                        "if(scope."+key+"){"+
                        "for(var p in dataArgs){"+
                        "scope."+key+"[p]=dataArgs[p];}}else{"+
                        "scope."+key+"="+ JSON.toJSONString(o)+";}"+
                        "scope.$apply();");
    }
    public static Object getData(WebDriver driver, String element, String key){
        Object o=((JavascriptExecutor)driver).executeScript(
                "var scope = angular.element("+element+").scope();" +
                        "return scope."+key+";");
        return o;
    }
}
