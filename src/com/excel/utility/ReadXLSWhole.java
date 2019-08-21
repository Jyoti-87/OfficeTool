package com.excel.utility;

//Taught BY Mukesh Otwani

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSWhole {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
				File src = new File("E:\\SEL\\Workspace_Eclipse\\OfficeTool\\src\\com\\testdata\\HalfEbayTestData.xlsx");
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet Sheet1 = wb.getSheetAt(0);
				
				int rowcount = Sheet1.getLastRowNum();
				
				System.out.println("Last number of row is" + rowcount+1);
				
				for (int i=0; i<=rowcount; i++) {
					
					String data0 = Sheet1.getRow(i).getCell(0).getStringCellValue();
					
					System.out.println("test data from excel is" + data0);
				}

	}

}
