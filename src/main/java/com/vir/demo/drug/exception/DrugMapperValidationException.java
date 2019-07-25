package com.vir.demo.drug.exception;

import com.vir.demo.drug.constants.ErrorCodes;


public class DrugMapperValidationException extends RuntimeException{

	private static final long serialVersionUID = 4256804040846786995L;
	
	private Integer errorCode;

	public DrugMapperValidationException(String message,ErrorCodes errorCode){
		super(message);
		this.errorCode=errorCode.getErrorCode();
	}
	
	public Integer getErrorCode(){
		return errorCode;
	}
	
}
