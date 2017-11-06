package com.zuora.api.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.inject.spi.StaticInjectionRequest;
import com.zuora.api.utils.LogHelper;


public class HttpClientUtil {

	private static Charset s = Consts.UTF_8;
	private static UrlEncodedFormEntity entitys = null;
	private static Hashtable headerMap = null;
	private static final String TAG="HttpClientUtil";

	/**
	 * doGet
	 * @param url
	 * @param headerMap
	 * @param httpclient
	 * @return
	 */
	public static CloseableHttpResponse doGet(String url, Map<String, String> headerMap, CloseableHttpClient httpclient) {

		HttpGet httpget = null;
		try {
			httpget = new HttpGet(url);
			for(String header : headerMap.keySet()){
				httpget.addHeader(header,headerMap.get(header));
			}
			CloseableHttpResponse httpResponse = httpclient.execute(httpget);
			return httpResponse;

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
/**
 * doPost
 * @param url
 * @param headerMap
 * @param httpclient
 * @return
 */
	public static CloseableHttpResponse doPost2(String url,  Map<String, String> headerMap,CloseableHttpClient httpclient) {

		HttpPost httppost = new HttpPost(url);
		for(String header : headerMap.keySet()){
			httppost.addHeader(header,headerMap.get(header));
		}
		try {
			CloseableHttpResponse httpResponse = httpclient.execute(httppost);
			return httpResponse;
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	

}
