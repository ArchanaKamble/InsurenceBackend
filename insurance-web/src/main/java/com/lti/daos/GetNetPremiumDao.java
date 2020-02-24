package com.lti.daos;

import java.util.ArrayList;
import java.util.List;

import com.lti.entities.AdminPageFields;
import com.lti.entities.InsuranceDetails;
import com.lti.entities.Insurers;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;

public interface GetNetPremiumDao {
	
	public ArrayList<Insurers> getInsurerList() throws HrException;
	public Insurers editInsurer(Insurers insurer) throws HrException;
	public PremiumShow showPremium(Provider provider) throws HrException;
	public List<AdminPageFields> showAdmin() throws HrException;
	public Users adminUpdate(AdminPageFields admin) throws HrException;
	//changes made
	public List<Insurers> getInsurers(int insuranceId) throws HrException;
	public InsuranceDetails insuranceDetails(int insuranceId) throws HrException;
	public double getPrice(String vehicleType,int carId) throws HrException;
}
