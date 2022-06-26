package com.qa.test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HRMSTest extends BaseTest {
	
		
	@Test
	public void getPageurlTest() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.orangehrm.com/orangehrm-30-day-trial/");
	}
	
	
	@Test
	public void getPageTitleTest() {
		Assert.assertTrue(driver.getTitle().contains("Free HR"));
	}
	
    @DataProvider
    public Object[][] getData() {
    	return new Object[][] {
    		{"Vedang","vedang@test.com"},
    		{"Ved","bg@gmail.com"},
    		{"vvvv","nh@gmail.com"}
    		
    	};
    }
    
    @Test(dataProvider = "getData", priority = 3)
    public void register(String name , String email) {
    	driver.findElement(By.name("Name")).clear();
    	driver.findElement(By.name("Name")).sendKeys(name);
    	driver.findElement(By.name("Email")).clear();

    	driver.findElement(By.name("Email")).sendKeys(email);
    }

}
