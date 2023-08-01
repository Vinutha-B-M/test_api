package com.zunaco.api.dao;

import java.util.Date;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.zunaco.api.request.ContactForm;
import com.zunaco.api.request.DemoRequest;
import com.zunaco.api.request.SubscriptionRequest;
import com.zunaco.api.util.DBConnector;
import com.zunaco.api.util.DBUtil;
import com.zunaco.api.util.DateUtil;

public class ContactDaoImpl {
	final static Logger logger = Logger.getLogger(ContactDaoImpl.class);
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String saveDemoRequest(DemoRequest demoRequest) {
		logger.info("@@@@@@@@@@@@ saveDemoRequest() Starts");
		String requestId = null;
		MongoCollection<Document> collection = null;
		try {
			collection = DBConnector.getDBConnectionByCollection(DBUtil.collection.CONTACT_DEMO);
			Document requestData = objectMapper.convertValue(demoRequest, Document.class);
			requestData.put("latestupdate", new Date());
			requestData.put("createdDatetime", DateUtil.getJulianDateTimeNow());
			collection.insertOne(requestData);
			logger.debug("requestData:" + requestData);
			requestId = requestData.getObjectId("_id").toString();
			logger.debug("added requestId::" + requestId);
		} catch (Exception e) {
			logger.error("Error due to  - " + e, e);
			e.printStackTrace();
		}
		logger.info("@@@@@@@@@@@@ saveDemoRequest() Ends");
		return requestId;
	}

	public static String saveEnquiry(ContactForm contactForm) {
		logger.info("@@@@@@@@@@@@ saveEnquiry() Starts");
		String requestId = null;
		MongoCollection<Document> collection = null;
		try {
			collection = DBConnector.getDBConnectionByCollection(DBUtil.collection.CONTACT_FORM);
			Document requestData = objectMapper.convertValue(contactForm, Document.class);
			requestData.put("createdDatetime", DateUtil.getJulianDateTimeNow());
			collection.insertOne(requestData);
			logger.debug("requestData:" + requestData);
			requestId = requestData.getObjectId("_id").toString();
			logger.debug("added requestId::" + requestId);
		} catch (Exception e) {
			logger.error("Error due to  - " + e, e);
			e.printStackTrace();
		}
		logger.info("@@@@@@@@@@@@ saveEnquiry() Ends");
		return requestId;
	}

	public static String processSubscription(SubscriptionRequest subscriptionRequest) {
		logger.info("@@@@@@@@@@@@ processSubscription() Starts");
		String requestId = null;
		MongoCollection<Document> collection = null;
		try {
			collection = DBConnector.getDBConnectionByCollection(DBUtil.collection.SUBSCRIPTION_REQUEST);
			Document requestData = objectMapper.convertValue(subscriptionRequest, Document.class);
			requestData.put("createdDatetime", DateUtil.getJulianDateTimeNow());
			collection.insertOne(requestData);
			logger.debug("requestData:" + requestData);
			requestId = requestData.getObjectId("_id").toString();
			logger.debug("added requestId::" + requestId);
		} catch (Exception e) {
			logger.error("Error due to  - " + e, e);
			e.printStackTrace();
		}
		logger.info("@@@@@@@@@@@@ processSubscription() Ends");
		return requestId;
	}
	
}
