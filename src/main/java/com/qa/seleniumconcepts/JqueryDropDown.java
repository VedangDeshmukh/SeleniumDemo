package com.qa.seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDown {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		
		/**
		 * Jquery Dropdown are handel by the 
		 * get the list of WebElent of dropdown options iterate the list matvh and select the value
		 */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		
		driver.findElement(By.id("justAnInputBox")).click();
		
		By options = By.xpath("//span[@class ='comboTreeItemTitle']");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<WebElement> ele= driver.findElements(By.xpath("//span[@class ='comboTreeItemTitle']"));
//		
//		for(WebElement e: ele) {
//			if(e.getText().equals("choice 3")) {
//				e.click();
//				break;
//			}
//		}
		
		//selectChoice(options, "choice 3","choice 4","choice 7");
		selectChoice(options, "all");
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void selectChoice(By locator, String... value) {

		List<WebElement> ele = getElements(locator);
		System.out.println("size of elements:" + ele.size());
		System.out.println("dropdown options are:");

		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement e : ele) {
				String text = e.getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						e.click();
						break;
					}
				}
			}
		} else {
			for (WebElement e : ele) {
				System.out.println(e.getText());
				// all selection logic
				try {
					e.click();
				} catch (Exception ee) {
				}
			}
		}
	}

}
