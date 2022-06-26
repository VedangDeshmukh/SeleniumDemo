package com.qa.test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	
	@Test
	public void getPageurlTest() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.co.in/");
	}
	
	
	@Test
	public void getPageTitleTest() {
		Assert.assertTrue(driver.getTitle().contains("Google"));
	}

}
