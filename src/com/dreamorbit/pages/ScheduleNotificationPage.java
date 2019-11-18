package com.dreamorbit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScheduleNotificationPage 
{
	
	@FindBy(xpath= "//mat-dialog-content/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")// Declaration
	private WebElement activity;
	
	@FindBy(xpath= "//mat-dialog-content/div/div[2]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")
	private WebElement schedule;
	
	@FindBy(xpath= "//mat-dialog-content/div/div[3]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")
	private WebElement days;
	
	@FindBy(xpath="//mat-dialog-content/div/div[4]/mat-form-field/div/div[1]/div")
	private WebElement time;
	
	@FindBy(xpath="//span[.='Save']")
	private WebElement sNsaveBTN;
	
	@FindBy(xpath="//span[.='Cancel']")
	private WebElement sNcancelBTN;

	
	public ScheduleNotificationPage(WebDriver driver)//Initialization to handle stale element exception
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void activityDropDownClick()
	{
		activity.click();
	}
	
	public void scheduleDropdownClick()
	{
		schedule.click();
	}
	
	public void daysDropdownClick()
	{
		schedule.click();
	}
	
	public void timeClick()
	{
		time.click();
	}
	
	public void sendTime()
	{
		time.sendKeys("1256PM");
	}
	
	public void saveSNclick()
	{
		sNsaveBTN.click();
	}
	
	public void CancelSNclick()
	{
		sNsaveBTN.click();
	}
	

	
	
	
	
}
