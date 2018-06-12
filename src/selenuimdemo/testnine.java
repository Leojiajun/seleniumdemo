package selenuimdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testnine {
	@Test
	public void test(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/jenkins/");
		A a = new A(){

			@Override
			public void aa(int i) {
				// TODO Auto-generated method stub
				
			}


		};
	}


}


interface A{
	
	void aa(int i);
	
}

@interface B{
	
}