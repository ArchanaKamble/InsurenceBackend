package com.lti.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entities.BikeModel;
import com.lti.entities.CarModel;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;

@Repository
public class FetchVehicleDaoImp implements FetchVehicleDao {

	@PersistenceContext
	private EntityManager manager;
	
	public ArrayList<CarModel> getCarList() throws HrException {
		String strQry = "from CarModel";
		Query qry = manager.createQuery(strQry);
		List<CarModel> lst=qry.getResultList();
		return (ArrayList<CarModel>) lst;
	}
	public ArrayList<BikeModel> getBikeList() throws HrException {
		String strQry = "from BikeModel";
		Query qry = manager.createQuery(strQry);
		List<BikeModel> lst=qry.getResultList();
		return (ArrayList<BikeModel>) lst;
	}

}
