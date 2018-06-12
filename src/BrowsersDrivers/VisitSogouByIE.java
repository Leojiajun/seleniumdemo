package BrowsersDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class VisitSogouByIE {
	WebDriver driver;
	String baseUrl;
	private static DesiredCapabilities caps = null;
	@BeforeMethod
	public void setUp() throws Exception{
		baseUrl = "http://www.sogou.com";
		System.setProperty("webdriver.ie.driver", "D:/BrowsersDrivers/IEDriverServer.exe");
		caps =DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);//���ⰲȫ�Լ�������
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");//ÿ������IE���Զ����cookie����¼
		caps.setCapability("ignoreZoomSetting", true);
		driver = new InternetExplorerDriver(caps);
		driver.manage().window().maximize();	
	}
	@Test
	public void visitSogou(){
		driver.get(baseUrl);
	}
	

}
