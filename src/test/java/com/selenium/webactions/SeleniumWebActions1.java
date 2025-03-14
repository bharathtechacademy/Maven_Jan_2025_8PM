package com.selenium.webactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumWebActions1 {

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

		// 5. Verify application title (ParaBank | Welcome | Online Banking)
		String actualTitle = driver.getTitle();
		String expTitle = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actualTitle, expTitle);

		// 6. Verify application logo
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
		Assert.assertTrue(logo.isDisplayed());
		
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
		
		// 11. Click on Admin page link
		// 12. Wait for admin page
		// 13. Select Data access mode as ' SOAP'
		// 14. Scroll-down till Loan provider
		// 15. Select Loan provider as 'Web Service'
		// 16. Click on Submit button
		// 17. wait for Successful submission message
		// 18. Click on Services Link
		// 19. Wait for Services page
		// 20. Scroll-down till Bookstore services
		// 21. Get total rows, columns in the bookstore service table
		// 22. Get Column headers of book store services table
		// 23. Get all the data from book store service table
		// 24. Close browser window

	}

}
