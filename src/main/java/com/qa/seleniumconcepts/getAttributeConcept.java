package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getAttributeConcept {
	
	/**
	 * to the get the atribute of the webElement in selenium 
	 * driver.getAttribute("attribute name") method is available
	 */

	
	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
		By contact = By.id("Form_submitForm_Contact");
		
		String palceholder = driver.findElement(contact).getAttribute("placeholder");
		System.out.println("place holder is:"+palceholder);
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doGetAttributeValue(By locator , String attributename) {
		return getElement(locator).getAttribute(attributename);
	}

}
