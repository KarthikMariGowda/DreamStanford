package com.dreamorbit.pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ResetPasswordPage
	{

		@FindBy(xpath= "//img[@title='Change Password']")// Declaration
		private WebElement restPasswordButton;
		
		@FindBy(id= "currentPass")
		private WebElement currentPassword;
		
		@FindBy(id="newPass")
		private WebElement newPassword;
		
		@FindBy(id="confPass")
		private WebElement confirmPassword;
		
		@FindBy(id="FormSubmt")
		private WebElement ResetSubmit;
		
		
		

		public ResetPasswordPage(WebDriver driver)//Initialization to handle stale element exception
		{
			PageFactory.initElements(driver, this);
		}
		
				
		public void restButtonClick()//Utilization methods
		{
			restPasswordButton.click();;
		}
		
		public void sendCurrentPassword(String curntpwd)
		{
			currentPassword.sendKeys(curntpwd);
		}
		public void sendNewPassword(String newpwd )
		{
			newPassword.sendKeys(newpwd);
		}
		public void sendConfirmPassword(String confpwd)
		{
			confirmPassword.sendKeys(confpwd);
		}
		public void submitReset()
		{
			ResetSubmit.click();
		}
	}



