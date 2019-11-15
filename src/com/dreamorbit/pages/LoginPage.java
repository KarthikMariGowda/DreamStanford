package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath= "//input[@type='text']")// Declaration
	private WebElement unTB;
	
	@FindBy(id= "userPassword")
	private WebElement pwdTB;
	
	@FindBy(xpath= "//button[.='Login']")
	private WebElement lgnBTN;
	
	@FindBy(xpath="//a[.=\"Forgot Password?\"]")
	private WebElement forgotPwd;
	
	@FindBy(xpath="//input[@id='userPassword']")
	private WebElement pwdField;
	
	@FindBy(xpath="//span[@id='showhide']")
	private WebElement showHideBTN;

	
	public LoginPage(WebDriver driver)//Initialization to handle stale element exception
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void setUN(String un)//Utilization methods
	{
		unTB.sendKeys(un);
	}
	
	public void clrUN()
	{
		unTB.clear();
	}
	
	public void setPWD(String pwd)
	{
		pwdTB.sendKeys(pwd);
	}
	
	public void clrPWD()
	{
		pwdTB.clear();
	}
	
	public void clickLogin()
	{
		lgnBTN.click();
	}
	
	public void clickForgotPwd()
	{
		forgotPwd.click();
	}
	
	public void clickShowHide()
	{
	showHideBTN.click();
	}
	
	public boolean showHideState()
	  {
		  String typeStatus =pwdField.getAttribute("type");
				  if((typeStatus.contains("password")))
				  {
					  return true;//when password is hidden
				  }
				  else {
					  return false;//When password is showing/Visible
				  }
	  }
	  
}

