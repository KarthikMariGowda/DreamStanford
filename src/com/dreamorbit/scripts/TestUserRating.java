
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
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;
import com.dreamorbit.generic.Commons;
import com.dreamorbit.main.NavigationDrawerPage;
import com.dreamorbit.pages.RatingPage;

public class TestUserRating extends BaseTest {

	int sum = 0;
	List<WebElement> Stars;

	@Test(priority = 25, enabled = true)
	public void ratingAvgCheck() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		RatingPage ratingPage = new RatingPage(driver);
		Commons commons = new Commons();
		NavigationDrawerPage navigationDrawerPage = new NavigationDrawerPage(driver);
		commons.login(driver);
		commons.studiesScreenWait(driver);
		Thread.sleep(5000);
		navigationDrawerPage.nDRatingClick();
		Thread.sleep(8000);

		// To scroll till the bottom of the screen

		try {
			do {
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			} while (ratingPage.lodingIconVisibility() == true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(4000);
//AVG Chk
		double sum = sum();
		System.out.println(sum);
		double eAvgRating = avg();
		double eAVGRating = Math.round(eAvgRating * 10.0) / 10.0;
		String eAverageRating = Double.toString(eAVGRating);

		System.out.println(eAVGRating);
		String aAvgrating = ratingPage.aAvgRating();
		//double eAvgrating = Double.parseDouble(aAvgrating);
		// int aAVGRating = (int) r;
		AssertJUnit.assertEquals(eAverageRating, aAvgrating);
		Reporter.log("Calculated Average rating and displayed average ratings are matching- testcase passed",true);
		
//NoUserChk
		
		int eNoUsersRated = noUsersRated();
		String eNoUsersRatedText = "Based on "+eNoUsersRated+" ratings";
		String aNoUsersRatedText= ratingPage.aNoUsersGetText();
		
		AssertJUnit.assertEquals(eNoUsersRatedText, aNoUsersRatedText);
		Reporter.log("Actual displayed number of users and expected number of users are matching- testcase passed",true);

		
	}

	double avg() {
		double sum = sum();
		double noUsersRated = Stars.size();
		double avgRating = sum / noUsersRated;
		return avgRating;
	}

	int noUsersRated() {
		int noUsers = Stars.size();
		return noUsers;
	}

	double sum() {
		Stars = driver.findElements(By.xpath("//span[@class='rating readonly']"));

		// System.out.println(Stars.size());

		sum = 0;
		for (int i = 0; i < Stars.size(); i++) {

			WebElement aStar = Stars.get(i);
			String ariaValuenow = aStar.getAttribute("aria-valuenow");

			try {
				double d = Double.parseDouble(ariaValuenow);
				int result = (int) d;
				sum = sum + result;
				// System.out.println(sum);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sum;

	}

}
