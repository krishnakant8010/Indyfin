package Indyfin_Testcase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");				

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://indyfin.com/financial-advisor/massachusetts/");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total Links are : " +links.size());
		
		for(int i=0;i<links.size();i++) {
			WebElement ele=links.get(i);
			//System.out.println(ele);
			String url=ele.getAttribute("href");
			VerifyLinkActive(url);
		}
		driver.quit();
	}

	public static void VerifyLinkActive(String linkUrl) {
	
		try {
			URL urll=new URL(linkUrl);
			HttpURLConnection httpURLConnect=(HttpURLConnection)urll.openConnection();
		
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			
			if(httpURLConnect.getResponseCode()==200) {
				System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage());
			}
			if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage() + "-" + HttpURLConnection.HTTP_NOT_FOUND);
			}
					
		}catch (Exception e) {
			}
		}
}
