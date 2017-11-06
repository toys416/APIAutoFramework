package com.zuora.api.utils;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class LogHelper {

	//public static Logger logger = LogManager.getLogger();

	public static String nowString;
	public static String TAG;

	public static void info(String TAG,String message) {
		nowString=General.getDatetime();
		String header = "[INFO ] " + nowString+" "+TAG+ " - ";
		testngLogOutput(header + message);   //Write to report
	}
	
	public static void info(String message) {
		nowString=General.getDatetime();
		String header = "[INFO ] " + nowString+" - ";
		testngLogOutput(header + message); 
	}

	public static void debug(String TAG,String message) {
		//logger.debug(message);
		nowString=General.getDatetime();
		String header = "[DEBUG] " + nowString+" "+TAG+ " - ";
		testngLogOutput(header + message);
	}

	public static void error(String TAG,String message) {
		//logger.error(message);
		nowString=General.getDatetime();
		String header = "[ERROR] " + nowString+" "+TAG+ " - ";
		testngLogOutput(header + message);
	}

	public static void warn(String TAG,String message) {
		//logger.warn(message);
		nowString=General.getDatetime();
		String header = "[WARN] " + nowString+" "+TAG+ " - ";
		testngLogOutput(header + message);
	}
	

	private static void testngLogOutput(String message) {
		Reporter.log(message,0,true);
	}

}

