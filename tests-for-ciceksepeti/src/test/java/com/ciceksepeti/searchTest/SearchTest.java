package com.ciceksepeti.searchTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciceksepeti.base.TestUtilities;
import com.ciceksepeti.pages.SecureAreaPage;
import com.ciceksepeti.pages.WelcomePageObject;

public class SearchTest extends TestUtilities {
	@Parameters({ "flowername" })
	@Test
	public void searchTest(String flowername) {
		log.info("Starting SearchTest");
		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		sleep(3000);

		welcomePage.clickCloseLink();
		sleep(1000);

		welcomePage.clicksearchLink();

		welcomePage.searchFlower(flowername);

		SecureAreaPage secureAreaPage = new SecureAreaPage(driver, log);

		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		System.out.println(expectedSuccessMessage);

	}
}