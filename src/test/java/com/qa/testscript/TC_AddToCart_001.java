package com.qa.testscript;
import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.CartPages;
public class TC_AddToCart_001 extends TestBase{
	@Test
	public void addtocart() throws InterruptedException, IOException {
		SoftAssert SAssert = new SoftAssert();
		CartPages CartOR= new CartPages(driver);
		String defaultt = CartOR.getUname().getText().toString();
		String parent=driver.getWindowHandle();
		CartOR.getacc().click();
		Thread.sleep(3000);

		CartOR.getnum().sendKeys(prop.getProperty("UserName")+Keys.ENTER);
		Thread.sleep(3000);
		CartOR.getpwd().sendKeys(prop.getProperty("password")+Keys.ENTER);
		Thread.sleep(3000);
		String name = CartOR.getUname().getText().toString();
	    String ar[] = name.split(","); 
	    System.out.println(ar[1]);
	   
	    if(name != defaultt)
	    {
	       SAssert.assertTrue(true);
	       Reporter.log("User logged in",true);
	    }
	    else
	    {
	    	captureSS(driver,"addtocart");
	    	SAssert.assertTrue(false);
	    	Reporter.log("User not logged in",true);
	    }
		CartOR.getsearchitem().sendKeys("oppo mobile phone");
		Thread.sleep(3000);
		CartOR.getspecifieditem().click();
		String search_url=driver.getCurrentUrl();
		if(search_url.contains("mobile"))
        {
            Reporter.log("Landed on searched product Page",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"addtocart");
            Reporter.log("Not Landed on searched product Page",true);
            SAssert.assertTrue(false);
        }

		Thread.sleep(3000);
		CartOR.getlink_item().click();
		String searchiteam_url=driver.getCurrentUrl();
		if(searchiteam_url.contains("mobile"))
        {
            Reporter.log("Landed on searched item Page",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"addtocart");
            Reporter.log("Not Landed on searched item Page",true);
            SAssert.assertTrue(false);
        }
		
		Thread.sleep(3000);
	
	
		Set<String> allWindow = driver.getWindowHandles();
		for (String string : allWindow) {
			if(!parent.equals(string)) {
				driver.switchTo().window(string);
				CartOR.getaddtocart().click();
				Thread.sleep(7000);
			}
		}
		
		driver.navigate().to("https://www.amazon.in/gp/cart/view.html/ref=dp_atch_dss_cart?");
		
		Thread.sleep(3000);
	CartOR.getinitial_qnt().click();
	String addtocart_url=driver.getCurrentUrl();
	if(addtocart_url.contains("cart?"))
    {
        Reporter.log("Landed on addtocartitem Page",true);
        SAssert.assertTrue(true);
    }
    else
    {
    	captureSS(driver,"addtocart");
        Reporter.log("Not Landed on addtocartitem Page",true);
        SAssert.assertTrue(false);
    }
	
	Thread.sleep(3000);

		CartOR.getchanged_qnt().click();
		String addtocart_url1=driver.getCurrentUrl();
		if(addtocart_url1.contains("cart"))
	    {
	        Reporter.log(" Quantityofitem Changed",true);
	        SAssert.assertTrue(true);
	    }
	    else
	    {
	    	captureSS(driver,"addtocart");
	        Reporter.log("Quantityofitem not Changed",true);
	        SAssert.assertTrue(false);
	    }
		Thread.sleep(3000);
		CartOR.getdlt_items().click();
		String addtocart_url2=driver.getCurrentUrl();
		if(addtocart_url2.contains("cart"))
	    {
	        Reporter.log("Addeditems Deleted",true);
	        SAssert.assertTrue(true);
	    }
	    else
	    {
	    	captureSS(driver,"addtocart");
	        Reporter.log("Addeditems not Deleted",true);
	        SAssert.assertTrue(false);
	    }
		
		
		Thread.sleep(3000);	
		SAssert.assertAll();
	
	}
}
