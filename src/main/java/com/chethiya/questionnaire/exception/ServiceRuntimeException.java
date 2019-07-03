package com.chethiya.questionnaire.exception;

import java.util.Map;

import lombok.Getter;

@SuppressWarnings("serial")
public class ServiceRuntimeException extends RuntimeException {

	@Getter
	private String code;

	@Getter
	private Map<String, String> args;

	public ServiceRuntimeException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ServiceRuntimeException(String code, String message) {
		super(message);
		this.code = code;
	}

	public ServiceRuntimeException(String code, String message, Throwable cause, Map<String, String> args) {
		super(message, cause);
		this.code = code;
		this.args = args;
	}

	public ServiceRuntimeException(String code, String message, Map<String, String> args) {
		super(message);
		this.code = code;
		this.args = args;
	}
}
