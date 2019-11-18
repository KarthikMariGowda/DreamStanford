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
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.LabelPage;
import com.dreamorbit.pages.ParticipantListPage;
import com.dreamorbit.pages.ParticipantPage;
import com.dreamorbit.pages.SymmetricKeyPage;


public class PersonalInfoDecrypt extends BaseTest

{
	@Test(priority = 21, enabled = false)
	public void jsonDownloadCheck()  throws InterruptedException 
	{
		
		Commons commons= new Commons();
		BaseTest baseTest= new BaseTest();
		
		LabelPage studypage= new LabelPage(driver);
		ParticipantListPage participantListPage = new ParticipantListPage(driver);
		ParticipantPage participantPage= new ParticipantPage(driver);
		SymmetricKeyPage symmetricKeyPage= new SymmetricKeyPage(driver);
		
		String validSKEY = baseTest.read_XL_Data(XL_DATA_PATH,"SymmtricKeyValid",1,0);
		
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 commons.login(driver); 
			 commons.studiesScreenWait(driver);
			 Thread.sleep(3000); 
			 studypage.particpantLabelClick();
			 Thread.sleep(3000);
			 
			 String uploadsCount = participantListPage.buttonUploadsCount();
			 Reporter.log(uploadsCount, true);
			 
			 if(uploadsCount=="0 Uploads")
			 {
			 participantListPage.clickUploads();
			 commons.participantScreenWait(driver);
			 Thread.sleep(4000);
			 participantPage.personalDecryptClick();
			 symmetricKeyPage.sendSymmetricKey(validSKEY);
			 symmetricKeyPage.sK_clickOk(); 
			 commons.toastwait(driver);
			 String aPersonalInfoDecrptToast= commons.getToastMSG(driver);
			 AssertJUnit.assertEquals(aPersonalInfoDecrptToast, "Data Decrypted successfully");
			 Reporter.log("Personal info decrypt through zero uploads testcase  is passed",true);
			 }
			 
			 else
			 {
				 participantListPage.clickUploads();
				 commons.participantScreenWait(driver);
				 Thread.sleep(5000);
				 participantPage.personalTabClick();
				 commons.personalInfoScreenWait(driver);
				 Thread.sleep(5000);
				 participantPage.personalDecryptClick();
				 symmetricKeyPage.sendSymmetricKey(validSKEY);
				 symmetricKeyPage.sK_clickOk(); 
				 commons.toastwait(driver);
				 String aPersonalInfoDecrptToast= commons.getToastMSG(driver);
				 AssertJUnit.assertEquals(aPersonalInfoDecrptToast, "Data Decrypted successfully");
				 Reporter.log("Personal info decrypt through " + uploadsCount+" uploads testcase via  is passed",true);
				 }
			 
			 
		/*
		 * WebElement downloadToast=driver.findElement(By.className("toast-message"));
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * Reporter.log("check 2 "+downloadToast,true);
		 * ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "toast-container"))); String
		 * downloadToastMess=downloadToast.getAttribute("aria-label");//
		 * ="Invalid current password"Reporter.log(downloadToastMess, true);
		 * Assert.assertEquals(downloadToastMess,"File downloaded successfully");
		 * Reporter.log("Json Download testcase is passed"); Thread.sleep(8000);
		 * Assert.assertEquals(actual, expected);
		 */
	}

}


 
 
