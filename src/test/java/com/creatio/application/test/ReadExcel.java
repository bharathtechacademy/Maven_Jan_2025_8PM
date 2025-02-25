package com.creatio.application.test;

import java.util.List;
import java.util.Map;

import com.creatio.framework.utilities.ExcelUtil;

public class ReadExcel {

	public static void main(String[] args) {
		List<Map<String,String>> data = ExcelUtil.readData("TestData.xlsx", "LoginData");		
		
		System.out.println(data.get(1).get("Password"));
		
		String [][] excelData = ExcelUtil.readExcelData("TestData.xlsx", "LoginData");

	}

}
