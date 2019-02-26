package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Set;

public class JsonAssert {
    public static void deepEquals(Object object, Object expectObject) throws Exception {
        if(!JSON.toJSONString(expectObject).equals(JSON.toJSONString(object))){
            throw new AssertionError("\nExpect:"+ JSON.toJSONString(expectObject)+"\n   But:"+ JSON.toJSONString(object));
        }
    }
    public static boolean equals(Object object, Object expectObject) throws Exception {
        return equals(object,expectObject,"");
    }
    private static boolean equals(Object object, Object expectObject,String currentKey) throws Exception {
        boolean isEquals = true;
        if(expectObject instanceof JSONObject && object instanceof JSONObject){
            Set<String> keySet = ((JSONObject) expectObject).keySet();
            for(String key:keySet){
                isEquals = isEquals&&equals((((JSONObject)object).get(key)),((JSONObject) expectObject).get(key),key);
            }
        }else if(expectObject instanceof JSONArray && object instanceof JSONArray){
            int size = ((JSONArray) expectObject).size();
            isEquals = isEquals&&((JSONArray) object).size()==size;
            if(isEquals){
                for(int i=0;i<size;i++){
                    isEquals = isEquals&&equals(((JSONArray) object).get(i),((JSONArray) expectObject).get(i),"array["+i+"]");
                }
            }
        }else{
            isEquals = isEquals&&(expectObject==object||expectObject.equals(object)||expectObject.toString().equals(object.toString()));
        }
        if(!isEquals){
            throw new AssertionError(currentKey+"\nExpect:"+ JSON.toJSONString(expectObject)+"\n   But:"+ JSON.toJSONString(object));
        }
        return isEquals;
    }
}
