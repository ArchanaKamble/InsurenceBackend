package com.lti.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PLANS")
@SequenceGenerator(name="seq", sequenceName="PLANSEQ", initialValue= 104,allocationSize=1)
public class Plans {
	@Id
	@Column(name = "PLANID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int planId;
	
	@Column(name = "TYPEOFPLAN")
	private String typeOfPlan;
	
	@Column(name = "DURATION")
	private int duration;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "INSURANCEID")
	private int insuranceId;

	@Column(name = "PROVIDERNAME")
	private String providerName;
	@Column(name = "STATUS")
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "STARTDATE")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ENDDATE")
	private Date endDate;
	public Plans() {
	super();
	}


	public Plans(int planId, String typeOfPlan, int duration, double price, int insuranceId, String providerName,
			String status, Date startDate, Date endDate) {
		super();
		this.planId = planId;
		this.typeOfPlan = typeOfPlan;
		this.duration = duration;
		this.price = price;
		this.insuranceId = insuranceId;
		this.providerName = providerName;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public void setTypeOfPlan(String typeOfPlan) {
		this.typeOfPlan = typeOfPlan;
	}

	public int getPlanId() {
	return planId;
	}

	public void setPlanId(int planId) {
	this.planId = planId;
	}

	public String getTypeOfPlan() {
	return typeOfPlan;
	}


	public int getDuration() {
	return duration;
	}

	public void setDuration(int duration) {
	this.duration = duration;
	}

	public double getPrice() {
	return price;
	}

	public void setPrice(double price) {
	this.price = price;
	}

	public int getInsuranceId() {
	return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
	this.insuranceId = insuranceId;
	}

	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "Plans [planId=" + planId + ", typeOfPlan=" + typeOfPlan + ", duration=" + duration + ", price=" + price
				+ ", insuranceId=" + insuranceId + ", providerName=" + providerName + ", status=" + status
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}


	
}
