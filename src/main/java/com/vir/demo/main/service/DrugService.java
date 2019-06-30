package com.vir.demo.main.service;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.demo.main.constants.DrugConstants;
import com.vir.demo.main.constants.ErrorCodes;
import com.vir.demo.main.dao.DrugDAO;
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
				   if(userInfo.getUserName().equals(userName)&& userInfo.getPassWord().equals(password)){
					   responseMsg = DrugConstants.LOGIN_SUCCESS_MSG;
				   }else if(!userInfo.getPassWord().equals(password)){
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
	

}
