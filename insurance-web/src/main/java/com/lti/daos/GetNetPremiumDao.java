package com.lti.daos;

import java.util.ArrayList;

import com.lti.entities.Insurers;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;

public interface GetNetPremiumDao {
	public  ArrayList<ResultOfPremium> getPremium(int insuranceId) throws HrException ;
	public ArrayList<Insurers> getInsurerList() throws HrException;
	public PremiumShow showPremium(Provider provider) throws HrException;
	
}
