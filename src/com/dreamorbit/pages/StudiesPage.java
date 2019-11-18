package com.dreamorbit.pages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class StudiesPage {
		

			@FindBy(xpath="//*[@id=\"page-wrapper\"]/div/div[2]/div/div/app-studies/div[2]/div/table/tbody/tr/td[5]/ui-switch/span")// Declaration
			private WebElement verifyToken;
			
			
			
			@FindBy(xpath="//a[.='Participants']")
			private WebElement participantALink;
			
			@FindBy(xpath="//button[.='Schedule Notification']")
			private WebElement scheduleNotificationBTN;
			
			
		
			public StudiesPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			
			
			public void verifyTokenClick()//Utilization methods
			{
				verifyToken.click();
			}
			
			public void scheduleNotificationBTNClick()
			{
				scheduleNotificationBTN.click();
			}
			
			public void participantALinkClick()
			{
				participantALink.click();
			}
			
			public boolean verifyTokeBTNState()
			  {
				  String tokenStatus =verifyToken.getAttribute("class");
						  if((tokenStatus.contains("switch switch-small checked")))
						  {
							  return true;//when Verify token is ON
						  }
						  else {
							  return false;//when Verify token is OFF
						  }
			  }

		}







