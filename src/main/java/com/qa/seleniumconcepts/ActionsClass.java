package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

	static WebDriver driver;
	
	public static void main(String[] args) {

		
		/**
		 * selenium provide the Actions class to handel the user actions like 
		 * move to element, drag and drop , right click 
		 * Actions act = new Actions(driver);
		 */
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		
		driver.get("http://mrbool.com/");
		
		By source = By.xpath("(//span[@id='headermenudesktop']//li/a)[1]");
		
		By destination = By.linkText("COURSES");
		
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(source)).perform();
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		driver.findElement(destination).click();
//		
		
		twoLevelMenuHandeling(source, destination);
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement waitForVisisblityofElement(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void twoLevelMenuHandeling(By parentlocator, By childlocator) {
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentlocator)).perform();
		waitForVisisblityofElement(childlocator, 2).click();
	}
	
	
	public static void threeLevelMenuHandeling(By parentlocator, By childlocator , By subcchildlocator) {
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentlocator)).perform();
		act.moveToElement(getElement(childlocator)).perform();

		waitForVisisblityofElement(subcchildlocator, 2).click();
	}

}
