package common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.Iterator;

public class Browser {
    private String companyId;
    private String ut;
    public Connection.Response execute(String method, ContentType contentType, String url, JSONObject param) throws Exception{
        Connection connection = Jsoup.connect(url)
                .method(Connection.Method.valueOf(method.toUpperCase()))
                .ignoreContentType(true)
                .header("Accept","application/json, text/plain, */*")
                .header("Accept-Encoding","gzip, deflate")
                .header("Accept-Language","en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7")
                .header("Connection","keep-alive")
                .header("Content-Length","35")
                .header("Content-Type",contentType.getContentType())
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
        if(companyId!=null){
            connection.header("System-Context","[{companyId_:'"+companyId+"'}]");
        }
        if(ut!=null){
            connection.cookie("ut",ut);
        }
        if(ContentType.FORM.equals(contentType)){
            for(Iterator<String> it = param.keySet().iterator();it.hasNext();){
                String key = it.next();
                connection.data(key, JSON.toJSONString(param.get(key)));
            }
        }else{
            connection.requestBody(param.toJSONString());
        }
        Connection.Response response = connection.execute();
        return response;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }
}
