package Indyfin_Testcase;

import org.testng.annotations.Test;

public class CloseBrowser extends Browser_Lunch{
	@Test
	public void CloseAPP() {
		driver.close();
	}
}
