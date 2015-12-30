package com.shmlv3b_maven.pageobjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyingTheParcelObects {

	@FindBy(xpath="//div[@id='content']//preceding-sibling::div[@id='navigation']//a[text()='MY SHIPMENTS']")
	private WebElement myShipmentTab;
	
	@FindBy(linkText="Completed Shipments")
	private WebElement completedTab;
	
	@FindBy(xpath="//thead[tr[th[contains(text(),'Recipient')]]]//following-sibling::tbody//tr[1]//td//div[contains(text(),'receiver_001')]")
	private WebElement verifyReceiverName;
	
	@FindBy(xpath="//thead[tr[th[contains(text(),'Recipient')]]]//following-sibling::tbody//tr[1]//td[5]//a")
	private WebElement barCodeInMyShipmentTab;
	
	
	public void clickOnMyShipmenttab(){
		myShipmentTab.click();
	}
	
	public void clickOnCompletedTab(){
		completedTab.click();
	}
	
	public String verifyingTheOrderedParcelByReceiverName(){
		
		return verifyReceiverName.getText();
		
	}
	
	public String getTheBarCodeFromMyshipmentPage(){
		return barCodeInMyShipmentTab.getText();
	}
	
}
