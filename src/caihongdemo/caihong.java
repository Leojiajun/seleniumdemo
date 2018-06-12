package caihongdemo;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Properties.Do;
import com.Properties.ParseProperties;
import com.Properties.Wait;
import launch.Browsers;
import launch.BrowsersType;

public class caihong {
	protected static WebDriver ffwd=null;
	private Do du;
	//private String projectpath=System.getProperty("user.dir");
	private ParseProperties data;
	private ParseProperties locator;
	private Wait wait;
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void startFirefox(@Optional("data") String da,@Optional("locl") String loc){
		data = new ParseProperties(System.getProperty("user.dir")+da);
		locator = new ParseProperties(System.getProperty("user.dir")+loc);
		Browsers browser = new Browsers(BrowsersType.firefox);
		ffwd = browser.driver;
		wait = new Wait(ffwd);
		du = new Do(ffwd);
	}
	@Test//登录
	public void register(){
		//从test.properties中解析到caihongURl
		ffwd.get(data.getValue("caihongURL"));
		//从locators.properties中解析到username输入框的元素，再输入test.properties中的username
		du.what("usernameEle").clear();
		du.what("usernameEle").sendKeys(data.getValue("username"));
		du.what("passwordEle").sendKeys(data.getValue("password"));
		du.what("enterEle").click();
		du.waitFor(3000);

		//等待help元素的出现
		//wait.waitForElementPresent(locator.getValue("helpEle"));
		du.waitForElementPresent("helpEle");
		//判断仪表盘是否出现，出现就说明登录成功了
		Assert.assertEquals(du.what("instrumentEle").isDisplayed(), true);
	}
	
	@Test(dependsOnMethods = {"register"})//选择产品查看报表
	public void report(){
		du.waitForElementPresent("logoEle");
		du.what("instrumentEle").click();
		//Select se1 = new Select(du.what("chanpinxialaEle"));
		//se1.selectByValue("PR10007");
		Select se2 = new Select(du.what("chaxunfangshiEle"));
		//记录下拉列表中的内容，分别打印出来
		List<WebElement> alltime = se2.getOptions();
		for(WebElement eachtime:alltime){
			System.out.println(eachtime.getText());
		}
		/*se2.selectByValue("day");
		du.what("startTime").click();
		du.what("bayue").click();
		du.what("endTime").click();
		du.what("jiuyue").click();
		du.what("search").click();
		du.waitFor(3000);*/
	}
	
	@Test(dependsOnMethods = {"report"})//向下拖出库记录
	public void chukujilu(){
		du.what("cangcu").click();
		du.waitForElementIsEnable("chukujilu");
		du.what("chukujilu").click();
		du.waitForElementIsEnable("chukujiluxiala");
		Select se3 = new Select(du.what("chukujiluxiala"));
		se3.selectByValue("100");
		du.waitFor(5000);
		//获取某元素的X Y坐标
		Point gg = ffwd.findElement(By.xpath("html/body/div[1]/div[3]/section[2]/div/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr[95]/td[1]")).getLocation();
		System.out.println(gg);
		((JavascriptExecutor)ffwd).executeScript("window.scrollBy("+gg.getX()+","+gg.getY()+")");//拖动滚动条到指定位置	
	}
	
	@AfterClass
	public void release(){
		ffwd.quit();
	}
}
