package com.shmlv3b_maven.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Bishnu Das
 * @description
 *                     WebdriverCommonLib  java class file contains webdriver specific
 *                     custom and reusable method ,which can be used for multiple application like Ajax
 *                     and any (clickAndWait() , waitForPageToLoad() waitForElementPresent ….etc
 */

public class WebDriverCommonLib {
	
	/**
	 * @author bishnu
	 * @description
	 *                        The waitForPageToLoad() method is for implicit wait and it
	 *                        should be used whenever there is a page navigation.This
	 *                         method will wait till 30 seconds but if the required page gets downloaded
	 *                         before 30 seconds then driver controll will be release to the next line and it
	 *                         will not wait for 30 seconds to complete.
	 */
	
	  public void waitForPageToLoad(){
		  
		  Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
	  }

	  /**
	   * 
	   * @param wbXpath
	   * @description
	   *                      The waitForElementPresent(String wbXpath) method is for Explicit wait and it
	   *                      is used whenever we need to wait for particular Element in application .This method 
	   *                     will have one String argument where we have to give the xpath of that particular element
	   *                     for which we want to wait and also this method will wait till 30 seconds.
	   */
	  
	  public void waitForElementPresent(String wbXpath){
		  
		  WebDriverWait wait = new WebDriverWait(Driver.driver, 30);
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(wbXpath)));
		  
	  }
	  
	  
	  /**
	   * @description
	   *                     The waitForElementPresentById(String idValue) method is for Explicit wait and it
	   *                      is used whenever we need to wait for particular Element by id locator in application .This method 
	   *                     will have one String argument where we have to give the id of that particular element
	   *                     for which we want to wait and this method will wait till 30 seconds. 
	   *                     
	   * @param idValue
	   */
	  
  public void waitForElementPresentById(String idValue){
		  
		  WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(idValue)));
		  
	  }
	  
  
  /**
   * @description
   *                         The waitForLinkPresent(String linkName) method is for Explicit wait and it
	   *                      is used whenever we need to wait for particular link by linkName locator in application .This method 
	   *                      will have one String argument where we have to give the linkName of that particular Link
	   *                      for which we want to wait and this method will wait till 30 seconds.     
   *                     
   * @param linkName
   */
  
	  public void waitForLinkPresent(String linkName){
		  
		  WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkName)));
		  
	  }
	  
	  
	  /**
	   * @description 
	   *                 The select(WebElement selWb,String value) method is used to select
	   *                 the element for from the drop down menu bar using Visible text and this method should
	   *                 be called using two arguments i.e first argument will be WebElement 
	   *                 and second one should be of String type.
	   *                 
	   * @param selWb of WebElement type
	   * @param value of String type
	   */
	  
	  public void select(WebElement selWb,String value){
		  
		  Select sel = new Select(selWb);
		  sel.selectByVisibleText(value);
		  
	  }
	  
	  
	  /**
	   * @description
	   *                 The selectIndex(WebElement selWb,String index) method is used to select
	   *                 the element for from the drop down menu bar using Visible text and this method should
	   *                 be called using two arguments i.e first argument will be WebElement 
	   *                 and second one should be of String type.
	   * 
	   * @param selWb of WebElement type
	   * @param index of String type
	   */
	  
      public void selectIndex(WebElement selWb,String index){
		  
		  Select sel = new Select(selWb);
		  sel.selectByVisibleText(index);
		  
	  } 
      
      
      /**
       * @description
       *                     The alertAlert() method clicks on the “Ok”  or accept button
       *                      as soon as the pop up window appears.
       */
      
      public void alertAlert(){
    	  
    	  Alert alt = Driver.driver.switchTo().alert();
    	  alt.accept();
    	  
      }
      
      
      /**
       * @description
       *                  The cancelAlert() method clicks on the “Cancel” button 
       *                  as soon as the pop up window appears.
       */
      
      public void cancelAlert(){
    	  
    	  Alert alt = Driver.driver.switchTo().alert();
    	  alt.dismiss();
    	  
      }
      
      
      public void performMouseHoverOperation(WebElement webelement){
    	  
    	  
    	  Actions action = new Actions(Driver.driver);
    	  action.moveToElement(webelement).build().perform();
    	  
      }
      
      
      /**
       * @description
       *                  The scrollingThePage()  is a javaScript method  used to scroll down
       *                   the scroll bar to view the elements
       */
      
      public void scrollingThePage(){
    	  
    	  JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
			js.executeScript("window.scrollBy(0,800)", "");
      }
      
      
      
      /**
       * @Description
       *                     The writeTextInsideTheFrameInPostKartPage(String frameByName)
       *                      method  is  used to take the driver control inside the frame by frame name locator.
       *                      
       * @param frameByName of type String
       */
      
      public void writeTextInsideTheFrameInPostKartPage(String frameByName){
    	  
    	  Driver.driver.switchTo().frame(frameByName);
      }
      
      
      /**
       * @Description
       *                      The writeTextInsideFrameById(String frameByid)
       *                      method  is  used to take the driver control inside the frame by frame id .
       *                      
       * @param frameByid of String type
       */
      
      public void writeTextInsideFrameById(String frameByid){
    	  Driver.driver.switchTo().frame(frameByid);
      }
      
      
      
      /**
       * @Description
       *                 The  frameToDefaultContent() method is used to take
       *                  the driver control out of frame to a default content.
       */
      
      public void frameToDefaultContent(){
    	  
    	  Driver.driver.switchTo().defaultContent();
      }
      
      
      /**
       * @Description
       *                    The  removeNonDigits(final String str) method is used 
       *                    to remove all the non-digits and return only digits
       *                       
       * @param str of type String 
       * @return onlyDigits
       */
      
      public static String removeNonDigits(final String str) {
    	   if (str == null || str.length() == 0) {
    	       return "";
    	   }
    	   return str.replaceAll("\\D+", "");
    	}
      
      
      /**
       * @Decsription
       *                     The deleteAllCookies() method is used to delete all
       *                      cookies of the browser before launching the Browser.
       */
      
      public void deleteAllCookies(){
    	  
    	  /*Delete all cookies from the browser*/
    	  Driver.driver.manage().deleteAllCookies();
    	  /*Wait for few seconds*/
    	  waitForPageToLoad();
      }
      
      
      /**
       * @Description
       *                  The  scrollingToBottomofAPage() is a javaScript method used
       *                   to scroll down to the bottom of the web page.
       */
      
      public void scrollingToBottomofAPage() {
  		
  		 ((JavascriptExecutor) Driver.driver)
           .executeScript("window.scrollTo(0, document.body.scrollHeight)");
  	}
      
      
      public void waitForAjax() throws InterruptedException
      {

          while (true)
          {

              Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)Driver.driver).executeScript("return jQuery.active == 0");
              if (ajaxIsComplete){
                  break;
              }
              Thread.sleep(100);
          }
      } 

}
