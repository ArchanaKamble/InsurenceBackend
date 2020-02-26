package com.lti.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entities.BuyInsurance;

import com.lti.entities.InsuranceDetails;
import com.lti.entities.Plans;

import com.lti.exceptions.HrException;

@Repository
public class InsuranceDaoImpl implements InsuranceDao{

	@PersistenceContext
	private EntityManager manager;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int addDetails(BuyInsurance insurance) throws HrException {
		
		InsuranceDetails insuranceDetails = new InsuranceDetails();
		insuranceDetails.setAgeOfCar(insurance.getAgeOfCar());
		insuranceDetails.setChasisNo(insurance.getChasisNo());
		insuranceDetails.setEngineNo(insurance.getEngineNo());
		insuranceDetails.setInsuranceId(insurance.getInsuranceId());
		insuranceDetails.setLicenseNo(insurance.getLicenseNo());
		insuranceDetails.setTypeOfVehicle(insurance.getTypeOfVehicle());
		insuranceDetails.setUserId(insurance.getUserId());
		
		Query qry = manager.createQuery("Select e.carId from "+insurance.getTypeOfVehicle()+" e where e.brand=:arg1 and  e.model=:arg2 and  e.variant=:arg3");
		qry.setParameter("arg1", insurance.getBrand());
		qry.setParameter("arg2", insurance.getModel());
		qry.setParameter("arg3", insurance.getVariant());
		int carId  = (Integer)qry.getSingleResult();
		insuranceDetails.setCarId(carId);
		manager.persist(insuranceDetails);

		return insuranceDetails.getInsuranceId();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int addPlan(Plans plan) throws HrException {
		manager.persist(plan);
		return plan.getPlanId();
	}
}
