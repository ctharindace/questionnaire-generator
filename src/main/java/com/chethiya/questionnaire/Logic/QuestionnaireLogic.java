package com.chethiya.questionnaire.Logic;

import org.springframework.stereotype.Component;

import com.chethiya.questionnaire.model.Questionnaire;

@Component
public interface QuestionnaireLogic {

	void validateNewQuestionnaire(Questionnaire questionnaire);

	void constructFields(Questionnaire questionnaire);
}
