package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorConcepts {
	
	// RelativeLocator.with(targetElementLocator).DIRECTION(referenceElementLocator)
	
	// above
	// below
	// toLeftOf
	// toRightOf
	// near

	public static void main(String[] args) {
		
//		1. Launch the Browser window (Browser = Chrome)    
		WebDriver driver = new ChromeDriver();
		
//		2. Minimize browser window     
		driver.manage().window().minimize();
		
//		3. Maximize to specific resolution(800X400) 
		driver.manage().window().setSize(new Dimension(800,400));
		
//		4. Maximize the browser window  
		driver.manage().window().maximize();
		
//		5. Delete all browser cookies     
		driver.manage().deleteAllCookies();
		
//		6. Enter URL and Launch the Application (https://www.google.co.in/)  
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
//		7. Locate Services using 'Relative' locator
		driver.findElement(RelativeLocator.with(By.linkText("Services")).above(By.xpath("//a[text()='Products']")));
		

	}

}
