package com.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	
	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver){
		this.driver = driver;

        PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement magnifierBtn;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a")
	WebElement product;
	
	@FindBy(css = "#price > table > tbody > tr:nth-child(1) > td.a-span12.a-color-secondary.a-size-base > span.priceBlockStrikePriceString.a-text-strike")
	WebElement productPrice;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div[3]/div[10]/div[42]/div/div[1]/div/table/tbody")
	WebElement productSpecification;
	
	@FindBy(css = "#reviewsMedley > div > div.a-fixed-left-grid-col.a-col-left > div.a-section.a-spacing-none.a-spacing-top-mini.cr-widget-ACR > div.a-fixed-left-grid.AverageCustomerReviews.a-spacing-small > div > div.a-fixed-left-grid-col.aok-align-center.a-col-right > div > span > span")
	WebElement productRatings;
	
	@FindBy(css =  "#altImages > ul > li:nth-child(6)")
	WebElement prodImg1;

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getMagnifierBtn() {
		return magnifierBtn;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getProductSpecification() {
		return productSpecification;
	}

	public WebElement getProductRatings() {
		return productRatings;
	}

	public WebElement getProdImg1() {
		return prodImg1;
	}


}
