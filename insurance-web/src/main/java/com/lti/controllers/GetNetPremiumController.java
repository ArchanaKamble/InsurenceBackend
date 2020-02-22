package com.lti.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.Insurers;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;
import com.lti.services.GetNetPremiumService;

@RestController
@CrossOrigin
public class GetNetPremiumController {

	@Autowired
	GetNetPremiumService service;
	
//	@GetMapping('/')
//	public String startpage()
//	{
//		return ""
//	}
	@GetMapping(value="/getPremium", produces="application/json")
	public @ResponseBody  ArrayList<ResultOfPremium> getNetPremium(@RequestParam int insuranceId){
		
		 ArrayList<ResultOfPremium> result = null;
		System.out.println("insuranceId="+insuranceId);
		try {
			result = service.getPremium(insuranceId);
		} catch (HrException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	@GetMapping(value="/listInsurers", produces="application/json")
	public @ResponseBody List<Insurers> getUserList(){
		
		ArrayList<Insurers> userList = null;
		try {
			userList = service.getInsurerList();
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	
	@PutMapping(value = "/showPremium", produces="application/json")
	public @ResponseBody PremiumShow showPremium(@RequestBody Provider provider){
		PremiumShow show = null;
		try {
			show =service.showPremium(provider);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return show;
		
	}
}
