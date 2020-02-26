package com.lti.daos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lti.entities.AdminPageFields;
import com.lti.entities.InsuranceDetails;
import com.lti.entities.Insurers;
import com.lti.entities.Plans;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;

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
		int premiumAmount = (int) provider.getFinalPremium();
		int taxAppliedValue =(int) (0.18 *premiumAmount)+premiumAmount;
		String strQry = "Select e from Plans e where e.insuranceId=:arg and e.planId=:arg1";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("arg",provider.getInsuranceid());
		qry.setParameter("arg1", provider.getPlanId());
		Plans plan =(Plans) qry.getSingleResult();
	
		show.setChosenPlan(plan.getTypeOfPlan()); 
		show.setPremiumAmount(premiumAmount);  
		show.setTaxAppliedValue(taxAppliedValue);  
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
		AdminPageFields admin= new AdminPageFields();
		for(Plans plan : lst){
			String strQry2 = "Select e from InsuranceDetails e where e.insuranceId=:arg";
			Query qry2 = manager.createQuery(strQry2);
			qry2.setParameter("arg", plan.getInsuranceId());
			InsuranceDetails insurance= (InsuranceDetails) qry2.getSingleResult();
			String strQry3 = "Select e.name from Users e where e.userId=:arg ";
			Query qry3 = manager.createQuery(strQry3);
			qry3.setParameter("arg", insurance.getUserId());
			String name= (String) qry3.getSingleResult();
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
		
		String strQry = "from Plans p where p.planId=:planId";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("planId", admin.getPlanId());
		Plans plan = (Plans) qry.getSingleResult();
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		plan.setStartDate(today);
		cal.add(Calendar.YEAR, plan.getDuration()); 
	    Date nextYear = cal.getTime();
	    plan.setEndDate(nextYear);
		plan.setStatus(admin.getStatus());
		
		
		String strQry1 = "from Users p where p.userId=:arg";
		Query qry1 = manager.createQuery(strQry1);
		qry1.setParameter("arg",admin.getUserId());
		Users user= (Users) qry1.getSingleResult();
		int policyNo=(int)(Math.random()*9000)+1000;
		user.setPolicyNo(policyNo);
		Document document = new Document();
	      try
	      {
	    	  PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/lntinfotech/Desktop/pdfs/"+policyNo+".pdf"));
	         	document.open();
	         	Image img;
	         	try {
					img = Image.getInstance("C:\\Users\\lntinfotech\\Downloads\\icons8-vehicle-insurance-32.png");
					img.scaleAbsolute(50f, 50f);
		         	document.add(img);
		         	document.add(new Paragraph("BUNK INSURANCE"));
					document.add(new Paragraph("\n"));
					document.add(new Paragraph("\n"));
					document.add(new Paragraph("Congratulations! Dear "+user.getName()+" , your policy number is "+policyNo+" and your insurance is approved."));
					document.add(new Paragraph("GUIDELINES"));
					document.add(new Paragraph("This is an introductory guide to provide you with a better understanding of what general insurance is and what you must know when buying motor insurance policies and making claims. "));
					document.add(new Paragraph("Types of motor policies "));
					document.add(new Paragraph("When you buy a motor vehicle, you need to buy a motor insurance. There are, however, many types of motor insurance policies available. "));
					document.add(new Paragraph("The common types are: "));
					document.add(new Paragraph("• Third party cover - This policy insures you against claims for bodily injuries or deaths caused to other persons (known as the third party), as well as loss or damage to third party property caused by your vehicle. "));
					document.add(new Paragraph("• Comprehensive cover - This policy provides the widest coverage, i.e. third- party bodily injury and death, third party property loss or damage and loss or damage to your own vehicle due to accidental fire, theft or an accident. "));
					document.add(new Paragraph("What you should do in the event of an accident/loss? "));
					document.add(new Paragraph("• Take notes of the accident – If you are involved in a motor accident, take notes of the accident, i.e. the names and addresses of all drivers and passengers involved, vehicle registration numbers, make and model of each vehicle involved, the drivers’ licence numbers and insurance identification as well as the names and addresses of as many witnesses as possible "));
					document.add(new Paragraph("• Make a police report – You are required by law to lodge a police report within 24 hours of a road accident. "));
					document.add(new Paragraph("• Notify your insurance company – You must notify your insurance company in writing with full details as soon as possible. Depending on the type of claim you intend to make, you may have to notify other insurance. If you fail to report the accident, you will be liable for your own loss as well as any third -party claim against you. "));
					document.add(new Paragraph("Price"));
					document.add(new Paragraph(" The price you pay for your vehicle insurance will depend on the type of policy selected. The insurance premium charged by your insurance company is the standard minimum rate in accordance with the depreciation rate.  "));
					document.add(new Paragraph("For Any Queries: "));
					document.add(new Paragraph("Contact No:8789456123 "));
					
			        document.add(new Paragraph("Email: bunkinsurance@gmail.com "));
		         	
	         	} catch (MalformedURLException e) {
				
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	         	
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

