package com.ciceksepeti.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageUrl = "https://www.ciceksepeti.com/";

	// giriş sayfasında tıklanabilecekler buraya yazılacak
	private By membership = By.cssSelector(
			"body > div.header > div.container > div > div.header__right-col > div.user-menu-container.js-user-menu > nav > ul > li:nth-child(2) > a > span.user-menu__icon.user-menu__icon--account.icon-user");
	private By memberLogIn = By.cssSelector(
			"body > div.header > div.container > div > div.header__right-col > div.user-menu-container.js-user-menu > nav > ul > li:nth-child(2) > div > div > ul > li:nth-child(1) > a");
	private By close = By.cssSelector(
			"body > main > div > div.subheader.js-subheader > div.subheader__district.js-district-wrapper.is-active.subheader__district-full > div.subheader-close.js-subheader-close.is-hidden > a > span");
	private By search = By.cssSelector("#product-search-1 > input");
	private By searchButton = By
			.cssSelector("#product-search-1 > button > span.icon.icon-search.product-search__button-icon");

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** click to close advertisement */
	public WelcomePageObject clickCloseLink() {
		log.info("Closing advertisement");
		click(close);
		return new WelcomePageObject(driver, log);
	}

	/** click on Membership Link */
	public WelcomePageObject clickMembershipLink() {
		log.info("Clicking Membership link on Welcome Page");
		click(membership);
		return new WelcomePageObject(driver, log);
	}

	/** click on MemberLogIn Link */
	public WelcomePageObject clickMemberLogInLink() {
		log.info("Clicking Member Log in link on Welcome Page");
		click(memberLogIn);
		return new WelcomePageObject(driver, log);
	}

	/** click on search Link */
	public WelcomePageObject clicksearchLink() {
		log.info("Clicking search link on Welcome Page");
		click(search);
		return new WelcomePageObject(driver, log);
	}

	public void searchFlower(String flowername) {

		type(flowername, search);
		click(searchButton);
	}
}
