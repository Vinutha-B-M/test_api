package com.zunaco.api.util;

public class AppConstants {

	//public static final String CLIENT = "localhost";

	//public static final String MONGO_URL = "mongodb://";
	//public static final String DB_SERVER_USER = "zunaUser";
	//public static final String DB_SERVER_PASSWORD = "qwerty";
	//public static final String DB_SERVER_ADDRESS = "localhost:27019";
	//public static final String AUTH_SOURCE_DB = "admin";

	 public static final String DB_NAME = "zuna";

	// Connect with authentication
	//public static final String MONGO_CLIENT_URI = AppConstants.MONGO_URL + AppConstants.DB_SERVER_USER + ":"
	//		+ AppConstants.DB_SERVER_PASSWORD + "@" + AppConstants.DB_SERVER_ADDRESS + "/"
	//		+ AppConstants.AUTH_SOURCE_DB;

 	//Connect with authentication
        public static final String MONGO_CLIENT_URI = mongodb://zunaSuperAdmin:zuna123987@mongo-db:27017/admin;

	// Uncomment this line for mysql server version 8+
	public static final String JDBC_DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";

	public static final String DB_HOST = "localhost";

	// production
//	public static final String CONTACT_EMAIL = "sales@zunaco.com";

	// development
	public static final String CONTACT_EMAIL = "vedashri.jundre@goalsr.com";

	/*
	 * SES Email Config
	 */

	// This address must be verified.
	// public static final String FROM = "notifications@goalsr.com";
	public static final String FROM = "no-reply@zunaco.com";
	public static final String FROMNAME = "no-reply@zunaco.com";

	// Replace smtp_username with your Amazon SES SMTP user name.
	// public static final String SMTP_USERNAME = "AKIAVCRTAQOFHLH765UE";
	public static final String SMTP_USERNAME = "no-reply@zunaco.com";

	// Replace smtp_password with your Amazon SES SMTP password.
	// public static final String SMTP_PASSWORD =
	// "BO3HLeHGxkozCgyEmRyjnBfRQFugNrXxUVnbpTInGfuX";
	public static final String SMTP_PASSWORD = "goalsr@123";

	// public static final String SMTP_HOST = "email-smtp.us-west-2.amazonaws.com";
	public static final String SMTP_HOST = "smtp.gmail.com";

	// The port you will connect to on the Amazon SES SMTP endpoint.
	public static final int SMTP_PORT = 587;

	/*
	 * App parameter contants
	 *
	 */
	public static final String HTTP_POST = "POST";
	public static final String HTTP_GET = "GET";
	public static final String HTTP_PUT = "PUT";

	public static final String STATUS_SUCCESS = "0";
	public static final String STATUS_FAILURE = "1";

	public static final String APP_STATUS_SUCCESS = "0";
	public static final String APP_STATUS_FAILURE = "1";

	public static final String INVALID_REQUEST_MESSAGE = "Invalid request";

	public static final String REQUEST_PROCESSING_SUCCESS = "Request processed successfully";
	public static final String REQUEST_PROCESSING_FAILED = "Request processing failed";

}
