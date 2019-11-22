
  package com.dreamorbit.scripts;
  
  import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import
  com.dreamorbit.generic.Commons;
import com.dreamorbit.main.NavigationDrawerPage; 
  
  
  public class TestStar extends BaseTest {
  
  @Test(priority = 25, enabled = true)
  public void navigationFlowCheck() throws InterruptedException 
  { 
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  Commons commons = new Commons();
	  NavigationDrawerPage navigationDrawerPage= new NavigationDrawerPage(driver);
  commons.login(driver); 
  commons.studiesScreenWait(driver);
  Thread.sleep(5000);
  navigationDrawerPage.nDRatingClick();
  Thread.sleep(8000);
		
		 /* WebElement lastElement= driver.findElement(By.xpath(
		  "//div[@title='e2edc68f28c5370b4b65bfb324bda473eaf383c291ed0c875f812ea57ddd01ab@phaware.org']"*/
		 // )); 
  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 
  List<WebElement> Stars = driver.findElements(By.xpath("xpath=/html/body/app-root/app-nav-bar/div/div[2]/div/div[2]/div/div/app-ratings/div/div[2]"));

	for (int i = 0; i < Stars.size(); i++) {
		System.out.println(Stars.size());

		WebElement aStar = Stars.get(i);
		String ariaValuenow = aStar.getAttribute("aria-valuenow");
		int result = Integer.parseInt(ariaValuenow);			
		System.out.println(result);
  } 
	}
  }
 