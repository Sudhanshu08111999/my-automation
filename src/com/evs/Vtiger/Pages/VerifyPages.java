package com.evs.Vtiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import evs.vtiger.framework.utillity.WebUtillFrameWork;

public class VerifyPages {
	WebUtillFrameWork util;
	 WebDriver driver;
	public void launchBrowser(ExtentTest extlaunch) {		
		util=new WebUtillFrameWork();		
	    driver=util.launchbrowser("chrome");	
		extlaunch.log(Status.INFO, " browser should be launch");
		
	}
	public void getUrl(ExtentTest extUrl) {
		util.get("http://localhost:8888/");
		
		extUrl.log(Status.INFO, "verify url should be hit");
	}
	
	public void login(ExtentTest extenlogin) {
		util.inputData(driver, extenlogin,"//input[@name='user_name']", "admin", "entering admin in username field");
		util.inputData(driver, extenlogin,"//input[@name='user_password']", "admin", "entering admin in password field");
		util.selectByValue(driver, extenlogin, "//select[@name='login_theme']", "softed", "verify softed entring passed");		
		util.selectByVisibleText(driver, extenlogin, "//select[@name='login_language']", "US English", "verify us english entered passed");
		util.click(driver, extenlogin, "//input[@name='Login']", "clicking login button");
	}
     public void homePage(ExtentTest exthome) {
	  util.actionMouseOver(driver, exthome, "//a[text()='My Home Page']", "mouse over homepage successful");
      util.actiondragAndDrop(driver, exthome, "//tr[@id='headerrow_11']", "//tr[@id='headerrow_12']", "action of drag and drop successfully");
      util.actionRightclick(driver, exthome, "//a[text()='Marketing']", "action of rightclick successfully");
      util.getAttributeValue(driver, exthome, "//input[@value='Find']", "Find", "Fin", "bfd");
     }
      public void Inventory(ExtentTest extInv) {
    	  util.actionMouseOver(driver, extInv, "//a[text()='Inventory']", "Inventory page successfuly mouse over");   	 
    	  util.actionclick(driver, extInv, "//div[@id='Inventory_sub']//a[text()='Invoice']","invoice page successfuly click");
          
    	  util.click(driver, extInv, "//img[@title='Create Invoice...']", "invoice page click");
      }
     
	  
	  
}





