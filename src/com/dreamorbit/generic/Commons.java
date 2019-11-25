package com.dreamorbit.generic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.dreamorbit.main.NavigationDrawerPage;
import com.dreamorbit.pages.LoginPage;
import com.dreamorbit.pages.ParticipantPage;
import com.dreamorbit.pages.ResearcherPage;
import com.dreamorbit.pages.SymmetricKeyPage;

public class Commons implements IAutoConstant

{
	long epochTime;
	public String epochEmail;
	public String partialEpochEmail;
	public String nonExistingEmailID;

	BaseTest baseTest = new BaseTest();

	// Constructor to define epoch time

	public Commons() // When ever the Commons constructor is called or object is created a unique
						// epoch time is generated -CONSTRUCTOR
	{
		Date today = Calendar.getInstance().getTime();// gets today
		// Constructs a SimpleDateFormat using the given pattern
		SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
		// format() formats a Date into a date/time string.
		String currentTime = crunchifyFormat.format(today);// will get current time of the day

		// parse() parses text from the beginning of the given string to produce a date.
		Date date = null;
		try {
			date = crunchifyFormat.parse(currentTime);// on passing current time will get date
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00
		// GMT represented by this Date object.
		epochTime = date.getTime(); // using the date we can get epoch time using getTime();
	}

	public Long getEpochTime() {
		return epochTime;
	}

	// Handling Toasts and Alerts
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

	public String getAlertMSG(WebDriver driver) throws InterruptedException {

		WebElement AlertBox = driver.findElement(By.className("swal2-validationerror"));
		String AlertMesg = AlertBox.getText();
		return AlertMesg;

	}

	// Commonly used Methods

	// Login

	public void login(WebDriver driver) {
		LoginPage loginPage = new LoginPage(driver);
		String un = baseTest.read_XL_Data(XL_DATA_PATH, "ValidLoginData", 1, 0);
		String pwd = baseTest.read_XL_Data(XL_DATA_PATH, "ValidLoginData", 1, 1);
		loginPage.setUN(un);
		loginPage.setPWD(pwd);
		loginPage.clickLogin();
	}

	// Adding researcher
	public void addResearcher(WebDriver driver, String Emailid) throws InterruptedException {

		Commons commons = new Commons();
		ResearcherPage researcherPage = new ResearcherPage(driver);
		SymmetricKeyPage symmetricKeyPage = new SymmetricKeyPage(driver);
		WebDriverWait ewait = new WebDriverWait(driver, ETO);

		/*
		 * int rowCount = baseTest.xl_RowCount(XL_DATA_PATH, "ValidResearcherEmails");
		 * Reporter.log("RowCount=" + rowCount, true); for (int i = 1; i <= rowCount;
		 * i++) {
		 * 
		 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		commons.researchersScreenWait(driver);

		researcherPage.addResearcherClick();
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/ic_save.png']")));

		Long epochTime = commons.getEpochTime();// calls getEpochTime() method
		// Reporter.log(vEmailid.replace("@", epochTime + "@"), true);// replaces @ with
		// epoch time and then appends @
		epochEmail = Emailid.replace("@", "+" + epochTime + "@");
		researcherPage.setEmailAddress(epochEmail);// replaces @ with epoch time
													// appends "+" before epoch time
													// example-
													// karthik.m+11454544@dreamorbit.com
		partialEpochEmail = epochEmail.replace("+" + epochTime + "@gmail.com", "");

		researcherPage.tickButtonClick();
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swalSymmetricKey")));
		symmetricKeyPage.sendSymmetricKey(sKey);
		symmetricKeyPage.sK_clickOk();
		Thread.sleep(5000);

		// nonExistingEmailID = baseTest.read_XL_Data(XL_DATA_PATH,
		// "NonExistingResearcherEmail", 1, 0);- TO BE CHECKED

	}

//Participant personal info
	public String decryptPersonalInfo(WebDriver driver) throws InterruptedException {
		BaseTest baseTest = new BaseTest();
		ParticipantPage participantPage = new ParticipantPage(driver);
		SymmetricKeyPage symmetricKeyPage = new SymmetricKeyPage(driver);
		String validSKEY = baseTest.read_XL_Data(XL_DATA_PATH, "SymmtricKeyValid", 1, 0);
		Commons commons = new Commons();

		participantPage.personalDecryptClick();
		symmetricKeyPage.sendSymmetricKey(validSKEY);
		symmetricKeyPage.sK_clickOk();
		commons.toastwait(driver);
		String aPersonalInfoDecrptToast = commons.getToastMSG(driver);
		return aPersonalInfoDecrptToast;
	}
//Second row Json download

	public void downloadJson(WebDriver driver) {

		BaseTest baseTest = new BaseTest();
		ParticipantPage participantPage = new ParticipantPage(driver);
		SymmetricKeyPage symmetricKeyPage = new SymmetricKeyPage(driver);

		String validSKEY = baseTest.read_XL_Data(XL_DATA_PATH, "SymmtricKeyValid", 1, 0);

		participantPage.fileJsonClick();
		symmetricKeyPage.sendSymmetricKey(validSKEY);
		symmetricKeyPage.sK_clickOk();
	}

	
	
	
	// Waits

	public void toastwait(WebDriver driver) {

		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

	}

	public void studiesScreenWait(WebDriver driver) {

		String VerifytokenLoc = "//*[@id=\"page-wrapper\"]/div/div[2]/div/div/app-studies/div[2]/div/table/tbody/tr/td[5]/ui-switch/span";
		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VerifytokenLoc)));
	}

	public void researchersScreenWait(WebDriver driver) {

		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='insert-more']")));
	}

	public void participantListScreenWait(WebDriver driver) {

		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Decrypt']")));
	}

	public void participantScreenWait(WebDriver driver) {

		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='View Uploads']")));
	}

	public void personalInfoScreenWait(WebDriver driver) {

		WebDriverWait ewait = new WebDriverWait(driver, ETO);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Decrypt']")));
	}

}
