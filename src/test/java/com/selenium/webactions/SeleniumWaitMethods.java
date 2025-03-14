package com.selenium.webactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitMethods {
	
	
	// Implicit Wait  ==> 5 sec  ==> A global wait that applies to all elements.
	// Explicit Wait ==> Wait for a specific element based on certain conditions along with wait time ==>  wait for max 5 sec or wait for spec. condition
	// Fluent Wait ==> A more flexible wait that polls for an element at regular intervals. ==> wait for max 10 sec or wait for spec. condition along with spec. intervals 2 sec

	public static void main(String[] args) {
		
		
		// 1. Launch browser window(Chrome)
		WebDriver driver = new ChromeDriver();

		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();

		// 4. Enter URL and Launch the application
		// (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		// Implicit Wait  ==> 5 sec  ==> A global wait that applies to all elements.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //No Such Element 
		
		// Explicit Wait ==> Wait for a specific element based on certain conditions along with wait time ==>  wait for max 5 sec or wait for spec. condition
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0)); // Timeout
		
		// Fluent Wait ==> A more flexible wait that polls for an element at regular intervals. ==> wait for max 10 sec or wait for spec. condition along with spec. intervals 2 sec
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
		fluentWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0)); // Timeout

	}

}
