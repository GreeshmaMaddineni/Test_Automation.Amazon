package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchfunction {
	 WebDriver driver;

	    public Searchfunction(WebDriver driver){
	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }

		@FindBy(id = "twotabsearchtextbox")
		WebElement searchbox;
	
		public WebElement getSearchbox(){
			return searchbox;
		}
	
		@FindBy(xpath = "/html/body/div[1]/div[2]/span/div/span/h1/div/div[1]/div/div")
		WebElement searchinfo;
	
		public WebElement getSearchinfo(){
			return searchinfo;
		}
		
		@FindBy(name = "s")
		WebElement dropdown;
	
		public WebElement getDropdown(){
			return dropdown;
		}

		@FindBy(id = "searchDropdownBox")
		WebElement category;
	
		public WebElement getcategory(){
			return category;
		}

		
		@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[14]/span/div/div/ul/li[7]/a")
       WebElement nextpage;

       public WebElement getNextpage() {
           return nextpage;
       }

       @FindBy(css = "#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(21) > span > div > div > ul > li:nth-child(1) > a")
       WebElement prevpage;

       public WebElement getPrevpage() {
           return prevpage;
       }
       
       @FindBy(id="nav-search-submit-button")
       WebElement Btn_magnifier;
       
       public WebElement getBtn_magnifier() {
    	   return Btn_magnifier;
       }
}
