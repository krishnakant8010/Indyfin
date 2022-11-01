package Indyfin_Testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Store;

import com.testing.framework.EmailUtils;

public class Get_gmail_otp {

	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
		EmailUtils emailUtils=new EmailUtils();
		Properties prop=new Properties ();
		prop.load(new FileInputStream("C:\\Users\\CL-009\\eclipse-workspace\\Indyfin\\config\\Config1_setup.txt"));
		Store connection=emailUtils.connectToGmail(prop);
		
		
		//emailUtils.getUnreadMessages(connection, "Inbox");
		
		List<String> emailtext=emailUtils.getUnreadMessageByFromEmail(connection, "Inbox", "krishnakant@colaborarlabs.com", "Advisor Platform Verification Code");
		
		if(emailtext.size()<1) {
			throw new Exception("No Emial Rechived");
			
		}else {
			String regex="[^\\d]+";
			String[] OTP=emailtext.get(0).split(regex);
			System.out.println("OTP is:" + OTP[1]);
		}
	}

}
