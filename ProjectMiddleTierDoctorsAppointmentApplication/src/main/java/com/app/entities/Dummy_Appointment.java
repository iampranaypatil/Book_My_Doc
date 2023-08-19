package com.app.entities;

import java.sql.Date;
import java.sql.Time;

public class Dummy_Appointment {

	Date date;
	int doctor_id,patient_id,status_id;
	Time slot;
	
	public Dummy_Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dummy_Appointment(Date date, int doctor_id, int patient_id, int status_id, Time slot) {
		super();
		this.date = date;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.status_id = status_id;
		this.slot = slot;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public Time getSlot() {
		return slot;
	}

	public void setSlot(Time slot) {
		this.slot = slot;
	}
	
	
	
	
	
}
