package com.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testscript.TestBase;


public class CartPages extends TestBase {
	WebDriver Driver;
	@FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement Uname;

    public WebElement getUname(){
        return Uname;
    }
	@FindBy(id="nav-link-accountList")
	WebElement acc;
	public WebElement getacc()
	{
		return acc;
	}
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement num;
	public WebElement getnum()
	{
		return num;
	}
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	WebElement pwd;
	public WebElement getpwd()
	{
		return pwd;
	}
	@FindBy(id="twotabsearchtextbox")
	WebElement searchitem;
	public WebElement getsearchitem()
	{
		return searchitem;
	}
	@FindBy(id="nav-search-submit-button")
	WebElement specifieditem;
	public WebElement getspecifieditem()
	{
		return specifieditem;
	}
	@FindBy(xpath="//span[normalize-space()='OPPO A74 5G (Fluid Black,6GB RAM,128GB Storage) - 5G Android Smartphone | 5000 mAh Battery | 18W Fast Charge | 90Hz LCD Display']")
    WebElement link_item;
    public WebElement getlink_item()
    {
		return link_item;
	}
	@FindBy(id="add-to-cart-button")
	WebElement addtocart;
	public WebElement getaddtocart()
	{
		return addtocart;
	}
	@FindBy(xpath="//span[@id='a-autoid-0-announce']")
	WebElement initial_qnt;
	public WebElement getinitial_qnt()
	{
		return initial_qnt;
	}
	@FindBy(xpath="//a[@id='quantity_2']")
	WebElement changed_qnt;
	public WebElement getchanged_qnt()
	{
		return changed_qnt;
	}
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]")
	WebElement dlt_items;
	public WebElement getdlt_items()
	{
		return dlt_items;
	}
			public CartPages(WebDriver Driver)
	{
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
}

