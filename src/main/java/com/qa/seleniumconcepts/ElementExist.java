package com.qa.seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementExist {

	static WebDriver driver;
	
	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		By mobile = By.linkText("Mobiles");
		isElementExist(mobile);

	}

	
	public  static List<WebElement> getEleWebElements(By locator){
		return driver.findElements(locator);
	}
	
	public static Boolean isElementExist(By locator) {

		List<WebElement> ele = getEleWebElements(locator);
		System.out.println("size of the elements:" + ele.size());

		if (ele.size() > 0) {
			System.out.println("element is availabel and displayed");
			return true;
		} else {
			System.out.println("element is not availabel and displayed");
			return false;
		}

	}
	
	
}
