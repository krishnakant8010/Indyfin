package Indyfin_Testcase;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Indyfin_Profile extends Login {
//ChromeDriver driver=null;

	@Test
	public void NavigateToProfile() throws IOException, InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='menu-content']//div[3]//ul//li[1]")).click();
		String expectedTitle = "https://stage.indyfin.com/#/profile";
		if (driver.getCurrentUrl() != null && driver.getCurrentUrl().contains(expectedTitle)) {
			System.out.println("Web page is opened");
		} else {
			System.out.println("Web page could not open.");
		}
	}

	@Test(dependsOnMethods="NavigateToProfile")
	public void Update_Profile_data() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@class='v-text-field__slot']//textarea")).click();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		  String datetime=dtf.format(now);
		   
		driver.findElement(By.xpath("//div[@class='v-text-field__slot']//textarea")).sendKeys("\n" + " Update Date and time :- " + datetime);
		Thread.sleep(1000);
		
//		Thread.sleep(5000);
//		driver.navigate().refresh();
		
		// method Keys.chord
	      String n = Keys.chord(Keys.CONTROL, Keys.ENTER);
	      //open link in new tab
	      driver.findElement(By.xpath("//div[@class='v-card__actions actionSection']//button[2]")).sendKeys(n);
	      Thread.sleep(8000);
	      // store window handle ids
	      ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
	      //switch to open tab
	      driver.switchTo().window(w.get(1));
	      System.out.println("New tab title: " + driver.getTitle());
	      Thread.sleep(5000);
	      driver.navigate().refresh();
	      Thread.sleep(3000);
	      driver.navigate().refresh();
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	        //Scroll down till the bottom of the page
	        js.executeScript("window.scrollBy(100,document.body.scrollHeight)");
	        String t = "Read More";
	        List<WebElement> l= driver.findElements(By.xpath("//button[@id='about_read_more']"));
	        // verify list size
	        if ( l.size() > 0){
	           System.out.println("Text: " + t + " is present. ");
	           driver.findElement(By.id("about_read_more")).click();
	        } else {
	           System.out.println("Text: " + t + " is not present. ");
	        }
	        
	      // driver.findElement(By.xpath("//button[@id='about_read_more']")).click();
	       driver.quit();
	     
	      //switch to first tab
	      driver.switchTo().window(w.get(0));
	      //System.out.println("First tab title: " + driver.getTitle());
	     // Update media tab
	      driver.findElement(By.xpath("//ul[@class='lists']//li[6]")).click();
	      
	      
	      
	     
	      
	   }
	
}
