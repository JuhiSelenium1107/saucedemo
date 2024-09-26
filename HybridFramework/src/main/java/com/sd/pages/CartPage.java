package com.sd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * 
 * This class will store all the locaters and Methods for cart page
 * 
 * 
 */
public class CartPage{
	WebDriver driver;

	public CartPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	private By firstProductName = By.xpath("(//div[@class='inventory_item_name '])[1]");
	private By addedItem = By.xpath("//div[text()='Sauce Labs Backpack']");
	
	
	public void verifyAddedItem() {
		driver.findElement(addedItem).getText();
		if(addedItem.equals(firstProductName)) {
			System.out.println("Added Item is available in the cart:  "+ addedItem );
		}
		else {
			System.out.println("Wrong Product:  "+ addedItem );
		}
	}
	
}
