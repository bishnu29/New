package com.shmlv3b_maven.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;





import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.shmlv3b_maven.genericLib.Constants;
import com.shmlv3b_maven.genericLib.Driver;
import com.shmlv3b_maven.genericLib.ReportLib;
import com.shmlv3b_maven.genericLib.WebDriverCommonLib;
import com.shmlv3b_maven.pageobjectRepoLib.BpostDeliverypointObjects;
import com.shmlv3b_maven.pageobjectRepoLib.HomeOrOfficeDeliveryObjects;
import com.shmlv3b_maven.pageobjectRepoLib.LetReceiverChooseTheMethodObjects;
import com.shmlv3b_maven.pageobjectRepoLib.LoginObjects;
import com.shmlv3b_maven.pageobjectRepoLib.OgonePageObjects;
import com.shmlv3b_maven.pageobjectRepoLib.ParcelLockerDeliveryObjects;
import com.shmlv3b_maven.pageobjectRepoLib.VerifyingTheParcelObects;


/**
 * 
 * @author Bishnu
 *
 */


public class CheckingForAllFourDeliveryTest extends WebDriverCommonLib{

	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	LoginObjects loginObjects;
	HomeOrOfficeDeliveryObjects homeOrOfficeObjects;
	ParcelLockerDeliveryObjects parcelLockerDeliveryobjects;
	BpostDeliverypointObjects bpostDeliverypointObjects;
	LetReceiverChooseTheMethodObjects letReceiverChoseTheMethodObjects;
	OgonePageObjects ogonepageObjects;
	VerifyingTheParcelObects verifyParcelObjects;
	
	
	
	
	
	@BeforeClass
	public void configBfrCls() throws IOException{
		
		//report = ExtentReports.get(CheckingForAllFourDeliveryTest.class);
		report = new ExtentReports(Constants.reportPath,false);
		//report.addSystemInfo("Host Name ", "BISHNU");
		report.addSystemInfo("Enviornment","QA");
		report.addSystemInfo("Selenium Version","2.45.0");
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		driver = Driver.getDriver();
		logger.log(LogStatus.INFO, "BROWSER STARTED");
		loginObjects = PageFactory.initElements(driver, LoginObjects.class);
		homeOrOfficeObjects  = PageFactory.initElements(driver, HomeOrOfficeDeliveryObjects.class);
		parcelLockerDeliveryobjects = PageFactory.initElements(driver, ParcelLockerDeliveryObjects.class);
		bpostDeliverypointObjects = PageFactory.initElements(driver, BpostDeliverypointObjects.class);
		letReceiverChoseTheMethodObjects  = PageFactory.initElements(driver, LetReceiverChooseTheMethodObjects.class);
		ogonepageObjects = PageFactory.initElements(driver, OgonePageObjects.class);
		verifyParcelObjects = PageFactory.initElements(driver, VerifyingTheParcelObects.class);
		
	}
	
