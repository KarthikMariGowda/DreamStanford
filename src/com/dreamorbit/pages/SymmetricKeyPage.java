package com.dreamorbit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SymmetricKeyPage {

	@FindBy(id = "swalSymmetricKey")
	private WebElement textField_sKey;

	@FindBy(id = "isSave")
	private WebElement checkBox_saveSession;

	@FindBy(xpath = "//button[.='OK']")
	private WebElement button_sKeyOk;

	@FindBy(xpath = "//button[.='Cancel']")
	WebElement button_sKeycancel;

	@FindBy(xpath = "//div[.='Invalid key']")
	private WebElement warningMessInvalidKey;

	@FindBy(xpath = "//button[.='Copy and Deliver']")
	private WebElement copyNDeliverBTN;
	
	

	public SymmetricKeyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

	public void sendSymmetricKey(String key)
	{
		textField_sKey.sendKeys(key);
	}

	public void clearSymmetricKey() {
		textField_sKey.clear();
	}

	public void sK_clickOk() {
		button_sKeyOk.click();
	}

	public void sK_click_Cancel() {
		button_sKeyOk.click();
	}

	public boolean sk_warning_isDisplayed() {
		boolean res = warningMessInvalidKey.isDisplayed();
		return res;
	}
	public void copyNDeliverBTNClick()
	{
		copyNDeliverBTN.click();
	}
}