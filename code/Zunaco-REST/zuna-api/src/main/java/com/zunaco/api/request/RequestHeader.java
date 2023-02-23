package com.zunaco.api.request;

import java.io.Serializable;


public class RequestHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6866297201934754724L;
	private String appId;
	private String clientId;
	private String apiId;
	private String requestDateTime;
	private String appVer;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAppVer() {
		return appVer;
	}

	public void setAppVer(String appVer) {
		this.appVer = appVer;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getRequestDateTime() {
		return requestDateTime;
	}

	public void setRequestDateTime(String requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	@Override
	public String toString() {
		return "RequestHeader [appId=" + appId + ", clientId=" + clientId + ", apiId=" + apiId + ", requestDateTime="
				+ requestDateTime + ", appVer=" + appVer + ", userId=" + userId + "]";
	}
	
	
}
