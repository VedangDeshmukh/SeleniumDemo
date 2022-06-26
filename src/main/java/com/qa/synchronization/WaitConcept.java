package com.qa.synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitConcept {

	
	static WebDriver driver;
	public static void main(String[] args) {

		/**
		 * There are two type of wait in selenium
		 * 1- Static wait : Thread.sleep(2000);
		 * it paus the execution 
		 * 
		 * 2- Dynamic wait
		 * it will wait for the till the time period is given , if element found earlier then rest of time will ignore
		 * 
		 * A- Implicite Wait :
		 * - it applied to all the webElement it is a global wait 
		 * - it can not applied to non webelement (url,title,aleart,frame) only on wevbelement
		 * 
		 * driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		 * 
		 * B- Explite wait:
		 * - it is a custom wait and can be applied to the WebElement and non-WebEelement
		 * 
		 * WebDriverWait
		 * FluentWait
		 * 
		 * 
		 * WebDriverWait(c) extends FluentWait (c) implements Wait[I]
		 * 
		 */
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.id("Form_submitForm_Name"));
		driver.findElement(By.id("Form_submitForm_Email"));
		
	}

}
