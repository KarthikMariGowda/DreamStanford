
  package com.dreamorbit.pages;
  
  import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
  import org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory;
  
  public class ParticipantPage {
  
  @FindBy(xpath="//a[.='Personal']/ancestor::div[2]//div[2]/div[2]//img[@class='img-responsive eye-icon']")// Declaration private WebElement fileJson;
  private WebElement fileJson;
  
  
  
  public ParticipantPage(WebDriver driver)//Initialization to handle stale element exception
	{
		PageFactory.initElements(driver,this);
	}
  
  
  public void fileJsonClick()
  { 
	  fileJson.click();//Utilization methods } }
  }
  }
 