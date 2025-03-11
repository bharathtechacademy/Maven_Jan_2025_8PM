package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedCssSelectors {
	
	// Syntax 4: ancestorTag > parentTag > childTag: nth-child(n)
	
	
	// ancestor : ul[class='leftmenu']
	// parent : li
	// target : a[href='services.htm']
	
	// ul[class='leftmenu'] > li:nth-child(3) > a[href='services.htm']

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
		
//		7. Locate google search box using 'cssSelector' locator -Syntax 4
		driver.findElement(By.cssSelector("ul[class='leftmenu'] > li:nth-child(3) > a[href='services.htm']"));

	}

}
