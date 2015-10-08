package com.kassiane.selenium.pages.actions;

import org.openqa.selenium.WebDriver;
import com.kassiane.selenium.pages.RangoNowLoginPage;

public class RangoNowLoginPageActions {

	private RangoNowLoginPage rangoNowLoginPage;
	
	public RangoNowLoginPageActions(WebDriver driver){
		this.rangoNowLoginPage = new RangoNowLoginPage(driver);
	}
	
	public RangoNowLoginPageActions sendKeysEmail(String email) {
		rangoNowLoginPage.getEmailInput().clear();
		rangoNowLoginPage.getEmailInput().sendKeys(email);
		return this;
	}
	
	public RangoNowLoginPageActions sendKeysPassword(String password) {
		rangoNowLoginPage.getPasswordInput().clear();
		rangoNowLoginPage.getPasswordInput().sendKeys(password);
		return this;
	}
	
	public RangoNowLoginPageActions submit() {
		rangoNowLoginPage.getSignInButton().click();
		return this;
	}
	
	public RangoNowLoginPageActions clickOnCreateAccount() {
		rangoNowLoginPage.getCreateAccountButton().click();
		return this;
	}
	
}
