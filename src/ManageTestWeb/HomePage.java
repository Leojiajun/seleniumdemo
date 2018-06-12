package ManageTestWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='login']")
	private WebElement loginbtn;
	
	//¹¹Ôìº¯Êý
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void toTo(String url){
		driver.get(url);
	}
	public void setName(String name){
		username.sendKeys(name);
	}
		
	public void setPassword(String pword){
		password.sendKeys(pword);
	}
		
	public void logIn(){
		loginbtn.click();
	}
	
}
