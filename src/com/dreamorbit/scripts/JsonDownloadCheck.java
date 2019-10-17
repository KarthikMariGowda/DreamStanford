package com.dreamorbit.scripts;

import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;

public class JsonDownloadCheck extends BaseTest

{
	@Test(priority=3)
	public void jsonDownloadCheck()
	{
		
	}
	
}



/*
 * @Test(priority=3)
 * 
 * void jsonDownloadCheck() throws InterruptedException {
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * commons.login(); ewait.until(ExpectedConditions.urlToBe(studyUrl));
 * Thread.sleep(3000); commons.participantClick(); Thread.sleep(3000);
 * ewait.until(ExpectedConditions.urlToBe(partExpected_url));
 * commons.uploadsClick(); Thread.sleep(6000); commons.csvFileClick();
 * commons.sendSymmetricKey(sKey); commons.sKey_OK(); WebElement downloadToast=
 * driver.findElement(By.className("toast-message"));
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * Reporter.log("check 2 "+downloadToast,true); //
 * ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
 * "toast-container"))); String
 * downloadToastMess=downloadToast.getAttribute("aria-label");//
 * ="Invalid current password" Reporter.log(downloadToastMess, true);
 * Assert.assertEquals(downloadToastMess,"File downloaded successfully");
 * Reporter.log("Json Download testcase is passed"); Thread.sleep(8000); //
 * Assert.assertEquals(actual, expected);
 * 
 */