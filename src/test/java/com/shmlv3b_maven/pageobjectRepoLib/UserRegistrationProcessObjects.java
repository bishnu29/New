package com.shmlv3b_maven.pageobjectRepoLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shmlv3b_maven.genericLib.Driver;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class UserRegistrationProcessObjects extends  WebDriverCommonLib{

	@FindBy(xpath="//img[contains(@src,'u51.png')]//following-sibling::span/a")
	private WebElement registerLink_inHomePage;
	
	@FindBy(id="facebook")
	private WebElement facebookButton;
	
	@FindBy(id="gmail")
	private WebElement googleButton;
	
	@FindBy(id="edit_title_chosen")
	private WebElement titleDropdown;
	
	
	@FindBy(id="edit-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="edit-lastname")
	private WebElement lastNameField;
	
	
	@FindBy(name="birthdate[date]")
	private WebElement birthdayField;
	
	@FindBy(id="edit_preferredlanguage_chosen")
	private WebElement prefixDropdown;
	
	@FindBy(id="edit-mobilenumber")
	private WebElement mobileNumberField;
	
	@FindBy(id="edit-username")
	private WebElement emailIDField;
	
	@FindBy(xpath="//label[contains(text(),'Password')]//following-sibling::input")
	private WebElement passwordField;
	
	@FindBy(xpath="//label[contains(text(),'Confirm password')]//following-sibling::input")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//div[@id='checkboxproduct']//span")
	private WebElement firstCheckBox;
	
	@FindBy(xpath="//div[@id='checkboxpproduct']//span")
	private WebElement secCheckBox;
	
	@FindBy(xpath="//div[@id='terms']//span")
	private WebElement thirdCheckBox;
	
	@FindBy(id="edit-submit")
	private WebElement registerButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @Description
	 *        This method will click on Register link which is present on the home page and 
	 *        and try to fetch the title of the next window is opened.
	 * @return
	 *          This method will return The title of the page which is opened while clicking on
	 *           register link in the home page.
	 */
	public String clickOnRegisterLink(){
		
		registerLink_inHomePage.click();
		waitForPageToLoad();
	   Set<String> set = Driver.driver.getWindowHandles();
	   System.out.println(set.size());
	   Iterator<String> it = set.iterator();
	   String parentId = it.next();
	   System.out.println(parentId);
	   String childID = it.next();
	   System.out.println(childID);
	    waitForPageToLoad();
	    Driver.driver.switchTo().window(childID);
	    
		return Driver.driver.getTitle();
	
		
	}
	
	
	public boolean checkForGoogleAndFacebookRegistration(){
		
		return facebookButton.isDisplayed()&& googleButton.isDisplayed();
		
	}
	
	
	public boolean verifyTheTitleDropDown(){
		return titleDropdown.isDisplayed();
	}
	
	public boolean verifyingTheFirstNameField(){
		return firstNameField.isDisplayed();
	}
	
	public boolean verifyingTheLastNameField(){
		return lastNameField.isDisplayed();
		
	}
	
	public boolean verifyingTheBirthdayField(){
		return birthdayField.isDisplayed();
	}
	
	public boolean verifyingThePrefixDropdown(){
		return prefixDropdown.isDisplayed();
	}
	
	public boolean verifyingTheMobileNumbrField(){
		return mobileNumberField.isDisplayed();
	}
	
	public boolean verifyingEmailIDField(){
		return emailIDField.isDisplayed();
		
	}
	
	public boolean verifyingPasswordField(){
		return passwordField.isDisplayed();
	}
	
	public boolean verifyingConfirmPasssword(){
		return confirmPasswordField.isDisplayed();
	}
	
	public boolean verifyingTheTermsAndConditionsCheckbox(){
		
		
		return thirdCheckBox.isDisplayed();
	}
	
	public boolean verifyingTheFirstCheckBox(){
		return firstCheckBox.isDisplayed();
	}
	
	public boolean verifyingTheSecondCheckBox(){
		return secCheckBox.isDisplayed();
	}
	
	
	
	public boolean verifyingTheRegisterBtn(){
		return registerButton.isDisplayed();
	}
}
