package com.qa.testscript;

import com.qa.pages.Searchfunction;
import com.qa.utility.ExcelUtility;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class TC_SearchFunctionality_001 extends TestBase {
	@Test(dataProvider ="getData")
	public  void Search(String ProductName) throws InterruptedException, IOException	{

		Searchfunction searchfOR = new Searchfunction(driver);
		SoftAssert SAssert = new SoftAssert();

		/*
		 * WebElement element3 = searchfOR.getSearchbox();
		 * element3.sendKeys("Macbook - 2021");
		 */
		searchfOR.getSearchbox().sendKeys(ProductName);
		Thread.sleep(3000);
		searchfOR.getBtn_magnifier().click();
		String search_url=driver.getCurrentUrl();
		if(search_url.contains("s?k=Macbook+-+2021&ref=nb_sb_noss"))
        {
            Reporter.log("Landed on searched products Page",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Not Landed on searched products Page",true);
            SAssert.assertTrue(false);
        }
		
	Reporter.log(searchfOR.getSearchinfo().getText(),true); // number of products searched and results for the searched term
		Select sorting = new Select(searchfOR.getDropdown());
		
		sorting.selectByVisibleText("Featured");
		Thread.sleep(2000);
		String Featured_url=driver.getCurrentUrl();
		if(Featured_url.contains("Macbook"))
        {
            Reporter.log("Sorting is done for Featured Category",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Sorting is not done for Featured Ctegory",true);
            SAssert.assertTrue(false);
        }
		sorting.selectByVisibleText("Price: Low to High");
		Thread.sleep(2000);
		String LowToHigh_url=driver.getCurrentUrl();
		if(LowToHigh_url.contains("price-asc-rank"))
        {
            Reporter.log("Sorting is done for Price: Low to High Category",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Sorting is not done for Price: Low to High Category",true);
            SAssert.assertTrue(false);
        }
		sorting.selectByVisibleText("Price: High to Low");
		Thread.sleep(2000);
		String HighToLow_url=driver.getCurrentUrl();
		if(HighToLow_url.contains("price-desc-rank"))
        {
            Reporter.log("Sorting is done for Price: High to Low Category",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Sorting is not done for Price: High to Low Category",true);
            SAssert.assertTrue(false);
        }
		sorting.selectByVisibleText("Avg. Customer Review");
		Thread.sleep(2000);
		String Customer_url=driver.getCurrentUrl();
		if(Customer_url.contains("review-rank"))
        {
            Reporter.log("Sorting is done for Avg. Customer Review Category",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Sorting is not done for Avg. Customer Review Category",true);
            SAssert.assertTrue(false);
        }
		sorting.selectByVisibleText("Newest Arrivals");
		String New_url=driver.getCurrentUrl();
		if(New_url.contains("date-desc-rank"))
        {
            Reporter.log("Sorting is done for Newest Arrivals Category",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Sorting is not done for Newest Arrivals Category",true);
            SAssert.assertTrue(false);
        }
		
		Select changeCategory = new Select(searchfOR.getcategory());
		changeCategory.selectByVisibleText("Books");
		String Books_url=driver.getCurrentUrl();
		if(Books_url.contains("Macbook"))
        {
            Reporter.log("Sorting is done for Books Category",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Sorting is not done for Books Category",true);
            SAssert.assertTrue(false);
        }
		
		WebElement element4 = searchfOR.getSearchbox();
		element4.clear();
		element4.sendKeys(ProductName);
		element4.submit();
        String Search1_url=driver.getCurrentUrl();
        if(Search1_url.contains("Macbook"))
        {

            Reporter.log("Landed on searched products page",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Not landed on Searched products page",true);
            SAssert.assertTrue(false);
        }
        
		searchfOR.getNextpage().click();
		String Next_url=driver.getCurrentUrl();
        if(Next_url.contains("Macbook"))
        {

            Reporter.log("Moved to Next page",true);
            SAssert.assertTrue(true);
        }
        else
        {
        	captureSS(driver,"Search");
            Reporter.log("Not moved to Next page",true);
            SAssert.assertTrue(false);
        }
		Thread.sleep(6000);
		
	}
	@DataProvider
    public String[][] getData() throws IOException {
        String xFile="E:\\eclipse workspace\\TestAutomation.Amazon\\src\\test\\java\\com\\qa\\testdata\\testData.xlsx";
        String xSheet="Sheet1";
        int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
        int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
        String[][] data = new String[rowCount][cellCount]; // [m][n]: m- no. of inputs , n - no. of fields
        for (int i=1; i<=rowCount ; i++) {
        for (int j=0; j<cellCount; j++) {
        data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
        }
        }
        return data;
    }
}
