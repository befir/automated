package common.utils;

public enum ContentType {
    JSON("application/json;charset=UTF-8"),
    FORM("application/x-www-form-urlencoded");
    private String contentType;
    ContentType(String contentType){
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
