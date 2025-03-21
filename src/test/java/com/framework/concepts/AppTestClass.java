package com.framework.concepts;

public class AppTestClass {

	public static void main(String[] args) {
		
		WebCommons commons = new WebCommons();
		AppCommons app = new AppCommons();
		
		commons.startReporting();		
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in/");
		app.TestCase1();
		commons.closeBrowser();
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in/");
		app.TestCase2();
		commons.closeBrowser();
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in/");
		app.TestCase3("Bharath","Bharath123");
		commons.closeBrowser();
		
		commons.launchBrowserAndApplication("Chrome", "https://www.amazon.in/");
		app.TestCase3("sfjbjw324729","jh#%&^$%");
		commons.closeBrowser();
		
		commons.stopReporting();

	}

}
