package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudiesPage {
	

		@FindBy(xpath= "//span[.='Total Participants']")// Declaration
		private WebElement totalParticpantLabel;
		
		@FindBy(xpath="//span[.='Total Fellow Researchers']")
		private WebElement totalFellowResearcher;
		
		
		
	
		public StudiesPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void particpantLabelClick()//Utilization methods
		{
			totalParticpantLabel.click();
		}
		
		public void totalFellowResearcherClick()
		{
			totalFellowResearcher.click();
		}
		
		
		

	}



}
