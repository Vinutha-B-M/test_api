package com.zunaco.api.request;

import java.io.Serializable;

public class SubscriptionRequest extends RequestBody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8031062091631279580L;

	@Override
	public String log() {
		// TODO Auto-generated method stub
		return null;
	}

	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "SubscriptionRequest [emailId=" + emailId + "]";
	}

}
