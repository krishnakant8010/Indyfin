package Indyfin_Testcase;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends Browser_Launch {

	@Parameters({ "username", "password" })
	@Test
	public void EnterLoginDetails(String username, String password) throws InterruptedException {
		// System.out.println(username);
		driver.findElement(By.xpath("//input[@id='input-16']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-20']")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(),'SIGN IN')]")).click();
		Thread.sleep(2000);
	}

	@Test
	public void VerifyLogin() throws InterruptedException {
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]"));
		assertTrue(element.isDisplayed());
		// aseertTrue(element.getText().startsWith("Profile / Builder"));
	}
}
