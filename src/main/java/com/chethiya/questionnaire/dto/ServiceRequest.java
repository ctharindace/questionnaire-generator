package com.chethiya.questionnaire.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public class ServiceRequest<T> implements Serializable {

	public ServiceRequest() {

	}

	public ServiceRequest(T payload) {
		super();
		this.payload = payload;
	}

	@Getter
	@Setter
	private T payload;
}
