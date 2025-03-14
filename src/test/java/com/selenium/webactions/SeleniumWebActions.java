package com.selenium.webactions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumWebActions {

	public static void main(String[] args) throws IOException {

//		1. Launch the Browser window (Browser = Chrome) 
		WebDriver driver = new ChromeDriver();

//		2. Maximize the browser window  
		driver.manage().window().maximize();

//		3. Delete all browser cookies 
		driver.manage().deleteAllCookies();

//		4. Enter URL and Launch the Application (https://www.google.co.in/)  
		driver.get("https://www.google.co.in/");
		
//		5. Locate the element
		WebElement element = driver.findElement(By.xpath("//element"));
		
		/********** Common WebElement Actions **********/
		
		// Check if the element is displayed on the page
		boolean isElementDisplayed = element.isDisplayed();
		
		// Check if the element is enabled on the page
		boolean isElementEnabled = element.isEnabled();	
		
		// Check if the element is selected
		boolean isElementSelected= element.isSelected();	
		
        /************* Regular Element Specific Actions *************/

        /********** Button Element **********/
		WebElement button = driver.findElement(By.xpath("//button"));
		
		// Get the label of the button
		String label1 = button.getText(); //it label is added as text value
		String label2 = button.getAttribute("value"); //if label is added as attribute value
		
		// Click on the button
		button.click(); //normal click
			
		
		// double click
		Actions action = new Actions(driver);
		action.doubleClick(button).perform();
		
		// Action click
		action.click(button).perform();
		
		// right click
		action.contextClick(button).perform();
		
		// move the mouse pointer towards button
		action.moveToElement(button).perform();
		
		// drag and drop 
		WebElement source = driver.findElement(By.xpath("//button"));
		WebElement target = driver.findElement(By.xpath("//button"));
		action.dragAndDrop(source, target).perform();
		
		// Click on the hidden element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", button);		
		
		// Scroll and Click on the hidden element when element is at the bottom of the page
		js.executeScript("arguments[0].scrollToElement()", button); //scroll
		js.executeScript("arguments[0].click()", button);//then click
		
		/********** Textbox Element **********/
		
		WebElement textbox = driver.findElement(By.xpath("//input"));
		
		// Clear the textbox
		textbox.clear();
		
		// Enter text into the textbox
		textbox.sendKeys("Text Value"); // normal way of typing the text
		
		// Enter text using Actions class to type chars 
		action.sendKeys(textbox, "Text").perform();
		action.sendKeys(textbox, "Text"+Keys.ENTER).perform();
		
		// Type text in disabled textbox /hidden textbox
		js.executeScript("arguments[0].value='text'", textbox);//then click
		
		/********** Dropdown Element **********/
		WebElement dropdown = driver.findElement(By.xpath("//select"));
		
		Select s = new Select(dropdown);
		
		// Get all options available in the dropdown
		List<WebElement> options = s.getOptions();
		for(WebElement option : options) {
			System.out.println(option.getText());
		}
		
		// Select options from a dropdown
		s.selectByVisibleText("Audi");
		s.selectByValue("audi");
		s.selectByIndex(3);
		
		// Verify the selected option
		WebElement selectedOption = s.getFirstSelectedOption();
		String selectedOptionValue = selectedOption.getText();
		
		// Verify whether dropdown is multi-select dropdown
		boolean isMultiSelection = s.isMultiple();
		
		// Select and de-select options
		s.selectByVisibleText("Audi");
		s.selectByValue("audi");
		s.selectByIndex(3);
		
		s.deselectByVisibleText("Audi");
		s.deselectByValue("audi");
		s.deselectByIndex(3);
		
		/********** Checkbox Element **********/
		
		// select the checkbox if it is not selected already
		WebElement checkbox = driver.findElement(By.xpath("//input"));
		
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
		
		/********** Radio Button Element **********/
		
		// Select the radio button
		WebElement radioButton = driver.findElement(By.xpath("//input"));
		radioButton.click();
		
		/********** Text Element / Label  **********/
		//get the text values from web element
		WebElement label = driver.findElement(By.xpath("//input"));
		String labelText1 = label.getText(); //it label is added as text value
		String labelText2 = label.getAttribute("value"); //if label is added as attribute value
		
		/********** Hyperlink Element **********/
		WebElement hyperLink = driver.findElement(By.xpath("//a"));
		
		 // Verify the URL in the hyperlink using href value
		String link = hyperLink.getAttribute("href");
		
		// Verify the URL in the hyperlink by clicking on the link and check the updated url 
		hyperLink.click();
		String updatedUrl = driver.getCurrentUrl();
		
		/********** Image Element **********/
		WebElement image = driver.findElement(By.xpath("//img"));
		
		// Verify if the image element is displayed
		boolean isImageDisplayed = image.isDisplayed();
		
		// Verify image is valid
		String imageSource = image.getAttribute("src");
		
		// Verify the image dimensions
		int imageWidth = image.getSize().getWidth();
		int imageHeight = image.getSize().getHeight();
		
		// Get the position of the image
		Point imagePosition = element.getLocation();
		int x = imagePosition.getX();
		int y = imagePosition.getY();
		
		// verify a specific pixel color
		int colorCode = ImageIO.read(new File(imageSource)).getRGB(x, y);
		
		/********** Alerts **********/
		Alert alert = driver.switchTo().alert();
		
		// click on ok
		alert.accept();
		
		//click on the cancel
		alert.dismiss();
		
		//copy text from alert
		alert.getText();
		
		//type text in alert
		alert.sendKeys("Text");
		
		/********** Frames **********/
		
		// switch from main window to frame
		driver.switchTo().frame(0); //index
		driver.switchTo().frame("frame1");//by using id or name
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='frame1Wrapper']/child::iframe"))); // by using webelemnt
		
	}

}
