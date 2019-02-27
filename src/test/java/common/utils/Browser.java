package common.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver driver;
    public Browser(WebDriver driver){
        this.driver = driver;
    }
    public Object execute(RequestMethod method,ContentType contentType,String companyId,String url,Object param){
        Object o = null;
        if(ContentType.JSON.equals(contentType)){
            o = ((JavascriptExecutor)driver).executeScript(
                    "var result;" +
                            "var xhr = new XMLHttpRequest();" +
                            "xhr.open('"+method.getMethod()+"','"+url+"',false);" +
                            "xhr.setRequestHeader('Content-type','"+contentType.getContentType()+"');" +
                            "xhr.setRequestHeader('System-Context','[{\"companyId_\":\""+companyId+"\"}]');" +
                            "xhr.onreadystatechange = function () {" +
                            "if(xhr.readyState==4 && xhr.status == 200){" +
                            "  result = JSON.parse(xhr.responseText);" +
                            "}else if(xhr.readyState==4 && xhr.status != 200){" +
                            "  result='服务异常:'+xhr.status;" +
                            "}" +
                            "};" +
                            "xhr.send(JSON.stringify("+param+"));" +
                            "return result;");
        }else if(ContentType.FORM.equals(contentType)){
            o = ((JavascriptExecutor)driver).executeScript(
                    "var result;" +
                            "var xhr = new XMLHttpRequest();" +
                            "xhr.open('"+method.getMethod()+"', '"+url+"',false);" +
                            "xhr.setRequestHeader('Content-type','"+contentType.getContentType()+"');" +
                            "xhr.setRequestHeader('System-Context','[{\"companyId_\":\""+companyId+"\"}]');" +
                            "var formData = new FormData();"+
                            "for(var key in param){"+
                            "formData.append(key,param[key]);"+
                            "}"+
                            "xhr.onreadystatechange = function () {" +
                            "if(xhr.readyState==4  && xhr.status == 200){" +
                            "  result = JSON.parse(xhr.responseText);" +
                            "}else if(xhr.readyState==4  && xhr.status != 200){" +
                            "  result='服务异常:'+xhr.status;" +
                            "}" +
                            "};" +
                            "xhr.send(formData);" +
                            "return result;");
        }
        return o;
    }
}
