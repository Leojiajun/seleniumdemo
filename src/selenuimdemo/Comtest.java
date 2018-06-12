package selenuimdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Comtest {
	//变量projectpath  定位到主目录selenuimdemo
	   private String projectpath =System.getProperty("user.dir");
       @Test
       public void test(){
    	   WebDriver driver = new FirefoxDriver();
    	   driver.manage().window().maximize();
    	   driver.get("http://localhost:8080/jenkins/");
    	   driver.findElement(By.linkText("用户")).click();
    	   driver.navigate().back();
    	   driver.navigate().forward();   
       }
       
       @Test
       public void ietest(){
    	   System.setProperty("webdriver.ie.driver", projectpath+"/Tools/IEDriverSerner.exe");
    	   WebDriver driver = new InternetExplorerDriver();
    	   //driver.get("http://localhost:8080/jenkins/");
    	   driver.get("http://www.baidu.com");
       }
       
       //搜索
       @Test
       public void chrometest(){
    	   System.setProperty("webdriver.chrome.driver", projectpath+"/Tools/chromedriver_x64.exe");
    	   WebDriver driver = new ChromeDriver();
    	   driver.get("http://localhost:8080/jenkins/");
    	   driver.findElement(By.id("search-box")).clear();
    	   driver.findElement(By.id("search-box")).sendKeys("搜索内容",Keys.ENTER);
    	   Actions action = new Actions(driver); 
    	   action.sendKeys(driver.findElement(By.id("search-box")),Keys.ENTER);
    	   action.sendKeys(driver.findElement(By.id("search-box")),Keys.NULL);
       }
       
       //登陆
       @Test
       public void chrometest2(){
    	   System.setProperty("webdriver.chrome.driver", projectpath+"/Tools/chromedriver_x64.exe");
    	   WebDriver driver = new ChromeDriver();
    	   driver.get("http://localhost:8080/jenkins/");
    	   //driver.findElement(By.cssSelector("#header .login a b")).click();
    	   //driver.findElement(By.xpath("//b[text()='登录']")).click();
    	   driver.findElement(By.xpath(".//*[@id='header']/div[2]/a[1]/b")).click();
    	   driver.findElement(By.id("j_username")).sendKeys("Leo");
    	   driver.findElement(By.name("j_password")).clear();
    	   driver.findElement(By.name("j_password")).sendKeys("123456",Keys.ENTER);
    	   
       }
    	   
    	   
      
       
}
