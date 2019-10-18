package com.datadriven.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase {

	WebDriver driver = null;
	
	
	@Test  
	public void Login() throws IOException  
	{
		
	
		
		Properties prop = new Properties();
					
			FileInputStream fis = new FileInputStream("E:\\SEL\\Workspace_Eclipse\\OfficeTool\\src\\com\\datadriven\\test\\datadri.properties");
			prop.load(fis);
			
			System.out.println(prop.getProperty("username"));
					
			
			if(prop.getProperty("browser").equals("gecko"))
			{
				System.setProperty("webdriver.gecko.driver", "E:\\SEL\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
			else if (prop.getProperty("browser").equals("Chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", "E://SEL//driver//chromedriver.exe");
			driver = new ChromeDriver();
			}
			else {
				driver = new InternetExplorerDriver();
							
			}
			
			driver.get(prop.getProperty("url"));
			
			
			
	}
			

	
	
	
}
