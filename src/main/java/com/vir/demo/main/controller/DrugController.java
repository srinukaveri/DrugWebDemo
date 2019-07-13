package com.vir.demo.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vir.demo.main.entity.DrugDetails;
import com.vir.demo.main.entity.DrugSearch;
import com.vir.demo.main.entity.PharmacyDetails;
import com.vir.demo.main.entity.UserLoginDetails;
import com.vir.demo.main.exception.LoginValidationException;
import com.vir.demo.main.service.DrugService;
import com.vir.demo.main.util.DrugUtil;

import object.PriceInput;

/**
 * @author Sreeni
 * This is the controller class where all process starting from here.
 *
 */
@RestController
@Component
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
		 * This method returns all the pharmacy details for the user
		 * @return  list of PharmacyDetails
		 */
		@RequestMapping(method = RequestMethod.GET,value="/pharmacy")
		public List<PharmacyDetails> getPharmacyDetails(){
			return drugService.getPharmacyDetails();
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
		public List<DrugSearch> getPharmacyDrugMasterDetails(@RequestBody String drugDetails)throws Exception{
			DrugDetails drugDetailsObj = DrugUtil.getMapperInstance().readValue(drugDetails, DrugDetails.class);
			return drugService.getPharmacyDrugMasterDetails(drugDetailsObj.getDrugName());
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
				value="/drug/info",
				method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public List<DrugSearch> getPriceDetails(@RequestBody String drugDetails)throws Exception{
			
			PriceInput priceInputObj = DrugUtil.getMapperInstance().readValue(drugDetails,PriceInput.class);
			
			return drugService.getPharmacyDrugInfo(priceInputObj);

			//return drugDetails;
		}
		
}
