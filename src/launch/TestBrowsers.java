package launch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrowsers {

	private WebDriver driver = null;
	//private APIObject testlinkapi;
	private String caseName = null;
	
	@BeforeClass
	public void beforeClass(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver =browser.driver;
	}
	
	
	@Test
	public void start(){
		caseName = "DoOne";
		driver.get("http://www.baidu.com");
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
