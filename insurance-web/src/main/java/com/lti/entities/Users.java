package com.lti.entities;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Users")
@SequenceGenerator(name="seq", sequenceName="USERSEQ", initialValue= 104,allocationSize=1)
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int userId;
	private String name;
	private String email;
	private String password;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	private long contact;
	private  String address;
	private int policyNo;
	
	public Users() {
		super();
	}

	public Users(int userId, String name, String email, String password, Date dob, long contact, String address,
			int policyNo) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.contact = contact;
		this.address = address;
		this.policyNo = policyNo;
	}


	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", dob="
				+ dob + ", contact=" + contact + ", address=" + address + "]";
	}
	
	
}
