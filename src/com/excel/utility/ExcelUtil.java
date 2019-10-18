package com.excel.utility;


	import java.io.FileInputStream;
import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	// taught by Raghav PAl
	
	public class ExcelUtil {

		
	public static void main(String[] args) {
		
		getRowCount();
		
	}
		public static void getRowCount() {
			
			try {
				
				FileInputStream fis= new FileInputStream("E:\\SEL\\Workspace_Eclipse\\OfficeTool\\src\\com\\testdata\\HalfEbayTestData.xlsx");
				
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet Sheet = wb.getSheet("RegTestData");
//				int rowcount1 = Sheet.getLastRowNum(); //does the same function as belowone.
				int rowcount= Sheet.getPhysicalNumberOfRows();// It gives direct last number of sheet.
				System.out.println("Count the row is:" + rowcount);
				
			} catch (IOException exp) {
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				exp.printStackTrace();
			}
			
			
				}

	}



