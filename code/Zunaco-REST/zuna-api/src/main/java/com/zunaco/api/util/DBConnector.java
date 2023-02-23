package com.zunaco.api.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBConnector {
	final static Logger logger = Logger.getLogger(DBConnector.class);
	private static MongoClient mongoClient = null;
	private static MongoDatabase database = null;
	
	
	public Connection conn = null;
	
	static {
		mongoClient = new MongoClient(new MongoClientURI(AppConstants.MONGO_CLIENT_URI));
		database = mongoClient.getDatabase(AppConstants.DB_NAME);
		//db = mongoClient.getDB(AppConstants.DB_NAME);

	}

	public static MongoCollection<Document> getDBConnectionByCollection(String collectionName) {
		MongoCollection<Document> con = null;
		try {
			con = database.getCollection(collectionName);
		} catch (Exception e) {
			logger.error("Error::" + e, e);
		}
		return con;
	}

	/*public static DBCollection getDBConnectionByCollection(String collectionName) {
		DBCollection con = null;
		try {
			con = db.getCollection(collectionName);
		} catch (Exception e) {
			logger.error("Error::" + e, e);		
		}		
		return con;
	}*/
	
	protected void finalizer() {
		mongoClient.close();

	}
	
//	public static Connection getDbConn() {
//		Connection conn = null;
//		String myUrl = "jdbc:mysql://" + AppConstants.DB_HOST + "/" + AppConstants.DB_NAME
//				+ "?allowPublicKeyRetrieval=true" + "&useSSL=false";
//		try {
//			Class.forName(AppConstants.JDBC_DRIVER_MYSQL);
//			conn = DriverManager.getConnection(myUrl, AppConstants.DB_SERVER_USER, AppConstants.DB_SERVER_PASSWORD);
//		} catch (Exception e) {
//			logger.error("Error due to - " + e, e);
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	public static void closeConnection(Connection con, PreparedStatement pst) {
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				logger.error("Error due to - " + e, e);
			} finally {

			}
		}
		if (null != pst) {
			try {
				pst.close();
			} catch (SQLException e) {
				logger.error("Error due to - " + e, e);
			} finally {

			}
		}
	}
}
