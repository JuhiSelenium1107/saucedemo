package com.sd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * This class will store all the locaters and Methods for login page 
 */
public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	private By username = By.xpath("//input[@id='user-name']");

	private By password = By.xpath("//input[@id='password']");

	private By loginButton = By.xpath("//input[@id='login-button']");
	
	private By headerText=By.xpath("//div[text()='Swag Labs']");
	
	public void typeUsername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}

	public void typePassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void loginToApplication(String uname,String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
	
	public boolean landedToProductPage() 
	{
		String url=driver.getCurrentUrl();
		
		return url.contains("inventory.html");
		
	}
	
	public boolean isHeaderPresent() 
	{
		return driver.findElement(headerText).isDisplayed();
	
	}
}