package com.qa.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	
	
	@Parameters({"browser","url"})
	@BeforeTest
	public WebDriver setUp(String browsername,String url) {
		
		System.out.println("browser is launching:"+browsername);
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browsername.equals("safari")) {
			driver = new SafariDriver();
		}else if(browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	
	public void tearDown() {
		driver.quit();
	}
	
	
}
