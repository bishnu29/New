package com.shmlv3b_maven.pageobjectRepoLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shmlv3b_maven.genericLib.Constants;
import com.shmlv3b_maven.genericLib.Driver;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class LoginObjects extends WebDriverCommonLib{

	
	
	
	@FindBy(xpath="//header[@id='header']//span[text()='My account']")
	private WebElement myAccount;
	
	@FindBy(id="edit-name")
	private WebElement emailId;
	
	@FindBy(id="edit-pass")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement loginBlock;
	
	@FindBy(xpath="//header[@id='header']//a[text()='Help']")
	private WebElement HelpLink;
	
	@FindBy(xpath="//header[@id='header']//div//div//div[3]")
	private WebElement loginName;
	
	@FindBy(xpath="//header[@id='header']//div//div//div[3]//a[text()='Sign out']")
	private WebElement logOutLink;
	
	@FindBy(id="logout-ok")
	private WebElement okButton;
	
	@FindBy
	private WebElement obj9;
	
	@FindBy
	private WebElement obj10;
	
	@FindBy
	private WebElement obj11;
	
	
	
	public void navigateToTheHomePage(){
		
		
		Driver.driver.get(Constants.url);
		
		Driver.driver.manage().window().maximize();
		waitForPageToLoad();
		
	}
	
	public void loginToTheApplication(){
		
		waitForElementPresent("//header[@id='header']//span[text()='My account']");
		myAccount.click();
		emailId.clear();
		emailId.sendKeys(Constants.loginEmail);
		password.sendKeys(Constants.password,Keys.ENTER);
		
		
		
	}
	
	public void logOutTheApplication() throws InterruptedException {
		
		performMouseHoverOperation(loginName);
		waitForElementPresentById("logout-ok");
		
		logOutLink.click();
		
		okButton.click();
		
		
		
		
		
	}
	
	
	
}
