package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver;
	
	@Test
	@Parameters({"browser","url","emailid"})
	public void yahooLoginTest(String browser, String url, String emailid ) {
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E://SEL//driver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equals("gecko")) {
			System.setProperty("webdriver.gecko.driver", "E:\\SEL\\driver\\geckodriver.exe");
			driver = new ChromeDriver();
		}
		
		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("uh-signin")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(emailid);;
		driver.findElement(By.id("login-signin")).click();
	}

	private void elseif(boolean equals) {
		// TODO Auto-generated method stub
		
	}
	
}
