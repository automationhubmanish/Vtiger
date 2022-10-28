package com.evs.vtiger.exceldata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExcelData {

	
	public int getColumnNumberByColumnName(Sheet sheetObj,String culumnName) {
		Row rowObj=sheetObj.getRow(0);
		int cellNumberObj =rowObj.getLastCellNum();
		for(int i=0;i<=cellNumberObj-1;i++) {
		Cell cellObj=rowObj.getCell(i);
		
		String cellData =cellObj.getStringCellValue();
		if(cellData.equalsIgnoreCase(culumnName)) {
			cellNumberObj=i;
			break;
		}
		
		}
		
		return cellNumberObj;
	}
	
	
	
}
