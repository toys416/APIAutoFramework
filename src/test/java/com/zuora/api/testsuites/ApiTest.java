package com.zuora.api.testsuites;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zuora.api.beans.ResponseBean;
import com.zuora.api.http.HttpClientUtil;
import com.zuora.api.http.ReponseUtil;
import com.zuora.api.utils.PropertiesUtil;


public class ApiTest {

	static CookieStore cookieStore=null;

	static CloseableHttpClient httpclient=null;

	@Test
	public void signIN() {

		try {
			String url = PropertiesUtil.getValue("url","config.properties");

			httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
			CloseableHttpResponse httpResponse = HttpClientUtil.doPost(url, paramsMap, httpclient, cookieStore);
			ResponseBean responseBean = ReponseUtil.setResponseBean(httpResponse);

			// add Assert
			Assert.assertEquals("OK", responseBean.getStatus());
			Assert.assertEquals("200", responseBean.getStatusCode());
			Assert.assertEquals("dsgfdfgdfsdfdgfdg", responseBean.getBody());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void closeClient() {
		try {
			// 关闭流并释放资源
			httpclient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
