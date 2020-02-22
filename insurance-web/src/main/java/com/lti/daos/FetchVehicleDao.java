package com.lti.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lti.entities.BikeModel;
import com.lti.entities.CarModel;
import com.lti.exceptions.HrException;

public interface FetchVehicleDao {

	public Map<String, Map<String, List<String>>>  getCarList() throws HrException;
	public ArrayList<BikeModel> getBikeList() throws HrException;
}
