package com.shmlv3b_maven.pageobjectRepoLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shmlv3b_maven.genericLib.Constants;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class BpostDeliverypointObjects extends WebDriverCommonLib{

	/**
	 *  Create label page
	 */
	
	@FindBy(xpath="//span[img[contains(@src,'more_info.png')]]//preceding-sibling::span[text()='bpost delivery point']")
	private WebElement selectBpostDeliveryPoint;
	

	@FindBy(id="edit_weight_chosen")
	private WebElement clickOnTheWeightDropDown;
	
	
	@FindBy(xpath="//li[contains(text(),'0-2 kg')]")
	private WebElement selectTheValue0_2kgTab;
	
	
	public void performOperationOn_createLabelPage() throws InterruptedException{
		
		selectBpostDeliveryPoint.click();
		Thread.sleep(3000);
		
		clickOnTheWeightDropDown.click();
		Thread.sleep(2000);
		selectTheValue0_2kgTab.click();
		
		Thread.sleep(3000);
		
	}
	
	/**
	 *  Destination page
	 */
	
	@FindBy(id="edit-name")
	private WebElement enterName;
	
	
	@FindBy(id="edit-email")
	private WebElement enterMail;
	
	
	@FindBy(id="edit-phone")
	private WebElement enterPhoneNumbr;
	
	@FindBy(xpath="//ul[@id='service-point']//li[1]/div")
	private WebElement selecTheFirstAddress;
	
	@FindBy(xpath="//input[@value='Select this delivery point']")
	private WebElement clickOnSelectTheDeliverypoint;
	
	@FindBy(id="edit-enter-bpack-address")
	private WebElement enterPostalCode;
	
	
	public void performOperationOn_DestinationPage() throws InterruptedException{
		
		enterName.sendKeys(Constants.name);
		enterMail.sendKeys(Constants.emailID);
		enterPhoneNumbr.sendKeys(Constants.phNumber);
		scrollingThePage();
		waitForElementPresentById("edit-enter-bpack-address");
		Thread.sleep(4000);
		System.out.println("Before entering Postal code");
		enterPostalCode.sendKeys("1000",Keys.ENTER);
		Thread.sleep(4000);
		System.out.println("After entering Postal code");
		selecTheFirstAddress.click();
		clickOnSelectTheDeliverypoint.click();
		
	}
	
	
	/**
	 *   Sender page
	 */
	
	
	
}
