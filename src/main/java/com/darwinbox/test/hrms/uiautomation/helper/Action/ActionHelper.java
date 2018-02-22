package com.darwinbox.test.hrms.uiautomation.helper.Action;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.darwinbox.test.hrms.uiautomation.helper.Alert.AlertHelper;
import com.darwinbox.test.hrms.uiautomation.helper.TestBase.TestBase;

public class ActionHelper extends TestBase{

	private WebDriver driver;
	private static final Logger oLog = Logger.getLogger(AlertHelper.class);
	
	public ActionHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("AlertHelper : " + this.driver.hashCode());
	}
	
	/**
	 * This method clicks using action class
	 * 
	 * @param element
	 * @param text
	 * @return
	 */
	public boolean actionClick(WebDriver driver,WebElement element, String text) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			action.click(element).build().perform();
			Reporter("Clicked on " + text + " successfully", "Pass");
			return true;
		} catch (Exception e) {
			Reporter("Exception while clicking on " + text, "Fail");
			throw new RuntimeException("Exception while clicking on " + text + ":" + e.getMessage());
		}
	}

	/**
	 * This method clicks using action class
	 * 
	 * @param element
	 * @param text
	 * @return
	 */
	public boolean moveToElement(WebDriver driver,WebElement element, String text) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Reporter("Moved to " + text + " successfully", "Pass");
			return true;
		} catch (Exception e) {
			Reporter("Exception while clicking on " + text, "Fail");
			throw new RuntimeException("Exception while clicking on " + text + ":" + e.getMessage());
		}
	}

	/**
	 * Move to top of page by pressing CNTRL+HOME button
	 * @param driver
	 * @param element
	 * @param text
	 * @return boolean
	 */
	public boolean moveToTop(WebDriver driver,WebElement element, String text) {
		try {
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
			action.keyDown(Keys.CONTROL).release().perform();
			Reporter("Moved to top successfully", "Pass");
			return true;
		} catch (Exception e) {
			Reporter("Exception while clicking on " + text, "Fail");
			throw new RuntimeException("Exception while clicking on " + text + ":" + e.getMessage());
		}
	}
	
	/**
	 * Move to top of page by pressing CNTRL+HOME button
	 * @param driver
	 * @param element
	 * @param text
	 * @return boolean
	 */
	public boolean pressEnterKey(WebDriver driver) {
		try {
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();
			action.keyDown(Keys.CONTROL).release().perform();
			return true;
		} catch (Exception e) {
			Reporter("Exception while clicking on Enter key", "Fail");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
}
