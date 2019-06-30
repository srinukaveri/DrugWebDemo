package com.vir.demo.main.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DrugUtil {
	
	public static String toJSONStringException(String errorMessage,Integer errorCode)throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,Object> responseJsonStr = new HashMap<String,Object>();
		responseJsonStr.put("error message", errorMessage);
		responseJsonStr.put("error code", errorCode);
		return objectMapper.writeValueAsString(responseJsonStr);
	}
	
	public static String toJSONString(String message)throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,Object> responseJsonStr = new HashMap<String,Object>();
		responseJsonStr.put("message", message);
		return objectMapper.writeValueAsString(responseJsonStr);
	}

}
