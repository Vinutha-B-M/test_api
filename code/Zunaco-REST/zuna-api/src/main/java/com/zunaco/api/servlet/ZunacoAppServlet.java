package com.zunaco.api.servlet;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.zunaco.api.controller.ContactController;

public class ZunacoAppServlet extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	
	public ZunacoAppServlet() {
		singletons.add(new ContactController());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
