package com.qa.seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionList {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		By google = By.name("q");
		By options = By.xpath("//ul[@class='G43f7e']/li//div[@class='wM6W7d']/span");
		
		driver.findElement(google).sendKeys("australia");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selectValue(options, "australia time");
	}
	
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void selectValue(By locator, String value) {
		
			List<WebElement> ele= getElements(locator);
			System.out.println("size of elements:"+ele.size());
			
			for(WebElement e : ele) {
				if(e.getText().equals(value)) {
					e.click();
					break;
				}
			}
	}

}	
	

