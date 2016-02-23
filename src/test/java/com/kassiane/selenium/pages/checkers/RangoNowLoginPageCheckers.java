package com.kassiane.selenium.pages.checkers;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.kassiane.selenium.pages.messages.RangoNowLoginPageMessages;

public class RangoNowLoginPageCheckers {

    private final WebDriver driver;

    public RangoNowLoginPageCheckers(final WebDriver driver) {
        this.driver = driver;
    }

    public RangoNowLoginPageCheckers errorMessageDisplayed(final RangoNowLoginPageMessages errorMessage) {
        final boolean messageDisplayed = this.driver.getPageSource().contains(errorMessage.toString());
        assertTrue(messageDisplayed);
        return this;
    }
}
