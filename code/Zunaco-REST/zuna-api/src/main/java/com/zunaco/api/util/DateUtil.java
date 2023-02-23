package com.zunaco.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.log4j.Logger;

public class DateUtil {

	final static Logger logger = Logger.getLogger(DateUtil.class);
	public static final String DATE_MM_DD_YYYY_FRONT_SLASH = "MM/dd/yyyy";
	public static final String DATE_DD_MM_YYYY_FRONT_SLASH = "dd/MM/yyyy";
	public static final String DATE_YYYY_MM_DD_DASH = "yyyy/MM/dd";
	public static final String JULIAN_DATE_FORMAT = "yyyyDDDHHmmssSSS";
	public static final String DATE_DD_MMM_YYYY_FORMAT = "dd/mm/yyyy hh:mm:ss a";
	public static final String TIME_ZONE = "IST";

	public static long getJulianDateTimeNow() {
		long time = 0L;
		try {
			// logger.debug("getJulianDateTimeNow starts...");
			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
			cal.setTime(new Date());
			String now = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR))
					+ String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))
					+ String.format("%02d", cal.get(Calendar.MINUTE)) + ""
					+ String.format("%02d", cal.get(Calendar.SECOND)) + ""
					+ String.format("%03d", cal.get(Calendar.MILLISECOND));
			time = Long.parseLong(now);
		} catch (Exception e) {
			logger.error("Error due to - " + e, e);
		}
		// logger.debug("getJulianDateTimeNow ends...");
		return time;
	}

	public static long getJulianDateTimeUTC() {
		long time = 0L;
		try {
			// logger.debug("getJulianDateTimeNow starts...");
			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone("UTC"));
			cal.setTime(new Date());
			String now = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR))
					+ String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))
					+ String.format("%02d", cal.get(Calendar.MINUTE)) + ""
					+ String.format("%02d", cal.get(Calendar.SECOND)) + ""
					+ String.format("%03d", cal.get(Calendar.MILLISECOND));
			time = Long.parseLong(now);
		} catch (Exception e) {
			logger.error("Error due to - " + e, e);
		}
		// logger.debug("getJulianDateTimeNow ends...");
		return time;
	}

	public static long getCurrentJulianDate() {
		long time = 0L;
		try {
			logger.debug("getJulianDateNow starts...");
			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
			cal.setTime(new Date());
			String now = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR)) + "000000000";
			time = Long.parseLong(now);
		} catch (Exception e) {
			logger.error("Error due to - " + e, e);
		}
		logger.debug("getJulianDateNow ends...");
		return time;
	}

	public static long getCurrentJulianDateIST() {
		long time = 0L;
		try {
			logger.debug("getJulianDateNow starts...");
			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
			cal.setTime(new Date());
			String now = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR)) + "053000000";
			time = Long.parseLong(now);
		} catch (Exception e) {
			logger.error("Error due to - " + e, e);
		}
		logger.debug("getJulianDateNow ends...");
		return time;
	}

	public static String getJulianDayOfMonth() {
		String day = "0";
		try {
			Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
			Calendar cal = Calendar.getInstance();
			cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014

			int dayOfMonth = (cal.get(Calendar.DAY_OF_MONTH)) - 1; // 17
			day = Integer.toString(dayOfMonth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}

	public static String convertDateFormatToJulianDateFormat(String inputDate, String inputFormat) {
		String formattedDate = null;

		if (inputDate != null && inputFormat != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(inputFormat);
				Date inputData = sdf.parse(inputDate);
				System.out.println("inputData:" + inputData);
				Calendar cal = Calendar.getInstance();
				cal.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
				cal.setTime(inputData);
				formattedDate = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR))
						+ String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))
						+ String.format("%02d", cal.get(Calendar.MINUTE)) + ""
						+ String.format("%02d", cal.get(Calendar.SECOND)) + ""
						+ String.format("%03d", cal.get(Calendar.MILLISECOND));
				System.out.println("formattedDate:" + formattedDate);
			} catch (Exception e) {
				logger.error("Error due to - " + e, e);
			}
			return formattedDate;
		}
		return null;
	}

	public static Date convertStringToDate(String inputStringDate, String inputFormat) {
		Date outputDate = null;
		try {
			DateFormat sourceFormat = new SimpleDateFormat(inputFormat);
			outputDate = sourceFormat.parse(inputStringDate);
		} catch (Exception e) {
			logger.error("Error due to - " + e, e);
			e.printStackTrace();
		}
		return outputDate;
	}

	public static String dateToString(String format, Date date) {
		String returnDate = "";
		if (format != null && date != null) {
			try {
				DateFormat dateFormat = new SimpleDateFormat(format);
				returnDate = dateFormat.format(date);
			} catch (Exception e) {
				logger.error("Error due to - " + e, e);
				e.printStackTrace();
			}
		}
		return returnDate;
	}

	public static long convertDateToJulianDate(Date date) {
		long time = 0L;
		try {
			// logger.debug("getJulianDateTimeNow starts...");
			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
			cal.setTime(date);
			String now = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR))
					+ String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))
					+ String.format("%02d", cal.get(Calendar.MINUTE)) + ""
					+ String.format("%02d", cal.get(Calendar.SECOND)) + ""
					+ String.format("%03d", cal.get(Calendar.MILLISECOND));
			time = Long.parseLong(now);
		} catch (Exception e) {
			logger.error("Error due to - " + e, e);
		}
		// logger.debug("getJulianDateTimeNow ends...");
		return time;
	}

	public static long addDaysToJulianDate(String startDateTime, String numberOfDays) {
		logger.debug("**** deductDaysFromJulianDate() Starts");
		long newDate = 0;
		try {
			Date myDate = convertStringToDate(startDateTime, JULIAN_DATE_FORMAT);
			Calendar cal = Calendar.getInstance();
			cal.setTime(myDate);
			cal.add(Calendar.DATE, +Integer.parseInt(numberOfDays));
			Date dateBeforeDays = cal.getTime();
			newDate = convertDateToJulianDate(dateBeforeDays);
		} catch (Exception e) {
			logger.error("Error::" + e);
		}
		logger.debug("**** deductDaysFromJulianDate() Ends");
		return newDate;
	}

	public static long deductDaysFromJulianDate(String startDateTime, String numberOfDays) {
		logger.debug("**** deductDaysFromJulianDate() Starts");
		long newDate = 0;
		try {
			Date myDate = convertStringToDate(startDateTime, JULIAN_DATE_FORMAT);
			Calendar cal = Calendar.getInstance();
			cal.setTime(myDate);
			cal.add(Calendar.DATE, -Integer.parseInt(numberOfDays));
			Date dateBeforeDays = cal.getTime();
			newDate = convertDateToJulianDate(dateBeforeDays);
		} catch (Exception e) {
			logger.error("Error::" + e);
		}
		logger.debug("**** deductDaysFromJulianDate() Ends");
		return newDate;
	}

	public static String convertJulianDateFormatDateFormatTo(String inputDate, String inputFormat) {
		String formattedDate = "0";
		try {
			String input = inputDate.substring(0, 7);
			DateFormat fmt1 = new SimpleDateFormat("yyyyDDD");
			Date date = fmt1.parse(input);
			DateFormat fmt2 = new SimpleDateFormat(inputFormat);
			formattedDate = fmt2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDate;
	}

	public static String convertJulianISTToJulianUTC(String inputDate) {
		String formattedDate = "0";
		try {
			DateFormat fmt1 = new SimpleDateFormat(JULIAN_DATE_FORMAT);
			fmt1.setTimeZone(TimeZone.getTimeZone("IST"));
			Date date = fmt1.parse(inputDate);

			System.out.println("Date:" + date);
			DateFormat fmt2 = new SimpleDateFormat(JULIAN_DATE_FORMAT);
			formattedDate = fmt2.format(date);

			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone("UTC"));
			cal.setTime(date);
			formattedDate = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR))
					+ String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))
					+ String.format("%02d", cal.get(Calendar.MINUTE)) + ""
					+ String.format("%02d", cal.get(Calendar.SECOND)) + ""
					+ String.format("%03d", cal.get(Calendar.MILLISECOND));
			System.out.println("formattedDate:" + formattedDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDate;
	}

	public static String convertJulianUTCToJulianIST(String inputDate) {
		String formattedDate = "0";
		try {
			DateFormat fmt1 = new SimpleDateFormat(JULIAN_DATE_FORMAT);
			fmt1.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date date = fmt1.parse(inputDate);

			System.out.println("Date:" + date);
			DateFormat fmt2 = new SimpleDateFormat(JULIAN_DATE_FORMAT);
			formattedDate = fmt2.format(date);

			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone("IST"));
			cal.setTime(date);
			formattedDate = cal.get(Calendar.YEAR) + String.format("%03d", cal.get(Calendar.DAY_OF_YEAR))
					+ String.format("%02d", cal.get(Calendar.HOUR_OF_DAY))
					+ String.format("%02d", cal.get(Calendar.MINUTE)) + ""
					+ String.format("%02d", cal.get(Calendar.SECOND)) + ""
					+ String.format("%03d", cal.get(Calendar.MILLISECOND));
			System.out.println("formattedDate:" + formattedDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDate;
	}

}
