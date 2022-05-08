package com.evs.testCases.Vtiger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.evs.Vtiger.Pages.VerifyPages;

public class RunnerTestCases001 {

	public static void main(String[] args) {
		ExtentHtmlReporter extenthtml=new ExtentHtmlReporter("C:\\Users\\HP\\Desktop\\New folder/result.html");
		ExtentReports extentreport=new ExtentReports();
		extentreport.attachReporter(extenthtml);
		
		VerifyPages verf=new VerifyPages();
		
		ExtentTest extlaunch=extentreport.createTest("varify launch browser");
		verf.launchBrowser(extlaunch);
		extentreport.flush();
		
		ExtentTest exturl=extentreport.createTest("varify url");
		verf.getUrl(exturl);
		extentreport.flush();
		
		ExtentTest extlogin=extentreport.createTest("varify login button click");
	    verf.login(extlogin);
	    extentreport.flush();
	    
	    ExtentTest exthome=extentreport.createTest("varify homePage creation");
	    verf.homePage(exthome);
	    extentreport.flush();
	    
//	    ExtentTest extInv=extentreport.createTest("varify inventory creation");
//	    verf.Inventory(extInv);
//	    extentreport.flush();
	}
    
}
