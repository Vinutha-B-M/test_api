package com.zunaco.api.response;

import java.io.Serializable;

public class DemoResponse extends ResponseBody implements Serializable {

	private static final long serialVersionUID = -3553823725782430754L;

	private String id;
	private String message;
	
	@Override
	public String log() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}





	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}





	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}



	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "DemoResponse [id=" + id + ", message=" + message + "]";
	}

	

}
