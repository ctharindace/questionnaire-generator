package com.chethiya.questionnaire.Service;

import org.springframework.stereotype.Service;

import com.chethiya.questionnaire.dto.CommonResponse;
import com.chethiya.questionnaire.dto.ServiceResponse;
import com.chethiya.questionnaire.model.Questionnaire;

@Service
public interface QuestionnaireService {

	ServiceResponse<CommonResponse> createQuestionnaire(Questionnaire questionnaire);

}
