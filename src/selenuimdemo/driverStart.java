package selenuimdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Properties.Do;

import launch.Browsers;
import launch.BrowsersType;

public class driverStart {
	private static WebDriver ffwd=null;
	private static Do du;
	private String projectpath=System.getProperty("user.dir");
	
	@BeforeClass
	public static void DriverStart(){
		Browsers browser= new Browsers(BrowsersType.firefox);
		ffwd= browser.driver;
		du = new Do(ffwd);
		
	}
	@Test
	public static void getBaidu(){
		ffwd.get("https://www.baidu.com/?tn=47018152_dg");
		//ÐÝÃßÎåÃë
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ffwd.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]/div/form/span[1]/input")).sendKeys("ÄãºÃÂð",Keys.ENTER);
		
	}
	@AfterClass
	public void release(){
		ffwd.quit();
	}
}
