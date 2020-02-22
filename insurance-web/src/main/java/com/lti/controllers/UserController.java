package com.lti.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.BuyInsurance;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;
import com.lti.services.RegistrationService;
import com.lti.services.RegistrationServiceImp;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private RegistrationService service;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    dateFormat.setLenient(true);
	    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); 
	}
	
	@ResponseBody
	@PostMapping(value="/register", consumes="application/json")
	public void addNewUser(@RequestBody Users user,HttpServletResponse response)
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
	
	


	
	
	
	
	
}
