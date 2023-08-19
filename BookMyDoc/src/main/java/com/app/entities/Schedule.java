package com.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule extends BaseEntity {

//	private String slot;
//	private Date date;
//	private Doctor doctorId;
	
	@Column(length = 10)
	private SlotType slot;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctorId;
}
