package com.chethiya.questionnaire.Logic.impl;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.chethiya.questionnaire.Logic.ParticipantLogic;
import com.chethiya.questionnaire.exception.ErrorCodes;
import com.chethiya.questionnaire.exception.ServiceRuntimeException;
import com.chethiya.questionnaire.model.Participant;

@Component
public class ParticipantLogicImpl implements ParticipantLogic {

	public void validateNewParticipant(Participant participant) {
		if (participant == null) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Participant is null");
		}

		if (StringUtils.isEmpty(participant.getDateOfBirth())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Participant date of birth cannot be empty");
		}

		if (StringUtils.isEmpty(participant.getFirstName())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Participant date of birth cannot be empty");
		}

		if (StringUtils.isEmpty(participant.getLastName())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Participant date of birth cannot be empty");
		}

		if (StringUtils.isEmpty(participant.getParticipantNIC())) {
			throw new ServiceRuntimeException(ErrorCodes.Common.MISSING_REQUIRED_PARAMETER.getCode(),
					"Participant date of birth cannot be empty");
		}
	}

}
