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
//Togle, loggedout,reset password isnot captured in Audit- issue
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.AuditResearcherPage;
import com.dreamorbit.pages.NavigationDrawerPage;
import com.dreamorbit.pages.ParticipantListPage;
import com.dreamorbit.pages.ParticipantPage;
import com.dreamorbit.pages.StudiesPage;
import com.dreamorbit.pages.SymmetricKeyPage;

public class AuditResearcherTest extends BaseTest

{
	@Test(priority = 26, enabled = true)

	public void auditRessearcherVerification() throws InterruptedException {
		Commons commons = new Commons();
		StudiesPage studiesPage = new StudiesPage(driver);
		ParticipantListPage participantListPage = new ParticipantListPage(driver);
		AuditResearcherPage auditResearcherPage = new AuditResearcherPage(driver);
		SymmetricKeyPage symmetricKeyPage = new SymmetricKeyPage(driver);
		ParticipantPage participantPage = new ParticipantPage(driver);
		NavigationDrawerPage navigationDrawerPage = new NavigationDrawerPage(driver);

//Calling login method
		commons.login(driver);
		commons.studiesScreenWait(driver);

// method to add researcher
		navigationDrawerPage.nDResearchersClick();
		Thread.sleep(4000);

		String vEmailid = read_XL_Data(XL_DATA_PATH, "ValidResearcherEmails", 1, 0);
		commons.addResearcher(driver, vEmailid,false);
		commons.toastwait(driver);
		symmetricKeyPage.copyNDeliverBTNClick();
		commons.toastwait(driver);
		Thread.sleep(6000);
//click on studies
		navigationDrawerPage.nDStudiesClick();

		commons.studiesScreenWait(driver);

//calling the method - Participant link click
		studiesPage.participantALinkClick();

		commons.participantListScreenWait(driver);

		String uploadsCount = participantListPage.buttonUploadsCount();
		Reporter.log(uploadsCount, true);

		if (uploadsCount == "0 Uploads") {
			// called the method to decrypt participant details
			participantListPage.clickUploads();
			commons.participantScreenWait(driver);
			Thread.sleep(4000);

			// click on audit researcher

			navigationDrawerPage.nDAuditResearcherClick();
			Thread.sleep(6000);

			String aFirstRowAction = auditResearcherPage.getFirstRowData();
			String aSecondRowAction = auditResearcherPage.getFirstRowData();
			String aThirdRowAction = auditResearcherPage.getThirdRowData();
			String aFourthRowAction = auditResearcherPage.getFourthRowData();

			try {
				AssertJUnit.assertTrue(aFirstRowAction.contains("Viewed Participant Details"));
				Reporter.log("File download activity under Audit recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("File download activity under Audit is not recorded- testcase failed", true);
				AssertJUnit.fail();
			}

			try {
				AssertJUnit.assertEquals(aSecondRowAction, "Viewed Participants listing");
				Reporter.log("Viewed Participant Uploads activity under Audit recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Viewed Participant Uploads activity under Audit is not recorded- testcase failed", true);
				AssertJUnit.fail();

			}

			try {
				AssertJUnit.assertEquals(aThirdRowAction, "Added new Researcher");
				Reporter.log("Added new Researcher activity under Audit recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Added new Researcher activity under Audit  not recorded- testcase failed", true);
				AssertJUnit.fail();
			}

			try {
				AssertJUnit.assertEquals(aFourthRowAction, "Logged In");
				Reporter.log("Researcher Login activity under Audit is recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Researcher Login activity under Audit is not recorded", true);
				AssertJUnit.fail();
			}

		}

		else {
			// Called the method to download json
			Thread.sleep(3000);
			participantListPage.clickUploads();
			// commons.viewUploadsScreenWait(driver);
			Thread.sleep(4000);

			// called the method to decrypt participant details
			participantPage.personalTabClick();
			commons.personalInfoScreenWait(driver);
			Thread.sleep(6000);

			// click on audit researcher

			navigationDrawerPage.nDAuditResearcherClick();
			Thread.sleep(5000);

			String aFirstRowAction = auditResearcherPage.getFirstRowData();
			String aSecondRowAction = auditResearcherPage.getSecondRowData();
			String aThirdRowAction = auditResearcherPage.getThirdRowData();
			String aFourthRowAction = auditResearcherPage.getFourthRowData();
			String aFifthRowAction = auditResearcherPage.getFifthRowData();

			try {
				AssertJUnit.assertEquals(aFirstRowAction, "Viewed Participant Details");
				Reporter.log("Viewed Participant Details under Audit recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Viewed Participant Details under Audit is not recorded- testcase failed", true);
				AssertJUnit.fail();
			}
			try {
				AssertJUnit.assertTrue(aSecondRowAction.contains("Viewed Participant Uploads"));
				Reporter.log("Viewed Participant Uploads under Audit recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Viewed Participant Uploads under Audit is not recorded- testcase failed", true);
				AssertJUnit.fail();
			}

			try {
				AssertJUnit.assertEquals(aThirdRowAction, "Viewed Participants listing");
				Reporter.log("Viewed Participant Listing activity under Audit recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Viewed Participant Listing activity under Audit is not recorded- testcase failed", true);
				AssertJUnit.fail();

			}

			try {
				AssertJUnit.assertEquals(aFourthRowAction, "Added new Researcher");
				Reporter.log("Added new Researcher activity under Audit recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Added new Researcher activity under Audit  not recorded- testcase failed", true);
				AssertJUnit.fail();
			}

			try {
				AssertJUnit.assertEquals(aFifthRowAction, "Logged In");
				Reporter.log("Researcher Login activity under Audit is recorded- testcase passed", true);
			} catch (AssertionError e) {
				Reporter.log("Researcher Login activity under Audit is not recorded", true);
				AssertJUnit.fail();
			}

		}

	}

}
