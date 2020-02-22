package com.lti.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entities.Insurers;
import com.lti.entities.Plans;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;

@Repository
public class GetNetPremiumDaoImpl implements GetNetPremiumDao {

	@PersistenceContext
	EntityManager manager;
	public ArrayList<Insurers> getInsurerList() throws HrException {
		String strQry = "from Insurers";
		Query qry = manager.createQuery(strQry);
		List<Insurers> lst=qry.getResultList();
		
		return (ArrayList<Insurers>) lst;
	}
	public ArrayList<ResultOfPremium> getPremium(int insuranceId) throws HrException {
		double percentOfDepreciation;
		double valueOfDepreciation;
		int IDV = 0;
		double ownDamagePremium;
		int netPremium = 0;
		ResultOfPremium result = new ResultOfPremium();
		String strQry = "from Insurers";
		Query qry4 = manager.createQuery(strQry);
		List<Insurers> list=qry4.getResultList();
		ArrayList<ResultOfPremium> resultList = new ArrayList<ResultOfPremium>();
		
		Query qry = manager.createQuery("Select e.carId from InsuranceDetails e where e.insuranceId=:arg");
		qry.setParameter("arg", insuranceId);
		int carId  = (Integer)qry.getSingleResult();
		System.out.println("price"+carId);
//		
		Query qry2 = manager.createQuery("Select e.ageOfCar from InsuranceDetails e where e.insuranceId=:arg1");
		qry2.setParameter("arg1", 1);
		int ageOfCar = (Integer) qry2.getSingleResult();
		System.out.println("ageOFcar"+ageOfCar);
//		
		Query qry3 = manager.createQuery("Select e.marketPrice from CarModel e where e.carId=:arg1");
		qry3.setParameter("arg1", carId);
		double price;
		try
		{
			 price =Double.parseDouble((String) qry3.getSingleResult());
		}catch(Exception e){e.printStackTrace();
		price=0;}//long price = (Long) qry3.getSingleResult();
		//System.out.println("ageOFcar"+price);
//		
		//int carId =3;
		//int ageOfCar=1;
		//double price =514000;
		for(Insurers insurers : list)
		{
			if(ageOfCar < 1) {
//				percentOfDepreciation = 0.15;
//				valueOfDepreciation  = percentOfDepreciation * price;
//			
				result.setProviderName(insurers.getProviderName());
				result.setIDV( (price *0.85)+ insurers.getComprehensive() + insurers.getThirdPartyLiability());
				ownDamagePremium = 0.0197 * result.getIDV();
				double finalODPremium = ownDamagePremium-(insurers.getNcb() * ownDamagePremium)/100 ; 
				result.setFinalNetPremium(finalODPremium );
				//netPremium=hdfc.finalPremium(ownDamagePremium);
				System.out.println("----------------------------------------------------");
				System.out.println("ownDamagePremium"+ownDamagePremium+"finalODPremium"+finalODPremium+"---"+result.getFinalNetPremium());
				resultList.add(result);
				result = new ResultOfPremium();
				
			}
			else if( ageOfCar >=1 && ageOfCar <2) {
//				percentOfDepreciation = 0.20;
//				System.out.println(insurers.toString());
//				valueOfDepreciation  = percentOfDepreciation * price;
				result.setProviderName(insurers.getProviderName());
				result.setIDV(( price *0.8)+ insurers.getComprehensive() + insurers.getThirdPartyLiability());
				ownDamagePremium = 0.0197 * result.getIDV();
				double finalODPremium = ownDamagePremium-(insurers.getNcb() * ownDamagePremium)/100 ; 
				result.setFinalNetPremium(finalODPremium );
				System.out.println(netPremium);
				System.out.println(result);
				System.out.println("----------------------------------------------------");
				System.out.println("ownDamagePremium"+ownDamagePremium+"finalODPremium"+finalODPremium+"---"+result.getFinalNetPremium());
				resultList.add(result);
				result = new ResultOfPremium();
			}
			else if( ageOfCar >=2 && ageOfCar <3) {
//				percentOfDepreciation = 0.30;
//				valueOfDepreciation  = percentOfDepreciation * price;
				result.setProviderName(insurers.getProviderName());
				result.setIDV( (price *0.7)+ insurers.getComprehensive() + insurers.getThirdPartyLiability());
				ownDamagePremium = 0.0197 * result.getIDV();
				double finalODPremium = ownDamagePremium- (insurers.getNcb() * ownDamagePremium)/100 ; 
				result.setFinalNetPremium(finalODPremium );
				System.out.println("----------------------------------------------------");
				System.out.println("ownDamagePremium"+ownDamagePremium+"finalODPremium"+finalODPremium+"---"+result.getFinalNetPremium());
				resultList.add(result);
				result = new ResultOfPremium();
			}
			else if( ageOfCar >=3 && ageOfCar <4) {
//				percentOfDepreciation = 0.40;
//				valueOfDepreciation  = percentOfDepreciation * price;
				result.setProviderName(insurers.getProviderName());
				result.setIDV( (price *0.6)+ insurers.getComprehensive() + insurers.getThirdPartyLiability());
				ownDamagePremium = 0.0197 * result.getIDV();
				double finalODPremium = ownDamagePremium- (insurers.getNcb() * ownDamagePremium)/100 ; 
				result.setFinalNetPremium(finalODPremium );
				System.out.println("----------------------------------------------------");
				System.out.println("ownDamagePremium"+ownDamagePremium+"finalODPremium"+finalODPremium+"---"+result.getFinalNetPremium());
				resultList.add(result);
				result = new ResultOfPremium();
			}
			else if( ageOfCar >=4 && ageOfCar <5) {
//				percentOfDepreciation = 0.50;
//				valueOfDepreciation  = percentOfDepreciation * price;
				result.setProviderName(insurers.getProviderName());
				result.setIDV( (price *0.5)+ insurers.getComprehensive() + insurers.getThirdPartyLiability());
				ownDamagePremium = 0.0197 * result.getIDV();
				double finalODPremium = ownDamagePremium- (insurers.getNcb() * ownDamagePremium)/100 ; 
				result.setFinalNetPremium(finalODPremium );
				System.out.println("----------------------------------------------------");
				System.out.println("ownDamagePremium"+ownDamagePremium+"finalODPremium"+finalODPremium+"---"+result.getFinalNetPremium());
				resultList.add(result);
				result = new ResultOfPremium();
			}
		}
		
		return resultList;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public PremiumShow showPremium(Provider provider) throws HrException {
		PremiumShow show = new PremiumShow();
		System.out.println(provider);
		int premiumAmount = (int) provider.getFinalPremium();
		int taxAppliedValue =(int) (0.18 *premiumAmount)+premiumAmount;
		String strQry = "Select e from Plans e where e.insuranceId=:arg and e.planId=:arg1";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("arg",provider.getInsuranceid());
		qry.setParameter("arg1", provider.getPlanId());
		Plans plan =(Plans) qry.getSingleResult();
	
		show.setChosenPlan(plan.getTypeOfPlan());  //plans update 
		show.setPremiumAmount(premiumAmount);  
		show.setTaxAppliedValue(taxAppliedValue);  //price update in plans table
		show.setInsuranceId(provider.getInsuranceid());
		
		plan.setPrice(taxAppliedValue);
		plan.setProviderName(provider.getName());
		return null;
	}

}

