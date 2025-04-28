package com.tutorialninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
//import java.sql.Date;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateEmailWithTimeStamp() {
		
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		System.out.println(timestamp);
		return timestamp+"@gmail.com";
	}
	
	public static Object[][] getTestDataFromExcel (String sheetName) {
		System.out.println(org.apache.xmlbeans.XmlObject.class.getName());
		System.out.println(org.apache.commons.compress.archivers.zip.ZipFile.class.getName());
		System.out.println(org.apache.xmlbeans.XmlOptions.class.getProtectionDomain().getCodeSource().getLocation());
		System.out.println("XmlBeans loaded from: " + org.apache.xmlbeans.XmlOptions.class.getProtectionDomain().getCodeSource().getLocation());


		File excelFile =  new File(System.getProperty("user.dir") + "/src/main/java/com/tutorialsninja/qa/testdata/testdata.xlsx");
		System.out.println("Excel file path: " + excelFile.getAbsolutePath());
		System.out.println("File exists? " + excelFile.exists());
		System.out.println("XmlBeans loaded from: " + org.apache.xmlbeans.XmlOptions.class.getProtectionDomain().getCodeSource().getLocation());

		XSSFWorkbook workbook = null;
		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		 workbook = new XSSFWorkbook(fisExcel);
		}catch (IOException e) {
		    throw new RuntimeException("Failed to load Excel workbook: " + excelFile.getAbsolutePath(), e);
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
	        throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
	    }
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				 if (cell == null) {
		                data[i][j] = "";
		                continue;
				 }
				switch(cell.getCellType()) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
					
				 default:
	                data[i][j] = "";
	                break;
				}
			}
		}
		
		return data;
		
		}
	
	public static Object[][] getTestDataofiTouchFromExcel (String sheetName) {
		System.out.println(org.apache.xmlbeans.XmlObject.class.getName());
		System.out.println(org.apache.commons.compress.archivers.zip.ZipFile.class.getName());
		System.out.println(org.apache.xmlbeans.XmlOptions.class.getProtectionDomain().getCodeSource().getLocation());
		System.out.println("XmlBeans loaded from: " + org.apache.xmlbeans.XmlOptions.class.getProtectionDomain().getCodeSource().getLocation());


		File excelFile =  new File(System.getProperty("user.dir") + "/src/main/java/com/tutorialsninja/qa/testdata/testdataforitouch.xlsx");
		System.out.println("Excel file path: " + excelFile.getAbsolutePath());
		System.out.println("File exists? " + excelFile.exists());
		System.out.println("XmlBeans loaded from: " + org.apache.xmlbeans.XmlOptions.class.getProtectionDomain().getCodeSource().getLocation());

		XSSFWorkbook workbook = null;
		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		 workbook = new XSSFWorkbook(fisExcel);
		}catch (IOException e) {
		    throw new RuntimeException("Failed to load Excel workbook: " + excelFile.getAbsolutePath(), e);
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
	        throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
	    }
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				 if (cell == null) {
		                data[i][j] = "";
		                continue;
				 }
				switch(cell.getCellType()) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
					
				 default:
	                data[i][j] = "";
	                break;
				}
			}
		}
		
		return data;
		
		}
	}