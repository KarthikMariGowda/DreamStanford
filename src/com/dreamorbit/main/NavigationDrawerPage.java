package com.dreamorbit.main;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	public class NavigationDrawerPage
	{
	
		
		//Declaration
	@FindBy(xpath="//span[.=\"Studies\"]")
	private WebElement nDStudies;

	@FindBy(xpath="//span[.=\"Researchers\"]")
	private WebElement nDResearchers;

	@FindBy(xpath="//span[.=\"Mobile App Ratings\"]")
	private WebElement nDRating;

	@FindBy(xpath="//span[.=\"Audit Researcher\"]")
	private WebElement nDAuditResearcher;

	//Initialization to handle stale element exception
	public NavigationDrawerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	//Utilization methods
	public void nDStudiesClick()
	{
		nDStudies.click();
	}

	public void nDResearchersClick()
	{
		nDResearchers.click();
	}
	public void nDRatingClick()
	{
		nDRating.click();
	}

	public void nDAuditResearcherClick()
	{
		nDAuditResearcher.click();
	}


		}


