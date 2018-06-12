package com.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import launch.Browsers;
import launch.BrowsersType;

public class Practice2OnTestng {
	protected static WebDriver ffwd = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user,dir");
	
	private ParseProperties data;
	private ParseProperties locator;
	private Wait wait;
	
	//xml文件传数据  去找xml文件中的 data和locator
	@Parameters({"data","locator"})
	
	@BeforeClass
	//把xml中的data里的值传给da   把xml中的locator里的值传给loc  @Optional的功能是：假如在xml文件中找不到data和locator   则默认为data和locl
	public void startFirefox(@Optional("data") String da,@Optional("locl") String loc){
		data = new ParseProperties(System.getProperty("user.dir")+da);
		locator = new ParseProperties(System.getProperty("user.dir")+loc);
		Browsers browser = new Browsers(BrowsersType.firefox);
		ffwd = browser.driver;
		wait = new Wait(ffwd);
	}

	@Test
	public void acceddMail(){
		ffwd.get(data.getValue("caihongURL"));
		ffwd.findElement(By.xpath(locator.getValue("usernameEle"))).clear();
		ffwd.findElement(By.xpath(locator.getValue("usernameEle"))).sendKeys(data.getValue("username"));
		ffwd.findElement(By.xpath(locator.getValue("passwordEle"))).sendKeys(data.getValue("password"));
		ffwd.findElement(By.xpath(locator.getValue("enterEle"))).click();
		
		//等待help元素的出现
		wait.waitForElementPresent(locator.getValue("helpEle"));
		//判断“仪表盘“是否出现，期望值是true
		Assert.assertEquals(ffwd.findElement(By.xpath(locator.getValue("instrumentEle"))).isDisplayed(), true);
		System.out.println("------********111100000***********------");
		
	}
	@AfterClass
	public void release(){
		ffwd.quit();
	}
}

