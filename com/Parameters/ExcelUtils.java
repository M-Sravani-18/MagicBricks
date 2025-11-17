package com.Parameters;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
 
import com.Setup.BaseSteps;
public class ExcelUtils{
    public static String readData(String sheetName, int rowNum) throws Exception {
        String excelPath = "src\\test\\resources\\Exceldata\\magicbrickscity.xlsx"; // your Excel path
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);
        String pickup = sheet.getRow(rowNum).getCell(0).getStringCellValue();
        wb.close();
        fis.close();
        return pickup;
    }
}