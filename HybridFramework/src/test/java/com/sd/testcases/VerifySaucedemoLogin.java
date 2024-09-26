/**
 * 
 */
package com.sd.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sd.base.Base;
import com.sd.pages.LogOutPage;
import com.sd.pages.LoginPage;


/**
 * Login Test Cases
 */
public class VerifySaucedemoLogin extends Base {
	
	LoginPage login;
	
	LogOutPage logout;
	
	@Test
	public void verifyValidLogin() {
	
		login = new LoginPage(driver);
		
		login.typeUsername("standard_user");
		
		login.typePassword("secret_sauce");
		
		login.clickOnLoginButton();
		
		Assert.assertTrue(login.landedToProductPage());
		
	}
	
	@Test(dependsOnMethods = "verifyValidLogin")
	public void verifyLogout()
	{
		LogOutPage logout=new LogOutPage(driver);
		
		logout.logout();
		
		Assert.assertTrue(login.isHeaderPresent());
		
	}
}
