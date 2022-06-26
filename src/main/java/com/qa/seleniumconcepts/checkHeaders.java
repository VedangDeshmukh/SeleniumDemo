package com.qa.seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkHeaders {

	
	static WebDriver driver;
	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By headers = By.xpath("//li[@class='main-list']/a");
		
		ElementUtil el = new ElementUtil(driver);
		
		List<WebElement> ele = el.getElements(headers);
		
		for(WebElement e : ele) {
			e.isDisplayed();
		}
	}

}
