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
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import java.util.concurrent.TimeUnit;
import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.ParticipantListPage;
import com.dreamorbit.pages.ParticipantPage;
import com.dreamorbit.pages.StudiesPage;


public class JsonDownloadValidSkey extends BaseTest

{
	@Test(priority = 4, enabled = false)
	public void jsonDownloadCheck()  throws InterruptedException 
	{
		
		Commons commons= new Commons();
		BaseTest baseTest= new BaseTest();
		
		StudiesPage studypage= new StudiesPage(driver);
		ParticipantListPage participantListPage = new ParticipantListPage(driver);
		ParticipantPage participantPage= new ParticipantPage(driver);
		String validSKEY = baseTest.read_XL_Data(XL_DATA_PATH,"SymmtricKeyValid",1,0);
		
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 commons.login(driver); 
			 commons.studiesWait(driver);
			 Thread.sleep(3000); 
			 studypage.particpantLabelClick();
			 Thread.sleep(3000);
			 participantListPage.clickUploads();
			 Thread.sleep(2000); 
			 participantPage.fileJsonClick();
			 participantListPage.sendSymmetricKey(validSKEY);
			 participantListPage.sK_clickOk(); 
			 
			 String actualDownlaodSuccessToast= commons.getToastMSG(driver);
			 AssertJUnit.assertEquals(actualDownlaodSuccessToast, "File downloaded successfully");
			 Reporter.log("Json Download testcase with valid symmetric key is passed");
			 
			 
		/*
		 * WebElement downloadToast=driver.findElement(By.className("toast-message"));
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * Reporter.log("check 2 "+downloadToast,true);
		 * ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "toast-container"))); String
		 * downloadToastMess=downloadToast.getAttribute("aria-label");//
		 * ="Invalid current password"Reporter.log(downloadToastMess, true);
		 * Assert.assertEquals(downloadToastMess,"File downloaded successfully");
		 * Reporter.log("Json Download testcase is passed"); Thread.sleep(8000);
		 * Assert.assertEquals(actual, expected);
		 */
	}

}


 
 