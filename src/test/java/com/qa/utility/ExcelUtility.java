package com.qa.utility;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell; 
import org.apache.poi.xssf.usermodel. XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fileLoc;

	public static XSSFWorkbook wBook;

	public static XSSFSheet wsheet;

	public static XSSFRow row;

	public static XSSFCell cell;

	public static int getRowCount (String xFile, String xSheet) throws IOException {

		fileLoc= new FileInputStream(xFile);

		wBook = new XSSFWorkbook (fileLoc); 


		wsheet = wBook.getSheet(xSheet);
		int rowCount = wsheet.getLastRowNum();

		return rowCount;
	}

	// sethod to get the cell count.

	public static int getCellCount(String xFile, String xSheet, int rowNum) throws IOException { 


		fileLoc = new FileInputStream(xFile);

		wBook= new XSSFWorkbook(fileLoc); 
		wsheet = wBook.getSheet(xSheet);

		row = wsheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();

		return cellCount;
	}

	// read the data from each cell and return in the String format.

	public static String getCellData(String xFile, String xSheet, int rowNum, int colNum) throws IOException {

		fileLoc= new FileInputStream(xFile); 
		wBook = new XSSFWorkbook(fileLoc);



		wsheet = wBook.getSheet(xSheet); 
		row = wsheet.getRow(rowNum);

		cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter(); 
		String cellData = formatter.formatCellValue(cell);
		
//		wBook.close();

		fileLoc.close();	

		return cellData;

	}
}
