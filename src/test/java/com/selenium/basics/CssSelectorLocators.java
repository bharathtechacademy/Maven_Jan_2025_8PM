package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorLocators {
	
//	Syntax 1 : tagName#id
	
//	Syntax 2 : tagName.className
	
//	Syntax 3 : tagName[Attribute='attribute-value’]

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
		
//		7. Locate google search box using 'cssSelector' locator -Syntax 1
		driver.findElement(By.cssSelector("textarea#APjFqb"));
		
//		8. Locate google search box using 'cssSelector' locator -Syntax 2
		driver.findElement(By.cssSelector("textarea.gLFyf"));
		
//		9. Locate google search box using 'cssSelector' locator -Syntax 3
		driver.findElement(By.cssSelector("textarea[title='Search']"));

	}

}
