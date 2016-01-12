package com.shmlv3b_maven.pageobjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shmlv3b_maven.genericLib.Constants;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class LetReceiverChooseTheMethodObjects extends WebDriverCommonLib{

	/**
	 *  Create Label Objects
	 */
	
	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//a[text()='SEND']")
	private WebElement sendTab;
	
	
	@FindBy(xpath="//span[contains(text(),'receiver choose his')]")
	private WebElement letReceiverChooseDeliveryTab;
	
	
	@FindBy(id="edit_weight_chosen")
	private WebElement clickOnTheWeightDropDown;
	
	
	@FindBy(xpath="//li[contains(text(),'0-2 kg')]")
	private WebElement selectTheValue0_2kgTab;
	
	
	@FindBy(xpath="//label[div[span[contains(text(),'Confirmation of receipt')]]]//preceding-sibling::span//input")
	private WebElement confirmationOfReceiptCheckBox;
	
	@FindBy(id="edit-notification-type-value")
	private WebElement enterTheEmailId;
	
	
	@FindBy(xpath="//label[div[span[contains(text(),'Insurance')]]]//preceding-sibling::span//input")
	private WebElement insuranceCheckBox;
	
	
	
	public void performOperation_OnCreateLabelPage() throws InterruptedException{
		
		
		
		letReceiverChooseDeliveryTab.click();
		Thread.sleep(3000);
		clickOnTheWeightDropDown.click();
		selectTheValue0_2kgTab.click();
		Thread.sleep(4000);
	//	confirmationOfReceiptCheckBox.click();
	//	enterTheEmailId.sendKeys(Constants.emailID);
		
		
	}
	
	
	/**
	 *  Destination Page
	 */
	
	@FindBy(id="edit-name")
	private WebElement enterName;
	
	@FindBy(id="edit-email")
	private WebElement enterEmailId;
	
	@FindBy(xpath="//label[img[contains(@src,'Home-or-office-address.png')]]//preceding-sibling::span//input")
	private WebElement homeOrOfficeCheckBox;
	
	
	@FindBy(xpath="//label[img[contains(@src,'Parcel-locker.png')]]//preceding-sibling::span//input")
	private WebElement parcelLockerCheckBox;
	
	
	@FindBy(xpath="//label[img[contains(@src,'bpost-delivery-point.png')]]//preceding-sibling::span//input")
	private WebElement bpostDeliveryPointCheckBox;
	
	
	@FindBy(xpath="//label[div[@id='send-own-mail']]//preceding-sibling::span//input")
	private WebElement radioButton1;
	
	
	public void performOperation_onDestinationPage(){
		
		enterName.sendKeys(Constants.name);
		enterEmailId.sendKeys(Constants.emailID);
		
		if(homeOrOfficeCheckBox.isSelected()){
		
		}else{
			homeOrOfficeCheckBox.click();
		}
		
		
		if(parcelLockerCheckBox.isSelected()){
			
		}else{
			parcelLockerCheckBox.click();
		}
		
		if(bpostDeliveryPointCheckBox.isSelected()){
			
		}else{
			bpostDeliveryPointCheckBox.click();
		}
		
		
		radioButton1.click();
		
	}
	
	
	
	
	/**
	 *   Sender Page
	 */
	
	
	
	@FindBy(id="edit_title_chosen")
	private WebElement clickOnTitleDropDown;
	
	@FindBy(xpath="//li[text()='Mr.']")
     private WebElement selectTheMr_text;
	
	
	@FindBy(id="edit-first-name")
	private WebElement enterTheFirstName;
	
	
	@FindBy(id="edit-last-name")
	private WebElement enterLastName;
	
	@FindBy(id="edit-street")
	private WebElement fillStreetName;
	
	@FindBy(id="edit-nr")
	private WebElement fillNrValue;
	
	@FindBy(id="edit-contact-email")
	private WebElement enterEmailIdnw;
	
	
	@FindBy(id="edit-submit")
	private WebElement addToBasketbutton;
	
	
	@FindBy(id="edit_city_chosen")
	private WebElement clickOnPostalCodeAndcityDropdown;
	
	
	@FindBy(xpath="//li[contains(text(),'1000 Brussel')]")
	private WebElement selectTheValueFromDropDown;
	
	
	
	
	public void performOperationOn_senderPage() throws InterruptedException{
		
		scrollingThePage();
		Thread.sleep(3000);
		clickOnTitleDropDown.click();
		selectTheMr_text.click();
		enterTheFirstName.clear();
		enterTheFirstName.sendKeys(Constants.firstName);
		enterLastName.clear();
		enterLastName.sendKeys(Constants.lastName);
		fillStreetName.clear();
		fillStreetName.sendKeys(Constants.streetName2);
		fillNrValue.clear();
		fillNrValue.sendKeys(Constants.nrvalue2);
        clickOnPostalCodeAndcityDropdown.click();
		selectTheValueFromDropDown.click();
		enterEmailIdnw.clear();
		enterEmailIdnw.sendKeys(Constants.emailId2);
		
		addToBasketbutton.click();
		waitForPageToLoad();
		
	}
	
  
	
}
