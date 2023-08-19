package com.app.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

import javax.persistence.*;


@Entity
@Table(name="appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int app_id;
	
	//@JsonFormat(pattern = "YYYY-MM-DD")
	@Column
	Date date;

	@ManyToOne
	@JoinColumn(name="status_id")
	AppointmentStatus status_id;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	Doctor doctor_id;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	Patient patient_id;
	
	@Column
	Time slot;
	
	@Column
	byte[] prescription;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment( Date date, AppointmentStatus status_id, Doctor doctor_id, Patient patient_id, Time slot,
			byte[] prescription) {
		super();
		
		this.date = date;
		this.status_id = status_id;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.slot = slot;
		this.prescription = prescription;
	}
	
	public Appointment(Date date, AppointmentStatus status_id, Doctor doctor_id, Patient patient_id, Time slot) {
		super();
		this.date = date;
		this.status_id = status_id;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.slot = slot;
	}

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AppointmentStatus getStatus_id() {
		return status_id;
	}

	public void setStatus_id(AppointmentStatus status_id) {
		this.status_id = status_id;
	}

	public Doctor getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Patient getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}

	public Time getSlot() {
		return slot;
	}

	public void setSlot(Time slot) {
		this.slot = slot;
	}

	public byte[] getPrescription() {
		return prescription;
	}

	public void setPrescription(byte[] prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Appointment [app_id=" + app_id + ", date=" + date + ", status_id=" + status_id + ", doctor_id="
				+ doctor_id + ", patient_id=" + patient_id + ", slot=" + slot + ", prescription="
				+ Arrays.toString(prescription) + "]";
	}
	
}
