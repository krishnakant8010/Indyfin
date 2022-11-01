package Indyfin_Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ExcelLogindata {

	WebDriver driver;
	@Test
	public void logindata() throws IOException, Exception {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://practice.automationtesting.in/");
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		File file = new File("Data\\InputData.xlsx");

		// System.out.println(file);
		FileInputStream inputstrem = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstrem);

		XSSFSheet sheet = workbook.getSheet("Logindata");

	XSSFRow row = null;
		XSSFCell cell = null;
		// String userName=null;
		// String passWord=null;
		int row_count = sheet.getLastRowNum();
		System.out.println("Total row is= " + row_count);

		for (int i = 1; i < row_count + 1; i++) {
			String username = sheet.getRow(i).getCell(0).getStringCellValue();

			String password = sheet.getRow(i).getCell(1).getStringCellValue();
			for (int j = 0; j < i; j++) {
				// System.out.println(value1);
			}

			

			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.name("login")).click();

			String result = null;
			try {
				Boolean Islogied = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/nav[1]/h3[1]/span[1]")).isDisplayed();
				//System.out.printlln(Islogied);
				if (Islogied == true) {

					result = "Pass";
////				//Write to an excel 
//				cell=row.createCell(2);
//				//cell.getCellType();
//				cell.setCellValue(result);
				}
				System.out.println("User name= " + username + " | " + "password is= " + password + "---> Login Success " + result);
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign out")).click();
				
			} catch (Exception e) {
				Boolean IsError = driver.findElement(By.xpath("//*[text()='Lost your password?']")).isDisplayed();
				if (IsError == true) {

					result = "Fail";
//					cell=row.createCell(2);
//					cell.getCellType();
//					cell.setCellValue(result);
				}

				System.out.println("User name= " + username + " | " + "password is= " + password + "---> Login Success " + result);
					driver.findElement(By.xpath("//input[@id='username']")).clear();
			}
			Thread.sleep(1000);
		}
//		FileOutputStream fos = new FileOutputStream(file);
//		workbook.write(fos);
//		fos.close();
		workbook.close();
		driver.close();
	}
}
