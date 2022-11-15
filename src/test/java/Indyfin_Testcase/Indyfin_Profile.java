package Indyfin_Testcase;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Indyfin_Profile {
//ChromeDriver driver=null;

	public static WebDriver driver;
@Test
public void Update_Indyfin_Profile() throws IOException {
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
	
	
	//ChromeOptions option=new ChromeOptions();
//	option.setPageLoadStrategy(PageLoadStrategy.EAGER);
//	option.addArguments("imcognito");
//	option.addArguments("start-maximized");
//	driver = new ChromeDriver(option);
	
	driver=WebDriverManager.chromedriver().create();
	driver.manage().window().maximize(); 
	driver.get("https://stage.indyfin.com/#/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	
	//get screen shot code below
	WebElement screen1=driver.findElement(By.className("c-form"));
	File source =screen1.getScreenshotAs(OutputType.FILE);
	File destination=new File(System.getProperty("user.dir") + "\\test-output\\Screenshort\\screenshor1.png");
	
	FileHandler.copy(source, destination);
}	
}
