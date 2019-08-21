package com.excel.utility;

//Taught BY Mukesh Otwani

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File src = new File("E:\\SEL\\Workspace_Eclipse\\OfficeTool\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet1 = wb.getSheetAt(0);
		String data0 = Sheet1.getRow(1).getCell(0).getStringCellValue();
		
		System.out.println("dta from excel" + data0);
		wb.close();
		
		
		
		

	}

}
