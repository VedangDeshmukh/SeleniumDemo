package com.qa.seleniumconcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AleartHandeling {

	static WebDriver driver;
	public static void main(String[] args) {

		
		/**
		 * To handel the aleart in selenium we need to Swith to Alert by 
		 * driver.swithTo.alert(); it return the Alert class object
		 * 
		 * Methods:
		 * alt.getText();
		 * alt.accept()
		 * alt.dismiss();
		 * alt.sendKeys("hello");


		 * 
		 */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		By submit = By.name("submit");
		
		driver.findElement(submit).click();
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		//alt.accept();
		alt.dismiss();
		alt.sendKeys("hello");
	}

}
