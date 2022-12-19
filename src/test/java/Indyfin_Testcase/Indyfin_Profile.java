package Indyfin_Testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Indyfin_Profile extends Login {
//ChromeDriver driver=null;

	@Test
	public void NavigateToProfile() throws IOException, InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='menu-content']//div[3]//ul//li[1]")).click();
		String expectedTitle = "https://stage.indyfin.com/#/profile";
		if (driver.getCurrentUrl() != null && driver.getCurrentUrl().contains(expectedTitle)) {
			System.out.println("Web page is opened");
		} else {
			System.out.println("Web page could not open.");
		}
	}

	@Test(dependsOnMethods = "NavigateToProfile")
	public void Update_Profile_data() throws InterruptedException, AWTException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@class='v-text-field__slot']//textarea[1]")).click();

		Actions builder = new Actions(driver);

		WebElement Element = driver.findElement(By.xpath("//div[@class='v-text-field__slot']//textarea[1]"));

		builder.moveToElement(Element, -10, -10).click().build().perform();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime = dtf.format(now);

		driver.findElement(By.xpath("//div[@class='v-text-field__slot']//textarea"))
				.sendKeys("\n" + " Update Date and time :- " + datetime);
		Thread.sleep(1000);

		// method Keys.chord
		String n = Keys.chord(Keys.CONTROL, Keys.ENTER);
		// open link in new tab
		driver.findElement(By.xpath("//div[@class='v-card__actions actionSection']//button[2]")).sendKeys(n);
		Thread.sleep(8000);
		// store window handle ids
		ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
		// switch to open tab
		driver.switchTo().window(w.get(1));
		System.out.println("New tab title: " + driver.getTitle());
		Thread.sleep(8000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(5000);

		String Update_Word = datetime;

		if (driver.getPageSource().contains(Update_Word))
			System.out.println("Text is present in the page");
		else
			System.err.println("Text is not present in the page");
		Thread.sleep(5000);

		// switch to first tab
		driver.switchTo().window(w.get(0));
		// System.out.println("First tab title: " + driver.getTitle());

		//Update profile pic
		//https://www.youtube.com/watch?v=hLb7FlcRtCU
		driver.findElement(By.xpath("//button[@class='custom-btn v-btn v-btn--is-elevated v-btn--has-bg v-btn--rounded theme--light v-size--default']")).click();
		driver.findElement(By.xpath("//div[@class='vicp-drop-area']")).click();
		
		 Robot robot = new Robot();
		 Thread.sleep(1000); 
		 
		// Specify the file location with extension
		 StringSelection sel = new StringSelection("C:\\Users\\CL-009\\OneDrive\\Desktop\\Images\\images123.jpg");
		 // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		   
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		
		 // Release Enter
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(1000);
		        
		    //     Press Enter 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='vicp-operate']//a[2]")).click();
		Thread.sleep(2000);
		
		
		// Update media tab
//		driver.findElement(By.xpath("//ul[@class='lists']//li[6]")).click();
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//ul[@class='toggleBoxCustom']//li[4]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//section[@id='editMediaSection']//img")).click();
		

	}
 
}
