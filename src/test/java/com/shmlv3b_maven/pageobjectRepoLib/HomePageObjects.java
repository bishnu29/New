package com.shmlv3b_maven.pageobjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class HomePageObjects extends WebDriverCommonLib {

	
	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//a[text()='HOME']")
	private WebElement homeTab;
	
	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//a[text()='SEND']")
	private WebElement sendTab;
	
	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//a[text()='PICKUP']")
	private WebElement pickupTab;
	
	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//img[contains(@src,'cart.png')]")
	private WebElement basketTab;
	
	
	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//a[text()='MY SHIPMENTS']")
	private WebElement my_shipmentTab;
	
	
	@FindBy(xpath="//header[@id='header']//span[text()='My account']")
	private WebElement loginLink;
	
	@FindBy(xpath="//header[@id='header']//a[text()='Help']")
	private WebElement helpLink;
	
	@FindBy(xpath="//header[@id='header']//a[text()='Contact']")
	private WebElement contactLink;
	
	
	@FindBy(xpath="//header[@id='header']//a[text()='NL']")
	private WebElement nl_Link;
	
	@FindBy(xpath="//header[@id='header']//a[text()='FR']")
	private WebElement fr_Link;
	
	@FindBy(xpath="//header[@id='header']//a[text()='EN']")
	private WebElement en_Link;
	
	@FindBy(xpath="//a[text()='Register here']")
	private WebElement registerHereLink;
	
	@FindBy(id="")
	private WebElement obj13;
	
	@FindBy(id="")
	private WebElement obj14;
	
	@FindBy(id="")
	private WebElement obj15;
	
	@FindBy(id="")
	private WebElement obj16;
	
	@FindBy(id="")
	private WebElement obj17;
	
	
	
	public void clickOnHomeTab(){
		homeTab.click();
		
	}
	
	public boolean checkWhetherAllTheFiveMenusArePresentOrNot(){
		
		return homeTab.isDisplayed()&&sendTab.isDisplayed()&&
				pickupTab.isDisplayed()&&basketTab.isDisplayed()&&
				my_shipmentTab.isDisplayed();
	}
	
	public boolean checkWhetherTheLinksArePresentOrNot(){
		
		return loginLink.isDisplayed()&&helpLink.isDisplayed()
				&&contactLink.isDisplayed()&&nl_Link.isDisplayed()
				&&fr_Link.isDisplayed()&&en_Link.isDisplayed();
		
	}
	
	
	public void clickOnLoginLinkAndNavigateToRegisterPage(){
		
		loginLink.click();
		waitForPageToLoad();
		registerHereLink.click();
		waitForPageToLoad();
		
	}
	
	
}
