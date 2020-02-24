package com.lti.controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpMethod;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.BuyInsurance;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;
import com.lti.services.RegistrationService;
import com.lti.services.RegistrationServiceImp;
import com.sun.xml.txw2.TxwException;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private RegistrationService service;
	
	@Autowired
	private JavaMailSender sender;
	@Autowired
    private SimpleMailMessage preConfiguredMessage;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    dateFormat.setLenient(true);
	    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); 
	}
	
	@ResponseBody
	@PostMapping(value="/register", consumes="application/json")
	public int addNewUser(@RequestBody Users user,HttpServletResponse response)
	{
		
		//response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		System.out.println(user);
//		Users user =new Users();
//	user.setName("Archana");
//	user.setEmail("arcgha");
//	user.setPassword("ade");
//	user.setDob(LocalDate.of(2019, 10, 20));
//	user.setContact(7219212);
//	user.setAddress("satara");
		try {
			service.addUser(user);
			
	//		System.out.println(user);
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user.getUserId();
	}
	
	@GetMapping(value="/list", produces="application/json")
	public @ResponseBody List<Users> getUserList(){
		
		ArrayList<Users> userList = null;
		try {
			userList = service.getUserList();
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	
	@PostMapping(value="/login", produces="application/json")
	public @ResponseBody int checkCredentials(@RequestParam String emailId,@RequestParam String pass) {
		Users user=null;
		try {
			user= service.checkCredentials(emailId, pass);
			
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pass.equals(user.getPassword())){
			return user.getUserId();
		}
		else
		{
			return 0;
		}
		
	}
	

	
	
	
	
	
}
