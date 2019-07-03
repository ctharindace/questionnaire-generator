package com.chethiya.questionnaire.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "t_question_row")
public class QuestionRow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_question_row")
	@SequenceGenerator(name = "s_question_row", sequenceName = "s_question_row", allocationSize = 1)
	@Column(name = "question_row_id")
	private Integer questionRowId;

	@Column(name = "question_id")
	private Integer questionId;

	@Column(name = "row_heading_text")
	private String rowHeadingText;

}
