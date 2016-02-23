package com.kassiane.selenium.pages.actions;

import com.kassiane.selenium.pages.RangoNowLoginPage;

public class RangoNowLoginPageActions {

    private final RangoNowLoginPage rangoNowLoginPage;

    public RangoNowLoginPageActions(final RangoNowLoginPage rangoNowLoginPage) {
        this.rangoNowLoginPage = rangoNowLoginPage;
    }

    public RangoNowLoginPageActions sendKeysEmail(final String email) {
        this.rangoNowLoginPage.getEmailInput().clear();
        this.rangoNowLoginPage.getEmailInput().sendKeys(email);
        return this;
    }

    public RangoNowLoginPageActions sendKeysPassword(final String password) {
        this.rangoNowLoginPage.getPasswordInput().clear();
        this.rangoNowLoginPage.getPasswordInput().sendKeys(password);
        return this;
    }

    public RangoNowLoginPageActions submit() {
        this.rangoNowLoginPage.getSignInButton().click();
        return this;
    }

    public RangoNowLoginPageActions clickOnCreateAccount() {
        this.rangoNowLoginPage.getCreateAccountButton().click();
        return this;
    }

}
