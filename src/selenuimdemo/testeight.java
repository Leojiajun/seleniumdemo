package selenuimdemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testeight {
	@Test
	public void test(){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.baidu.com/");
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("D:/yyy.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ë«»÷
		Actions act = new Actions(driver);
		WebElement mess = driver.findElement(By.name("tj_trhao123"));
		act.doubleClick(mess).perform();
		//ÏÂÀ­Ñ¡Ôñ
		WebElement sss =driver.findElement(By.xpath(".//*[@id='search']/a/i"));
		Select sel = new Select(sss);
		sel.deselectByValue("");
		
		
		
				
	}

}
