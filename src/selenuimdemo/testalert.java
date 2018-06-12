package selenuimdemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testalert {
	@Test
	//alert确定
	public void test() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///E:/自动化测试/html文件/testpage.html");
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/input[1]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/input[1]")).click();
		Thread.sleep(3000);
		Alert dd = driver.switchTo().alert();
		dd.accept();
		
	}
    @Test
    //confirm
    public void testconfirm() throws InterruptedException{
    	WebDriver driver = new FirefoxDriver();
		driver.get("file:///E:/自动化测试/html文件/testpage.html");
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/input[2]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/input[2]")).click();
		Thread.sleep(3000);
		Alert cc = driver.switchTo().alert();
		String AA = cc.getText();
		cc.dismiss();
		Assert.assertTrue(AA.equals("这是Confirmation"));
		
    }
    @Test
    //prompt
    public void testprompt() throws InterruptedException{
    	WebDriver driver = new FirefoxDriver();
    	driver.get("file:///E:/自动化测试/html文件/testpage.html");
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/input[3]")));
    	driver.findElement(By.xpath("html/body/input[3]")).click();
    	Alert prom = driver.switchTo().alert();
    	Thread.sleep(3000);
    	prom.sendKeys("测试");
    	String pp = prom.getText();
    	System.out.println(pp);
    	prom.accept();
    	Assert.assertTrue(pp.equals("这是Prompt"));
    }
    
    @Test
    //frame切换
    public void testFram() throws InterruptedException{
    	WebDriver driver = new FirefoxDriver();
    	driver.get("file:///E:/自动化测试/html文件/fram/frame.html");
    	//切换到middlefram
    	WebDriver dd = driver.switchTo().frame("middleframe");
    	dd.findElement(By.id("kw")).sendKeys("444");
    	Thread.sleep(3000);
    	//切回去
    	driver.switchTo().defaultContent();
    	Thread.sleep(3000);
    	//切换到leftfram
    	WebDriver cc = driver.switchTo().frame("leftframe");
    	cc.findElement(By.id("kw")).sendKeys("555");	
    }
    
	@Test
	public void testselect() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///E:/自动化测试/html文件/select.html");
		driver.manage().window().maximize();
		//select
		WebElement cars = driver.findElement(By.name("cars"));
		Select se = new Select(cars);
		Thread.sleep(3000);
		se.selectByValue("audi");
		Thread.sleep(3000);
		se.selectByValue("saab");	
	}
}
