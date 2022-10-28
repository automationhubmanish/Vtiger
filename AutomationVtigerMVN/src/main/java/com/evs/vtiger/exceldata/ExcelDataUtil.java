package com.evs.vtiger.exceldata;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtil {


	public  int getColumnNumber (Sheet sheetObj ,String colomnName) throws IOException {
		Row rowObj =sheetObj.getRow(0);
		int columnNumber=-1;
		//		It method give last number of cell where is our data ending
		int  currentCellNumber= rowObj.getLastCellNum();
		for (int j = 0; j <=currentCellNumber-1; j++) {
			Cell cellObj =rowObj.getCell(j);
			String columnData=cellObj.getStringCellValue();
			if (columnData.equalsIgnoreCase(colomnName)) {
				columnNumber=j;
			}
		}
		return columnNumber;
	}

	public  List<Map<String,String>> getTestCaseData(String xlsFilePath,String testcaseId) throws IOException {

		// For reading excel file we will use File input stream
		//	 	when we want to write any data in excel then we will use FileoutPutsream ..	
		// InputStream is a parent of FileInputsream .....	
		InputStream  files=	new FileInputStream(xlsFilePath);
		//		It will split(break) the path according to (.) like our path is TestCase.xlsx or TestCase.xls
		String [] arrPath=  xlsFilePath.split("\\.");
		Workbook wBook=null;   
		String fileExcetension=arrPath[1];
		//		Here we are passing condition when condition will true then it will create object of XSSFWorkBook if condition will false 
		//		then it will go on the next condition 
		if(fileExcetension.equalsIgnoreCase("xlsx")) {
			// Here we will create object of XSSFWorkbook for using reference variable of File Input Stream 	
			wBook= new XSSFWorkbook(files);
			//			Here we are passing condition when condition will true then it will create object of HSSFWorkBook if condition will false 
			//			then it will go on the next condition 
		}else if(fileExcetension.equalsIgnoreCase("xls")) {
			wBook =new HSSFWorkbook(files);
		}else {
			System.out.println("File Extension name is wrong Please check it ");
		}
		//		Here we are calling getSheet method in which we will pass sheet name on which sheet we want to work
		Sheet sheetObj= wBook.getSheet("TestData");
		//		It get the row number of given testcaseId 
		List<Integer> rowNumbersList =getRowNumbers(sheetObj,testcaseId) ;
		//		It keep all map data in a list.
		List<Map<String,String>> completeDataMapList =new ArrayList<Map<String,String>>();
		//		This loop will executing as long as condition is true
		for(int j=0;j<=rowNumbersList.size()-1;j++) {
			//			It go on all list data one by one and it will also count the number of List Row 
			int rowNumber=	rowNumbersList.get(j);
			//		it keep all data in pears like Key and value .
			Map<String,String> testCaseDataMap =new HashMap<String,String>();
			//		Here  we  are passing reference variable of row number for getting row count
			Row  rowObj= sheetObj.getRow(rowNumber);
			//		It get column number of given column name .
			int dataColumnNumber =getColumnNumber(sheetObj,"DataName1");
			//		It get total cell number in which cell have data . 
			int cellCount= rowObj.getLastCellNum();
			//			This loop will keep executing alternate as long as the condition is true .
			for (int i =dataColumnNumber; i <=cellCount-1 ; i=i+2) {
				//			It go on all cell one by one(like 1,2,3) which cell have data  
				Cell  cellDataNameObj= rowObj.getCell(i,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				//			It go on all cell one after one(like 1,3,5) which cell have data
				Cell  cellDataValueObj= rowObj.getCell(i+1,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				//			It get all data in a string because in the excel sheet we have all data in string 
				String  cellDataName=cellDataNameObj.getStringCellValue();
				String cellDataValue =cellDataValueObj.getStringCellValue(); 
				//			Here we do pass data of map first is key and second is value
				testCaseDataMap.put(cellDataName,cellDataValue);
			} 
			//		Here we do call add method of List Map for storing all data of map
			//		Here we will have to pass reference variable of Map and it keep adding all map in a list
			completeDataMapList.add(testCaseDataMap);
		}

		return completeDataMapList;
	}

	public  List<Integer> getRowNumbers(Sheet sheetObj ,String testcaseId) throws IOException {
		//	It get column number of given column name.	And here we are passing argument of sheetObj for getting object of sheet
		int columnnum =getColumnNumber(sheetObj,"TcId");
		int countRow =sheetObj.getLastRowNum();
		List<Integer> rowNumbers=new ArrayList<Integer>();
		for (int i = 0; i <=countRow; i++) {
			Row rowObj =sheetObj.getRow(i);
			Cell cellData= rowObj.getCell(columnnum,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if(cellData.getStringCellValue().equalsIgnoreCase(testcaseId)) {
				rowNumbers.add(i);
			}
		}

		return rowNumbers;
	}



}
