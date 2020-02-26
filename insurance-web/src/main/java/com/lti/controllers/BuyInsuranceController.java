package com.lti.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.BuyInsurance;
import com.lti.entities.Plans;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;
import com.lti.services.InsuranceService;
import com.lti.services.RegistrationService;

@RestController
@CrossOrigin
public class BuyInsuranceController {

	@Autowired
	private InsuranceService service;
	
	@ResponseBody
	@PostMapping(value="/buy-insurance", consumes="application/json")
	public int addInsuranceDetails(@RequestBody BuyInsurance insurance)
	{
//		insurance.setAgeOfCar(2);
//		insurance.setBrand("Maruti");
//		insurance.setChasisNo("seafed");
//		insurance.setEngineNo("sadfedf");
//		insurance.setInsuranceId(1);
//		insurance.setLicenseNo("sadfwedg");
//		insurance.setModel("Swift");
//		insurance.setTypeOfVehicle("four-wheeler");
//		insurance.setUserId(102);
//		insurance.setVariant("LXI(1298CC)");
//		insurance.setVehiclePrice(50000000);
		int insuranceId = 0;
		try {
			 insuranceId=service.addDetails(insurance);
			
		} catch (HrException e) {
			e.printStackTrace();
		}
		return insuranceId;
	}
	@ResponseBody
	@PostMapping(value="/plan-insurance", consumes="application/json")
	public int addPlan(@RequestBody Plans plan)
	{
		int planId = 0;
		System.out.println(plan);
		try {
			planId=service.addPlan(plan);
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planId;
	}
	
}
