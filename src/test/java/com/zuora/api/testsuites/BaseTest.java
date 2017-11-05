package com.zuora.api.testsuites;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

//	@BeforeTest
//	public static void init() {
//	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws Exception {
	}

	@AfterMethod
	public void teardown(ITestResult itr) throws Exception {

	}

	
}
