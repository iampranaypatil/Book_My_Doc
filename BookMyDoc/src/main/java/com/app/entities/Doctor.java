package com.app.entities;

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
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor extends BaseEntity{

//	private String qualification;
//	private String specialization;
//	private String department;
//	private String type;
//	private int experience;
//	private int imrNo;
//	private User userId;
	
	@Column(length = 20)
	private String qualification;
	@Column(length = 20)
	private String specialization;
	@Column(length = 20)
	private String department;
	@Column(length = 20)
	private String type;
	private int experience;
	@Column(length = 20,name = "imr_no")
	private int imrNo;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;
}
