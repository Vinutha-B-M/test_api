package com.zunaco.api.service;

import org.apache.log4j.Logger;

import com.zunaco.api.dao.ContactDaoImpl;
import com.zunaco.api.request.ContactForm;
import com.zunaco.api.request.DemoRequest;
import com.zunaco.api.request.SubscriptionRequest;
import com.zunaco.api.response.DemoResponse;
import com.zunaco.api.util.AppConstants;
import com.zunaco.api.util.MailServiceImpl;

public class ContactService {
	final static Logger logger = Logger.getLogger(ContactService.class);

	public static DemoResponse processDemoRequest(DemoRequest demoRequest) {
		logger.info("@@@@@@@@@@@@ processDemoRequest() Starts");
		DemoResponse response = new DemoResponse();
		try {

			String id = ContactDaoImpl.saveDemoRequest(demoRequest);
			if (id != null) {
				response.setId(id);
				response.setMessage("Hi, Thanks for contacting us, Our Sales team will revert to you shortly !!");
				new Thread(() -> {
					String msgBody = MailServiceImpl.CLIENT_DEMO_EMAIL_BODY;
					msgBody = msgBody.replace("{NAME}", demoRequest.getName());
					msgBody = msgBody.replace("{COMPANY}", demoRequest.getOrganization());
					msgBody = msgBody.replace("{STATE}", demoRequest.getState());
					msgBody = msgBody.replace("{WEBSITE}", demoRequest.getWebsite());
					msgBody = msgBody.replace("{EMAIL}", demoRequest.getEmail());
					msgBody = msgBody.replace("{PHONE}", demoRequest.getPhone());
					msgBody = msgBody.replace("{INTREST}", demoRequest.getSolutionInterest());
					msgBody = msgBody.replace("{CHALLENGES}",
							(demoRequest.getBusinessChallenge() != null
									&& demoRequest.getBusinessChallenge().trim().length() != 0)
											? demoRequest.getBusinessChallenge()
											: "--");
					msgBody = msgBody.replace("{LOCATIONS}",
							(demoRequest.getGrowLocation() != null
									&& demoRequest.getGrowLocation().trim().length() != 0)
											? demoRequest.getGrowLocation()
											: "--");
					msgBody = msgBody.replace("{HEAR}", demoRequest.getSource());
					MailServiceImpl.sendMail(msgBody, AppConstants.CONTACT_EMAIL,
							"Request for demo via website");
				}).start();
			}

		} catch (Exception e) {
			logger.error("Error due to  - " + e, e);
			e.printStackTrace();
		}
		logger.info("@@@@@@@@@@@@ processDemoRequest() Ends");
		return response;
	}

	public static DemoResponse saveEnquiry(ContactForm contactForm) {
		logger.info("@@@@@@@@@@@@ saveEnquiry() Starts");
		DemoResponse response = new DemoResponse();
		try {

			String id = ContactDaoImpl.saveEnquiry(contactForm);
			if (id != null) {
				response.setId(id);
				response.setMessage("Hi, Thanks for contacting us, Our sales team will revert to you shortly !!");
				new Thread(() -> {
					String msgBody = MailServiceImpl.CLIENT_CONTACT_EMAIL_BODY;
					msgBody = msgBody.replace("{NAME}", contactForm.getFirstName() + " " + contactForm.getLastName());
					msgBody = msgBody.replace("{COMPANY}", contactForm.getCompanyName());
					msgBody = msgBody.replace("{COUNTRY}", contactForm.getCountry());
					msgBody = msgBody.replace("{EMAIL}", contactForm.getEmailId());
					msgBody = msgBody.replace("{PHONE}", contactForm.getPhoneNo());
					msgBody = msgBody.replace("{MESSAGE}", contactForm.getMessage());

					MailServiceImpl.sendMail(msgBody, AppConstants.CONTACT_EMAIL, "Enquiry via website");
				}).start();
			}

		} catch (Exception e) {
			logger.error("Error due to  - " + e, e);
			e.printStackTrace();
		}
		logger.info("@@@@@@@@@@@@ saveEnquiry() Ends");
		return response;
	}

	public static DemoResponse processSubscription(SubscriptionRequest subscriptionRequest) {
		logger.info("@@@@@@@@@@@@ processSubscription() Starts");
		DemoResponse response = new DemoResponse();
		try {

			String id = ContactDaoImpl.processSubscription(subscriptionRequest);
			if (id != null) {
				response.setId(id);
			}

		} catch (Exception e) {
			logger.error("Error due to  - " + e, e);
			e.printStackTrace();
		}
		logger.info("@@@@@@@@@@@@ processSubscription() Ends");
		return response;
	}
}
