
  package com.dreamorbit.pages;
  
  import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
  import org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory;
  
  public class ParticipantPage {
  
  @FindBy(xpath="//a[.='Personal']/ancestor::div[2]//div[2]/div[2]//img[@class='img-responsive eye-icon']")// Declaration private WebElement fileJson;
  private WebElement fileJson;
  
  @FindBy(xpath="//a[.='Personal']")
  private WebElement personalTab;
  
  @FindBy(xpath="//a[.='View Uploads']")
  private WebElement viewUploadsTab;

  @FindBy(xpath="//button[.='Decrypt']")
  private WebElement decryptBTNPersonal;

  
  
  public ParticipantPage(WebDriver driver)//Initialization to handle stale element exception
	{
		PageFactory.initElements(driver,this);
	}
  
  
  
  
  public void fileJsonClick()
  { 
	  fileJson.click();//Utilization methods } }
  }
  
  public void personalTabClick()
  {
	  personalTab.click();
  }
  
  public void personalDecryptClick()
  {

  decryptBTNPersonal.click();
  }
  
  
  public Boolean personalTabiSSelected()
  {
	  String classValueAfter=personalTab.getAttribute("class");
			  if((classValueAfter.contains("active")))
			  {
				  return true;
			  }
			  else {
				  return false;
			  }
  }

  
  public Boolean viewUploadsTabiSSelected()
  {
	  String classValueAfter=viewUploadsTab.getAttribute("class");
			  if((classValueAfter.contains("active")))
			  {
				  return true;
			  }
			  else {
				  return false;
			  }
	
  
  
  
  }
  }
 