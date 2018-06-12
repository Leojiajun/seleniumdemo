package selenuimdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testsix {
	@Test
	public void test(){
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///E:/%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95/html%E6%96%87%E4%BB%B6/%E5%A4%9A%E9%80%89%E6%8C%89%E9%92%AE.html");
		driver.manage().window().maximize();
		//单选或双选按钮
		WebElement ridio =driver.findElement(By.name("Bike"));
		ridio.click();
		WebElement ridio1 =driver.findElement(By.name("Car"));
		ridio1.click();
}
}