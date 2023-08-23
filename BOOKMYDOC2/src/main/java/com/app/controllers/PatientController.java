package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDto;
import com.app.dto.PatientDto;
import com.app.entities.Appointment;
import com.app.entities.Patient;
import com.app.services.PatientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class PatientController {

	@Autowired
	private PatientService patientService;

//	@Autowired
//	JavaMailSender sender;

	@PostMapping("/registerPatient")
	public ResponseEntity<?> registerNewPatient(@RequestBody PatientDto patient) {
		return ResponseEntity.status(HttpStatus.CREATED).body(patientService.registerPatient(patient));
	}
	/*
	 * Patient p; try {
	 * 
	 * SimpleMailMessage mailMsg=new SimpleMailMessage();
	 * mailMsg.setFrom("onlinelifelinehospital@gmail.com");
	 * mailMsg.setTo(p.getUser_id().getEmail());
	 * mailMsg.setSubject("Registration Details..."); mailMsg.
	 * setText("Your registration has been done successfully in LifeLine Hospital.\n"
	 * +"Following are your Login details :\n" + "UserId : " +
	 * p.getUser_id().getEmail()+"\n" +"Password : " +
	 * p.getUser_id().getPassword()); sender.send(mailMsg); } catch(Exception e) {
	 * p=null; e.printStackTrace();
	 * 
	 * }
	 * 
	 * return p;
	 */

	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/getPatientByUId")
	public Patient getPatientByUId(@RequestParam("user_id") int user_id) {
		return patientService.getPatientByUId(user_id);
	}

	@GetMapping("/getPatientByPId")
	public Patient getPatientByPId(@RequestParam("patient_id") int patient_id) {
		return patientService.getPatientByPId(patient_id);
	}

	@PostMapping("/addAppointment")
	public Appointment addAppointment(@RequestBody AppointmentDto app) {
		return patientService.addAppointment(app);
	}

	@GetMapping("/getAppointmentsofPatient")
	public List<Appointment> getAppointmentsofPatient(@RequestParam("patient_id") int pid) {
		return patientService.getAppointmentsofPatient(pid);
	}

	@GetMapping("/appointmentCancellationRequest")
	public boolean appointmentCancellationRequest(@RequestParam("app_id") int app_id) {
		return patientService.appointmentCancellationRequest(app_id);
	}

}
