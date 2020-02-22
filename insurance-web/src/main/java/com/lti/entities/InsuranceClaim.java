package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSURANCE_CLAIM")
public class InsuranceClaim {

	@Id
	@Column(name = "CLAIMID")
	private int claimId;
	
	@Column(name = "REASONFORCLAIM")
	private String reasonForClaim;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "INSURANCEID")
	private int insuranceId;

	public InsuranceClaim() {
		super();
	}

	public InsuranceClaim(int claimId, String reasonForClaim, String status, double price, int insuranceId) {
		super();
		this.claimId = claimId;
		this.reasonForClaim = reasonForClaim;
		this.status = status;
		this.price = price;
		this.insuranceId = insuranceId;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getReasonForClaim() {
		return reasonForClaim;
	}

	public void setReasonForClaim(String reasonForClaim) {
		this.reasonForClaim = reasonForClaim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	
}
