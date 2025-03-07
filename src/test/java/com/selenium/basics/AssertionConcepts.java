package com.selenium.basics;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionConcepts {

	public static void main(String[] args) {
		// Hard Assertions ==> Assert  ==> will fail the test immediately ==> Static methods
		Assert.assertEquals("Barath", "Barath");
		Assert.assertNotEquals("Barath", "Sarath");
		Assert.assertTrue(5>4);
		Assert.assertFalse(5<4);
		Assert.assertNull(null);
		Assert.assertNotNull(123);
//		Assert.fail("Fail");
		
		
		// Soft Assertions ==> SoftAssert  ==> will record errors and fail at the end  ==> Non-Static methods
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Barath", "Sarath");
		softAssert.assertNotEquals("Barath", "Barath");
		softAssert.assertTrue(5<4);
		softAssert.assertFalse(5>4);
		softAssert.assertNull(123);
		softAssert.assertNotNull(null);
		softAssert.fail("Fail");
		softAssert.assertAll();
		System.out.println("Execution Completed");

	}

}
