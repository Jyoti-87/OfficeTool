package com.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.datadriven.test.TestBase;

public class TestNgFeatures extends TestBase {
	
	@Test (groups= "Tittle")
	public void loginTest() throws IOException {
		Login();
		System.out.println("login test");
//		int i= 9/0;
	}

	@Test (dependsOnMethods="loginTest")
	public void HomePageTest() {
		System.out.println("HomePage test");
	}
	
	@Test (dependsOnMethods="loginTest")
	public void SearchPageTest() {
		System.out.println("login test");
	}
	
	@Test (dependsOnMethods="loginTest")
	public void RegisPageTest() {
		System.out.println("Regis test");
	}
}
