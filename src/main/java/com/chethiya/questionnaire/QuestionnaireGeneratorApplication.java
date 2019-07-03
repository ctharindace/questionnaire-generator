package com.chethiya.questionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.chethiya.questionnaire.dao.QuestionnaireDAO;
import com.chethiya.questionnaire.model.Questionnaire;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class QuestionnaireGeneratorApplication implements CommandLineRunner {

	@Autowired
	private QuestionnaireDAO questionnaireDAO;

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) {
		questionnaireDAO.get(Questionnaire.class, 1);
	}
}
