package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDto;
import com.app.dto.SlotSchedule;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.Schedule;
import com.app.services.DoctorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Transactional
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/registerDoctor")
	public Doctor register(@RequestBody DoctorDto doc) {
		return doctorService.register(doc);
	}

	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@GetMapping("/getDoctorByUId")
	public Doctor getDoctorByUId(@RequestParam("user_id") int user_id) {
		return doctorService.getDoctorByUId(user_id);
	}

	@GetMapping("/getDoctorByDId")
	public Doctor getDoctorByDId(@RequestParam("doctor_id") int doctor_id) {
		return doctorService.getDoctorByDId(doctor_id);
	}

	@GetMapping("/getDoctorsByDept")
	public List<Doctor> getDoctorsByDept(@RequestParam("department") String dept) {
		return doctorService.getDoctorsByDept(dept);
	}

	@PostMapping("/addSchedule")
	public Schedule addSchedule(@RequestBody Schedule sch) {
		return doctorService.addSchedule(sch);
	}

	@GetMapping("/getAllDepartments")
	public List<String> getDepartments() {
		return doctorService.getDepartments();
	}

	@GetMapping("/getSchedule")
	public List<SlotSchedule> getSchedule(@RequestParam("doctor_id") int did) {
		return doctorService.getSchedule(did);
	}

	@GetMapping("/getAppointmentsofDoctor")
	public List<Appointment> getAppointmentsofDoctor(@RequestParam("doctor_id") int did) {
		return doctorService.getAppointmentsofDoctor(did);
	}

}
