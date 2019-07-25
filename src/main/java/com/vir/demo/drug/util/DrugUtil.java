package com.vir.demo.drug.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vir.demo.drug.constants.DrugConstants;

/**
 * @author Sreeni having all the utility methods
 */
public class DrugUtil {

	/**
	 * @param errorMessage
	 * @param errorCode
	 * @return
	 * @throws Exception
	 */
	public static String toJSONStringException(String errorMessage, Integer errorCode) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> responseJsonStr = new HashMap<String, Object>();
		responseJsonStr.put("error message", errorMessage);
		responseJsonStr.put("error code", errorCode);
		return objectMapper.writeValueAsString(responseJsonStr);
	}

	/**
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static String toJSONString(String message) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> responseJsonStr = new HashMap<String, Object>();
		responseJsonStr.put("message", message);
		return objectMapper.writeValueAsString(responseJsonStr);
	}

	/**
	 * @return object of the class instance
	 */
	public static ObjectMapper getMapperInstance() {
		ObjectMapper objectMapper = null;
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		return objectMapper;
	}

	/**
	 * @param responseMessage
	 * @return
	 */
	public static Map<String, String> setResponseMsg(String responseMessage) {
		Map<String, String> mapResponse = new HashMap<String, String>();
		mapResponse.put(DrugConstants.MESSAGE, responseMessage);
		return mapResponse;
	}

	/**
	 * @param errorMessage
	 * @param errorCode
	 * @return
	 */
	public static Map<String, String> setResponseMsg(String errorMessage, Integer errorCode) {
		Map<String, String> mapResponse = new HashMap<String, String>();
		mapResponse.put("error message", errorMessage);
		mapResponse.put("error code", errorCode.toString());
		return mapResponse;
	}

	/**
	 * @param errorMessage
	 * @param errorCode
	 * @return
	 */
	public static List<Object> setResponseList(String errorMessage, Integer errorCode) {
		Map<String, String> mapResponse = new HashMap<String, String>();
		List<Object> response = new ArrayList<Object>();
		mapResponse.put("error message", errorMessage);
		mapResponse.put("error code", errorCode.toString());
		response.add(mapResponse);
		return response;
	}
}
