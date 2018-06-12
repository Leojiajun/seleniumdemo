package selenuimdemo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


@Test
public class testwindow2 {
	public void test(){
		WebDriver driver = new FirefoxDriver();
		//1
		driver.get("file:///E:/%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95/html%E6%96%87%E4%BB%B6/target.html");
		String parent = driver.getWindowHandle();
		//2
		driver.findElement(By.xpath("html/body/ul/li[1]/a")).click();
		//driver.findElement(By.xpath(".//*[@id='u1']/a[3]")).click();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> ite = all.iterator();
		String temp = null;
		while (ite.hasNext()){
			temp = ite.next();
			if (!temp.equals(parent)){
				System.out.println("++++++++++++++++++++"+temp);
				driver.switchTo().window(temp);
				
			}
		}
		//3
		driver.findElement(By.xpath("html/body/ul/li[1]/a")).click();	
		Set<String> all1 = driver.getWindowHandles();
		Iterator<String> ite1 = all1.iterator();
		String temp1 = null;
		while (ite1.hasNext()){
			temp1 = ite1.next();
			if (!temp1.equals(parent)){
				System.out.println("++++++eeeee++++++++"+temp);
				driver.switchTo().window(temp1);
			}
		}	
			driver.findElement(By.xpath("html/body/ul/li[2]/a")).click();
			//·µ»ØÔ­´°¿Ú
			driver.switchTo().window(parent);
			driver.findElement(By.xpath("html/body/ul/li[2]/a")).click();
			
			
  }	
}	
	

