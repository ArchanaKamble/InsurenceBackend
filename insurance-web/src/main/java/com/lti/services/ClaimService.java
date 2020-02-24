package com.lti.services;

import org.springframework.stereotype.Service;

import com.lti.entities.Claim;
import com.lti.exceptions.HrException;


public interface ClaimService {

	public Claim getClaim(Claim claim)  throws HrException;
	
}
