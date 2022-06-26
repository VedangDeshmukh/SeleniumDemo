package com.qa.synchronization;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		
		

	}

	
	public static WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementPresence(By locator, int timeout, int interval) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, interval);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static List<WebElement> waitForElementsVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
	 return	wait.until(ExpectedConditions.alertIsPresent());

	}
	
	public static String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}
	
	public static void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}
	
	public static void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	
	public static void sendKeysToAlert(int timeout , String value) {
		waitForAlert(timeout).sendKeys(value);
	}
	
	
	public static void waitForFrameAndSwitchToIt(By locator ,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public static void waitForFrameAndSwitchToIt(String name ,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}
	
	public static void waitForFrameAndSwitchToIt(int index ,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
	public static void waitForFrameAndSwitchToIt(WebElement element ,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	
	public static String waitForUrlContains(int timeout, String urlvalue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		if(wait.until(ExpectedConditions.urlContains(urlvalue))) {
			return driver.getCurrentUrl();
		}else {
			return null;
		}
	}
	
	public static String waitForUrlIS(int timeout, String fullurl) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		if(wait.until(ExpectedConditions.urlToBe(fullurl))) {
			return driver.getCurrentUrl();
		}else {
			return null;
		}
	}
	
	public static String waitForTitleConatins(int timeout, String titlevalue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		if(wait.until(ExpectedConditions.titleContains(titlevalue))) {
			return driver.getTitle();
		}else {
			return null;
		}
	}
	
	public static String waitForTitleIs(int timeout, String fulltitile) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		if(wait.until(ExpectedConditions.titleIs(fulltitile))) {
			return driver.getTitle();
		}else {
			return null;
		}
	}
	
	public static WebElement waitForElementToBeClickable(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void clickWhenReady(By locator) {
		waitForElementToBeClickable(locator, 10).click();
	}

	
	

}
