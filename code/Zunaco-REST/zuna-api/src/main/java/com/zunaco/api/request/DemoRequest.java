package com.zunaco.api.request;

import java.io.Serializable;

public class DemoRequest extends RequestBody implements Serializable {

	private static final long serialVersionUID = -5067638990921307066L;

	private String name;
	private String organization;
	private String state;
	private String website;
	private String email;
	private String phone;
	private String solutionInterest;
	private String businessChallenge;
	private String growLocation;
	private String source;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSolutionInterest() {
		return solutionInterest;
	}

	public void setSolutionInterest(String solutionInterest) {
		this.solutionInterest = solutionInterest;
	}

	/**
	 * @return the businessChallenge
	 */
	public String getBusinessChallenge() {
		return businessChallenge;
	}

	/**
	 * @param businessChallenge the businessChallenge to set
	 */
	public void setBusinessChallenge(String businessChallenge) {
		this.businessChallenge = businessChallenge;
	}

	/**
	 * @return the growLocation
	 */
	public String getGrowLocation() {
		return growLocation;
	}

	/**
	 * @param growLocation the growLocation to set
	 */
	public void setGrowLocation(String growLocation) {
		this.growLocation = growLocation;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String log() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "DemoRequest [name=" + name + ", organization=" + organization + ", state=" + state + ", website="
				+ website + ", email=" + email + ", phone=" + phone + ", solutionInterest=" + solutionInterest
				+ ", businessChallenge=" + businessChallenge + ", growLocation=" + growLocation + ", source=" + source
				+ "]";
	}

}
