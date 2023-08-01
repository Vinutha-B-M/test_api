package com.zunaco.api.request;

import java.io.Serializable;

public class ContactForm extends RequestBody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3632807390149680615L;

	@Override
	public String log() {
		// TODO Auto-generated method stub
		return null;
	}

	private String firstName;
	private String lastName;
	private String emailId;
	private String companyName;
	private String country;
	private String phoneNo;
	private String message;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactForm [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", companyName=" + companyName + ", country=" + country + ", phoneNo=" + phoneNo + ", message="
				+ message + "]";
	}

}
