package selenuimdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.testng.annotations.Test;




public class testfour {
	@Test
	public void testJS(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/jenkins/");
		/*//打开网页如果超过8秒就报错
		driver.manage().timeouts().pageLoadTimeout(8000, TimeUnit.MILLISECONDS);
		//打开网页后休眠三秒
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		driver.findElement(By.xpath(".//*[@id='header']/div[2]/a[1]")).click();;
		/*JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement username = (WebElement) js.executeScript("document.getElementById(\"j_username\")");
		username.clear();
		username.sendKeys("Leo");*/
		//截屏
		OutputStream out = null;
		TakesScreenshot take = (TakesScreenshot)driver;
	    File file = take.getScreenshotAs(OutputType.FILE);
	    try {
			out = new FileOutputStream("D:/seleniumscreenshot/jieping.jpg");
			FileUtils.copyFile(file, out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		//执行双击操作
	    Actions act = new Actions(driver);
	    WebElement shuangji = driver.findElement(By.xpath(".//*[@id='tasks']/div[2]/a[2]"));
		act.doubleClick(shuangji).perform();
	    
	    //执行拖拽操作
	    WebElement src = driver.findElement(By.xpath(".//*[@id='timeline-band-1']/div/div[7]/div"));
	    WebElement target = driver.findElement(By.xpath(".//*[@id='timeline-band-1']/div/div[7]/div"));
	    act.dragAndDrop(src, target).perform();
	   
	    		
	    }

}
