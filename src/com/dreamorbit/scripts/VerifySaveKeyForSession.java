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
import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.LabelPage;
import com.dreamorbit.pages.NavigationDrawerPage;
import com.dreamorbit.pages.ParticipantListPage;
import com.dreamorbit.pages.ParticipantPage;

public class VerifySaveKeyForSession extends BaseTest 
{
	@Test(priority = 28,enabled =true)
	public void testSaveSessionKey() throws InterruptedException

	{
		Commons commons = new Commons();
		
		LabelPage studypage = new LabelPage(driver);
		ParticipantListPage participantListPage = new ParticipantListPage(driver);
		ParticipantPage participantPage = new ParticipantPage(driver);
		NavigationDrawerPage navigationDrawerPage = new NavigationDrawerPage(driver);
		
		String vEmailid = read_XL_Data(XL_DATA_PATH, "ValidResearcherEmails", 1, 0);
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		commons.login(driver);
		commons.studiesScreenWait(driver);
		Thread.sleep(3000);
		studypage.particpantLabelClick();
		Thread.sleep(3000);
		participantListPage.clickUploads();
		Thread.sleep(2000);
		commons.downloadJson(driver, true);
		commons.toastwait(driver);
		Thread.sleep(5000);
		participantPage.fileJsonClick();
		commons.toastwait(driver);
		String actualDownlaodSuccessToast = commons.getToastMSG(driver);
		AssertJUnit.assertEquals(actualDownlaodSuccessToast, "File downloaded successfully");
		Reporter.log("Session is saving for File downloads - testcase passed",true);
		
		participantPage.personalTabClick();
		commons.personalInfoScreenWait(driver);
		Thread.sleep(5000);
		participantPage.personalDecryptClick();
		commons.toastwait(driver);
		String aPersonalinfoDecryptToast = commons.getToastMSG(driver);
		AssertJUnit.assertEquals(aPersonalinfoDecryptToast, "Data Decrypted successfully");
		Reporter.log("Session is saving for personal info screen- testcase passed",true);
		
		
		navigationDrawerPage.nDResearchersClick();
		Thread.sleep(4000);
		commons.addResearcher( driver, vEmailid, true);
		Thread.sleep(2000);
		commons.toastwait(driver);
		String aResearcheraddedSucessMSG = commons.getToastMSG(driver);
		Reporter.log(aResearcheraddedSucessMSG, true);
		AssertJUnit.assertTrue(aResearcheraddedSucessMSG.equals("Researcher added successfully."));
		Reporter.log("Session is saving for Adding researcher - Save Session Key testcase is passed", true);
	

	}

}
