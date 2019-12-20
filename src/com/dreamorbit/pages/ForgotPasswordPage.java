package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage 
{
	//Declaration
@FindBy(xpath="//input[@type='text']")
private WebElement EmailField;

@FindBy(xpath="//div[@id='submit']")
private WebElement FpSubmit;

@FindBy(xpath="//a[.=\"Login?\"]")
private WebElement FpLogin;


//Initialization to handle stale element exception
public ForgotPasswordPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}



//Utilization methods
public void sendEmail(String testEmails)
{
	EmailField.sendKeys(testEmails);
}

public void clearEmail()
{
	EmailField.clear();
}

public void FpSubmitClick()
{
	
	FpSubmit.click();
}

public Boolean FpSubmitIsEnabled()
{
	Boolean status= FpSubmit.isEnabled();
	return status;
}

public void fpLoginClick()
{
	FpLogin.click();
}
}
