package com.lti.daos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lti.entities.AdminPageFields;
import com.lti.entities.InsuranceDetails;
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
	//changes made
	public List<Insurers> getInsurers(int insuranceId) throws HrException{
		String strQry = "from Insurers";
		Query qry4 = manager.createQuery(strQry);
		List<Insurers> list=qry4.getResultList();
		return list;
	}
	
	public InsuranceDetails insuranceDetails(int insuranceId) throws HrException {
		
		Query qry5 = manager.createQuery("Select e from InsuranceDetails e where e.insuranceId=:arg");
		qry5.setParameter("arg", insuranceId);
		InsuranceDetails details = (InsuranceDetails) qry5.getSingleResult();
		System.out.println("price"+details.getCarId());
		System.out.println("ageOfCar"+details.getAgeOfCar());
		return details;
	}
	public double getPrice(String vehicleType,int carId) throws HrException {
		Query qry3 = manager.createQuery("Select e.marketPrice from "+vehicleType+" e where e.carId=:arg1");
		qry3.setParameter("arg1",carId);
		double price;
		try {
			 price =Double.parseDouble((String) qry3.getSingleResult());
		}
		catch(Exception e) {
			e.printStackTrace();
			price=0;
		}
		return price;
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
		return show;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Insurers editInsurer(Insurers insurer) throws HrException {
		Insurers in = new Insurers();
		String strQry = "from Insurers e where e.insurersId=:arg ";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("arg", insurer.getInsurersId());
		in=(Insurers) qry.getSingleResult();
		in.setComprehensive(insurer.getComprehensive());
		in.setNcb(insurer.getNcb());
		in.setThirdPartyLiability(insurer.getThirdPartyLiability());
		return in;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<AdminPageFields> showAdmin() throws HrException {
		List<AdminPageFields>  ad = new ArrayList<AdminPageFields>();
		String strQry = "from Plans";
		Query qry = manager.createQuery(strQry);
		List<Plans> lst=qry.getResultList();
		System.out.println(lst);
		AdminPageFields admin= new AdminPageFields();
		for(Plans plan : lst){
			String strQry2 = "Select e from InsuranceDetails e where e.insuranceId=:arg";
			Query qry2 = manager.createQuery(strQry2);
			System.out.println(plan.getInsuranceId());
			qry2.setParameter("arg", plan.getInsuranceId());
			InsuranceDetails insurance= (InsuranceDetails) qry2.getSingleResult();
			System.out.println("-------------userId"+insurance.getUserId());
			String strQry3 = "Select e.name from Users e where e.userId=:arg ";
			Query qry3 = manager.createQuery(strQry3);
			qry3.setParameter("arg", insurance.getUserId());
			String name= (String) qry3.getSingleResult();
			System.out.println("name"+name);
			admin.setUserId(insurance.getUserId());
			admin.setPlanId(plan.getPlanId());
			admin.setName(name);
			admin.setPrice(plan.getPrice());
			admin.setProviderName(plan.getProviderName());
			admin.setStatus(plan.getStatus());
			admin.setTypeOfPlan(plan.getTypeOfPlan());
			
			ad.add(admin);
			admin= new AdminPageFields();
		}
		
		return ad;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Users adminUpdate(AdminPageFields admin) throws HrException {
		
		AdminPageFields ad = new AdminPageFields();
		String strQry = "from Plans p where p.planId=:planId";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("planId", admin.getPlanId());
		Plans plan = (Plans) qry.getSingleResult();
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		plan.setStartDate(today);
		cal.add(Calendar.YEAR, plan.getDuration()); // to get previous year add -1
	    Date nextYear = cal.getTime();
	    plan.setEndDate(nextYear);
		plan.setStatus(admin.getStatus());
		//ad.setStatus(admin.getStatus());
		
		String strQry1 = "from Users p where p.userId=:arg";
		Query qry1 = manager.createQuery(strQry1);
		qry1.setParameter("arg",admin.getUserId());
		Users user= (Users) qry1.getSingleResult();
		int policyNo=(int)(Math.random()*9000)+1000;
		user.setPolicyNo(policyNo);
		Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/lntinfotech/Desktop/"+policyNo+".pdf"));
	         document.open();
	         document.add(new Paragraph("Your insurance is Approved with cost"+admin.getPrice()+"from Insurers company"+admin.getProviderName()+". Your PolicyNo is "+policyNo));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
		
		return user;
	}
}

