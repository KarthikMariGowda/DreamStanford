package com.dreamorbit.scripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.NavigationDrawerPage;
import com.dreamorbit.pages.ResearcherPage;
import com.dreamorbit.pages.SearchFieldPage;
import com.dreamorbit.pages.SymmetricKeyPage;

public class TestSearchResearcher extends BaseTest {
	@Test(priority = 18, enabled = true)
	
	public void searchResearcherValid() throws InterruptedException {
		
		String vEmailid = read_XL_Data(XL_DATA_PATH, "ValidResearcherEmails", 1, 0);
		
		SymmetricKeyPage symmetricKeyPage = new SymmetricKeyPage(driver);
		Commons commons = new Commons();
		ResearcherPage researcherPage = new ResearcherPage(driver);
		SearchFieldPage searchFieldPage = new SearchFieldPage(driver);
		NavigationDrawerPage navigationDrawerPage = new NavigationDrawerPage(driver);
		
		commons.login(driver);
		
		Thread.sleep(4000);
		commons.studiesScreenWait(driver);
		navigationDrawerPage.nDResearchersClick();
		Thread.sleep(4000);

		commons.researchersScreenWait(driver);
		
		try {
			commons.addResearcher(driver,vEmailid,false);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		symmetricKeyPage.copyNDeliverBTNClick();
		Thread.sleep(4000);
		researcherPage.inputsearchResearcherField(commons.epochEmail);
		Thread.sleep(4000);
		searchFieldPage.searchBTNClick();
		Thread.sleep(5000);
		String firstRowEmailID = researcherPage.getfirstRowREmail();

		try {
			AssertJUnit.assertEquals(commons.epochEmail, firstRowEmailID);
			Reporter.log("Researcher exact Search test case with existing data is passed", true);
		} catch (AssertionError e) {
			Reporter.log("The Expected Search result \" +commons.epochEmail+ \"is not Dispalyed", true);
			Assert.fail();
		}

		searchFieldPage.searchClearBTNClick();
		Thread.sleep(6000);

		//Reporter.log(commons.partialEpochEmail, true);
		researcherPage.inputsearchResearcherField(commons.partialEpochEmail);
		Thread.sleep(4000);
		searchFieldPage.searchBTNClick();
		Thread.sleep(5000);
		String tOPRowEmailID = researcherPage.getfirstRowREmail();
		if (tOPRowEmailID.contains(commons.partialEpochEmail)) {
			Reporter.log("Researcher partial Search test case with existing data is passed", true);
		} else {
			Reporter.log("The Expected partial Search result \" +commons.epochEmail+ \"is not Dispalyed", true);
			Assert.fail();
		}

		searchFieldPage.searchClearBTNClick();
		Thread.sleep(5000);

		String textInRSearch = researcherPage.getTextRSearch();
		try {
			AssertJUnit.assertEquals(textInRSearch, "");
			Reporter.log("Clear button functionality in researcher search- testcase is passed ", true);
		} catch (AssertionError e) {
			Reporter.log("Clear button in researcher search is not working as expected ", true);
			Assert.fail();
		}

		Thread.sleep(4000);
		researcherPage.inputsearchResearcherField(commons.nonExistingEmailID);
		Thread.sleep(4000);
		searchFieldPage.searchBTNClick();
		commons.toastwait(driver);
		String warnMess = commons.getToastMSG(driver);
		//Reporter.log(warnMess, true);

		if (warnMess.contains("No such Researcher as ")) {
			Reporter.log("Researcher Search testcase with  non existing data is passed", true);

		} else {
			Reporter.log("Researcher Search testcase with  non existing data is failed", true);
			AssertJUnit.fail();
		}

	}

}
