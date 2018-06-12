package selenuimdemo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWindowUp {
	public class Window{
		private String address;
		private Window parent;
		private List<Window> childrens;
		public Window(){}
		public Window(String address){
			this.address = address;
			this.childrens = new ArrayList<>();
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Window getParent() {
			return parent;
		}
		public void setParent(Window parent) {
			this.parent = parent;
		}
		public List<Window> getChildrens() {
			return childrens;
		}
		public void setChildrens(List<Window> childrens) {
			this.childrens = childrens;
		}
		
		public void addChildren(Window children) {
			this.childrens.add(children);
		}
		
	}
	
	
	public void test(){
		WebDriver driver = new FirefoxDriver();
		driver.get("ww.baidu.com");
		Window w = new Window("ww.baidu.com");
		
		driver.findElement(By.id("xx")).click();
		Window w1 = new Window("ww.google.com");
		w1.setParent(w);
		w.addChildren(w1);
		
		driver.findElement(By.id("xx")).click();
		Window w2 = new Window("www.google1.com");
		
		w2.setParent(w);
		w.addChildren(w2);
		
		driver.switchTo().frame("www.google1.com");
		driver.findElement(By.id("xx")).click();
		Window w3 = new Window("www.google2.com1");
		
		w3.setParent(w2);
		w2.addChildren(w3);
		
		driver.switchTo().frame(w.getChildrens().get(0).parent.getAddress());
		
		
		
	}
	
}
