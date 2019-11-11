package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResearcherPage {
	@FindBy(xpath = "//button[@id='insert-more']") // Declaration
	private WebElement addResearcher;

	@FindBy(xpath = "//input[@name=\"rsSearch\"]")
	private WebElement researcherSearchField;

	@FindBy(xpath = "//input[@placeholder=\"enter email address\"]")
	private WebElement EmailAddressTB;

	@FindBy(xpath = "//img[@src='assets/images/ic_save.png']")
	private WebElement tickButton;

	@FindBy(xpath = "//img[@src='assets/images/ic_remove.png']")
	private WebElement crossButton;

	
	
	
	
	public ResearcherPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

	public void addResearcherClick()// Utilization methods
	{
		addResearcher.click();
	}
	
	
	public void inputsearchResearcherField(String searchParameter) {
		researcherSearchField.sendKeys(searchParameter);
	}

	public void setEmailAddress(String researcherEmail) 
	{
		EmailAddressTB.sendKeys(researcherEmail);
	}

	public void tickButtonClick() {
		tickButton.click();
	}

	public void crossButtonClick() {
		crossButton.click();
	}
}
