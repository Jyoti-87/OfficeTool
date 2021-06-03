package com.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonBookBuyTest {

	WebDriver driver;
	Select drpCategory;
	WebElement searchbox;
	WebElement searchclick;
	WebElement kindlelink;
	WebElement buybutton;
	WebElement ele5;
	WebElement createacc;
	WebElement customername;
	WebElement customeremail;
	WebElement password;
	WebElement repassword;
	WebElement submit;
	WebElement signin;
	WebElement createmazonenewacc;
	String currentHandle;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D://webdrivers//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https:www.amazon.co.uk");
	}

	@Test (priority =1)
	public void searchBook() throws InterruptedException {
		// Accept the pop up for cookies
		driver.findElement(By.id("sp-cc-accept")).click();

		// Click on drop-down
		driver.findElement(By.id("searchDropdownBox")).click();

		// To select the category
		drpCategory = new Select(driver.findElement(By.id("searchDropdownBox")));
		drpCategory.selectByValue("search-alias=stripbooks");

// Search book.
		searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.clear();
		searchbox.sendKeys("harry potter and the philosophers stone book");
		searchclick = driver.findElement(By.id("nav-search-submit-button"));
		searchclick.submit();}

// Check Kindle Edition
	@Test(dependsOnMethods="searchBook") 
	public void checkKindleformat() {
		String bookformat = "Kindle Edition";
		
// getPageSource() to get page source
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		if (driver.getPageSource().contains("Kindle Edition")) {

			kindlelink = driver.findElement(By.xpath(
					".//div/following-sibling::div/div/a[contains(@class, 'a-size-base a-link-normal a-text-bold') and .//text() ='Kindle Edition']"));
			kindlelink.click();
			System.out.println("Text: " + bookformat + " is present. ");
		} else {
			System.out.println("Text: " + bookformat + " is not present. ");
		}

		buybutton = driver.findElement(By.id("one-click-button"));
		buybutton.click();
		createacc = driver.findElement(By.id("createAccountSubmit"));
		createacc.click();}
//
// Verify all elements on sign up page
	
	    @Test(dependsOnMethods="checkKindleformat")
	    public void verifyAllElements() {
		customername = driver.findElement(By.xpath("//input[@name='customerName']//parent::div/label"));
		System.out.println(customername.isDisplayed());

		customeremail = driver.findElement(By.xpath("//input[@name='email']//parent::div/label"));
		System.out.println(customeremail.isDisplayed());

		password = driver.findElement(By.xpath("//input[@name='password']//parent::div/label"));
		System.out.println(password.isDisplayed());

		repassword = driver.findElement(By.xpath("//input[@name='passwordCheck']//parent::div/label"));
		System.out.println(repassword.isDisplayed());

		submit = driver.findElement(By.id("continue"));
		System.out.println(submit.isEnabled());
	    }

// sign up page with all correct details
	    
	    @Test(dependsOnMethods="verifyAllElements")
	    public void correctUserdetails() {
		customername = driver.findElement(By.id("ap_customer_name"));
		customername.click();
		customername.clear();
		customername.sendKeys("Amazonuser");

		customeremail = driver.findElement(By.id("ap_email"));
		customeremail.click();
		customeremail.clear();
		customeremail.sendKeys("nyoamazonacc@gmail.com");

		password = driver.findElement(By.id("ap_password"));
		password.click();
		password.clear();
		password.sendKeys("nyosaa26");

		repassword = driver.findElement(By.id("ap_password_check"));
		repassword.click();
		repassword.clear();
		repassword.sendKeys("nyosaa26");

		submit = driver.findElement(By.id("continue"));
		submit.click();
		

		// Set <String> allWindows = driver.getWindowHandles();
		//
		// for(String handle : allWindows)
		// {
		// driver.switchTo().window(handle);
		// }
		// String expectedURL = "https://www.amazon.co.uk/ap/register";
		// String actualURL = driver.getCurrentUrl();
		// System.out.println(actualURL);
		// Assert.assertEquals(actualURL, expectedURL);

		signin = driver.findElement(By.xpath("//div/a[contains(text(), 'Sign-In')]"));
		signin.click();

// Click on create amazon
		createmazonenewacc = driver.findElement(By.xpath("//span[@id='auth-create-account-link']"));
		createmazonenewacc.click();

	    }
// Registration without providing Name field
	    @Test(dependsOnMethods="correctUserdetails")
	    public void emptyCustomerName(){
		customername = driver.findElement(By.id("ap_customer_name"));
		customername.click();
		customername.clear();
		customername.sendKeys("");

		customeremail = driver.findElement(By.id("ap_email"));
		customeremail.click();
		customeremail.clear();
		customeremail.sendKeys("nyoamazonacc@gmail.com");

		password = driver.findElement(By.id("ap_password"));
		password.click();
		password.clear();
		password.sendKeys("nyosaa26");

		repassword = driver.findElement(By.id("ap_password_check"));
		repassword.click();
		repassword.clear();
		repassword.sendKeys("nyosaa26");

		submit = driver.findElement(By.id("continue"));
		submit.click();

		String expectedErrorMsg = "Enter your name";

		WebElement exp = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		String actualErrorMsg = exp.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println(actualErrorMsg);
		driver.navigate().refresh();
	    }

