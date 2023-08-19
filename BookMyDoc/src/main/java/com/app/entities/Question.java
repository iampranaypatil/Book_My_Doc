package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question extends BaseEntity {

	//private String question;
	@Column(length = 40,unique = true)
	private String question;
}
