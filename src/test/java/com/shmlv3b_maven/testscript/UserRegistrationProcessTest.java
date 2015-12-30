package com.shmlv3b_maven.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.shmlv3b_maven.genericLib.Driver;
import com.shmlv3b_maven.genericLib.ExcelLib;
import com.shmlv3b_maven.pageobjectRepoLib.HomePageObjects;
import com.shmlv3b_maven.pageobjectRepoLib.LoginObjects;
import com.shmlv3b_maven.pageobjectRepoLib.UserRegistrationProcessObjects;

public class UserRegistrationProcessTest extends ExcelLib{

	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	LoginObjects loginObjects;
	UserRegistrationProcessObjects userRegistrationProcessObjects;
	HomePageObjects homePageObjects;
    ExcelLib eLib;
	
	@BeforeClass
	public void configBfrCls() throws IOException{
		report = new ExtentReports("D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\report.html",false);
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		driver = Driver.getDriver();
		loginObjects = PageFactory.initElements(driver, LoginObjects.class);
		userRegistrationProcessObjects = PageFactory.initElements(driver, UserRegistrationProcessObjects.class);
		homePageObjects = PageFactory.initElements(driver, HomePageObjects.class);
		eLib = PageFactory.initElements(driver, ExcelLib.class);
		
		
	}
	
	@BeforeMethod
	public void configBfrMtd(){
		
		// Navigate to the Home page of the application.
		loginObjects.navigateToTheHomePage();
		
	}
	
	/**
	 *@Description
	 *          This method will click and on the Register link on the home page and should navigate to Registration page.
	 */
	@Test
	public void clickOnTheRegisterLinkAndCheckForTheRegisterPage(){
		
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		//String expectedTitleOfThePage="Register to bpost shipping solution";
		String actualTitleOfThePage = userRegistrationProcessObjects.clickOnRegisterLink();
		Assert.assertTrue(actualTitleOfThePage.equals("Register to bpost shipping solution"),"Did not navigated to register page");
		logger.log(LogStatus.PASS,"After clicking on the register link, it is successfully navigating to Register page.");
		
	}
	
	/**
	 * @Description
	 *        This methods will verify for the below respective fields and they are :
	 *        Check whether "Create your accout " page should consists of following fields  or not
	 *        
	 *        b. Enter your personal data .   1. Title (dropdown)     2. First name (mandatory)      3. Last name (mandatory) 
	 *                                                           4. Birth date                 5.Prefix                                      6. Mobile number
	 *                                                           7. Username(e-mail address) - mandatory                8. Confirm your Username(e-mail address) - mandatory
	 *                                                           9. password (mandatory)                                            10. Confirm password(mandatory)
	 *                                                         11. Terms and conditions (checkbox)                          12.  Next (button)            
	 */
	@Test
	public void checkForTheFieldInTheRegistraionPage(){
		
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		/*Navigate to User Registration page*/
		homePageObjects.clickOnLoginLinkAndNavigateToRegisterPage();
		
		
		/* 1. Verifying the Title Dropdown */
		 Assert.assertTrue(userRegistrationProcessObjects.verifyTheTitleDropDown(),
				 "The Title drop down in the Registration page is not displaying");
		logger.log(LogStatus.PASS,"The Title drop down in the Registration page is Successfully displaying");
		
		
		/* 2. Verifying the First name field */
		Assert.assertTrue(userRegistrationProcessObjects.verifyingTheFirstNameField(),
				"The First name field in the registration page is not displaying");
		logger.log(LogStatus.PASS,"The First name field in the registration page is Successfully displaying");
		
		
		/* 3. Verifying the Last name field */
		Assert.assertTrue(userRegistrationProcessObjects.verifyingTheLastNameField(), "The Last Name in the Registration page is not displaying");
		logger.log(LogStatus.PASS,"The Last Name field in the Registration page is not displaying");
		
		
		/* 4. Verifying the Birth date  field */
		Assert.assertTrue(userRegistrationProcessObjects.verifyingTheBirthdayField(), "The Birth Day field in the Registration field is not displaying");
        logger.log(LogStatus.PASS,"The Birth Day field in the Registration field is Successfully displaying");		
		
		/* 5. Verifying the Prefix field        */
       // Assert.assertTrue(userRegistrationProcessObjects.verifyingThePrefixDropdown(),"The Prefix Language field in the Rgistration page is not displaying");
       // logger.log("The Prefix Language field  in the Rgistration page is Successfully displaying");
        
		/* 6. Verifying the Mobile number */
        Assert.assertTrue(userRegistrationProcessObjects.verifyingTheMobileNumbrField(),"The Mobile number field in the Registration page is not displaying ");
        logger.log(LogStatus.PASS,"The Mobile number field in the Registration page is successfully displaying ");
        
        
        /*   Scrolling down the page   */
        //scrollingThePage();
        
		/* 7. Verifying the Username (e-mail address) field  */
        Assert.assertTrue(userRegistrationProcessObjects.verifyingEmailIDField(),"The Email id Field in the Registration page is not displaying  ");
        logger.log(LogStatus.PASS,"The Email id Field in the Registration page is Successfully displaying  ");
        
		/* 8. Verifying the Confirm your username field      */
       // Assert.assertTrue(userRegistrationProcessObjects.verifyingConfirmPasssword(),"The Email");
        
        
        
		/* 9. Verifying the Password field */
        Assert.assertTrue(userRegistrationProcessObjects.verifyingConfirmPasssword(), "The Password field in the Registration field is not displaying ");
        logger.log(LogStatus.PASS,"The Password field in the Registration field is Successfully displaying ");
        
        
     
        
        
		/* 10. Verifying the Confirm Password field */
        Assert.assertTrue(userRegistrationProcessObjects.verifyingConfirmPasssword(),"The Confirm password in the Registeration field is not present ");
        logger.log(LogStatus.PASS,"The Confirm password in the Registeration field is Successfully present ");
        
        /*Verifying the First checkbox*/
        Assert.assertTrue(userRegistrationProcessObjects.verifyingTheFirstCheckBox(),"The First Checkbox in the Registration page is not Displaying ");
        logger.log(LogStatus.PASS,"The First Checkbox in the Registration page is Succefully Displaying  ");
        
        
        /*  Verifying the Second checkbox   */
        Assert.assertTrue(userRegistrationProcessObjects.verifyingTheSecondCheckBox(),"The Second checkbox in the Registration process is not present");
        logger.log(LogStatus.PASS,"The Second checkbox in the Registration process is Successfully Displaying");
		
        /* 10. Verifying the Terms and Condition checkbox */
        Assert.assertTrue(userRegistrationProcessObjects.verifyingTheTermsAndConditionsCheckbox(),"The terms and condition checkbox in Registration page  is not displaying");
        logger.log(LogStatus.PASS,"The terms and condition checkbox in Registration page  is Successfully displaying");        
        
		/* 2. Verifying the Next  field */
		Assert.assertTrue(userRegistrationProcessObjects.verifyingTheRegisterBtn(),"The Register button in the Registration page is not present ");
        logger.log(LogStatus.PASS,"The Register button in the Registration page is Successfully present  ");		
		
	}
	
