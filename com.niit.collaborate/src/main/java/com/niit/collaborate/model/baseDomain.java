package com.niit.collaborate.model;


import javax.persistence.Transient;

public class BaseDomain 
{
	@Transient
	String errorCode;
	@Transient
	String errorMessage;
	
	public String getErrorCode() 
	{
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
