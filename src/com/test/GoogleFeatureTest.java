package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleFeatureTest {
	
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
	
	
	@Test  (priority =2,groups="Tittle")
	public void googleTittleTest() 
	{
		String tittle= driver.getTitle();
		System.out.println(tittle);
		
	}
	
	@Test (priority =1,groups="Logo")
	public void googleLogoText()
	{
		boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
	}
	
	@Test  (priority =3,groups="LinkTest")
	public void mailLinkText()
	{
		boolean b = driver.findElement(By.linkText("mail")).isDisplayed();
	}
	
	@Test  (priority =4,groups="Test")
	public void test4()
	{
		System.out.println("Test4");
	}
	
	@Test (priority =5,groups="Test")
	public void test5()
	{
		System.out.println("Test5");
	}
	
	@Test (priority =6,groups="Test")
	public void test6()
	{
		System.out.println("Test6");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
