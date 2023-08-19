package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity {

//	private String area;
//	private String city;
//	private String state;
//	private int pincode;
	
	@Column(length = 40)
	private String area;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column
	private int pincode;
}
