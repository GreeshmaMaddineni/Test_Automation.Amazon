package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPages {

	WebDriver driver;

    public OrdersPages(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id="nav-link-accountList")
    WebElement signin;
   
    public WebElement getsignin()
    {
        return signin;
    }
    
    @FindBy(id="ap_email")
    WebElement mail;
    public WebElement getmail()
    {
        return mail;
    }
    
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement Uname;

    public WebElement getUname(){
        return Uname;
    }
    
    @FindBy(id="ap_password")
    WebElement psw;
    public WebElement getpsw()
    {
        return psw;
    }
    
    @FindBy(id="nav-orders")
    WebElement orders;
    public WebElement getorders()
    {
    	return orders;
    }
  
    @FindBy(id="a-autoid-3-announce")
    WebElement track;
    public WebElement gettrack()
    {
    	return track;
    }
 
    @FindBy(id="Cancel-items_1")
    WebElement cancel;
    public WebElement getcancel()
    {
    	return cancel;
    }
    
    @FindBy(id="cancelButton")
    WebElement cancelbutton;
    public WebElement getcancelbutton()
    {
    	return cancelbutton;
    }
    
    /*@FindBy(className="a-dropdown-prompt")
    WebElement dropdown;
    public WebElement getdropdown()
    {
    	return dropdown;
    }
    
    @FindBy(id="orderFilter_3")
    WebElement options;
    public WebElement getoptions()
    {
    	return options;
    }*/
    
    @FindBy(xpath="//*[@id=\"Write-a-product-review_1\"]")
    WebElement review;
    public WebElement getreview()
    {
    	return review;
    }
    
    
	}
