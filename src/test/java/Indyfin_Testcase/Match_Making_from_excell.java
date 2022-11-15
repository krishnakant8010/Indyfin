package Indyfin_Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Match_Making_from_excell {

	public static WebDriver driver;

	@Test(priority=1)
	public void Match_making_Start() {
		// WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		// https://chromedriver.chromium.org/downloads
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stage-match.indyfin.com/");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=2)
	public void Lending_Page() {
		String Currect_URL = driver.getCurrentUrl();
		// String EXpect_URL="https://stage-match.indyfin.com/";

		if (Currect_URL.equals("https://stage-match.indyfin.com/")) {
			System.out.println("Match Making landing page is Pass");
		} else {
			System.out.println("Match Making landing page is fail");
		}
	}
	
	@Test(priority=1)
	public void Match_Advsior() throws IOException, Exception {

		File file = new File("Data\\Matching+value.xlsx");
		// System.out.println(file);
		FileInputStream inputstrem = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputstrem);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int row_count = sheet.getLastRowNum();	
		System.out.println("Total row of test case are = " + row_count);
		//XSSFRow row=sheet.getRow(0);
		for (int i = 1; i <= row_count; i++) {
			int TestCaseID = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
			String Topic =  sheet.getRow(i).getCell(1).getStringCellValue();	
			// System.out.println(Topic);
			String Age =  sheet.getRow(i).getCell(2).getStringCellValue();
			String income  = sheet.getRow(i).getCell(3).getStringCellValue();
			String Profession  = sheet.getRow(i).getCell(4).getStringCellValue();
			int ZipCode = (int) sheet.getRow(i).getCell(5).getNumericCellValue();
			String Investables = sheet.getRow(i).getCell(6).getStringCellValue();
			String FirstName = sheet.getRow(i).getCell(7).getStringCellValue();
			String LastName = sheet.getRow(i).getCell(8).getStringCellValue();
			String Email = sheet.getRow(i).getCell(9).getStringCellValue();
			String Phone =  sheet.getRow(i).getCell(10).getStringCellValue();
			List<String> results_first = new ArrayList();
	        for (int j=11;j<14;j++) {
	        	results_first.add(sheet.getRow(i).getCell(j).getStringCellValue());
		       }
		       String Excell_result=(Arrays.toString(results_first.toArray()));
		       
		       System.out.println("Expacted Advsior " + Excell_result);

			//Topic
			if(Topic != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(text(),'"+Topic+"')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'NEXT ')]")).click();
			}else {
				System.out.println("Topic not found");						
			}

			// For Age page
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='v-select__slot']")).click();
			if(Topic != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[contains(text(),'"+Age+"')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'NEXT ')]")).click();
			}else {
				System.out.println("Topic not found");						
			}
			// Income Value 
			if(income != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(text(),'"+income+"')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'NEXT ')]")).click();
			}else {
				System.out.println("Income not found");						
			}
			//Profession 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='v-select__slot']")).click();
			if(Profession  != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[contains(text(),'"+Profession+"')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'NEXT ')]")).click();
			}else {
				System.out.println("Income not found");						
			}
			//ZipCode
			if(String.valueOf(ZipCode)  != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Enter Your Zip Code']")).sendKeys(String.valueOf(ZipCode));
				Thread.sleep(10000);
				Boolean nextbutton =driver.findElement(By.xpath("//span[contains(text(),'NEXT')]")).isEnabled();
				if(nextbutton) {
					driver.findElement(By.xpath("//span[contains(text(),'NEXT')]")).click();
				}
				else {
					System.out.println("NO ! Element is not Present");
				}
			}else {
				System.out.println("ZipCode not found");						
			}
			//Investables 
			if(Investables  != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(text(),'"+Investables+"')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'NEXT ')]")).click();
			}else {
				System.out.println("Income not found");						
			}
			//FirstName			
			if(FirstName  != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
			}else {
				System.out.println("First Name not found");						
			}
			//LastName
			if(LastName  != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
			}else {
				System.out.println("Last Name not found");						
			}
			//Email 			
			if(Email  != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Email);
			}else {
				System.out.println("Email id not found");						
			}
			//Phone			
			if(Phone  != "") {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys(Phone);
			}else {
				System.out.println("Email id not found");						
			}
			driver.findElement(By.xpath("//span[contains(text(),'FIND MY MATCHES')]")).click();
			Thread.sleep(5000);

			// Check match advisor 	
			List<WebElement> Name = driver.findElements(By.xpath("//h5[@class='name']"));

			
			List<String> results_second = new ArrayList();
			for (WebElement webElement : Name) {
				results_second.add(webElement.getText());
				}
			String Web_result=(Arrays.toString(results_second.toArray()));
			System.out.println("Actual Advisor "+ Web_result);
			
			System.out.println("--------------------------------------------");
			
			List<String> common_elems = new ArrayList<String>(results_first);
			List<String> elems_not_in_list_2 = new ArrayList<String>(results_first);
			
			//System.out.println(secondList);  
			if(common_elems.size()>0) {
			System.out.println("Matched actual prostion Advisors");  
			System.out.println(common_elems);
			}
			
			elems_not_in_list_2.removeAll(results_second);     
			if(elems_not_in_list_2.size()>0) {
			System.out.println("Not Matched in actual position Advisors");  
			System.out.println(elems_not_in_list_2);
	      
			}
			System.out.println("--------------------------------------------");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//span[contains(text(),'START OVER')]")).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//h2[contains(text(),'Financial Topics')]")).isEnabled()) {
				System.out.println("TestCaseID " + TestCaseID + " is Passed");
			}else {
				System.out.println("TestCaseID " + TestCaseID + "is Not Passed, Something is wrong");
			}
		}

		workbook.close();
		driver.close();
	}
}