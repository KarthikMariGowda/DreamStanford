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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.main.NavigationDrawerPage;

public class VerifySessionExpiryTest extends BaseTest {

	@Test(priority = 23, enabled = false)
	public void sessionExpiryCheck() throws InterruptedException {

		Commons commons = new Commons();
		NavigationDrawerPage navigationDrawerPage = new NavigationDrawerPage(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		commons.login(driver);
		commons.studiesScreenWait(driver);

// Thread.sleep(19*60*1000);

		Thread.sleep(31 * 60 * 1000);
		navigationDrawerPage.nDResearchersClick();
		Thread.sleep(8000);
		Alert alert = driver.switchTo().alert();
		String alertMess = alert.getText();
		System.out.println(alertMess);

		String aCurrentPageUrl = driver.getCurrentUrl();

		try {
			AssertJUnit.assertEquals(aCurrentPageUrl, "https://qa-stanford.phaware.global/signin?expired=true");
			Reporter.log("Session is expired- testcase passed", true);
		} catch (AssertionError e) {
			Reporter.log("Session is not expired- testcase failed", true);
			AssertJUnit.fail();
		}

		Thread.sleep(3000);
		alert.accept();

		String saCurrentPageUrl = driver.getCurrentUrl();
		System.out.println(saCurrentPageUrl);
// https://qa-stanford.phaware.global/signin

	}
}
