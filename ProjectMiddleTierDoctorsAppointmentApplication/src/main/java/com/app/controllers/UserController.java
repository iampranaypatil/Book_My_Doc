package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Login;
import com.app.entities.Passwordbasedencryption;
import com.app.entities.QuestionAnswer;
import com.app.entities.SaltValue;
import com.app.entities.User;
import com.app.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Transactional
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@Autowired
	SaltValue saltval;
	/*
	@PostMapping("/login")
	public User loginCheck(@RequestBody Login l)
	{
		return uservice.getLogin(l.getEmail(), l.getPassword());
	}
	*/
	
	@PostMapping("/login")
	public User loginCheck(@RequestBody Login l)
	{
		System.out.println(l.getPassword());
		String encryption=Passwordbasedencryption.generateSecurePassword(l.getPassword(),saltval.getSalt());
		l.setPassword(encryption);
		System.out.println(l.getPassword());
		return uservice.getLogin(l.getEmail(), l.getPassword());
	}
	
	@GetMapping("/getQuestionAnswer")
	public QuestionAnswer getQuestionAnswer(@RequestParam("email") String email)
	{
		return uservice.getQuestionAnswer(email);
	}
	
	@PostMapping(value="/changePassword/{email}")
	public boolean changePassword(@PathVariable ("email")String email,@RequestBody String password) {
		
		boolean flag=true;
		try
		{
			String encryption=Passwordbasedencryption.generateSecurePassword(password,saltval.getSalt());
			flag=uservice.changePassword(email,encryption);
		}
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
	}
	
	
	
	
	
}
