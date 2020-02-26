package com.lti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lti.entities.BikeModel;
import com.lti.exceptions.HrException;

public interface FetchVehicleService {

	public Map<String, Map<String,List<String>>> getCarList() throws HrException;
	public ArrayList<BikeModel> getBikeList() throws HrException;
}
