package com.chethiya.questionnaire.exception;

import lombok.Getter;

public interface ErrorCodes {

	enum Common {
		SYSTEM_ERROE("system.error"),
		MISSING_REQUIRED_PARAMETER("missing.required.parameter");

		@Getter
		private String code;

		private Common(String code) {
			this.code = code;
		}
	}

}
