package com.ClearTrip.CommonFunctions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	public static String filename = "C:\\Users\\220097\\Workspace\\ClearTrip\\src\\com\\ClearTrip\\TestData\\TestData.xlsx";
	

	public static String getData (String SheetName, int row, int col) throws IOException
	{
		FileInputStream ExcelFile = new FileInputStream(filename);
		
		// Access the required file3
		

		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		XSSFCell ExcelCell = ExcelWSheet.getRow(row).getCell(col);
		ExcelCell.setCellType(Cell.CELL_TYPE_STRING);
		String cellData = ExcelCell.getStringCellValue();
				return cellData;
	}
}
