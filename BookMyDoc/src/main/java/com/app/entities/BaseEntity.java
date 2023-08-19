package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass //-->Mandatory annotation to tell hibernate it's a common super class 

@Getter
@Setter
public class BaseEntity {

	@Id //pK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generated values
	private Long id;
}
