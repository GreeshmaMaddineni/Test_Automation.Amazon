package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerServicePage {
	
	WebDriver driver;
	
	public CustomerServicePage(WebDriver driver){
		this.driver = driver;

        PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/div[5]/div[1]/div/div[7]/ul/li[7]/a")
	WebElement Link_help;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[5]/div/div/div[2]/div/div/div[1]/ul/li[12]/a")
	WebElement Btn_customerService;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[5]/div/div/div[2]/div/div/div[13]/div/div/div/ul/li[6]/a/span/span/button")
	WebElement Btn_contactUs;
	
	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div/div/div[2]/div[1]/div/div/div[4]/div/span/span/span/input")
	WebElement Btn_chat;
	
	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/div/div[4]/div/span/span")
	WebElement Btn_callMe;

	@FindBy(id = "nav-link-accountList")
	WebElement btn_signinNav;
	
	@FindBy(id = "ap_email")
	WebElement txtbx_email;
	
	/*
	 * @FindBy(id = "continue") WebElement continuee;
	 */
	
	@FindBy(id = "ap_password")
	WebElement txtbx_pwd;
	
	@FindBy(id = "signInSubmit")
	WebElement signIn;
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement Uname;

    public WebElement getUname(){
        return Uname;
    }
	
	public WebElement getLink_help() {
		return Link_help;
	}

	public WebElement getBtn_CustomerService() {
		return Btn_customerService;
	}

	public WebElement getBtn_ContactUs() {
		return Btn_contactUs;
	}

	public WebElement getBtn_Chat() {
		return Btn_chat;
	}

	public WebElement getBtn_CallMe() {
		return Btn_callMe;
	}

	public WebElement getBtn_SigninNav() {
		return btn_signinNav;
	}

	public WebElement getTxtbx_email() {
		return txtbx_email;
	}

	/*
	 * public WebElement getContinuee() { return continuee; }
	 */

	public WebElement getTxtbx_pwd() {
		return txtbx_pwd;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	
	
	

	
}

