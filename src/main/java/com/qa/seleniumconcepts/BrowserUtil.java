package com.qa.seleniumconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	public WebDriver driver;
	
	/**
	 * Method to launch the browser base on the given browser.
	 * 
	 * if wanted launch Chrome Browser pass browsername = "chrome",
	 * 
	 * if wanted launch Firefox Browser pass browsername = "firefox",
	 * 
	 * if wanted launch Safari Browser pass browsername = "safari",
	 * 
	 * if wanted launch Edge Browser pass browsername = "edge"

	 * @param browsername
	 * @return driver 
	 */
	public WebDriver intBrowser(String browsername) {
		
		System.out.println("browser is launching:"+browsername);
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}else if (browsername.equals("safari")) {
			driver = new SafariDriver();
		}else if ( browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid browser is passed please pass the correct browse:"+browsername);
		}
		
		driver.manage().window().maximize(); // to maximize the window
		
		return driver;
	}
	
	
	/**
	 * To lauch the webpage base on the given url
	 * @param url
	 */
	public void launchUrl(String url) {
		
		if(url==null) {
			return;
		}else if(url.isEmpty()){
			return;
		}
		
		driver.get(url);
	}
	
	
	/**
	 * get the title of the webpage
	 * @return String title
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	/**
	 * get the url of the webpage
	 * @return String url
	 */
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	
	/**
	 * get the source code of the page
	 * @return String code
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	
	/**
	 * Close the current browser
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	/**
	 * Quite the current browser
	 */
	public void quiteBrowser() {
		driver.quit();
	}
	
	
	

}
