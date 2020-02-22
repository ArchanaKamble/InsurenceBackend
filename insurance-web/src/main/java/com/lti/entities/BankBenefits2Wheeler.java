package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANKBENEFITS2WHEELER")
public class BankBenefits2Wheeler {

	@Id
	@Column(name  = "BANK")
	private String bank;
	
	@Column(name  = "LOANINTEREST")
	private int loanInterest;
	
	@Column(name  = "LOWESTEMI")
	private int lowestEMI;
	
	@Column(name  = "TENURE")
	private int tenure;
	
	@Column(name  = "EXTRABENEFITS")
	private String extraBenefits;
	
	public BankBenefits2Wheeler() {
		super();
	}


	public BankBenefits2Wheeler(String bank, int loanInterest, int lowestEMI, int tenure, String extraBenefits) {
		super();
		this.bank = bank;
		this.loanInterest = loanInterest;
		this.lowestEMI = lowestEMI;
		this.tenure = tenure;
		this.extraBenefits = extraBenefits;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public int getLoanInterest() {
		return loanInterest;
	}


	public void setLoanInterest(int loanInterest) {
		this.loanInterest = loanInterest;
	}


	public int getLowestEMI() {
		return lowestEMI;
	}


	public void setLowestEMI(int lowestEMI) {
		this.lowestEMI = lowestEMI;
	}


	public int getTenure() {
		return tenure;
	}


	public void setTenure(int tenure) {
		this.tenure = tenure;
	}


	public String getExtraBenefits() {
		return extraBenefits;
	}


	public void setExtraBenefits(String extraBenefits) {
		this.extraBenefits = extraBenefits;
	}


	@Override
	public String toString() {
		return "BankBenefits2Wheeler [bank=" + bank + ", loanInterest=" + loanInterest + ", lowestEMI=" + lowestEMI
				+ ", tenure=" + tenure + ", extraBenefits=" + extraBenefits  + "]";
	}
}
