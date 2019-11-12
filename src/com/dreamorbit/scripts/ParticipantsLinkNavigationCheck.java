package com.dreamorbit.scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.generic.FWUtils;
import com.dreamorbit.pages.StudiesPage;

public class ParticipantsLinkNavigationCheck extends BaseTest {
	@Test(priority = 19, enabled = true)
	public void testValidlogin() throws InterruptedException
	{
		Commons commons = new Commons();
		StudiesPage studiesPage= new StudiesPage(driver);
		
		commons.login(driver);
		commons.studiesScreenWait(driver);
		studiesPage.participantALinkClick();
		Thread.sleep(5000);//commons.wa
		String aPPUrl= FWUtils.getCurrentPageUrl(driver, ParticipantUrl);
		
		try {
			AssertJUnit.assertEquals(aPPUrl, ParticipantUrl);
			Reporter.log("Functional verification of Participant link under Actions testcase is  passed");
		} 
		catch (AssertionError e) {
			Reporter.log("Functional verification of Participant link under Actions testcase is  passed");
			AssertJUnit.fail();
		}
		
		
		
		
}
}