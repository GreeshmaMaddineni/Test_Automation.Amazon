package com.qa.testscript;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.HomePages;

public class TC_Home_001 extends TestBase {
	@Test
  public void Home() throws InterruptedException, IOException    {
		SoftAssert SAssert = new SoftAssert();
    HomePages HomeOR = new HomePages(driver);
    String title = driver.getTitle();

    String defaultt = HomeOR.getUname().getText();

    HomeOR.getBtn_signin().click();
    
    WebElement username = HomeOR.getTxtbx_email();
    username.sendKeys(prop.getProperty("UserName")+Keys.ENTER);


    WebElement password = HomeOR.getTxtbx_pwd();
    password.sendKeys(prop.getProperty("password")+Keys.ENTER);
    
    Thread.sleep(5000);

    String name = HomeOR.getUname().getText();
    String ar[] = name.split(","); 
    System.out.println(ar[1]);
   

    if(name != defaultt)
    {
       SAssert.assertTrue(true);
       Reporter.log("User logged in",true);
    }
    else
    {
    	captureSS(driver,"Home");
    	SAssert.assertTrue(false);
    	Reporter.log("User not logged in",true);
    }
    
	/*
	 * String titleafl = driver.getTitle(); if(title.equalsIgnoreCase(titleafl));
	 * System.out.println("User at home page after login");
	 */
    Thread.sleep(3000);
    
      HomeOR.getHome_product().click();
      String ProductTitle=driver.getTitle();
      if(ProductTitle != title)
      {
    	  SAssert.assertTrue(true);
    	  Reporter.log("Product is displayed",true);
      }
      else 
      {
    	  captureSS(driver,"Home");
    	  SAssert.assertTrue(false);
    	  Reporter.log("Product is not displayed",true);
    	  }
 

    SAssert.assertAll();
  }
}