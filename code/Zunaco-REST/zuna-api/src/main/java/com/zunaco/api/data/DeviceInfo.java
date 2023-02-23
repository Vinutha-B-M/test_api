package com.zunaco.api.data;

import java.io.Serializable;

public class DeviceInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String osName;
	private String osVer;
	private String deviceId;
	private String pnsToken;
	
	/**
	 * @return the osName
	 */
	public String getOsName() {
		return osName;
	}
	/**
	 * @param osName the osName to set
	 */
	public void setOsName(String osName) {
		this.osName = osName;
	}
	/**
	 * @return the osVer
	 */
	public String getOsVer() {
		return osVer;
	}
	/**
	 * @param osVer the osVer to set
	 */
	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the pnsToken
	 */
	public String getPnsToken() {
		return pnsToken;
	}
	/**
	 * @param pnsToken the pnsToken to set
	 */
	public void setPnsToken(String pnsToken) {
		this.pnsToken = pnsToken;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeviceInfo [osName=" + osName + ", osVer=" + osVer + ", deviceId=" + deviceId + ", pnsToken=" + pnsToken
				+ "]";
	}
	
	
	

}
