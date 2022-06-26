package com.qa.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUpHandeling {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		String username = "Admin";
		String password = "Admin";
		
		driver.get("http://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");

	}

}
