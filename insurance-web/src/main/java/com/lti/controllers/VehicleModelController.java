package com.lti.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.BikeModel;
import com.lti.entities.CarModel;
import com.lti.exceptions.HrException;
import com.lti.services.FetchVehicleService;

@RestController
@CrossOrigin
public class VehicleModelController {

	@Autowired
	FetchVehicleService service;
	
	@GetMapping(value="/carList", produces="application/json")
	public @ResponseBody Map<String, Map<String, List<String>>> getCarList(){
		
		Map<String, Map<String,List<String>>> carModelList = null;
		try {
			carModelList = service.getCarList();
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return carModelList;
	}
	@GetMapping(value="/bikeList", produces="application/json")
	public @ResponseBody List<BikeModel> getBikeList(){
		
		ArrayList<BikeModel> bikeModelList = null;
		try {
			bikeModelList = service.getBikeList();
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bikeModelList;
	}
}
