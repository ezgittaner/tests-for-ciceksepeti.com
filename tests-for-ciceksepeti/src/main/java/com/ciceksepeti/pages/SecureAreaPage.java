package com.ciceksepeti.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	private String pageUrl = "https://www.ciceksepeti.com/Arama?query=ORK%C4%B0DE";

	public String getPageUrl() {
		return pageUrl;
	}

}
