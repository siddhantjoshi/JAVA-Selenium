package com.hackathon.project;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(parallel = true)
	public Object[][] dataProviderMethod() throws Exception {

		File file = new File("data.xlsx");
		FileInputStream fileInput = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("data");
		int row = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[row - 1][col];

		for (int i = 0; i < row - 1; i++) {
			for (int j = 0; j < col; j++) {
				DataFormatter dataFormatter = new DataFormatter();
				data[i][j] = dataFormatter.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}

		workbook.close();
		fileInput.close();
	
		return data ; 
	}
}
