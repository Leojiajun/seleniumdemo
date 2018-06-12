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
	
	//xml�ļ�������  ȥ��xml�ļ��е� data��locator
	@Parameters({"data","locator"})
	
	@BeforeClass
	//��xml�е�data���ֵ����da   ��xml�е�locator���ֵ����loc  @Optional�Ĺ����ǣ�������xml�ļ����Ҳ���data��locator   ��Ĭ��Ϊdata��locl
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
		
		//�ȴ�helpԪ�صĳ���
		wait.waitForElementPresent(locator.getValue("helpEle"));
		//�жϡ��Ǳ��̡��Ƿ���֣�����ֵ��true
		Assert.assertEquals(ffwd.findElement(By.xpath(locator.getValue("instrumentEle"))).isDisplayed(), true);
		System.out.println("------********111100000***********------");
		
	}
	@AfterClass
	public void release(){
		ffwd.quit();
	}
}

