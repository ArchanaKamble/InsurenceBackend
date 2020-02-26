package com.lti.services;
import com.lti.entities.Claim;
import com.lti.exceptions.HrException;


public interface ClaimService {

	public Claim getClaim(Claim claim)  throws HrException;
	
}
