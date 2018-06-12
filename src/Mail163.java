

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Properties.Do;
import com.Properties.ParseProperties;

import launch.Browsers;
import launch.BrowsersType;

@Test
public class Mail163 {
	private WebDriver driver;
	//private ParseProperties data;
	private Do du;
	
	@BeforeClass
	public void inital(){
		//data = new ParseProperties(System.getProperty("user.dir")+"/Tools/test.properties");
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		du = new Do(driver);
	}
	public void login163mail(){
		driver.get("http://mail.163.com/");
		du.waitFor(3000);
		driver.switchTo().frame("x-URS-iframe");//切换iframe
		du.what("username163Mail").sendKeys("wujiajun318");
		du.what("password163Mail").sendKeys("ABWJJ318318@");
		du.what("login163Mail").click();
		du.waitFor(3000);
	}
	public void restriveMailsIn(){
		int actualunreadMailsNum=0;
		int totalPagesNum=0;
		
		String strNum = du.what("shoujianxiangEle").getText().replace(" ", "");
		System.out.println("111111111"+strNum);
		System.out.println("2222222"+strNum.length());
		du.waitFor(2000);
		int inboxunReadMailsNum= Integer.valueOf(strNum.substring(4, strNum.length()-1));//截取字符串中第4位到最后第二位
		System.out.println("11111****************"+inboxunReadMailsNum);
		System.out.println("11111****************"+strNum.length());
		du.what("shoujianxiangEle").click();
		du.waitFor(3000);
		du.what("weiduyoujianEle").click();
		//du.waitFor(3000);
		du.waitForElementPresent("totalPagesEle");
		String tpE =du.what("totalPagesEle").getText();
		System.out.println(tpE);
		totalPagesNum = Integer.valueOf(tpE.split("/")[1]);//以/分割，取第二个元素
		String[] dd = tpE.split("/");//用/分割，得到数组[1,5],这里的5是总页数，对应的索引值分别是0，1
		System.out.println(dd);
		
		
		System.out.println("2222****************"+totalPagesNum);
		
		//循环点击下一页按钮
		for(int i=1;i<=totalPagesNum;i++){
			actualunreadMailsNum = actualunreadMailsNum+du.whats("unreadMails").size();//ʵ��δ����=ÿ��ҳ���ϵĸ�ѡ����ܺ�
			du.what("nextbotn").click();//点击下一页
			du.waitFor(3000);
		}
//		if(inboxunReadMailsNum==actualunreadMailsNum){
//			System.out.println("测试通过");
//		}else{
//			System.out.println("测试不通过"); ;
//		}
			Assert.assertTrue(inboxunReadMailsNum==actualunreadMailsNum);
			
		/*while(totalPagesNum>=1){
			actualunreadMailsNum = actualunreadMailsNum+du.whats("unreadMails").size();//ʵ��δ����=ÿ��ҳ���ϵĸ�ѡ����ܺ�
			try{
				du.what("nextbotn").click();
				du.waitFor(3000);
			}catch(Exception e){
				break;
			}
			totalPagesNum--;
		}*/
		System.out.println("1****��ʾ��δ���ʼ�����"+inboxunReadMailsNum);
		System.out.println("2****ʵ�ʵ�δ���ʼ�����"+actualunreadMailsNum);
	}
//	@Test(dependsOnMethods={"restriveMailsIn"})
//	public void mouseRightclickContext(){
//		Actions actions = new Actions(driver);
//		actions.contextClick(du.what("yifasong")).build().perform();
//		du.waitFor(2000);
//		du.what("dakai").click();
//		du.waitFor(2000);
//		Assert.assertEquals(du.what("yanzheng").isDisplayed(), true);
//		
//	}

	@AfterClass
	public void release(){
		driver.quit();
	}
	
}
