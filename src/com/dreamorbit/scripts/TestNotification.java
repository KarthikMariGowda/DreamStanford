package com.dreamorbit.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.ParticipantListPage;
import com.dreamorbit.pages.StudiesPage;
import com.dreamorbit.pages.SymmetricKeyPage;

public class TestNotification extends BaseTest {

	@Test(priority = 23, enabled = true)
	public void setNotification() throws InterruptedException {

		Commons commons = new Commons();
		StudiesPage studiesPage = new StudiesPage(driver);
		

		commons.login(driver);
		commons.studiesScreenWait(driver);
		Thread.sleep(9000);
		studiesPage.scheduleNotificationBTNClick();
		Thread.sleep(5000);
		
		
		
		//ACTIVITY
		
		driver.findElement(By.xpath("//mat-dialog-content/div/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")).click();
		Thread.sleep(8000);

		List<WebElement> activityMenu =driver.findElements(By.xpath("//span[contains(@class,'mat-option-text')]"));
			
																											
		for (int i = 0; i < activityMenu.size(); i++)
		{
			System.out.println(activityMenu.size());
			
			WebElement aOption = activityMenu.get(i);
			String innerhtml = aOption.getAttribute("innerHTML");
			System.out.println(innerhtml);
			
			
			if (innerhtml.contains("6 Minute Walk Test"))
			{
				aOption.click();
				break;

			}

		}
		//SCHEDULE
		
		
		driver.findElement(By.xpath("//mat-dialog-content/div/div[2]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")).click();
		Thread.sleep(8000);
		
		
		List<WebElement> scheduleMenu =driver.findElements(By.xpath("//span[contains(@class,'mat-option-text')]"));
	
																								
	for (int i = 0; i < scheduleMenu.size(); i++)
	{
	System.out.println(scheduleMenu.size());

	WebElement sOption = scheduleMenu.get(i);
	String innerhtml = sOption.getAttribute("innerHTML");
	System.out.println(innerhtml);


	if (innerhtml.contains("Weekly"))
	{
		sOption.click();
		break;

	}

	}


//DAYS
	
	driver.findElement(By.xpath("//mat-dialog-content/div/div[3]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")).click();
	Thread.sleep(8000);
	
	
	List<WebElement> daysMenu =driver.findElements(By.xpath("//span[contains(@class,'mat-option-text')]"));
	for (int i = 0; i < scheduleMenu.size(); i++)
{
System.out.println(daysMenu.size());

WebElement dOption = daysMenu.get(i);
String innerhtml = dOption.getAttribute("innerHTML");
System.out.println(innerhtml);


if (innerhtml.contains("Friday"))
{
	dOption.click();
	break;

}

}

Thread.sleep(5000);
}


		
	}

	


	
	