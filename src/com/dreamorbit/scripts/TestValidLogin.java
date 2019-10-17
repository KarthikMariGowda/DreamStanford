package com.dreamorbit.scripts;
import org.testng.annotations.Test;
import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.generic.FWUtils;

	public class TestValidLogin extends BaseTest
	{	
@Test(priority = 0)
	 public void login() throws InterruptedException
		  {
		  Commons commons= new Commons();
		  commons.login(driver);
		  	FWUtils.verifyPage(driver,studyUrl);
	  } 
	  
}
