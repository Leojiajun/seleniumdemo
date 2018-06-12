package BrowsersDrivers;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisitByFirefox {
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setUp() throws Exception{
		baseUrl = "http://www.sogou.com";
		//将制定文件下的驱动加载到系统中
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}	
	@Test
	public void visitSogou(){
		driver.get(baseUrl);
	}

}

