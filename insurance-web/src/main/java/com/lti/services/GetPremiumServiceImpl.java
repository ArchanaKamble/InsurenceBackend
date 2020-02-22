package com.lti.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.daos.GetNetPremiumDao;
import com.lti.entities.Insurers;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;

@Service
public class GetPremiumServiceImpl implements GetNetPremiumService {

	@Autowired
	private GetNetPremiumDao dao;
	public  ArrayList<ResultOfPremium> getPremium(int insuranceId) throws HrException {
		
		return dao.getPremium(insuranceId);
	}
	public ArrayList<Insurers> getInsurerList() throws HrException {
		return dao.getInsurerList();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public PremiumShow showPremium(Provider provider) throws HrException {
		
		return dao.showPremium(provider);
	}
}
