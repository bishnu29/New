package com.shmlv3b_maven.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shmlv3b_maven.genericLib.Driver;
import com.shmlv3b_maven.pageobjectRepoLib.HomePageObjects;
import com.shmlv3b_maven.pageobjectRepoLib.LoginObjects;

public class HomePageTest {

	
	WebDriver driver;
	LoginObjects loginObjects;
	HomePageObjects homePageObjects;
	
	
	
	@BeforeClass
	public void configBeforeClassMtd() throws IOException{
		
		driver = Driver.getDriver();
		loginObjects = PageFactory.initElements(driver, LoginObjects.class);
		homePageObjects = PageFactory.initElements(driver, HomePageObjects.class);
		
		
	}
	
	@BeforeMethod
	public void configBeforeMtd(){
		
		// Navigate to the Home page of the application.
		loginObjects.navigateToTheHomePage();
	}
	
	/**
	 * @Description
	 *           This method will check for the home page buttons 1. Home,2. Send,3. Plan a pick up,4. Shipment,5. basket page
	 */
	@Test
	public void checkingForTheMenusInHomePage(){
		
		boolean checkForFiveMenus = homePageObjects.checkWhetherAllTheFiveMenusArePresentOrNot();
		Assert.assertTrue(checkForFiveMenus, "All the Five Menus are not displaying in the him page");
		Reporter.log("All the five Menus in home page are successfully displaying");
		
	}
	
	/**
	 * @Description
	 *        This method will check for the Links present in the Home page :: 1.Login , 2.Help , 3.Contact , 4.NL,FR and EN.
	 */
	
	@Test
	public void checkForTheLinksInHomePage(){
		
		boolean checkLinks = homePageObjects.checkWhetherTheLinksArePresentOrNot();
		Assert.assertTrue(checkLinks, "All the Four links are not working");
		Reporter.log("All of the Four links are working ");
	}
	
	/**
	 * @Description
	 *              Check Whether the 'Home' tab is cliable or not.
	 */
	@Test
	public void checkWhetherThe_HomeTab_isClickableOrNot(){
		
		try{
	  homePageObjects.clickOnHomeTab();
		}catch(Throwable e){
			Reporter.log("The 'Home ' tab is not clickable");
			Assert.fail();
		}
	}
	@AfterMethod
	public void configAfterMtd(){
		
	}
	
	@AfterClass
	public void tearDownMtd(){
		
	}
}
