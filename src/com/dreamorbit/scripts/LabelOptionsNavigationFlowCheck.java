package com.dreamorbit.scripts;

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
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.generic.FWUtils;
import com.dreamorbit.pages.LabelPage;


public class LabelOptionsNavigationFlowCheck extends BaseTest
{
	
@Test(priority = 14, enabled = false)
public void totalParticipantNavigationCheck() throws InterruptedException
{
	Commons commons = new Commons();
	LabelPage labelPage= new LabelPage(driver);
	
	commons.login(driver);
	commons.studiesScreenWait(driver);
	Thread.sleep(4000);
	labelPage.particpantLabelClick();
	Thread.sleep(4000);
	String aTPUrl= FWUtils.getCurrentPageUrl(driver, ParticipantUrl);
	
	try {
		AssertJUnit.assertEquals(aTPUrl, ParticipantUrl);
		Reporter.log("TotalParticipant Navigation Check testcase is passed");
	} 
	catch (AssertionError e) {
		Reporter.log("The Expected Page URL\" +ParticipantUrl+ \"is not Dispalyed");
		Assert.fail();
	}
	
	Thread.sleep(3000);
	labelPage.totalFellowResearcherClick();
	Thread.sleep(3000);
	String aTRUrl= FWUtils.getCurrentPageUrl(driver, ResearcherPageUrl);
	
	try {
		AssertJUnit.assertEquals(aTRUrl, ResearcherPageUrl);
		Reporter.log("TotalResearcher Navigation Check testcase is passed");
	} 
	catch (AssertionError e) {
		Reporter.log("The Expected Page URL\" +ResearcherPageUrl+ \"is not Dispalyed");
		Assert.fail();
	}
	

}

}
