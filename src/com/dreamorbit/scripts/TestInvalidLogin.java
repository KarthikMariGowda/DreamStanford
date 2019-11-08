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
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter; 
import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.pages.LoginPage;
  

  public class TestInvalidLogin extends BaseTest
  {
  @Test(priority = 2,enabled= false) 
  public void testInvalidlogin() throws InterruptedException
  {
	  LoginPage loginPage= new LoginPage(driver);
	  Commons commons= new Commons();
	  BaseTest baseTest= new BaseTest();
	  
	  
 int rowCount = baseTest.xl_RowCount(XL_DATA_PATH, "InvalidLoginData");
  Reporter.log("RowCount="+rowCount,true);
  
 for( int i=1;i<=rowCount;i++)
  {
	 
	  loginPage.clrUN();
	  loginPage.clrPWD();
	  
String un = baseTest.read_XL_Data(XL_DATA_PATH,"InvalidLoginData",i,0); 
String pwd =baseTest.read_XL_Data(XL_DATA_PATH,"InvalidLoginData",i,1);
 

  loginPage.setUN(un);// to login to the application with invalid data 
  loginPage.setPWD(pwd); 
  loginPage.clickLogin();
  
  String warningMSG=commons.getToastMSG(driver);
  AssertJUnit.assertTrue(warningMSG.equals("Incorrect username or password.") || warningMSG.equals("User does not exist.") || warningMSG.equals("Temporary password has expired and must be reset by an administrator."));
  Reporter.log("Invalid login verification testcase is passed");
  Thread.sleep(5000);
  } 
 
  }
  
  
  }
  
  
/*
 * driver.findElement(By.className("toast-message"));
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * Reporter.log("check 2 "+downloadToast,true); //
 * ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
 * "toast-container"))); String
 * downloadToastMess=downloadToast.getAttribute("aria-label");
 */