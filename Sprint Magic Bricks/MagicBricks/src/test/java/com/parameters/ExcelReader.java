package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	

	    public static List<String[]> readExcelData(String filePath, String sheetName) {
	        List<String[]> data = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                System.out.println("❌ Sheet '" + sheetName + "' not found in file: " + filePath);
	                return data;
	            }

	            DataFormatter formatter = new DataFormatter();

	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue;

	                String city = formatter.formatCellValue(row.getCell(0));
	                String budget = formatter.formatCellValue(row.getCell(1));

	                // Skip empty rows
	                if (city.isEmpty() && budget.isEmpty()) continue;

	                data.add(new String[]{city.trim(), budget.trim()});
	            }

	        } catch (IOException e) {
	            System.out.println("Error reading Excel file: " + filePath);
	            e.printStackTrace();
	        }

	        return data;
	    }
	}

	
//	
//	   public static List<String[]> readExcelData(String filePath, String sheetName) {
//	        List<String[]> data = new ArrayList<>();
//	        try (FileInputStream fis = new FileInputStream(filePath);
//	             Workbook workbook = new XSSFWorkbook(fis)) {
//
//	            Sheet sheet = workbook.getSheet(sheetName);
//	            DataFormatter fmt = new DataFormatter();
//
//	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//	                Row row = sheet.getRow(i);
//	                if (row == null) continue;
//	                String city = fmt.formatCellValue(row.getCell(0));
//	                String budget = fmt.formatCellValue(row.getCell(1));
//	                data.add(new String[]{city, budget});
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        return data;
//	    }
//	
	
	

//	public static String readCell(String filePath,String sheetName, int rowIndex, int colIndex) {
//		String cellValue="";
//		 FileInputStream fis = null;
//	        Workbook workbook = null;
//
//	        try {
//	            fis = new FileInputStream(filePath);
//	            workbook = new XSSFWorkbook(fis);
//	            Sheet sheet = workbook.getSheet(sheetName);
//	            if (sheet == null) {
//	                throw new IllegalArgumentException("Sheet not found: " + sheetName);
//	            }
//
//	            Row row = sheet.getRow(rowIndex);
//	            if (row == null) {
//	                throw new IllegalArgumentException("Row not found: " + rowIndex);
//	            }
//
//	            Cell cell = row.getCell(colIndex);
//	            if (cell == null) {
//	                throw new IllegalArgumentException("Cell not found at column: " + colIndex);
//	            }
//
//	            DataFormatter formatter = new DataFormatter();
//	            cellValue = formatter.formatCellValue(cell);
//
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (workbook != null) workbook.close();
//	                if (fis != null) fis.close();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
//
//	        return cellValue;
//	    }
	
