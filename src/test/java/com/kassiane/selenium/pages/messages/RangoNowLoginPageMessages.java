package com.kassiane.selenium.pages.messages;

public enum RangoNowLoginPageMessages {
	INVALID_EMAIL_ADDRESS("Invalid e-mail address."),
	INVALID_PASSWORD("Passwords don't match.");
	
	private String message;
	
	RangoNowLoginPageMessages (final String message) {
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	
	@Override
	public String toString() {
		return this.getMessage();
	}
}
