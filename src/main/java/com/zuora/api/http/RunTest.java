package com.zuora.api.http;

import java.util.Hashtable;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;

import com.google.common.base.CaseFormat;
import com.zuora.api.beans.ResponseBean;
import com.zuora.api.utils.LogHelper;

public class RunTest {

	static ResponseBean responseBean = null;
	static CloseableHttpResponse httpResponse = null;
	private static final String TAG="RunTest";

	public static ResponseBean runGet(CloseableHttpClient httpClient, String url, Hashtable<String, String> headerMap) {
		try {
			httpResponse = HttpClientUtil.doGet(url, headerMap, httpClient);
			responseBean = ReponseUtil.setResponseBean(httpResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}

	public static ResponseBean runPost(CloseableHttpClient httpClient, String url,
			Hashtable<String, String> headerMap) {
		try {
			httpResponse = HttpClientUtil.doPost(url, headerMap, httpClient);
			responseBean = ReponseUtil.setResponseBean(httpResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}

	public static ResponseBean runT(String how, CloseableHttpClient httpClient, String url,
			Hashtable<String, String> headerMap) {
		
		how=how.toUpperCase();
		try {
			switch (how) {
			case "GET":
				httpResponse = HttpClientUtil.doGet(url, headerMap, httpClient);
				break;
			case "POST":
				httpResponse = HttpClientUtil.doPost(url, headerMap, httpClient);
				break;
			case "PUT":
				LogHelper.warn(TAG, "PUT is not supported yet.");
				break;
			case "DELETE":
				LogHelper.warn(TAG, "DELETE is not supported yet.");
				break;
			default:
				LogHelper.error(TAG, how+" is not a valid HTTP method!");
				break;
			}
			responseBean = ReponseUtil.setResponseBean(httpResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}

}
