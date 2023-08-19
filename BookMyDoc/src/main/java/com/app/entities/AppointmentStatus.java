package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointment_status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentStatus extends BaseEntity {

	@Column(length = 10)
	private String status;
}
