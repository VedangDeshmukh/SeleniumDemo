package com.qa.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasic {

	public static void main(String[] args) {
		
		
		/*
		 * it should be the firt line of the code , this line start the selenium server 
		 * System is the class in java and setProperty is the mathod it is a static mentod
		 * need to the pas the key and value 
		 * key:
		 * - if chorme = webdriver.chrome.driver
		 * - if firefox = webdriver.gecko.driver
		 * - if edge = webdriver.ie.driver.
		 * - if safari not requried 
		 * 
		 * path : path the driver , for windows need to pass file name .exe ex: //chromedriver.exe at the last
		 */
//		System.setProperty("webdriver.chrome.driver", "path");
		
		WebDriverManager.chromedriver().setup();
		
		
		/*
		 * This line launch the Browser 
		 * if wanted to launch the firefox : new FireFoxDriver()
		 * if wanted to launch the safari : new SafariDriver();
		 * if wanted to launch the edge  : new EgdeDriver();
		 * 
		 * WebDriver is the Interface and ChromeDriver is the calss
		 * This is the java top casting concept child class object refer but the parent interface referance varibale.
		 * driver is the ref variable and new ChromeDriver() is the object 
		 * WebDriver is the child Interface of the Search Context Interface which extend the (search context) interface
		 * ChromeDriver is the child class of the Remote Webdriver class which extend the (RMD) class
		 */
		WebDriver driver = new ChromeDriver();
		
		/**
		 * method to lauch the url of the application , it launch the application url 
		 * prtotype(http:// or https://) is mandatory other wise it will give the "invalid argument" exception
		 * domain name is not mandatory
		 */
		driver.get("https://www.google.com");
		
		/**
		 * method to get the title of the webpage
		 * return type is String
		 */
		String titile =driver.getTitle();
		System.out.println("Title of the page is:"+titile);
		
		//Validation
		if(titile.equals("Google")) {
			System.out.println("Test Case Pass");
		}else {
			System.out.println("Test Case Fail");
		}
		
		
		/**
		 * get the url of the current webpage
		 */
		String url =driver.getCurrentUrl();
		System.out.println("Url of the page is :"+url);
		
		/**
		 * get the complete page source of the page
		 */
		System.out.println(driver.getPageSource());
		
		/**
		 * to close the browser we have two methods 
		 */
	
		//driver.close();
		driver.quit();

	}

}
