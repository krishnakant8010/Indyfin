package Indyfin_Testcase;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPageObjects {

	private WebDriver driver;
	@FindBy(how=How.XPATH,xpath="//input[@id='identifierId']")
	WebElement emailField;
	
	@FindBy(how=How.XPATH,xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement passwordField;


	@FindBy(how=How.XPATH,xpath="//tbody/tr[@id=':1y']/td[@id=':24']/div[1]/div[1]/div[1]/span[1]/span[1]")
	
	List<WebElement> emailThreads;
	
	@FindBy(how=How.XPATH,xpath="//header/div[2]/div[1]/div[4]/div[1]/a[1]/img[1]")
	WebElement profileLogo;
	
	
	
	public GmailPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterEmail(String emailID) {
		waitForVisible(driver,emailField);
		Actions actions=new Actions(driver);
		actions.moveToElement(emailField);
		actions.click();
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
		System.out.println("Email entered");	
		}

	public void enterPassword(String password) {
		waitForVisible(driver,passwordField);
		Actions actions=new Actions(driver);
		actions.moveToElement(passwordField);
		actions.click();
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
		System.out.println("Password Entered");	
		}
	
	public void clickEmail(String emailSubject) {
		waitForVisible(driver, profileLogo);
		for(int i=0;i<emailThreads.size();i++) {
				if(emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("Enter click");
				break;
			}
		}
	}
	
	

	private void waitForVisible(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			System.out.println("Wait for element visibility");
			//@SuppressWarnings("deprecation")
			WebDriverWait wait=new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));		
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
	}
}

