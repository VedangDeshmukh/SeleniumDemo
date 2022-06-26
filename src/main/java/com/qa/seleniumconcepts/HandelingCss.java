package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandelingCss {

	static WebDriver driver;
	
	public static final Color WHITE = Color.fromString("white");
	private static final Color GREEN = Color.fromString("green");
	
	private static final Color YELLOW = Color.fromString("yellow");
	private static final Color BLACK = Color.fromString("black");



	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		
		By btn = By.xpath("//a[text()='Contact Sales']");
		By text = By.xpath("//h3[text()='See OrangeHRM in Action']");
		
		By link = By.id("nav-search-submit-button");
		
//		 String color= driver.findElement(btn).getCssValue("color");
//		 System.out.println(color);
//		 
//		 Color btncolor =  Color.fromString(driver.findElement(btn).getCssValue("color"));
//		 
//		 System.out.println("Btn color:"+btncolor);
//		 if(btncolor.equals(WHITE)) {
//			 System.out.println("Test Cases is pass");
//		 }else {
//			 System.out.println("Test Case is fail");
//		 }
//		 
//		 
//		Color bgcolor = Color.fromString(driver.findElement(btn).getCssValue("background-color"));
//		if(bgcolor.equals(GREEN)) {
//			 System.out.println("Test Cases is pass");
//		 }else {
//			 System.out.println("Test Case is fail");
//		 }
		
		
		
//		System.out.println("Color of the Contact Sales btn:"+getElementColor(btn));
//		
//		if(getElementColor(btn).equals(WHITE)) {
//			System.out.println("Color of the Contact sale is correct");
//		}else {
//			System.out.println("Color of the Contact sale is incorrect");
//		}
//		
//		System.out.println("BGColor of the Contact Sales btn:"+getElementBgColo(btn));
//		
//		if(getElementBgColo(btn).equals(GREEN)) {
//			System.out.println("BGColor of the Contact sale is correct");
//		}else {
//			System.out.println("BGColor of the Contact sale is incorrect");
//		}
//		
//		
//		System.out.println("Font of the text:"+getTextFont(text));
//		System.out.println("Size of the text:"+ getTextSize(text));
//		
//		System.out.println("height of the content sale btn is :"+getElementHeight(btn));
//		System.out.println("weidth of the content sale btn is :"+getElementWidth(btn));
		
		

		
		System.out.println("Color of the Contact Sales btn:"+getElementColor(link));
		
		if(getElementColor(link).equals(WHITE)) {
			System.out.println("Color of the Contact sale is correct");
		}else {
			System.out.println("Color of the Contact sale is incorrect");
		}
		
		System.out.println("BGColor of the Contact Sales btn:"+getElementBgColo(link));
		
		if(getElementBgColo(link).equals(BLACK)) {
			System.out.println("BGColor of the Contact sale is correct");
		}else {
			System.out.println("BGColor of the Contact sale is incorrect"+getElementBgColo(link).toString());
		}
		
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	/**
	 * method to get the color of the webelement
	 * @param locator
	 * @return
	 */
	public static Color getElementColor(By locator) {

		return Color.fromString(getElement(locator).getCssValue("color"));
	}
	
	
	/**
	 * method to get the background color of webelement
	 * @param locator
	 * @return
	 */
	public static Color getElementBgColo(By locator) {
		
		return Color.fromString(getElement(locator).getCssValue("background-color"));
	}
	
	/**
	 * method to get the font style of the text
	 * @param locator
	 * @return
	 */
	public static String getTextFont(By locator) {
		
		return  getElement(locator).getCssValue("font-style").toString();
	}
	
	/**
	 * method to get the size of text
	 * @param locator
	 * @return
	 */
	public static String getTextSize(By locator) {
		
		return  getElement(locator).getCssValue("font-size").toString();
	}
	
	/**
	 * method to get the height of the webelement
	 * @param locator
	 * @return
	 */
	public static int getElementHeight(By locator) {
		
		Dimension element =	getElement(locator).getSize();
		return element.getHeight();
	}
	
	/**
	 * method to get the width of webelement
	 * @param locator
	 * @return
	 */
	public static int getElementWidth(By locator) {
		
		Dimension element =	getElement(locator).getSize();
		return element.getWidth();
	}
	
	
}
