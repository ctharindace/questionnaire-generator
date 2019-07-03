package com.chethiya.questionnaire.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chethiya.questionnaire.Logic.ParticipantLogic;
import com.chethiya.questionnaire.Service.ParticipantService;
import com.chethiya.questionnaire.dao.ParticipantDAO;
import com.chethiya.questionnaire.dto.CommonResponse;
import com.chethiya.questionnaire.dto.ServiceError;
import com.chethiya.questionnaire.dto.ServiceResponse;
import com.chethiya.questionnaire.exception.ErrorCodes;
import com.chethiya.questionnaire.exception.ServiceRuntimeException;
import com.chethiya.questionnaire.model.Participant;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantDAO participantDAO;

	@Autowired
	private ParticipantLogic participantLogic;

	@Override
	public ServiceResponse<CommonResponse> createParticipant(Participant participant) {
		CommonResponse commonResponse = new CommonResponse();
		ServiceResponse<CommonResponse> commonServiceResponse = new ServiceResponse<>();
		try {
			participantLogic.validateNewParticipant(participant);
			participant.generateBarCodeHash();
			participantDAO.save(participant);
			commonResponse.setSuccess(true);
		} catch (ServiceRuntimeException se) {
			log.error(se.getMessage(), se);
			commonServiceResponse.setError(new ServiceError(se.getCode(), se.getMessage(), se.getCause()));
		} catch (Exception e) {
			log.error("Creating participant failed", e);
			commonServiceResponse
					.setError(new ServiceError(ErrorCodes.Common.SYSTEM_ERROE.getCode(), "System Error", e.getCause()));
		}
		commonServiceResponse.setPayload(commonResponse);
		return commonServiceResponse;
	}

}
