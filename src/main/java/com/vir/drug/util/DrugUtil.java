package com.vir.drug.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vir.drug.constants.DrugConstants;

/**
 * @author Sreeni
 * having all the utility methods
 */
@Component
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
	
	public  ObjectMapper getMapperInstance(){
		ObjectMapper objectMapper =  new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

	public static Map<String,String> setResponseMsg(String responseMessage){
		Map<String,String> mapResponse = new HashMap<String,String>();
		mapResponse.put(DrugConstants.MESSAGE, responseMessage);
		return mapResponse;
	}
	public static Map<String,String> setResponseMsg(String errorMessage,Integer errorCode){
		Map<String,String> mapResponse = new HashMap<String,String>();
		mapResponse.put("error message", errorMessage);
		mapResponse.put("error code", errorCode.toString());
		return mapResponse;
	}
	
}
