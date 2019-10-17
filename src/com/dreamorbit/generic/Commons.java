package com.dreamorbit.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dreamorbit.pages.LoginPage;

public class Commons implements IAutoConstant
{
	BaseTest baseTest= new BaseTest();
	public String getToastMSG(WebDriver driver) throws InterruptedException
	{
		WebElement toastBOX= driver.findElement(By.className("toast-message"));
		WebDriverWait ewait= new WebDriverWait(driver,10);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container"))); 
		String toastMSG =toastBOX.getAttribute("aria-label");
		/*
		 * WebDriverWait ewait= new WebDriverWait(driver,10);
		 * ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
		 * "toast-message"))); String errorMSG =
		 * WarningMSG.getAttribute("aria-label");// ="Invalid current password"
		 */		
		return toastMSG;

}
	
	public void studiesWait(WebDriver driver)
	{
		WebDriverWait ewait= new WebDriverWait(driver,ETO);
		ewait.until(ExpectedConditions.urlToBe(studyUrl));
	}
	
	
	public void login(WebDriver driver)
	{
		LoginPage loginPage= new LoginPage(driver);
		  String un = baseTest.read_XL_Data(XL_DATA_PATH,"ValidLoginData",1,0); 
		  String pwd =baseTest.read_XL_Data(XL_DATA_PATH,"ValidLoginData",1,1);
	
		  	loginPage.setUN(un);
		  	loginPage.setPWD(pwd);
		  	loginPage.clickLogin();
	}
}
