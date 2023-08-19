package com.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient extends BaseEntity{
	
//	private Date birthDate;
//	private String bloodGroup;
//	private String diabetes;
//	private String bloodPressure; //blood pressure is high? ans yes or no
//	private User userId;
	
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "blood_group",length = 5)
	private String bloodGroup;
	@Column(length = 10)
	private String diabetes;
	@Column(length = 10)
	private String bloodPressure;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;
	
}
