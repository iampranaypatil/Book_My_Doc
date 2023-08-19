package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Doctor;
import com.app.entities.Login;
import com.app.entities.User;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	@Query("select d from Doctor d where user_id = :user_id")
	public Doctor getDoctorByUId(@Param("user_id") User user_id);
	
	@Query("select d from Doctor d where doctor_id = :did")
	public Doctor getDoctorByDId(@Param("did") int did);
	
	@Query("select distinct d.department from Doctor d")
	public List<String> getDepartments();
	
	@Query("select d from Doctor d where department = :dept")
	public List<Doctor> getDoctorsByDept(@Param("dept") String dept);
}
