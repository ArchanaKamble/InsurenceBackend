package com.lti.entities;

public class PremiumShow {

	private String chosenPlan;
	private int premiumAmount;
	private int taxAppliedValue;
	private int insuranceId;
	public PremiumShow() {
		super();
	}
	
	public PremiumShow(String chosenPlan, int premiumAmount,int taxAppliedValue, int insuranceId) {
		super();
		this.chosenPlan = chosenPlan;
		this.premiumAmount = premiumAmount;
		this.taxAppliedValue = taxAppliedValue;
		this.insuranceId = insuranceId;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getChosenPlan() {
		return chosenPlan;
	}
	public void setChosenPlan(String chosenPlan) {
		this.chosenPlan = chosenPlan;
	}
	public int getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public int getTaxAppliedValue() {
		return taxAppliedValue;
	}
	public void setTaxAppliedValue(int taxAppliedValue) {
		this.taxAppliedValue = taxAppliedValue;
	}
	@Override
	public String toString() {
		return "PremiumShow [chosenPlan=" + chosenPlan + ", premiumAmount=" + premiumAmount + ", taxAppliedValue="
				+ taxAppliedValue + "]";
	}

}
