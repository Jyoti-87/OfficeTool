package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {
	
	@Test
	public void loginTest() {
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
