package com.shmlv3b_maven.pageobjectRepoLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shmlv3b_maven.genericLib.Constants;
import com.shmlv3b_maven.genericLib.Driver;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class ParcelLockerDeliveryObjects extends WebDriverCommonLib{

	
	WebDriverWait wait = new WebDriverWait(Driver.driver, 10);
	
	/**
	 *  Perform Operation on Create label page
	 */
	
	@FindBy(xpath="//span[contains(text(),'Parcel locker')]")
	private WebElement parcelLockerDeliverMethod;
	
	@FindBy(id="edit_weight_chosen")
	private WebElement clickOnTheWeightDropDown;
	

	@FindBy(xpath="//label[div[span[contains(text(),'Confirmation of receipt')]]]//preceding-sibling::span//input")
	private WebElement confirmationOfReceiptCheckBox;
	
	@FindBy(id="edit-notification-type-value")
	private WebElement enterTheEmailId;
	
	
	
	@FindBy(xpath="//li[contains(text(),'0-2 kg')]")
	private WebElement selectTheValue0_2kgTab;
	
    
	@FindBy(id="edit-next")
	private WebElement nextButton;
	
	
	@FindBy(id="create-label-service")
	private WebElement checkBoxBlock;
	
	
	public void performOperationOn_createlabelPage() throws InterruptedException{
		
		parcelLockerDeliverMethod.click();
		scrollingToBottomofAPage();
		//Thread.sleep(3000);
		clickOnTheWeightDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(selectTheValue0_2kgTab));
		selectTheValue0_2kgTab.click();
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(checkBoxBlock));
		
   if(confirmationOfReceiptCheckBox.isSelected()){
			
		}else{
			confirmationOfReceiptCheckBox.click();
	
		}
		
        wait.until(ExpectedConditions.visibilityOf(enterTheEmailId));
		enterTheEmailId.clear();
		enterTheEmailId.sendKeys(Constants.emailID);
		
		/*
		clickOnTheWeightDropDown.click();
		selectTheValue0_2kgTab.click();
		
		enterTheEmailId.clear();
		enterTheEmailId.sendKeys(Constants.emailID);
		*/
		
	}
	
	
	/**
	 *  Destination page
	 */
	
	
	@FindBy(id="edit-name")
	private WebElement nameOfTheReceiver;
	
	@FindBy(id="edit-email")
	private WebElement enterTheEmailOfTheReceiver;
	
	@FindBy(xpath="//input[@id='edit-email' and @class='form-text']")
	private WebElement enterEmail;
	
	@FindBy(id="edit-mob-zone")
	private WebElement mobilityZone;
	
	@FindBy(id="edit-enter-bpack-address")
	private WebElement enterParcelLockerZipCode;
	
	//@FindBy(xpath="//li[@id='14472']")
	//private WebElement selectTheFirstAddress;
	
	@FindBy(xpath="//div[text()='BPACK De Brouckere bpost']")
	private WebElement selectTheFirstAddress;
	
	@FindBy(xpath="//input[@value='Deliver here!']")
	private WebElement clickOnDeliverHereOnTheMap;
	
	@FindBy(xpath="//a[@title='Click to see this area on Google Maps']//img")
	private By googleImgOnGoogleMap;
	
	@FindBy(xpath="//a[@title='Click to see this area on Google Maps']//img")
	private WebElement googleImgOnGoogleMapWB;
	
	
	@FindBy(id="edit-next")
	private WebElement nextBtn;
	
	
	
	
	public void performOperationOn_destinationPage() throws InterruptedException{
		
		nameOfTheReceiver.sendKeys(Constants.name);
		enterTheEmailOfTheReceiver.sendKeys(Constants.emailID);
		enterTheEmailOfTheReceiver.sendKeys(Keys.SPACE);
		mobilityZone.click();
		enterTheEmailOfTheReceiver.sendKeys(Keys.SPACE);
		enterParcelLockerZipCode.sendKeys("1000"+Keys.ENTER);
		
		Thread.sleep(4000);
		enterTheEmailOfTheReceiver.sendKeys(Keys.DOWN);
		selectTheFirstAddress.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = ((JavascriptExecutor) Driver.driver);
		js.executeScript("scroll(0, -00);");
		
//		selectTheFirstAddress.sendKeys(Keys.UP,Keys.UP,Keys.UP,Keys.UP,Keys.UP);
		//waitForElementPresent("//input[@value='Deliver here!']");
		Thread.sleep(8000);
		clickOnDeliverHereOnTheMap.click();
		Thread.sleep(6000);
		//clickOnDeliverHereOnTheMap.click();
	//	scrollingThePage();
			
	}
	
	
	public void fillTheDataOn_DestinationPage(){
		
		nameOfTheReceiver.sendKeys(Constants.name);
		enterEmail.sendKeys(Constants.emailID);
		enterParcelLockerZipCode.sendKeys("1000"+Keys.ENTER);
		scrollingThePage();
		//System.out.println("After Entering Postal Code");
		wait.until(ExpectedConditions.visibilityOf(googleImgOnGoogleMapWB));
		//System.out.println("After Waiting for Google Image");
		selectTheFirstAddress.click();
		//System.out.println("After Selecting the 1st Address");
		wait.until(ExpectedConditions.visibilityOf(clickOnDeliverHereOnTheMap));
		//System.out.println("After visibility of Deliver Here pop up");
		clickOnDeliverHereOnTheMap.click();
		//System.out.println("After Clicking on the Deliver Here pop up");
		wait.until(ExpectedConditions.visibilityOf(nextBtn));
		//System.out.println("After invisibility of Google map ");
		//nextBtn.click();
		System.out.println("After clicking on the next button");
		
		
		
	}
	
}