	@BeforeMethod
	public void configBfrMtd() throws InterruptedException{
		
		       
		// Navigate to the Home page of the application.
		        //logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		        
				loginObjects.navigateToTheHomePage();
				waitForPageToLoad();
				
				loginObjects.loginToTheApplication();
				waitForPageToLoad();
				Thread.sleep(4000);
				logger.log(LogStatus.INFO, "Application is UP and Running");

	}

	
	@Test(priority=1)
	public void checkingTheHomeOrOfficeDeliveryMethod() throws InterruptedException {
	
		
		
		
	/*	
		
		
			
		//report = new ExtentReports("D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\report1.html",true);
		//logger = report.startTest("checkingTheHomeOrOfficeDeliveryMethod is started");
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		//logger.assignCategory("1st flow - Home or Office Delivery Method ");
		
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> Navigating to The URL :: "+Driver.driver.getCurrentUrl()+"</span>");
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		homeOrOfficeObjects.clickOnSendTab();
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> The Send Button is Clicked. </span>");
		
		homeOrOfficeObjects.performOperationOn_createLabel_method();
		logger.log(LogStatus.INFO, "Started filling the fields in the Create Label page . . . ");
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "Clicked on Next button");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		homeOrOfficeObjects.performOperationOn_destinationPage();
		logger.log(LogStatus.INFO, "Started filling the fields in the Destination  page . . . ");
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "Clicked on Next button");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		//homeOrOfficeObjects.clickOn_newSenderAddressRadioButton();
		homeOrOfficeObjects.performOperationOn_senderPage();
		logger.log(LogStatus.INFO, "Started filling the fields in the Sender  page . . . ");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		String expectedMsg = "Your parcel has been successfully added to your shopping basket";
		String actualMsg = homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		System.out.println("The Message which is showing in the Overview page is :: "+homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded());
		Assert.assertEquals(expectedMsg, actualMsg,"The Parcel is not added to the cart and the success message is displaying");
		Reporter.log("The Parcel is Successfully added to the cart and the success message is  verified",true);
		logger.log(LogStatus.PASS, "The Parcel is Successfully added to the cart and the success message is  verified");
		
		
		homeOrOfficeObjects.clickOn_termsAndConditionCheckBox();
		logger.log(LogStatus.INFO, "Clicked Terms and conditions Check box");
		
		homeOrOfficeObjects.clickOn_payButton();
		logger.log(LogStatus.INFO, "Clicked on Pay Button");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		ogonepageObjects.clickOn_visaCard();
		
		
		logger.log(LogStatus.INFO, "Clicked On the Visa Card");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		ogonepageObjects.enterTheDetailsInTheCardDetailsPage();
		logger.log(LogStatus.INFO, "Entering the Payment Card Details");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		Driver.driver.navigate().refresh();
		logger.log(LogStatus.INFO, "The page is Refreshing");
		waitForPageToLoad();
		
		/*
		verifyParcelObjects.clickOnMyShipmenttab();
		logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		verifyParcelObjects.clickOnCompletedTab();
		logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		
		String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
		Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
		logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page");
		
		
		
		ogonepageObjects.clickOnTheDownloadPDFButton();
		logger.log(LogStatus.INFO, " The Download button is clicked ");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		//Thread.sleep(6000);
		//Assert.assertTrue(isFileDownloaded(Constants.downloadPath, "bpost-label.pdf"), "Failed to download Expected document");
		//waitForPageToLoad();
		Assert.assertTrue(isFileDownloaded_Ext(Constants.downloadPath, ".pdf"), "Failed to download document which has extension .pdf");
		logger.log(LogStatus.PASS, "Yes, The Downloaded File is of .pdf extension ");
		//waitForPageToLoad();
		
		Thread.sleep(6000);
		
		File getLatestFile = getLatestFilefromDir(Constants.downloadPath);
		logger.log(LogStatus.INFO, "Downloaded File Path is :: <span style='font-weight:bold;'> " +getLatestFile+" </span>");
	    String fileName = getLatestFile.getName();
	    logger.log(LogStatus.INFO, " Latest Downloaded File Name is ::  <span style='font-weight:bold;'> " +fileName+"</span>");
		Reporter.log("After downloading, the latest file name is :: "+fileName,true);
		Thread.sleep(4000);
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		//Assert.assertTrue(verifyPDFContent(downloadedFilePath, "323257001657391007"),"This BARCODE is not matching with the PDF ");
		
		
		
		
		
		
		verifyParcelObjects.clickOnMyShipmenttab();
		logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		verifyParcelObjects.clickOnCompletedTab();
		logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
		
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		
		 Get the BARCODE from the Myshipment tab and store in the barCode variable
		
		String barCode = verifyParcelObjects.getTheBarCodeFromMyshipmentPage();
		logger.log(LogStatus.INFO, "The BARCODE from the web is :: <span style='font-weight:bold;'>"+barCode+"<span>");
		Reporter.log("The BARCODE from the web is :: "+barCode,true);
		Thread.sleep(4000);
		Assert.assertTrue(verifyPDFContent(Constants.downloadPath,barCode,fileName)," This BARCODE is not matching with the PDF ");
		logger.log(LogStatus.PASS, "The Web Bar code is successfully matching with the Downloaded PDF");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Wait for the Page to Load");
		
		
		
		String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
		System.out.println("The Receiver's name in the My shipment page is :: "+receiverName);
		Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
		logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page <span class='label success'>Success</span>");
		
		
		
		*/
		
		
		
		
		
		
       

		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		//logger.assignCategory("1st flow - Home or Office Delivery Method ");
		
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> Navigating to The URL :: "+Driver.driver.getCurrentUrl()+"</span>");
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		homeOrOfficeObjects.clickOnSendTab();
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> The Send Button is Clicked. </span>");
		homeOrOfficeObjects.performOperationOn_createLabel_method();
		logger.log(LogStatus.INFO, "Started filling the fields in the Create Label page . . . ");
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "Clicked on Next button");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		homeOrOfficeObjects.performOperationOn_destinationPage();
		logger.log(LogStatus.INFO, "Started filling the fields in the Destination  page . . . ");
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "Clicked on Next button");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		homeOrOfficeObjects.clickOn_newSenderAddressRadioButton();
		homeOrOfficeObjects.performOperationOn_senderPage();
		logger.log(LogStatus.INFO, "Started filling the fields in the Sender  page . . . ");
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		/*
		homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		logger.log(LogStatus.INFO, "Successfully fetched the message after adding the parcel to the cart");
		String expectedMsg = "Your parcel has been added to your shopping basket";
		String actualMsg = homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		System.out.println("The Message which is showing in the Overview page is :: "+homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded());
		Assert.assertEquals(expectedMsg, actualMsg,"The Parcel is not added to the cart and the success message is displaying");
		Reporter.log("The Parcel is Successfully added to the cart and the success message is  verified");
		logger.log(LogStatus.PASS, "The Parcel is Successfully added to the cart and the success message is  verified");
		
		*/
		
		homeOrOfficeObjects.clickOn_termsAndConditionCheckBox();
		logger.log(LogStatus.INFO, "Clicked Terms and conditions Check box");
		
		homeOrOfficeObjects.clickOn_payButton();
		logger.log(LogStatus.INFO, "Clicked on Pay Button");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	
	ogonepageObjects.clickOn_visaCard();
	logger.log(LogStatus.INFO, "Clicked On the Visa Card");
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	
	ogonepageObjects.enterTheDetailsInTheCardDetailsPage();
	logger.log(LogStatus.INFO, "Entering the Payment Card Details");
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	
	Driver.driver.navigate().refresh();
	logger.log(LogStatus.INFO, "The page is Refreshing");
	waitForPageToLoad();
	
	/*
	verifyParcelObjects.clickOnMyShipmenttab();
	logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	
	verifyParcelObjects.clickOnCompletedTab();
	logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	
	
	
	String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
	Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
	logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page");
	*/
	
	
	ogonepageObjects.clickOnTheDownloadPDFButton();
	logger.log(LogStatus.INFO, " The Download button is clicked ");
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	//Thread.sleep(6000);
	//Assert.assertTrue(isFileDownloaded(Constants.downloadPath, "bpost-label.pdf"), "Failed to download Expected document");
	//waitForPageToLoad();
	Assert.assertTrue(isFileDownloaded_Ext(Constants.downloadPath, ".pdf"), "Failed to download document which has extension .pdf");
	logger.log(LogStatus.PASS, "Yes, The Downloaded File is of .pdf extension ");
	//waitForPageToLoad();
	
	Thread.sleep(6000);
	
	File getLatestFile = getLatestFilefromDir(Constants.downloadPath);
	logger.log(LogStatus.INFO, "Downloaded File Path is :: <span style='font-weight:bold;'> " +getLatestFile+" </span>");
    String fileName = getLatestFile.getName();
    logger.log(LogStatus.INFO, " Latest Downloaded File Name is ::  <span style='font-weight:bold;'> " +fileName+"</span>");
	Reporter.log("After downloading, the latest file name is :: "+fileName,true);
	Thread.sleep(4000);
	//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
	//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	//Assert.assertTrue(verifyPDFContent(downloadedFilePath, "323257001657391007"),"This BARCODE is not matching with the PDF ");
	
	
	
	
	
	
	verifyParcelObjects.clickOnMyShipmenttab();
	logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	
	verifyParcelObjects.clickOnCompletedTab();
	logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
	
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	
	
	
	/* Get the BARCODE from the Myshipment tab and store in the barCode variable*/
	
	String barCode = verifyParcelObjects.getTheBarCodeFromMyshipmentPage();
	logger.log(LogStatus.INFO, "The BARCODE from the web is :: <span style='font-weight:bold;'>"+barCode+"<span>");
	Reporter.log("The BARCODE from the web is :: "+barCode,true);
	Thread.sleep(4000);
	Assert.assertTrue(verifyPDFContent(Constants.downloadPath,barCode,fileName)," This BARCODE is not matching with the PDF ");
	logger.log(LogStatus.PASS, "The Web Bar code is successfully matching with the Downloaded PDF");
	
	waitForPageToLoad();
	logger.log(LogStatus.INFO, "Wait for the Page to Load");
	
	
	
	String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
	System.out.println("The Receiver's name in the My shipment page is :: "+receiverName);
	Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
	logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page <span class='label success'>Success</span>");
	
	
	
	
	//driver.findElement(By.linkText("PDF flyer")).click();
	
	
		
		
		
		
		
	}
	
	@Test(priority=2)
	public void checkingTheParcelLockerDeliveryMethod() throws InterruptedException{
		
		
		
	//report2 = new ExtentReports("D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\report2.html",true);
	//logger = report.startTest("checkingTheParcelLockerDeliveryMethod is started");
		
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		//logger.assignCategory("2nd flow - via Parcel locker delivery ");
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> Navigating to The URL :: "+Driver.driver.getCurrentUrl()+"</span>");
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		homeOrOfficeObjects.clickOnSendTab();
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> The Send Button is Clicked. </span>");
		
		logger.log(LogStatus.INFO, "Started Filling the fields of the Create label page");
		parcelLockerDeliveryobjects.performOperationOn_createlabelPage();
		logger.log(LogStatus.INFO, "The Filling of data is done");
		
		
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "Clicked on Next Button");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		//parcelLockerDeliveryobjects.performOperationOn_destinationPage();
		//homeOrOfficeObjects.nextButton();
		
		logger.log(LogStatus.INFO, "Started Filling the Fields of Destination Page  ");
		parcelLockerDeliveryobjects.fillTheDataOn_DestinationPage();
		logger.log(LogStatus.INFO, "Filling of the data is done");
		
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "The Next Button is Clicked");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		
		homeOrOfficeObjects.clickOn_newSenderAddressRadioButton();/* THIS METHOD WILL BE USED FOR lOGGEDIN USER */
		logger.log(LogStatus.INFO, "Clicked on New Sender Address Radio Button");
		
		logger.log(LogStatus.INFO, "Started filling the Fields on Sender Page");
		homeOrOfficeObjects.performOperationOn_senderPage();
		logger.log(LogStatus.INFO, "Sender page is Done");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
	
		
		/*
		homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		String expectedMsg = "Your parcel has been successfully added to your shopping basket";
		String actualMsg = homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		System.out.println("The Message which is showing in the Overview page is :: "+homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded());
		Assert.assertEquals(expectedMsg, actualMsg,"The Parcel is not added to the cart and the success message is displaying");
		Reporter.log("The Parcel is Successfully added to the cart and the success message is  verified",true);
		logger.log(LogStatus.PASS, "The Parcel is Successfully added to the cart and the success message is  verified");
		*/
		//Thread.sleep(4000);
		
		
		homeOrOfficeObjects.clickOn_termsAndConditionCheckBox();
		logger.log(LogStatus.INFO, "Clicked Terms and conditions Check box");
		
		homeOrOfficeObjects.clickOn_payButton();
		logger.log(LogStatus.INFO, "Clicked on Pay Button");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		ogonepageObjects.clickOn_visaCard();
		logger.log(LogStatus.INFO, "Clicked On the Visa Card");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		ogonepageObjects.enterTheDetailsInTheCardDetailsPage();
		logger.log(LogStatus.INFO, "Entering the Payment Card Details");
		
		
		
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		
		Driver.driver.navigate().refresh();
		logger.log(LogStatus.INFO, "The page is Refreshing");
		waitForPageToLoad();
		
		
		/*
		verifyParcelObjects.clickOnMyShipmenttab();
		logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		verifyParcelObjects.clickOnCompletedTab();
		logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		
		String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
		Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
		logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page");
		*/
		
		
		ogonepageObjects.clickOnTheDownloadPDFButton();
		logger.log(LogStatus.INFO, " The Download button is clicked ");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		
		Assert.assertTrue(isFileDownloaded_Ext(Constants.downloadPath, ".pdf"), "Failed to download document which has extension .pdf");
		logger.log(LogStatus.PASS, "Yes, The Downloaded File is of .pdf extension ");
		
		//Thread.sleep(6000);
		//Assert.assertTrue(isFileDownloaded(Constants.downloadPath, "bpost-label.pdf"), "Failed to download Expected document");
		//waitForPageToLoad();
		//Assert.assertTrue(isFileDownloaded_Ext(Constants.downloadPath, ".pdf"), "Failed to download document which has extension .pdf");
		//waitForPageToLoad();
		
		Thread.sleep(6000);
		
		File getLatestFile = getLatestFilefromDir(Constants.downloadPath);
		logger.log(LogStatus.INFO, "Downloaded File Path is :: <span style='font-weight:bold;'> " +getLatestFile+" </span>");
	    String fileName = getLatestFile.getName();
	    logger.log(LogStatus.INFO, " Latest Downloaded File Name is ::  <span style='font-weight:bold;'> " +fileName+"</span>");
		Reporter.log("After downloading, the latest file name is :: "+fileName,true);
		Thread.sleep(4000);
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		//Assert.assertTrue(verifyPDFContent(downloadedFilePath, "323257001657391007"),"This BARCODE is not matching with the PDF ");
		
		
		
		
		
		
		verifyParcelObjects.clickOnMyShipmenttab();
		logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		verifyParcelObjects.clickOnCompletedTab();
		logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
		
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		
		/* Get the BARCODE from the Myshipment tab and store in the barCode variable*/
		
		String barCode = verifyParcelObjects.getTheBarCodeFromMyshipmentPage();
		logger.log(LogStatus.INFO, "The BARCODE from the web is :: <span style='font-weight:bold;'>"+barCode+"<span>");
		Reporter.log("The BARCODE from the web is :: "+barCode,true);
		Thread.sleep(4000);
		Assert.assertTrue(verifyPDFContent(Constants.downloadPath,barCode,fileName)," This BARCODE is not matching with the PDF ");
		logger.log(LogStatus.PASS, "The Web Bar code is successfully matching with the Downloaded PDF");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		
		
		String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
		System.out.println("The Receiver's name in the My shipment page is :: "+receiverName);
		Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
		logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page  <span class='label success'>Success</span>");
		
		
		
		
	}
	
    @Test(priority=3)
	public void checkingTheBpostDeliveryPointMethod() throws InterruptedException{
		
	    
    	
	    logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
	    //logger.assignCategory("3rd flow - Via Bpost delivery point ");
	    logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> Navigating to The URL :: "+Driver.driver.getCurrentUrl()+"</span>");
	    
	    logger.log(LogStatus.INFO, "Waiting till  required  page loads");
	    homeOrOfficeObjects.clickOnSendTab();
	    logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> The Send Button is Clicked. </span>");
	    
	    logger.log(LogStatus.INFO, "Started Filling the fields of the Create label page");
		bpostDeliverypointObjects.performOperationOn_createLabelPage();
		logger.log(LogStatus.INFO, "The Filling of data is done");
		
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "The next button is clicked");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		logger.log(LogStatus.INFO, "Started filling the fields of Destination page.");
		bpostDeliverypointObjects.performOperationOn_DestinationPage();
		logger.log(LogStatus.INFO, "Destination Page is Done");
		
		
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "The Next Button is Clicked");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		

		homeOrOfficeObjects.clickOn_newSenderAddressRadioButton();/* THIS METHOD WILL BE USED FOR lOGGEDIN USER */
		logger.log(LogStatus.INFO, "Clicked on New Sender Address Radio Button");
		
		logger.log(LogStatus.INFO, "Started filling the Fields on Sender Page");
		homeOrOfficeObjects.performOperationOn_senderPage();
		logger.log(LogStatus.INFO, "Sender page is Done");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		/*
		homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		String expectedMsg = "Your parcel has been successfully added to your shopping basket";
		String actualMsg = homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded();
		System.out.println("The Message which is showing in the Overview page is :: "+homeOrOfficeObjects.fetchTheSuccessfullMessageOfParcelAdded());
		Assert.assertEquals(expectedMsg, actualMsg,"The Parcel is not added to the cart and the success message is displaying");
		Reporter.log("The Parcel is Successfully added to the cart and the success message is  verified",true);
		logger.log(LogStatus.PASS, "The Parcel is Successfully added to the cart and the success message is  verified");
		*/
		
		
		homeOrOfficeObjects.clickOn_termsAndConditionCheckBox();
		logger.log(LogStatus.INFO, "Clicked Terms and conditions Check box");
		
		homeOrOfficeObjects.clickOn_payButton();
		logger.log(LogStatus.INFO, "Clicked on Pay Button");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
	
		ogonepageObjects.clickOn_visaCard();
		
		logger.log(LogStatus.INFO, "Clicked On the Visa Card");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		ogonepageObjects.enterTheDetailsInTheCardDetailsPage();
		logger.log(LogStatus.INFO, "Entering the Payment Card Details");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		Driver.driver.navigate().refresh();
		logger.log(LogStatus.INFO, "The page is Refreshing");
		waitForPageToLoad();
		
		
		ogonepageObjects.clickOnTheDownloadPDFButton();
		logger.log(LogStatus.INFO, " The Download button is clicked ");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		Assert.assertTrue(isFileDownloaded_Ext(Constants.downloadPath, ".pdf"), "Failed to download document which has extension .pdf");
		logger.log(LogStatus.PASS, "Yes, The Downloaded File is of .pdf extension ");
		
		
		//Thread.sleep(6000);
		//Assert.assertTrue(isFileDownloaded(Constants.downloadPath, "bpost-label.pdf"), "Failed to download Expected document");
		//waitForPageToLoad();
		//Assert.assertTrue(isFileDownloaded_Ext(Constants.downloadPath, ".pdf"), "Failed to download document which has extension .pdf");
		//waitForPageToLoad();
		
		Thread.sleep(6000);
		
		File getLatestFile = getLatestFilefromDir(Constants.downloadPath);
		logger.log(LogStatus.INFO, "Downloaded File Path is :: <span style='font-weight:bold;'> " +getLatestFile+" </span>");
	    String fileName = getLatestFile.getName();
	    logger.log(LogStatus.INFO, " Latest Downloaded File Name is ::  <span style='font-weight:bold;'> " +fileName+"</span>");
		Reporter.log("After downloading, the latest file name is :: "+fileName,true);
		Thread.sleep(4000);
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		//Assert.assertTrue(verifyPDFContent(downloadedFilePath, "323257001657391007"),"This BARCODE is not matching with the PDF ");
		
		
		
		
		
		
		verifyParcelObjects.clickOnMyShipmenttab();
		logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		verifyParcelObjects.clickOnCompletedTab();
		logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
		
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		
		/* Get the BARCODE from the Myshipment tab and store in the barCode variable*/
		
		String barCode = verifyParcelObjects.getTheBarCodeFromMyshipmentPage();
		logger.log(LogStatus.INFO, "The BARCODE from the web is :: <span style='font-weight:bold;'>"+barCode+"<span>");
		Reporter.log("The BARCODE from the web is :: "+barCode,true);
		Thread.sleep(4000);
		Assert.assertTrue(verifyPDFContent(Constants.downloadPath,barCode,fileName)," This BARCODE is not matching with the PDF ");
		logger.log(LogStatus.PASS, "The Web Bar code is successfully matching with the Downloaded PDF");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		
		
		
		String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
		System.out.println("The Receiver's name in the My shipment page is :: "+receiverName);
		Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
		logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page <span class='label success'>Success</span>");
		
		
		
		
		//driver.findElement(By.linkText("PDF flyer")).click();
		
		
		
		
		
		
		
		
		/*
		verifyParcelObjects.clickOnMyShipmenttab();
		logger.log(LogStatus.INFO, "Clicked on My Shipment Tab");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		verifyParcelObjects.clickOnCompletedTab();
		logger.log(LogStatus.INFO, "Clicked on the Completed task under My Shipment page ");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting till  required  page loads");
		
		
		
		String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
		Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
		logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page");
		
		*/
		
	    
		
		
	}
	
	 @Test(priority=4)
	 public void checkingReceiverChooseMethod() throws InterruptedException{
		
	 
		
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		//logger.assignCategory("4th flow -Via  let the receiver choose his preferred method ");
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> Navigating to The URL :: "+Driver.driver.getCurrentUrl()+"</span>");
		
		
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		homeOrOfficeObjects.clickOnSendTab();
		logger.log(LogStatus.INFO, "<span style='font-weight:bold;'> The Send Button is Clicked. </span>");
		
		logger.log(LogStatus.INFO, "Stared Filling the data on Create label");
		letReceiverChoseTheMethodObjects.performOperation_OnCreateLabelPage();
		logger.log(LogStatus.INFO, "Fiiling of Data is Done");
		
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "The Next Button is Clicked");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		logger.log(LogStatus.INFO, "Started Filling the Fields in the Destination Page ");
		letReceiverChoseTheMethodObjects.performOperation_onDestinationPage();
		logger.log(LogStatus.INFO, "Destination Page is Done");
		
		homeOrOfficeObjects.nextButton();
		logger.log(LogStatus.INFO, "The Next Button is Clicked. ");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		homeOrOfficeObjects.clickOn_newSenderAddressRadioButton();  /* THIS METHOD WILL BE USED FOR lOGGEDIN USER */
		logger.log(LogStatus.INFO, "Clicked on new Sender Address Radio Button");
		
		logger.log(LogStatus.INFO, "Started Filling the Sender Page");
		letReceiverChoseTheMethodObjects.performOperationOn_senderPage();
		logger.log(LogStatus.INFO, "Sender Page is Done");
		
		waitForPageToLoad();
		logger.log(LogStatus.INFO, "Waiting for the Page to Load");
		
		logger.log(LogStatus.PASS, " Checking The Receiver Choose method is passed <span class='label success'>Success</span>");
		
		
	
		
		
	}
	
	
	@AfterMethod
	public void configAfterMtd(ITestResult result) throws InterruptedException{
			
		
		  
		
			if(result.getStatus() == ITestResult.FAILURE){
				
				String screenshot_path = ReportLib.captureScreenshot(result.getName());
				String image  = logger.addScreenCapture(screenshot_path);
				logger.log(LogStatus.FAIL, "The current Testscript is Failed"+image);
				
			}
			
			//Driver.driver.get("D:\\BpostShmlv3bReport\\report.html");
			
			try{	
			loginObjects.logOutTheApplication();
			waitForPageToLoad();
			}catch(Throwable e){
				loginObjects.logOutTheApplication();
				waitForPageToLoad();
			}
		   
			
    		
    		
			report.endTest(logger);
            report.flush();		
            
            Driver.driver.get("D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\");
            
		   

		}
		
	
	@AfterClass
	public void tearDownAfterCls(){
		
		//driver.quit();
	}
	
	
	
public boolean verifyPDFContent(String downloadPath, String barCode,String fileName) {
		
		boolean flag = false;
		
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;

		try {
			
		//	URL url = new URL(strURL);
		//	BufferedInputStream file = new BufferedInputStream(url.openStream());
		//	PDFParser parser = new PDFParser(file);
			
			File file = new File(downloadPath.concat(fileName));
			PDFParser parser = new PDFParser(new FileInputStream(file));
			
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(1);
			
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (MalformedURLException e2) {
			System.err.println("URL string could not be parsed "+e2.getMessage());
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			e.printStackTrace();
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
		
		System.out.println("======= THE CONTENT INSIDE THE DOWNLOADED PDF ARE AS BELOW ======");
		System.out.println(parsedText);
		System.out.println("======= THE END =======");

		if(parsedText.contains(barCode)) {
			flag=true;
		}
		
		return flag;
	}
	
	



		public boolean isFileDownloaded(String downloadPath, String fileName) {
				boolean flag = false;
			    File dir = new File(downloadPath);
			    File[] dir_contents = dir.listFiles();
			  	    
			    for (int i = 0; i < dir_contents.length; i++) {
			        if (dir_contents[i].getName().equals(fileName))
			        	{//System.out.println("The downloaded file name is :: "+dir_contents[i].getName().equals(fileName));
			            return flag=true;
			        	}
			            }
			
			    return flag;
			   
		}
		
		
		/* Check the file from a specific directory with extension */
		private boolean isFileDownloaded_Ext(String downloadPath, String ext){
			boolean flag=false;
		    File dir = new File(downloadPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        flag = false;
		    }
		    
		    for (int i = 1; i < files.length; i++) {
		    	if(files[i].getName().contains(ext)) {
		    		//System.out.println("The downloaded file is with extension is :: "+files[i].getName().contains(ext));
		    		flag=true;
		    	}
		    }
		    return flag;
		}
		
		
		
		/* Get the latest file from a specific directory*/
		private File getLatestFilefromDir(String downloadPath){
		    File dir = new File(downloadPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        return null;
		    }
		
		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) {
		       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		           lastModifiedFile = files[i];
		       }
		    }
		    return lastModifiedFile;
		}
		
		
		public static String getDownloadedDocumentName(String downloadDir, String fileExtension)
		{	
			String downloadedFileName = null;
			boolean valid = true;
			boolean found = false;
		
			//default timeout in seconds
			long timeOut = 20; 
			try 
			{					
				Path downloadFolderPath = Paths.get(downloadDir);
				WatchService watchService = FileSystems.getDefault().newWatchService();
				downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
				long startTime = System.currentTimeMillis();
				do 
				{
					WatchKey watchKey;
					watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
					long currentTime = (System.currentTimeMillis()-startTime)/1000;
					if(currentTime>timeOut)
					{
						System.out.println("Download operation timed out.. Expected file was not downloaded");
						return downloadedFileName;
					}
					
					for (WatchEvent event : watchKey.pollEvents())
					{
						 WatchEvent.Kind kind = event.kind();
						if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) 
						{
							String fileName = event.context().toString();
							System.out.println("New File Created:" + fileName);
							if(fileName.endsWith(fileExtension))
							{
								downloadedFileName = fileName;
								System.out.println("Downloaded file found with extension " + fileExtension + ". File name is " + 

	fileName);
								Thread.sleep(500);
								found = true;
								break;
							}
						}
					}
					if(found)
					{
						return downloadedFileName;
					}
					else
					{
						currentTime = (System.currentTimeMillis()-startTime)/1000;
						if(currentTime>timeOut)
						{
							System.out.println("Failed to download expected file");
							return downloadedFileName;
						}
						valid = watchKey.reset();
					}
				} while (valid);
			} 
			
			catch (InterruptedException e) 
			{
				System.out.println("Interrupted error - " + e.getMessage());
				e.printStackTrace();
			}
			catch (NullPointerException e) 
			{
				System.out.println("Download operation timed out.. Expected file was not downloaded");
			}
			catch (Exception e)
			{
				System.out.println("Error occured - " + e.getMessage());
				e.printStackTrace();
			}
			return downloadedFileName;
		}
	
	
	
	
	}