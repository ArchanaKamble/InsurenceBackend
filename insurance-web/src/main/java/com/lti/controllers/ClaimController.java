package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.Claim;
import com.lti.exceptions.HrException;
import com.lti.services.ClaimService;

@RestController
@CrossOrigin
public class ClaimController {

	@Autowired
	ClaimService service;
	
	@PostMapping(value = "/claim",produces="application/json")
	public @ResponseBody Claim addClaim(@RequestBody Claim claim) {
		Claim c = null;
		System.out.println(claim);
		try {
			c= service.getClaim(claim);
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