// Registration without providing user email field
	    @Test(dependsOnMethods="emptyCustomerName")
	    public void emptyemail() {
		customername = driver.findElement(By.id("ap_customer_name"));
		customername.click();
		customername.clear();
		customername.sendKeys("Amazonuser");

		customeremail = driver.findElement(By.id("ap_email"));
		customeremail.click();
		customeremail.clear();
		customeremail.sendKeys("");

		password = driver.findElement(By.id("ap_password"));
		password.click();
		password.clear();
		password.sendKeys("nyosaa26");

		repassword = driver.findElement(By.id("ap_password_check"));
		repassword.click();
		repassword.clear();
		repassword.sendKeys("nyosaa26");

		submit = driver.findElement(By.id("continue"));
		submit.click();

		String expectedErrorMsg2 = "Enter your e-mail";
		WebElement exp2 = driver.findElement(
		By.xpath("//div[@id='auth-email-missing-alert']/div/div[contains(text(), 'Enter your e-mail')]"));
		String actualErrorMsg2 = exp2.getText();
		Assert.assertEquals(actualErrorMsg2, expectedErrorMsg2);
		System.out.println(actualErrorMsg2);
		driver.navigate().refresh();
	    }

	    // Registration with email id which already/invalid have account
	    @Test(dependsOnMethods="emptyemail")
	    public void invalidemail(){
		customername = driver.findElement(By.id("ap_customer_name"));
		customername.click();
		customername.clear();
		customername.sendKeys("Amazonuser");

		customeremail = driver.findElement(By.id("ap_email"));
		customeremail.click();
		customeremail.clear();
		customeremail.sendKeys("amazon@test.com");

		password = driver.findElement(By.id("ap_password"));
		password.click();
		password.clear();
		password.sendKeys("nyosaa26");

		repassword = driver.findElement(By.id("ap_password_check"));
		repassword.click();
		repassword.clear();
		repassword.sendKeys("nyosaa26");

		submit = driver.findElement(By.id("continue"));
		submit.click();

		String expectedErrorMsg3 = "E-mail address already in use";
		WebElement exp3 = driver.findElement(By.xpath("//div/h4[contains(text(), 'E-mail address already in use')]"));
		String actualErrorMsg3 = exp3.getText();
		Assert.assertEquals(actualErrorMsg3, expectedErrorMsg3);
		System.out.println(actualErrorMsg3);

		signin = driver.findElement(By.xpath("//div/a[contains(text(), 'Sign-In')]"));
		signin.click();
		
		// Click on create amazon
		createmazonenewacc = driver.findElement(By.xpath("//span[@id='auth-create-account-link']"));
		createmazonenewacc.click();
	    }
	    
// Registration without providing password field
	    
	    @Test(dependsOnMethods="invalidemail")
	    public void withoutPassword() {

		customername = driver.findElement(By.id("ap_customer_name"));
		customername.click();
		customername.clear();
		customername.sendKeys("Amazonuser");

		customeremail = driver.findElement(By.id("ap_email"));
		customeremail.click();
		customeremail.clear();
		customeremail.sendKeys("nyoamazonacc@gmail.com");

		password = driver.findElement(By.id("ap_password"));
		password.click();
		password.clear();
		password.sendKeys("");

		repassword = driver.findElement(By.id("ap_password_check"));
		repassword.click();
		repassword.clear();
		repassword.sendKeys("nyosaa26");

		submit = driver.findElement(By.id("continue"));
		submit.click();

		String expectedErrorMsg4 = "Enter your password";
		WebElement exp4 = driver.findElement(By.xpath("//div[contains(text(), 'Enter your password')]"));
		String actualErrorMsg4 = exp4.getText();
		Assert.assertEquals(actualErrorMsg4, expectedErrorMsg4);
		System.out.println(actualErrorMsg4);
		driver.navigate().refresh();
	    }

// Registration with invalid password
		@Test(dependsOnMethods="withoutPassword")
		public void invalidPassword() {
		customername = driver.findElement(By.id("ap_customer_name"));
		customername.click();
		customername.clear();
		customername.sendKeys("Amazonuser");

		customeremail = driver.findElement(By.id("ap_email"));
		customeremail.click();
		customeremail.clear();
		customeremail.sendKeys("amazon@test.com");

		password = driver.findElement(By.id("ap_password"));
		password.click();
		password.clear();
		password.sendKeys("nyosaa27");

		repassword = driver.findElement(By.id("ap_password_check"));
		repassword.click();
		repassword.clear();
		repassword.sendKeys("nyo26");

		submit = driver.findElement(By.id("continue"));
		submit.click();

		String expectedErrorMsg5 = "Passwords do not match";

		WebElement exp5 = driver.findElement(By.xpath("//div[@id='auth-password-mismatch-alert']/div"));
		String actualErrorMsg5 = exp5.getText();

		Assert.assertEquals(actualErrorMsg5, expectedErrorMsg5);
		System.out.println(actualErrorMsg5);

	}


 @AfterMethod
 public void tearDown()
 {
 driver.quit();
 }
}