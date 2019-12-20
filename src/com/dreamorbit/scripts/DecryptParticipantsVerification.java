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
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.generic.FWUtils;
import com.dreamorbit.pages.ParticipantListPage;
import com.dreamorbit.pages.StudiesPage;
import com.dreamorbit.pages.SymmetricKeyPage;

public class DecryptParticipantsVerification extends BaseTest
{
	
	@Test(priority = 19, enabled = true)
	public void testDecryptParticipants() throws InterruptedException
	{
		Commons commons = new Commons();
		
		ParticipantListPage participantListPage= new ParticipantListPage(driver);
		SymmetricKeyPage symmetricKeyPage= new SymmetricKeyPage(driver);
		StudiesPage studiesPage = new StudiesPage(driver);
		commons.login(driver);
		commons.studiesScreenWait(driver);
		studiesPage.participantALinkClick();
		commons.participantListScreenWait(driver);
		String aPPUrl= FWUtils.getCurrentPageUrl(driver, ParticipantUrl);
		
		try {
			AssertJUnit.assertEquals(aPPUrl, ParticipantUrl);
			Reporter.log("Participants Link Navigation under Actions - Testcase is  passed",true);
		} 
		catch (AssertionError e) {
			Reporter.log("Participants Link Navigation under Actions Testcase is  failed"+"Actual URL" +aPPUrl+ "," + "Expected URL"+ ParticipantUrl, true);
			Assert.fail();
		}
		
		participantListPage.clickDecrypt();
		symmetricKeyPage.sendSymmetricKey(sKey);
		symmetricKeyPage.sK_clickOk();
		commons.toastwait(driver);
		 String aDecryptedSuccessToast= commons.getToastMSG(driver);
		 try {
			AssertJUnit.assertEquals(aDecryptedSuccessToast, "Data Decrypted successfully");
			 Reporter.log("Decrypt Participants in list with valid symmetric key -Testcase is Passed",true);
		} catch (Exception e) {
			Reporter.log("Decrypt Participants in list with valid symmetric key -Testcase is Failed",true);
			Assert.fail();
		}
		 
		 
			try {
				AssertJUnit.assertFalse(participantListPage.isDecrptBTNEnabled());
				Reporter.log("Decrypt Participants button is Disabled after the decryption is done, Testcase is Passed",true);
			} 
			catch (AssertionError e) {
				Reporter.log("Decrypt Participants button is still enabled after the decryption of the participant list , Testcase is failed", true);
				Assert.fail();
			}
			
		 
				
}
}