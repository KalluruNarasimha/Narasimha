package com.app.Util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
 
	public String convertObjectToJson(Object ob){
		String json=null;
		try {
			json=new ObjectMapper().writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object convertJsonToObject(String json,Class c){
		Object ob=null;
		try {
			ob=new ObjectMapper().readValue(json, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}   

}
