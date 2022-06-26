package com.qa.seleniumconcepts;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.jcajce.provider.symmetric.TEA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectBaseDropDownHandeling {
	
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		/**
		 * To handel the select base dropdown select provide the Select class
		 * Select s = new Select(webelement);
		 * methods:
		 * s.selectByIndex(3);
		 * s.selectByVisibleText("test");
		 * s.selectByValue("tt1");
		 * 
		 * s.getOptions();
		 * 
		 * s.getAllSelectedOptions(); when multiselect dropdown
		 * s.getFirstSelectedOption();	return webelement first select option
		 * s.deselectAll();	when multiselect dropdown
		 * s.deselectByIndex(3);
		 * s.deselectByVisibleText("test");
		 * s.deselectByValue("tt1");

		 * 
		 */
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
	//	Select s = new Select(driver.findElement(By.id("Form_submitForm_Country")));
		//s.selectByIndex(2);
		//s.selectByValue("Algeria");
//		s.selectByVisibleText("India");
		
		//System.out.println(s.getFirstSelectedOption().getText());
		
//		  List<WebElement> ele= s.getOptions();
//		  System.out.println("size of dropdown options:"+ele.size());
//		  System.out.println("dropdown options are:");
//		  
//		  for(WebElement e : ele) {
//			  System.out.println(e.getText());
//		  }
		
		By options = By.xpath("//select[@name='Country']/option");
		By country = By.id("Form_submitForm_Country");
		
		driver.findElement(country).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//selectDropDownValueByOption(country, "India");
		//selectDroDownValue(options, "India");
		
		getDroDownOptions(options);
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void selectByIndex(By locator, int index) {
		Select s = new Select(getElement(locator));
		s.selectByIndex(index);
	}
	
	public static void selectByValue(By locator , String value) {
		Select s = new Select(getElement(locator));
		s.selectByValue(value);
	}
	
	public static void selectByVisibleText(By locator, String text) {
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(text);
	}
	
	public static List<String> getSelectDropDownOptions(By locator) {

		List<String> dropdownoptionslist = new ArrayList<>();

		Select s = new Select(getElement(locator));
		List<WebElement> ele = s.getOptions();
		System.out.println("size of dropdown options:" + ele.size());
		System.out.println("dropdown options are:");

		for (WebElement e : ele) {
			String text = e.getText();
			System.out.println(text);
			dropdownoptionslist.add(text);
		}

		return dropdownoptionslist;
	}
	
	public static void selectDropDownValueByOption(By locator, String value) {

		Select s = new Select(getElement(locator));
		List<WebElement> ele = s.getOptions();
		System.out.println("size of dropdown options:" + ele.size());
		System.out.println("dropdown options are:");

		for (WebElement e : ele) {
			System.out.println(e.getText());
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public static void selectDroDownValue(By locator , String value) {
		
		List<WebElement> ele = getElements(locator);
		System.out.println("size of dropdown options:"+ele.size());
		System.out.println("dropdown options are:");
		
		for(WebElement e : ele) {
			System.out.println(e.getText());
			
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public static List<String> getDroDownOptions(By locator) {
		
		List<String> optionslist = new ArrayList<>();
		
		List<WebElement> ele = getElements(locator);
		System.out.println("size of dropdown options:"+ele.size());
		System.out.println("dropdown options are:");
		
		for(WebElement e : ele) {
			System.out.println(e.getText());
			optionslist.add(e.getText());
		}
		return optionslist;
	}

}
