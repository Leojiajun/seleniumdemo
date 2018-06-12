package selenuimdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testfive {
	@Test
	public void test() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///E:/自动化测试/html文件/select.html");
		driver.manage().window().maximize();
		//ʹ��select��
		WebElement cars = driver.findElement(By.name("cars"));
		Select se = new Select(cars);
		Thread.sleep(5000);
		se.selectByValue("audi");
		Thread.sleep(5000);
		se.selectByValue("saab");
		
	}

}
