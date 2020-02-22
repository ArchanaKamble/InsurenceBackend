package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INSURERS")
public class Insurers {

	@Id
	@Column(name="INSURERSID")
	private int insurersId;
	
	@Column(name="PROVIDERNAME")
	private String providerName;
	
	@Column(name="NCB")
	private int ncb;
	
	@Column(name="THIRDPARTYLIABILITY")
	private int thirdPartyLiability;
	
	@Column(name="COMPREHENSIVE")
	private int comprehensive;

	public Insurers() {
		super();
	}

	public Insurers(int insurersId, String providerName, int ncb, int thirdPartyLiability, int comprehensive) {
		super();
		this.insurersId = insurersId;
		this.providerName = providerName;
		this.ncb = ncb;
		this.thirdPartyLiability = thirdPartyLiability;
		this.comprehensive = comprehensive;
	}

	public int getInsurersId() {
		return insurersId;
	}

	public void setInsurersId(int insurersId) {
		this.insurersId = insurersId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public int getNcb() {
		return ncb;
	}

	public void setNcb(int ncb) {
		this.ncb = ncb;
	}

	public int getThirdPartyLiability() {
		return thirdPartyLiability;
	}

	public void setThirdPartyLiability(int thirdPartyLiability) {
		this.thirdPartyLiability = thirdPartyLiability;
	}

	public int getComprehensive() {
		return comprehensive;
	}

	public void setComprehensive(int comprehensive) {
		this.comprehensive = comprehensive;
	}

	@Override
	public String toString() {
		return "Insurers [insurersId=" + insurersId + ", providerName=" + providerName + ", ncb=" + ncb
				+ ", thirdPartyLiability=" + thirdPartyLiability + ", comprehensive=" + comprehensive + "]";
	}
	
	
	
}
