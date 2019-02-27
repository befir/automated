package common.utils;

public enum RequestMethod {
    POST("post"),
    GET("get");
    private String method;
    RequestMethod(String method){
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
