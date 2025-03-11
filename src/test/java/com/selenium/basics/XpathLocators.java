package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocators {

	// Xpath ==> XML Path

	// Absolute Xpath ==> / (Child) ==> /html/body/div[1]/div[1]/a[2]/img (full Xpath starts from html ,till target element)
	// Relative Xpath ==> // along with relation ships

	/********** Basic Xpath (Level 1) *************/

	// Syntax 1 : //tagName [@Attribute='Attribute Value']
	// Syntax 2 : //tagName [text()='Text Value']
	
	/********** Level 2 - with contains & starts-with *************/
	// Syntax 3 : //tagName [contains(@Attribute,'Partial Attribute Value')]
	// Syntax 4 : //tagName [contains(text(),'Partial Text Value')]
	
	// Syntax 5 : //tagName [starts-with(@Attribute,'Partial Attribute Value')]
	// Syntax 6 : //tagName [starts-with(text(),'Partial Text Value')]
	
	/**********Level 3 - combine multiple attributes and text values using 'and' *************/
	// Syntax 7 : //tagName [@Attribute1='Attribute Value' and @Attribute2='Attribute Value' and text()='Text Value']
	
	/**********Level 4 - Advanced Xpath *************/
	// Syntax 8 : referenceElementXpath/relationship::targetElementXpath
	
	//child
	//parent
	//ancestor
	//following-sibling
	//preceding-sibling
	// / -> with in the family
	// following
	// preceding
	
	
	// sibling > parent > ancestor > ancestor's parent
	
	// ancestor : //ul[@class='leftmenu']
	// parent: //li
	//target : //a[text()='Services']
	
	//ul[@class='leftmenu']/child::li/child::a[text()='Services']	
	//ul[@class='leftmenu']//a[text()='Services']
	//li[text()='Solutions'] /following-sibling::li[2]/child::a[text()='Services']
	
	

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
		
//		7. Locate parabank logo using 'xpath' locator -Syntax 1
		driver.findElement(By.xpath("//img[@class='logo']"));
		
//		8. Locate parabank caption using 'xpath' locator -Syntax 2
		driver.findElement(By.xpath("//p[text()='Experience the difference']"));
		
//		7. Locate parabank logo using 'xpath' locator -Syntax 3
		driver.findElement(By.xpath("//img[starts-with(@src,'images/logo')]"));
		
//		8. Locate parabank caption using 'xpath' locator -Syntax 4
		driver.findElement(By.xpath("//p[starts-with(text(),'Experience')]"));
		
//		9. Locate parabank caption using 'xpath' locator -Syntax 7
		driver.findElement(By.xpath("//p[@class='caption' and text()='Experience the difference']"));
		
//		10. Locate Products in footer element using 'xpath' locator -Syntax 8
		driver.findElement(By.xpath("//div[@id='footerPanel']/child::ul/child::li/child::a[text()='Products']"));

	}

}
