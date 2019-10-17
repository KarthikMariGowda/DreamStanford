package com.dreamorbit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{
	@FindBy(xpath= "//input[@type='text']")// Declaration
	private WebElement unTB;
	
	@FindBy(id= "userPassword")
	private WebElement pwdTB;
	
	@FindBy(xpath= "//button[.='Login']")
	private WebElement lgnBTN;
	
	/*
	 * @FindBy(className="toast-message")
	 * //driver.findElement(By.className("toast-message")) private WebElement
	 * WarningMSG;
	 */

	
	
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
	
	
	

}

