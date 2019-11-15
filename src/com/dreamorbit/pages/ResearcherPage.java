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
	
	@FindBy(xpath = "//*[@id=\"first-row\"]/td[2]")
	private WebElement firstRowREmail;
	

	
	
	public ResearcherPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

	public void addResearcherClick()// Utilization methods
	{
		addResearcher.click();
	}
	
	public String getTextRSearch()//fetches the text from researcher search field 
	{
		String textInSearch= researcherSearchField.getAttribute("ng-reflect-model");
		return textInSearch;
	}
	
	public void inputsearchResearcherField(String searchParameter) {
		researcherSearchField.sendKeys(searchParameter);
	}

	public void setEmailAddress(String researcherEmail) 
	{
		EmailAddressTB.sendKeys(researcherEmail);
	}

	public void clearEmailAddress() 
	{
		EmailAddressTB.clear();
	}

	
	public void tickButtonClick() {
		tickButton.click();
	}

	public void crossButtonClick() {
		crossButton.click();
	}
	
	public String getfirstRowREmail() //gets first row researcher email ID
	{
		String topRowEmailID =firstRowREmail.getText();
		return topRowEmailID;
	}

	
}
