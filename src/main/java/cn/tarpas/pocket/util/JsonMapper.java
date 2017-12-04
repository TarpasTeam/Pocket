package cn.tarpas.pocket.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonMapper {
	
	 public <T> T fromJson(String requestBody, Class<?> obj){
		 
			JSONObject Json = JSONObject.fromObject(requestBody);
			T RequestDTO = (T)Json.toBean(Json, obj);
			
		
		return RequestDTO;
	 }
	 
	 public  String listToJson(List obj){
		 JSONArray Json=JSONArray.fromObject(obj);
		 return Json.toString();
	 }
	 
	 public <T> String beanToString(T obj){
		 JSONObject json=JSONObject.fromObject(obj);
		 return json.toString();
	 }
	  
}
