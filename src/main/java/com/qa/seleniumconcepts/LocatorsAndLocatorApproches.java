package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsAndLocatorApproches {

	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//1 create the webElement and perform the action
		/**
		 * disadvantage of the this approch is if there are 200 elements or you need to use same element 200 times 
		 * then every time we need to write driver.findElement().sendkeys()
		 * so every time we hit the server
		 */
	//	driver.findElement(By.id("Form_submitForm_Name")).sendKeys("TestName");
	//	driver.findElement(By.id("Form_submitForm_Email")).sendKeys("Test@gmail.com");
		
		
		//2 creating the WebElement and then perform the actions
		
		/**
		 * with this approch we can maintain the webElement and then perform the action whenever is requried 
		 */
		
//		WebElement name = driver.findElement(By.id("Form_submitForm_Name"));
//		WebElement email = driver.findElement(By.id("Form_submitForm_Email"));
//		name.sendKeys("TestName");
//		email.sendKeys("Test@gmail.com");
		
		//3 By locator startegy
		/**
		 * we will maintain the locators and when we create the webelement we will use 
		 * By is the class in selenium
		 */
		
//		By name = By.id("Form_submitForm_Name");
//		WebElement nameele = driver.findElement(name);
//		nameele.sendKeys("TestName");
		
		//4 maintain the By locator and creating generic method to locate the WebElement
		
//		By name = By.id("Form_submitForm_Name");
//		getElement(name).sendKeys("TestEmail");
		
		
//		//5 cretaing the generic method with Action
//		By name = By.id("Form_submitForm_Name");
//		doSendkeys(name, "Test Name");
		
		//6 creating the seperate class ElementUtil

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
}
