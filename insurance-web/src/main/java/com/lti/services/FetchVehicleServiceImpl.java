package com.lti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.FetchVehicleDao;
import com.lti.entities.BikeModel;
import com.lti.entities.CarModel;
import com.lti.exceptions.HrException;

@Service
public class FetchVehicleServiceImpl implements FetchVehicleService {

	@Autowired
	private FetchVehicleDao dao;
	public Map<String, Map<String,List<String>>> getCarList() throws HrException {
		
		return dao.getCarList();
	}
	public ArrayList<BikeModel> getBikeList() throws HrException {
			
			return dao.getBikeList();
		}

}
