package com.dreamorbit.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.ParticipantListPage;
import com.dreamorbit.pages.ResetPasswordPage;
import com.dreamorbit.pages.StudiesPage;



public class JsonDownloadCheck extends BaseTest

{
	@Test(priority = 4, enabled = true)
	public void jsonDownloadCheck()  throws InterruptedException 
	{
		Commons commons= new Commons();
		BaseTest baseTest= new BaseTest();
		
		StudiesPage studypage= new StudiesPage(driver);
		ParticipantListPage participantListPage = new ParticipantListPage(driver);
		StudiesPage studiesPage= new StudiesPage(driver);
		
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 commons.login(driver); 
			 commons.studiesWait(driver);
			 Thread.sleep(3000); 
			 studypage.particpantLabelClick();
			 Thread.sleep(3000);
			 participantListPage.clickUploads();
			 Thread.sleep(2000); 
			 participantListPage.
			 commons.csvFileClick();
			 commons.sendSymmetricKey(sKey);
			 commons.sKey_OK(); 
			 WebElement downloadToast=driver.findElement(By.className("toast-message"));
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Reporter.log("check 2 "+downloadToast,true); 
			 ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
			 String downloadToastMess=downloadToast.getAttribute("aria-label");// ="Invalid current password"Reporter.log(downloadToastMess, true);
			 Assert.assertEquals(downloadToastMess,"File downloaded successfully");
			 Reporter.log("Json Download testcase is passed");
			 Thread.sleep(8000); 
			 Assert.assertEquals(actual, expected);
			 
	}

}


 
 
