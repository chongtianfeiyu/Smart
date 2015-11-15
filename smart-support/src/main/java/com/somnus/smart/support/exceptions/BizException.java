package com.somnus.smart.support.exceptions;

public class BizException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorCode;

	public BizException() {
		super();
	}
	
	public BizException(String message) {
		super(message);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

    
    public String getErrorCode() {
        return errorCode;
    }

    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
	
}
