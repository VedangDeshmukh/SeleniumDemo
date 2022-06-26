package com.qa.seleniumconcepts;

import org.openqa.selenium.WebDriver;

public class GoogleTest {

	static WebDriver driver;
	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		driver =br.intBrowser("chrome");
		br.launchUrl("https://www.google.com");
		
		System.out.println(br.getPageTitle());
		System.out.println(br.getPageUrl());
		System.out.println("=====================================");

		//System.out.println(br.getPageSource());
		
	//	br.closeBrowser();

	}

}
