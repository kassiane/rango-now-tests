package com.kassiane.selenium.pages.actions;

import org.openqa.selenium.WebDriver;
import com.kassiane.selenium.pages.RangoNowLoginPage;

public class RangoNowLoginPageActions {

	private RangoNowLoginPage rangoNowLoginPage;
	
	public RangoNowLoginPageActions(WebDriver driver){
		this.rangoNowLoginPage = new RangoNowLoginPage(driver);
	}
	
	public void sendKeysEmail(String email) {
		rangoNowLoginPage.getEmailInput().sendKeys(email);
	}
	
	public void sendKeysPassword(String password) {
		rangoNowLoginPage.getPasswordInput().sendKeys(password);
	}
	
	public void clickOnSignIn() {
		rangoNowLoginPage.getSignInButton().click();
	}
	
	public void clickOnCreateAccount() {
		rangoNowLoginPage.getCreateAccountButton().click();
	}
	
}
