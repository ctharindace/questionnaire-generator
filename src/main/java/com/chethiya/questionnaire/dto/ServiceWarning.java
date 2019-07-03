package com.chethiya.questionnaire.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ServiceWarning implements Serializable {

	private String code;

	private String message;

	public ServiceWarning(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
