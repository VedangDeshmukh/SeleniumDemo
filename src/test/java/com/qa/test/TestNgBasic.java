package com.qa.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgBasic {

	
	/**
	 * - TestNg is the Unit testing framework, use to maintaint and execute the test cases
	 * - it provide the different Annonitations , Annonitations we use to define preconditions 
	 * Annonations are :
	 * @BeforeTest
	 * @BeforeClass
	 * @BeforeMethod 
	 * @Test
	 * @AfterMentod
	 * @AdterClass
	 * @AfterTest
	 * 
	 * - with the help of TestNg you will be able to priortize your test cases , we need to maintain the sequence of 
	 * execution of test cases . 
	 * : test cases are executed in alphabate orders , if prioriyt then non-priority will execute and then priorty will execute
	 * 
	 * - it provide the different Assersation Hard and Soft Assersions , asserstions means validation expected vs actual
	 * - it support the HTML report 
	 * - with the help of test NG you will be able to paramatrize your test cases 
	 * - it provide the DataProvider : data provider we use to provide the data to test case
	 */
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void pageUrlTest() {
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.co.in/");
	}
	
	
	@Test(priority = 2)
	public void pageTitleTest() {
		
		Assert.assertTrue(driver.getTitle().contains("Googler"));
	}
	
	@Test(priority = 3, expectedExceptions = {ArithmeticException.class}, invocationCount = 2, dependsOnMethods = {"pageTitleTest"})
	public void getLinkTextTest() {
		
		int c = 10/0;
	}
	
}
