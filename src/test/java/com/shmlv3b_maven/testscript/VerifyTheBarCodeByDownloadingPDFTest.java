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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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

public class VerifyTheBarCodeByDownloadingPDFTest extends WebDriverCommonLib{
	
	WebDriver driver;
	
	ExtentReports report;
	//ExtentReports report2;
	//ExtentReports report3;
    //ExtentReports report4;
	ExtentTest logger;
	LoginObjects loginObjects;
	HomeOrOfficeDeliveryObjects homeOrOfficeObjects;
	BpostDeliverypointObjects bpostDeliverypointObjects;
	OgonePageObjects ogonepageObjects;
	VerifyingTheParcelObects verifyParcelObjects;
	
	//String downloadedFilePath = "D:\\SeleniumAutomateDownloadFiles";
	
	@BeforeClass
	public void setUp() throws Exception {
		//driver = new FirefoxDriver(firefoxProfile());
		//driver.get(Constants.url);
		//waitForPageToLoad();
		report = new ExtentReports("D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\report.html",true);
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		driver = Driver.getDriver();
		logger.log(LogStatus.INFO, "BROWSER STARTED");
		loginObjects = PageFactory.initElements(driver, LoginObjects.class);
		homeOrOfficeObjects  = PageFactory.initElements(driver, HomeOrOfficeDeliveryObjects.class);
		bpostDeliverypointObjects = PageFactory.initElements(driver, BpostDeliverypointObjects.class);
		ogonepageObjects = PageFactory.initElements(driver, OgonePageObjects.class);
		verifyParcelObjects = PageFactory.initElements(driver, VerifyingTheParcelObects.class);
		
		
	}
	
	@BeforeMethod
	public void configBeforeMethd() throws InterruptedException{
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		loginObjects.navigateToTheHomePage();
		waitForPageToLoad();
		
		loginObjects.loginToTheApplication();
		waitForPageToLoad();
		Thread.sleep(4000);
		logger.log(LogStatus.INFO, "Application is UP and Running");
	}
	
	/**
	 * To verify PDF content in the pdf document
	 * @throws InterruptedException 
	 */
	@Test
	public void testVerifyPDFTextInBrowser() throws InterruptedException {
		
		
		
		
		
		
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		homeOrOfficeObjects.clickOnSendTab();
		logger.log(LogStatus.INFO, "Clicked on Send Button");
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
		
		
		
		
		ogonepageObjects.clickOnTheDownloadPDFButton();
		logger.log(LogStatus.INFO, " The Download button is clicked ");
		waitForPageToLoad();
		//Thread.sleep(6000);
		//Assert.assertTrue(isFileDownloaded(Constants.downloadPath, "bpost-label.pdf"), "Failed to download Expected document");
		//waitForPageToLoad();
		//Assert.assertTrue(isFileDownloaded_Ext(Constants.downloadPath, ".pdf"), "Failed to download document which has extension .pdf");
		//waitForPageToLoad();
		
		Thread.sleep(6000);
		
		File getLatestFile = getLatestFilefromDir(Constants.downloadPath);
	    String fileName = getLatestFile.getName();
		System.out.println("After downloading, the latest file name is :: "+fileName);
		Thread.sleep(4000);
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		//Assert.assertTrue(fileName.equals("bpost-label.pdf"), "Downloaded file name is not matching with expected file name");
		waitForPageToLoad();
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
		System.out.println("The BARCODE from the web is :: "+barCode);
		Thread.sleep(4000);
		Assert.assertTrue(verifyPDFContent(Constants.downloadPath,barCode,fileName)," This BARCODE is not matching with the PDF ");
		
		waitForPageToLoad();
		
		
		
		
		String receiverName = verifyParcelObjects.verifyingTheOrderedParcelByReceiverName();
		System.out.println("The Receiver's name in the My shipment page is :: "+receiverName);
		Assert.assertEquals(receiverName, Constants.name,"The Receiver name is not matching when we cross check under completed tab of My shipment page");
		logger.log(LogStatus.PASS, "The Receiver name is successfully matching when we cross check under completed tab of My shipment page");
		
		
		
		
		//driver.findElement(By.linkText("PDF flyer")).click();
		
	}
	

	/**
	 * To verify pdf in the URL 
	 */
	//@Test
	public void testVerifyPDFInURL() {
		driver.get("http://www.princexml.com/samples/");
		driver.findElement(By.linkText("PDF flyer")).click();
		String getURL = driver.getCurrentUrl();
		Assert.assertTrue(getURL.contains(".pdf"));
	}

	@AfterMethod
	public void configAftrMtd(ITestResult result) throws InterruptedException{

		if(result.getStatus() == ITestResult.FAILURE){
			
			String screenshot_path = ReportLib.captureScreenshot(result.getName());
			String image  = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "The current Testscript is Failed"+image);
			
		}
		
		//Driver.driver.get("D:\\BpostShmlv3bReport\\report.html");
		loginObjects.logOutTheApplication();
		waitForPageToLoad();
		
		report.endTest(logger);
        report.flush();		
        
        Driver.driver.get("D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\");
        
        
	}
	
	@AfterClass
	public void tearDown() {
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
	
	
	/*
	
		public static FirefoxProfile firefoxProfile() throws Exception {
				
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.download.folderList",2);
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
				firefoxProfile.setPreference("browser.download.dir",Constants.downloadPath);
				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
				
				return firefoxProfile;
			}
       */

		public boolean isFileDownloaded(String downloadPath, String fileName) {
				boolean flag = false;
			    File dir = new File(downloadPath);
			    File[] dir_contents = dir.listFiles();
			  	    
			    for (int i = 0; i < dir_contents.length; i++) {
			        if (dir_contents[i].getName().equals(fileName))
			        	{System.out.println("The downloaded file name is :: "+dir_contents[i].getName().equals(fileName));
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
		    		System.out.println("The downloaded file is with extension is :: "+files[i].getName().contains(ext));
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

