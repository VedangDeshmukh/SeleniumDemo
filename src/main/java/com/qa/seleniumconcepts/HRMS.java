package com.qa.seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HRMS {

	static WebDriver driver;
	
	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		driver =br.intBrowser("chrome");
		br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By name = By.id("Form_submitForm_Name");
		By email = By.id("Form_submitForm_Email");
		By pno = By.id("Form_submitForm_Contact");
		
		
		ElementUtil el = new ElementUtil(driver);
		
		el.doSendkeys(name, "Testuser");
		el.doSendkeys(email, "test@gmail.com");
		el.doSendkeys(pno, "8987656789");
		
		//br.closeBrowser();
		
	}
	
	

}
