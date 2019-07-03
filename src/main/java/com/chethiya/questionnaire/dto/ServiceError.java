package com.chethiya.questionnaire.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceError implements Serializable {

	@Getter
	@NonNull
	private String code;

	@Getter
	@NonNull
	private String message;

	@Getter
	@NonNull
	private Throwable trace;

	@Getter
	private Map<String, String> args;

}
