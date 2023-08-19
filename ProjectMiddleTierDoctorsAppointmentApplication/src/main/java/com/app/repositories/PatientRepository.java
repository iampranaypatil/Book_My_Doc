package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Doctor;
import com.app.entities.Login;
import com.app.entities.Patient;
import com.app.entities.User;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	@Query("select p from Patient p where user_id = :user_id")
	public Patient getPatientByUId(@Param("user_id") User user_id);
	
}
