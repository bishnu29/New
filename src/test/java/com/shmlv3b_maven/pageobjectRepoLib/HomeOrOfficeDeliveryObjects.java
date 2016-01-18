package com.shmlv3b_maven.pageobjectRepoLib;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shmlv3b_maven.genericLib.Constants;
import com.shmlv3b_maven.genericLib.Driver;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class HomeOrOfficeDeliveryObjects extends WebDriverCommonLib{

	WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
	
	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//a[text()='SEND']")
	private WebElement sendTab;
	
	
	@FindBy(xpath="//span[contains(text(),'Home or office')]")
	private WebElement homeOrOfficeDeliveryMethodTab;
	
	
	@FindBy(id="edit_weight_chosen")
	private WebElement clickOnTheWeightDropDown;
	
	
	@FindBy(xpath="//li[contains(text(),'0-2 kg')]")
	private WebElement selectTheValue0_2kgTab;
	
	@FindBy(xpath="//li[contains(text(),'0-2 kg')]")
	private WebElement selectTheValue2_10kgTab;
	
	
	@FindBy(xpath="//li[contains(text(),'0-2 kg')]")
	private WebElement selectTheValue10_30kgTab;
	
	
	@FindBy(id="edit-next")
	private WebElement nextButton;
	
	
	@FindBy(xpath="//label[div[span[contains(text(),'Confirmation of receipt')]]]//preceding-sibling::span//input")
	private WebElement confirmationOfReceiptCheckBox;
	
	@FindBy(id="edit-notification-type-value")
	private WebElement enterTheEmailId;
	
	
	
	@FindBy(xpath="//label[div[span[contains(text(),'nsurance')]]]//preceding-sibling::span//input")
	private WebElement insuranceCheckBox;
	
	
	@FindBy(xpath="//label[div[span[contains(text(),'Payment on delivery')]]]//preceding-sibling::span[@class='custom-checkbox']")
	private WebElement paymentOnDeliveryCheckBox;
	
	@FindBy(id="create-label-service")
	private WebElement checkBoxBlock;
	
	
	
	public void performOperationOn_createLabel_method() throws InterruptedException {
		
		
		homeOrOfficeDeliveryMethodTab.click();
		//scrollingToBottomofAPage();
		//Thread.sleep(3000);
		waitForPageToLoad();
		//selecting the weight dropdown
		clickOnTheWeightDropDown.click();
		waitForPageToLoad();
		wait.until(ExpectedConditions.visibilityOf(selectTheValue0_2kgTab));
		selectTheValue0_2kgTab.click();
		//Thread.sleep(4000);
		
		
		
		wait.until(ExpectedConditions.visibilityOf(checkBoxBlock));
		
		
		

		
	//	clickOnTheWeightDropDown.click();
	//	selectTheValue0_2kgTab.click();
		
		
		//waitForElementPresent("//label[div[span[contains(text(),'Confirmation of receipt')]]]//preceding-sibling::span//input");
		
		
		if(confirmationOfReceiptCheckBox.isSelected()){
			
		}else{
			confirmationOfReceiptCheckBox.click();
	
		}
		
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(enterTheEmailId));
		enterTheEmailId.clear();
		enterTheEmailId.sendKeys(Constants.emailID);
		//Thread.sleep(2000);
		if(insuranceCheckBox.isSelected()){
			
		}else{
			insuranceCheckBox.click();
		}
			
	//	System.out.println(Constants.browser.equals("chrome"));
	//	if(Constants.browser.equals("firefox")){
	//	enterTheEmailId.sendKeys(Constants.emailID);
	//	}
		
	}
	
	public void nextButton(){
		
		nextButton.click();
		waitForPageToLoad();
		
	}
	
	public void clickOnSendTab(){
		sendTab.click();
		waitForPageToLoad();
		
	}
	
	
	/**
	 *  Destination page objects 
	 *  
	 */
	
	
	@FindBy(id="edit-name")
	private WebElement enterName;
	
	
	@FindBy(id="edit-street")
	private WebElement enterStreetName;
	
	
	@FindBy(id="edit-nr")
	private WebElement enterNrValue;
	
	@FindBy(id="edit_city_chosen")
	private WebElement clickOnPostalCodeAndcityDropdown;
	
	
	@FindBy(xpath="//li[contains(text(),'1000 Brussel')]")
	private WebElement selectTheValueFromDropDown;
	
	
	@FindBy(id="edit_country_chosen")
	private WebElement clickOnTheCountryDropDown;
	
	@FindBy(xpath="//li[text()='Belgium']")
	private WebElement selectTheCountry;
	
	
	@FindBy(id="edit-contactemail")
	private WebElement enterTheEmailID;
	
	
	
	
	public void performOperationOn_destinationPage(){
		
		enterName.sendKeys(Keys.SPACE);
		enterName.clear();
		enterName.sendKeys(Constants.name);
		enterStreetName.sendKeys(Constants.sheetName);
		enterNrValue.sendKeys(Constants.nRvalue);
		enterTheEmailID.sendKeys(Constants.emailID);
		clickOnPostalCodeAndcityDropdown.click();
		
		
		selectTheValueFromDropDown.click();
		clickOnTheCountryDropDown.click();
		selectTheCountry.click();
		
	}
	
	
	/**
	 *  Sender page i.e step 3 
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
	private WebElement enterEmailId;
	
	
	@FindBy(id="edit-submit")
	private WebElement addToBasketbutton;
	
	@FindBy(xpath="//label[contains(text(),'New sender address ')]")
     private WebElement selectNewSenderAddress;	
	
	
	public void clickOn_newSenderAddressRadioButton(){
		selectNewSenderAddress.click();
	}
	
	
	public void performOperationOn_senderPage() throws InterruptedException{
		
		scrollingThePage();
		Thread.sleep(2000);
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
		enterEmailId.clear();
		enterEmailId.sendKeys(Constants.emailId2);
		
		addToBasketbutton.click();
		waitForPageToLoad();
		
	}
	
	
	/**
	 *   Basket page
	 */
	
	@FindBy(xpath="//div[h2[text()='Status message']]")
	private WebElement parcelAddedToBasketMsg;
	
	
	@FindBy(xpath="//div[@id='checkout']/span/input")
	private WebElement termsAndConditionCheckBox;
	
	@FindBy(xpath="//button[text()='Pay']")
	private WebElement clickOnPayButton;
	
	
	
	public String fetchTheSuccessfullMessageOfParcelAdded(){
		
		String messagefromOverviewpage = parcelAddedToBasketMsg.getText();
		//System.out.println(messagefromOverviewpage);
		String[] messagefromOverviewpageAfterSplitting = messagefromOverviewpage.split("\\n");
		//System.out.println(messagefromOverviewpageAfterSplitting[0]);
		//System.out.println(messagefromOverviewpageAfterSplitting[1]);
		
		return messagefromOverviewpageAfterSplitting[1];
	}
	
	public void clickOn_termsAndConditionCheckBox(){
		scrollingToBottomofAPage();
		System.out.println("checkbox"+!termsAndConditionCheckBox.isSelected());
		if(!termsAndConditionCheckBox.isSelected()){
		termsAndConditionCheckBox.click();
		}
	}
	
	public void clickOn_payButton(){
		clickOnPayButton.click();
	}
	
}
