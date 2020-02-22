package com.lti.entities;

public class ResultOfPremium {

	private String providerName;
	private double IDV;
	private double finalNetPremium;
	public ResultOfPremium() {
		super();
	}
	public ResultOfPremium(String providerName, double iDV, double finalNetPremium) {
		super();
		this.providerName = providerName;
		IDV = iDV;
		this.finalNetPremium = finalNetPremium;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public double getIDV() {
		return IDV;
	}
	public void setIDV(double iDV) {
		IDV = iDV;
	}
	public double getFinalNetPremium() {
		return finalNetPremium;
	}
	public void setFinalNetPremium(double finalNetPremium) {
		this.finalNetPremium = finalNetPremium;
	}
	@Override
	public String toString() {
		return "ResultOfPremium [providerName=" + providerName + ", IDV=" + IDV + ", finalNetPremium=" + finalNetPremium
				+ "]";
	}
	
}
