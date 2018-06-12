package BrowsersDrivers;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisitSogouByChrome {
	WebDriver driver;
	String baseUrl;
	@BeforeMethod
	public void setUp() throws Exception{
		baseUrl = "http://www.sogou.com";
		//将制定文件下的驱动加载到系统中
		System.setProperty("webdriver.chrome.driver","D:\\BrowsersDrivers\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		capabilities.setCapability("chrome.binary","src/ucBrowserDrivers/chromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY,options);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
	}	
	@Test
	public void visitSogou(){
		driver.get(baseUrl);
	}

}
