package com.vir.demo.drug.exception;

import com.vir.demo.drug.constants.ErrorCodes;

@SuppressWarnings("serial")
public class DrugMapperValidationException extends RuntimeException{

	
	private Integer errorCode;

	public DrugMapperValidationException(String message,ErrorCodes errorCode){
		super(message);
		this.errorCode=errorCode.getErrorCode();
	}
	
	public Integer getErrorCode(){
		return errorCode;
	}
	
}
