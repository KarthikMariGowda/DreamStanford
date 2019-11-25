package com.dreamorbit.scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.ScheduleNotificationPage;
import com.dreamorbit.pages.StudiesPage;

public class TestNotification extends BaseTest {

	@Test(priority = 23, enabled = false)
	public void setNotificationDaily() throws InterruptedException, AWTException {
		Commons commons = new Commons();
		StudiesPage studiesPage = new StudiesPage(driver);
		ScheduleNotificationPage scheduleNotificationPage = new ScheduleNotificationPage(driver);

		commons.login(driver);
		commons.studiesScreenWait(driver);
		Thread.sleep(7000);
		studiesPage.scheduleNotificationBTNClick();
		Thread.sleep(3000);

		// Verifies cancel button functionality in notification screen
		scheduleNotificationPage.CancelSNclick();
		Thread.sleep(2000);
		boolean notificationAlertStatus = scheduleNotificationPage.isSavedisplayed();
		//System.out.println(notificationAlertStatus);

		AssertJUnit.assertEquals(notificationAlertStatus,false);
		Reporter.log("Cancel button functionality in the Set Notification screen is working as expected- TestCase Passed",true);

		// ACTIVITY

		studiesPage.scheduleNotificationBTNClick();
		Thread.sleep(3000);
		scheduleNotificationPage.activityDropDownClick();
		Thread.sleep(3000);
		commons.selectActivity(driver);

		// SCHEDULE

		scheduleNotificationPage.scheduleDropdownClick();
		Thread.sleep(3000);
		commons.setSchedule(driver,"Daily");
		Thread.sleep(3000);

		boolean daysDropdownstate = scheduleNotificationPage.chkDaysDDIsEnabled();

		AssertJUnit.assertEquals(daysDropdownstate, false);
		Reporter.log("Days drop down is disabled on daily schedule selection-Test case passed ", true);
		
		Thread.sleep(3000);
		scheduleNotificationPage.sendTime();
		Thread.sleep(2000);

		scheduleNotificationPage.saveSNclick();
	

		commons.toastwait(driver);
		String notificationSuccessToast = commons.getToastMSG(driver);
		try {
			AssertJUnit.assertEquals(notificationSuccessToast, "Updated successfully");
			Reporter.log("Notification is updating successfully for Daily schedule-Test case passed", true);
		} catch (Exception e) {
			Reporter.log("Notification updating for Daily schedule-Test case Failed", true);
			AssertJUnit.fail();
		}
		
		studiesPage.scheduleNotificationBTNClick();
		Thread.sleep(3000);
		scheduleNotificationPage.activityDropDownClick();
		Thread.sleep(2000);
		commons.selectActivity(driver);
		scheduleNotificationPage.scheduleDropdownClick();
		Thread.sleep(2000);
		commons.setSchedule(driver,"Weekly");
		Thread.sleep(2000);
		scheduleNotificationPage.daysDropdownClick();
		Thread.sleep(2000);
		commons.setDay(driver, "Monday");
		Thread.sleep(2000);
		scheduleNotificationPage.sendTime();
		Thread.sleep(2000);

		scheduleNotificationPage.saveSNclick();
		Thread.sleep(3000);

		commons.toastwait(driver);
		String notificationmess = commons.getToastMSG(driver);
		try {
			AssertJUnit.assertEquals(notificationmess, "Updated successfully");
			Reporter.log("Days drop down is Enabled on Weekly schedule selection-Test case passed ", true);
			Reporter.log("Notification is updating successfully for Weekly schedule-Test case passed", true);
		} catch (Exception e) {
			Reporter.log("Notification updating for Weekly schedule-Test case Failed", true);
			AssertJUnit.fail();
		}

	}
}

/*
 * @Test(priority = 24, enabled = fail) public void setNotificationWeekly()
 * throws InterruptedException, AWTException {
 * 
 * Commons commons = new Commons(); StudiesPage studiesPage = new
 * StudiesPage(driver); ScheduleNotificationPage scheduleNotificationPage = new
 * ScheduleNotificationPage(driver);
 * 
 * commons.login(driver); commons.studiesScreenWait(driver); Thread.sleep(8000);
 * studiesPage.scheduleNotificationBTNClick(); Thread.sleep(4000);
 * 
 * // ACTIVITY scheduleNotificationPage.activityDropDownClick();
 * 
 * 
 * List<WebElement> activityMenu =
 * driver.findElements(By.xpath("//span[contains(@class,'mat-option-text')]"));
 * 
 * for (int i = 0; i < activityMenu.size(); i++) {
 * System.out.println(activityMenu.size());
 * 
 * WebElement aOption = activityMenu.get(i); String innerhtml =
 * aOption.getAttribute("innerHTML");
 * 
 * if (innerhtml.contains("6 Minute Walk Test")) { aOption.click(); break; }
 * 
 * } // SCHEDULE
 * 
 * 
 * scheduleNotificationPage.scheduleDropdownClick(); Thread.sleep(3000);
 * 
 * List<WebElement> scheduleMenu =
 * driver.findElements(By.xpath("//span[contains(@class,'mat-option-text')]"));
 * 
 * for (int i = 0; i < scheduleMenu.size(); i++) {
 * 
 * WebElement sOption = scheduleMenu.get(i); String innerhtml =
 * sOption.getAttribute("innerHTML");
 * 
 * if (innerhtml.contains("Weekly")) { Actions actions = new Actions(driver);
 * actions.moveToElement(sOption).click().build().perform(); break;
 * 
 * }
 * 
 * } Thread.sleep(4000);
 * 
 * 
 * // boolean daysDropdownstate = scheduleNotificationPage.chkDaysDDIsEnabled();
 * // System.out.println(daysDropdownstate); //
 * AssertJUnit.assertEquals(daysDropdownstate, true);
 * 
 * // DAYS // scheduleNotificationPage.daysDropdownClick();
 * 
 * 
 * List<WebElement> daysMenu =
 * driver.findElements(By.xpath("//span[contains(@class,'mat-option-text')]"));
 * for (int i = 0; i < daysMenu.size(); i++) {
 * 
 * WebElement dOption = daysMenu.get(i); String innerhtml =
 * dOption.getAttribute("innerHTML");
 * 
 * if (innerhtml.contains("Friday")) { dOption.click(); break;
 * 
 * }
 * 
 * }
 * 
 * 
 * Thread.sleep(3000); scheduleNotificationPage.sendTime(); Thread.sleep(3000);
 * 
 * scheduleNotificationPage.saveSNclick(); Thread.sleep(4000);
 * 
 * commons.toastwait(driver); String notificationSuccessToast =
 * commons.getToastMSG(driver); try {
 * AssertJUnit.assertEquals(notificationSuccessToast, "Updated successfully");
 * Reporter.
 * log("Days drop down is Enabled on Weekly schedule selection-Test case passed "
 * , true); Reporter.
 * log("Notification is updating successfully for Weekly schedule-Test case passed"
 * , true); } catch (Exception e) {
 * Reporter.log("Notification updating for Weekly schedule-Test case Failed",
 * true); Assert.fail(); }
 * 
 * }
 * 
 * }
 */