package com.lti.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;
import com.lti.services.RegistrationService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private RegistrationService service;
	
	@Autowired
	private JavaMailSender sender;
	
	@ResponseBody
	@PostMapping(value="/register", consumes="application/json")
	public int addNewUser(@RequestBody Users user)
	{
		try {
			service.addUser(user);
			final String emailId = user.getEmail();
			MimeMessagePreparator prep = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
					mimeMessage.setFrom(new InternetAddress("archanask267@gmail.com"));
					mimeMessage.setSubject("Insurance");
					mimeMessage.setText("Registration process is completed successfully on Bunk Insurance");
				}
			};
			sender.send(prep);
		} catch (HrException e) {
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
			e.printStackTrace();
		}
		return userList;
	}
	
	@PostMapping(value="/login", produces="application/json")
	public @ResponseBody int checkCredentials(@RequestParam String emailId,@RequestParam String pass) {
		Users user=null;
		user= service.checkCredentials(emailId, pass);
		if(user== null){
			return 0;
		}
		else if(pass.equals(user.getPassword())){
			return user.getUserId();
		}
		else
		{
			return 0;
		}
		
	}	
	
}
