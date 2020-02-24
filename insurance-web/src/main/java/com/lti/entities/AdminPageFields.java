package com.lti.entities;

public class AdminPageFields {

	private int planId;
	private String name;
	private double price;
	private String providerName;
	private String typeOfPlan;
	private String status;
	private int userId;
	public AdminPageFields() {
		super();
	}

	public AdminPageFields(int planId, String name, double price, String providerName, String typeOfPlan, String status,
			int userId) {
		super();
		this.planId = planId;
		this.name = name;
		this.price = price;
		this.providerName = providerName;
		this.typeOfPlan = typeOfPlan;
		this.status = status;
		this.userId = userId;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getTypeOfPlan() {
		return typeOfPlan;
	}
	public void setTypeOfPlan(String typeOfPlan) {
		this.typeOfPlan = typeOfPlan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdminPageFields [planId=" + planId + ", name=" + name + ", price=" + price + ", providerName="
				+ providerName + ", typeOfPlan=" + typeOfPlan + ", status=" + status + "]";
	}
	
}
