package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickandSendKeys {

	
	static WebDriver driver;
	public static void main(String[] args) {

		/**
		 * Actions click and sendkeys we use when one element is overlap with Another webElement
		 */
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator , String value) {
		
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value);
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator));
	}

}
