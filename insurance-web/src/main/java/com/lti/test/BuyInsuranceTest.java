package com.lti.test;

import org.junit.Test;

import com.lti.daos.InsuranceDaoImpl;
import com.lti.entities.BuyInsurance;
import com.lti.exceptions.HrException;
import com.lti.services.InsuranceServiceImpl;

public class BuyInsuranceTest {

	@Test
	public void addInsuranceDetails(){
		BuyInsurance insurance = new BuyInsurance();
		insurance.setAgeOfCar(2);
		insurance.setBrand("Maruti");
		insurance.setChasisNo("seafed");
		insurance.setEngineNo("sadfedf");
		insurance.setLicenseNo("sadfwedg");
		insurance.setModel("Alto");
		insurance.setTypeOfVehicle("CarModel");
		insurance.setUserId(106);
		insurance.setVariant("LX CNG(796CC)");
		InsuranceDaoImpl dao = new InsuranceDaoImpl();
		try {
			dao.addDetails(insurance);
		} catch (HrException e) {
			e.printStackTrace();
		}
		
	}
}
