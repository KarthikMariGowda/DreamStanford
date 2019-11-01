package com.dreamorbit.scripts;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.generic.FWUtils;

	public class TestValidLogin extends BaseTest
	{	
	@Test(priority = 1,enabled= true)
	 public void testValidlogin() throws InterruptedException
		  {
		  Commons commons= new Commons();
		  commons.login(driver);
		  FWUtils.verifyPage(driver,studyUrl);
	  } 
	  
}
