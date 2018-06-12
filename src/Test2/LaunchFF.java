package Test2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LaunchFF {
	private String projectpath=System.getProperty("user.dir");
	private WebDriver ffwb=null;
	@BeforeClass
	public void startfirefox(){
		//System.setProperty("Webdriver.firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe" );
		File firebug =new File(projectpath+"/Tools/firebug@software.joehewitt.com.xpi");
		File fireXpath = new File(projectpath+"/Tools/FireXPath@pierre.tholence.com.xpi");
		FirefoxProfile firefoxprofile = new FirefoxProfile();
		    try {
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(fireXpath);
				//确定firebug的版本，不然会一直弹出一个也没要求确认版本
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.17");
				//自动启动firebug
				firefoxprofile.setPreference("extensions.firebug.allPagesActivation", "on");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		ffwb = new FirefoxDriver(firefoxprofile);
	}
	@Test
	public void SerachOnBaidu(){
		ffwb.get("http://www.baidu.com");
	}
	@AfterClass
	public void releaseFFdriver(){
		ffwb.quit();
	}
}
