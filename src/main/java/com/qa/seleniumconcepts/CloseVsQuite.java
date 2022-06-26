package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseVsQuite {
	
	static WebDriver driver;

	public static void main(String[] args) {

		/**
		 * close and quite both are use to close the browser
		 * driver.close - close the current browser 
		 * driver.quite() - close the all open browser
		 * 
		 * differance is also in case of Session ID 
		 * session id is geneated when driver = new ChromeDriver(); line is executed 
		 * 
		 * In case of Close - NoSuchSessionID session id ,invalid session id Exception we will get
		 * In case of Quite - NoSuchSessionId session id ,session id is null Exception we will get
		 */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		System.out.println("title of the page:"+driver.getTitle());
		System.out.println("url of the page :"+driver.getCurrentUrl());
		
		driver.get("https://www.amazon.in");
		
		driver.close();
	//	driver.quit();
		
		//driver.findElement(By.name("btnK"));
	}

}
