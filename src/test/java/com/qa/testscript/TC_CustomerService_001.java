package com.qa.testscript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.CustomerServicePage;

public class TC_CustomerService_001 extends TestBase {
@Test
	public  void Service() throws InterruptedException, IOException {
	SoftAssert SAssert = new SoftAssert();
		CustomerServicePage serviceOR = new CustomerServicePage(driver);
		String defaultt = serviceOR.getUname().getText();
		String choiceOFService = "chat";


		String parent = driver.getWindowHandle();
		// Signin to application
		serviceOR.getBtn_SigninNav().click();
		serviceOR.getTxtbx_email().sendKeys(prop.getProperty("UserName")+Keys.ENTER);
		serviceOR.getTxtbx_pwd().sendKeys(prop.getProperty("password")+Keys.ENTER);
		Thread.sleep(3000);
		
		String Uname = serviceOR.getUname().getText();
	    String ar[] = Uname.split(","); 
	    System.out.println(ar[1]);
	   

	    if(Uname != defaultt)
	    {
	       SAssert.assertTrue(true);
	       Reporter.log("User logged in",true);
	    }
	    else
	    {
	    	captureSS(driver,"Service");
	    	SAssert.assertTrue(false);
	    	Reporter.log("User not logged in",true);
	    }
		// Test Case 1
		serviceOR.getLink_help().click();
		String Help_url=driver.getCurrentUrl();
		 
		 if(Help_url.contains("help"))
		 {
			 Reporter.log("Landed on Customer Service Page",true);
			 SAssert.assertTrue(true);
		 }
		 else
		 {
			 captureSS(driver,"Service");
			 Reporter.log("Not Landed on Customer Service Page",true);
			 SAssert.assertTrue(false);
		 }
		
		serviceOR.getBtn_CustomerService().click();
		String Service_url=driver.getCurrentUrl();
		 
		 if(Service_url.contains("customer"))
		 {
			 Reporter.log("Options for Customer Service are displayed",true);
			 SAssert.assertTrue(true);
		 }
		 else
		 {
			 captureSS(driver,"Service");
			 Reporter.log("Options for Customer Service are not displayed",true);
			 SAssert.assertTrue(false);
		 }
		
		serviceOR.getBtn_ContactUs().click();
		String Contact_url=driver.getCurrentUrl();
		 
		 if(Contact_url.contains("us"))
		 {
			 Reporter.log("Options for Contacting are displayed",true);
			 SAssert.assertTrue(true);
		 }
		 else
		 {
			 captureSS(driver,"Service");
			 Reporter.log("Options for Contacting are not displayed",true);
			 SAssert.assertTrue(false);
		 }

		Set<String> allWindows = driver.getWindowHandles();
		// Test Case 2
		for (String child : allWindows) {

			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				if (choiceOFService.equalsIgnoreCase("chat")) {
					serviceOR.getBtn_Chat().click();
					String ExpectedTittle="Chat with Amazon Customer Service - Google Chrome"; 
					  String actualTittle = driver.getTitle(); 
					  SAssert.assertEquals(actualTittle,ExpectedTittle); 
					  Reporter.log("Page Navigated to Chat Page.", true);
					  
					  Thread.sleep(5000);
				} else {
					serviceOR.getBtn_CallMe().click();
				}

			}

		}

	}

}

