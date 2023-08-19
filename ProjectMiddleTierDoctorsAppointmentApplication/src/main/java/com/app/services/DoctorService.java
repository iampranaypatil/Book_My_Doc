package com.app.services;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Address;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.DummyDoctor;
import com.app.entities.Login;
import com.app.entities.Passwordbasedencryption;
import com.app.entities.Questions;
import com.app.entities.Role;
import com.app.entities.SaltValue;
import com.app.entities.Schedule;
import com.app.entities.SlotSchedule;
import com.app.entities.Slots;
import com.app.entities.User;
import com.app.repositories.AddressRepository;
import com.app.repositories.AppointmentRepository;
import com.app.repositories.DoctorRepository;
import com.app.repositories.QuestionsRepository;
import com.app.repositories.RoleRepository;
import com.app.repositories.ScheduleRepository;
import com.app.repositories.UserRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository drepo;
	
	@Autowired
	RoleRepository rrepo;
	
	@Autowired
	QuestionsRepository qrepo;
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	AddressRepository arepo;
	
	@Autowired
	ScheduleRepository srepo;
	
	@Autowired
	AppointmentRepository apprepo;
	
	@Autowired
	SaltValue saltval;
	
	public Doctor register(DummyDoctor doc)
	{
		Role role = new Role(2,"Doctor");
		Questions que = new Questions(doc.getQuestion_id());
		Address add=new Address(doc.getArea(),doc.getCity(),doc.getState(),doc.getPincode());
		arepo.save(add);
		
		String encryption=Passwordbasedencryption.generateSecurePassword(doc.getPassword(),saltval.getSalt());
		
		User u=new User(doc.getFname(),doc.getLname(),doc.getEmail(),encryption,doc.getContact_no(),doc.getGender(),doc.getAnswer(),add,role,que);
		urepo.save(u);
		
		Doctor dr=new Doctor(doc.getQualification(),doc.getSpecialization(),doc.getDepartment(),doc.getType(),doc.getExperience(),doc.getImr_no(),u);
		return drepo.save(dr);
	}
	
	public List<Doctor> getAllDoctors()
	{
		return drepo.findAll();
	}
	
	public Doctor getDoctorByUId(int user_id)
	{
		User u=urepo.findById(user_id).get();  //findById returns optional---use get method to retrieve
		
		return drepo.getDoctorByUId(u);
	}
	
	public Doctor getDoctorByDId(int doctor_id)
	{	
		return drepo.findById(doctor_id).get();
	}
	
	public List<Doctor> getDoctorsByDept(String dept)
	{
		return drepo.getDoctorsByDept(dept);
	}
	
	public Schedule addSchedule(Schedule sch)
	{
		return srepo.save(sch);
	}
	
	public List<String> getDepartments()
	{
		return drepo.getDepartments();
	}
	
	public List<SlotSchedule> getSchedule(int did)
	{
		List<Schedule> list =srepo.getByDoctorId(did);
		List<SlotSchedule> sl=new ArrayList<>();
		
		for(Schedule s:list)
		{
			SlotSchedule ss=new SlotSchedule();
			System.out.println(s.getDate());
			ss.setDate(s.getDate());
			
			try 
			{
					LocalTime st=s.getStart_time().toLocalTime();
					LocalTime et=s.getEnd_time().toLocalTime();
					List<Slots> tl=new ArrayList<>();
					do
					{
						Slots slot=new Slots();
						slot.setSlot_time(st);
						tl.add(slot);
						st=st.plusMinutes(30);
					}while(!(st.equals(et)));
					ss.setSlots(tl);
					sl.add(ss);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		//changing status if slot is already booked
		Doctor d=drepo.getDoctorByDId(did);
		
		List<Appointment> app_list=apprepo.getAppointmentsofDoctor(d);
		
		for(SlotSchedule ssl:sl)
		{
			for(Appointment ap:app_list)
			{
				if(ssl.getDate().equals(ap.getDate()))
				{
					
					for(Slots slots:ssl.getSlots())
					{
						LocalTime ti=ap.getSlot().toLocalTime();
						if(slots.getSlot_time().equals(ti))
						{
							slots.setStatus(0);
						}
					}
				}
			}
		}
		return sl;
	}
	
	
	public List<Appointment> getAppointmentsofDoctor(int did)
	{
		Doctor doc=getDoctorByDId(did);
		
		return apprepo.getAppointmentsofDoctor(doc);
	}
}
