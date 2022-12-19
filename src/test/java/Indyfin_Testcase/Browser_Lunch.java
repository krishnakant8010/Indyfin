package Indyfin_Testcase;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Lunch {
	public static WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void BroswerLunch(String browserName) {

		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().create();
			driver = new FirefoxDriver();
			break;
		default:
			System.err.println("Invalid broswer name");
		}
		driver.manage().window().maximize();
	}

	@Parameters("Url")
	@Test
	public void LunchApp_URL(String Url) throws IOException {

		driver.get(Url);
		driver.getTitle();
	}
	
}
