package com.dreamorbit.pages;


	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class StudiesPage {
		

			@FindBy(xpath="//*[@id=\"page-wrapper\"]/div/div[2]/div/div/app-studies/div[2]/div/table/tbody/tr/td[5]/ui-switch/span")// Declaration
			private WebElement verifyToken;
			
			@FindBy(xpath="//span[.='Total Fellow Researchers']")
			private WebElement totalFellowResearcher;
			
			
			
		
			public StudiesPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			
			
			public void verifyTokenClick()//Utilization methods
			{
				verifyToken.click();
			}
			
			public void totalFellowResearcherClick()
			{
				totalFellowResearcher.click();
			}
			
			
			

		}







