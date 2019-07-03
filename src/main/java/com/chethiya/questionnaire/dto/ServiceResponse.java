package com.chethiya.questionnaire.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.chethiya.questionnaire.exception.ServiceRuntimeException;

import lombok.Getter;
import lombok.Setter;

public class ServiceResponse<T> implements Serializable {

	@Getter
	@Setter
	private ServiceError error;

	@Getter
	@Setter
	private List<ServiceWarning> warnings;

	@Setter
	private T payload;

	public ServiceResponse() {
	}

	public ServiceResponse(T payload, ServiceError error) {
		this.payload = payload;
		this.error = error;
	}

	public T getPayload() {

		if (hasError()) {

			Throwable traceError = this.error.getTrace();

			if (traceError instanceof ServiceRuntimeException) {
				throw (ServiceRuntimeException) traceError;
			} else {
				throw new ServiceRuntimeException(this.error.getCode(), this.error.getMessage(), traceError);
			}
		}
		return payload;
	}

	public boolean hasError() {
		return error != null;
	}

	public boolean hasWarnings() {
		return !CollectionUtils.isEmpty(warnings);
	}

	public void addWarning(ServiceWarning warning) {

		if (warnings == null) {
			this.warnings = new ArrayList<ServiceWarning>();
		}
		this.warnings.add(warning);
	}
}
