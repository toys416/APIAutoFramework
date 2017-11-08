package com.zuora.api.utils;

import java.io.IOException;

import org.apache.poi.hssf.model.ConvertAnchor;

import com.google.inject.spi.StaticInjectionRequest;
import com.zuora.api.utils.PropertiesUtil;

public class Config {

	public static String getApiId() throws IOException {
		return PropertiesUtil.getValue("apiAccessKeyId", "config.properties");
	}
	
	public static String getApiKey() throws IOException {
		return PropertiesUtil.getValue("apiSecretAccessKey", "config.properties");
	}
	
	public static String getBaseUrl() throws IOException {
		return PropertiesUtil.getValue("baseUrl", "config.properties");
	}
	
	public static String getExcelPath() throws IOException {
		return PropertiesUtil.getValue("excelPath", "config.properties");
	}
	
	public static int getRetryTime() throws IOException {
		String retryString=PropertiesUtil.getValue("retry", "config.properties");
		return Integer.parseInt(retryString);
	}

}
