package com.shmlv3b_maven.pageobjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shmlv3b_maven.genericLib.Constants;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;

public class OgonePageObjects extends WebDriverCommonLib{

	
	
	@FindBy(xpath="//input[@name='VISA_brand']")
	private WebElement visaCard;
	
	@FindBy(xpath="//input[@name='Eurocard_brand']")
	private WebElement masterCard;
	
	@FindBy(xpath="//input[@name='BCMC_brand']")
	private WebElement bcmcCard;
	
	@FindBy(xpath="//input[@name='Maestro_brand']")
	private WebElement maestroCard;
	
	@FindBy(id="ncol_cancel")
    private WebElement cancelbutton;
	
	
	
	
	/**
	 * @Description
	 *    This method will click on the visa card.
	 */
	public void clickOn_visaCard(){
		
		visaCard.click();
		
	}
	
	
	@FindBy(id="Ecom_Payment_Card_Name")
	private WebElement cardholdersName;
	
	@FindBy(id="Ecom_Payment_Card_Number")
	private WebElement enterTheCardNumber;
	
	@FindBy(id="Ecom_Payment_Card_ExpDate_Month")
	private WebElement selectTheExpiryMonth;
	
	@FindBy(id="Ecom_Payment_Card_ExpDate_Year")
	private WebElement selectTheExpiryYear;
	
	@FindBy(id="Ecom_Payment_Card_ExpDate_Month_chosen")
	private WebElement clcikOnSelectMonth;
	
	@FindBy(xpath="//div[@id='Ecom_Payment_Card_ExpDate_Month_chosen']//descendant::li[4]")
	private WebElement selectTheMonthFromDropDown;
	
	@FindBy(id="Ecom_Payment_Card_ExpDate_Year_chosen")
	private WebElement clickOnSelectYear;
	
	@FindBy(xpath="//div[@id='Ecom_Payment_Card_ExpDate_Year_chosen']//descendant::li[9]")
	private WebElement selectTheYearFromTheDropDown;
	
	
	
	
	@FindBy(id="Ecom_Payment_Card_Verification")
	private WebElement enterTheVerificationCode;
	
	@FindBy(xpath="//input[@type='submit' and @value='Yes, I confirm my payment']")
	private WebElement clickOn_confirmButton;
	
	
	/**
	 * @Description
	 *      This method will Enter the required fields in the Payment confirmation
	 *       page like Card number,card name,expiry date,verification code and 
	 *       atlast will click on confirm button.  
	 */
	
	public void enterTheDetailsInTheCardDetailsPage(){
		cardholdersName.sendKeys(Constants.cardName);
		enterTheCardNumber.sendKeys(Constants.cardNumber);
		//select(selectTheExpiryMonth, "10");
		//select(selectTheExpiryYear, "2030");
		clcikOnSelectMonth.click();
	    selectTheMonthFromDropDown.click();
	    
	    clickOnSelectYear.click();
	    selectTheYearFromTheDropDown.click();
		enterTheVerificationCode.sendKeys(Constants.verificationCode);
		clickOn_confirmButton.click();
		
		
	}
	
	
	/* click on the download button */
	
	@FindBy(xpath="//span[contains(text(),' to download')]")
	private WebElement downloadPDFButton;
	
	public void clickOnTheDownloadPDFButton(){
		
		downloadPDFButton.click();
	}
	
	
	
	
}
