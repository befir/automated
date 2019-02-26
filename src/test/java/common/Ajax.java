package common;

//import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Ajax {
    public static Object post(WebDriver driver, String url, Object param){
        return ((JavascriptExecutor)driver).executeScript(
                "var result;"+
                "$.ajax({" +
                        "type : 'POST'," +
                        "url : \""+url+"\"," +
                        "async:false,"+
                        "dataType: 'json'," +
                        "contentType: 'application/json'," +
                        "data :JSON.stringify("+JSON.toJSONString(param)+")," +
                        "success : function(data) {" +
                        "result = data;" +
                        "}," +
                        "error : function(XMLHttpRequest, textStatus, errorThrown){" +
                        "    result = XMLHttpRequest.responseText;" +
                        "}" +
                        "});" +
                        "return result;");
    }
    public static Object soaPost(WebDriver driver, String url, Object param){
        return ((JavascriptExecutor)driver).executeScript(
                "var result;" +
                   "var xhr = new XMLHttpRequest();" +
                        "xhr.open('post', '"+url+"',false);" +
                        "xhr.setRequestHeader(\"Content-type\",\"application/json;charset=UTF-8\");" +
                        "xhr.onreadystatechange = function () {" +
                        "if(xhr.readyState==4){" +
                        "  result = xhr.responseText;" +
                        "}};" +
                        "xhr.send(JSON.stringify("+param+"));" +
                        "return JSON.parse(result);");
    }
    public static Object postForm(WebDriver driver, String url, Object param){
        return ((JavascriptExecutor)driver).executeScript(
                "var result;" +
                        "var xhr = new XMLHttpRequest();" +
                        "xhr.open('post', '"+url+"',false);" +
                        "xhr.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");" +
                        "var formData = new FormData();"+
                        "for(var key in param){"+
                        "formData.append(key,param[key]);"+
                        "}"+
                        "xhr.onreadystatechange = function () {" +
                        "if(xhr.readyState==4){" +
                        "  result = xhr.responseText;" +
                        "}};" +
                        "xhr.send(formData);" +
                        "return JSON.parse(result);");
    }
    public static Object get(WebDriver driver, String url, Object param){
        return ((JavascriptExecutor)driver).executeScript(
                "var result;"+
                        "$.ajax({" +
                        "type : 'GET'," +
                        "url : \""+url+"\"," +
                        "async:false,"+
                        "dataType: 'json'," +
                        "contentType: 'application/json'," +
                        "data :JSON.stringify("+JSON.toJSONString(param)+")," +
                        "success : function(data) {" +
                        "result = data;" +
                        "}," +
                        "error : function(){" +
                        "    result = \"错误\";" +
                        "}" +
                        "});" +
                        "return result;");
    }
}
