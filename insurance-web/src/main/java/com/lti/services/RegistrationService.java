package com.lti.services;

import java.util.ArrayList;

import com.lti.entities.BuyInsurance;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;



public interface RegistrationService {

	public boolean addUser(Users user) throws HrException;
	public ArrayList<Users> getUserList() throws HrException;
}
