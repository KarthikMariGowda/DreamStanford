
package com.dreamorbit.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RatingPage {

	@FindBy(xpath = "//div[@class='cssload-speeding-wheel']")
	private WebElement loadingIcon;
	
	@FindBy(xpath = "//div[@class='offset-3 col-3 no-padding-right']")
	private WebElement aAVGRating;
	
	@FindBy(xpath = "//span[contains(.,'Based on')]")
	private WebElement aNoUsers;

	public RatingPage(WebDriver driver)// Initialization to handle stale element exception
	{
		PageFactory.initElements(driver, this);
	}

	public boolean lodingIconVisibility() {
	
		boolean loadingIconStatus = loadingIcon.isDisplayed();
		return loadingIconStatus;
	}
	
	public String aAvgRating()
	{
		String aAvgRate=aAVGRating.getText();
		return aAvgRate;
	}
	
	public String aNoUsersGetText()
	{
		String aNoUsersText=aNoUsers.getText();
		
		return aNoUsersText;
	}
}