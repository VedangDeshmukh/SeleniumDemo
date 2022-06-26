package com.qa.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUplaod {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("");
		
		
		/**
		 * File uplaod we can handel with .sendKeys("path of the file");
		 * but type should be file
		 */
		
		
	}

}
