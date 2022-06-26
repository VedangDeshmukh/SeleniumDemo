package com.qa.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	
	static WebDriver driver;
	public static void main(String[] args) {

		
		/**
		 * whenever we perform the move than one action we need build and then perform
		 * 
		 */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("");
		
		Actions act = new Actions(driver);
		act.clickAndHold(null).
		moveToElement(null).
		release(null).build().perform();
	}

}
