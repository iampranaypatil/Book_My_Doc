package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(length = 50)
	private String area;

	@Column(length = 50)
	private String city;

	@Column(length = 50)
	private String state;

	@Column
	private int pincode;

	public Address(String area, String city, String state, int pincode) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

}
