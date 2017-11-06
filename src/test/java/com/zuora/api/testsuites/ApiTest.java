package com.zuora.api.testsuites;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zuora.api.beans.ResponseBean;
import com.zuora.api.http.HttpClientUtil;
import com.zuora.api.http.ReponseUtil;
import com.zuora.api.http.RunTest;
import com.zuora.api.utils.LogHelper;
import com.zuora.api.utils.PropertiesUtil;

public class ApiTest extends BaseTest {

	private static final String TAG = "ApiTest";

	@Test
	public void getAccount() {

		String url = baseUrl + "accounts/A00000045";
		ResponseBean responseBean = RunTest.runT("GET",httpClient, url, headerMap);
		//ResponseBean responseBean = RunTest.runGet(httpClient, url, headerMap);
		// add Assert
		Assert.assertEquals("OK", responseBean.getStatus());
		Assert.assertEquals("200", responseBean.getStatusCode());

	}

	@Test
	@Parameters({ "apiAccessKeyId", "apiSecretAccessKey", "baseUrl" })
	public void getAccountSummary(String usr, String pwd, String baseUrl) {

		try {
			String url = baseUrl + "accounts/A00000045/summary";
			httpClient = HttpClients.createDefault();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("apiAccessKeyId", usr);
			headerMap.put("apiSecretAccessKey", pwd);

			CloseableHttpResponse httpResponse = HttpClientUtil.doGet(url, headerMap, httpClient);
			ResponseBean responseBean = ReponseUtil.setResponseBean(httpResponse);

			// add Assert
			Assert.assertEquals("OK", responseBean.getStatus());
			Assert.assertEquals("200", responseBean.getStatusCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
