package groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import launch.Browsers;
import launch.BrowsersType;

public class testgroupsBrowsers {
	private WebDriver driver = null;
	private Browsers browser = null;
	
	@Parameters({"platform"})//将xml文件中的name=platform的value值带入下面inital类中的platform
	@BeforeMethod(groups="browser")
	public void inital(String platform){
		if(platform.equals("FF"))
			browser = new Browsers(BrowsersType.firefox);
		else if(platform.equals("chrome"))
			browser = new Browsers(BrowsersType.chrome);
		else
			browser = new Browsers(BrowsersType.ie);
			
		driver = browser.driver;
	}
	
	@Test(groups="submodule1",priority=1)//优先级为1
	public void sunmodule1(){
		driver.get("http://www.baidu.com");
		System.out.println("----submodule1-----");
	}
	
	@Test(groups="submodule2",priority=2)//优先级为2
	public void submodule2(){
		driver.get("http://www.so.com");
		System.out.println("----submodule2-----");
	}
	
	@Test(groups="submodule3")
	public void submodule3(){
		driver.get("http://www.bing.com");
		System.out.println("----submodule3-----");
	}
	@Test(groups="submodule4")
	public void submodule4(){
		driver.get("http://www.oracle.com");
		System.out.println("----submodule4-----");
	}
	
	@AfterMethod(groups="browser")
	public void release(){
		driver.quit();
	}
	
}
