package selenuimdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public class TestTakesScreenshot {
	private static final Logger logger = LoggerFactory.getLogger(TestTakesScreenshot.class);
	@Test
	public void test() throws FileNotFoundException{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys(" ¿ΩÁ±≠");
		driver.findElement(By.xpath(".//*[@id='su']")).click();
		//driver.findElement(By.id("su")).click();
		OutputStream out = null;
		out = new FileOutputStream("D:/seleniumscreenshot/jieping.jpg");
		TakesScreenshot take = (TakesScreenshot)driver;
		File file=take.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info(" over end!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n!!!!!!!!!!!!!!");
	}
	
	public static void main(String[] args) {
		logger.info(" over end!");
	}

	
	
			
}
