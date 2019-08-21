package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTittleTest {
	
	WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "E://SEL//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http:www.google.com");	
	}

	
	@Test  (priority =2,groups="Tittle") // Use assert to validate condition 
	public void googleTittleTest() 
	{
		String tittle= driver.getTitle();
		System.out.println(tittle);
		
		Assert.assertEquals(tittle, "Google", "tittle doen't match");
	}
	
	
	
	@Test ()
	public void googleLogoText()
	{
		boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
		
		Assert.assertTrue(b);
		Assert.assertEquals(true, b);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
