package com.qa.testscript;


import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.OrdersPages;

import java.io.IOException;

import org.openqa.selenium.Keys;
public class TC_ReturnsAndOrders_001 extends TestBase {

	@Test
	public void Order() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		Reporter.log("TC to test Amazon Orders functioanlity started", true);
		SoftAssert SAssert = new SoftAssert();
		OrdersPages OrdersOR=new OrdersPages(driver);
		String defaultt = OrdersOR.getUname().getText();
		OrdersOR.getsignin().click();
		
		OrdersOR.getmail().sendKeys(prop.getProperty("UserName")+Keys.ENTER);
		
		OrdersOR.getpsw().sendKeys(prop.getProperty("password")+Keys.ENTER);
		
		String Uname = OrdersOR.getUname().getText();
	    String ar[] = Uname.split(","); 
	    System.out.println(ar[1]);
	   

	    if(Uname != defaultt)
	    {
	       SAssert.assertTrue(true);
	       Reporter.log("User logged in",true);
	    }
	    else
	    {
            captureSS(driver,"Order");
	    	SAssert.assertTrue(false);
	    	Reporter.log("User not logged in",true);
	    }
	    
		
		  OrdersOR.getorders().click(); 
		  String Order_url=driver.getCurrentUrl();
		  
		  if(Order_url.contains("css")) {
			  Reporter.log("Landed on Orders Page",true);
				 SAssert.assertTrue(true);
			 }
			 else
			 {
				 captureSS(driver,"Order");
				 Reporter.log("Not Landed on Orders Page",true);
				 SAssert.assertTrue(false);
			 }
		 
		
		  OrdersOR.gettrack().click();
		 String Track_url=driver.getCurrentUrl();
		 
		 if(Track_url.contains("tracker"))
		 {
			 Reporter.log("Landed on Tracking Page",true);
			 SAssert.assertTrue(true);
		 }
		 else
		 {
			 captureSS(driver,"Order");
			 Reporter.log("Not Landed on Tracking Page",true);
			 SAssert.assertTrue(false);
		 }
		 
		

		
		 OrdersOR.getorders().click();
		 if(Order_url.contains("css")) {
			  Reporter.log("Landed on Orders Page",true);
				 SAssert.assertTrue(true);
			 }
			 else
			 {
				 captureSS(driver,"Order");
				 Reporter.log("Not Landed on Orders Page",true);
				 SAssert.assertTrue(false);
			 }
		
	  
		 OrdersOR.getcancel().click();
		String Cancel_url=driver.getCurrentUrl();
		 
		 if(Cancel_url.contains("order"))
		 {
			 Reporter.log("Landed on Cancel Order Page",true);
			 SAssert.assertTrue(true);
		 }
		 else
		 {
			 captureSS(driver,"Order");
			 Reporter.log("Not Landed on Cancel Order Page",true);
			 SAssert.assertTrue(false);
		 }
		
		 OrdersOR.getcancelbutton().click();
		String CancelRequest_url=driver.getCurrentUrl();
		 
		 if(CancelRequest_url.contains("order-details"))
		 {
			 Reporter.log("Order is Cancelled",true);
			 SAssert.assertTrue(true);
		 }
		 else
		 {
			 captureSS(driver,"Order");
			 Reporter.log("Order is not Cancelled",true);
			 SAssert.assertTrue(false);
		 }
		
		 Thread.sleep(3000);
		
		 OrdersOR.getorders().click(); 
		 if(Order_url.contains("css")) {
			  Reporter.log("Landed on Orders Page",true);
				 SAssert.assertTrue(true);
			 }
			 else
			 {
				 captureSS(driver,"Order");
				 Reporter.log("Not Landed on Orders Page",true);
				 SAssert.assertTrue(false);
			 }
		
	        Thread.sleep(3000);
	    
		
		  OrdersOR.getreview().click();
		  Thread.sleep(5000);
		  String Review_url=driver.getCurrentUrl();
		  if(Review_url.contains("review"))
		  {
			  Reporter.log("Landed on Review Page",true);
				 SAssert.assertTrue(true);
		  }
		  else
			 {
				 captureSS(driver,"Order");
				 Reporter.log("Not Landed on Review Page",true);
				 SAssert.assertTrue(false);
			 }
		  

		 
		 
		
		SAssert.assertAll();
	}

}
