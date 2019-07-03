package com.chethiya.questionnaire.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "t_questionnaire_section")
public class QuestionnaireSection {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_questionnaire_section")
	@SequenceGenerator(name = "s_questionnaire_section", sequenceName = "s_questionnaire_section", allocationSize = 1)
	@Column(name = "questionnaire_section_id")
	private Integer questionnaireSectionId;

	@Column(name = "questionnaire_id", insertable = false, updatable = false)
	private Integer questionnaireId;

	@Column(name = "section_name")
	private String sectionName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Question.class, orphanRemoval = true)
	@JoinColumn(name = "questionnaire_section_id", nullable = false)
	private Set<Question> questions;
}
