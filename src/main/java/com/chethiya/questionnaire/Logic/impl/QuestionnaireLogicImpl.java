package com.chethiya.questionnaire.Logic.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.chethiya.questionnaire.Logic.QuestionnaireLogic;
import com.chethiya.questionnaire.exception.ErrorCodes;
import com.chethiya.questionnaire.exception.ServiceRuntimeException;
import com.chethiya.questionnaire.model.*;

@Component
public class QuestionnaireLogicImpl implements QuestionnaireLogic {

	public void validateNewQuestionnaire(Questionnaire questionnaire) {
		if (questionnaire == null) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Questionnaire is null");
		}

		if (StringUtils.isEmpty(questionnaire.getQuestionnaireName())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Questionnaire description cannot be empty");
		}

		if (StringUtils.isEmpty(questionnaire.getDescription())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Questionnaire description cannot be empty");
		}

		if (CollectionUtils.isEmpty(questionnaire.getQuestionnaireSections())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Questionnaire sections cannot be empty");
		}
		questionnaire.getQuestionnaireSections().forEach(this::validateQuestionnaireSection);
	}

	private void validateQuestionnaireSection(QuestionnaireSection questionnaireSection) {
		if (questionnaireSection == null) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"QuestionnaireSection is null");
		}

		if (StringUtils.isEmpty(questionnaireSection.getSectionName())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Questionnaire description cannot be empty");
		}

		if (CollectionUtils.isEmpty(questionnaireSection.getQuestions())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Questionnaire sections cannot be empty");
		}

		questionnaireSection.getQuestions().forEach(this::validateQuestion);
	}

	private void validateQuestion(Question question) {
		if (question == null) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Question is null");
		}

		if (StringUtils.isEmpty(question.getQuestionText())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Question text cannot be empty");
		}

		if (CollectionUtils.isEmpty(question.getQuestionColumns())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Question columns cannot be empty");
		}

		question.getQuestionColumns().forEach(this::validateQuestionColumn);

		if (CollectionUtils.isEmpty(question.getQuestionRows())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Question rows cannot be empty");
		}
		question.getQuestionRows().forEach(this::validateQuestionRow);
	}

	private void validateQuestionColumn(QuestionColumn questionColumn) {
		if (questionColumn == null) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Question column cannot be null");
		}

		if (StringUtils.isEmpty(questionColumn.getAnswerFieldType())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Question feild type cannot be empty");
		}
	}

	private void validateQuestionRow(QuestionRow questionRow) {
		if (questionRow == null) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Question column cannot be null");
		}
	}

	public void constructFields(Questionnaire questionnaire) {
		questionnaire.getQuestionnaireSections().forEach(questionnaireSection -> {
			questionnaireSection.getQuestions().forEach(question -> {
				Set<QuestionField> questionFields = new HashSet<>();
				question.getQuestionColumns().forEach(questionColumn -> {
					question.getQuestionRows().forEach(questionRow -> {
						QuestionField questionField = new QuestionField();
						questionField.setQuestionRowId(questionRow.getQuestionRowId());
						questionField.setQuestionColumnId(questionColumn.getQuestionColumnId());
						questionField.setQuestionId(question.getQuestionId());
						questionFields.add(questionField);
					});
				});
				question.setQuestionFields(questionFields);
			});
		});

	}
}
