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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.generic.FWUtils;
import com.dreamorbit.pages.ForgotPasswordPage;
import com.dreamorbit.pages.LoginPage;

public class ForgotPasswordCheck extends BaseTest {

	@Test(priority = 7, enabled = true)

	public void ForgotPWDNavigationFlowCheck() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickForgotPwd();
		loginPage.clickForgotPwd();// just for now issue to be logged

		String aFPURL = FWUtils.getCurrentPageUrl(driver, forgotPwdUrl);
		// Reporter.log(aFPURL);
		try {
			AssertJUnit.assertEquals(aFPURL, forgotPwdUrl);
			Reporter.log("Forgot password button NavigationFlowCheck- Testcase is passed",true);
		} catch (AssertionError e) {
			Reporter.log("The Expected Page URL\" +eURL+ \"is not Dispalyed for forgot password link click",true);
			AssertJUnit.fail();
		}
	}

	@Test(priority = 8, enabled = true)
	public void forgotPasswordValid() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		Commons commons = new Commons();

		Thread.sleep(4000);

		int rowCount = xl_RowCount(XL_DATA_PATH, "FpValidEmails");
		// Reporter.log("RowCount=" + rowCount, true);
		loginPage.clickForgotPwd();

		for (int i = 1; i <= rowCount; i++) {
			loginPage.clickForgotPwd();// to be changed
			Thread.sleep(2000);
			String testVemails = read_XL_Data(XL_DATA_PATH, "FpValidEmails", i, 0);

			forgotPasswordPage.sendEmail(testVemails);

			forgotPasswordPage.FpSubmitClick();
			commons.toastwait(driver);
			String successMSG = commons.getToastMSG(BaseTest.driver);
			// Reporter.log(successMSG);
			AssertJUnit.assertEquals(successMSG, "Verification code sent to your Email address");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.history.back()");
			Thread.sleep(4000);
		}
		Reporter.log("Forgot password feature with valid data is working as expected- Testcase is passed",true);
		Reporter.log("Back navigation from Reset Password screen is working as expected - Testcase is passed",true);

	}

	@Test(priority = 9, enabled = true)
	public void forgotPasswordInValid() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		Commons commons = new Commons();

		Thread.sleep(4000);

		int rowCount = xl_RowCount(XL_DATA_PATH, "FpInvalidEmails");
		// Reporter.log("RowCount=" + rowCount, true);
		loginPage.clickForgotPwd();

		for (int i = 1; i <= rowCount; i++) {
			loginPage.clickForgotPwd();// to be changed
			Thread.sleep(2000);
			String testVemails = read_XL_Data(XL_DATA_PATH, "FpInvalidEmails", i, 0);

			forgotPasswordPage.sendEmail(testVemails);
			forgotPasswordPage.FpSubmitClick();
			commons.toastwait(driver);
			String FpWarnMSG = commons.getToastMSG(BaseTest.driver);
			// Reporter.log(FpWarnMSG);
			AssertJUnit.assertTrue(FpWarnMSG.equals("You must had login once. Before resetting your password.")// message
																												// needs
																												// a
																												// ,-BUG
					|| FpWarnMSG.equals("Email not found."));
			// || FpWarnMSG.equals("Temporary password has expired and must be reset by an
			// administrator."));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.history.back()");
			Thread.sleep(4000);
		}
		Reporter.log("Forgot password feature with Invalid inputs - Testcase is passed",true);

	}

	@Test(priority = 10, enabled = true)
	public void fPChkWithAttemptlimitExceeded() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		Commons commons = new Commons();
		//WebDriverWait wait= new WebDriverWait(driver, 20);

		

		loginPage.clickForgotPwd();
		Thread.sleep(3000);
		loginPage.clickForgotPwd();// to be changed
		Thread.sleep(4000);
		String testVemails = read_XL_Data(XL_DATA_PATH, "FpEmailsAttemptlimitExceeded", 1, 0);

		
		for (int i = 1; i <= 6; i++)
		{
			Thread.sleep(4000);
			forgotPasswordPage.clearEmail();
			Thread.sleep(4000);
			forgotPasswordPage.sendEmail(testVemails);
			
			//commons.fPsubmitBTNWait(driver);
			forgotPasswordPage.FpSubmitClick();

		}
		commons.toastwait(driver);
		String FpWarnMSG = commons.getToastMSG(BaseTest.driver);
		// Reporter.log(FpWarnMSG,true);
		
		  AssertJUnit.assertTrue(FpWarnMSG.equals("Attempt limit exceeded, please try after some time."));// message needs // a ,-BUG
		  
		  Reporter.log("Forgot password feature with invalid Email attempt limit exceeds 5  - Testcase is passed",true);
		 
	}

	@Test(priority = 11, enabled = true)
	public void forgotPwdTologinNavigationChk() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickForgotPwd();
		loginPage.clickForgotPwd();// just for now issue to be logged
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.fpLoginClick();
		String aURL = FWUtils.getCurrentPageUrl(driver, loginPageUrl);
		// Reporter.log(aURL);
		try {
			AssertJUnit.assertEquals(aURL, loginPageUrl);
			Reporter.log("Login link in forgot password screen is working as expected-Testcase is passed",true);
		} catch (AssertionError e) {
			Reporter.log("The Expected Page URL\" +eURL+ \"is not Dispalyed for Login link click in forgot password screen",true);
			AssertJUnit.fail();
		}

	}
// need to write test case for - chk with dev team on how many attempts user email can get reset passwor sent to ur mail id " message and the email will br triggered to emil 
}