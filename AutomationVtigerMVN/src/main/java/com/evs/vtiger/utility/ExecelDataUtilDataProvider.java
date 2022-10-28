package com.evs.vtiger.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecelDataUtilDataProvider {
	
	public static void main(String[] args) throws IOException   {
		String xlsFilePath="src\\main\\resources\\TestCaseData\\TestData.xlsx";
		InputStream  files=	new FileInputStream(xlsFilePath);
		Workbook wBook =new XSSFWorkbook(files);
		Sheet sheetObj= wBook.getSheet("TestData");
		int columnNumber =getColumnNumber(sheetObj,"TcId");
		int rowNumber =getRowNumbers(sheetObj,"vt003ValidateCreateAccount");
		System.out.println("Column Number is "+columnNumber);
		System.out.println("Row Number is "+rowNumber);
//		Map<String, String> data =getData(xlsFilePath,"vt002ValidateCreateLeads");
//		String homePage=data.get("CreateLead_SurName_DD");
//		System.out.println("After the given key name getting value is -: "+homePage);
	}
	
	public  static int getRowNumbers(Sheet sheetObj ,String testcaseId) throws IOException {
		int columnnum =getColumnNumber(sheetObj,"TcId");
		int countRow =sheetObj.getLastRowNum();
		int rowNumbers=-1;
		for (int i = 0; i <=countRow; i++) {
			Row rowObj =sheetObj.getRow(i);
			Cell cellData= rowObj.getCell(columnnum,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if(cellData.getStringCellValue().equalsIgnoreCase(testcaseId)) {
				rowNumbers=i;
			}
		}
		return rowNumbers;
	}
	
	public  static int getColumnNumber (Sheet sheetObj ,String colomnName) throws IOException {
		Row rowObj =sheetObj.getRow(0);
		int columnNumber=-1;
		int  currentCellNumber= rowObj.getLastCellNum();
		for (int j = 0; j <=currentCellNumber-1; j++) {
			Cell cellObj =rowObj.getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String columnData=cellObj.getStringCellValue();
			if (columnData.equalsIgnoreCase(colomnName)) {
				columnNumber=j;
			}
		}
		return columnNumber;
	}
	
	public static Map<String,String> getData(String xlsFilePath,String testcaseId) throws IOException {
		InputStream  files=	new FileInputStream(xlsFilePath);
		String [] arrPath=  xlsFilePath.split("\\.");
		Workbook wBook=null;   
		String fileExcetension=arrPath[1];
		if(fileExcetension.equalsIgnoreCase("xlsx")) {
			wBook= new XSSFWorkbook(files);
		}else if(fileExcetension.equalsIgnoreCase("xls")) {
			wBook =new HSSFWorkbook(files);
		}else {
			System.out.println("File Extension name is wrong Please check it ");
		}
		Sheet sheetObj= wBook.getSheet("TestData");
		int rowNumberList =getRowNumbers(sheetObj, testcaseId);
		Row  rowObj= sheetObj.getRow(rowNumberList);
		int dataColumnNumber =getColumnNumber(sheetObj,"DataName1");
		Map<String,String> dataMap= new HashMap<String,String>();
		Object[][] objData =new Object [rowNumberList][dataColumnNumber];
		int cellCount= rowObj.getLastCellNum();
		for (int i =dataColumnNumber; i <=cellCount-1 ; i=i+2) {
			Cell  cellDataNameObj= rowObj.getCell(i,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			Cell  cellDataValueObj= rowObj.getCell(i+1,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String  cellDataName=cellDataNameObj.getStringCellValue();
			String cellDataValue =cellDataValueObj.getStringCellValue();
			dataMap.put(cellDataName, cellDataValue);
		} 
		return dataMap;
	}
	
	
	
}
