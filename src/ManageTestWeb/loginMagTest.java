package ManageTestWeb;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Properties.ParseProperties;
import com.Properties.Wait;


import launch.Browsers;
import launch.BrowsersType;

public class loginMagTest {
	private WebDriver driver;
	private ParseProperties data;
	private Wait wait;
	
	@BeforeClass
	public void startFox(){
		//data = new ParseProperties(System.getProperty("user.dil")+"//");
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		wait = new Wait(driver);
	}
	@Test
	public void login(){
		HomePage homepage = new HomePage(driver);
		homepage.toTo("http://test-platform.tcc.so/pages/login.html");
		homepage.setName("wujiajun");
		homepage.setPassword("123456");
		homepage.logIn();
		wait.waitFor(3000);
		//Assert.assertEquals(actual, expected);
		
	}
}
