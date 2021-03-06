package com.dreamorbit.scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.LogoutPage;

public class LogoutTest extends BaseTest {
	@Test(priority = 15, enabled = true)
	public void verifyLogout() throws InterruptedException {
		Commons commons = new Commons();
		LogoutPage logoutPage = new LogoutPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		commons.login(driver);
		commons.studiesScreenWait(driver);
		

		logoutPage.logoutBTNClick();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("swal2-cancel swal2-styled")));
		logoutPage.logoutCancelClick();
		Reporter.log("Logout Cancel button functionality is passed");
		
		Thread.sleep(3000);

		logoutPage.logoutBTNClick();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("swal2-confirm swal2-styled")));
		logoutPage.logoutConfirmClick();

		commons.toastwait(driver);
		String alogoutSuccessToast = commons.getToastMSG(driver);
		AssertJUnit.assertEquals(alogoutSuccessToast, "Logout Successful");
		Reporter.log("Logout success testcase is passed");

	}
}