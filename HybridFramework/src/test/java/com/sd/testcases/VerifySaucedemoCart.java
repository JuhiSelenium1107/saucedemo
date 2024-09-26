package com.sd.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sd.pages.CartPage;
import com.sd.pages.LoginPage;

public class VerifySaucedemoCart {
@Test
public void verifyValidLogin() {
		
		WebDriver driver = new ChromeDriver();
		
		CartPage cartpage = new CartPage(driver);
		cartpage.verifyAddedItem();
		//cartpage.OpenMenu();
	}
}
