package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	public WebElement dashboardPageTitle;

	//Get the user name of the home page
	public String getHomePageText() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(dashboardPageTitle));
	    return dashboardPageTitle.getText();
	}
}
