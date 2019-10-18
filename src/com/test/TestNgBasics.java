package com.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgBasics {
	
/*
*
*	
*	
setup system property for chrome
launch browser 
login to app
enter url
Check google tittle
Logout from app
delete cookies
close browser
*/	
	
	
//	Pre Condition annotation --starting with @Before
	@BeforeSuite //1
	public void setUp() {
		System.out.println("setup system property for chrome");
	}

	@BeforeTest //2
	public void launchBrowse() {
		System.out.println("launch browser ");
	}	
		
	@BeforeClass //3
	public void signUp() {
		System.out.println("login to app");
	}
	
/*
 * @BeforeMethod
 * @Test-1
 * @AfterMethod
 * 
 * @BeforeMethod
 * @Test- 2
 * @AfterMethod
 * 
 */
	
	
	@BeforeMethod //4
	public void enterURL() {
		System.out.println("enter url");
	}
	
	@Test (dataProvider = "getdata")
	public void login(String username, String Password) 
	{
		System.out.println(username);
		System.out.println(Password);
	}
	
//	Test cases -- Starting with @test
	@Test //5
	public void googleTittleTest() {
		System.out.println("Check google tittle");
	}
	
	@Test
	public void serachElement()
	{
		System.out.println("search element");
	}
	
		
// Post Condition-- Starting with @After	
	@AfterMethod //6
	public void logOut() {
		System.out.println("Logout from app");
	}
	
	@AfterClass //7
	public void deleteAllCookies() {
		System.out.println("delete cookies");
	}
	
	
	@AfterTest //8
	public void closeBrowser() {
		System.out.println("close browser");
	}
	

	@AfterSuite
	public void generateTestReport() {
		System.out.println("generate report");
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "set1oneUserName";
		data[0][1] = "set1password";
		
		data[1][0] = "set2oneUserName";
		data[1][1] = "set2password";
		
		data[2][0] = "set3oneUserName";
		data[2][1] = "set3password";
		return data;
		
		
	}
	
	
	
}
