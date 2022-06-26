package com.qa.seleniumconcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * method to locate and create the webelement
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	/**
	 * method to locate and create the webelements
	 * @param locator
	 * @return List<WebElement>
	 */
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	/**
	 * method to send the keys to the webelemt
	 * @param locator
	 * @param value
	 */
	public void doSendkeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	/**
	 * method to get the text of the webelement
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	/**
	 * method to click on webElement
	 * @param locator
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	/**
	 * method to check webElement is displayed on webpage
	 * @param locator
	 * @return
	 */
	public Boolean doCheckElementDisplayed(By locator) {
	  return getElement(locator).isDisplayed();
	}
	
	
	/**
	 * method to check webElement is eneable on webpage
	 * @param locator
	 * @return
	 */
	public Boolean doCheckElementEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	

	/**
	 * method to get the attribute value of the the weblement
	 * @param locator
	 * @param attributename
	 * @return
	 */
	public String doGetAttributeValue(By locator , String attributename) {
		return getElement(locator).getAttribute(attributename);
	}
	
	
	
	/**
	 * method to get the total links text on the basic on given locator
	 * @param locator
	 * @return List<String> of links text
	 */
	public List<String> getLinkTetxList(By locator) {

		List<String> textlist = new ArrayList<String>();

		List<WebElement> eleList = getElements(locator);
		System.out.println("size of the elemets:" + eleList.size());
		System.out.println("Text of Links:");

		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(text);
				textlist.add(text);
			}
		}
		return textlist;
	}
	
	
	
	/**
	 * method to click on specific link on basic of given link name 
	 * @param locator
	 * @param value
	 */
	public void clickOnLink(By locator, String value) {

		List<WebElement> ele = getElements(locator);
		System.out.println("Size of elements:" + ele.size());
		System.out.println("links are:");

		for (WebElement e : ele) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	
	/**
	 * method to check element is exist on webpage without isDisplayed method
	 * 
	 * @param locator
	 * @return
	 */
	public Boolean isElementExist(By locator) {

		List<WebElement> ele = getElements(locator);
		System.out.println("size of the elements:" + ele.size());

		if (ele.size() > 0) {
			System.out.println("element is availabel and displayed");
			return true;
		} else {
			System.out.println("element is not availabel and displayed");
			return false;
		}

	}
	
	//*************************** DropDownUtility ***************************************************
	
	/**
	 * method to select the select base dropdown value by index
	 * @param locator
	 * @param index
	 */
	public void selectByIndex(By locator, int index) {
		Select s = new Select(getElement(locator));
		s.selectByIndex(index);
	}
	
	
	/**
	 * method to select the select base dropdown value by value
	 * @param locator
	 * @param value
	 */
	public  void selectByValue(By locator , String value) {
		Select s = new Select(getElement(locator));
		s.selectByValue(value);
	}
	
	
	/**
	 * method to select the select base dropdown value by visibleText
	 * @param locator
	 * @param text
	 */
	public  void selectByVisibleText(By locator, String text) {
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(text);
	}
	
	
	/**
	 * method to get the select base dropdown options
	 * @param locator
	 * @return List<String> of dropdown options
	 */
	public  List<String> getSelectDropDownOptions(By locator) {

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
	
	
	/**
	 * method to select the select base dropdown value by Options() method
	 * @param locator
	 * @param value
	 */
	public  void selectDropDownValueByOption(By locator, String value) {

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
	
	/**
	 * method to select the dropdown value without using Select class , this method is also use to select the value of 
	 * Jquery dropdown
	 * @param locator
	 * @param value
	 */
	public  void selectDroDownValue(By locator , String value) {
		
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
	
	
	/**
	 * method to get the dropdown options which are non select dropdown
	 * @param locator
	 * @return List<String> dropdown options
	 */
	public List<String> getDroDownOptions(By locator) {
		
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

	
	/**
	 * method to seletc the choices (multiselection) of the jequery dropdown, pass locator of the dropdown options and "All" or "all" as a value to select the all choices
	 * @param locator
	 * @param value
	 */
	public void selectChoice(By locator, String... value) {

		List<WebElement> ele = getElements(locator);
		System.out.println("size of elements:" + ele.size());
		System.out.println("dropdown options are:");

		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement e : ele) {
				String text = e.getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						e.click();
						break;
					}
				}
			}
		} else {
			for (WebElement e : ele) {
				System.out.println(e.getText());
				// all selection logic
				try {
					e.click();
				} catch (Exception ee) {
				}
			}
		}
	}
	
	/**
	 * method to select the value from suggestion list
	 * @param locator of suggestion list
	 * @param value to be selected
	 */
	
	public void selectValue(By locator, String value) {

		List<WebElement> ele = getElements(locator);
		System.out.println("size of elements:" + ele.size());

		for (WebElement e : ele) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	//************************************ Actions Util *************************************************
	
	
	/**
	 * this method is use to move to source element and click on destination option
	 * @param parentlocator
	 * @param childlocator
	 */
	public void twoLevelMenuHandeling(By parentlocator, By childlocator) {

		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentlocator)).perform();
		waitForElementVisibility(childlocator, 2).click();
	}
	
	

	/**
	 * this method is use to move to the parent soure element to child source element and click on destination option
	 * @param parentlocator
	 * @param childlocator
	 * @param subcchildlocator
	 */
	public void threeLevelMenuHandeling(By parentlocator, By childlocator, By subcchildlocator) {

		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentlocator)).perform();
		act.moveToElement(getElement(childlocator)).perform();

		waitForElementVisibility(subcchildlocator, 2).click();
	}

	
	
	/**
	 * method to send the keys to webelement by Actions class
	 * @param locator
	 * @param value
	 */
	public void doActionsSendKeys(By locator, String value) {

		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value);
	}

	
	/**
	 * method to click on webelement by Actions class
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator));
	}

	
	/**
	 * method for Right click and click on given option
	 * @param rightclicklocator
	 * @param optionslocator
	 * @param value
	 */
	public void rightClickandSelect(By rightclicklocator, By optionslocator, String value) {

		Actions act = new Actions(driver);
		act.contextClick(getElement(rightclicklocator)).perform();

		List<WebElement> ele = getElements(optionslocator);
		System.out.println("size of elements:" + ele.size());
		System.out.println("options are:");

		for (WebElement e : ele) {
			System.out.println(e.getText());

			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	//************************************ Wait Util ***************************************************
	
	
	/**
	 * method wait till element located inside the DOM 
	 * @param locator
	 * @param timeout
	 * @return WebElement
	 */
	public WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresence(By locator, int timeout, int interval) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, interval);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public List<WebElement> waitForElementsVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}

	public void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}

	public void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}

	public void sendKeysToAlert(int timeout, String value) {
		waitForAlert(timeout).sendKeys(value);
	}

	public void waitForFrameAndSwitchToIt(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFrameAndSwitchToIt(String name, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}

	public void waitForFrameAndSwitchToIt(int index, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public void waitForFrameAndSwitchToIt(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public String waitForUrlContains(int timeout, String urlvalue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		if (wait.until(ExpectedConditions.urlContains(urlvalue))) {
			return driver.getCurrentUrl();
		} else {
			return null;
		}
	}

	public String waitForUrlIS(int timeout, String fullurl) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		if (wait.until(ExpectedConditions.urlToBe(fullurl))) {
			return driver.getCurrentUrl();
		} else {
			return null;
		}
	}

	public String waitForTitleConatins(int timeout, String titlevalue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		if (wait.until(ExpectedConditions.titleContains(titlevalue))) {
			return driver.getTitle();
		} else {
			return null;
		}
	}

	public String waitForTitleIs(int timeout, String fulltitile) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		if (wait.until(ExpectedConditions.titleIs(fulltitile))) {
			return driver.getTitle();
		} else {
			return null;
		}
	}

	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWhenReady(By locator) {
		waitForElementToBeClickable(locator, 10).click();
	}
	
	
	//******************************** CSS Util *************************************************************
	
	
	/**
	 * method to get the color of the webelement
	 * @param locator
	 * @return
	 */
	public Color getElementColor(By locator) {

		return Color.fromString(getElement(locator).getCssValue("color"));
	}
	
	
	/**
	 * method to get the background color of webelement
	 * @param locator
	 * @return
	 */
	public Color getElementBgColo(By locator) {
		
		return Color.fromString(getElement(locator).getCssValue("background-color"));
	}
	
	/**
	 * method to get the font style of the text
	 * @param locator
	 * @return
	 */
	public String getTextFont(By locator) {
		
		return  getElement(locator).getCssValue("font-style").toString();
	}
	
	/**
	 * method to get the size of text
	 * @param locator
	 * @return
	 */
	public String getTextSize(By locator) {
		
		return  getElement(locator).getCssValue("font-size").toString();
	}
	
	/**
	 * method to get the height of the webelement
	 * @param locator
	 * @return
	 */
	public int getElementHeight(By locator) {
		
		Dimension element =	getElement(locator).getSize();
		return element.getHeight();
	}
	
	/**
	 * method to get the width of webelement
	 * @param locator
	 * @return
	 */
	public int getElementWidth(By locator) {
		
		Dimension element =	getElement(locator).getSize();
		return element.getWidth();
	}
	
	

}
