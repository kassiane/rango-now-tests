package com.kassiane.selenium.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kassiane.selenium.pages.actions.RangoNowLoginPageActions;

public class RangoNowLoginPageTest {

	private static String rangoNowLoginPageURL = "http://dbserver.rangonow.com.br/#/login";
	private static RangoNowLoginPageActions rangoNowLoginPageActions;
	private static WebDriver driver;
	
	@BeforeClass
	public static void setEnvironment(){
		// Create a new instance of a driver
        driver = new FirefoxDriver();
        // obtain login page actions
        rangoNowLoginPageActions = new RangoNowLoginPageActions(driver);
	}
	
	@AfterClass
	public static void closeDriver(){
		driver.close();
	}
	
	@Before
	public void getLoginPage(){
		driver.get(rangoNowLoginPageURL);
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
	}
	
	@Test
	public void testNotRegisteredEmail(){
		rangoNowLoginPageActions
			.sendKeysEmail("test.rangonow@gmail.coms")
			.sendKeysPassword("rangonow!")
			.submit();
	}
	
	@Test
	public void testWrongEmailFormat(){
		rangoNowLoginPageActions
			.sendKeysEmail("test")
			.sendKeysPassword("rangonow!")
			.submit();
	}
	
	@Test
	public void testLoginSuccess(){
		rangoNowLoginPageActions
			.sendKeysEmail("test.rangonow@gmail.com")
			.sendKeysPassword("rangonow!")
			.submit();
	}
}
