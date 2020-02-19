package com.lti.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.daos.RegistrationDao;
import com.lti.daos.RegistrationDaoImp;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;


@Service
public class RegistrationServiceImp implements RegistrationService{

	@Autowired
	private RegistrationDao dao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean addUser(Users user) throws HrException {
		
		return dao.addUser(user);
		
	}

	public ArrayList<Users> getUserList() throws HrException {
		return dao.getUserList();
	}
	
}
