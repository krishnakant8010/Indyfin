package Indyfin_Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Gmail_login {
	WebDriver driver;
	@Test
	public void login() {
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://mail.google.com/");
	GmailPageObjects GPO=PageFactory.initElements(driver,GmailPageObjects.class);
	GPO.enterEmail("quality@indyfin.com");
	GPO.enterPassword("SuperDuper@1");
	GPO.clickEmail("Advisor Platform Verification Code");
	
	
	}
}
