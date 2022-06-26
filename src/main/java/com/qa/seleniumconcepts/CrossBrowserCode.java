package com.qa.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserCode {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		launchBrowser();
		
		driver.get("https://www.google.com");

	}
	
	
	
	/**
	 * Cross Broswer code base on the browser name browser will launch
	 */
	public static void launchBrowser() {
		
		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equals("safari")) {
			driver = new SafariDriver();
		}else if ( browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid browser is passed please pass the correct browse:"+browser);
		}
	}
}
