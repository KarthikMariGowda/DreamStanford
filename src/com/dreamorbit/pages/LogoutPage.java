package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
	@FindBy(xpath="//img[@title='Logout']")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//button[.='Logout']")// Declaration
	private WebElement logoutConfirm;
	
	@FindBy(xpath="//button[.='Cancel']")
	private WebElement logoutCancel;
	
	
	

	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);//Initialization
	}
	
	
	
	public void logoutBTNClick()
	{
		logoutBTN.click();
	}
	
	public void logoutConfirmClick()//Utilization methods
	{
		logoutConfirm.click();
	}
	
	public void logoutCancelClick()
	{
		logoutCancel.click();
	}
	
	
	
}
