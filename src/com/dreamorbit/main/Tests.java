/*
 * package com.dreamorbit.main;
 * 
 * import org.testng.annotations.Test; import org.testng.AssertJUnit; import
 * org.testng.annotations.Test; import org.testng.Assert; import
 * org.testng.AssertJUnit; import org.openqa.selenium.By; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.AssertJUnit;
 * import org.testng.Reporter; import org.testng.annotations.Test;
 * 
 * import com.dreamorbit.drivers.DriverUtils; import
 * com.dreamorbit.generic.PhCommons;
 * 
 * public class Tests extends DriverUtils
 * 
 * {
 * 
 * PhCommons commons = new PhCommons();
 * 
 * 
 * @Test void loginVerification() throws InterruptedException {
 * Thread.sleep(4000); commons.login();
 * //ewait.until(ExpectedConditions.urlToBe(
 * "https://qa-walktest.phaware.global/organization/127/studies")); String
 * act_title = driver.getCurrentUrl();
 * 
 * try { AssertJUnit.assertEquals(act_title,
 * "https://qa-walktest.phaware.global/organization/127/studies");
 * Reporter.log("Loging test case is passed"); } catch (AssertionError e) {
 * Reporter.log("Login test case is failed"); AssertJUnit.fail(); } }
 * 
 * @Test
 * 
 * void participantNavigationFlowCheck() throws InterruptedException {
 * //WebDriverWait ewait = new WebDriverWait(driver, 20);
 * //ewait.until(ExpectedConditions.urlToBe(
 * "https://qa-walktest.phaware.global/organization/127/studies"));
 * commons.login(); commons.participantClick(); WebDriverWait wait= new
 * WebDriverWait(driver,10);
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//th[.='Uploads']"))); String participantScreen_url=driver.getCurrentUrl();
 * try { AssertJUnit.assertEquals(participantScreen_url,
 * "https://qa-walktest.phaware.global/organization/127/studies/19/participants"
 * ); Reporter.log("Testcase pass"); } catch (Exception e) {
 * 
 * Reporter.log("Testcase failed"); AssertJUnit.fail(); e.printStackTrace(); }
 * 
 * }
 * 
 * 
 * 
 * 
 * @Test void multipleCsvDownloadCheck() throws InterruptedException {
 * 
 * //ewait.until(ExpectedConditions.urlToBe(
 * "https://qa-walktest.phaware.global/organization/127/studies"));
 * 
 * commons.login(); //ewait.until(ExpectedConditions.urlToBe(
 * "https://qa-walktest.phaware.global/organization/127/studies"));
 * commons.participantClick(); Thread.sleep(6000); commons.
 * multipleCheckboxSelection("//input[contains(@id ,'content-checkbox-')]");
 * commons.csvDownloadClick(); }
 * 
 * @Test void multipleJsonDownloadCheck() throws InterruptedException {
 * commons.login(); commons.participantClick(); Thread.sleep(5000); commons.
 * multipleCheckboxSelection("//input[contains(@id ,'content-checkbox-')]");
 * commons.jsonDownloadClick();
 * 
 * 
 * }
 * 
 * }
 */