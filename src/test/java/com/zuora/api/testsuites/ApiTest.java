package com.zuora.api.testsuites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zuora.api.beans.ResponseBean;
import com.zuora.api.http.RunTest;

public class ApiTest extends BaseTest {

	private static final String TAG = "ApiTest";

//	@Test
//	public void getAccount() {
//
//		String url = baseUrl + "accounts/A0000004523";
//		ResponseBean responseBean = RunTest.runT("GET",httpClient, url, headerMap);
//		// add Assert
//		Assert.assertEquals("OK", responseBean.getStatus());
//		Assert.assertEquals("200", responseBean.getStatusCode());
//	}
	
	@Test(dataProvider="account_valid",dataProviderClass=com.zuora.api.utils.DataProviders.class)
	public void getAccount_valid(String account) {

		String url = baseUrl + "accounts/"+account;
		ResponseBean responseBean = RunTest.runT("GET",httpClient, url, headerMap);
		// add Assert
		Assert.assertEquals("OK", responseBean.getStatus());
		Assert.assertEquals("200", responseBean.getStatusCode());
	}
	
	
	@Test(dataProvider="account_invalid",dataProviderClass=com.zuora.api.utils.DataProviders.class)
	public void getAccount_invalid(String account) {

		String url = baseUrl + "accounts/"+account;
		ResponseBean responseBean = RunTest.runT("GET",httpClient, url, headerMap);
		// add Assert
		Assert.assertEquals("OK", responseBean.getStatus());
		Assert.assertEquals("200", responseBean.getStatusCode());
	}
	

//	@Test
//	@Parameters({ "apiAccessKeyId", "apiSecretAccessKey", "baseUrl" })
//	public void getAccountSummary(String usr, String pwd, String baseUrl) {
//
//		try {
//			String url = baseUrl + "accounts/A00000045/summary";
//			httpClient = HttpClients.createDefault();
//
//			Map<String, String> headerMap = new HashMap<String, String>();
//			headerMap.put("apiAccessKeyId", usr);
//			headerMap.put("apiSecretAccessKey", pwd);
//
//			CloseableHttpResponse httpResponse = HttpClientUtil.doGet(url, headerMap, httpClient);
//			ResponseBean responseBean = ReponseUtil.setResponseBean(httpResponse);
//
//			// add Assert
//			Assert.assertEquals("OK", responseBean.getStatus());
//			Assert.assertEquals("200", responseBean.getStatusCode());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
