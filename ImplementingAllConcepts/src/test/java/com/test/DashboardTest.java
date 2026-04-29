package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utilities.DPforHrm;

public class DashboardTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(DashboardTest.class);

	@Test(priority = 1, dataProvider = "validData", dataProviderClass = DPforHrm.class)
	public void loginvalidTest(String username, String password) {
		objLogin = new LoginPage(getDriver());

		objLogin.login(username, password);
		 log.info("Login attempted with credentials");
		objDashboardPage = new DashboardPage(getDriver());

		String dashboardPageTitle = objDashboardPage.getHomePageText();
		 log.info("Dashboard page title retrieved: " + dashboardPageTitle);
		Assert.assertTrue(dashboardPageTitle.contains("Dashboard"));
		 log.info("loginValidTest PASSED.");

	}

}
