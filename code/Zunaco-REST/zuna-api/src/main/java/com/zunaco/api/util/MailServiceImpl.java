package com.zunaco.api.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailServiceImpl {

	final static Logger logger = Logger.getLogger(MailServiceImpl.class);
	public static final String CLIENT_DEMO_EMAIL_BODY = String.join(System.getProperty("line.separator"),
			"<p>Dear Sales Team,</p>",
			"<p>One of the customer has requested for demo.</p>",
			"<p><br/></p>",
			"<p>Customer details are as below:</p>",
			"<p>Name: {NAME}</p>",
			"<p>Company: {COMPANY}</p>",
			"<p>State: {STATE}</p>",
			"<p>Company Website: {WEBSITE}</p>",
			"<p>Email: {EMAIL}</p>",
			"<p>Phone Number: {PHONE}</p>",
			"<p>Solution Interest: {INTREST}</p>",
			"<p>Business Challenges: {CHALLENGES}</p>",
			"<p>Grow Locations: {LOCATIONS}</p>",
			"<p>How did they hear about us?: {HEAR}</p>",
			"<br/><br/>Best Regards,<br/> Zunaco Team</b></p>");
	
	public static final String CLIENT_CONTACT_EMAIL_BODY = String.join(System.getProperty("line.separator"),
			"<p>Dear Sales Team,</p>",
			"<p>We have received one enquiry.</p>",
			"<p><br/></p>",
			"<p>Contact details are as below:</p>",
			"<p>Name: {NAME}</p>",
			"<p>Company: {COMPANY}</p>",
			"<p>Country: {COUNTRY}</p>",
			"<p>Email Id: {EMAIL}</p>",
			"<p>Phone Number: {PHONE}</p>",
			"<p>Message: {MESSAGE}</p>",
			"<br/><br/>Best Regards,<br/> Zunaco Team</b></p>");
	
	
	public static void sendMail(String body, String recipients, String subject) {
		logger.debug("sendMail starts...");
		try {
			Properties props = System.getProperties();
			Transport transport = null;
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.port", ""+AppConstants.SMTP_PORT);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(props);
			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(AppConstants.FROM, AppConstants.FROMNAME));

			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));

			msg.setSubject(subject);

			msg.setContent(body, "text/html");

			transport = session.getTransport();

			// Send the message.

			transport.connect(AppConstants.SMTP_HOST, AppConstants.SMTP_USERNAME, AppConstants.SMTP_PASSWORD);
			transport.sendMessage(msg, msg.getAllRecipients());
		}

		catch (Exception e) {
			logger.error("Error::" + e, e);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String mailBody = CLIENT_DEMO_EMAIL_BODY;
		mailBody = mailBody.replace("##COMPANY_NAME##", "New Company");
		mailBody = mailBody.replace("##OFFICE_NUMBER##", "08087665675");
		mailBody = mailBody.replace("##ADDRESS##", "Bangalore");
		mailBody = mailBody.replace("##LICENSE_TYPE##", "Trial");
		mailBody = mailBody.replace("##LICENSES##", "15");
		mailBody = mailBody.replace("##NAME##", "Vishal Vyas");
		mailBody = mailBody.replace("##EMAIL_ID##", "vishal.vyas@gmail.com");
		mailBody = mailBody.replace("##PHONE_NO##", "8977689790");
		sendMail(mailBody, "vijay71189@gmail.com","Request for demo(inquiry) via Website");
	}
}
