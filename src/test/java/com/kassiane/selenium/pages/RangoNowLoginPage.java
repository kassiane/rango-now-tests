package com.kassiane.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RangoNowLoginPage {

	@FindBy(name = "email")
	private WebElement emailInput;
	
	@FindBy (name = "password")
	private WebElement passwordInput;

	@FindBy (className = "btn btn-lg btn-primary btn-block top-margin")
	private WebElement signInButton;
	
	@FindBy (className = "btn btn-lg btn-link btn-block")
	private WebElement createAccountButton;
	
	public RangoNowLoginPage(WebDriver driver){
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}
}