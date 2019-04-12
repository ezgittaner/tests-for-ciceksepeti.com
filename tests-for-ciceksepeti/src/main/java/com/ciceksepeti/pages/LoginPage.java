package com.ciceksepeti.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

	private By usernameLocator = By.cssSelector("#EmailLogin");
	private By passwordLocator = By.cssSelector("#Password");
	private By logInButtonLocator = By.cssSelector("#userLogin > div.form-group.form-user-login__action > button");
	private By errorMessageLocator = By.cssSelector("#modalBox > div > div > div.modal-body");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void negativeLogIn(String username, String password) {
		log.info("Executing Negative LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
	}

	/** Wait for error message to be visible on the page */
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 5);
	}

	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}

}
