package com.zuora.ApiAutoFramework.utils;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class LogHelper {

	//public static Logger logger = LogManager.getLogger();

	public static String nowString;

	public static void info(String message) {
		//logger.info(message);		          //Write to console
		nowString=General.getDatetime();
		String header = "[INFO ] " + nowString+" - ";
		testngLogOutput(header + message);   //Write to report
	}

	public static void debug(String message) {
		//logger.debug(message);
		nowString=General.getDatetime();
		String header = "[DEBUG] " + nowString+" - ";
		testngLogOutput(header + message);
	}

	public static void error(String message) {
		//logger.error(message);
		nowString=General.getDatetime();
		String header = "[ERROR] " + nowString+" - ";
		testngLogOutput(header + message);
	}

	public static void warn(String message) {
		//logger.warn(message);
		nowString=General.getDatetime();
		String header = "[WARN ] " + nowString+" - ";
		testngLogOutput(header + message);
	}
	

	private static void testngLogOutput(String message) {
		Reporter.log(message,0,true);
	}

}

