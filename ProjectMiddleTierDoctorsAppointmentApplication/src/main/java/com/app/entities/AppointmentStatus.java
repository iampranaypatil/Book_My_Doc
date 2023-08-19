package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name="appointment_status")
public class AppointmentStatus {

	@Id
	int status_id;
	@Column
	String status;
	
	public AppointmentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentStatus(int status_id, String status) {
		super();
		this.status_id = status_id;
		this.status = status;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
