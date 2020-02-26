package com.lti.entities;

public class BuyInsurance {

	private int insuranceId;
	private int userId;
	private String licenseNo;
	private String engineNo;
	private String chasisNo;
	private String typeOfVehicle;
	private int vehiclePrice;
	private int ageOfCar;
	private String brand;
	private String model;
	private String variant;
	public BuyInsurance() {
		super();
	}
	
	public BuyInsurance(int insuranceId, int userId, String licenseNo, String engineNo, String chasisNo,
			String typeOfVehicle, int vehiclePrice, int ageOfCar, String brand, String model, String variant) {
		super();
		this.insuranceId = insuranceId;
		this.userId = userId;
		this.licenseNo = licenseNo;
		this.engineNo = engineNo;
		this.chasisNo = chasisNo;
		this.typeOfVehicle = typeOfVehicle;
		this.vehiclePrice = vehiclePrice;
		this.ageOfCar = ageOfCar;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	public String getTypeOfVehicle() {
		return typeOfVehicle;
	}
	public void setTypeOfVehicle(String typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}
	public int getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(int vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	public int getAgeOfCar() {
		return ageOfCar;
	}
	public void setAgeOfCar(int ageOfCar) {
		this.ageOfCar = ageOfCar;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}

	@Override
	public String toString() {
		return "BuyInsurance [insuranceId=" + insuranceId + ", userId=" + userId + ", licenseNo=" + licenseNo
				+ ", engineNo=" + engineNo + ", chasisNo=" + chasisNo + ", typeOfVehicle=" + typeOfVehicle
				+ ", vehiclePrice=" + vehiclePrice + ", ageOfCar=" + ageOfCar + ", brand=" + brand + ", model=" + model
				+ ", variant=" + variant + "]";
	}
	
}
