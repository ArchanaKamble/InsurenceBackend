package com.lti.services;
import java.util.ArrayList;
import java.util.List;

import com.lti.entities.AdminPageFields;
import com.lti.entities.Insurers;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;


public interface GetNetPremiumService {

	public ArrayList<Insurers> getInsurerList() throws HrException;
	public Insurers editInsurer(Insurers insurer)  throws HrException;
	public List<AdminPageFields> showAdmin()  throws HrException;
	public Users adminUpdate(AdminPageFields admin)  throws HrException;
	public PremiumShow showPremium(Provider provider) throws HrException;
	public ArrayList<ResultOfPremium> getNetPremium(int insuranceId) throws HrException;
}
