package com.technocredits.orghrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static Object[][] getDataFromExcel(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][columnCount];
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				Cell cell = sheet.getRow(row+1).getCell(column);
				if (CellType.NUMERIC == cell.getCellType())
					data[row][column] = String.valueOf(cell.getNumericCellValue());
				else if (CellType.BOOLEAN == cell.getCellType())
					data[row][column] = String.valueOf(cell.getBooleanCellValue());
				else if (CellType.STRING == cell.getCellType())
					data[row][column] = cell.getStringCellValue();
			}
		}
		return data;
	}
}
