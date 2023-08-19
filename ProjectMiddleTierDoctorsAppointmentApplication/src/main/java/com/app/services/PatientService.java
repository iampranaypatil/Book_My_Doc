package com.app.services;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Address;
import com.app.entities.Appointment;
import com.app.entities.AppointmentStatus;
import com.app.entities.Doctor;
import com.app.entities.DummyDoctor;
import com.app.entities.DummyPatient;
import com.app.entities.Dummy_Appointment;
import com.app.entities.Login;
import com.app.entities.Passwordbasedencryption;
import com.app.entities.Patient;
import com.app.entities.Questions;
import com.app.entities.Role;
import com.app.entities.SaltValue;
import com.app.entities.User;
import com.app.repositories.AddressRepository;
import com.app.repositories.AppointmentRepository;
import com.app.repositories.DoctorRepository;
import com.app.repositories.PatientRepository;
import com.app.repositories.QuestionsRepository;
import com.app.repositories.RoleRepository;
import com.app.repositories.UserRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository prepo;
	
	@Autowired
	RoleRepository rrepo;
	
	@Autowired
	QuestionsRepository qrepo;
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	AddressRepository arepo;
	
	@Autowired
	AppointmentRepository apprepo;
	
	@Autowired
	DoctorRepository drepo;
	
	@Autowired
	SaltValue saltval;
	
	public Patient register(DummyPatient patient)
	{
		Role role = new Role(3,"Patient");
		Questions que = new Questions(patient.getQuestion_id());
		Address add=new Address(patient.getArea(),patient.getCity(),patient.getState(),patient.getPincode());
		arepo.save(add);
			
		String encryption=Passwordbasedencryption.generateSecurePassword(patient.getPassword(),saltval.getSalt());
		
		User u=new User(patient.getFname(),patient.getLname(),patient.getEmail(),encryption,patient.getContact_no(),patient.getGender(),patient.getAnswer(),add,role,que);
		urepo.save(u);
		
		Patient pt=new Patient(patient.getBirthdate(),patient.getBlood_group(),patient.getDiabetes(),patient.getBlood_pressure(),u);
		return prepo.save(pt);
	}
	
	
	public List<Patient> getAllPatients()
	{
		return prepo.findAll();
	}
	
	public Patient getPatientByUId(int user_id)
	{
		User u=urepo.findById(user_id).get();  //findById returns optional---use get method to retrieve
		
		return prepo.getPatientByUId(u);
	}
	
	public Patient getPatientByPId(int patient_id)
	{		
		return prepo.findById(patient_id).get();
	}
	
	public Appointment addAppointment(Dummy_Appointment app)
	{
		Doctor doc=drepo.getDoctorByDId(app.getDoctor_id());
		Patient pat=getPatientByPId(app.getPatient_id());
		AppointmentStatus as=new AppointmentStatus();
		as.setStatus_id(app.getStatus_id());
		Appointment a=new Appointment(app.getDate(),as,doc,pat,app.getSlot());
		return apprepo.save(a);
	}
	
	
	public List <Appointment> getAppointmentsofPatient(int pid)
	{
		Patient p=getPatientByPId(pid);
		return apprepo.getAppointmentsofPatient(p);
	}
	
	public boolean appointmentCancellationRequest(int app_id)
	{
		AppointmentStatus as=new AppointmentStatus(4,"cancellation requested");
		boolean flag=false;
		int a=apprepo.appointmentCancellationRequest(app_id,as);
		
		if(a==1)
			flag=true;
		
		return flag;
	}
	
}
