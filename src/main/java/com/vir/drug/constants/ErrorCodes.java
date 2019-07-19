package com.vir.drug.constants;

/**
 * @author Sreeni
 * All the Error codes are configured 
 */
public enum ErrorCodes {
	
	SERVICE_ERROR(1000),
	LOGIN_VALIDATION_ERROR_CODE(10001),
	USER_ID_VALIDATION_ERROR_CODE(10002),
	USER_PASSWORD_VALIDATION_ERROR_CODE(10003);
	
	
	private int errorCode;
	
	private ErrorCodes(int code) {
        this.errorCode=code;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
