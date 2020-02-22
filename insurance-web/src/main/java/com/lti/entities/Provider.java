package com.lti.entities;

public class Provider {

	private String name;
	private double idv;
	private double finalPremium;
	private int insuranceid;
	private int planId;
	public Provider() {
		super();
	}
	
	public Provider(String name, double idv, double finalPremium, int insuranceid, int planId) {
		super();
		this.name = name;
		this.idv = idv;
		this.finalPremium = finalPremium;
		this.insuranceid = insuranceid;
		this.planId = planId;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getIdv() {
		return idv;
	}
	public void setIdv(double idv) {
		this.idv = idv;
	}
	public double getFinalPremium() {
		return finalPremium;
	}
	public void setFinalPremium(double finalPremium) {
		this.finalPremium = finalPremium;
	}
	public int getInsuranceid() {
		return insuranceid;
	}
	public void setInsuranceid(int insuranceid) {
		this.insuranceid = insuranceid;
	}

	@Override
	public String toString() {
		return "Provider [name=" + name + ", idv=" + idv + ", finalPremium=" + finalPremium + ", insuranceid="
				+ insuranceid + ", planId=" + planId + "]";
	}
	
}
