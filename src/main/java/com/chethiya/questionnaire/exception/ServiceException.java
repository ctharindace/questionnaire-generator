package com.chethiya.questionnaire.exception;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	private String code;

	public ServiceException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ServiceException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
