package selenuimdemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class testseven {
      @Test
      public void test(){
    	  //Ë«»÷²Ù×÷
    	  WebDriver driver = new FirefoxDriver();
    	  //TakesScreenshot driver= new FirefoxDriver();
    	  driver.get("file:///C:/Users/user/Desktop/%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95/shuang.html");
    	  Actions act = new Actions(driver);
  	      WebElement shuangji = driver.findElement(By.id("inputbox"));
  		  act.doubleClick(shuangji).perform();
  	      //½ØÆÁ²Ù×÷
  		  File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  		  try {
			FileUtils.copyFile(file,new File ("D:/seleniumscreenshot/rrr.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		  
  	    }
}
