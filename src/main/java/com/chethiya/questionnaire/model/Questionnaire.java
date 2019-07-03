package com.chethiya.questionnaire.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "t_questionnaire")
public class Questionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_questionnaire")
	@SequenceGenerator(name = "s_questionnaire", sequenceName = "s_questionnaire", allocationSize = 1)
	@Column(name = "questionnaire_id")
	private Integer questionnaireId;

	@Column(name = "questionnaire_name")
	private String questionnaireName;

	@Column(name = "description")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = QuestionnaireSection.class, orphanRemoval = true)
	@JoinColumn(name = "questionnaire_id", nullable = false)
	private Set<QuestionnaireSection> questionnaireSections;

}
