package com.zuora.api.testsuites;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.zuora.api.beans.ConfigBean;
import com.zuora.api.beans.ResponseBean;
import com.zuora.api.utils.Config;
import com.zuora.api.utils.LogHelper;
import com.zuora.api.utils.PropertiesUtil;

public class BaseTest {
	
	private static final String TAG="BaseTest";
	protected static CloseableHttpClient httpClient=null;
	protected static CloseableHttpResponse httpResponse=null;
	protected static ResponseBean responseBean=null;
	protected static String baseUrl="";
	protected static String usr="";
	protected static String pwd="";
	protected static Hashtable<String,String> headerMap;
	
	
	@BeforeTest
	public void beforeTest() throws IOException {
		
		//read config from file
//		baseUrl= PropertiesUtil.getValue("baseUrl", "config.proterties");
//		usr= PropertiesUtil.getValue("apiAccessKeyId", "config.proterties");
//		pwd= PropertiesUtil.getValue("apiSecretAccessKey", "config.proterties");
		
		baseUrl= Config.getBaseUrl();
		usr= Config.getApiId();
		pwd= Config.getApiKey();
		
		//Compose header with usr,pwd
		headerMap=new Hashtable<String, String>();
		headerMap.put("apiAccessKeyId", usr);
		headerMap.put("apiSecretAccessKey",pwd);
		
		httpClient = HttpClients.createDefault();
	}

	@AfterTest
	public void afterTest() {
		try {
			LogHelper.debug(TAG,"Close httpclient");
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void closeClient() {

	}
	

}
