package com.chethiya.questionnaire.util;

import lombok.Getter;

public interface Constants {

	enum FieldType {
		NORMAL("NORMAL"),
		TAG("TAG"),
		DROPDOWN("DROPDOWN");

		@Getter
		private String code;

		FieldType(String code) {
			this.code = code;
		}
	}
}
