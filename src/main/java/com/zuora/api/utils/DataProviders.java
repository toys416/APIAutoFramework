package com.zuora.api.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.zuora.api.beans.DataProviderBean;

public class DataProviders {


//	@DataProvider(name = "account_invalid")
//	public static Object[][] account_invalie() {
//		LogHelper.error("test", "in dataprovider: [][]");
//		return new Object[][] { { "A00000047" }, { "A00000047" }, { "A00000047" } };
//	}

	@DataProvider(name = "account_valid", parallel=false)
	public Iterator<DataProviderBean[]> account_valid() throws Exception {
		 return ExcelUtil.getDataProvicerBeansFromExcel("Get Account", "account_valid");

	}
	
	
	@DataProvider(name = "account_invalid",parallel=false)
	public Iterator<DataProviderBean[]> account_invalid() throws Exception {
		 return ExcelUtil.getDataProvicerBeansFromExcel("Get Account", "account_invalid");
	}



}
