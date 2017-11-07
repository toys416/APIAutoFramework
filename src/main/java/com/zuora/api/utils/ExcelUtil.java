package com.zuora.api.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.zuora.api.beans.DataProviderBean;
import com.zuora.api.utils.PropertiesUtil;

/*
 * Excel Read&Write
 */
public class ExcelUtil {

	static String excelPath;

	public static Iterator<DataProviderBean[]> getDataProvicerBeansFromExcel(String apiName, String caseName)
			throws Exception {

		excelPath = PropertiesUtil.getValue("excelPath", "config.properties");
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(excelPath));
		HSSFSheet sheet = wb.getSheet(apiName);

		// Get total rows
		int rowNums = sheet.getLastRowNum();
		String method, url, desc, param, status, statusCode;

		List<DataProviderBean> beans = new ArrayList<DataProviderBean>();
		for (int i = 1; i <= rowNums; i++) {
			HSSFRow row = sheet.getRow(i);
			// Change cell type to STRING
			for (int j = 0; j < 8; j++) {
				row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			}

			method = row.getCell(2).getStringCellValue();
			url = row.getCell(3).getStringCellValue();
			desc = row.getCell(4).getStringCellValue();
			param = row.getCell(5).getStringCellValue();
			status = row.getCell(6).getStringCellValue();
			statusCode = row.getCell(7).getStringCellValue();

			if (row.getCell(1).getStringCellValue().equals(caseName)) {
				DataProviderBean bean = new DataProviderBean();
				bean.setMethod(method);
				bean.setUrl(url);
				bean.setDesc(desc);
				bean.setParam(param);
				bean.setStatus(status);
				bean.setStatusCode(statusCode);
				beans.add(bean);
			}
		}

		List<DataProviderBean[]> dataProviders = new ArrayList<DataProviderBean[]>();
		for (DataProviderBean u : beans) {
			dataProviders.add(new DataProviderBean[] { u });
		}

		return dataProviders.iterator();

	}

	// public static void main(String [] args){
	// String
	// path=System.getProperty("user.dir")+"/src/main/java/com/dji/itester/data/params.xlsx";
	// System.out.println(System.getProperty("user.dir")+"/src/main/java/com/dji/itester/data/params.xlsx");
	// try {
	// List<DataProviderBean> param=ExcelUtil.readExcel(path);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}