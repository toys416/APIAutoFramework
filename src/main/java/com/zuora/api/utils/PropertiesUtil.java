package com.zuora.api.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Read .properties config file
 * 
 * @author Jingzhou.Wang
 *
 */
public class PropertiesUtil {

	static String configPath = "cfg/config.properties";

	/*
	 * Get config by key
	 */
	public static String getValue(String key, String configName) throws IOException {

		// Load key,value
		InputStream in = new BufferedInputStream(new FileInputStream(new File(configPath)));
		Properties prop = new Properties();
		prop.load(in);
		String value = prop.getProperty(key);
		return value;
	}

}
