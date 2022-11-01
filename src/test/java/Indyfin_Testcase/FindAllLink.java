package Indyfin_Testcase;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindAllLink {
	

	@Test
	public void Findlink() {
		
		String baseUrl = "https://indyfin.com/";					
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");				
        WebDriver driver = new ChromeDriver();	
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
        //find all number of url 
        List<WebElement> linkNames =driver.findElements(By.tagName("a"));
        System.out.println("The Cound of links are " + linkNames.size());
        
       // Print the all url link
		for(int i=0;i<linkNames.size();i++)
		{
        	//String links= linkNames.get(i).getText();
        	System.out.println("Link name : " + linkNames.get(i).getAttribute("href"));
			//System.out.println("link name" +linkNames.get(i).getText());
			//int i;
			//System.out.println("Link name : " + linkNames.get();
		}
		driver.quit();
	}

}
