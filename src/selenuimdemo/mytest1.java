package selenuimdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mytest1 {
	public static void main(String[] args){
	  FirefoxDriver driver = new FirefoxDriver();
	  driver.get("http://www.baidu.com");
	  driver.findElementById("kw").sendKeys("���");
	  
	  //driver.findElementById("su").click();
	  driver.findElement(By.cssSelector("input[value='�ٶ�һ��']")).click();
	  driver.quit();
	  System.out.println("------------------");
	  
 }
}
