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
@Table(name="INSURANCECLAIM")
@SequenceGenerator(name="seq", sequenceName="CLAIMSEQ", initialValue= 104,allocationSize=1)
public class Claim {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="CLAIMID")
	private int claimId;
	@Column(name="INSURANCEID")
	private int insuranceId;
	@Column(name="MOBILENO")
	private long mobileNo;
	@Column(name="REASON")
	private String reason;
	@Column(name="PROOF")
	private String Proof;
	@Column(name="POLICYNO")
	private int policyNo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="CLAIMDATE")
	private Date claimDate;
	@Column(name="STATUS")
	private String status;
	@Column(name="PRICE")
	private int price;
	
	public Claim() {
		super();
	}

	
	public Claim(int claimId, int insuranceId, long mobileNo, String reason, String Proof, int policyNo,
			Date claimDate, String status, int price) {
		super();
		this.claimId = claimId;
		this.insuranceId = insuranceId;
		this.mobileNo = mobileNo;
		this.reason = reason;
		this.Proof = Proof;
		this.policyNo = policyNo;
		this.claimDate = claimDate;
		this.status = status;
		this.price = price;
	}


	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getProof() {
		return Proof;
	}

	public void setProof(String Proof) {
		this.Proof = Proof;
	}

	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public Date getStartDate() {
		return claimDate;
	}

	public void setStartDate(Date claimDate) {
		this.claimDate = claimDate;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", insuranceId=" + insuranceId + ", mobileNo=" + mobileNo + ", reason="
				+ reason + ", Proof=" + Proof + ", policyNo=" + policyNo + ", claimDate=" + claimDate
				+ ", status=" + status + ", price=" + price + "]";
	}

	
	
}

