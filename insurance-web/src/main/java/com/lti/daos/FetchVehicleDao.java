package com.lti.daos;

import java.util.ArrayList;

import com.lti.entities.BikeModel;
import com.lti.entities.CarModel;
import com.lti.exceptions.HrException;

public interface FetchVehicleDao {

	public ArrayList<CarModel> getCarList() throws HrException;
	public ArrayList<BikeModel> getBikeList() throws HrException;
}
