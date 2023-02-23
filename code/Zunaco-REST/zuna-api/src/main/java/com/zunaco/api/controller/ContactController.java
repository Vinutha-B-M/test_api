package com.zunaco.api.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.zunaco.api.request.ContactForm;
import com.zunaco.api.request.DemoRequest;
import com.zunaco.api.request.ServiceRequest;
import com.zunaco.api.request.SubscriptionRequest;
import com.zunaco.api.response.DemoResponse;
import com.zunaco.api.response.ServiceResponse;
import com.zunaco.api.service.ContactService;
import com.zunaco.api.util.AppConstants;

@Path("/contact")
public class ContactController {
	final static Logger logger = Logger.getLogger(ContactController.class);

	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getHome() {
		logger.debug("######## getHome() Starts");
		ServiceResponse<String> serviceResponse = new ServiceResponse<>();
		String message = "Success";
		serviceResponse.setData(message);
		logger.debug("######## getHome() Ends");
		return Response.status(200).entity(serviceResponse).build();
	}

	@POST
	@Path("/request/demo")
	@Produces("application/json")
	@Consumes("application/json")
	public Response contactUs(ServiceRequest<DemoRequest> serviceReq) {
		logger.debug("@@@@@@@@ contactUs() Starts" + serviceReq);
		DemoResponse resBody = new DemoResponse();
		ServiceResponse<DemoResponse> response = new ServiceResponse<DemoResponse>();

		DemoRequest contactUsReq = (DemoRequest) serviceReq.getBody();
		resBody = ContactService.processDemoRequest(contactUsReq);
		if (null != resBody) {
			response.setData(resBody);
			response.setStatus(AppConstants.APP_STATUS_SUCCESS);
			response.setMsg(AppConstants.REQUEST_PROCESSING_SUCCESS);
		} else {
			response.setData(resBody);
			response.setStatus(AppConstants.APP_STATUS_FAILURE);
			response.setMsg(AppConstants.REQUEST_PROCESSING_FAILED);
		}
		logger.debug("@@@@@@@@ contactUs() Ends....");
		return Response.status(200).entity(response).build();

	}

	@POST
	@Path("/form")
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveEnquiry(ServiceRequest<ContactForm> serviceReq) {
		logger.debug("@@@@@@@@ saveEnquiry() Starts" + serviceReq);
		DemoResponse resBody = new DemoResponse();
		ServiceResponse<DemoResponse> response = new ServiceResponse<DemoResponse>();

		ContactForm contactForm = serviceReq.getBody();
		resBody = ContactService.saveEnquiry(contactForm);
		if (null != resBody) {
			response.setData(resBody);
			response.setStatus(AppConstants.APP_STATUS_SUCCESS);
			response.setMsg(AppConstants.REQUEST_PROCESSING_SUCCESS);
		} else {
			response.setData(resBody);
			response.setStatus(AppConstants.APP_STATUS_FAILURE);
			response.setMsg(AppConstants.REQUEST_PROCESSING_FAILED);
		}
		logger.debug("@@@@@@@@ saveEnquiry() Ends....");
		return Response.status(200).entity(response).build();

	}
	
	@POST
	@Path("/subscribe")
	@Produces("application/json")
	@Consumes("application/json")
	public Response processSubscription(ServiceRequest<SubscriptionRequest> serviceReq) {
		logger.debug("@@@@@@@@ processSubscription() Starts" + serviceReq);
		DemoResponse resBody = new DemoResponse();
		ServiceResponse<DemoResponse> response = new ServiceResponse<DemoResponse>();

		SubscriptionRequest subscriptionRequest = serviceReq.getBody();
		resBody = ContactService.processSubscription(subscriptionRequest);
		if (null != resBody) {
			response.setData(resBody);
			response.setStatus(AppConstants.APP_STATUS_SUCCESS);
			response.setMsg(AppConstants.REQUEST_PROCESSING_SUCCESS);
		} else {
			response.setData(resBody);
			response.setStatus(AppConstants.APP_STATUS_FAILURE);
			response.setMsg(AppConstants.REQUEST_PROCESSING_FAILED);
		}
		logger.debug("@@@@@@@@ processSubscription() Ends....");
		return Response.status(200).entity(response).build();

	}
}
