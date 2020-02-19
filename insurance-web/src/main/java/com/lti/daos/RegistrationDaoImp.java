package com.lti.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

}
