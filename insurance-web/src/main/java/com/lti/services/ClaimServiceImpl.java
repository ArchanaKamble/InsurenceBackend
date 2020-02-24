package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.daos.ClaimDao;
import com.lti.entities.Claim;
import com.lti.exceptions.HrException;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	ClaimDao  dao;
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Claim getClaim(Claim claim) throws HrException {
		
		return dao.addClaim(claim);
	}

	
}
