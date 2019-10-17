package com.dreamorbit.scripts;

import org.testng.annotations.Test;
import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.FWUtils;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.LoginPage;
import com.dreamorbit.pages.ResetPasswordPage;

public class TestResetPasswordValid extends BaseTest
{
@Test(priority = 2) 
public void rstpwdVerification() throws InterruptedException 
	  { 
		  Commons commons= new Commons();
		  ResetPasswordPage resetPasswordPage= new ResetPasswordPage(driver);
		  BaseTest baseTest= new BaseTest();
		 
		  String currentPWD = baseTest.read_XL_Data(XL_DATA_PATH,"ValidResetPasswordData",1,0); 
		  String newPWD = baseTest.read_XL_Data(XL_DATA_PATH,"ValidResetPasswordData",1,1);
		  String confirmPWD = baseTest.read_XL_Data(XL_DATA_PATH,"ValidResetPasswordData",1,2);
		  
		  commons.login(driver);
		  commons.studiesWait(driver);
		  
		  resetPasswordPage.restButtonClick();
		  resetPasswordPage.sendCurrentPassword(currentPWD);
		  resetPasswordPage.sendNewPassword(newPWD);
		  resetPasswordPage.sendConfirmPassword(confirmPWD);
		  resetPasswordPage.submitReset();
		  String actualResetSuccessToast= commons.getToastMSG(driver);
		  System.out.println(actualResetSuccessToast);
		  
	  }
	  }
		  
		  
	  
		/*  String rstUrl="https://qa-stanford.phaware.global/reset_password"; 
		  commons.login();
	  ewait.until(ExpectedConditions.urlToBe(studyUrl)); 
	  Thread.sleep(5000);
	  commons.resetPassword("Orbit+987*", "Orbit+987*", "Orbit+987*");
	  
	  WebElement toast = driver.findElement(By.className("toast-message"));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Reporter.log("check toast1" + toast, true); String toastMess =
	  toast.getAttribute("aria-label");// ="Invalid current password"
	  Reporter.log("check toastMess1" + toastMess, true);
	  Assert.assertEquals(toastMess, "Password reset succeeded");
	  Reporter.log("Reset Password testcase is passed");*/
	 
