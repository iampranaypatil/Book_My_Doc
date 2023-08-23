package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Appointment;
import com.app.services.AdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Transactional
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/cancellationRequestedAppointments")
	public List<Appointment> cancellationRequestedAppointments() {
		return adminService.cancellationRequestedAppointments();
	}

	@GetMapping("/approveAppointmentCancellation")
	public boolean approveAppointmentCancellation(@RequestParam("app_id") int app_id) {
		return adminService.approveAppointmentCancellation(app_id);
	}

	@GetMapping("/getAllAppointments")
	public List<Appointment> getAllAppointments() {
		return adminService.getAllAppointments();
	}

	@DeleteMapping("/deleteByUId")
	public boolean deleteByUId(@RequestParam("user_id") int uid) {
		adminService.deleteByUId(uid);
		return true;
	}

}