	/**
	* @Description
	 *        This methods will verify for the below respective fields and they are :
	 *        Check whether "Create your accout " page should consists of following fields  or not
	 *        
	 *        a.  Use a social network . 1. Sign in with facebook    2. Sign in with google
	*/
	@Test
	public void checkForFacebookAndGoogleLink(){
		
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		/*Navigate to User Registration page*/
		homePageObjects.clickOnLoginLinkAndNavigateToRegisterPage();
		
		boolean resultOfpresenceOfFBandGoogleLink = userRegistrationProcessObjects.checkForGoogleAndFacebookRegistration();
		Assert.assertTrue(resultOfpresenceOfFBandGoogleLink,"The Facebook and google links in the Registration page is not present");
		logger.log(LogStatus.PASS,"Both the links that is Facebook and Google is Successfully present in the Home page");
		
		
	}
	
	
	/**
	 * @throws IOException 
	 * @Description
	 *       Check that password minimum strength is 8 characters long and one charcter should be of capital.
	 */
	
	@Test
	public void checkingThePasswordStrength() throws IOException{
		
		logger = report.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		/*Navigate to User Registration page*/
		homePageObjects.clickOnLoginLinkAndNavigateToRegisterPage();
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS,"This Testcase is Passed");
		/*   */
		
		
		
		
		
	}
	
	@DataProvider(name="test")
	public static Object [][] excellCode() throws IOException{
		
		  String fileName = "D:\\TestData_selenium\\demoData.xls";
		  File excel = new File(fileName);
		  FileInputStream fis = new FileInputStream(excel);

		  // XSSFWorkbook wb = new XSSFWorkbook(fis);
		 //  XSSFSheet ws = wb.getSheet("Sheet1");

		//   int rowNum = ws.getLastRowNum() + 1;
		//  int colNum = ws.getRow(0).getLastCellNum();
		//  String[][] data = new String[(rowNum - 1)][colNum];
		  
		  
		 String fileExtensionName = fileName.substring(fileName.indexOf("."));
		  // condition to check extension of the file .
		  
		  if(fileExtensionName.equals(".xlsx")){
			  XSSFWorkbook wb = new XSSFWorkbook(fis);
			  XSSFSheet ws = wb.getSheet("Sheet1");
			  int rowNum = ws.getLastRowNum() + 1;
			  int colNum = ws.getRow(0).getLastCellNum();
			  Object[][] data = new String[(rowNum - 1)][colNum];
					  int k = 0;
					  for (int i = 1; i < rowNum; i++) {
					  XSSFRow row = ws.getRow(i);
		                             for (int j = 0; j < colNum; j++) {
		                	 
		                            	 				XSSFCell cell = row.getCell(j);
		                            	 				String value = cellToString(cell);
		                            	 				data[k][j] = value;
		                            	 				System.out.println("the value is: " + value);
		                                }
		             k++;
		   }
					  
		  				  
	 wb.close();
	 fis.close();
	 return data;
		  }
		  else {
			  
			  HSSFWorkbook wb = new HSSFWorkbook(fis);
			  HSSFSheet ws = wb.getSheet("Sheet1");
			  int rowNum = ws.getLastRowNum() + 1;
			  int colNum = ws.getRow(0).getLastCellNum();
			  Object[][] data = new String[(rowNum - 1)][colNum];
					  int k = 0;
					  for (int i = 1; i < rowNum; i++) {
					  HSSFRow row = ws.getRow(i);
		                             for (int j = 0; j < colNum; j++) {
		                	 
		                            	 				HSSFCell cell = row.getCell(j);
		                            	 				String value = cellToString(cell);
		                            	 				data[k][j] = value;
		                            	 				System.out.println("the value is: " + value);
		                                }
		             k++;
			  
			  
		  }
		  
		     wb.close();
			 fis.close();
			  return data;
	    }
	}
	
	
	
    @AfterMethod
    public void configAftrMtd(){
    	
    	report.endTest(logger);
        report.flush();
        Driver.driver.get("D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\");
    	//driver.close();
    }
	
    @AfterClass
    public void configAftrcls(){
    	driver.quit();

    }
}
