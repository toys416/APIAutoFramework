package com.zuora.api.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "account_valid")
	public static Object[][] account_valid() {
		return new Object[][] { 
			{ "A00000045" }, 
			{ "A00000046" }, 
			{ "A00000047" } 
			};
	}
	
	
	@DataProvider(name = "account_invalid")
	public static Object[][] account_invalie() {
		return new Object[][] { 
			{ "A00000045123" }, 
			{ "A00000erererer" }, 
			{ "@" } 
			};
	}
}
