package com.lti.daos;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;


@Repository
public class RegistrationDaoImp implements RegistrationDao{

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addUser(Users user) throws HrException {
		manager.persist(user);
		return true;
	}
	public ArrayList<Users> getUserList() throws HrException {
		String strQry = "from Users";
		Query qry = manager.createQuery(strQry);
		List<Users> lst=qry.getResultList();
		
		return (ArrayList<Users>) lst;
	}
	public Users checkCredentials(String emailId, String pass) {
		String strQry = "from Users u where u.email=:email";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("email",emailId);
		try {
			Users user = (Users) qry.getSingleResult();
			return user;
		} catch(Exception e){
			return null;
		}
		
	}
	

}
