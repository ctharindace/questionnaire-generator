package com.chethiya.questionnaire.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "t_participant")
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_participant")
	@SequenceGenerator(name = "s_participant", sequenceName = "s_participant", allocationSize = 1)
	@Column(name = "participant_id")
	private Integer participantId;

	@Column(name = "barcode_hash")
	private Integer barCodeHash;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "national_id")
	private String participantNIC;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Answer.class, orphanRemoval = true)
	@JoinColumn(name = "participant_id")
	private Set<Answer> answers;

	public void generateBarCodeHash() {
		this.barCodeHash = Objects.hash(getFirstName(), getLastName(), getDateOfBirth(), getParticipantNIC());
	}
}
