package com.sd.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.framework.factory.BrowserFactory;
import com.sd.dataprovider.ConfigReader;


public class Base {

	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
  
		System.out.println("LOG:INFO - Starting Browser - Running Before Method ");

		driver=BrowserFactory.startBrowser(ConfigReader.getProperty("browserName"), ConfigReader.getProperty("appURLQA"));
    		
		System.out.println("LOG:INFO - Browser and Application up and running ");
		
		System.out.println("Browser details");

	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("LOG:INFO - Closing Browser - Running After Method");
		
		BrowserFactory.closeBrowser(driver);
		
		System.out.println("LOG:INFO - Session Closed");
	}
	
	
}
