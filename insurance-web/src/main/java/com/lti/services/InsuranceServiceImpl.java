package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.daos.InsuranceDao;
import com.lti.entities.BuyInsurance;
import com.lti.entities.Plans;
import com.lti.exceptions.HrException;

@Service
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	private InsuranceDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int addDetails(BuyInsurance insurance) throws HrException {
		
		return dao.addDetails(insurance);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int addPlan(Plans plan) throws HrException {
		
		return dao.addPlan(plan);
	}
}
