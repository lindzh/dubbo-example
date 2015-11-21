package com.linda.dubbo;

import java.util.HashMap;
import java.util.Map;

public class KopUtils {
	
	public static Map<String,Object> packResult(int code,String message,Object data){
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("code", code);
		result.put("msg", message);
		result.put("data", data);
		return result;
	}

}
