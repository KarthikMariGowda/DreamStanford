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
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.generic.FWUtils;
import com.dreamorbit.main.NavigationDrawerPage;

public class NavigationOnDrawerOptionsTest extends BaseTest
{
@Test(priority=11,enabled = true)

public void navigationFlowCheck() throws InterruptedException
{
	Commons commons = new Commons();
	NavigationDrawerPage navigationDrawerPage= new NavigationDrawerPage(driver);
	commons.login(driver);
	commons.studiesScreenWait(driver);
	Thread.sleep(5000);
	navigationDrawerPage.nDResearchersClick();
	Thread.sleep(5000);
	String aRpUrl= FWUtils.getCurrentPageUrl(driver, ResearcherPageUrl);
	
	try {
		AssertJUnit.assertEquals(aRpUrl, ResearcherPageUrl);
		Reporter.log("Researcher page navigation testcase is passed");
	} 
	catch (AssertionError e) {
		Reporter.log("The Expected Page URL\" +eURL+ \"is not Dispalyed");
		Assert.fail();
	}
	Thread.sleep(2000);
	
	navigationDrawerPage.nDRatingClick();
	Thread.sleep(5000);
	String aRtngUrl= FWUtils.getCurrentPageUrl(driver, RatingPageUrl);
	
	try {
		AssertJUnit.assertEquals(aRtngUrl, RatingPageUrl);
		Reporter.log("Rating page navigation testcase is passed",true);
	} 
	catch (AssertionError e) {
		Reporter.log("The Expected Page URL\" +eURL+ \"is not Dispalyed",true);
		Assert.fail();
	}
	
	Thread.sleep(2000);
	navigationDrawerPage.nDStudiesClick();
	Thread.sleep(5000);
	String aSpUrl= FWUtils.getCurrentPageUrl(driver, StudyPageUrl);
	
	try {
		AssertJUnit.assertEquals(aSpUrl, StudyPageUrl);
		Reporter.log("Studies page navigation testcase is passed",true);
	} 
	catch (AssertionError e) {
		Reporter.log("The Expected Page URL\" +eURL+ \"is not Dispalyed",true);
		Assert.fail();
	}
	Thread.sleep(2000);
	
	navigationDrawerPage.nDAuditResearcherClick();
	Thread.sleep(5000);
	String aLPUrl= FWUtils.getCurrentPageUrl(driver, AuditResearcherPageUrl);
	
	try {
		AssertJUnit.assertEquals(aLPUrl, AuditResearcherPageUrl);
		Reporter.log("AuditResearcher page navigation testcase is passed",true);
	} 
	catch (AssertionError e) {
		Reporter.log("The Expected Page URL\" +eURL+ \"is not Dispalyed",true);
		Assert.fail();
	}
	
}
}
