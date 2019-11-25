package com.dreamorbit.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScheduleNotificationPage 
{
	//mat-dialog-container[@class='mat-dialog-container ng-tns-c5-8 ng-trigger ng-trigger-slideDialog']
	@FindBy(xpath= "//mat-dialog-container[@class='mat-dialog-container ng-tns-c5-8 ng-trigger ng-trigger-slideDialog']")// Declaration
	private WebElement AlertBox;
	
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
		days.click();
	}

	/*
	 * String ariadisabledstate = days.getAttribute("aria-disabled");
	 * System.out.println(ariadisabledstate); return ariadisabledstate;
	 */
	public boolean chkDaysDDIsEnabled() throws InterruptedException
	{
		boolean dayFiledstate = days.isSelected();
		return dayFiledstate;
	}
	
	public void sendTime() throws AWTException, InterruptedException
	{
		time.click();
		 Robot robot = new Robot();      
		    robot.delay(2000);
		    robot.keyPress(KeyEvent.VK_1);
		    robot.keyRelease(KeyEvent.VK_1);
		    robot.keyPress(KeyEvent.VK_2);
		    robot.keyPress(KeyEvent.VK_2);
		    robot.keyPress(KeyEvent.VK_0);
		    robot.keyRelease(KeyEvent.VK_0);
		    Thread.sleep(3000);
		    robot.keyPress(KeyEvent.VK_A);
		    robot.keyRelease(KeyEvent.VK_A);
	}
	
	
	public void saveSNclick()
	{
		sNsaveBTN.click();
	}
	
	public void CancelSNclick()
	{
		sNcancelBTN.click();
	}
	
	
		public boolean isSavedisplayed() 
		{ 
		    try 
		    { 
		    	sNsaveBTN.isDisplayed();
		        return true; 
		    }   
		    catch (Exception $e) //global handler
		    { 
		        return false; 
		    }   // catch 
		}   // isAlertPresent()
	
	}

	
	
	
	

