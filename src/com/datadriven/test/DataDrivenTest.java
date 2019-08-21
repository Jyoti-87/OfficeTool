package com.datadriven.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.ExcelReader;
import com.excel.utility.Read_XLS;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E://SEL//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		Read_XLS Reader = new Read_XLS("E://SEL//Workspace_Eclipse//OfficeTool//src//com//testdata//HalfEbayTestData.xlsx");
		
		
	
		
		

	}

}
