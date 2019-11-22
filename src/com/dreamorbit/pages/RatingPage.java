/*
 * package com.dreamorbit.pages;
 * 
 * import java.util.List;
 * 
 * import org.openqa.selenium.Dimension; import org.openqa.selenium.WebDriver;
 * import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory;
 * 
 * public class RatingPage {
 * 
 * @FindBy(xpath="//rating[@class='rating ng-untouched ng-pristine ng-valid']")
 * private WebElement ratings;
 * 
 * @FindBy(xpath="//span[@id='showhide']") private WebElement showHideBTN;
 * 
 * 
 * public RatingPage(WebDriver driver)//Initialization to handle stale element
 * exception { PageFactory.initElements(driver,this); }
 * 
 * 
 * public void ratings()//Utilization methods { String activeRatings=
 * ratings.getText("dd"); // System.out.println("ratings >> "+activeRatings +
 * "Length "+activeRatings.length()); //for(int
 * i=0;i<activeRatings.length();i++) // activeRatings.get(i);
 * 
 * }
 * 
 * public void clrUN() { //unTB.clear(); }
 * 
 * }
 */