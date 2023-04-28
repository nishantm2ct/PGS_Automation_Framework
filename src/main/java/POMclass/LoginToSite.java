package POMclass;

import java.io.IOException;
import java.rmi.server.UID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base_Utility_CommonFunctions.BaseClass;


public class LoginToSite extends BaseClass

{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@type='email']") private WebElement Email;
	
	@FindBy(xpath="//input[@id='passwordInput']") private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']") private WebElement submit;
	
	@FindBy(xpath="//span[@id='submitButton']") private WebElement loginButton;

	
	public LoginToSite (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String enterLoginPage1userID(String userid) 
	{
		Email.sendKeys(userid);
		
		return userid;
	}

	
	public void clickLoginPage1login()
	{
		submit.click();
		
	}
	
	public String EnterPasswordForPGS(String pwd)
	{
		password.sendKeys(pwd);
		
		return pwd;
		
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
		
	}
	

	
}


