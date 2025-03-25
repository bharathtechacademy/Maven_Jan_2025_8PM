package com.framework.testng.concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppCommons extends WebCommons{
	
	@Test (groups= {"Regression"},invocationCount=10)
	public void TestCase1() {
	//	Assert.fail("Test Case 1 failed");
		System.out.println("Test Case 1 - Home Page Executed Successfully...");
	}
	
	@Test (priority=2,groups= {"Regression","Sanity"}, timeOut=2000)
	public void TestCase2() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Test Case 2 - Add Product to Cart Feature Executed Successfully...");
		
	}	

	@Test(dataProvider="testcase3", priority=-1,groups= {"Regression","Sanity","Smoke"},dependsOnMethods={"TestCase2","TestCase2"}, enabled=true)
	public void TestCase3(String username, String password) {
		System.out.println("Test Case 3 - Login Executed Successfully with..."+username+" ,"+password);
	}

}
