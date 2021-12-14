package com.qa.testscript;

import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.ProductDetailsPage;

public class TC_ProductDetails_001 extends TestBase {
	
	@Test
	public void Details() throws InterruptedException {

		ProductDetailsPage productDetailsOR = new ProductDetailsPage(driver);

		// Pre-requisite : Search for a product and open product page
		String parent = driver.getWindowHandle();
		productDetailsOR.getSearchTextBox().sendKeys("MacBook");
		productDetailsOR.getMagnifierBtn().click();
		productDetailsOR.getProduct().click();

		Thread.sleep(5000);

		Set<String> allwindows = driver.getWindowHandles();

		for (String child : allwindows) {

			if (!parent.equals(child)) {

				// Switching to new window
				driver.switchTo().window(child);

				// TestCase 1
				
				String price = productDetailsOR.getProductPrice().getText();
				System.out.println(price);
				System.out.println("Passed");
				boolean isPriceDisplayed = productDetailsOR.getProductPrice().isDisplayed();
				
				
				if(isPriceDisplayed==true) {
					Reporter.log("Price of produce is displayed properly "+price);
				}else {
					Reporter.log("Price of produce is not displayed properly ");
				}

				// Test Case 2
			
				String productSpecification = productDetailsOR.getProductSpecification().getText();
				boolean isProductSpecificationDesplayed = productDetailsOR.getProductSpecification().isDisplayed();
				
				if(isProductSpecificationDesplayed) {
					Reporter.log("Specification of product is displayed properly "+productSpecification);
				}else {
					Reporter.log("Specification of product is not displayed properly");
				}

				// Test Case 3
				
				String productRating = productDetailsOR.getProductRatings().getText();
				boolean isProductRatingDisplayed = productDetailsOR.getProductRatings().isDisplayed();
				
				
				if(isProductRatingDisplayed) {
					Reporter.log("Rating of a product is displayed properly "+productRating);
				}else {
					Reporter.log("Rating of a product is not displayed properly ");
				}
				
//				if(productRating!= null) {
//					Reporter.log("Rating of a product is displayed properly "+productRating);
//				}

				// Test Case 4
				if(productDetailsOR.getProdImg1().isDisplayed()) {
					Reporter.log("Image of product is displayed properly");
				}else {
					Reporter.log("Image of product is not displayed properly");
				}
				Thread.sleep(2000);

			}

		}

	}
}
