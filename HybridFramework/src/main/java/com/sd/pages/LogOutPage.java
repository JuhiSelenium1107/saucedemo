package com.sd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * 
 * This class will store all the locaters and Methods for login page
 * 
 */
public class LogOutPage {

	WebDriver driver;

	public LogOutPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	private By openLogOutOption = By.xpath("//button[text()='Open Menu']");
	private By logOutButton = By.xpath("//a[text()='Logout']");
	
	public void logout() 
	{
		driver.findElement(openLogOutOption).click();
		driver.findElement(logOutButton).click();
		
	}
}
