package com.kassiane.selenium.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kassiane.selenium.pages.actions.RangoNowLoginPageActions;
import com.kassiane.selenium.pages.checkers.RangoNowLoginPageCheckers;

import static com.kassiane.selenium.pages.messages.RangoNowLoginPageMessages.*;

public class RangoNowLoginPageTest {

	private static String rangoNowLoginPageURL = "http://dbserver.rangonow.com.br/#/login";
	private static RangoNowLoginPageActions rangoNowLoginPageActions;
	private static RangoNowLoginPageCheckers rangoNowLoginPageCheckers;
	private static WebDriver driver;
	
	@BeforeClass
	public static void setEnvironment(){
		// Create a new instance of a driver
        driver = new FirefoxDriver();
        // obtain login page actions
        rangoNowLoginPageCheckers = new RangoNowLoginPageCheckers();
        rangoNowLoginPageActions = new RangoNowLoginPageActions(driver);
	}
	
	@AfterClass
	public static void closeDriver(){
		driver.close();
	}
	
	@Before
	public void getLoginPage(){
		if (driver.getCurrentUrl().matches(rangoNowLoginPageURL))
			driver.navigate().refresh();
		
		driver.navigate().to(rangoNowLoginPageURL);
	}
	
	@After
	public void clearCache(){
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void goToCreateAccount(){
		rangoNowLoginPageActions.clickOnCreateAccount();
	}

	@Test
	public void testWrongPassword(){
		rangoNowLoginPageActions
			.sendKeysEmail("test.rangonow@gmail.com")
			.sendKeysPassword("blablabla")
			.submit();
		
		rangoNowLoginPageCheckers
			.errorMessageDisplayed(driver, INVALID_PASSWORD);
	}
	
	@Test
	public void testNotRegisteredEmail(){
		rangoNowLoginPageActions
			.sendKeysEmail("test.rangonow@gmail.coms")
			.sendKeysPassword("rangonow!")
			.submit();
		
		rangoNowLoginPageCheckers
			.errorMessageDisplayed(driver, INVALID_EMAIL_ADDRESS);
	}
	
	@Test
	public void testWrongEmailFormat(){
		rangoNowLoginPageActions
			.sendKeysEmail("test")
			.sendKeysPassword("rangonow!")
			.submit();
		
		rangoNowLoginPageCheckers
			.errorMessageDisplayed(driver, INVALID_EMAIL_ADDRESS);
	}
	
	@Test
	public void testLoginSuccess(){
		rangoNowLoginPageActions
			.sendKeysEmail("test.rangonow@gmail.com")
			.sendKeysPassword("rangonow!")
			.submit();
	}
}
