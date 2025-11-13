//package com.Parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//
//    private static final String FILE_PATH = "\"C:\\training\\SprintMagicbricks\\MagicBricks\\src\\test\\resources\\magicbricksdata1.xlsx\"";
//
//    public static String getCellValue(int sheetIndex, int rowIndex, int cellIndex) {
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            Row row = sheet.getRow(rowIndex);
//            Cell cell = row.getCell(cellIndex);
//
//            return cell.getCellType() == CellType.STRING ? cell.getStringCellValue() :
//                   cell.getCellType() == CellType.NUMERIC ? String.valueOf(cell.getNumericCellValue()) :
//                   "";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}

//package com.Parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//    private static final String FILE_PATH = "C:\\training\\SprintMagicbricks\\MagicBricks\\src\\test\\resources\\magicbricksdata1.xlsx";
//
//    public static String getCellValue(int sheetIndex, int rowIndex, int cellIndex) {
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            Row row = sheet.getRow(rowIndex);
//            Cell cell = row.getCell(cellIndex);
//
//            if (cell == null) return "";
//
//            return switch (cell.getCellType()) {
//                case STRING -> cell.getStringCellValue();
//                case NUMERIC -> String.valueOf(cell.getNumericCellValue());
//                default -> "";
//            };
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}

//package com.Parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//    private static final String FILE_PATH = "C:\\training\\SprintMagicbricks\\MagicBricks\\src\\test\\resources\\magicbricksdata1.xlsx";
//
//    public static String getCellValue(int sheetIndex, int rowIndex, int cellIndex) {
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(sheetIndex);
//            Row row = sheet.getRow(rowIndex);
//            Cell cell = row.getCell(cellIndex);
//
//            if (cell == null) return "";
//
//            return switch (cell.getCellType()) {
//                case STRING -> cell.getStringCellValue();
//                case NUMERIC -> String.valueOf(cell.getNumericCellValue());
//                default -> "";
//            };
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}

//package com.Parameters;
// 
//import java.io.FileInputStream;
// 
// 
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// 
//import java.io.File;
// 
// 
//public class ExcelReader {
//public static String getLocalityByRow(String filePath, int sheetIndex, int rowIndex) {
//	File file = new File(filePath);
//   
//    try (FileInputStream fis = new FileInputStream(filePath);
//         Workbook workbook = new XSSFWorkbook(fis)) {
// 
//        Sheet sheet = workbook.getSheetAt(sheetIndex);
//        Row row = sheet.getRow(rowIndex);
//        if (row != null) {
//            Cell cell = row.getCell(0);
//            if (cell != null) {
//                return cell.getStringCellValue().trim();
//            }
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
// 
//return null;
//}
//}
// 

package com.Parameters;
 
import java.io.FileInputStream;
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

	
}
