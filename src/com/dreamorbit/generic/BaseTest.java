package com.dreamorbit.generic;//latest
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends FWUtils 
{
	public static WebDriver driver;
	
	
	static 
	{
		System.setProperty(CHROM_KEY, CHROM_VALUE);
	}
	
	
@BeforeMethod
public void launchAPP() 
{
	 	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);		
}


@AfterMethod
public void closeApp()
{
	driver.quit();
}


}
	
	


