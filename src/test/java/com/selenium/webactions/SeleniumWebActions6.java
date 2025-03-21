package com.selenium.webactions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SeleniumWebActions6 {
	
	static ExtentHtmlReporter html = null; //white paper	
	static ExtentReports extent = null; // printer
	static ExtentTest logger = null; // ink

	static WebDriver driver = null;

	public static void main(String[] args) throws IOException {
		
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationTestReport.html"); //empty html report
		extent = new ExtentReports();
		extent.attachReporter(html); //attach empty report into extent reports class to print
		
		//start the printing process for specific test case
		logger = extent.createTest("Verify Application Logo And Caption");

		// 1. Launch browser window(Chrome)
		driver = new ChromeDriver();

		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();

		// 4. Enter URL and Launch the application
		// (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		logger.info("Application Launched Successfully");

		// 5. Verify application title (ParaBank | Welcome | Online Banking)
		String actualTitle = driver.getTitle();
		String expTitle = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actualTitle, expTitle);
		logger.info("Application title is matching");

		// 6. Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
		Assert.assertTrue(logo.isDisplayed());
		logger.pass("Application logo displayed Successfully");
		logger.addScreenCaptureFromPath(takeElementScreenshot(logo,"logo.png"));		
		
		// 7. Verify application caption (Experience the difference)
		WebElement caption = driver.findElement(By.xpath("//p[@class='caption']"));
		String actualCaption =caption.getText();
		String expCaption = "Experience the difference";
		Assert.assertEquals(actualCaption, expCaption);
		logger.pass("Application caption displayed Successfully");
		
		//stop printing for test case 1
		extent.flush();
		
		
		//start printing  for test case 2
		logger = extent.createTest("Verify Application Login");
		
		// 8. Enter Invalid credentials in Username and Password textboxes
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		
		//clear textboxes
		username.clear();
		password.clear();
		
		//Type credentials
		username.sendKeys("Invalid Username");
		password.sendKeys("  ");
		logger.info("User credentials are updated");
		
		// 9. Verify button label (LOG IN) and Click on Login Button
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		//Verify label
		String actualLabel = loginButton.getAttribute("value").toUpperCase();
		String expLabel = "LOG IN";
		Assert.assertEquals(actualLabel, expLabel);
		
		//Click on the login button
		loginButton.click();
		logger.info("Clicked on the login button");
		
		//wait for error message
		//Thread.sleep(5000);
		
		// 10. Verify error message is coming
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));
		
		WebElement error = driver.findElement(By.xpath("//p[@class='error']"));		
		Assert.assertTrue(error.isDisplayed());	
		logger.error("Login is failed");
		logger.addScreenCaptureFromPath(takeWindowScreenshot(driver, "Window.png"));
		
		//stop printing for test case 2
		extent.flush();		

	}
	
	//capture window screenshot
	public static String takeWindowScreenshot(WebDriver driver , String nameAndFormat ) {
		String filePath = System.getProperty("user.dir")+"\\Screenshots\\"+nameAndFormat;
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return filePath;
	}
	
	//capture element screenshot
	public static String takeElementScreenshot(WebElement element , String nameAndFormat ) {
		String filePath = System.getProperty("user.dir")+"\\Screenshots\\"+nameAndFormat;
		File screenshot =element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return filePath;
	}


}
