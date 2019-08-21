package mukesh.excel.confing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig
{

		FileInputStream fis;
		XSSFWorkbook wb;
		XSSFSheet Sheet1;
		
		
		public  ExcelConfig(String excelpath) {
			
		try {
			File src = new File(excelpath);
			 fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
			 
		}
		 catch (IOException e) {
			
			 System.out.println(e.getMessage());
		 
		}
		
		}
	
		public String getData(int SheetNumber, int row, int column)
		
		{
			
			Sheet1 = wb.getSheetAt(SheetNumber);
			String data = Sheet1.getRow(row).getCell(column).getStringCellValue();
			return data;
		}
		
	}


