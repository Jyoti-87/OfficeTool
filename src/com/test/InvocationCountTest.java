package com.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@BeforeSuite
	public void checkSuit() {
		System.out.println("I am starting of suit");
	}
	
	@Test (invocationCount =10)
	public void sum() {
		int i = 30;
		int j = 30; 
		int c = i+j;
		
		System.out.println("Sum is ==" + c);
	}
	
	@AfterSuite
	public void checkSuitEnd() {
		System.out.println("I am Ending of suit");
	}

}
