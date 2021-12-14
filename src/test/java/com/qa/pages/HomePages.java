package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePages {

    WebDriver driver;

    public HomePages(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "nav-link-accountList")
    WebElement btn_signin;

    public WebElement getBtn_signin() {
        return btn_signin;
 
    }

    @FindBy(id = "ap_email")
    WebElement txtbx_email;

    public WebElement getTxtbx_email(){
        return txtbx_email;
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement uname;

    public WebElement getUname(){
        return uname;
    }
    @FindBy(id = "ap_password")
    WebElement txtbx_pwd;

    public WebElement getTxtbx_pwd(){
        return txtbx_pwd;
    }

      @FindBy(xpath  = "/html/body/div[1]/div[2]/div[2]/div[2]/div/div[14]/div/div/div[2]/div/ul/li[1]/span/a")
      WebElement Home_product;

      public WebElement getHome_product(){
          return Home_product;
      }


}
