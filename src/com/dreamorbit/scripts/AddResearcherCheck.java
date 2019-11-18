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
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.main.NavigationDrawerPage;
import com.dreamorbit.pages.ResearcherPage;
import com.dreamorbit.pages.SymmetricKeyPage;

public class AddResearcherCheck extends BaseTest {
	@Test(priority = 12, enabled = false)
	
	public void AddResearcherCheckValid() throws InterruptedException {
		String vEmailid = read_XL_Data(XL_DATA_PATH, "ValidResearcherEmails", 1, 0);
		
		SymmetricKeyPage symmetricKeyPage = new SymmetricKeyPage(driver);
		Commons commons = new Commons();
		
		
		
		commons.addResearcher(driver,vEmailid);
		Thread.sleep(2000);
		commons.toastwait(driver);
		String aResearcheraddedSucessMSG = commons.getToastMSG(driver);
		Reporter.log(aResearcheraddedSucessMSG, true);
		AssertJUnit.assertTrue(aResearcheraddedSucessMSG.equals("Researcher added successfully."));
		Reporter.log("Add Researcher test case is passed", true);
		Thread.sleep(2000);
		symmetricKeyPage.copyNDeliverBTNClick();
		commons.toastwait(driver);
		String aCopyToclipBoardSucessMSG = commons.getToastMSG(driver);

		AssertJUnit.assertTrue(aCopyToclipBoardSucessMSG.equals("Copied to clipboard!"));
		Reporter.log("Copy reseracher sKey to clip board test case is passed", true);

	}

	@Test(priority = 13, enabled = false) // issue
	public void AddResearcherCheckInValid() throws InterruptedException {
		
		Commons commons = new Commons();
		ResearcherPage researcherPage = new ResearcherPage(driver);
		NavigationDrawerPage navigationDrawerPage = new NavigationDrawerPage(driver);
		BaseTest baseTest = new BaseTest();
		SymmetricKeyPage symmetricKeyPage = new SymmetricKeyPage(driver);

		commons.login(driver);
		Thread.sleep(4000);
		commons.studiesScreenWait(driver);
		navigationDrawerPage.nDResearchersClick();
		Thread.sleep(4000);

		commons.researchersScreenWait(driver);
		researcherPage.addResearcherClick();
		int rowCount = baseTest.xl_RowCount(XL_DATA_PATH, "InvalidResearcherEmails");
		Reporter.log("RowCount=" + rowCount, true);

		for (int i = 1; i <= rowCount; i++) {
			// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
			commons.researchersScreenWait(driver);
			String vEmailid = baseTest.read_XL_Data(XL_DATA_PATH, "InvalidResearcherEmails", i, 0);
			researcherPage.clearEmailAddress();
			researcherPage.setEmailAddress(vEmailid);
			researcherPage.tickButtonClick();
			Thread.sleep(2000);
			
			commons.toastwait(driver);
			String aWarnMSG = commons.getToastMSG(driver);
			// if(aWarnMSG= )

			AssertJUnit.assertTrue(aWarnMSG.equals("User already exist") || aWarnMSG.equals("Email is required"));
			// || aWarnMSG.equals("Temporary password has expired and must be reset by an
			// administrator."));-Bug for invalid format email add the related warn message
			// - not "Email is required" message
			Reporter.log("Trying to add researcher with invalid email iD's - testcase is passed", true);
			
			
			
			
		}
	}

}