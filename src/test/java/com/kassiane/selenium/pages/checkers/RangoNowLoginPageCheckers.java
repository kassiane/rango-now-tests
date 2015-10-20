package com.kassiane.selenium.pages.checkers;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.kassiane.selenium.pages.messages.RangoNowLoginPageMessages;

public class RangoNowLoginPageCheckers {
	
	public RangoNowLoginPageCheckers errorMessageDisplayed(WebDriver driver,
														   RangoNowLoginPageMessages errorMessage) {
		boolean messageDisplayed = driver.getPageSource().contains(errorMessage.toString());
		assertTrue(messageDisplayed);
		return this;
	}
}
