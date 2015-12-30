package com.shmlv3b_maven.genericLib;

/**
 * 
 * @author Bishnu Das
 * @Description-
 * Constants is an Interface and basically it holds all the constants values
 * required in this particular project like Browser name,Url,postal code,
 * emailId,dummyText,Firstname,Second name,AdderessField,
 * Title name,Phone number,Rotation value,etc.
 * 
 */

public interface Constants {
	
	/**
	 * This is an Interface and basically it holds all the constants values
	 * like Browser name,Url,postal code,emailId,dummyText,Firstname,Second name,AdderessField,
	 * Title name,Phone number,Rotation value,etc.
	 * 
	 */
	
	      String browser = "firefox";
	      //String url = "http://shml.infanion.com/en";  /* Test Url */
	      String url = "https://parcel-2.stbpost.be";
	      String downloadPath = "D:\\SeleniumAutomateDownloadFiles\\";
	      
	      /**
	       *  Login Details
	       */
	        String loginEmail = "bishnu.infanion@gmail.com";
	        String password = "Test12345";
	      
	      /**
	       * destination page details
	       */
	      String emailID = "rajbishnu32@gmail.com";
	      String name="receiver_001";
	      String streetname="Street_one";
	      String nRvalue="001";
	      String phNumber = "444444444";
	      
	      /**
	       *  Sender page details
	       */
	      
	      String firstName=" test_sender";
	      String lastName ="ts";
	      String streetName2 = "street_two";
	      String nrvalue2 = "002";
	      String emailId2 = "test@vds.com";
	      
	      
	      
	      
	      /**
	       *   Excel file Details 
	       */
	      
	      String filePath = "D:\\TestData_selenium";
	      String fileName = "Test_data_for_SHML_v3b_selenium";
	      String sheetName = "positive_values";   // negative_values
	     
          
          
          /**
           *  The card details 
           */
        
          String cardName="Testing";
          String cardNumber="4111111111111111";
          String verificationCode="123";
       
          
          /**
           *  Report Details
           */
          
          String reportPath = "D:\\SeleniumProjectTestReport\\shlm_v3b_testreport\\report.html";
          
     }
