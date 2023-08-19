package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Appointment;
import com.app.entities.AppointmentStatus;
import com.app.repositories.AppointmentRepository;
import com.app.repositories.DoctorRepository;
import com.app.repositories.RoleRepository;
import com.app.repositories.UserRepository;

@Service
public class AdminService {

	@Autowired
	AppointmentRepository apprepo;
	
	@Autowired
	DoctorRepository drepo;
	
	@Autowired
	UserRepository urepo;
	
	public List<Appointment> cancellationRequestedAppointments()
	{
		AppointmentStatus as=new AppointmentStatus(4,"cancellation requested");
		return apprepo.cancellationRequestedAppointments(as);
	}
	
	public boolean approveAppointmentCancellation(int app_id)
	{
		AppointmentStatus as=new AppointmentStatus(3,"cancelled");
		boolean flag=false;
		int a=apprepo.approveAppointmentCancellation(app_id,as);
		
		if(a==1)
			flag=true;
		
		return flag;
	}
	
	public List<Appointment> getAllAppointments()
	{
		return apprepo.findAll();
	}
	
	public void deleteByUId(int uid)
	{
		urepo.deleteById(uid);
	}
	

}
