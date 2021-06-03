package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AmazonSignUpTest {
//	To verify if the expected elements are available on the Sign Up page.
	
	
     WebDriver driver;
     WebElement customername;
     WebElement customeremail;
     WebElement password;
     WebElement repassword;
	
	@Test()
	public void verifyAllElementonSignUp() {
	 customername = driver.findElement(By.id("ap_customer_name"));
	 customername.isDisplayed();
	
	 customeremail = driver.findElement(By.id("ap_email"));
	 customeremail.isDisplayed();
	
	password = driver.findElement(By.id("ap_password"));
	password.isDisplayed();
	
	repassword = driver.findElement(By.id("ap_password_check"));
	repassword.isDisplayed();}

}



