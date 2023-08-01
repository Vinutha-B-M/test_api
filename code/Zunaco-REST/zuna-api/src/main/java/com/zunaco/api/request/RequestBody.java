package com.zunaco.api.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class RequestBody {

	public abstract String log();
	
	public String asString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
