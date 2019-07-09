package com.vir.demo.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.demo.main.constants.DrugConstants;
import com.vir.demo.main.constants.ErrorCodes;
import com.vir.demo.main.dao.DrugDAO;
import com.vir.demo.main.entity.DrugDetails;
import com.vir.demo.main.entity.DrugSearch;
import com.vir.demo.main.entity.PharmacyDetails;
import com.vir.demo.main.entity.UserLoginDetails;
import com.vir.demo.main.exception.LoginValidationException;

@Service
@Transactional
public class DrugService {
	
	@Autowired
	private DrugDAO drugDAO;
	
		
	
	public String doLogin(String userName,String password){
	String responseMsg = null;
		   if(!StringUtils.isBlank(userName) && !StringUtils.isBlank(password)){
			   UserLoginDetails userInfo = drugDAO.doLogin(userName, password);
			   if(userInfo != null){
				   if(userInfo.getUserName().equals(userName)&& userInfo.getUserPassword().equals(password)){
					   responseMsg = DrugConstants.LOGIN_SUCCESS_MSG;
				   }else if(!userInfo.getUserPassword().equals(password)){
					   responseMsg = DrugConstants.IN_VALID_USER_PASSWORD;
				   }else{
					   responseMsg = DrugConstants.INVALID_LOGIN_CREDENTIALS;
				   }
			   }else{
				   responseMsg = DrugConstants.NO_RECORD_FOUND;
			   }
		   }else{
			   throw new LoginValidationException(DrugConstants.INVALID_LOGIN_CREDENTIALS,ErrorCodes.LOGIN_VALIDATION_ERROR_CODE);
		   }
		return responseMsg;	
	}
	
	public List<PharmacyDetails> getPharmacyDetails(){
		return drugDAO.getPharmacyDetails();
	}
	
	public List<DrugDetails> getDrugDetails(){
		return drugDAO.getDrugDetails();
	}
	
	public List<DrugSearch> getPharmacyDrugMasterDetails(String drugName){
		//return drugDAO.getPharmacyDrugMasterDetails();
		return drugDAO.getPharmacyDrugDetails(drugName);
	}

}
