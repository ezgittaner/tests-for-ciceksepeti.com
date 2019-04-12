package com.ciceksepeti.logInTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciceksepeti.base.TestUtilities;
import com.ciceksepeti.pages.LoginPage;
import com.ciceksepeti.pages.WelcomePageObject;

public class NegativeTest extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		sleep(3000);

		welcomePage.clickCloseLink();
		sleep(1000);
		welcomePage.clickMembershipLink();
		sleep(2000);

		// Click on log in link
		welcomePage.clickMemberLogInLink();

		LoginPage loginPage = new LoginPage(driver, log);
		// execute negative login

		loginPage.negativeLogIn(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}

}
