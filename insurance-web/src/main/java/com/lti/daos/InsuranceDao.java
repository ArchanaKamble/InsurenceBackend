package com.lti.daos;

import com.lti.entities.BuyInsurance;
import com.lti.entities.Plans;
import com.lti.exceptions.HrException;

public interface InsuranceDao {
	public int addDetails(BuyInsurance insurance) throws HrException;
	public int addPlan(Plans plan) throws HrException;
}
