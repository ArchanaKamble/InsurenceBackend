package com.lti.daos;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entities.Claim;
import com.lti.entities.Plans;
import com.lti.entities.ResultOfPremium;
import com.lti.exceptions.HrException;

@Repository
public class ClaimDaoImpl implements ClaimDao{

	@PersistenceContext
	EntityManager manager;
	@Transactional(propagation=Propagation.REQUIRED)
	public Claim addClaim(Claim claim) throws HrException {
		String strQry = "Select e from Plans e where e.insuranceId=:arg";
		Query qry4 = manager.createQuery(strQry);
		qry4.setParameter("arg",claim.getInsuranceId());
		Plans plan = new Plans();
		plan=(Plans) qry4.setFirstResult(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = claim.getStartDate();
		Date date = plan.getEndDate();
		if(date1.compareTo(date)<0){
			Query qry = manager.createQuery("Select e.carId from InsuranceDetails e where e.insuranceId=:arg");
			qry.setParameter("arg", claim.getInsuranceId());
			int carId  = (Integer)qry.getSingleResult();
			System.out.println("price"+carId);
//			
			Query qry2 = manager.createQuery("Select e.ageOfCar from InsuranceDetails e where e.insuranceId=:arg1");
			qry2.setParameter("arg1", claim.getInsuranceId());
			int ageOfCar = (Integer) qry2.getSingleResult();
			System.out.println("ageOFcar"+ageOfCar);
//			
			Query qry3 = manager.createQuery("Select e.marketPrice from CarModel e where e.carId=:arg1");
			qry3.setParameter("arg1", carId);
			double price,percentOfDepreciation;
			int marketprice = 0 ;
			try
			{
				 price =Double.parseDouble((String) qry3.getSingleResult());
			}catch(Exception e){e.printStackTrace();
			price=0;}
			if(ageOfCar < 1) {
				percentOfDepreciation = 0.15;
				marketprice= (int) (price*percentOfDepreciation);
			}
			else if( ageOfCar >=1 && ageOfCar <2) {
				percentOfDepreciation = 0.20;
				marketprice= (int) (price*percentOfDepreciation);
			}
			else if( ageOfCar >=2 && ageOfCar <3) {
				percentOfDepreciation = 0.30;
				marketprice= (int) (price*percentOfDepreciation);
			}
			else if( ageOfCar >=3 && ageOfCar <4) {
				percentOfDepreciation = 0.40;
				marketprice= (int) (price*percentOfDepreciation);
			}
			else if( ageOfCar >=4 && ageOfCar <5) {
				percentOfDepreciation = 0.50;
				marketprice= (int) (price*percentOfDepreciation);
			}
			claim.setPrice(marketprice);
		}
		else{
			
		}
		return null;
	}

}
