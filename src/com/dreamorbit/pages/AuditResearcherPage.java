package com.dreamorbit.pages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class AuditResearcherPage
	
	{
	@FindBy(xpath= "//th[.='Researcher Name']//following::tr[1]/td[2]")
	private WebElement firstRowAction;

	@FindBy(xpath= "//th[.='Researcher Name']//following::tr[2]/td[2]")
	private WebElement secondRowAction;

	@FindBy(xpath="//th[.='Researcher Name']//following::tr[3]/td[2]")
	private WebElement thirdRowAction;

	@FindBy(xpath="//th[.='Researcher Name']//following::tr[4]/td[2]")
	private WebElement fourthRowAction;

	@FindBy(xpath="//th[.='Researcher Name']//following::tr[5]/td[2]")
	private WebElement fifthtRowAction;


	public AuditResearcherPage(WebDriver driver)//Initialization to handle stale element exception
	{
	PageFactory.initElements(driver,this);
	}


	public String getFirstRowData()//Utilization methods
	{
	String firstRowText= firstRowAction.getText();
	return firstRowText;
	}

	public String getSecondRowData()//Utilization methods
	{
	String secondRowText= secondRowAction.getText();
	return secondRowText;
	}

	public String getThirdRowData()//Utilization methods
	{
	String thirdRowText= thirdRowAction.getText();
	return thirdRowText;
	}

	public String getFourthRowData()//Utilization methods
	{
	String fourthRowText= fourthRowAction.getText();
	return fourthRowText;
	}

	public String getFifthRowData()//Utilization methods
	{
	String fifthRowText= fifthtRowAction.getText();
	return fifthRowText;
	}


	

}
