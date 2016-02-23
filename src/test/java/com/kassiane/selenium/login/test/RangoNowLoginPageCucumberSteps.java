package com.kassiane.selenium.login.test;

import static com.kassiane.selenium.pages.messages.RangoNowLoginPageMessages.INVALID_EMAIL_ADDRESS;
import static com.kassiane.selenium.pages.messages.RangoNowLoginPageMessages.INVALID_PASSWORD;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kassiane.selenium.pages.RangoNowLoginPage;
import com.kassiane.selenium.pages.actions.RangoNowLoginPageActions;
import com.kassiane.selenium.pages.checkers.RangoNowLoginPageCheckers;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RangoNowLoginPageCucumberSteps {

    private static String rangoNowLoginPageURL = "http://dbserver.rangonow.com.br/#/login";
    private static String rangoNowAccountPageURL = "http://dbserver.rangonow.com.br/#/account";
    private static RangoNowLoginPageActions rangoNowLoginPageActions;
    private static RangoNowLoginPageCheckers rangoNowLoginPageCheckers;
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        rangoNowLoginPageCheckers = new RangoNowLoginPageCheckers(driver);
        rangoNowLoginPageActions = new RangoNowLoginPageActions(new RangoNowLoginPage(driver));
    }

    @AfterClass
    public static void tierDown() {
        driver.close();
    }

    @After
    public void clearCache() {
        driver.manage().deleteAllCookies();
    }

    @Given("^the Rango Now login page is displayed$")
    public void theRangoNowLoginPageIsDisplayed() {
        if (driver.getCurrentUrl().matches(rangoNowLoginPageURL))
            driver.navigate().refresh();

        driver.navigate().to(rangoNowLoginPageURL);
    }

    @When("^user \"(.*)\" logs in using password \"(.*)\"$")
    public void loginWithUsernameAndPassword(final String username, final String password) {
        rangoNowLoginPageActions.sendKeysEmail(username).sendKeysPassword(password).submit();
    }

    @Then("^the login is successful$")
    public void theLoginIsSuccessful() {
        //
    }

    @Then("^an invalid password error message is displayed$")
    public void invalidPasswordErrorMessageDisplayed() {
        rangoNowLoginPageCheckers.errorMessageDisplayed(INVALID_PASSWORD);
    }

    @Then("^Then an invalid email error message is displayed$")
    public void invalidEmailErrorMessageDisplayed() {
        rangoNowLoginPageCheckers.errorMessageDisplayed(INVALID_EMAIL_ADDRESS);
    }

}
