package com.sd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * 
 * This class will store all the locaters and Methods for Product Page
 * 
 * 
 */
public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	private By firstProductName = By.xpath("(//div[@class='inventory_item_name '])[1]");
	private By firstProductPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
	private By addToCartButton = By.xpath("(//button[text() ='Add to cart'])[1]");
	private By goToCartButton = By.xpath("//span[@class='shopping_cart_badge']");
	
	public String storeProductName() 
	{
		String text=driver.findElement(firstProductName).getText();
		
		System.out.println("First Product Name is: "+firstProductName);
		
		return text;
		
	}
	public void storeProductPrice() {
		driver.findElement(firstProductPrice).getText();
		System.out.println("First Product Price is: "+firstProductPrice);
	}
	public void addToCart() {
		driver.findElement(addToCartButton).click();
		System.out.println("Product added successfully");
	}
	public void goToCart() {
		driver.findElement(goToCartButton).click();
	}
	
	

}
