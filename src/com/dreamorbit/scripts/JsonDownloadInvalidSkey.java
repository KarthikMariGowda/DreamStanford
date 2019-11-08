package com.dreamorbit.scripts;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;

	import org.testng.Reporter;
	import java.util.concurrent.TimeUnit;
	import com.dreamorbit.generic.BaseTest;
	import com.dreamorbit.generic.Commons;
	import com.dreamorbit.pages.ParticipantListPage;
	import com.dreamorbit.pages.ParticipantPage;
	import com.dreamorbit.pages.StudiesPage;


	public class JsonDownloadInvalidSkey extends BaseTest

	{
		@Test(priority = 5, enabled = false)
		public void jsonDownloadInvalidSkey()  throws InterruptedException 
		{
			
			Commons commons= new Commons();
			BaseTest baseTest= new BaseTest();
			StudiesPage studypage= new StudiesPage(driver);
			ParticipantListPage participantListPage = new ParticipantListPage(driver);
			ParticipantPage participantPage= new ParticipantPage(driver);
			
			
			int rowCnt = baseTest.xl_RowCount(XL_DATA_PATH, "SymmtricKeyInvalid");
			 Reporter.log("invalidkey input counts ="+rowCnt,true);
			  
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 commons.login(driver); 
				 commons.studiesWait(driver);
				 studypage.particpantLabelClick();
				 Thread.sleep(3000);
				 participantListPage.clickUploads();
				 
				 
			 for(int i=1;i<=rowCnt;i++)
			  {
				 participantPage.fileJsonClick();
				 participantListPage.clearSymmetricKey();
				 String inValidSkey = baseTest.read_XL_Data(XL_DATA_PATH,"SymmtricKeyInvalid",i,0); 
				 participantListPage.sendSymmetricKey(inValidSkey);
				 participantListPage.sK_clickOk(); 
				 commons.toastwait(driver);
				 String actualInvalidSkeyToast= commons.getToastMSG(driver);
				 //Reporter.log(actualInvalidSkeyToast,true);
				// boolean res= participantListPage.sk_warning_isDisplayed();
				AssertJUnit.assertTrue(actualInvalidSkeyToast.equals("Invalid Key")); //|| (res==true));
				Reporter.log("Json Download testcase with invalid symmetric key is passed");
				Thread.sleep(3000);
			  }
				 
				 
		}
			 
			 @Test(priority = 6, enabled = true)
			 public void jsonDownloadIncorrectSkey()  throws InterruptedException 
				{
					Commons commons= new Commons();
					BaseTest baseTest= new BaseTest();
					StudiesPage studypage= new StudiesPage(driver);
					ParticipantListPage participantListPage = new ParticipantListPage(driver);
					ParticipantPage participantPage= new ParticipantPage(driver);
					
					int rowCnt = baseTest.xl_RowCount(XL_DATA_PATH, "SymmtricKeyIncorrect");
					  Reporter.log("invalidkey input counts ="+rowCnt,true);
					  
					  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 commons.login(driver); 
						 commons.studiesWait(driver);
						 Thread.sleep(3000); 
						 studypage.particpantLabelClick();
						 Thread.sleep(3000);
						 participantListPage.clickUploads();
						 participantPage.fileJsonClick();
						 
					 for(int i=1;i<=rowCnt;i++)
					  {
						 participantListPage.clearSymmetricKey();
						 String inCorrectSkey = baseTest.read_XL_Data(XL_DATA_PATH,"SymmtricKeyIncorrect",i,0); 
						 participantListPage.sendSymmetricKey(inCorrectSkey);
						 participantListPage.sK_clickOk(); 
						 Thread.sleep(3000);
						 Boolean res= commons.isAlertMSGDisplayed(driver);
						if(res==true) 
						{
						  Reporter.log("Json Download testcase with incorrect symmetric key is passed");
						}
						else
						{
						Reporter.log("Json Download testcase with incorrect symmetric key is failed");
						}
						 		 
						 Thread.sleep(2000); 		 
				}
			
			 
	}


	 

}
