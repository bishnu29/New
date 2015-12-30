package com.shmlv3b_maven.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * 
 * @author Bishnu Das
 *
 */

public class ReportLib {
	
	/**
	 * 
	 * @param fileName
	 * @throws IOException
	 * @description
	 *                         The  takeScreenShot() method is used to get the Screenshot at runtime
	 *                         takeScreenShot() uses one parameter i.e String fileName
	 */   
	
	public static  String  captureScreenshot(String fileName) {
		
	  try{
		  
	               TakesScreenshot ts = (TakesScreenshot)Driver.driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					
					/*     Create a new File    */
					String  dest = "C:\\Users\\Saroj\\workspace\\BpostSHML_v3b\\screenshots\\"+fileName+".png";
					File destinationFile  = new File(dest);
					
					/*Copy ScreenShot to new File using Apache API */
					FileUtils.copyFile(source, destinationFile);
					System.out.println("Screenshot Taken");
					return dest;
					
		
		
		
		}catch(Exception e){
			
			System.out.println("Exception While taking Screenshot"+e.getMessage());
			return e.getMessage();
			
		}
	
	
	}
}
