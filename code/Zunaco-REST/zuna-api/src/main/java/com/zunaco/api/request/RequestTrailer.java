package com.zunaco.api.request;

import java.io.Serializable;

import com.zunaco.api.data.DeviceInfo;


public class RequestTrailer implements Serializable {

	private static final long serialVersionUID = 6138677423399804906L;

	private String nsToken;
	private String msgHash;
	private DeviceInfo deviceInfo;

	public String getNsToken() {
		return nsToken;
	}

	public void setNsToken(String nsToken) {
		this.nsToken = nsToken;
	}

	public String getMsgHash() {
		return msgHash;
	}

	public void setMsgHash(String msgHash) {
		this.msgHash = msgHash;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestTrailer [nsToken=" + nsToken + ", msgHash=" + msgHash + ", deviceInfo=" + deviceInfo + "]";
	}
	
	
}
