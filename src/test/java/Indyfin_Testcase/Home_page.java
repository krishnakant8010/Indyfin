package Indyfin_Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Home_page {
	WebDriver driver = null;

	@Parameters({ "browser", "url" })
	@Test(priority = 1)

	public void Browser_Set_Up(String browser, String url) {
		if (browser.equals("chrome")) {
			// System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,
			// "true");
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		 driver.get("https://dev.indyfin.com/");
		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
		} else if (browser.equals("ie")) {

			System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

			driver.manage().window().maximize();
		}
		// System.out.print(url);
		driver.get(url);
	}

	@Test(priority = 2)
	public void RegisterUser() throws Exception {
		driver.findElement(By.id("reg_email")).sendKeys("krishna@gmail.com");
		driver.findElement(By.id("reg_password")).sendKeys("Krishnakant@$12");

		driver.findElement(By.name("register")).click();

		Thread.sleep(2000);
//		String SignupText =driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).getText();
//		System.out.println(SignupText);
		String SignupError = driver.findElement(By.xpath("//h2[contains(text(),'Register')]")).getText();
		// System.out.println(SignupError);
		if (SignupError.equals("Register")) {
			System.out.println("User Not Register");
		} else {
			System.out.println("User Register Sucessfully");
		}

	}

	@Test(priority = 3)
	public void login_user() {
		driver.findElement(By.id("username")).sendKeys("agami.krishna@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Krishnakant@$12");
		driver.findElement(By.name("login")).click();
		String Actualmessage = driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).getText();
		String ExpectedMessage = "Sign out";
		Assert.assertEquals(ExpectedMessage, Actualmessage,"fdhdg");
	}

	@Test(priority = 4)
	public void Logout() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		String LoginText = driver.findElement(By.xpath("//h2[contains(text(),'Login')]")).getText();
		String ExpectedloginTest = "Login";
		Assert.assertEquals(ExpectedloginTest, LoginText);
	}

	@Test(priority = 5)
	public void Exit() {
		driver.close();
	}

}
