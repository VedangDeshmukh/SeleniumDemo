package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandeling {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		By username = By.name("username");
		By password = By.name("password");
		By login = By.xpath("//input[@type='submit']");
		
		driver.findElement(username).sendKeys("testuu12");
		driver.findElement(password).sendKeys("testuu12");
		driver.findElement(login).click();
		
		
		driver.switchTo().frame("mainpanel"); // name
		driver.switchTo().frame(0); // index
		//driver.switchTo().frame(null); // webelement
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("CONTACTS"))).perform();
		
	}

}
