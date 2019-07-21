package com.vir.demo.drug.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vir.demo.drug.entity.UserLoginDetails;
import com.vir.demo.drug.exception.LoginValidationException;
import com.vir.demo.drug.model.DrugRequest;
import com.vir.demo.drug.model.ModifyDrugInfo;
import com.vir.demo.drug.service.DrugService;
import com.vir.demo.drug.util.DrugUtil;

/**
 * @author Sreeni
 * This is the controller class where all process starting from here.
 *
 */
@RestController
public class DrugController {
	

	@Autowired
     private DrugService drugService;
	
		@RequestMapping(method = RequestMethod.GET,value="/")
		public String showText(){
			return  "Welcome to drugweb app...!"; 
		}
	
		/**
		 * this method validate the user id and password from the UI and returns the response
		 * @param userName
		 * @param password
		 * @return the login response whether success or failure
		 * @throws Exception
		 */
		@RequestMapping(method = RequestMethod.GET,value="/login")
		public String doLogin(@RequestParam(value="username") String userName,
							  @RequestParam(value="password") String password)throws Exception{
			   String loginResponse = null;
            	try{
	            	String serviceResponse=drugService.doLogin(userName, password);
	            	loginResponse = DrugUtil.toJSONString(serviceResponse);
            	}catch(LoginValidationException  exe){
            		loginResponse = DrugUtil.toJSONStringException(exe.getMessage(), exe.getErrorCode());
            	}
			return loginResponse;
		}
		
		/**
		 * This method return the detailed information about the drugs
		 * @return list of drug details
		 */
		@RequestMapping(value="/drug",
				method = RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,List<String>> getDrugDetails(){
			return drugService.getDrugDetails();
		}
	
	
		
		/**
		 * @param loginDetails
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(
				value="/login/", 
				method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,String> doUserLogin(@RequestBody String loginDetails)throws Exception{
			Map<String,String> response=null;
			try{
				UserLoginDetails loginDetailsObj = DrugUtil.getMapperInstance().readValue(loginDetails, UserLoginDetails.class);
				String serviceResponse=drugService.doLogin(loginDetailsObj.getUserName(), loginDetailsObj.getUserPassword());
				response = DrugUtil.setResponseMsg(serviceResponse);
        	}catch(LoginValidationException  exe){
        		response = DrugUtil.setResponseMsg(exe.getMessage(), exe.getErrorCode());
        	}
		 return response;	
		}
		
		/**
		 * This method find the corresponding and near by available 
		 * pharmacy details for the particular drug which is given by the user.
		 * @param drugDetails
		 * @return drugsearch
		 * @throws Exception
		 */
		@RequestMapping(
				value="/drug/details",
				method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Object>  getPriceDetails(@RequestBody String drugDetails)throws Exception{
			DrugRequest drugRequestObj = DrugUtil.getMapperInstance().readValue(drugDetails,DrugRequest.class);
			return drugService.fetchPharmacyDrugDetails(drugRequestObj);
		}
		
		@RequestMapping(
				value="/drug/add",
				method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String,String> saveDrug(@RequestBody String saveDrugDetails)throws Exception{
			ModifyDrugInfo drugRequestObj = DrugUtil.getMapperInstance().readValue(saveDrugDetails,ModifyDrugInfo.class);
			return null;
		}
		
}