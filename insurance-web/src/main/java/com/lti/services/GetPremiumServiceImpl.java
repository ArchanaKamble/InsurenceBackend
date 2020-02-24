package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.daos.GetNetPremiumDao;
import com.lti.entities.AdminPageFields;
import com.lti.entities.InsuranceDetails;
import com.lti.entities.Insurers;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;

@Service
public class GetPremiumServiceImpl implements GetNetPremiumService {

	@Autowired
	private GetNetPremiumDao dao;
	
	public ArrayList<Insurers> getInsurerList() throws HrException {
		return dao.getInsurerList();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public PremiumShow showPremium(Provider provider) throws HrException {
		
		return dao.showPremium(provider);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<AdminPageFields> showAdmin() throws HrException {
		
		return dao.showAdmin();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Insurers editInsurer(Insurers insurer) throws HrException {
		// TODO Auto-generated method stub
		return dao.editInsurer(insurer);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Users adminUpdate(AdminPageFields admin) throws HrException {
		// TODO Auto-generated method stub
		return dao.adminUpdate(admin);
	}
	//changes made
	public ArrayList<ResultOfPremium> getNetPremium(int insuranceId) throws HrException {
		int IDV = 0;
		double ownDamagePremium;
		int netPremium = 0;
		ResultOfPremium result = new ResultOfPremium();
		List<Insurers> list=dao.getInsurers(insuranceId);
		ArrayList<ResultOfPremium> resultList = new ArrayList<ResultOfPremium>();
		
		InsuranceDetails details =dao.insuranceDetails(insuranceId);
		double price=dao.getPrice(details.getTypeOfVehicle(), details.getCarId());
		System.out.println(list);
		System.out.println(details);
		System.out.println(price);
		for(Insurers insurers : list)
		{
			result.setProviderName(insurers.getProviderName());
			result.setIDV( (price *percentOfDepriciaton(details.getAgeOfCar()))+ insurers.getComprehensive() + insurers.getThirdPartyLiability());
			ownDamagePremium = 0.0197 * result.getIDV();
			int finalODPremium = (int) (ownDamagePremium-(insurers.getNcb() * ownDamagePremium)/100) ; 
			result.setFinalNetPremium(finalODPremium );
			System.out.println("----------------------------------------------------");
			System.out.println("ownDamagePremium"+ownDamagePremium+"finalODPremium"+finalODPremium+"---"+result.getFinalNetPremium());
			resultList.add(result);
			result = new ResultOfPremium();
			
		}
		
		return resultList;
	}
	public double percentOfDepriciaton(int ageOfCar) {
		if(ageOfCar < 1)
			return 0.85;
		else if( ageOfCar >=1 && ageOfCar <2)
			return 0.80;
		else if( ageOfCar >=2 && ageOfCar <3)
			return 0.70;
		else if( ageOfCar >=3 && ageOfCar <4)
			return 0.60;
		else 
			return 0.50;
	
	}
}
