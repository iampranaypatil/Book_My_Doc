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
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment extends BaseEntity {

//	private Date date;
//	private String prescription;
//	private AppointmentStatus statusId;
//	private Doctor doctorId;
//	private Patient patientId;
//	private Schedule scheduleId;
	
	private Date date;
	@Column(length = 200)
	private String prescription;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private AppointmentStatus statusId;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctorId;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patientId;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private Schedule scheduleId;
	
}
