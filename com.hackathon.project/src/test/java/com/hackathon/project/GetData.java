package com.hackathon.project;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {
	public String getDataFromExcelSheet(){
		String cityName= null;
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getSheet("Store Details");
		
		return cityName;
//		Map<String, Object[]> data = new HashMap<String, Object[]>();
//		data.put("7", new Object[] {7d, "Sonya", "75K", "SALES", "Rupert"});
//		data.put("8", new Object[] {8d, "Kris", "85K", "SALES", "Rupert"}); data.put("9", new Object[] {9d, "Dave", "90K", "SALES", "Rupert"});
//		// Set to Iterate and add rows into XLS file Set<String> newRows = data.keySet(); // get the last row number to append new data int rownum = mySheet.getLastRowNum(); for (String key : newRows) { // Creating a new Row in existing XLSX sheet Row row = mySheet.createRow(rownum++); Object [] objArr = data.get(key); int cellnum = 0; for (Object obj : objArr) { Cell cell = row.createCell(cellnum++); if (obj instanceof String) { cell.setCellValue((String) obj); } else if (obj instanceof Boolean) { cell.setCellValue((Boolean) obj); } else if (obj instanceof Date) { cell.setCellValue((Date) obj); } else if (obj instanceof Double) { cell.setCellValue((Double) obj); } } }
//
//		Read more: https://www.java67.com/2014/09/how-to-read-write-xlsx-file-in-java-apache-poi-example.html#ixzz7N83tYi71
	}

}
