package com.dreamorbit.pages;
	
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ParticipantListPage
	{
		//Declaration
		@FindBy(xpath= "//th[.='No.']/ancestor::table/tbody[1]/tr[2]/td[4]/a[@class='text-upload']")
		private WebElement button_Uploads;//for top most uploads button
		
		@FindBy(xpath= "button[.='Decrypt']")
		private WebElement button_Decrypt;
		
		
		@FindBy(xpath="//i[@class='fa fa-angle-down']")
		private WebElement button_downArrow;
		
		
		
		//Initialization to handle stale element exception
		public ParticipantListPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		

		
		//Utilization methods
		public void clickUploads()
		{
			button_Uploads.click();
		}
			
		public void clickDecrypt()
		{
			button_Decrypt.click();
		}
		
		
		public void downArrowClick()
		{
			button_downArrow.click();
		}

		}
