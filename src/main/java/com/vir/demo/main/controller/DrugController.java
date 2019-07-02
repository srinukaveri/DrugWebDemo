package com.vir.demo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vir.demo.main.entity.PharmacyDetails;
import com.vir.demo.main.exception.LoginValidationException;
import com.vir.demo.main.service.DrugService;
import com.vir.demo.main.util.DrugUtil;

@RestController
@Component
public class DrugController {
	

	@Autowired
     private DrugService drugService;
	
		@RequestMapping(method = RequestMethod.GET,value="/")
		public String showText(){
			return  "Welcome to drugweb app...!"; 
		}
	
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
		
		@RequestMapping(method = RequestMethod.GET,value="/pharmacy")
		public List<PharmacyDetails> getPharmacyDetails(){
			return drugService.getPharmacyDetails();
		}
		
	
}
