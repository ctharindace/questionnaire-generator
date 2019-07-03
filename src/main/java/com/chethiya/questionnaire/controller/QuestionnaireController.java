package com.chethiya.questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chethiya.questionnaire.Service.QuestionnaireService;
import com.chethiya.questionnaire.exception.ServiceException;
import com.chethiya.questionnaire.model.Questionnaire;

@Controller
@RequestMapping(path = "/questionnaire")
public class QuestionnaireController {
	@Autowired
	private QuestionnaireService questionnaireService;

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	private @ResponseBody Questionnaire createQuestionnaire(@RequestBody Questionnaire questionnaire) {
		questionnaireService.createQuestionnaire(questionnaire);
		return questionnaire;
	}

	@PostMapping(path = "/get", consumes = "application/json", produces = "application/json")
	private @ResponseBody Questionnaire getQuestionnaire(@RequestBody Questionnaire questionnaire)
			throws ServiceException {
		questionnaireService.createQuestionnaire(questionnaire);
		return questionnaire;
	}

}
