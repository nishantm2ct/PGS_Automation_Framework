package TestClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base_Utility_CommonFunctions.BaseClass;
import Base_Utility_CommonFunctions.UtilityClass;
import POMclass.HomePage;
import POMclass.LoginToSite;

public class TestLogin extends UtilityClass

{
	
	@BeforeTest
	public void m1() throws IOException
	{
		Login();
	}
	
	@AfterTest
	public void m3()
	{
		closeBrowser();
	} 
	
	@Test
	public void m2() throws IOException, InvalidFormatException, InterruptedException
	{
		
		
		LoginToSite login = new LoginToSite(driver);
		

		
	    String uid = getvalue(1, 0);
	     String pw = getvalue(1, 1);
	    
	    login.enterLoginPage1userID(uid);
	    
	    login.clickLoginPage1login();
	    
	    login.EnterPasswordForPGS(pw);
	    
	    login.clickOnLoginButton();
	    
	    login.clickLoginPage1login();
	    
	    Thread.sleep(5000);
	    

		
	//	login.enterLoginPage1userID(uid);
	
	//	login.clickLoginPage1login();
		
	//	captureScreenshot(driver, 2);
		

		

		
		
	}
	

}
