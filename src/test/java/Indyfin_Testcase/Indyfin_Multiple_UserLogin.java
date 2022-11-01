package Indyfin_Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Indyfin_Multiple_UserLogin {

	WebDriver driver;

	@Test
	public void logindata() throws IOException, Exception {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Keys.chord(Keys.CONTROL.SHIFT,"i"));
		driver.get("https://stage.indyfin.com/#/");
		//driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		WebElement l=driver.findElement(By.xpath("//div[@class='v-responsive__content']"));
	      // Actions class with moveToElement() and contextClick()
	      Actions a = new Actions(driver);
	      a.moveToElement(l).contextClick().build().perform();
		
		File file = new File("Data\\indyfinUser.xlsx");

		// System.out.println(file);
		FileInputStream inputstrem = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstrem);

		XSSFSheet sheet = workbook.getSheet("Logindata");

		int row_count = sheet.getLastRowNum();
		System.out.println("Total row is= " + row_count);

		for (int i = 1; i < row_count + 1; i++) {
			String username = sheet.getRow(i).getCell(0).getStringCellValue();

			String password = sheet.getRow(i).getCell(1).getStringCellValue();
						
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
			
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			driver.findElement(By.xpath("//span[contains(text(),'SIGN IN')]")).click();
			Thread.sleep(5000);
			String result = null;
		
			try {
				Thread.sleep(5000);
				//driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]/div[3]/div[1]/span[3]/a[1]/img[1]")).click();
				Boolean Islogied = driver.findElement(By.xpath("//span[contains(text(),'Getting started with Indyfin')]")).isDisplayed();
				//System.out.println(Islogied);
				if (Islogied == true) {

					result = "Pass";

				}
				System.out.println("User name= " + username + " | " + "password is= " + password + "---> Login Status " + result);
				
				Thread.sleep(4000);
				driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]/div[3]/div[1]/span[3]/a[1]/img[1]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
					
			} catch (Exception e) {
				Thread.sleep(1000);
				Boolean IsError = driver.findElement(By.xpath("//div[@class='v-snack__content']")).isEnabled();
				if (IsError == true) {

					result = "Fail";
				}
				System.out.println("User name= " + username + " | " + "password is= " + password + "---> Login Status " + result);			
				driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
			}
			Thread.sleep(1000);
			
		}		
		workbook.close();
		driver.close();
	}
	
}
