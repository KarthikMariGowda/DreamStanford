package com.dreamorbit.generic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;

public abstract class FWUtils implements IAutoConstant
{
	
	public static void verifyPage(WebDriver driver,String eURL)
	{
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		wait.until(ExpectedConditions.urlToBe(eURL));
		String aURL=driver.getCurrentUrl();
		System.out.println("Actual URL of the Page is :"+aURL);
		
		try {
			AssertJUnit.assertEquals(aURL, eURL);
			Reporter.log("Login testcase with valid data is passed");
		} 
		catch (AssertionError e) {
			Reporter.log("The Expected Page URL\" +eURL+ \"is not Dispalyed");
			AssertJUnit.fail();
		}
		
	}
	
	
	public  String read_XL_Data(String path,String sheet,int r,int c) 
	{
		String s="";
		try
		{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		s = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	public int xl_RowCount(String path,String sheet)  
	{
		int c=0;
		try
		{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		 c = wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 return c;
	}

}
