package com.qa.seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Context click means Right click , contextClick() method is available
		 */

		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		
		
		By rightclick = By.xpath("//span[text()='right click me']");
		By options = By.xpath("//li[contains(@class,'context-menu-item context-menu-icon ')]");
		
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(rightclick)).perform();
		
		 List<WebElement> ele = driver.findElements(options);
		 
		 for(WebElement e : ele) {
			 if(e.getText().equals("Copy")) {
				 e.click();
				 break;
			 }
		 }
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void rightClickandSelect(By rightclicklocator ,By optionslocator, String value) {
		
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightclicklocator)).perform();
		
		 List<WebElement> ele= getElements(optionslocator);
		 System.out.println("size of elements:"+ele.size());
		 System.out.println("options are:");
		 
		 for(WebElement e : ele) {
			 System.out.println(e.getText());
			 
			 if(e.getText().equals(value)) {
				 e.click();
				 break;
			 }
		 }
	}

}
