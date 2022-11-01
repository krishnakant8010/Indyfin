package Indyfin_Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Indyfin_Signup {

	private static final boolean Flase = false;
	WebDriver driver;

	@Test(priority=1,enabled=Flase)
	public void logindata() throws IOException, Exception {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Keys.chord(Keys.CONTROL.SHIFT,"i"));
		driver.get("https://stage.indyfin.com/#/sign-up");
		//driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		File file = new File("Data\\indyfinNewUser.xlsx");

		// System.out.println(file);
		FileInputStream inputstrem = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstrem);

		XSSFSheet sheet = workbook.getSheet("Signup");
	
		int row_count = sheet.getLastRowNum();
		System.out.println("Total row is= " + row_count);

		for (int i = 37; i < row_count + 1; i++) {
			int Testid = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
			String firstname = sheet.getRow(i).getCell(1).getStringCellValue();
			String lastname = sheet.getRow(i).getCell(2).getStringCellValue();
			String email = sheet.getRow(i).getCell(3).getStringCellValue();
			String phone = sheet.getRow(i).getCell(4).getStringCellValue();
			String password = sheet.getRow(i).getCell(5).getStringCellValue();	
						
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);	
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys(phone);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			driver.findElement(By.xpath("//div[@class='v-input--selection-controls__ripple']")).click();
			
			driver.findElement(By.xpath("//span[contains(text(),'JOIN INDYFIN')]")).click();	
			
			Thread.sleep(5000);
			String result = null;
			try {
				Thread.sleep(4000);
				//driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]/div[3]/div[1]/span[3]/a[1]/img[1]")).click();
				Boolean Islogied = driver.findElement(By.xpath("//h1[@class='heading']")).isDisplayed();
				//System.out.println(Islogied);
				if (Islogied == true) {

					result = "Pass";

				}
				System.out.println("First Row Data= " + Testid + " | " + "---> Signup Status " + result);
				
				Thread.sleep(2000);
				driver.navigate().refresh();
				
				
			} catch (Exception e) {
				Thread.sleep(2000);
				Boolean IsError = driver.findElement(By.xpath("//b[contains(text(),'An account with the given email already exists.')]")).isEnabled();
				if (IsError == true) {

					result = "Fail";
				}
				System.out.println("First Row Data= " + Testid + " | " + "---> Signup Status " + result);			
				driver.navigate().refresh();	
			}
			Thread.sleep(1000);
			
		}
		workbook.close();
		driver.close();
	}
	@Test(priority=2)
	public void Signup_with_OTP() throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Keys.chord(Keys.CONTROL.SHIFT,"i"));
		driver.get("https://stage.indyfin.com/#/sign-up");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		File file = new File("Data\\indyfinNewUser.xlsx");

		// System.out.println(file);
		FileInputStream inputstrem = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstrem);
		XSSFSheet sheet = workbook.getSheet("Signup");
		int row_count = sheet.getLastRowNum();
		System.out.println("Total row is= " + row_count);
		for (int i =48 ; i < row_count + 1; i++) {
			String email = sheet.getRow(i).getCell(3).getStringCellValue();
			System.out.println(email);
			String password = sheet.getRow(i).getCell(5).getStringCellValue();
			System.out.println(password);
			int OTP1 = (int) sheet.getRow(i).getCell(6).getNumericCellValue();
			System.out.println(OTP1);
			//String OTP2 = sheet.getRow(i).getCell(6).getStringCellValue();
			
			//System.out.println(OTP);
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			driver.findElement(By.xpath("//span[contains(text(),'SIGN IN')]")).click();
			Thread.sleep(2000);
			
			
			
			try {
				
				if (driver.findElement(By.xpath("//h1[contains(text(),'Confirm account')]")).isDisplayed()){
					driver.findElement(By.xpath("//input[@placeholder='Verification Code']")).sendKeys(Integer.toString(OTP1));
					//driver.findElement(By.xpath("//input[@placeholder='Verification Code']")).sendKeys(OTP2);
					driver.findElement(By.xpath("//span[@class='v-btn__content']")).click();
					Thread.sleep(5000);
					}
				Thread.sleep(5000);
				//System.out.println("Verrification page");
				//driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]/div[3]/div[1]/span[3]/a[1]/img[1]")).click();
				Boolean Is_OTP_matched = driver.findElement(By.xpath("//div[@class='v-snack__content']")).isDisplayed();
				//System.out.println(Is_OTP_matched);
				if (Is_OTP_matched == true) {

					driver.navigate().refresh();
				}
				else{
					Thread.sleep(6000);
					driver.findElement(By.xpath("//span[contains(text(),'Get Started')]")).click();
					Thread.sleep(2000);
					Boolean Islogied = driver.findElement(By.xpath("//span[contains(text(),'Getting started with Indyfin')]")).isDisplayed();
					//System.out.println(Islogied);
					if (Islogied == true) {

						Thread.sleep(5000);
						driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]/div[3]/div[1]/span[3]/a[1]/img[1]")).click();
						driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();

					}
				}
				
				
			} catch (Exception e) {
				
				Thread.sleep(4000);
				driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]/div[3]/div[1]/span[3]/a[1]/img[1]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
				//Boolean Islogied = driver.findElement(By.xpath("//span[contains(text(),'Getting started with Indyfin')]")).isDisplayed();
				System.out.println("llllll");
				Thread.sleep(1000);
	
			}
			Thread.sleep(1000);
			
		}
		workbook.close();
		driver.close();
	}
}
