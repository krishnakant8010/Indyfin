package Indyfin_Testcase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Advisor_Feedback extends Login{
	@Test(priority=1)
	public void loading_feedback_Page() throws Exception {
	Thread.sleep(10000);
	driver.findElement(By.xpath("//div[@class='menu-content']//div[3]//ul//li[2]")).click();
	String actualUrl2="https://stage.indyfin.com/#/feedback";
	String expectedUrl2= driver.getCurrentUrl();
	Assert.assertEquals(expectedUrl2,actualUrl2);
	Thread.sleep(5000);
	}
	
	@Test(priority=2,dependsOnMethods="loading_feedback_Page")
	public void All_Clinets_Page() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='text-right col'] //button[1]")).click();
		String actualUrl="https://stage.indyfin.com/#/feedback-clients";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
		Thread.sleep(5000);
	}
	
	@Test(priority=3,dependsOnMethods="All_Clinets_Page")
	public void Add_new_clinet() {
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/button[1]/span[1]")).click();
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Automation");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys("kant1");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/input[1]")).sendKeys("quality+automation@indyfin.com");
		
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]")).click();
		
		//b[contains(text(),'Client added successfully.')]
//		String expectedUrl = driver.findElement(By.xpath("//b[contains(text(),'Client added successfully.')]")).getText();;
//		String actualUrl="Client added successfully.";
//		
//		Assert.assertEquals(expectedUrl,actualUrl);
		
	}
	
	@Test(priority=4,dependsOnMethods="Add_new_clinet")
	public void Search_And_Update_Client() throws Exception {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Automation");
		
		String expectedUrl = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		
		String actualUrl="Automation";
		
		Assert.assertEquals(expectedUrl,actualUrl);
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/span[1]/div[1]/img[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

		Thread.sleep(3000);
	}
	
	@Test(priority=5,dependsOnMethods="Search_And_Update_Client")
	public void Send_Feedback_to_Client() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Automation");
		
		String expectedUrl = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		
		String actualUrl="Automation";
		
		Assert.assertEquals(expectedUrl,actualUrl);
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/span[1]/div[2]/img[1]")).click();
		
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=6,dependsOnMethods="Send_Feedback_to_Client" , enabled=false)
	public void Delete_Client() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Automation");
		
		String expectedUrl = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		
		String actualUrl="Automation";
		
		Assert.assertEquals(expectedUrl,actualUrl);
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[8]/span[1]/div[1]/img[1]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]")).click();
		
		
	}
}
