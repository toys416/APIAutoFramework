package com.zuora.ApiAutoFramework.testsuites;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zuora.ApiAutoFramework.utils.LogHelper;


public class Accounts extends BaseTest{


	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws Exception {
	}

	@AfterMethod
	public void teardown(ITestResult itr) throws Exception {

	}

	@Test(testName = "Create_Account", groups = { "create" })
	public void create_account() throws Exception {
		LogHelper.debug("first case");
		Assert.assertEquals(1, 1);
	}
}