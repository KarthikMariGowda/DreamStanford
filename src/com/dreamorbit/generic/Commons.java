package com.dreamorbit.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.dreamorbit.pages.LoginPage;
import com.dreamorbit.pages.ResearcherPage;
import com.dreamorbit.pages.StudiesPage;

public class Commons implements IAutoConstant {
	BaseTest baseTest = new BaseTest();

	public String getToastMSG(WebDriver driver) throws InterruptedException {
		WebElement toastBOX = driver.findElement(By.className("toast-message"));
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		String toastMSG = toastBOX.getAttribute("aria-label");
		return toastMSG;

	}

	public Boolean isAlertMSGDisplayed(WebDriver driver) throws InterruptedException {

		WebElement AlertBox = driver.findElement(By.className("swal2-validationerror"));
		Boolean AlertMSG = AlertBox.isDisplayed();
		String AlertMds1 = AlertBox.getText();
		Reporter.log(AlertMds1);
		return AlertMSG;

	}

	public String AlertMSG(WebDriver driver) throws InterruptedException {

		WebElement AlertBox = driver.findElement(By.className("swal2-validationerror"));

		String AlertMds1 = AlertBox.getText();
		return AlertMds1;

	}

	public void toastwait(WebDriver driver) {

		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));

	}

	public void login(WebDriver driver) {
		LoginPage loginPage = new LoginPage(driver);
		String un = baseTest.read_XL_Data(XL_DATA_PATH, "ValidLoginData", 1, 0);
		String pwd = baseTest.read_XL_Data(XL_DATA_PATH, "ValidLoginData", 1, 1);

		loginPage.setUN(un);
		loginPage.setPWD(pwd);
		loginPage.clickLogin();
	}

	public void studiesScreenWait(WebDriver driver)
	{
		
		String VerifytokenLoc = "//*[@id=\"page-wrapper\"]/div/div[2]/div/div/app-studies/div[2]/div/table/tbody/tr/td[5]/ui-switch/span";
		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VerifytokenLoc)));
	}

	public void researchersScreenWait(WebDriver driver) {
		
		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='insert-more']")));
	}
}
