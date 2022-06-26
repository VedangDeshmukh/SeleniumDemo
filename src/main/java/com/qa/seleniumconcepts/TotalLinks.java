package com.qa.seleniumconcepts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Program to calculate the total no links and display the link . ignore the blank links
 * @author Admin
 *
 */
public class TotalLinks {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		/**
		 * To locate the elememts on the webpage in Selenium findElements() method is available 
		 * findElements() method locate the all the webEement on basic of the given locator
		 * it returns the List<WebElement>
		 * 
		 * Formula = get the elemets + iterate the list and perform the actions
		 */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		By links = By.tagName("a");
		
//	 List<WebElement> linksele =	driver.findElements(links);
//	 System.out.println("Size of total links:"+linksele.size());
//	 
//	 for(int i=0 ;i<linksele.size();i++ ) {
//		String text= linksele.get(i).getText();
//		System.out.println(text);
//	 }

		 List<String> linktext = getLinkTetxList(links);
		 
		 System.out.println("===========================");
		 System.out.println(linktext);
		 
		 if(linktext.contains("Amazon Business")) {
			 System.out.println("Amazon Business is available Test cases is pass");
		 }else {
			 System.out.println("Amazon Business is not available Test cases is fail");
		 }

		
	}
		
	
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static List<String> getLinkTetxList(By locator) {
		
		
		List<String> textlist = new ArrayList<String>();
		
	  List<WebElement> eleList =getElements(locator);
	  System.out.println("size of the elemets:"+eleList.size());
	  System.out.println("Text of Links:");

	  for(WebElement e : eleList) {
		 String text= e.getText();
		 if(!text.isEmpty()) {
			 System.out.println(text);
			 textlist.add(text);
		 }
	  }
	  return textlist;
	}

	
}	
	

