package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Doctor;
import com.app.entities.Login;
import com.app.entities.Patient;
import com.app.entities.Schedule;
import com.app.entities.ScheduleID;
import com.app.entities.User;

public interface ScheduleRepository extends JpaRepository<Schedule,ScheduleID> {

	@Query("select s from Schedule s where doctor_id = :did")
	public List<Schedule> getByDoctorId(@Param("did") int did);
	
}
