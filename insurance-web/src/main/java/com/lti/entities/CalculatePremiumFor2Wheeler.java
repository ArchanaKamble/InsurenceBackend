package com.lti.entities;

public class CalculatePremiumFor2Wheeler {

	private int ageOfVehicle;
	private double vehiclePrice;
	private double finalPremium;
	
	public CalculatePremiumFor2Wheeler() {
		super();
	}
	public CalculatePremiumFor2Wheeler(int ageOfVehicle, double vehiclePrice, double finalPremium) {
		super();
		this.ageOfVehicle = ageOfVehicle;
		this.vehiclePrice = vehiclePrice;
		this.finalPremium = finalPremium;
	}
	public int getAgeOfVehicle() {
		return ageOfVehicle;
	}
	public void setAgeOfVehicle(int ageOfVehicle) {
		this.ageOfVehicle = ageOfVehicle;
	}
	public double getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	public double getFinalPremium() {
		return finalPremium;
	}
	public void setFinalPremium(double finalPremium) {
		this.finalPremium = finalPremium;
	}
	@Override
	public String toString() {
		return "CalculatePremiumFor2Wheeler [ageOfVehicle=" + ageOfVehicle + ", vehiclePrice=" + vehiclePrice
				+ ", finalPremium=" + finalPremium + "]";
	}
	
}
