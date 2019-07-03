package com.chethiya.questionnaire.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chethiya.questionnaire.Logic.QuestionnaireLogic;
import com.chethiya.questionnaire.Service.QuestionnaireService;
import com.chethiya.questionnaire.dao.QuestionnaireDAO;
import com.chethiya.questionnaire.dto.CommonResponse;
import com.chethiya.questionnaire.dto.ServiceError;
import com.chethiya.questionnaire.dto.ServiceResponse;
import com.chethiya.questionnaire.exception.ErrorCodes;
import com.chethiya.questionnaire.exception.ServiceRuntimeException;
import com.chethiya.questionnaire.model.Questionnaire;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireDAO questionnaireDAO;

	@Autowired
	private QuestionnaireLogic questionnaireLogic;

	@Override
	public ServiceResponse<CommonResponse> createQuestionnaire(Questionnaire questionnaire) {
		CommonResponse commonResponse = new CommonResponse();
		ServiceResponse<CommonResponse> commonServiceResponse = new ServiceResponse<>();
		try {
			questionnaireLogic.validateNewQuestionnaire(questionnaire);
			questionnaireDAO.save(questionnaire);
			questionnaireLogic.constructFields(questionnaire);
			questionnaireDAO.update(questionnaire);
			commonResponse.setSuccess(true);
		} catch (ServiceRuntimeException se) {
			log.error(se.getMessage(), se);
			commonServiceResponse.setError(new ServiceError(se.getCode(), se.getMessage(), se.getCause()));
		} catch (Exception e) {
			log.error("Creating questionnaire failed", e);
			commonServiceResponse
					.setError(new ServiceError(ErrorCodes.Common.SYSTEM_ERROE.getCode(), "System Error", e.getCause()));
		}
		commonServiceResponse.setPayload(commonResponse);
		return commonServiceResponse;
	}

}
