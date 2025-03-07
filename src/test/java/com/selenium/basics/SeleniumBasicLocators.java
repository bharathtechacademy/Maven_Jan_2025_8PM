package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicLocators {
	
//	1. id  ==> id attribute value
//	2. name ==> name attribute value
//	3. className ==> class attribute value
//	4. tagName ==> Html Tag 
	
//	5. linkText ==> Text value of hyperlink element
//	6. partialLinkText ==> Partial text value of hyperlink element

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
		driver.get("https://www.google.co.in/");
		
//		7. Locate google search box using 'id' locator
		By loc = By.id("APjFqb");		
		WebElement element =driver.findElement(By.id("APjFqb"));
		
//		8. Locate google search box using 'name' locator
		driver.findElement(By.name("q"));
		
//		9. Locate google search box using 'className' locator
		driver.findElement(By.className("gLFyf"));
		
//		10. Locate google search box using 'tagName' locator
		driver.findElement(By.tagName("textarea"));
		
//		11. Locate 'How Search Works' using 'linkText' locator
		driver.findElement(By.linkText(" How Search works "));
		
//		11. Locate 'How Search Works' using 'partialLinkText' locator
		driver.findElement(By.partialLinkText("How Search"));

	}

}
