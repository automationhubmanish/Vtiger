package com.evs.vtiger.exceldata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practise {

	public static void main(String[] args) throws IOException {
		getTestCaseData("TestCaseData/TestCase.xlsx","VT004");
	
	
	}
	
	public static void getTestCaseData(String xlpath,String testCaseId) throws IOException {
		InputStream fis=new	FileInputStream(xlpath);
		Map<String,String> dataMap =new HashMap<String,String>();
		String [] arrPath=  xlpath.split("\\.");
		Workbook wBook=null;   
		String fileExcetension=arrPath[1];
		if(fileExcetension.equalsIgnoreCase("xlsx")) {
			wBook= new XSSFWorkbook(fis);
		}else if(fileExcetension.equalsIgnoreCase("xls")) {
			wBook =new HSSFWorkbook(fis);
		}else {
			System.out.println("File Extension name is wrong Please check it ");
		}
		Sheet sheetObj=wBook.getSheet("TestData");
		int rowNumber =getRowNumber(sheetObj, testCaseId);
		Row dataRowObj=    sheetObj.getRow(rowNumber);
		int dataCellCount=  dataRowObj.getLastCellNum();
		int dataStartingColumnNumber= getColumnNumber(sheetObj,"DataName1");
		for (int i =dataStartingColumnNumber; i <=dataCellCount-1; i=i+2) {
			Cell  cellDataNameObj= dataRowObj.getCell(i);  
			Cell  cellDataValueObj= dataRowObj.getCell(i+1);
			String  cellDataName=cellDataNameObj.getStringCellValue();
			String cellDataValue =cellDataValueObj.getStringCellValue();
		System.out.println(cellDataName+" = "+cellDataValue);
		dataMap.put(cellDataName, cellDataValue);
		}
	}
	public static int getRowNumber(Sheet sheetObj ,String testcaseId) throws IOException {
		int columnnum =getColumnNumber(sheetObj,"TcId");
		int countRow =sheetObj.getLastRowNum();
		int rowNumber=-1;
		for (int i = 0; i <=countRow; i++) {
			Row rowObj =sheetObj.getRow(i);
			Cell cellData= rowObj.getCell(columnnum,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if(cellData.getStringCellValue().equalsIgnoreCase(testcaseId)) {
				rowNumber=i;
				break;
			}
		}
		return rowNumber;
	}
	
	public static int getColumnNumber(Sheet sheetObj ,String colomnName) throws IOException {
		Row rowObj =sheetObj.getRow(0);
		int columnNumber=-1;
		int  currentCellNumber= rowObj.getLastCellNum();
		for (int j = 0; j <=currentCellNumber-1; j++) {
			Cell cellObj =rowObj.getCell(j);
			String columnData=cellObj.getStringCellValue();
			if (columnData.equalsIgnoreCase(colomnName)) {
				columnNumber=j;
				break;
			}
		}
//		System.out.println(columnNumber);
		return columnNumber;

	}

	public static void getAllExcelData() throws IOException {

		InputStream  files=	new FileInputStream("TestCaseData\\TestCase.xlsx");
		XSSFWorkbook wBook= new XSSFWorkbook(files);
		XSSFSheet sheetObj= wBook.getSheet("TestData");
		int countRow=sheetObj.getLastRowNum();
		for (int i = 0; i <=countRow; i++) {
			XSSFRow  rowObj= sheetObj.getRow(i);
			int  currentCellNumber= rowObj.getLastCellNum();
			for (int j = 0; j <=currentCellNumber-1; j++) {
				XSSFCell cellObj =rowObj.getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				String cellValue =cellObj.getStringCellValue();
				System.out.print(cellValue+",");	
			}
			System.out.println("");
		}
	}
	public void getColumnNumberData(int columnNumber) throws IOException {
		InputStream  files=	new FileInputStream("TestCaseData\\TestCase.xlsx");
		XSSFWorkbook wBook=new XSSFWorkbook(files);
		XSSFSheet sheetObj= wBook.getSheet("TestData");

		for (int i = 0; i <sheetObj.getLastRowNum(); i++) {
			XSSFRow  rowObj= sheetObj.getRow(i);
			XSSFCell  cellObj= rowObj.getCell(columnNumber);
			String cellValue =cellObj.getStringCellValue();
			System.out.print(cellValue+",");
		}
		System.out.println();	
	}
	public static void getRowNumberData(int RowNumber) throws IOException {
		InputStream  files=	new FileInputStream("TestCaseData\\TestCase.xlsx");
		XSSFWorkbook wBook=    new XSSFWorkbook(files);
		XSSFSheet sheetObj= wBook.getSheet("TestData");
		XSSFRow  rowObj= sheetObj.getRow(RowNumber);
		int dataColumnNumber =getColumnNumber(sheetObj,"DataName1");
		for (int i =dataColumnNumber; i < rowObj.getLastCellNum(); i++) {
			XSSFCell  cellObj= rowObj.getCell(i);
			String cellValue =cellObj.getStringCellValue();
			System.out.print(cellValue+",");
		}
		System.out.println();
	}
	public void simpleCode(int RowNumber,int cellNumber) throws IOException {
		InputStream  files=	new FileInputStream("TestCaseData\\TestCase.xlsx");
		XSSFWorkbook wBook=    new XSSFWorkbook(files);
		XSSFSheet sheetObj= wBook.getSheet("TestData");
		XSSFRow  rowObj= sheetObj.getRow(RowNumber);
		XSSFCell  cellObj= rowObj.getCell(cellNumber);
		System.out.println(cellObj);
	}




	public void defineAbtCode() throws IOException{
		// For reading excel file  purpase we will use Fileinputstream
		//	 	when we want to write any data in excel then we will FileoutPutsream ..	
		// InputStream is a parent of FileInputsream .....		
		InputStream  files=	new FileInputStream("TestCaseData\\TestCase.xlsx");
		// For 	using fileinputsream valiable we will use XSSFWorkbook ........	
		XSSFWorkbook wBook=    new XSSFWorkbook(files);
		// For taking excel sheet we will use of getSheet in which we will have to pass sheet name      
		// For taking excel sheet we will use of getSheetAt in which we will have to pass number of sheet
		// it both return object of XSSFSheet  				
		XSSFSheet sheetObj= wBook.getSheet("TestData");
		// For Taking row number we will have to use getRow method
		// it take always one argument of int then we pass number of
		// row for taking data
		XSSFRow  rowObj= sheetObj.getRow(1);
		// For taking Cell number we will have to use getCell method it also taken
		// cell number in which we will pass number of cell 		
		XSSFCell  cellObj= rowObj.getCell(3);
		System.out.println(cellObj);
	}

}
