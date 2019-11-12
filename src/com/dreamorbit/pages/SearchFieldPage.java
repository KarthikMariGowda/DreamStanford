package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFieldPage

{
	//Declaration
	@FindBy(xpath = "//form/a[1]")
	private WebElement searchClearBTN;

	@FindBy(xpath = "//form/a[2]")
	private WebElement searchBTN;


	

	public SearchFieldPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void searchClearBTNClick()// Utilization methods
	{
		searchClearBTN.click();
	}
	
	
	public void searchBTNClick() {
		searchBTN.click();
	}
	
}
