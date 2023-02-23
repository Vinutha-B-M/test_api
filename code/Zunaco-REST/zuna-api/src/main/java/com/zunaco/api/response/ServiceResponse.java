package com.zunaco.api.response;
import java.io.Serializable;
public class ServiceResponse<T> implements Serializable {

	private static final long serialVersionUID = 6924343557823742844L;
	private String status;
	private String msg;
	private T data;

	

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String appStatusSuccess) {
		this.status = appStatusSuccess;
	}

	@Override
	public String toString() {
		return "ServiceResponse [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
