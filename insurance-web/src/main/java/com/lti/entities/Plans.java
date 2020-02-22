package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANS")
public class Plans {
	@Id
	@Column(name = "PLANID")
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
	public Plans() {
	super();
	}

	public Plans(int planId, String typeOfPlan, int duration, double price, int insuranceId, String providerName) {
		super();
		this.planId = planId;
		this.typeOfPlan = typeOfPlan;
		this.duration = duration;
		this.price = price;
		this.insuranceId = insuranceId;
		this.providerName = providerName;
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

	@Override
	public String toString() {
	return "Plan [planId=" + planId + ", typeOfPlan=" + typeOfPlan + ", duration=" + duration + ", price=" + price
	+ ", insuranceId=" + insuranceId + "]";
	}

}
