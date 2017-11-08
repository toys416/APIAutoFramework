package com.zuora.api.listeners;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.zuora.api.utils.Config;
import com.zuora.api.utils.LogHelper;

public class Retry implements IRetryAnalyzer {
	private static final String TAG="IRetryAnalyzer";
	private int retryCount = 1;
	private int maxReryCount;

	public boolean retry(ITestResult result) {
		try {
			maxReryCount = Config.getRetryTime();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (retryCount <= maxReryCount) {		
			String message="Running Retry for "+result.getName()+" on class" +this.getClass().getName()+ " retrying "+ retryCount+" time.";
			LogHelper.debug(TAG,message);
			retryCount++;
			return true;
		}
		return false;
	}
}
