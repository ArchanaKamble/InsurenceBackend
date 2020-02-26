package com.lti.daos;

import java.util.ArrayList;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;



public interface RegistrationDao {
	public boolean addUser(Users user) throws HrException;
	
	public ArrayList<Users> getUserList() throws HrException;
	public Users checkCredentials(String emailId, String pass);
	
}
