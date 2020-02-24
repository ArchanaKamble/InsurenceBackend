package com.lti.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entities.AdminPageFields;
import com.lti.entities.Insurers;
import com.lti.entities.PremiumShow;
import com.lti.entities.Provider;
import com.lti.entities.ResultOfPremium;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;
import com.lti.services.GetNetPremiumService;

@RestController
@CrossOrigin
public class GetNetPremiumController {

	@Autowired
	GetNetPremiumService service;
	@Autowired
	private JavaMailSender sender;
	@Autowired
    private SimpleMailMessage preConfiguredMessage;
//	@GetMapping('/')
//	public String startpage()
//	{
//		return ""
//	}
	@GetMapping(value="/getPremium", produces="application/json")
	public @ResponseBody  ArrayList<ResultOfPremium> getNetPremium(@RequestParam int insuranceId){
		
		 ArrayList<ResultOfPremium> result = null;
		System.out.println("insuranceId="+insuranceId);
		try {
			result = service.getNetPremium(insuranceId);
		} catch (HrException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	@GetMapping(value="/listInsurers", produces="application/json")
	public @ResponseBody List<Insurers> getUserList(){
		
		ArrayList<Insurers> userList = null;
		try {
			userList = service.getInsurerList();
		} catch (HrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	@PostMapping(value = "/edit", produces="application/json")
	public @ResponseBody Insurers editInsurer(@RequestBody Insurers insurer){
		 //insurer = null;
		System.out.println(insurer);
		Insurers in = null;
		try {
			in =service.editInsurer(insurer);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return in;
		
	}
	@PutMapping(value = "/showPremium", produces="application/json")
	public @ResponseBody PremiumShow showPremium(@RequestBody Provider provider){
		PremiumShow show = null;
		try {
			show =service.showPremium(provider);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return show;
		
	}
	@GetMapping(value = "/admin", produces="application/json")
	public @ResponseBody List<AdminPageFields> showAdmin(){
		ArrayList<AdminPageFields> ad = null;
		try {
			ad =(ArrayList<AdminPageFields>) service.showAdmin();
		} catch (HrException e) {
			e.printStackTrace();
		}
		return ad;
		
	}
	@PutMapping(value = "/adminUpdate", produces="application/json")
	public  void adminUpdate(@RequestBody AdminPageFields admin){
		 Users user = null;
		try {
			user = service.adminUpdate(admin);
			final String emailId = user.getEmail();
			final int policyNo= user.getPolicyNo();
			MimeMessagePreparator prep = new MimeMessagePreparator() {
				
				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
					mimeMessage.setFrom(new InternetAddress("archanask267@gmail.com"));
					mimeMessage.setSubject("Insurance2");
					mimeMessage.setText("with atttachment");
					Multipart content = new MimeMultipart();
				
					//Text body part
					MimeBodyPart textBodyPart = new MimeBodyPart();
					textBodyPart.setText("My multipart text");
					
					//Attachment body part
					MimeBodyPart pdf= new MimeBodyPart();
					pdf.attachFile("C:/Users/lntinfotech/Desktop/"+policyNo+".pdf");
					
					//attach body parts
					content.addBodyPart(textBodyPart);
					content.addBodyPart(pdf);
					mimeMessage.setContent(content);
				}
			};
			sender.send(prep);
		} catch (HrException e) {
			e.printStackTrace();
		}
		
		
	}
}
