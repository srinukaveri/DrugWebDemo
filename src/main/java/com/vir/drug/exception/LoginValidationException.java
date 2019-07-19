package com.vir.drug.exception;

import com.vir.drug.constants.ErrorCodes;

/**
 * @author Sreeni
 * handling the customized exception
 */
public class LoginValidationException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	private Integer errorCode;

	public LoginValidationException(String message,ErrorCodes errorCode){
		super(message);
		this.errorCode=errorCode.getErrorCode();
	}
	
	public Integer getErrorCode(){
		return errorCode;
	}
	
}
