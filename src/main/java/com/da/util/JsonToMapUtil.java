package com.da.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class JsonToMapUtil {

	/**
	 * 현재 사용 안함
	 * @param properties
	 * @param parentKey
	 * @param currentKey
	 * @param jsonObject
	 */
	public void jsonToMap(HashMap<String, Object> properties, String parentKey, String currentKey, Object jsonObject) {
	    String keyPrefix = null;
	    
	    try {
		    if(parentKey != null && currentKey != null) {
		      keyPrefix = parentKey + "." + currentKey;
		    }
		    else if(parentKey == null && currentKey != null) {
		      keyPrefix = currentKey;
		    }
		    else if(parentKey != null && currentKey == null) {
		      keyPrefix = parentKey;
		    }
	
		    if( jsonObject == null) {
		      properties.put(keyPrefix, "null");
		    }
		    else if( jsonObject instanceof JSONObject ) {
		      JSONObject jObj = (JSONObject)jsonObject;
		      Set<String> keys = (Set<String>)jObj.keySet();
		      for( String key : keys ) {
	    		  jsonToMap(properties, null, key, jObj.get(key));
		      }
		    }
		    else if( jsonObject instanceof JSONArray ) {
		      JSONArray jArr = (JSONArray)jsonObject;
		      int i = 0;
		      for( Object elem: jArr ) {
		    	  String keyString = String.format("%s[%d]", keyPrefix, i++);
		    	  
		    	  jsonToMap(properties, null, null, elem);
		      }
		    }
		    else if( jsonObject instanceof String ) {
		      properties.put(keyPrefix, jsonObject);
		    }
		    else if( jsonObject instanceof Number ) {
		      properties.put(keyPrefix, jsonObject);
		    }
	    }catch(Exception e) {
//	    	jLogger.info(getCurrentDate() + " " + "1 [PF]" + " " + topic + " " + properties);
	    }
	}
	
	public Map<String, Object> stringToJson(String jsonData) {
		
		Gson gson = new Gson();
		
		JSONObject jsonObj = new JSONObject();
		
		HashMap<String, Object> results = new HashMap<String, Object>();
		
		Map<String, Object> gsonObject = new HashMap<String, Object>();
		try {
			
			
			JSONParser jsonParser = new JSONParser();
				
			Object obj = jsonParser.parse(jsonData);
			jsonObj = (JSONObject) obj;
			
			Object parseRoot = jsonParser.parse(jsonData);
			
			String convRoot = String.valueOf(parseRoot);
			
			gsonObject = gson.fromJson(convRoot, new TypeToken<Map<String, Object>>(){}.getType());
			
			/*
			 * 22.03.07
			 * 주소만 사용 할 경우 다시 사용
			Map<String, Object> rsltList = (Map<String, Object>) gsonObject.get("results");
			List<Map<String, Object>> jsonList = (List) rsltList.get("juso");
			*/
			
		}catch(Exception e) {
			
		}
		
		return gsonObject;
	}
}
