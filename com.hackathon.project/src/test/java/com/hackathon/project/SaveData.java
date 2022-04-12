package com.hackathon.project;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SaveData {
	private static XSSFWorkbook workbook;

	public void sendDataToExccelSheet(String[] title, String[] address, String[] ratings, String[] votes,
			String SheetName) {

		File file = new File("outputsa.xlsx");
		if (file.exists() == false) {
			workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(SheetName);
			XSSFRow row = null;
			FileOutputStream fileOutputStream = null;

			// iterating rows and printing the headphones with price
			for (int i = 0; i < title.length; i++) {
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(title[i]);
				row.createCell(1).setCellValue(address[i]);
				row.createCell(2).setCellValue(votes[i]);
				row.createCell(3).setCellValue(ratings[i]);
			}
			sheet.autoSizeColumn(0);

			try {

				workbook.write(fileOutputStream);
				workbook.close();
				fileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Sorry data could not be saved in excel sheet");
			}

		} else {
			workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(SheetName);
			XSSFRow row = null;
			FileOutputStream fileOutputStream = null;

			// iterating rows and printing the headphones with price
			for (int i = 0; i < title.length; i++) {
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(title[i]);
				row.createCell(1).setCellValue(address[i]);
				row.createCell(2).setCellValue(votes[i]);
				row.createCell(3).setCellValue(ratings[i]);
			}
			sheet.autoSizeColumn(0);

			try {
				workbook.write(fileOutputStream);
				workbook.close();
				fileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Sorry data could not be saved in excel sheet");
			}

		}

	}
}
