package com.framework.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sd.dataprovider.ConfigReader;

public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver startBrowser(String browser,String appURL)
	{
		System.out.println("LOG:INFO - Starting "+appURL+" "+ "On "+browser);
	
		if(ConfigReader.getProperty("cloud").equals("true"))
		{
			
			System.out.println("LOG:INFO - Starting Test On Grid");
			
			URL gridURL = null;
			
			try {
				
				String urlOfHub="http://"+ConfigReader.getProperty("gridHub")+":"+ConfigReader.getProperty("gridPort")+"/wd/hub";
				
				System.out.println("Grid URL "+urlOfHub);
				
				gridURL = new URL(urlOfHub);
				
			} catch (MalformedURLException e) 
			{
				System.out.println("LOG:INFO Could not connect to Selenium Grid "+e.getMessage());
				
			}
			
			if(browser.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions opt=new ChromeOptions();
				
				if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
				{
					System.out.println("LOG:INFO - Test is running in headless mode");
					
					opt.addArguments("--headless=new");
				}
				
				
				
				driver=new RemoteWebDriver(gridURL, opt);
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				FirefoxOptions opt=new FirefoxOptions();
				
				if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
				{
					System.out.println("LOG:INFO - Test is running in headless mode");
					
					opt.addArguments("--headless=new");
				}
				
				driver=new RemoteWebDriver(gridURL, opt);
			}
			else if(browser.equalsIgnoreCase("Edge"))
			{
				EdgeOptions opt=new EdgeOptions();
				
				if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
				{
					System.out.println("LOG:INFO - Test is running in headless mode");
					
					opt.addArguments("--headless=new");
				}
				
				driver=new RemoteWebDriver(gridURL, opt);
			}
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadWait"))));
			
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptWait"))));
			
			driver.manage().window().maximize();
			
			driver.get(appURL);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
			
		
			return driver;
		}else
		{
			if(browser.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions opt=new ChromeOptions();
				
				if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
				{
					System.out.println("LOG:INFO - Test is running in headless mode");
					
					opt.addArguments("--headless=new");
				}
				
				driver=new ChromeDriver(opt);
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				FirefoxOptions opt=new FirefoxOptions();
				
				if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
				{
					System.out.println("LOG:INFO - Test is running in headless mode");
					
					opt.addArguments("--headless=new");
				}
				
				driver=new FirefoxDriver(opt);
			}
			else if(browser.equalsIgnoreCase("Edge"))
			{
				EdgeOptions opt=new EdgeOptions();
				
				if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"))
				{
					System.out.println("LOG:INFO - Test is running in headless mode");
					
					opt.addArguments("--headless=new");
				}
				
				driver=new EdgeDriver(opt);
			}
		
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadWait"))));
			
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptWait"))));
			
			driver.manage().window().maximize();
			
			driver.get(appURL);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
			
			return driver;
		}
		
		
		
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
