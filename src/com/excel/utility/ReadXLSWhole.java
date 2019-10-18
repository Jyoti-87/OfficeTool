package com.excel.utility;

//Taught BY Mukesh Otwani

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSWhole {
	
	String excelpath;
	
	public ReadXLSWhole(String excelpath){
		
		this.excelpath= excelpath;
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	
		
				File src = new File("E:\\SEL\\Workspace_Eclipse\\OfficeTool\\src\\com\\testdata\\HalfEbayTestData.xlsx");
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet Sheet1 = wb.getSheetAt(0);
				
				int row = Sheet1.getLastRowNum();
				System.out.println(row);
				
				int cell=Sheet1.getRow(row).getLastCellNum();
				
				System.out.println(cell);
				Object[][] array= new Object[row][cell];
				
				
				for (int i=1; i<=row; i++)
				{
			     for(int j=0;j<cell;j++)
					{
					CellType type=Sheet1.getRow(i).getCell(j).getCellType();
				     System.out.println(type);
				      if (type.name().equals("STRING"))
				        {
						array[i-1][j]=Sheet1.getRow(i).getCell(j).getStringCellValue();
						System.out.println(Sheet1.getRow(i).getCell(j).getStringCellValue());
						 }
//				         else if (type.name().equals("NUMERIC"))
//				         	{
//		                   array[i-1][j]=sheet.getRow(i).getCell(j).getNumericCellValue();
//					System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
//				}
				         else
			               {
				        	 array[i-1][j]=Sheet1.getRow(i).getCell(j).getRawValue();
			        	     System.out.println(Sheet1.getRow(i).getCell(j).getRawValue());
				              }
					}
				}
				
				
				
	}
}

			

//				
//				System.out.println("Last number of row is" + rowcount+1);
//				
//				for (int i=0; i<=rowcount; i++) {
//					
//					for (int j=0; i<cellcount; j++){
//						
//						CellType type=Sheet1.getRow(i).getCell(j).getCellType();
//					     System.out.println(type);
//					     
//					      if (type.name().equals("STRING"))
//					        {
//							array[i-1][j]=Sheet1.getRow(i).getCell(j).getStringCellValue();
//							System.out.println(Sheet1.getRow(i).getCell(j).getStringCellValue());
//						
//					}					
//					      else
//			               {
//				        	 array[i-1][j]=Sheet1.getRow(i).getCell(j).getRawValue();
//			        	     System.out.println(Sheet1.getRow(i).getCell(j).getRawValue());
//				              }
//				}
//
//	}
//
//}
