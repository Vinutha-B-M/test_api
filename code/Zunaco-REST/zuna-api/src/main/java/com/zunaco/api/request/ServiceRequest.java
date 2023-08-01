package com.zunaco.api.request;

public class ServiceRequest<T extends RequestBody> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8869173402076958693L;

	private RequestHeader header;
	private T body;
	private RequestTrailer trailer;

	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public RequestTrailer getTrailer() {
		return trailer;
	}

	public void setTrailer(RequestTrailer trailer) {
		this.trailer = trailer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ServiceRequest [header=" + header + ", body=" + body + ", trailer=" + trailer + "]";
	}

}
