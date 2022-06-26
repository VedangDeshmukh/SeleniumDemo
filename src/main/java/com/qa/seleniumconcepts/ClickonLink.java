package com.qa.seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickonLink {

	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		By linkloc = By.xpath("//div[@id='SIvCob']//a");
		
		List<WebElement> ele =  driver.findElements(linkloc);
		System.out.println("Size of elements:"+ele.size());
		System.out.println("links are:");
		
		for(WebElement e : ele) {
			String text= e.getText();
			System.out.println(text);
			
			if(text.equals("मराठी")) {
				e.click();
				break;
			}
		}
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void clickOnLink(By locator, String value) {

		List<WebElement> ele = getElements(locator);
		System.out.println("Size of elements:" + ele.size());
		System.out.println("links are:");

		for (WebElement e : ele) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
