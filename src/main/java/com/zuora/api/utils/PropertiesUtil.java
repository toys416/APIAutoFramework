package com.zuora.api.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Read .properties config file
 * 
 * @author Jingzhou.Wang
 *
 */
public class PropertiesUtil {
	
	
	public static String getValue(String key,String configName) throws IOException{
		
		// Load key,value
		Properties prop = new Properties();
		String configPath=PropertiesUtil.class.getClassLoader().getResource(configName).getPath();
		
		FileReader fr = new FileReader(configPath);
		prop.load(fr);
		fr.close();	
		// Get Date
		String value = prop.getProperty(key);
		return value;
	}
}
