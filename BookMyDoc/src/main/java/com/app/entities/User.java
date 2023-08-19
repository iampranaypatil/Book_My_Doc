package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
	
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String password;
//	private String gender;
//	private String answer;
//	private String contactNo;
//	Address addressId;
//	Role roleId;
//	Question questionId;
	
	@Column(name = "first_name",length = 20)
	private String firstName;
	@Column(name = "last_name",length = 20)
	private String lastName;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@Column(length = 20)
	private String gender;
	@Column(length = 20)
	private String answer;
	@Column(name = "contact_no",length = 20)
	private String contactNo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adress_id")
	//@MapsId
	private Address addressId;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role roleId;
	
	@ManyToOne
	@JoinColumn(name = "quetion_id")
	private Question questionId;
}
