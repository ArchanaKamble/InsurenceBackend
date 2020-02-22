package com.lti.services;

import com.lti.entities.BuyInsurance;
import com.lti.entities.Plans;
import com.lti.exceptions.HrException;

public interface InsuranceService {

	public boolean addDetails(BuyInsurance insurance) throws HrException;
	public boolean addPlan(Plans plan) throws HrException;
}
