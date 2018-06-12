package selenuimdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class testDriver {
	@Test
	public void test(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
	
	}

}
