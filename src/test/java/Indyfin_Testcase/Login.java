package Indyfin_Testcase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Browser_Lunch {
	
//	public static WebDriver driver;
//	@Parameters("browserName")
//	@BeforeTest
//	public void BroswerLunch(String browserName) {
//		
//	switch(browserName){
//	case "Chrome":
//		 WebDriverManager.chromedriver().setup();
//		 driver = new ChromeDriver();
//		break;
//		
//	case "firefox":
//		 WebDriverManager.firefoxdriver().create();
//		 driver = new FirefoxDriver();
//		break;
//		default:
//			System.err.println("Invalid broswer name");
//	}
//	driver.manage().window().maximize();
//	}
//	
//	@Parameters("Url")
//	@Test
//	public void LunchApp_URL(String Url) throws IOException {
//				
//		driver.get(Url);
//
//		
//	}
//	
	
	@Parameters({"username" , "password"})
	@Test
	public void EnterLoginDetails(String username,String password) throws InterruptedException {
		System.out.println(username);
		driver.findElement(By.xpath("//input[@id='input-16']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-20']")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(),'SIGN IN')]")).click();
		Thread.sleep(2000);
	}
	@Test
	public void VerifyLogin() throws InterruptedException {
		Thread.sleep(10000);
		WebElement element=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]"));
		assertTrue(element.isDisplayed());
		//aseertTrue(element.getText().startsWith("Profile / Builder"));
	}
}
