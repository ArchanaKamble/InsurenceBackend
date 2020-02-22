package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSURANCE_TBL")
public class InsuranceDetails {

	@Id
	@Column(name = "INSURANCEID")
	private int insuranceId;
	
	@Column(name = "USERID")
	private int userId;
	
	@Column(name = "LICENSENO")
	private String licenseNo;
	
	@Column(name = "ENGINENO")
	private String engineNo;
	
	@Column(name = "CHASISNO")
	private String chasisNo;
	
	@Column(name = "TYPEOFVEHICLE")
	private String typeOfVehicle;
	
	@Column(name = "AGEOFCAR")
	private int ageOfCar;
	
	@Column(name = "CARID")
	private int carId;
	

	public InsuranceDetails() {
		super();
	}

	public InsuranceDetails(int insuranceId, int userId, String licenseNo, String engineNo, String chasisNo,
			String typeOfVehicle, int ageOfCar, int carId) {
		super();
		this.insuranceId = insuranceId;
		this.userId = userId;
		this.licenseNo = licenseNo;
		this.engineNo = engineNo;
		this.chasisNo = chasisNo;
		this.typeOfVehicle = typeOfVehicle;
		this.ageOfCar = ageOfCar;
		this.carId = carId;
		
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


	public int getAgeOfCar() {
		return ageOfCar;
	}

	public void setAgeOfCar(int ageOfCar) {
		this.ageOfCar = ageOfCar;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "InsuranceDetails [insuranceId=" + insuranceId + ", userId=" + userId + ", licenseNo=" + licenseNo
				+ ", engineNo=" + engineNo + ", chasisNo=" + chasisNo + ", typeOfVehicle=" + typeOfVehicle
				+  ", ageOfCar=" + ageOfCar + ", carId=" + carId + "]";
	}

	
	
	
}
