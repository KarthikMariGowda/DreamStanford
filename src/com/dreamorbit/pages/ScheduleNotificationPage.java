package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScheduleNotificationPage 
{
	
	@FindBy(xpath= "//input[@type='text']")// Declaration
	private WebElement activity;
	
	@FindBy(id= "userPassword")
	private WebElement schedule;
	
	@FindBy(xpath= "//button[.='Login']")
	private WebElement days;
	
	@FindBy(xpath="//mat-dialog-content/div/div[4]/mat-form-field/div/div[1]/div")
	private WebElement time;
	
	@FindBy(xpath="//input[@id='userPassword']")
	private WebElement sNsaveBTN;
	
	@FindBy(xpath="//span[@id='showhide']")
	private WebElement sNcancelBTN;

	
	public ScheduleNotificationPage(WebDriver driver)//Initialization to handle stale element exception
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
	


	
	
	
	
}
