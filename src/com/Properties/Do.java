package com.Properties;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Do {
	private WebDriver driver;
	private ParseProperties locator = new ParseProperties(System.getProperty("user.dir")+"/Tools/locators.properties");
	private Wait waiter;
	
	public Do(WebDriver driver){
		this.driver = driver;
		waiter = new Wait(driver);
	}
	public WebElement what(String locatorname){
		return driver.findElement(By.xpath(locator.getValue(locatorname)));	
	}
	public List<WebElement> whats(String locatorname){
		return driver.findElements(By.xpath(locator.getValue(locatorname)));
	}
	public void waitForElementPresent(String locatorname){
		waiter.waitForElementPresent(locator.getValue(locatorname));
	}
	public void waitForElementIsEnable(String locatoename){
		waiter.waitForElementIsEnable(locator.getValue(locatoename));
	}
	public void waitFor(long timeout){
		waiter.waitFor(timeout);
	}
}
