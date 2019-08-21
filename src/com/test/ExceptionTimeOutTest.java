package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	@Test(invocationTimeOut=2)// This key word used to terminate the programme with define time
	public void infintLoopTest() {
		int i =100;
		while (i==1) {
			System.out.println(i);
		}
	}
	
	@Test(expectedExceptions=NumberFormatException.class)// Handle exceptions
	public void test1() {
		String X = "100A";
		Integer.parseInt(X);
	}
}
