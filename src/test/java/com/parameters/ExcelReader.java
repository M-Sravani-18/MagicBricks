

package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
		try (FileInputStream fis = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(sheetIndex);
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				Cell cell = row.getCell(0);
				if (cell != null) {
					return cell.getStringCellValue().trim();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static final int SEARCH_COLUMN_INDEX=0;
	public static String pathfiles="C:\\Users\\madhams\\OneDrive - Capgemini\\Desktop\\Training\\SprintMagicBricks\\MagicBricks\\src\\test\\resources\\com\\Excel\\Filters.xlsx";
	public static String getCellDatas(String filePath, Integer int1, Integer int2, Integer colIndex) {
	    String cellValue = "";
	    FileInputStream fis = null;
	    Workbook workbook = null;
	 
	    try {
	        fis = new FileInputStream(filePath);
	        workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(int1);
	        Row row = sheet.getRow(int2);
	        Cell cell = row.getCell(colIndex);
	 
	        if (cell != null) {
	            cellValue = cell.toString().trim();
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading Excel file: " + e.getMessage());
	    } finally {
	        try {
	            if (workbook != null) workbook.close();
	            if (fis != null) fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return cellValue;
	}
}