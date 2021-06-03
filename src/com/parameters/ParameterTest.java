package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver;
	
	
	@Parameters({"browser","url","emailid"})
	@Test
	public void yahooLoginTest(String browsername, String urlname, String emailadd ) {
		
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D://webdrivers//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equals("gecko")) {
			System.setProperty("webdriver.gecko.driver", "D://webdrivers//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlname);
		driver.findElement(By.id("uh-signin")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(emailadd);;
		driver.findElement(By.id("login-signin")).click();
		
		
	}
	
	@Test (dataProvider = "getData")
	public void mobileSignCarLoan(String Username, String Password) {
		System.out.println("Mobiel Sign Out");
		System.out.println(Username);
		System.out.println(Password);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Laxmi";
	    data[0][1] = "Laxmi@33";
	    
	    data[1][0] = "Saanvi";
	    data[1][1] = "Saanvi@33";
	    
	    data[0][0] = "User";
	    data[0][1] = "User@33";
	    return data;
	    
		
		
	}
	
		
	}
	

