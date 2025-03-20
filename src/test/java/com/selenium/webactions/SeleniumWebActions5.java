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

public class SeleniumWebActions5 {

	static WebDriver driver = null;

	public static void main(String[] args) {

		// 1. Launch browser window(Chrome)
		driver = new ChromeDriver();

		// 2. Maximize the browser window
		driver.manage().window().maximize();

		// 3. Delete all the cookies
		driver.manage().deleteAllCookies();

		// 4. Enter URL and Launch the application
		// (https://parabank.parasoft.com/parabank/index.htm)
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		// 5. Verify application title (ParaBank | Welcome | Online Banking)
		String actualTitle = driver.getTitle();
		String expTitle = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actualTitle, expTitle);

		// 6. Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
		Assert.assertTrue(logo.isDisplayed());
		takeElementScreenshot(logo,"logo.png");
		
		// 7. Verify application caption (Experience the difference)
		WebElement caption = driver.findElement(By.xpath("//p[@class='caption']"));
		String actualCaption =caption.getText();
		String expCaption = "Experience the difference";
		Assert.assertEquals(actualCaption, expCaption);
		
		// 8. Enter Invalid credentials in Username and Password textboxes
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		
		//clear textboxes
		username.clear();
		password.clear();
		
		//Type credentials
		username.sendKeys("Invalid Username");
		password.sendKeys("  ");
		
		// 9. Verify button label (LOG IN) and Click on Login Button
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		//Verify label
		String actualLabel = loginButton.getAttribute("value").toUpperCase();
		String expLabel = "LOG IN";
		Assert.assertEquals(actualLabel, expLabel);
		
		//Click on the login button
		loginButton.click();
		
		//wait for error message
		//Thread.sleep(5000);
		
		// 10. Verify error message is coming
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p[@class='error']"), 0));
		
		WebElement error = driver.findElement(By.xpath("//p[@class='error']"));
		Assert.assertTrue(error.isDisplayed());	
		takeWindowScreenshot(driver, "Window.png");

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
