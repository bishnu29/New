package com.shmlv3b_maven.genericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * 
 * @author Bishnu Das
 * @Description
 *     Driver class is used to start a web browser and run the application Under
 *     Test on that particular browser.
 */

public class Driver {
	
	
	
	
	   public static WebDriver driver;
	
	   /**
	    * @Description
	    *      getDriver() is a method which is used to get the browser at the runtime.
	    * @ForExample
	    *      If you want to run the application under test in firefox browser,then just change
	    *       the String value in Constant class as ::     
	    *      
	    *                                            String browser="firefox";
	    * @return driver
	    * @throws IOException
	    */
	   
	   public static WebDriver getDriver() throws IOException {
		   
		   
		     if(Constants.browser.equals("firefox")){
		    	 
		    	String firebugPath = "D:\\Desktop\\firebug-2.0.11-fx.xpi";
		    	String firePath = "D:\\Desktop\\firepath-0.9.7.1-fx.xpi";
		    	FirefoxProfile profile = new FirefoxProfile();       
		 		profile.addExtension(new File(firebugPath));
		 		profile.addExtension(new File(firePath));
		 		profile.setPreference("extensions.firebug.currentVersion", "2.0.11");
		    	
		 		//profile.setPreference("browser.download.folderList",2);
		 		//profile.setPreference("browser.download.manager.showWhenStarting",false);
		 		//profile.setPreference("browser.download.dir",Constants.downloadPath);
		 		//profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		//"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/pdf");
		 		//profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
		 		//profile.setPreference("browser.download.dir",Constants.downloadPath);
		 		
		 		
		 		//profile.setPreference("browser.download.folderList",2);
				//profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
				//profile.setPreference("browser.download.dir","D:\\SeleniumAutomateDownloadFiles\\");
		 		
		    	
		    	profile.setPreference("browser.download.dir", "D:\\SeleniumAutomateDownloadFiles\\");
		    	  profile.setPreference("browser.download.folderList", 2);
		    	  //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
		    	  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
		    	    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//MIME types Of MS Excel File.
		    	    + "application/pdf;" //MIME types Of PDF File.
		    	    + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //MIME types Of MS doc File.
		    	    + "text/plain;" //MIME types Of text File.
		    	    + "text/csv"); //MIME types Of CSV File.
		    	  profile.setPreference( "browser.download.manager.showWhenStarting", false );
		    	  profile.setPreference( "pdfjs.disabled", true );
		    	  //Pass fprofile parameter In webdriver to use preferences to download file.
		    	
		    	
		    	
		 		//System.out.println("Firefox profile name :: "+profile);
		    	 driver = new FirefoxDriver(profile);
		    	 
		    	 
		     }
		     else if(Constants.browser.equals("ie")){
		    	 
		    	 System.setProperty("webdriver.ie.driver", "D:\\Desktop\\ie\\IEDriverServer.exe");
		    	 driver = new InternetExplorerDriver();
		    	 
		     }
		     else if(Constants.browser.equals("chrome")){
		    	 
		    	 System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chrome\\chromedriver.exe");
		    	 driver = new ChromeDriver();
		    	 
		     }
		     else if(Constants.browser.equals("safari")){
		    	 
		    	 System.setProperty("SafariDefaultPath","C:\\Program Files (x86)\\Safari\\Safari.exe");
		    	 driver = new SafariDriver();
		    	 
		     }
		     else {
		    	 
		    	  driver = new FirefoxDriver();
		    	  
		     }
		     
		     
		return driver;
		
		
	}
	

}
