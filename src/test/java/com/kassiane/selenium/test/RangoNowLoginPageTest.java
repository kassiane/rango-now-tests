package com.kassiane.selenium.test;

import static com.kassiane.selenium.pages.messages.RangoNowLoginPageMessages.INVALID_EMAIL_ADDRESS;
import static com.kassiane.selenium.pages.messages.RangoNowLoginPageMessages.INVALID_PASSWORD;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kassiane.selenium.pages.RangoNowLoginPage;
import com.kassiane.selenium.pages.actions.RangoNowLoginPageActions;
import com.kassiane.selenium.pages.checkers.RangoNowLoginPageCheckers;

@Deprecated
public class RangoNowLoginPageTest {

    private static String rangoNowLoginPageURL = "http://dbserver.rangonow.com.br/#/login";
    private static String rangoNowAccountPageURL = "http://dbserver.rangonow.com.br/#/account";
    private static RangoNowLoginPageActions rangoNowLoginPageActions;
    private static RangoNowLoginPageCheckers rangoNowLoginPageCheckers;
    private static WebDriver driver;

    @BeforeClass
    public static void setEnvironment() {
        // Create a new instance of a driver
        driver = new FirefoxDriver();
        // obtain login page actions
        rangoNowLoginPageCheckers = new RangoNowLoginPageCheckers(driver);
        rangoNowLoginPageActions = new RangoNowLoginPageActions(new RangoNowLoginPage(driver));
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Before
    public void getLoginPage() {
        if (driver.getCurrentUrl().matches(rangoNowLoginPageURL))
            driver.navigate().refresh();

        driver.navigate().to(rangoNowLoginPageURL);
    }

    @After
    public void clearCache() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void goToCreateAccount() {
        rangoNowLoginPageActions.clickOnCreateAccount();

        assertTrue(driver.getCurrentUrl().matches(rangoNowAccountPageURL));
    }

    @Test
    public void testWrongPassword() {
        rangoNowLoginPageActions.sendKeysEmail("test.rangonow@gmail.com").sendKeysPassword("blablabla").submit();

        rangoNowLoginPageCheckers.errorMessageDisplayed(INVALID_PASSWORD);
    }

    @Test
    public void testNotRegisteredEmail() {
        rangoNowLoginPageActions.sendKeysEmail("test.rangonow@gmail.coms").sendKeysPassword("rangonow!").submit();

        rangoNowLoginPageCheckers.errorMessageDisplayed(INVALID_EMAIL_ADDRESS);
    }

    @Test
    public void testWrongEmailFormat() {
        rangoNowLoginPageActions.sendKeysEmail("test").sendKeysPassword("rangonow!").submit();

        rangoNowLoginPageCheckers.errorMessageDisplayed(INVALID_EMAIL_ADDRESS);
    }

    @Test
    public void testLoginSuccess() {
        rangoNowLoginPageActions.sendKeysEmail("test.rangonow@gmail.com").sendKeysPassword("rangonow!").submit();
    }
}
