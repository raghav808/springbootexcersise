package com.raghavrs.mybank.customer_service.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String value;
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomException(Integer code, String value, String message) {
		super(message);
		this.code = code;
		this.value = value;
		this.message = message;
	}
	

}
